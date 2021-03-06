var appWish = angular.module("appWish", [ 'ui.router',
		'pascalprecht.translate', 'toaster', 'ngAnimate', 'ui.bootstrap' ]);

appWish.config([
		'$stateProvider',
		'$urlRouterProvider',
		'$translatePartialLoaderProvider',
		'$translateProvider',
		function($stateProvider, $urlRouterProvider,
				$translatePartialLoaderProvider, $translateProvider) {
			// translate i18n

			$translateProvider.useLoader('$translatePartialLoader', {
				urlTemplate : 'app/i18n/{part}/{lang}.json'
			});
			$translatePartialLoaderProvider.addPart('wish');
			$translateProvider.preferredLanguage('FR');
			// routage en utilisant ui-route
			$urlRouterProvider.otherwise('/admin/wish');
			$stateProvider.state('login', {
				url : '/login',
				templateUrl : 'app/templates/login.html',
				controller : 'loginCtrl',

			}).state('admin', {
				url : '/admin',
				abstract : true,
				templateUrl : 'app/templates/admin.html',
				controller : 'adminCtrl',

			}).state('admin.wish', {
				url : '/wish',
				templateUrl : 'app/templates/adminWish.html',
				controller : 'adminWishCtrl',

			})

		} ]);
appWish.run([
		'$rootScope',
		'$location',
		'loginService',
		function($rootScope, $location, loginService) {

			// Redirect to login if route requires auth and you're not logged in
			$rootScope.$on('$stateChangeStart', function(event, toState,
					toParams) {
				
				loginService.isAuth().then(function(data) {
					console.log('ALLOW');
					
				}, function(error) {
					console.log('DENY');
					event.preventDefault();
					$location.path('/login');
				});

			});
		} ]);
