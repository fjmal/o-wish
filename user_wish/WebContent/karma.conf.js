module.exports = function(config) {
	config
			.set({
				basePath : '',
				frameworks : [ 'jasmine' ],
				files : [
						// vendor files
						'bower_components/angular/angular.js',
						'bower_components/angular-ui-router/release/angular-ui-router.js',
						'bower_components/ui-bootstrap-tpls/ui-bootstrap-tpls.js',
						'bower_components/angular-translate/angular-translate.js',
						'bower_components/angular-translate-loader-partial/angular-translate-loader-partial.js',
						'bower_components/angular-animate/angular-animate.js',
						'bower_components/angular-toastr/dist/angular-toastr.js',
						'app/app.js', 'app/controllers/*.js','app/services/*.js', 'app/tests/*.js' ],
				exclude : [],
				preprocessors : {},
				port : 9876,
				colors : true,
				logLevel : config.LOG_INFO,
				autoWatch : true,
				browsers : [ 'Chrome' ],
				singleRun : true
			});
};