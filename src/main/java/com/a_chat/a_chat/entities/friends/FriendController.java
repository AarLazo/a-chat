package com.a_chat.a_chat.entities.friends;

import com.a_chat.a_chat.entities.friends.model.CreateFriendDTO;
import com.a_chat.a_chat.entities.friends.model.FriendDTO;
import com.a_chat.a_chat.entities.friends.model.UpdateFriendCommand;
import com.a_chat.a_chat.entities.friends.model.enums.FriendState;
import com.a_chat.a_chat.entities.friends.services.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FriendController {
    private final CreateFriendService createFriendService;
    private final GetFriendService getFriendService;
    private final GetAllFriendsService getAllFriendsService;
    private final UpdateFriendStateService updateFriendStateService;
    private final DeleteFriendService deleteFriendService;
    private final GetFriendsByUser getFriendsByUser;

    public FriendController(
            CreateFriendService createFriendService,
            GetFriendService getFriendService,
            GetAllFriendsService getAllFriendsService,
            UpdateFriendStateService updateFriendStateService,
            DeleteFriendService deleteFriendService,
            GetFriendsByUser getFriendsByUser
    ) {
        this.createFriendService = createFriendService;
        this.getFriendService = getFriendService;
        this.getAllFriendsService = getAllFriendsService;
        this.updateFriendStateService = updateFriendStateService;
        this.deleteFriendService = deleteFriendService;
        this.getFriendsByUser = getFriendsByUser;
    }

    //CREATE A FRIEND
    @PostMapping("/friend")
    public ResponseEntity<FriendDTO> createFriend(@RequestBody CreateFriendDTO createFriendDTO){
        return createFriendService.execute(createFriendDTO);
    }

    //READ ALL FRIENDS
    @GetMapping("/friends")
    public ResponseEntity<List<FriendDTO>> getAllFriends (){
        return getAllFriendsService.execute(null);
    }

    //READ A FRIEND BY ID
    @GetMapping("/friend/{friendID}")
    public ResponseEntity<FriendDTO> getFriend(@PathVariable Integer friendID){
        return getFriendService.execute(friendID);
    }

    //READ FRIENDS BY USER
    @GetMapping("/friendsByUser/{friendID}")
    public ResponseEntity<List<FriendDTO>> getFriendsByUser(@PathVariable Integer friendID){
        return getFriendsByUser.execute(friendID);
    }

    //UPDATE A FRIEND STATE
    @PutMapping("/friend/{friendID}")
    public ResponseEntity<FriendDTO> updateFriend(@PathVariable Integer friendID, @RequestBody FriendState state){
        return updateFriendStateService.execute(new UpdateFriendCommand(friendID, state));
    }

    //DELETE A FRIEND
    @DeleteMapping("/friend/{friendID}")
    public ResponseEntity<Void> deleteFriend(@PathVariable Integer friendID){
        return deleteFriendService.execute(friendID);
    }

}
