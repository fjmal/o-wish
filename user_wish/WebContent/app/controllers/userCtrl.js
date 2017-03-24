appWish.controller('userCtrl', [ '$scope', '$window', '$rootScope', 'toaster','$timeout',
		function($scope, $window, $rootScope, toaster,$timeout) {

			// declaration des objets
			$scope.connectWebSocket = connectWebSocket;
			// init function
			connectWebSocket();

			// Implementation des fonctions
			function connectWebSocket() {
				$rootScope.webSocket = new WebSocket(WEB_SOCKET_URL);

			}
			// Events
			$rootScope.webSocket.onopen = function() {
				toaster.pop('info', "info", "Web Socket connection");
			};

			$rootScope.webSocket.onmessage = function(message) {
				if (message.data === "new Wish") {
					$scope.$broadcast("new_Wish")
				}
				if (message.data === "Wish Deleted") {
					$scope.$broadcast("delete_Wish")
				}
			
			};
			
		} ])
