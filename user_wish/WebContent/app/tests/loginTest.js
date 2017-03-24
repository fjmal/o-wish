describe('loginTest', function() {

	beforeEach(module('appWish'));

	var loginCtrl, scope;

	beforeEach(inject(function($rootScope, $controller) {
		scope = $rootScope.$new();
		loginCtrl = $controller('loginCtrl', {
			$scope : scope
		});
		
	}));

});
