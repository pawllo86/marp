/**
 * Created by pma on 2016-09-18.
 */
angular.module('authorization', [])
    .directive('authorization', function () {
        return {
            restrict: 'E',
            transclude: true,
            templateUrl: '../template/directive/login.html'
        }
    });