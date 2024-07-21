package ir.group_3_and_4.controller;

import ir.group_3_and_4.dto.twitt.TwittSaveRequest;
import ir.group_3_and_4.dto.twitt.TwittSaveResponse;
import ir.group_3_and_4.dto.twitt.TwittUpdateRequest;
import ir.group_3_and_4.dto.twitt.TwittUpdateResponse;
import ir.group_3_and_4.dto.user.UserSaveRequest;
import ir.group_3_and_4.dto.user.UserSaveResponse;
import ir.group_3_and_4.dto.user.UserUpdateRequest;
import ir.group_3_and_4.dto.user.UserUpdateResponse;
import ir.group_3_and_4.mapper.TwittMapper;
import ir.group_3_and_4.mapper.UserMapper;
import ir.group_3_and_4.model.Twitt;
import ir.group_3_and_4.model.User;
import ir.group_3_and_4.service.TwittService;
import ir.group_3_and_4.service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
@Validated
public class UserController {
    private final UserService userService;
    private final TwittService twittService;


    @PostMapping("/save")
    public ResponseEntity<UserSaveResponse> saveUser(@RequestBody UserSaveRequest request) {
        User mappedUser = UserMapper.INSTANCE.userSaveRequestToUser(request);
        User savedUser = userService.saveUser(mappedUser);
        return new ResponseEntity<>(UserMapper.INSTANCE.userToUserSaveResponse(savedUser), HttpStatus.CREATED);

    }

    @GetMapping("/display")
    public ResponseEntity<UserSaveResponse> displayAccount(@RequestParam String username){
        User byUserName = userService.findByUserName(username);
        return new ResponseEntity<>(UserMapper.INSTANCE.userToUserSaveResponse(byUserName), HttpStatus.OK);

    }

    @DeleteMapping("/deleteUser")
    public String deleteUser(@RequestParam long userId){
        userService.delete(userId);
        return "user with id :" + userId + "is deleted!";
    }

    @PatchMapping("/updateUser")
    public ResponseEntity<UserUpdateResponse> updateUser(@RequestBody UserUpdateRequest request){
        User mappedUser = UserMapper.INSTANCE.userUpdateRequestToUser(request);
        User updatedUser = userService.updateUser(mappedUser);
        return new ResponseEntity<>(UserMapper.INSTANCE.userToUserUpdateResponse(updatedUser),HttpStatus.OK );
    }

    @PostMapping("/sendTwitt")
    public  ResponseEntity<TwittSaveResponse> sendTwitt(@Valid @RequestBody TwittSaveRequest request,
                                                        @Valid @Min (1) @RequestParam Long userId){
        Twitt mappedTwitt = TwittMapper.INSTANCE.twittSaveRequestToTwitt(request);
        Twitt savedTwitt = twittService.saveTwitt(mappedTwitt,userId);
        return new ResponseEntity<>(TwittMapper.INSTANCE.twittToTwittSaveResponse(savedTwitt), HttpStatus.CREATED );
    }

    @GetMapping("/displayTwitt")
    public ResponseEntity<List<TwittSaveResponse>> displayAllTwitt(@RequestParam Long userId){
        List<Twitt> twitts = twittService.displayAllTwittsByUserId(userId);
        List<TwittSaveResponse> twittSaveResponses = new ArrayList<>();
        for (Twitt twitt : twitts) {
            twittSaveResponses.add(TwittMapper.INSTANCE.twittToTwittSaveResponse(twitt));

        }
        return new ResponseEntity<>(twittSaveResponses,HttpStatus.OK);

    }

    @DeleteMapping("/deleteTwitt")
    public String deleteTwitt(@RequestParam Long twittId){
        twittService.deleteTwitt(twittId);
        return "twitt with id : "+ twittId + " is deleted";
    }

    @PatchMapping("/updatetwitt")
    public ResponseEntity<TwittUpdateResponse> updateTwitt(@RequestBody TwittUpdateRequest request){
        Twitt mappedTwitt = TwittMapper.INSTANCE.twittUpdateRequestToTwitt(request);
        Twitt updateTwitt = twittService.updateTwitt(mappedTwitt);
        return new ResponseEntity<>(TwittMapper.INSTANCE.twittToTwittUpdateResponse(updateTwitt),HttpStatus.OK );

    }




}
