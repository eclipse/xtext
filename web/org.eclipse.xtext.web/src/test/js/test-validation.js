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

suite('Validation', function() {
	
	test('should display the problem markers sent by the server', function(done) {
		requirejs(['assert', 'jquery', 'xtext/xtext-test'], function(assert, jQuery, xtext) {
			jQuery.mockAjax({
				onStart: function(url, settings) {
					assert.equal('GET', settings.type);
				},
				result: {entries: [{severity: 'error', startOffset: 3}]}
			});
			var editor = xtext.createEditor();
			editor.xtextServiceSuccessListeners.push(function(requestType, result) {
				var markers = editor.getMarkers();
				assert.equal('error', markers[0].severity);
				assert.equal(3, markers[0].startOffset);
				done();
			});
			editor.invokeXtextService('validation');
		});
	});
	
	test('should send the full text when requested', function(done) {
		requirejs(['assert', 'jquery', 'xtext/xtext-test'], function(assert, jQuery, xtext) {
			jQuery.mockAjax({
				onStart: function(url, settings) {
					assert.equal('foo', settings.data.fullText);
					assert.equal('POST', settings.type);
					done();
				},
				result: {entries: []}
			});
			var editor = xtext.createEditor({sendFullText: true});
			editor.setText('foo');
			editor.invokeXtextService('validation');
		});
	});
	
	test('should try again when a conflict occurs', function(done) {
		requirejs(['assert', 'jquery', 'xtext/xtext-test'], function(assert, jQuery, xtext) {
			var trace = '';
			jQuery.mockAjax([
				{
					onStart: function(url, settings) {
						trace += 'a';
					},
					result: {conflict: 'invalidStateId'}
				}, {
					onStart: function(url, settings) {
						trace += 'b';
					},
					result: {entries: [{severity: 'error', startOffset: 3}]}
				}
			]);
			var editor = xtext.createEditor();
			editor.xtextServiceSuccessListeners.push(function(requestType, result) {
				var markers = editor.getMarkers();
				assert.equal('error', markers[0].severity);
				assert.equal(3, markers[0].startOffset);
				assert.equal('ab', trace);
				done();
			});
			editor.invokeXtextService('validation');
		});
	});
	
});
