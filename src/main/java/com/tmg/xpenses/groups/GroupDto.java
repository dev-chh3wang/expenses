package com.tmg.xpenses.groups;

public record GroupDto(Long id, String name, Long createdBy) {
    public static GroupDto of(Group grp) {
        return new GroupDto(grp.getId(),grp.getName(),grp.getCreatedBy().getId().longValue());
    }
}
