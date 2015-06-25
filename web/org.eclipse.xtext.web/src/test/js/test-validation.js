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
		requirejs(['assert', 'xtext/xtext-test'], function(assert, xtext) {
			xtext.testEditor({doneCallback: done})
				.setText('foo')
				.invokeService('validation')
				.checkRequest(function(url, settings) {
					assert.equal('test://xtext-service/validation', url);
					assert.equal('GET', settings.type);
				})
				.respond({entries: [{severity: 'error', startOffset: 3}]})
				.checkResult(function(editorContext, issues) {
					assert.equal('error', issues[0].severity);
					assert.equal(3, issues[0].startOffset);
				})
				.done();
		});
	});
	
	test('should send the full text when requested', function(done) {
		requirejs(['assert', 'xtext/xtext-test'], function(assert, xtext) {
			xtext.testEditor({sendFullText: true, doneCallback: done})
				.setText('foo')
				.invokeService('validation')
				.checkRequest(function(url, settings) {
					assert.equal('test://xtext-service/validation', url);
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
				.invokeService('validation')
				.respond({conflict: 'invalidStateId'})
				.respond({entries: [{severity: 'error', startOffset: 3}]})
				.checkResult(function(editorContext, issues) {
					assert.equal('error', issues[0].severity);
					assert.equal(3, issues[0].startOffset);
				})
				.done();
		});
	});
	
});
