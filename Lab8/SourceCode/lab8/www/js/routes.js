angular.module('app.routes', [])

.config(function($stateProvider, $urlRouterProvider) {

  // Ionic uses AngularUI Router which uses the concept of states
  // Learn more here: https://github.com/angular-ui/ui-router
  // Set up the various states which the app can be in.
  // Each state's controller can be found in controllers.js
  $stateProvider

  //.state('profile', {
//    url: '/login',
  //  templateUrl: 'templates/login.html',
    //controller: 'profileCtrl'
  //})

  .state('login', {
    url: '/login',
    templateUrl: 'templates/login.html',
    controller: 'loginCtrl'
  })
  
  .state('home', {
    url: '/home',
    templateUrl: 'templates/home.html',
    controller: 'homeCtrl'
  })
  
  

  .state('register', {
    url: '/register',
    templateUrl: 'templates/register.html',
    controller: 'registerCtrl'
  })

  .state('plugin', {
    url: '/plugin',
    templateUrl: 'templates/plugins.html',
    controller: 'pluginCtrl'
  })
  
  .state('settings', {
    url: '/settings',
    templateUrl: 'templates/settings.html',
    controller: 'settingsCtrl'
  })

  .state('splash', {
    url: '/splash',
    templateUrl: 'templates/splash.html',
    controller: 'splashCtrl'
  })

  .state('tiles', {
    url: '/tiles',
    templateUrl: 'templates/tiles.html',
    controller: 'tilesCtrl'
  })

$urlRouterProvider.otherwise('/login')

  

});