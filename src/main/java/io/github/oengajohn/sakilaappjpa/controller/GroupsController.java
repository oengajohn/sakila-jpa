package io.github.oengajohn.sakilaappjpa.controller;

import io.github.oengajohn.sakilaappjpa.controller.dto.GenericResponse;
import io.github.oengajohn.sakilaappjpa.controller.dto.GroupDto;
import io.github.oengajohn.sakilaappjpa.service.GroupsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("api/group")
@RestController
public class GroupsController {
    private final GroupsService groupsService;

    public GroupsController(GroupsService groupsService) {
        this.groupsService = groupsService;
    }

    @GetMapping("list")
    public GenericResponse<List<GroupDto>> list(){
        return GenericResponse.success(
                groupsService.listGroups()
        );
    }
    @GetMapping("list/{groupId}")
    public GenericResponse<GroupDto> getGroupDetails(@PathVariable("groupId") Integer groupId){
        return GenericResponse.success(
                groupsService.getGroupDetails(groupId)
        );
    }
}
