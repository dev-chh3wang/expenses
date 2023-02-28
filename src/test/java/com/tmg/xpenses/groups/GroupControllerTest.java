package com.tmg.xpenses.groups;

import com.tmg.xpenses.users.User;
import com.tmg.xpenses.users.UserService;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
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
@AutoConfigureMockMvc
class GroupControllerTest {



    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GroupService groupService;
    @MockBean
    private UserService userService;


    @InjectMocks
    GroupController groupController;

    @BeforeEach
    void setUp() {
        //MockitoAnnotations.openMocks(this);
        //this.mockMvc = MockMvcBuilders.standaloneSetup(groupController).build();
    }

    @Test
    void shouldGetGroup() throws Exception {

        Long uuid = 1l;
        User user = new User(1,"John","enail");
        Group group1 = new Group( uuid,"group1",user);
        group1.setId(uuid);
        Optional<Group> group = Optional.of(group1);
        MockHttpServletRequestBuilder req = MockMvcRequestBuilders.get("/api/v1/group/get/"+uuid.toString());

        when(groupService.findById(uuid.intValue())).thenReturn(group);
        when(userService.findById(user.getId().longValue())).thenReturn(Optional.of(user));
        this.mockMvc.perform(req)
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(uuid.toString()))
                .andExpect(jsonPath("$.name").value(group.get().getName().toString()))
                .andExpect(jsonPath("$.createdBy").value(group.get().getCreatedBy().getId()));
    }

    @Test
    void shouldSavegroup() throws Exception {
        Integer uuid = 1;
        User user = new User(1,"John","enail");
        Group group1 = new Group(uuid.longValue(),"group1",user);
        group1.setId(uuid.longValue());
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id",group1.getId().toString());
        jsonObject.put("name",group1.getName().toString());
        jsonObject.put("createdBy",group1.getCreatedBy().getId().toString());

        MockHttpServletRequestBuilder req = MockMvcRequestBuilders.post("/api/v1/group/")
                .content(jsonObject.toString())
                .contentType(MediaType.APPLICATION_JSON);

        when(groupService.save(group1)).thenReturn(group1);
        when(userService.findById(user.getId().longValue())).thenReturn(Optional.of(user));
        this.mockMvc.perform(req)
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(uuid.toString()))
                .andExpect(jsonPath("$.name").value(group1.getName().toString()));

        verify(groupService,times(1)).save(any(Group.class));
        verifyNoMoreInteractions(groupService);
    }

    @Test
    void shouldDeleteGroup() throws Exception {
        Integer uuid = 2;

        MockHttpServletRequestBuilder req = MockMvcRequestBuilders.delete("/api/v1/group/"+uuid)
                .contentType(MediaType.APPLICATION_JSON);

        doNothing().when(groupService).delete(uuid);
        this.mockMvc.perform(req)
                .andExpect(status().isOk());

        verify(groupService,times(1)).delete(uuid);
        verifyNoMoreInteractions(groupService);
    }


    @Test
    void shouldUpdateGroup() throws Exception {
        Integer uuid = 2;
        User user = new User(1,"John","enail");
        Group group1 = new Group(uuid.longValue(),"group1",user);
        User createdBy = new User(1, "John", "meail");
        group1.setCreatedBy(createdBy);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id",group1.getId().toString());
        jsonObject.put("name",group1.getName().toString());
        jsonObject.put("createdBy",group1.getCreatedBy().getId().toString());
        MockHttpServletRequestBuilder req = MockMvcRequestBuilders.put("/api/v1/group/")
                .content(jsonObject.toString())
                .contentType(MediaType.APPLICATION_JSON);

        when(groupService.save(group1)).thenReturn(group1);
        when(userService.findById(user.getId().longValue())).thenReturn(Optional.of(user));
        this.mockMvc.perform(req)
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(uuid.toString()))
                .andExpect(jsonPath("$.name").value(group1.getName().toString()))
                .andExpect(jsonPath("$.createdBy").value(group1.getCreatedBy().getId().toString()));

        verify(groupService,times(1)).save(group1);
        verifyNoMoreInteractions(groupService);
    }
}