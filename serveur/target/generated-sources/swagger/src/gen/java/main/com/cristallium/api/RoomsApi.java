package com.cristallium.api;

import com.cristallium.api.dto.Room;
import com.cristallium.api.dto.StatisticalQuestion;
import com.cristallium.api.dto.CompleteQuestion;
import com.cristallium.api.dto.CompleteRoom;
import com.cristallium.api.dto.Question;

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

@Api(value = "rooms", description = "the rooms API")
public interface RoomsApi {

    @ApiOperation(value = "New room", notes = "Creates a new room ", response = Void.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Sucessfully created.", response = Void.class),
        @ApiResponse(code = 400, message = "Bad request.", response = Void.class),
        @ApiResponse(code = 403, message = "Forbidden.", response = Void.class) })
    @RequestMapping(value = "/rooms",
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Void> roomsPost(

@ApiParam(value = "room to be created" ,required=true ) @RequestBody Room room

,
@ApiParam(value = "token to be passed as a header" ,required=true ) @RequestHeader(value="token", required=true) String token


);


    @ApiOperation(value = "deletes a question", notes = "deletes a question of this room", response = Void.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = Void.class),
        @ApiResponse(code = 401, message = "Unauthorized.", response = Void.class),
        @ApiResponse(code = 403, message = "Forbidden.", response = Void.class),
        @ApiResponse(code = 404, message = "Not found.", response = Void.class) })
    @RequestMapping(value = "/rooms/question/{qId}",
        method = RequestMethod.DELETE)
    ResponseEntity<Void> roomsQuestionQIdDelete(
@ApiParam(value = "poll to be deleted",required=true ) @PathVariable("qId") Long qId


,
@ApiParam(value = "token to be passed as a header" ,required=true ) @RequestHeader(value="token", required=true) String token


);


    @ApiOperation(value = "gets a question and its statistics", notes = "gets a question and its statistics a question of this room. This method is public.", response = StatisticalQuestion.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = StatisticalQuestion.class),
        @ApiResponse(code = 404, message = "Not found.", response = StatisticalQuestion.class) })
    @RequestMapping(value = "/rooms/question/{qId}",
        method = RequestMethod.GET)
    ResponseEntity<StatisticalQuestion> roomsQuestionQIdGet(
@ApiParam(value = "question to be retrived",required=true ) @PathVariable("qId") Long qId


);


    @ApiOperation(value = "patch this question", notes = "Update a question in your room. If users are using it, they will be notified instantly via websocket.", response = Void.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK.", response = Void.class),
        @ApiResponse(code = 401, message = "Unauthorized.", response = Void.class),
        @ApiResponse(code = 403, message = "Forbidden.", response = Void.class),
        @ApiResponse(code = 404, message = "Not found.", response = Void.class) })
    @RequestMapping(value = "/rooms/question/{qId}",
        consumes = { "application/json" },
        method = RequestMethod.PATCH)
    ResponseEntity<Void> roomsQuestionQIdPatch(
@ApiParam(value = "the question",required=true ) @PathVariable("qId") Long qId


,

@ApiParam(value = "question to be patched" ,required=true ) @RequestBody CompleteQuestion question

,
@ApiParam(value = "token to be passed as a header" ,required=true ) @RequestHeader(value="token", required=true) String token


);


    @ApiOperation(value = "Deletes this room.", notes = "Deletes this room.", response = Void.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = Void.class),
        @ApiResponse(code = 401, message = "You don't own this room.", response = Void.class),
        @ApiResponse(code = 403, message = "You don't have a token.", response = Void.class),
        @ApiResponse(code = 404, message = "not found.", response = Void.class) })
    @RequestMapping(value = "/rooms/{roomId}",
        method = RequestMethod.DELETE)
    ResponseEntity<Void> roomsRoomIdDelete(
@ApiParam(value = "room to be deleted",required=true ) @PathVariable("roomId") Long roomId


,
@ApiParam(value = "token to be passed as a header" ,required=true ) @RequestHeader(value="token", required=true) String token


);


    @ApiOperation(value = "Gets this room.", notes = "Gets this room. Rooms are visible by all.", response = CompleteRoom.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = CompleteRoom.class),
        @ApiResponse(code = 404, message = "not found.", response = CompleteRoom.class) })
    @RequestMapping(value = "/rooms/{roomId}",
        method = RequestMethod.GET)
    ResponseEntity<CompleteRoom> roomsRoomIdGet(
@ApiParam(value = "room to be get",required=true ) @PathVariable("roomId") Long roomId


);


    @ApiOperation(value = "Patches this room.", notes = "Patches this room.", response = Void.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = Void.class),
        @ApiResponse(code = 401, message = "You don't own this room.", response = Void.class),
        @ApiResponse(code = 403, message = "You don't have a token.", response = Void.class),
        @ApiResponse(code = 404, message = "not found.", response = Void.class) })
    @RequestMapping(value = "/rooms/{roomId}",
        method = RequestMethod.PATCH)
    ResponseEntity<Void> roomsRoomIdPatch(
@ApiParam(value = "room to be modified",required=true ) @PathVariable("roomId") Long roomId


,

@ApiParam(value = "room to be patched" ,required=true ) @RequestBody Room room

,
@ApiParam(value = "token to be passed as a header" ,required=true ) @RequestHeader(value="token", required=true) String token


);


    @ApiOperation(value = "add a question", notes = "adds a question to your poll", response = CompleteQuestion.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "OK", response = CompleteQuestion.class),
        @ApiResponse(code = 401, message = "You don't own this room.", response = CompleteQuestion.class),
        @ApiResponse(code = 403, message = "You don't have a token.", response = CompleteQuestion.class) })
    @RequestMapping(value = "/rooms/{roomId}",
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<CompleteQuestion> roomsRoomIdPost(
@ApiParam(value = "the room",required=true ) @PathVariable("roomId") Long roomId


,

@ApiParam(value = "Question to be added" ,required=true ) @RequestBody Question question

,
@ApiParam(value = "token to be passed as a header" ,required=true ) @RequestHeader(value="token", required=true) String token


);

}
