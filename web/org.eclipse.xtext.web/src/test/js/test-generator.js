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

suite('Generator', function() {
	
	test('should return the generated document', function(done) {
		requirejs(['assert', 'xtext/xtext-test'], function(assert, xtext) {
			xtext.testEditor({doneCallback: done})
				.invokeService('generate')
				.checkRequest(function(url, settings) {
					assert.equal('test://xtext-service/generate', url);
					assert.equal('GET', settings.type);
				})
				.respond('Foo')
				.checkResult(function(editorContext, result) {
					assert.equal('Foo', result);
				})
				.done();
		});
	});
	
	test('should send the full text when requested', function(done) {
		requirejs(['assert', 'xtext/xtext-test'], function(assert, xtext) {
			xtext.testEditor({sendFullText: true, doneCallback: done})
				.setText('foo')
				.invokeService('generate')
				.checkRequest(function(url, settings) {
					assert.equal('test://xtext-service/generate', url);
					assert.equal('POST', settings.type);
					assert.equal('foo', settings.data.fullText);
				})
				.done();
		});
	});
	
	test('should wait until pending update completes', function(done) {
		requirejs(['assert', 'xtext/xtext-test'], function(assert, xtext) {
			xtext.testEditor({doneCallback: done})
				.triggerModelChange('foo')
				.checkRequest(function(url, settings) {
					assert.equal('test://xtext-service/update', url);
				})
				.invokeService('generate')
				.respond({stateId: '1'})
				.checkRequest(function(url, settings) {
					assert.equal('test://xtext-service/generate', url);
					assert.equal('1', settings.data.requiredStateId);
				})
				.respond('Foo')
				.checkResult(function(editorContext, result) {
					assert.equal('Foo', result);
				})
				.done();
		});
	});
	
	test('should try again when a conflict occurs with full text', function(done) {
		requirejs(['assert', 'xtext/xtext-test'], function(assert, xtext) {
			xtext.testEditor({sendFullText: true, doneCallback: done})
				.setText('foo')
				.invokeService('generate')
				.checkRequest(function(url, settings) {
					assert.equal('test://xtext-service/generate', url);
				})
				.respond({conflict: 'invalidStateId'})
				.checkRequest(function(url, settings) {
					assert.equal('test://xtext-service/generate', url);
				})
				.respond('Foo')
				.checkResult(function(editorContext, result) {
					assert.equal('Foo', result);
				})
				.done();
		});
	});
	
	test('should try again when a conflict occurs with update', function(done) {
		requirejs(['assert', 'xtext/xtext-test'], function(assert, xtext) {
			xtext.testEditor({doneCallback: done})
				.setText('foo')
				.invokeService('generate')
				.checkRequest(function(url, settings) {
					assert.equal('test://xtext-service/generate', url);
				})
				.respond({conflict: 'invalidStateId'})
				.checkRequest(function(url, settings) {
					assert.equal('test://xtext-service/update', url);
					assert.equal('foo', settings.data.fullText);
				})
				.respond({stateId: '1'})
				.checkRequest(function(url, settings) {
					assert.equal('test://xtext-service/generate', url);
					assert.equal('1', settings.data.requiredStateId);
				})
				.done();
		});
	});
	
	test('should stop after 10 times', function(done) {
		requirejs(['assert', 'xtext/xtext-test'], function(assert, xtext) {
			var tester = xtext.testEditor({sendFullText: true, doneCallback: done})
				.setText('foo')
				.invokeService('generate');
			for (var i = 0; i < 10; i++) {
				tester.checkRequest(function(url, settings) {
						assert.equal('test://xtext-service/generate', url);
					})
					.respond({conflict: 'invalidStateId'});
			}
			tester.checkError(function(serviceType, severity, message, requestData) {
					assert.equal('generate', serviceType);
					assert.equal('warning', severity);
				}).done();
		});
	});
	
});
