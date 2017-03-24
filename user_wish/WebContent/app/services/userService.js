appWish.factory('userService', [ '$http', '$q', userService ]);

function userService($http, $q) {
	var service = {

		loadWish : loadWish

	};
	return service;

	function loadWish() {
		var deferred = $q.defer();
		$http({
			url : baseURL + LOAD_WISH_URL,
			method : 'GET',
		}).success(function(data, status) {
			deferred.resolve(data);

		}).error(function(data, status) {
			deferred.reject(status);

		});
		return deferred.promise;

	}

}