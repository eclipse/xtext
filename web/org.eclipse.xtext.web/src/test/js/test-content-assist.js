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

suite('content-assist', function() {
	test('should return the proposals sent by the server', function(done) {
		requirejs(['assert', 'jquery', 'xtext/xtext-test'], function(assert, jQuery, xtext) {
			jQuery.mockAjax({
				result: {entries: [{proposal: 'foo'}]}
			});
			var editorContext = xtext.createEditor();
			editorContext.invokeXtextService('content-assist').done(function(proposals) {
				assert.equal('foo', proposals[0].proposal);
				done();
			});
		});
	});
});
