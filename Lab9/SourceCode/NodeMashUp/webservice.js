
var express = require('express');
var app = express();
var request = require('request');
app.get('/getdata/:food_name', function (req, res) {
    var result={
        'search_details': [],
            };

    /*request('https://www.googleapis.com/customsearch/v1?key=AIzaSyDWuHIysjQ-x98rx9tab4waJ49qcdkcb3I&cx=017576662512468239146:omuauf_lfve&q='+req.params.food_name, function (error,response,body) {
        if (error) {
            return console.log('Error:', error);
        }

        if (response.statusCode !== 200) {
            return console.log('Invalid Status Code Returned:', response.statusCode);
        }
        body = JSON.parse(body);
        var food_values = body.items[0].pagemap.cse_thumbnail[0].src;*/

        request('https://kgsearch.googleapis.com/v1/entities:search?query='+req.params.food_name+'&key=AIzaSyCXJNuYLzvuyRDHgh7zbzPsv071SI555So&limit=1&indent=True', function (error,response,body1) {
            if (error) {
                return console.log('Error:', error);
            }

            if (response.statusCode !== 200) {
                return console.log('Invalid Status Code Returned:', response.statusCode);
            }
            body1 = JSON.parse(body1);
            var fooddescription = body1.itemListElement[0].result;
            result.search_details.push(fooddescription);

            res.contentType('application/json');
            res.header("Access-Control-Allow-Origin", "*");
            res.header("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
            res.write(JSON.stringify(result));
            res.end();
        });


        /*result.search_details.push(food_values);

        res.contentType('application/json');
        res.header("Access-Control-Allow-Origin", "*");
        res.header("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
        res.write(JSON.stringify(food_values));
        res.end();*/

   // });
    console.log(result);
});


var server = app.listen(8081, function () {
    var host = server.address().address;
    var port = server.address().port;

    console.log("Example app listening at http://%s:%s", host, port)
});