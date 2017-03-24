appWish.controller('adminWishCtrl', [ '$scope', '$rootScope', '$modal',
		'adminService', 'toaster',
		function($scope, $rootScope, $modal, adminService, toaster) {

			// declaration des objets
			$scope.wishs = [];

			$scope.open = open;
			$scope.loadWish = loadWish;
			$scope.deleteWish = deleteWish;

			// init function

			loadWish();
			// Implementation des fonctions

			function loadWish() {
				adminService.loadWish().then(function(data) {
					$scope.wishs = data;
				})

			}
			function deleteWish(wish) {
				adminService.deleteWish(wish).then(function(data) {
					$rootScope.isMe = true;
					$rootScope.webSocket.send("Wish Deleted");
					toaster.pop('success', "success", "Success deleted Wish");
					loadWish();
				})
			}

			function open() {
				$modal.open({
					controller : 'modalController as modal',
					templateUrl : 'modal.html',
					resolve : {
						wishs : function() {
							return $scope.wishs;
						}
					}
				});
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
			$rootScope.$on('success_added_Wish', function(data) {
				toaster.pop('success', "success", "Success added Wish");
				loadWish();

			})

		} ])
appWish.controller('modalController', [ '$modalInstance', '$rootScope',
		'adminService', 'wishs', '$scope',
		function($modalInstance, $rootScope, adminService, wishs, $scope) {

			this.wishs = wishs;
			this.cancel = cancel;
			this.addWish = addWish;
			this.wish = {
				id : "",
				name : "",
				description : "",
				date : ""
			}

			function cancel() {
				$modalInstance.dismiss();
			}
			function addWish() {
				if (this.wishs.length != 0) {
					this.wish.id = this.wishs[this.wishs.length - 1].id + 1;
				} else {
					this.wish.id = 1;
				}
				adminService.addWish(this.wish).then(function(data) {
					cancel();
					$rootScope.isMe = true;
					$rootScope.webSocket.send("new Wish");
					$rootScope.$emit('success_added_Wish');
				})

			}
		} ])
