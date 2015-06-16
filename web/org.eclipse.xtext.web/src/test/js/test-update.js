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

suite('Update', function() {
	
	test('should update the known server state', function(done) {
		requirejs(['assert', 'jquery', 'xtext/xtext-test'], function(assert, jQuery, xtext) {
			jQuery.mockAjax({
				onStart: function(url, settings) {
					assert.equal('0', settings.data.requiredStateId);
					assert.equal('PUT', settings.type);
				},
				result: {stateId: '1'}
			});
			var editor = xtext.createEditor({enableValidationService: false});
			editor.addServerStateListener(function() {
				var knownServerState = editor.getServerState();
				assert.equal('foo', knownServerState.text);
				assert.equal('1', knownServerState.stateId);
				done();
			});
			editor.triggerModelChange('foo');
		});
	});
	
	test('should send the full text when the server state is unknown', function(done) {
		requirejs(['assert', 'jquery', 'xtext/xtext-test'], function(assert, jQuery, xtext) {
			jQuery.mockAjax({
				onStart: function(url, settings) {
					assert.equal('foo', settings.data.fullText);
					assert.equal('PUT', settings.type);
				},
				result: {stateId: '1'}
			});
			var editor = xtext.createEditor({enableValidationService: false});
			var knownServerState = editor.getServerState();
			editor.addServerStateListener(function() {
				assert.equal('foo', knownServerState.text);
				assert.equal('1', knownServerState.stateId);
				done();
			});
			delete knownServerState.text;
			delete knownServerState.stateId;
			editor.triggerModelChange('foo');
		});
	});
	
	test('should compute a delta from the previous known server state', function(done) {
		requirejs(['assert', 'jquery', 'xtext/xtext-test'], function(assert, jQuery, xtext) {
			var trace = '';
			jQuery.mockAjax([
				{
					onStart: function(url, settings) {
						assert.equal('0', settings.data.requiredStateId);
						assert.equal('Foobar', settings.data.deltaText);
						assert.equal(0, settings.data.deltaOffset);
						assert.equal(0, settings.data.deltaReplaceLength);
						trace += 'a';
					},
					result: {stateId: '1'},
					onComplete: function() {
						editor.triggerModelChange('Foo and Bar');
					}
				}, {
					onStart: function(url, settings) {
						assert.equal('1', settings.data.requiredStateId);
						assert.equal(' and B', settings.data.deltaText);
						assert.equal(3, settings.data.deltaOffset);
						assert.equal(1, settings.data.deltaReplaceLength);
						trace += 'b';
					},
					result: {stateId: '2'},
					onComplete: function() {
						assert.equal('ab', trace);
						done();
					}
				}]);
			var editor = xtext.createEditor({enableValidationService: false});
			editor.triggerModelChange('Foobar');
		});
	});
	
});
