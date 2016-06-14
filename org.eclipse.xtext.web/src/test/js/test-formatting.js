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

suite('Formatting', function() {
	
	test('should return the formatted document', function(done) {
		requirejs(['assert', 'xtext/xtext-test'], function(assert, xtext) {
			xtext.testEditor({doneCallback: done})
				.setText('f  o  o')
				.invokeService('format')
				.checkRequest(function(url, settings) {
					assert.equal('test://xtext-service/format', url);
					assert.equal('POST', settings.type);
				})
				.respond({stateId: '1', formattedText: 'f o o'})
				.checkResult(function(editorContext, result) {
					assert.equal('1', result.stateId);
					assert.equal('f o o', result.formattedText);
				})
				.done();
		});
	});
	
	test('should send the full text when requested', function(done) {
		requirejs(['assert', 'xtext/xtext-test'], function(assert, xtext) {
			xtext.testEditor({sendFullText: true, doneCallback: done})
				.setText('f  o  o')
				.invokeService('format')
				.checkRequest(function(url, settings) {
					assert.equal('test://xtext-service/format', url);
					assert.equal('POST', settings.type);
					assert.equal('f  o  o', settings.data.fullText);
				})
				.done();
		});
	});
	
	test('should update the known server state', function(done) {
		requirejs(['assert', 'xtext/xtext-test'], function(assert, xtext) {
			xtext.testEditor()
				.setup(function(editorContext) {
					editorContext.addServerStateListener(function() {
						assert.equal('f o o', editorContext.getText());
						var knownServerState = editorContext.getServerState();
						assert.equal('f o o', knownServerState.text);
						assert.equal('1', knownServerState.stateId);
						done();
					});
				})
				.setText('f  o  o')
				.invokeService('format')
				.checkRequest(function(url, settings) {
					assert.equal('test://xtext-service/format', url);
					assert.equal('0', settings.data.requiredStateId);
				})
				.respond({stateId: '1', formattedText: 'f o o'})
		});
	});
	
	test('should wait until pending update completes', function(done) {
		requirejs(['assert', 'xtext/xtext-test'], function(assert, xtext) {
			xtext.testEditor({doneCallback: done})
				.triggerModelChange('foo')
				.checkRequest(function(url, settings) {
					assert.equal('test://xtext-service/update', url);
				})
				.invokeService('format')
				.respond({stateId: '1'})
				.checkRequest(function(url, settings) {
					assert.equal('test://xtext-service/format', url);
					assert.equal('1', settings.data.requiredStateId);
				})
				.respond({stateId: '1', formattedText: 'f o o'})
				.checkResult(function(editorContext, result) {
					assert.equal('f o o', result.formattedText);
				})
				.done();
		});
	});
	
	test('should try again when a conflict occurs with full text', function(done) {
		requirejs(['assert', 'xtext/xtext-test'], function(assert, xtext) {
			xtext.testEditor({sendFullText: true, doneCallback: done})
				.setText('f  o  o')
				.invokeService('format')
				.checkRequest(function(url, settings) {
					assert.equal('test://xtext-service/format', url);
				})
				.respond({conflict: 'invalidStateId'})
				.checkRequest(function(url, settings) {
					assert.equal('test://xtext-service/format', url);
				})
				.done();
		});
	});
	
	test('should try again when a conflict occurs with update', function(done) {
		requirejs(['assert', 'xtext/xtext-test'], function(assert, xtext) {
			xtext.testEditor({doneCallback: done})
				.setText('f  o  o')
				.invokeService('format')
				.checkRequest(function(url, settings) {
					assert.equal('test://xtext-service/format', url);
				})
				.respond({conflict: 'invalidStateId'})
				.checkRequest(function(url, settings) {
					assert.equal('test://xtext-service/update', url);
					assert.equal('f  o  o', settings.data.fullText);
				})
				.respond({stateId: '1'})
				.checkRequest(function(url, settings) {
					assert.equal('test://xtext-service/format', url);
					assert.equal('1', settings.data.requiredStateId);
				})
				.done();
		});
	});
	
	test('should stop after 10 times', function(done) {
		requirejs(['assert', 'xtext/xtext-test'], function(assert, xtext) {
			var tester = xtext.testEditor({sendFullText: true, doneCallback: done})
				.setText('f  o  o')
				.invokeService('format');
			for (var i = 0; i < 10; i++) {
				tester.checkRequest(function(url, settings) {
						assert.equal('test://xtext-service/format', url);
					})
					.respond({conflict: 'invalidStateId'});
			}
			tester.checkError(function(serviceType, severity, message, requestData) {
					assert.equal('format', serviceType);
					assert.equal('warning', severity);
				}).done();
		});
	});
	
});
