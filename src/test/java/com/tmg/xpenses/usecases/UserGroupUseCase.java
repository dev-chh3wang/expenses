package com.tmg.xpenses.usecases;

import com.tmg.xpenses.groups.Group;
import com.tmg.xpenses.groups.GroupDto;
import com.tmg.xpenses.groups.GroupService;
import com.tmg.xpenses.users.User;
import com.tmg.xpenses.users.UserController;
import com.tmg.xpenses.users.UserService;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
class UserGroupUseCase {


    @Autowired
    MockMvc mockMvc;

    @InjectMocks
    UserController userController;

    @MockBean
    UserService userService;

    @MockBean
    GroupService groupService;



    @Test
    void userShouldbeAbleToSignUp() throws Exception {

        Integer id = 1;
        User user1 = new User(id, "Jack", "email");
        JSONObject userJson = new JSONObject();
        userJson.put("id",id);
        userJson.put("name",user1.getName());
        userJson.put("email",user1.getEmail());

        when(userService.save(user1)).thenReturn(user1);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/api/v1/user/")
                .content(userJson.toString())
                .contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(user1.getId().toString()))
                .andExpect(jsonPath("$.name").value(user1.getName()))
                .andExpect(jsonPath("$.email").value(user1.getEmail()));

        verify(userService,times(1)).save(user1);
        verifyNoMoreInteractions(userService);

    }

    @Test
    void userShouldBeAbletoCreateAGroup() throws Exception {
        Integer id = 1;
        //given user
        User user1 = new User(id, "Jack", "email");

        // creates a group
        GroupDto group = new GroupDto(2l, "User1Group", user1.getId().longValue());
        Group groupEntity = new Group(group.id(), group.name(), user1);
        JSONObject userGroupJson = new JSONObject();
        userGroupJson.put("id",group.id());
        userGroupJson.put("name",group.name());
        userGroupJson.put("createdBy",group.createdBy());

        //submits a form
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/api/v1/group/")
                .content(userGroupJson.toString())
                .contentType(MediaType.APPLICATION_JSON);


        when(userService.findById(user1.getId().longValue())).thenReturn(Optional.of(user1));
        when(groupService.save(groupEntity)).thenReturn(groupEntity);

        mockMvc.perform(request)
                .andExpect(status().isCreated()) // is user created
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(group.id()))
                .andExpect(jsonPath("$.name").value(group.name()))
                .andExpect(jsonPath("$.createdBy").value(group.createdBy()));



        verify(userService,times(1)).findById(id.longValue());
        verifyNoMoreInteractions(userService);
        verify(groupService,times(1)).save(groupEntity);
        verifyNoMoreInteractions(groupService);
    }

    @Test
    void userShouldBeAbleToInviteOtherUserToAGroup() throws Exception {
        Integer id = 1;
        //given user
        User jack = new User(id, "Jack", "email");

        // owns a group
        GroupDto group = new GroupDto(2l, "HomeGroup", jack.getId().longValue());
        Group groupEntity = new Group(group.id(), group.name(), jack);
        JSONObject userGroupJson = new JSONObject();
        userGroupJson.put("id",group.id());
        userGroupJson.put("name",group.name());
        userGroupJson.put("createdBy",group.createdBy());


        User jane = new User(2, "Jane", "jane@email");
        User sara = new User(3, "Sara", "sara@email");



    }
}
