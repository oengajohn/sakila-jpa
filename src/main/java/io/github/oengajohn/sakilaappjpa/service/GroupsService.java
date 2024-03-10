package io.github.oengajohn.sakilaappjpa.service;

import io.github.oengajohn.sakilaappjpa.controller.dto.GroupDto;

import java.util.List;

public interface GroupsService {
    List<GroupDto> listGroups();

    GroupDto getGroupDetails(Integer groupId);
}
