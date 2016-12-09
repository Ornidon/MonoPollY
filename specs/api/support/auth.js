var apiPrefix = "http://localhost:3000"; //TODO: CHANGER CA
var api = require("supertest-as-promised")(apiPrefix);

function auth(creditentials)
{
    return api
        .post('/auth')
        .set('Content-Type', 'application/json')
        .send(creditentials)
        .then(function(response){
            return response;
        });
}

module.exports = {
    auth: auth
}