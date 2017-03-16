angular.module('app.controllers', [])
  
.controller('profileCtrl', function($scope, $ionicSideMenuDelegate) {
	$scope.toggleLeft = function() {
    	$ionicSideMenuDelegate.toggleLeft();
  	};
})
   
.controller('loginCtrl', function($scope, $rootScope, $state, AuthService) {

	//ionic.Platform.ready(function(){

  	//});

    
    
//  	$scope.login = function() {
  		
//  		console.info('Authentication...');
//  		AuthService.login($scope.email,$scope.password);
//  		
//  		setTimeout(function() {
//			if($scope.token) {
//				console.info('Successfully logged in...');
				
                
//                $state.go('home');
//			}
//		}, 2000);
//                $state.go('home');
//  		
//  	};
    
    $scope.u = {
        email: '',
        password: ''
    };
    
    ionic.Platform.ready(function(){

  	});
    
    $scope.gotoHome = function() {
        
        
        if($scope.u.email==='' || $scope.u.password==='' )
            
            {
                alert("email/password can not be empty");
            }
    
        else
            
            {
                $state.go('home')
            }
    }
	
})
   

.controller('homeCtrl', function($scope,$cordovaAppVersion,$cordovaFlashlight,$cordovaContacts,$ionicPlatform,$cordovaImagePicker,$cordovaClipboard,$cordovaBatteryStatus,$rootScope) {
    
    
// get the app version
$scope.getVersion = function(){
    
    document.addEventListener("deviceready", function () {

    $cordovaAppVersion.getVersionNumber().then(function (version) {
      var appVersion = version;
        alert(version);
    });
  }, false);
      
} 

// flash on plugin
$scope.flashon = function(){
    
    
    $cordovaFlashlight.switchOn()
    .then(
      function (success) { /* success */ },
      function (error) { /* error */ });
}

// flash off plugin
$scope.flashoff = function(){
    
    
   $cordovaFlashlight.switchOff()
    .then(
      function (success) { /* success */ },
      function (error) { /* error */ });
}

$scope.contacts = function(){
    
    var opts = {                                           //search options
      filter : searchTerm,                                 // 'Bob'
      multiple: true,                                      // Yes, return any contact that matches criteria
      fields:  [ 'displayName', 'name' ]                   // These are the fields to search for 'bob'.
//      desiredFields: [id];    //return fields.
    };
    
}


$scope.imagepicker = function(){
    
//    var options = {
//   maximumImagesCount: 10,
//   width: 800,
//   height: 800,
//   quality: 80
//  };
//    
//    $cordovaImagePicker.getPictures(options)
//    .then(function (results) {
//      for (var i = 0; i < results.length; i++) {
//        console.log('Image URI: ' + results[i]);
//      }
//    }, function(error) {
//      // error getting photos
//    });
    
    window.imagePicker.getPictures(
    function(results) {
        for (var i = 0; i < results.length; i++) {
            console.log('Image URI: ' + results[i]);
        }
    }, function (error) {
        console.log('Error: ' + error);
    }, {
        maximumImagesCount: 10,
        width: 800
    }
);
    
            
}


$scope.clipboard = function(){
    
    
}

// battery status
$scope.battery = function(){
    
    $ionicPlatform.ready(function() {
        $rootScope.$on("$cordovaBatteryStatus:status", function(event, args) {
            if(args.isPlugged) {
                alert("In Charging mode, Battery status " + args.level + "%");
            } else {
                alert("Charging removed, Battery status" + args.level + "%");
            }
        });
    });
    
    


}

                              

})

.controller('registerCtrl', function($scope,$cordovaDatePicker) {
    
    $scope.date = function(){
        
        var options = {
    date: new Date(),
    mode: 'date', // or 'time'
    minDate: new Date() - 10000,
    allowOldDates: true,
    allowFutureDates: false,
    doneButtonLabel: 'DONE',
    doneButtonColor: '#F2F3F4',
    cancelButtonLabel: 'CANCEL',
    cancelButtonColor: '#000000'
  };

  document.addEventListener("deviceready", function () {

    $cordovaDatePicker.show(options).then(function(date){
        $scope.displaydate=date;
    });

  }, false);
        
    }

})

.controller('pluginCtrl', function($scope) {

})
.controller('settingsCtrl', function($scope) {

})

.controller('splashCtrl', function($scope, $state) {
	setTimeout(function() {
		$state.go('login');
	}, 2000);
})

.controller('tilesCtrl', function($scope) {

})
 