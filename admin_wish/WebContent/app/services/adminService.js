appWish.factory('adminService', [ '$http', '$q', adminService ]);

function adminService($http, $q) {
	var service = {
		addWish : addWish,
		loadWish : loadWish,
		deleteWish:deleteWish

	};
	return service;
	function deleteWish(wish)
	{
		var deferred = $q.defer();
		$http({
			url : baseURL + DELETE_WISH_URL,
			method : 'POST',
			data : wish
		}).success(function(data, status) {
			deferred.resolve(data);

		}).error(function(data, status) {
			deferred.reject(data);

		});
		return deferred.promise;
	}
	function addWish(wish) {
		var deferred = $q.defer();
		$http({
			url : baseURL + ADD_WISH_URL,
			method : 'POST',
			data : wish
		}).success(function(data, status) {
			deferred.resolve(data);

		}).error(function(data, status) {
			deferred.reject(data);

		});
		return deferred.promise;
	}
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