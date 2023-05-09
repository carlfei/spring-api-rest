(function() {
    "use strict";
    var app = angular.module('app');

    app.$inject=['$stateProvider'];

    app.config(function($stateProvider) {
        var frontState = {
            name : 'front',
            url : '/front',
            templateUrl : '/view/front',
            controller: 'FrontController as front'
        };
        $stateProvider.state(frontState);
    });

})();