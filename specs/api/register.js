var register = require("./support/register.js");
var chai = require("chai");
chai.should();
chai.use(require('chai-things'));

describe("The /register endpoint", function()
{
    it("should make possible to create a new account", itShouldMakeItPossibleToCreateAnAccount);
    it("should refuse to create an account if mandatory fields are not provided", itShouldRefuseToCreateAnAccountIfMandatoryFeildsAreNotProvided);
    it("should refuse to create an account if the password lengthis < 8 password", test3);
    it("should refuse to create an account if the provided username is not available", itShouldRefuseToCreateAnAccountIfProvidedUsernameIsNotAvailable);
    it("return the id of the created account in the location header", itShouldReturnTheIdOfTheCreatedAccount);
});

function itShouldMakeItPossibleToCreateAnAccount()
{
    var payload = register.generateUser();
    return register.register(payload)
        .then(function(response)
        {
            response.should.have.property('status', 201);
            return response;
        });
}

function itShouldRefuseToCreateAnAccountIfMandatoryFeildsAreNotProvided()
{
    var payload = register.generateUser();
    var original = JSON.stringify(payload);

    var wrongPayLoad = [];
    for(var i=0; i<4; i++)
    {
        wrongPayLoad.push(JSON.parse(original));
    }
    delete wrongPayLoad[0].username;
    delete wrongPayLoad[1].firstName;
    delete wrongPayLoad[2].lastName;
    delete wrongPayLoad[3].password;

    var promises = wrongPayLoad.map(p => register.register(p));

    return Promise.all(promises)
        .then(function(responses)
        {
            responses.forEach(r => (r.status.should.equal(422)));
        });
}

function test3()
{
    var payload = register.generateUser();
    payload.password = "1234567";
    return register.register(payload)
        .then(function(response){
            response.status.should.equal(422);
        })
        .then(function(){
            payload.password = "12345678";
            return register.register(payload);
        })
        .then(function (response){
            response.status.should.equal(201);
        });
}

function itShouldRefuseToCreateAnAccountIfProvidedUsernameIsNotAvailable()
{
    var p1 = register.generateUser();
    var p2 = register.generateUser();

    p1.username = p2.username;
    return register.register(p1)
        .then(function(response){
            response.status.should.equal(201);
            return register.register(p2);
        })
        .then(function(response){
            response.status.should.equal(422);
        });
}

function itShouldReturnTheIdOfTheCreatedAccount()
{
    var payload = register.generateUser();
    return register.register(payload)
        .then(function(response){
            response.status.should.equal(201);
            response.headers.should.include.keys("location");
        });
}