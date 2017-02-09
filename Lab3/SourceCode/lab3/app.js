/**
 * Created by revan on 2/6/2017.
 */

function checkLoginState() {
    FB.getLoginStatus(function(response) {
        // statusChangeCallback(response);

        window.location="index.html";
    });


}

var app=angular.module('myapp',[]);
app.controller('mycontroller',function ($scope) {
    $scope.onSignIn=function (googleUser) {
        var profile = googleUser.getBasicProfile();
        console.log('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.
        console.log('Name: ' + profile.getName());
        console.log('Image URL: ' + profile.getImageUrl());
        console.log('Email: ' + profile.getEmail()); // This is null if the 'email' scope is not present.
        var id_token = googleUser.getAuthResponse().id_token;
        console.log("ID Token: " + id_token);
    }
});


var x=angular.module('mashup',[])
x.controller('mycont',function ($scope,$http) {
    $scope.searchclick=function () {
        var i = $scope.input;
        var z = i.replace(" ", "+");
        var handler = $http.get("https://kgsearch.googleapis.com/v1/entities:search?query=" + z + "&key=AIzaSyAoVY5oQcNNpJo7SPeIC6c88hD7Ugy6ZeQ&limit=1&indent=True")
        handler.success(function (data) {
            if (data != null) {
                // document.getElementById('out').innerHTML="Search Name:"+data.itemListElement[0].result.name+"</br>"+"Description:"+data.itemListElement[0].result.description+"</br>"+"wiki:"+data.itemListElement[0].result.image.url+"</br>"+"DetailedDescription:"+data.itemListElement[0].result.detailedDescription.articleBody+"</br>"+"Source"+data.itemListElement[0].result.url;
                //document.getElementById('ne').innerHTML="negative"+data.negative;

                //    document.getElementById('out').innerHTML =data.itemListElement[0].result.name;
                $scope.test = {
                    "name": data.itemListElement[0].result.name,
                    "disc": data.itemListElement[0].result.description,
                    "link": data.itemListElement[0].result.image.contentUrl,
                    "detailed": data.itemListElement[0].result.detailedDescription.articleBody,
                    "web": data.itemListElement[0].result.url,
                    "wiki": data.itemListElement[0].result.detailedDescription.url
                }
                document.getElementById('se').style.display = 'block';
            }
        })
        handler.error(function (data) {
            alert("There was some error processing your request. Please try after some time.");
        })

        hand.success(function (res) {
            document.getElementById('trans').innerHTML=res.text[0];
        })
    }

    // $scope.translate=function (y) {
    //     var hand=$http.get("https://translate.yandex.net/api/v1.5/tr.json/translate?key=trnsl.1.1.20170206T054715Z.79fffb75ffe99e6e.ee7075626f5e0a731fc17fee095054467a4c665c&text="+y+"&lang=hi&callback=");
    //     hand.success(function (res)
    //     {
    //         document.getElementById('trans').innerHTML=res.text[0];
    //     })
    //
    // }
    $scope.voice=function (audio) {
        responsiveVoice.speak(audio);
    }
});

function signout() {

    window.location="signout.html"

}

function backtologin() {
    window.location="login.html"
}