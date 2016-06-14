/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

var requirejs = require('requirejs');
requirejs.config({
	baseUrl: 'src/main/js',
	nodeRequire: require,
	paths: {
		'xtext/xtext-test': '../../../src/test/js/xtext/xtext-test',
		'xtext/MockEditorContext': '../../../src/test/js/xtext/MockEditorContext',
		'jquery': '../../../src/test/js/xtext/mock-jquery'
	}
});

suite('Highlighting', function() {
	
	test('should return the highlighting regions sent by the server', function(done) {
		requirejs(['assert', 'xtext/xtext-test'], function(assert, xtext) {
			xtext.testEditor({doneCallback: done})
				.setText('foo')
				.invokeService('highlight')
				.checkRequest(function(url, settings) {
					assert.equal('test://xtext-service/highlight', url);
					assert.equal('GET', settings.type);
				})
				.respond({regions: [{offset: 0, length: 3, styleClasses: ['bar']}]})
				.checkResult(function(editorContext, result) {
					assert.equal('bar', result.regions[0].styleClasses[0]);
					assert.equal(3, result.regions[0].length);
				})
				.done();
		});
	});
	
	test('should send the full text when requested', function(done) {
		requirejs(['assert', 'xtext/xtext-test'], function(assert, xtext) {
			xtext.testEditor({sendFullText: true, doneCallback: done})
				.setText('foo')
				.invokeService('highlight')
				.checkRequest(function(url, settings) {
					assert.equal('test://xtext-service/highlight', url);
					assert.equal('POST', settings.type);
					assert.equal('foo', settings.data.fullText);
				})
				.done();
		});
	});
	
	test('should try again when a conflict occurs', function(done) {
		requirejs(['assert', 'xtext/xtext-test'], function(assert, xtext) {
			xtext.testEditor({doneCallback: done})
				.setText('foo')
				.invokeService('highlight')
				.respond({conflict: 'invalidStateId'})
				.respond({regions: [{offset: 0, length: 3, styleClasses: ['bar']}]})
				.checkResult(function(editorContext, result) {
					assert.equal('bar', result.regions[0].styleClasses[0]);
					assert.equal(3, result.regions[0].length);
				})
				.done();
		});
	});
	
	test('should stop after 10 times', function(done) {
		requirejs(['assert', 'xtext/xtext-test'], function(assert, xtext) {
			var tester = xtext.testEditor({doneCallback: done})
				.setText('foo')
				.invokeService('highlight');
			for (var i = 0; i < 10; i++) {
				tester.checkRequest(function(url, settings) {
						assert.equal('test://xtext-service/highlight', url);
					})
					.respond({conflict: 'invalidStateId'});
			}
			tester.checkError(function(serviceType, severity, message, requestData) {
					assert.equal('highlight', serviceType);
					assert.equal('warning', severity);
				}).done();
		});
	});
	
});
