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

suite('Persistence', function() {
	
	test('[load] should return the client text', function(done) {
		requirejs(['assert', 'xtext/xtext-test'], function(assert, xtext) {
			xtext.testEditor({resourceId: 'test.mydsl', doneCallback: done})
				.invokeService('load')
				.checkRequest(function(url, settings) {
					assert.equal('test://xtext-service/load?resource=test.mydsl', url);
					assert.equal('GET', settings.type);
				})
				.respond({fullText: 'foo', dirty: false, stateId: '1'})
				.checkResult(function(editorContext, result) {
					assert.equal('foo', result.fullText);
				})
				.done();
		});
	});
	
	test('[load] should update the client text', function(done) {
		requirejs(['assert', 'xtext/xtext-test'], function(assert, xtext) {
			xtext.testEditor({resourceId: 'test.mydsl'})
				.setup(function(editorContext) {
					editorContext.addServerStateListener(function() {
						assert.equal('foo', editorContext.getText());
						var knownServerState = editorContext.getServerState();
						assert.equal('foo', knownServerState.text);
						assert.equal('1', knownServerState.stateId);
						done();
					});
				})
				.invokeService('load')
				.checkRequest(function(url, settings) {
					assert.equal('test://xtext-service/load?resource=test.mydsl', url);
					assert.equal('GET', settings.type);
				})
				.respond({fullText: 'foo', dirty: false, stateId: '1'});
		});
	});
	
	test('[revert] should return the client text', function(done) {
		requirejs(['assert', 'xtext/xtext-test'], function(assert, xtext) {
			xtext.testEditor({resourceId: 'test.mydsl', doneCallback: done})
				.invokeService('revert')
				.checkRequest(function(url, settings) {
					assert.equal('test://xtext-service/revert?resource=test.mydsl', url);
					assert.equal('POST', settings.type);
				})
				.respond({fullText: 'foo', dirty: false, stateId: '1'})
				.checkResult(function(editorContext, result) {
					assert.equal('foo', result.fullText);
				})
				.done();
		});
	});
	
	test('[revert] should update the client text', function(done) {
		requirejs(['assert', 'xtext/xtext-test'], function(assert, xtext) {
			xtext.testEditor({resourceId: 'test.mydsl'})
				.setup(function(editorContext) {
					editorContext.addServerStateListener(function() {
						assert.equal('foo', editorContext.getText());
						var knownServerState = editorContext.getServerState();
						assert.equal('foo', knownServerState.text);
						assert.equal('1', knownServerState.stateId);
						done();
					});
				})
				.invokeService('revert')
				.checkRequest(function(url, settings) {
					assert.equal('test://xtext-service/revert?resource=test.mydsl', url);
					assert.equal('POST', settings.type);
				})
				.respond({fullText: 'foo', dirty: false, stateId: '1'});
		});
	});
	
	test('[save] should set the editor to clean', function(done) {
		requirejs(['assert', 'xtext/xtext-test'], function(assert, xtext) {
			xtext.testEditor({resourceId: 'test.mydsl', doneCallback: done})
				.setDirty(true)
				.invokeService('save')
				.checkRequest(function(url, settings) {
					assert.equal('test://xtext-service/save?resource=test.mydsl', url);
					assert.equal('POST', settings.type);
				})
				.respond({stateId: '1'})
				.checkResult(function(editorContext) {
					assert(!editorContext.isDirty());
				})
				.done();
		});
	});
	
	test('[save] should send the full text when requested', function(done) {
		requirejs(['assert', 'xtext/xtext-test'], function(assert, xtext) {
			xtext.testEditor({resourceId: 'test.mydsl', sendFullText: true, doneCallback: done})
				.setText('foo')
				.invokeService('save')
				.checkRequest(function(url, settings) {
					assert.equal('test://xtext-service/save?resource=test.mydsl', url);
					assert.equal('foo', settings.data.fullText);
				})
				.done();
		});
	});
	
	test('[save] should try again when a conflict occurs with full text', function(done) {
		requirejs(['assert', 'xtext/xtext-test'], function(assert, xtext) {
			xtext.testEditor({resourceId: 'test.mydsl', sendFullText: true, doneCallback: done})
				.setText('foo')
				.invokeService('save')
				.checkRequest(function(url, settings) {
					assert.equal('test://xtext-service/save?resource=test.mydsl', url);
				})
				.respond({conflict: 'invalidStateId'})
				.checkRequest(function(url, settings) {
					assert.equal('test://xtext-service/save?resource=test.mydsl', url);
				})
				.done();
		});
	});
	
	test('[save] should try again when a conflict occurs with update', function(done) {
		requirejs(['assert', 'xtext/xtext-test'], function(assert, xtext) {
			xtext.testEditor({resourceId: 'test.mydsl', doneCallback: done})
				.setText('foo')
				.invokeService('save')
				.checkRequest(function(url, settings) {
					assert.equal('test://xtext-service/save?resource=test.mydsl', url);
				})
				.respond({conflict: 'invalidStateId'})
				.checkRequest(function(url, settings) {
					assert.equal('test://xtext-service/update?resource=test.mydsl', url);
					assert.equal('foo', settings.data.fullText);
				})
				.respond({stateId: '1'})
				.checkRequest(function(url, settings) {
					assert.equal('test://xtext-service/save?resource=test.mydsl', url);
					assert.equal('1', settings.data.requiredStateId);
				})
				.done();
		});
	});
	
	test('[save] should stop after 10 times', function(done) {
		requirejs(['assert', 'xtext/xtext-test'], function(assert, xtext) {
			var tester = xtext.testEditor({resourceId: 'test.mydsl', sendFullText: true, doneCallback: done})
				.setText('foo')
				.invokeService('save');
			for (var i = 0; i < 10; i++) {
				tester.checkRequest(function(url, settings) {
						assert.equal('test://xtext-service/save?resource=test.mydsl', url);
					})
					.respond({conflict: 'invalidStateId'});
			}
			tester.checkError(function(serviceType, severity, message, requestData) {
					assert.equal('save', serviceType);
					assert.equal('warning', severity);
				}).done();
		});
	});
	
	test('[save] should wait until pending update completes', function(done) {
		requirejs(['assert', 'xtext/xtext-test'], function(assert, xtext) {
			xtext.testEditor({resourceId: 'test.mydsl', doneCallback: done})
				.triggerModelChange('foo')
				.checkRequest(function(url, settings) {
					assert.equal('test://xtext-service/update?resource=test.mydsl', url);
				})
				.invokeService('save')
				.respond({stateId: '1'})
				.checkRequest(function(url, settings) {
					assert.equal('test://xtext-service/save?resource=test.mydsl', url);
					assert.equal('1', settings.data.requiredStateId);
				})
				.done();
		});
	});
	
});
