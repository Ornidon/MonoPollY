package com.cristallium.api;

import com.cristallium.api.dto.CompleteQuestion;

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

@Api(value = "answer", description = "the answer API")
public interface AnswerApi {

    @ApiOperation(value = "Posts an answer .", notes = "Posts an answer for a question. If this question is closed then it is not possible any longer.", response = CompleteQuestion.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK. Returns the question with the correct answer.", response = CompleteQuestion.class),
        @ApiResponse(code = 400, message = "Invalid answer object.", response = CompleteQuestion.class),
        @ApiResponse(code = 403, message = "You don't have a token.", response = CompleteQuestion.class),
        @ApiResponse(code = 404, message = "Question not found.", response = CompleteQuestion.class),
        @ApiResponse(code = 409, message = "You already have submitted an answer.", response = CompleteQuestion.class) })
    @RequestMapping(value = "/answer/{aId}",
        method = RequestMethod.POST)
    ResponseEntity<CompleteQuestion> answerAIdPost(
@ApiParam(value = "the id of the answer",required=true ) @PathVariable("aId") Long aId


,
@ApiParam(value = "token to be passed as a header" ,required=true ) @RequestHeader(value="token", required=true) String token


);

}
