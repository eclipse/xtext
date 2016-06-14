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

suite('Occurrences', function() {
	
	test('should return the occurrences sent by the server', function(done) {
		requirejs(['assert', 'xtext/xtext-test'], function(assert, xtext) {
			xtext.testEditor({doneCallback: done})
				.setText('foo')
				.invokeService('occurrences')
				.checkRequest(function(url, settings) {
					assert.equal('test://xtext-service/occurrences', url);
					assert.equal('GET', settings.type);
				})
				.respond({readRegions: [{offset: 0, length: 3}]})
				.checkResult(function(editorContext, result) {
					assert.equal(3, result.readRegions[0].length);
				})
				.done();
		});
	});
	
	test('should send the full text when requested', function(done) {
		requirejs(['assert', 'xtext/xtext-test'], function(assert, xtext) {
			xtext.testEditor({sendFullText: true, doneCallback: done})
				.setText('foo')
				.invokeService('occurrences')
				.checkRequest(function(url, settings) {
					assert.equal('test://xtext-service/occurrences', url);
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
				.invokeService('occurrences')
				.respond({stateId: '1'})
				.checkRequest(function(url, settings) {
					assert.equal('test://xtext-service/occurrences', url);
					assert.equal('1', settings.data.requiredStateId);
				})
				.respond({readRegions: [{offset: 0, length: 3}]})
				.checkResult(function(editorContext, result) {
					assert.equal(3, result.readRegions[0].length);
				})
				.done();
		});
	});
	
	test('should try again when resource is not found', function(done) {
		requirejs(['assert', 'xtext/xtext-test'], function(assert, xtext) {
			xtext.testEditor({doneCallback: done})
				.setText('foo')
				.invokeService('occurrences')
				.checkRequest(function(url, settings) {
					assert.equal('test://xtext-service/occurrences', url);
				})
				.httpError('Resource not found', {status: 404})
				.checkRequest(function(url, settings) {
					assert.equal('test://xtext-service/update', url);
					assert.equal('foo', settings.data.fullText);
				})
				.respond({stateId: '1'})
				.checkRequest(function(url, settings) {
					assert.equal('test://xtext-service/occurrences', url);
					assert.equal('1', settings.data.requiredStateId);
				})
				.respond({readRegions: [{offset: 0, length: 3}]})
				.checkResult(function(editorContext, result) {
					assert.equal(3, result.readRegions[0].length);
				})
				.done();
		});
	});
	
});
