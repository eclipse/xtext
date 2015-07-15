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

suite('Content Assist', function() {
	
	test('should return the proposals sent by the server', function(done) {
		requirejs(['assert', 'xtext/xtext-test'], function(assert, xtext) {
			xtext.testEditor({doneCallback: done})
				.setCaretOffset(0)
				.invokeService('assist')
				.checkRequest(function(url, settings) {
					assert.equal('test://xtext-service/assist', url);
					assert.equal('GET', settings.type);
					assert.equal(0, settings.data.caretOffset);
				})
				.respond({entries: [{proposal: 'bar'}]})
				.checkResult(function(editorContext, proposals) {
					assert.equal('bar', proposals[0].proposal);
				})
				.done();
		});
	});
	
	test('should send the full text when requested', function(done) {
		requirejs(['assert', 'xtext/xtext-test'], function(assert, xtext) {
			xtext.testEditor({sendFullText: true, doneCallback: done})
				.setText('foo')
				.setCaretOffset(3)
				.invokeService('assist')
				.checkRequest(function(url, settings) {
					assert.equal('test://xtext-service/assist', url);
					assert.equal('POST', settings.type);
					assert.equal('foo', settings.data.fullText);
					assert.equal(3, settings.data.caretOffset);
				})
				.done();
		});
	});
	
	test('should send a delta text when necessary', function(done) {
		requirejs(['assert', 'xtext/xtext-test'], function(assert, xtext) {
			xtext.testEditor({doneCallback: done})
				.setText('foo')
				.setCaretOffset(3)
				.invokeService('assist')
				.checkRequest(function(url, settings) {
					assert.equal('test://xtext-service/assist', url);
					assert.equal('POST', settings.type);
					assert.equal('foo', settings.data.deltaText);
					assert.equal(3, settings.data.caretOffset);
				})
				.done();
		});
	});
	
	test('should trigger server state listeners after an update', function(done) {
		requirejs(['assert', 'xtext/xtext-test'], function(assert, xtext) {
			xtext.testEditor()
				.setup(function(editorContext) {
					editorContext.addServerStateListener(function() {
						var serverState = editorContext.getServerState();
						assert.equal('1', serverState.stateId);
						assert.equal('foo', serverState.text);
						done();
					});
					editorContext.setText('foo');
				})
				.invokeService('assist')
				.respond({stateId: '1', entries: []});
		});
	});
	
	test('should try again when a conflict occurs', function(done) {
		requirejs(['assert', 'xtext/xtext-test'], function(assert, xtext) {
			xtext.testEditor({doneCallback: done})
				.setText('foo')
				.invokeService('assist')
				.checkRequest(function(url, settings) {
					assert.equal('test://xtext-service/assist', url);
					assert.equal('foo', settings.data.deltaText);
				})
				.respond({conflict: 'invalidStateId'})
				.checkRequest(function(url, settings) {
					assert.equal('test://xtext-service/update', url);
					assert.equal('foo', settings.data.fullText);
				})
				.respond({stateId: '1'})
				.checkRequest(function(url, settings) {
					assert.equal('test://xtext-service/assist', url);
					assert.equal('1', settings.data.requiredStateId);
				})
				.respond({entries: [{proposal: 'bar'}]})
				.checkResult(function(editorContext, proposals) {
					assert.equal('bar', proposals[0].proposal);
				})
				.done();
		});
	});
	
	test('should try again when resource is not found', function(done) {
		requirejs(['assert', 'xtext/xtext-test'], function(assert, xtext) {
			xtext.testEditor({doneCallback: done})
				.setText('foo')
				.invokeService('assist')
				.checkRequest(function(url, settings) {
					assert.equal('test://xtext-service/assist', url);
				})
				.httpError('Resource not found', {status: 404})
				.checkRequest(function(url, settings) {
					assert.equal('test://xtext-service/update', url);
					assert.equal('foo', settings.data.fullText);
				})
				.respond({stateId: '1'})
				.checkRequest(function(url, settings) {
					assert.equal('test://xtext-service/assist', url);
					assert.equal('1', settings.data.requiredStateId);
				})
				.respond({entries: [{proposal: 'bar'}]})
				.checkResult(function(editorContext, proposals) {
					assert.equal('bar', proposals[0].proposal);
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
				.invokeService('assist')
				.respond({stateId: '1'})
				.checkRequest(function(url, settings) {
					assert.equal('test://xtext-service/assist', url);
					assert.equal('1', settings.data.requiredStateId);
				})
				.respond({entries: [{proposal: 'bar'}]})
				.checkResult(function(editorContext, proposals) {
					assert.equal('bar', proposals[0].proposal);
				})
				.done();
		});
	});
	
});
