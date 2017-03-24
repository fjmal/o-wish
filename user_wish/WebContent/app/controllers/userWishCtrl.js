appWish.controller('userWishCtrl', [ '$scope', '$rootScope', '$modal',
		'userService','$timeout','toaster', function($scope, $rootScope, $modal, userService,$timeout,toaster) {

			// declaration des objets
			$scope.wishs = [];
			$scope.loadWish = loadWish;
			// init function
			loadWish();
			// Implementation des fonctions
			function loadWish() {
				userService.loadWish().then(function(data) {
					$scope.wishs = data;
				})

			}
			// event
			$scope.$on('new_Wish', function(data) {
					toaster.pop('info', "info", "New Wish Added");
					loadWish();
					
			})
			$scope.$on('delete_Wish', function(data) {
					toaster.pop('info', "info", "Wish Deleted");
					loadWish();
					
			})

		} ])
