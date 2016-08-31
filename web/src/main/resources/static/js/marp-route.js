angular.module('appMarp')
    .config(function ($routeProvider, $locationProvider) {
        $routeProvider.when('/', {
            templateUrl: 'template/main.html'
        }).when('/login', {
            templateUrl: 'template/login.html'
        }).when('/product', {
            templateUrl: 'template/product.html'
        });

        $locationProvider.html5Mode(true);

    });