/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

define(function() {
	
	function isFunction(object) {
		return typeof object == 'function'
	}
	
	function Deferred() {
		var result = {
			promise: function() {
				return {
					done: function(callback) {
						result.resolve = callback;
					},
					fail: function(callback) {
						result.reject = callback;
					}
				};
			},
			resolve: function() {},
			reject: function() {}
		};
		return result;
	}
	
	var mockOptions;
	
	function mockAjax(options) {
		mockOptions = options;
		if (mockOptions.result)
			mockOptions.success = true;
		else if (mockOptions.errorThrown)
			mockOptions.success = false;
	}
	
	function ajax(url, settings) {
		if (isFunction(mockOptions.listener))
			mockOptions.listener(url, settings);
		
		function asyncAjax() {
			var xhr = {};
			if (mockOptions.success)
				settings.success(mockOptions.result);
			else
				settings.error(xhr, 'error', mockOptions.errorThrown);
			settings.complete(xhr, mockOptions.success ? 'success' : 'error');
		}
		if (settings.async)
			setTimeout(asyncAjax, 50);
		else
			asyncAjax();
	}
	
	return {
		isFunction: isFunction,
		Deferred: Deferred,
		mockAjax: mockAjax,
		ajax: ajax
	};
});

