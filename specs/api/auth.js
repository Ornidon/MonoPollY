var register = require("./support/register.js");
var auth = require("./support/auth.js");
var Chance = require("chance");
var chance = new Chance();
var chai = require("chai");
chai.should();
chai.use(require('chai-things'));

describe("The /auth endpoint", function()
{
    it("should allow a user to get a JSON Web Token", itShouldAllowRegisteredUserToGetJsonWebToken);
    it("should refuse to send a JSON Web Token if password is wrong", itShouldRefuseToSendAJSONWebTokenIfPasswordIsWrong);
});

function itShouldAllowRegisteredUserToGetJsonWebToken(){
    var user = register.generateUser();
    var creditentials = {
        username: user.username,
        password: user.password
    }
    return register.register(user)
        .then(function(response){
            return auth.auth(creditentials);
        })
        .then(function(response){
            response.status.should.equal(200);
            return response;
        });
}

function itShouldRefuseToSendAJSONWebTokenIfPasswordIsWrong()
{
    var user = register.generateUser();
    var creditentials = {
        username: user.username,
        password: "correctPassword"
    }
    return register.register(user)
        .then(function(response){
            creditentials.password = "incorrectPassword";
            return auth.auth(creditentials);
        })
        .then(function(response){
            response.status.should.equal(401);
            return response;
        });
}