var gulp = require('gulp'), ghtmlSrc = require('gulp-html-src'), debug = require('gulp-debug'), concat = require('gulp-concat'), minify = require('gulp-minify'), change = require('gulp-change'), htmlreplace = require('gulp-html-replace'), rimraf = require('rimraf'), runSequence = require('run-sequence'), uglify = require('gulp-uglify');
var pump = require('pump');

function replaceAll(content) {
	var target = content;

	return target.split('/bower_components').join('../js');
};

gulp.task('compress', function(cb) {
	pump([ gulp.src('index.html'), ghtmlSrc(),concat('compress.js'), minify({
		ext : {
			src : '.js',
			min : '.min.js'
		}
	}), gulp.dest('minify') ], cb);
});

gulp.task('html', function(cb) {
	//remplcer les fichiers par min
});

gulp.task('minify', function() {
	runSequence('compress', 'html');
});