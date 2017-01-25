package com.cristallium.api;

import com.cristallium.api.dto.User;
import com.cristallium.api.dto.CompleteRoom;

import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-01-25T16:05:49.733+01:00")

@Api(value = "user", description = "the user API")
public interface UserApi {

    @ApiOperation(value = "delete user", notes = "Let a user delete himself ", response = Void.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 204, message = "user deleted successfully.", response = Void.class),
        @ApiResponse(code = 400, message = "invalid token or credentials.", response = Void.class),
        @ApiResponse(code = 403, message = "only you can delete yourself.", response = Void.class) })
    @RequestMapping(value = "/user",
        method = RequestMethod.DELETE)
    ResponseEntity<Void> userDelete(
@ApiParam(value = "token to be passed as a header" ,required=true ) @RequestHeader(value="token", required=true) String token


);


    @ApiOperation(value = "new user", notes = "Creates a new user. Username and password shall not be emtpy. ", response = Void.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Sucessfully created.", response = Void.class),
        @ApiResponse(code = 400, message = "Bad request.", response = Void.class),
        @ApiResponse(code = 409, message = "Already exists.", response = Void.class) })
    @RequestMapping(value = "/user",
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Void> userPost(

@ApiParam(value = "user to be created" ,required=true ) @RequestBody User user

);


    @ApiOperation(value = "Gets your rooms", notes = "retrives a list of your rooms and your subscribed one.", response = CompleteRoom.class, responseContainer = "List", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = CompleteRoom.class),
        @ApiResponse(code = 400, message = "Bad request.", response = CompleteRoom.class),
        @ApiResponse(code = 403, message = "Forbidden.", response = CompleteRoom.class) })
    @RequestMapping(value = "/user/rooms",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<CompleteRoom>> userRoomsGet(
@ApiParam(value = "token to be passed as a header" ,required=true ) @RequestHeader(value="token", required=true) String token


);

}
