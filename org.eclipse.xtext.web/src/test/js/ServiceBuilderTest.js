/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
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

suite('ServiceBuilder', function() {
	
	test('mergeOptions_01', function(done) {
		requirejs(['assert', 'xtext/ServiceBuilder'], function(assert, ServiceBuilder) {
			var defaultOptions = {
				value: 'Foo'
			};
			var mergedOptions = ServiceBuilder.mergeOptions(null, defaultOptions);
			mergedOptions.value = 'Bar';
			assert.equal('Foo', defaultOptions.value);
			done();
		});
	});
	
});