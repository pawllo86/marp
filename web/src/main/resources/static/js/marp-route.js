angular.module('appMarp').config(function ($routeProvider, $locationProvider) {
    $routeProvider.when('/', {
        templateUrl: '/main'
    }).when('/product', {
        templateUrl: '/product'
    });

    $locationProvider.html5Mode(true);
});