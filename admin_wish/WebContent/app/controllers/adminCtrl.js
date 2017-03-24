appWish.controller('adminCtrl', [ '$scope', '$window', '$rootScope', 'toaster','loginService','$location',
		function($scope, $window, $rootScope, toaster,loginService,$location) {

			// declaration des objets
			$scope.connectWebSocket = connectWebSocket;
			$scope.logout=logout;
			// init function
			connectWebSocket();

			// Implementation des fonctions
			function logout()
			{
				loginService.logout().then(function(){
					
				},function(){
					$location.path('/login');
				});
			}
			function connectWebSocket() {
				$rootScope.webSocket = new WebSocket(WEB_SOCKET_URL);

			}
			// Events
			$rootScope.webSocket.onopen = function() {
				//toaster.pop('info', "info", "Web Socket connection");
			};
			var comp = 0;
			$rootScope.webSocket.onmessage = function(message) {

				if ($rootScope.isMe !== true) {
					if (message.data === "new Wish") {
						$scope.$broadcast("new_Wish")
					}
					if (message.data === "deleted Wish") {
						$scope.$broadcast("delete_Wish")
					}
				}
				comp++;
				if (message.eventPhase == comp) {
					comp = 0;
					$rootScope.isMe = false;
				}

			};
		} ])
