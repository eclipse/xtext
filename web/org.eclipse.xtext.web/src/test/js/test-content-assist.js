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

suite('Content-assist', function() {
	
	test('should return the proposals sent by the server', function(done) {
		requirejs(['assert', 'jquery', 'xtext/xtext-test'], function(assert, jQuery, xtext) {
			jQuery.mockAjax({
				onStart: function(url, settings) {
					assert.equal('GET', settings.type);
					assert.equal(0, settings.data.caretOffset);
				},
				result: {entries: [{proposal: 'bar'}]}
			});
			var editor = xtext.createEditor();
			editor.invokeXtextService('content-assist').done(function(proposals) {
				assert.equal('bar', proposals[0].proposal);
				done();
			});
		});
	});
	
	test('should send the full text when requested', function(done) {
		requirejs(['assert', 'jquery', 'xtext/xtext-test'], function(assert, jQuery, xtext) {
			jQuery.mockAjax({
				onStart: function(url, settings) {
					assert.equal('foo', settings.data.fullText);
					assert.equal(3, settings.data.caretOffset);
					assert.equal('POST', settings.type);
					done();
				},
				result: {entries: []}
			});
			var editor = xtext.createEditor({sendFullText: true});
			editor.setText('foo');
			editor.setCaretOffset(3);
			editor.invokeXtextService('content-assist');
		});
	});
	
	test('should send a delta text when necessary', function(done) {
		requirejs(['assert', 'jquery', 'xtext/xtext-test'], function(assert, jQuery, xtext) {
			jQuery.mockAjax({
				onStart: function(url, settings) {
					assert.equal('foo', settings.data.deltaText);
					assert.equal(3, settings.data.caretOffset);
					assert.equal('POST', settings.type);
					done();
				},
				result: {stateId: '1', entries: []}
			});
			var editor = xtext.createEditor();
			editor.setText('foo');
			editor.setCaretOffset(3);
			editor.invokeXtextService('content-assist');
		});
	});
	
	test('should trigger server state listeners after an update', function(done) {
		requirejs(['assert', 'jquery', 'xtext/xtext-test'], function(assert, jQuery, xtext) {
			jQuery.mockAjax({
				result: {stateId: '1', entries: []}
			});
			var editor = xtext.createEditor();
			editor.addServerStateListener(function() {
				var serverState = editor.getServerState();
				assert.equal('1', serverState.stateId);
				assert.equal('foo', serverState.text);
				done();
			})
			editor.setText('foo');
			editor.invokeXtextService('content-assist');
		});
	});
	
	test('should try again when a conflict occurs', function(done) {
		requirejs(['assert', 'jquery', 'xtext/xtext-test'], function(assert, jQuery, xtext) {
			var trace = '';
			jQuery.mockAjax([
				{
					onStart: function(url, settings) {
						assert.equal('foo', settings.data.deltaText);
						trace += 'a';
					},
					result: {conflict: 'invalidStateId'}
				}, {
					onStart: function(url, settings) {
						assert.equal('foo', settings.data.fullText);
						trace += 'b';
					},
					result: {entries: [{proposal: 'bar'}]}
				}
			]);
			var editor = xtext.createEditor();
			editor.setText('foo');
			editor.invokeXtextService('content-assist').done(function(proposals) {
				assert.equal('bar', proposals[0].proposal);
				assert.equal('ab', trace);
				done();
			});
		});
	});
	
	test('should try again when resource is not found', function(done) {
		requirejs(['assert', 'jquery', 'xtext/xtext-test'], function(assert, jQuery, xtext) {
			var trace = '';
			jQuery.mockAjax([
				{
					onStart: function(url, settings) {
						assert.equal('test://xtext-service/content-assist', url);
						trace += 'a';
					},
					errorThrown: 'Resource not found',
					xhr: {status: 404}
				}, {
					onStart: function(url, settings) {
						assert.equal('test://xtext-service/update', url);
						assert.equal('foo', settings.data.fullText);
						trace += 'b';
					},
					result: {stateId: '1'}
				}, {
					onStart: function(url, settings) {
						assert.equal('test://xtext-service/content-assist', url);
						assert.equal('1', settings.data.requiredStateId);
						trace += 'c';
					},
					result: {entries: [{proposal: 'bar'}]}
				}
			]);
			var editor = xtext.createEditor();
			editor.setText('foo');
			editor.invokeXtextService('content-assist').done(function(proposals) {
				assert.equal('bar', proposals[0].proposal);
				assert.equal('abc', trace);
				done();
			});
		});
	});
	
	test('should wait until pending update completes', function(done) {
		requirejs(['assert', 'jquery', 'xtext/xtext-test'], function(assert, jQuery, xtext) {
			var trace = '';
			jQuery.mockAjax([
				{
					onStart: function(url, settings) {
						assert.equal('test://xtext-service/update', url);
						trace += 'a';
					},
					wait: true,
					result: {stateId: '1'}
				}, {
					onStart: function(url, settings) {
						assert.equal('test://xtext-service/content-assist', url);
						assert.equal('1', settings.data.requiredStateId);
						trace += 'c';
					},
					result: {entries: [{proposal: 'bar'}]}
				}
			]);
			var editor = xtext.createEditor();
			editor.triggerModelChange('foo');
			editor.invokeXtextService('content-assist').done(function(proposals) {
				assert.equal('bar', proposals[0].proposal);
				assert.equal('abc', trace);
				done();
			});
			trace += 'b';
			// Respond to the update request, then start the content assist request
			jQuery.giveNextResponse();
		});
	});
	
});
