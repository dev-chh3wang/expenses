package com.tmg.xpenses.users;

public record UserDto(Integer id, String name, String email) {

    public static UserDto of(User saved) {
        return new UserDto(saved.getId(),saved.getName(),saved.getEmail());
    }
}
