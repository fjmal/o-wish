appWish.factory('loginService', [ '$http', '$q', loginService ]);

function loginService($http, $q) {
	var service = {
		login : login,
		isAuth : isAuth,
		logout : logout

	};
	return service;
	function login(user) {
		var deferred = $q.defer();
		$http(
				{
					url : baseURL + LOGIN_URL + "?username=" + user.username
							+ "&password=" + user.password,
					method : 'GET',
				}).success(function(data, status) {
			service.isAuth().then(function(data) {
				deferred.resolve(data);
			}, function() {
				service.logout();
				deferred.reject("Unauthorized");
			})

		}).error(function(data, status) {
			deferred.reject("error username and password");

		});
		return deferred.promise;
	}
	function isAuth() {
		var deferred = $q.defer();
		$http({
			url : baseURL + IS_AUTH_URL,
			method : 'GET',
		}).success(function(data, status) {
			deferred.resolve(data);

		}).error(function(data, status) {
			deferred.reject(status);

		});
		return deferred.promise;

	}
	function logout() {
		var deferred = $q.defer();
		$http({
			url : baseURL + LOGOUT_URL,
			method : 'GET',
		}).success(function(data, status) {
			deferred.resolve(data);

		}).error(function(data, status) {
			deferred.reject(status);

		});
		return deferred.promise;

	}
}