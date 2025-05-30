package com.a_chat.a_chat.entities.users;


import com.a_chat.a_chat.entities.users.model.*;
import com.a_chat.a_chat.entities.users.services.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final CreateUserService createUserService;
    private final GetAllUsersService getAllUsersService;
    private final GetUserService getUserService;
    private final UpdateUserService updateUserService;
    private final DeleteUserService deleteUserService;
    private final UpdateUserChatService updateUserChatService;
    private final UpdateUserStateService updateUserStateService;
    private final UpdateUserRoleService updateUserRoleService;


    public UserController(
            CreateUserService createUserService,
            GetAllUsersService getAllUsersService,
            GetUserService getUserService,
            UpdateUserService updateUserService,
            DeleteUserService deleteUserService,
            UpdateUserChatService updateUserChatService,
            UpdateUserStateService updateUserStateService,
            UpdateUserRoleService updateUserRoleService
    ) {
        this.createUserService = createUserService;
        this.getAllUsersService = getAllUsersService;
        this.getUserService = getUserService;
        this.updateUserService = updateUserService;
        this.deleteUserService = deleteUserService;
        this.updateUserChatService = updateUserChatService;
        this.updateUserStateService = updateUserStateService;
        this.updateUserRoleService = updateUserRoleService;
    }


    //CREATE A USER
    @PostMapping("/user")
    public ResponseEntity<UserDTO> createUser(@RequestBody User user){
        return createUserService.execute(user);
    }

    //READ ALL USERS
    @GetMapping("/users")
    public ResponseEntity<List<UserDTO>> getAllUsers(){
        return getAllUsersService.execute(null);
    }

    //READ A USER BY ID
    @GetMapping("/user/{userID}")
    public ResponseEntity<UserDTO> getUser(@PathVariable Integer userID){
        return getUserService.execute(userID);
    }

    //UPDATE A USER
    @PutMapping("/user/{userID}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Integer userID, @RequestBody User user){
        return updateUserService.execute(new UpdateUserCommand(userID, user));
    }

    //UPDATE A USER CHAT
    @PutMapping("/userChat/{userID}")
    public ResponseEntity<UserDTO> updateUserChat(@PathVariable Integer userID, @RequestBody String chat){
        return updateUserChatService.execute(new UpdateUserChatCommand(userID, chat));
    }

    //UPDATE A USER ROLE
    @PutMapping("/userRole/{userID}")
    public ResponseEntity<UserDTO> updateUserRole(@PathVariable Integer userID, @RequestBody String role){
        return updateUserRoleService.execute(new UpdateUserRoleCommand(userID, role));
    }

    //UPDATE A USER STATE
    @PutMapping("/userState/{userID}")
    public ResponseEntity<UserDTO> updateUserState(@PathVariable Integer userID, @RequestBody String state){
        return updateUserStateService.execute(new UpdateUserStateCommand(userID, state));
    }


    //DELETE A USER
    @DeleteMapping("/user/{userID}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer userID){
        return deleteUserService.execute(userID);
    }


}