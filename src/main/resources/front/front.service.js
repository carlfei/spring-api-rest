(function() {
    "use strict";

    angular.module('app').service('FrontService', FrontService);

    FrontService.$inject = ['$q','$http'];

    function FrontService($q, $http) {

        var service = {
            save: save,
            getById: getById,
            getAll: getAll,
            deleteById: deleteById,
            deleteAll: deleteAll,
            count: count 
         };
        return service;

        function save(curso) {
            var deferred = $q.defer();
            var call = $http({
                url: '/api/curso',
                method: 'POST',
                data: curso,
		        params: {
		        }
            }).then(function(response) {
                deferred.resolve(response);
            }, function(response) {
                deferred.reject(null);
            });
            return deferred.promise;
        }

        function getById(id) {
            var deferred = $q.defer();
            var call = $http({
                url: '/api/curso/'+id+'',
                method: 'GET',
		        params: {
		        }
            }).then(function(response) {
                deferred.resolve(response);
            }, function(response) {
                deferred.reject(null);
            });
            return deferred.promise;
        }

        function getAll() {
            var deferred = $q.defer();
            var call = $http({
                url: '/api/curso',
                method: 'GET',
		        params: {
		        }
            }).then(function(response) {
                deferred.resolve(response);
            }, function(response) {
                deferred.reject(null);
            });
            return deferred.promise;
        }

        function deleteById(id) {
            var deferred = $q.defer();
            var call = $http({
                url: '/api/curso/'+id+'',
                method: 'DELETE',
		        params: {
		        }
            }).then(function(response) {
                deferred.resolve(response);
            }, function(response) {
                deferred.reject(null);
            });
            return deferred.promise;
        }

        function deleteAll() {
            var deferred = $q.defer();
            var call = $http({
                url: '/api/curso',
                method: 'DELETE',
		        params: {
		        }
            }).then(function(response) {
                deferred.resolve(response);
            }, function(response) {
                deferred.reject(null);
            });
            return deferred.promise;
        }

        function count() {
            var deferred = $q.defer();
            var call = $http({
                url: '/api/curso/count',
                method: 'GET',
		        params: {
		        }
            }).then(function(response) {
                deferred.resolve(response);
            }, function(response) {
                deferred.reject(null);
            });
            return deferred.promise;
        }
    }

})();
