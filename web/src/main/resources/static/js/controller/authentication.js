/**
 * Created by User on 2016-09-07.
 */
'use strict';

angular.module('appMarp').controller('AuthenticationController', function ($rootScope, $http, $location) {
    var self = this;

    self.credentials = {};

    var authenticate = function (credentials, callback) {
        var headers = credentials ? {
            authorization : "Basic " + btoa(credentials.username + ":" + credentials.password)
        } : {};

        $http.get('user', {headers : headers}).then(
            function (response) {
                if (response.data.name) {
                    $rootScope.authenticated = true;
                } else {
                    $rootScope.authenticated = false;
                }
                callback && callback();
            },
            function (response) {
                $rootScope.authenticated = false;
                callback && callback();
            }
        );
    };
    authenticate();

    self.login = function() {
        authenticate(self.credentials, function () {
            if ($rootScope.authenticated) {
                $location.path('/');
                self.error = false;
            } else {
                $location.path('/login');
                self.error = true;
            }
        })
    }

    self.logout = function () {
        $http.post('/logout', {}).then(function () {
            $rootScope.authenticated = false;
            $location.path('/');
        });
    }

});