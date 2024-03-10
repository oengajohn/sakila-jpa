package io.github.oengajohn.sakilaappjpa.controller;

import io.github.oengajohn.sakilaappjpa.controller.dto.ActorDto;
import io.github.oengajohn.sakilaappjpa.controller.dto.GenericResponse;
import io.github.oengajohn.sakilaappjpa.service.ActorService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/actor")
public class ActorController {

    private final ActorService actorService;

    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @PostMapping("saveOrUpdate")
    public GenericResponse<List<ActorDto>> saveOrUpdate(@RequestBody List<ActorDto> actorDtoList){
        return GenericResponse.success(
                actorService.saveOrUpdate(actorDtoList)
        );
    }
    @DeleteMapping("destroy")
    public GenericResponse<?> destroy(@RequestBody List<ActorDto> actorDtoList){
        actorService.destroy(actorDtoList);

        return GenericResponse.success(
        );
    }

    @GetMapping("list")
    public GenericResponse<List<ActorDto>> list(){
        return GenericResponse.success(
                actorService.listActors()
        );
    }
    @GetMapping("searchActors")
    public GenericResponse<List<ActorDto>> searchActors(  @RequestParam( value = "start", defaultValue = "0") int start,
                                                          @RequestParam( value = "limit", defaultValue = "10") int limit,
                                                          @RequestParam( value = "query",required = false) String query){
        Page<ActorDto> actorDtoPage = actorService.searchActors(start, limit, query);
        return GenericResponse.success(
                actorDtoPage.getContent(),
                actorDtoPage.getTotalElements()
        );
    }
}
