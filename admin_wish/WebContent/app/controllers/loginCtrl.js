appWish.controller('loginCtrl',
		[
				'$scope',
				'$window',
				'loginService',
				'$location',
				'toaster',
				'$rootScope',
				function($scope, $window, loginService, $location, toaster,
						$rootScope) {
					// declaration des objets
					$scope.user = {
						username : "",
						password : ""
					};
					$scope.login = login;
					$scope.greeting = 'Hello World!';

					// Implementation des fonctions
					function login() {
						if ($scope.user.username != ""
								&& $scope.user.password != "") {
							loginService.login($scope.user).then(function() {
								toaster.pop('success', "success", "OK");
								/** Connect To web socket* */

								$location.path(WISH_ROUTE_URL);
							}, function(data) {
								toaster.pop('error', "error", data);
							});

						}

					}

				} ])
