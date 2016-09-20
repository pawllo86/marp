angular.module('appMarp')
    .config(function ($routeProvider, $locationProvider, $httpProvider) {
        $routeProvider.when('/', {
            templateUrl: 'template/main.html'
        }).when('/login', {
            templateUrl: 'template/login.html',
            controller: 'AuthenticationController',
            controllerAs: 'authCtrl'
        }).when('/product', {
            templateUrl: 'template/product.html'
        });
        $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';

        $locationProvider.html5Mode(true);
    });