package io.github.oengajohn.sakilaappjpa.service.impl;

import io.github.oengajohn.sakilaappjpa.component.DtoMapper;
import io.github.oengajohn.sakilaappjpa.controller.dto.GroupDto;
import io.github.oengajohn.sakilaappjpa.repository.GroupRepository;
import io.github.oengajohn.sakilaappjpa.service.GroupsService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupsServiceImpl implements GroupsService {
    private final GroupRepository groupRepository;

    public GroupsServiceImpl(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public List<GroupDto> listGroups() {
        return groupRepository.findAll().stream().map(DtoMapper::mapToGroupDto).toList();
        
    }

    @Override
    public GroupDto getGroupDetails(Integer groupId) {
        return groupRepository.findById(groupId).map(DtoMapper::mapToGroupDto).orElseThrow(()->new EntityNotFoundException("Group with supplied is not found."));
    }

}
