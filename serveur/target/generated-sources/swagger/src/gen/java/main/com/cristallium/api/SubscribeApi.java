package com.cristallium.api;


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

@Api(value = "subscribe", description = "the subscribe API")
public interface SubscribeApi {

    @ApiOperation(value = "Add yourself to a room.", notes = "Suscribes you to a room. Grants you the rights to post answers to the questions of this room.", response = Void.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK - you have joined this room.", response = Void.class),
        @ApiResponse(code = 403, message = "You don't have a token.", response = Void.class),
        @ApiResponse(code = 404, message = "Room not found.", response = Void.class),
        @ApiResponse(code = 409, message = "You are already subscribed to this room.", response = Void.class) })
    @RequestMapping(value = "/subscribe/{roomName}",
        method = RequestMethod.POST)
    ResponseEntity<Void> subscribeRoomNamePost(
@ApiParam(value = "the room to join.",required=true ) @PathVariable("roomName") String roomName


,
@ApiParam(value = "token to be passed as a header" ,required=true ) @RequestHeader(value="token", required=true) String token


);

}
