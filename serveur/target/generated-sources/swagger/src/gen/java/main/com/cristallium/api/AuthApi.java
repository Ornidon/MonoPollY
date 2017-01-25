package com.cristallium.api;

import com.cristallium.api.dto.User;
import com.cristallium.api.dto.Token;

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

@Api(value = "auth", description = "the auth API")
public interface AuthApi {

    @ApiOperation(value = "Authenticate", notes = "Authenticate a user ", response = Token.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Authentication sucessfull.", response = Token.class),
        @ApiResponse(code = 400, message = "Bad request.", response = Token.class),
        @ApiResponse(code = 401, message = "Bad credentials.", response = Token.class) })
    @RequestMapping(value = "/auth",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Token> authPost(

@ApiParam(value = "user to be connected" ,required=true ) @RequestBody User user

);

}
