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
		requirejs(['assert', 'xtext/xtext-test'], function(assert, xtext) {
			xtext.testEditor({enableValidationService: false})
				.setup(function(editorContext) {
					editorContext.addServerStateListener(function() {
						var knownServerState = editorContext.getServerState();
						assert.equal('foo', knownServerState.text);
						assert.equal('1', knownServerState.stateId);
						done();
					});
				})
				.triggerModelChange('foo')
				.checkRequest(function(url, settings) {
					assert.equal('PUT', settings.type);
					assert.equal('0', settings.data.requiredStateId);
				})
				.respond({stateId: '1'});
		});
	});
	
	test('should send the full text when the server state is unknown', function(done) {
		requirejs(['assert', 'xtext/xtext-test'], function(assert, xtext) {
			xtext.testEditor({enableValidationService: false})
				.setup(function(editorContext) {
					var knownServerState = editorContext.getServerState();
					editorContext.addServerStateListener(function() {
						assert.equal('foo', knownServerState.text);
						assert.equal('1', knownServerState.stateId);
						done();
					});
					delete knownServerState.text;
					delete knownServerState.stateId;
				})
				.triggerModelChange('foo')
				.checkRequest(function(url, settings) {
					assert.equal('PUT', settings.type);
					assert.equal('foo', settings.data.fullText);
				})
				.respond({stateId: '1'});
		});
	});
	
	test('should compute a delta from the previous known server state', function(done) {
		requirejs(['assert', 'xtext/xtext-test'], function(assert, xtext) {
			xtext.testEditor({enableValidationService: false, doneCallback: done})
				.triggerModelChange('Foobar')
				.checkRequest(function(url, settings) {
					assert.equal('0', settings.data.requiredStateId);
					assert.equal('Foobar', settings.data.deltaText);
					assert.equal(0, settings.data.deltaOffset);
					assert.equal(0, settings.data.deltaReplaceLength);
				})
				.respond({stateId: '1'})
				.triggerModelChange('Foo and Bar')
				.checkRequest(function(url, settings) {
					assert.equal('1', settings.data.requiredStateId);
					assert.equal(' and B', settings.data.deltaText);
					assert.equal(3, settings.data.deltaOffset);
					assert.equal(1, settings.data.deltaReplaceLength);
				})
				.respond({stateId: '2'})
				.done();
		});
	});
	
});
