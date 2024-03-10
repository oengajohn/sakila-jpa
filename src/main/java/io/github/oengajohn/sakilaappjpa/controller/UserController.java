package io.github.oengajohn.sakilaappjpa.controller;

import io.github.oengajohn.sakilaappjpa.controller.dto.GenericResponse;
import io.github.oengajohn.sakilaappjpa.controller.dto.UserDto;
import io.github.oengajohn.sakilaappjpa.service.FileService;
import io.github.oengajohn.sakilaappjpa.service.UserService;
import io.github.oengajohn.sakilaappjpa.constants.Constants;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RequestMapping("api/user")
@RestController
public class UserController {
    private final UserService userService;
    private final FileService fileService;

    public UserController(UserService userService, FileService fileService) {
        this.userService = userService;
        this.fileService = fileService;
    }

    @GetMapping("list")
    public GenericResponse<List<UserDto>> list(@RequestParam(value = "group", required = false) Integer groupId) {
        return GenericResponse.success(
                userService.listUsers(groupId)
        );
    }

    @GetMapping("list/{userId}")
    public GenericResponse<UserDto> getUser(@PathVariable("userId") Integer userId) {
        return GenericResponse.success(
                userService.getUser(userId)
        );
    }


    @PostMapping(value = "saveOrUpdate")
    public GenericResponse<UserDto> save(@RequestParam(value = "id", required = false) Integer id,
                                         @RequestParam("username") String username,
                                         @RequestParam("name") String name,
                                         @RequestParam("email") String email,
                                         @RequestParam("groupId") Integer groupId,
                                         @RequestParam("picture") MultipartFile picture) throws IOException {
        String filePath = null;
        if (picture != null && !picture.isEmpty()) {
            filePath = fileService.saveDataToDatabaseWithFilePath(username, picture);
        }
        System.out.println("filePath = " + filePath);
        UserDto userDto = UserDto.builder()
                .id(id)
                .username(username)
                .name(name)
                .email(email)
                .groupId(groupId)
                .picture(filePath)
                .build();

        return GenericResponse.success(userService.createUser(userDto));

    }

    @GetMapping("image/{picture:.+}")
    public ResponseEntity<Resource> serveImage(@PathVariable String picture) throws MalformedURLException {

        String userHome = System.getProperty("user.home");
        String uploadPath = userHome + Constants.FILE_SEPARATOR + Constants.UPLOAD_DIR;
        Path filePath = Paths.get(uploadPath + Constants.FILE_SEPARATOR + picture);
        Resource resource = new UrlResource(filePath.toUri());
        if (resource.exists() && resource.isReadable()) {
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_TYPE, MediaType.IMAGE_JPEG_VALUE)
                    .body(resource);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("destroy/{userId}")
    public GenericResponse<?> destroy(@PathVariable("userId") Integer id, @RequestBody(required = false) UserDto userDto) {
        userService.deleteUser(id, userDto);
        return GenericResponse.success();
    }
}
