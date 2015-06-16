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
	
	var ajaxOptionsArray;
	
	function mockAjax(options) {
		if (Array.isArray(options))
			ajaxOptionsArray = options;
		else
			ajaxOptionsArray = [options];
	}
	
	var nextResponses = [];
	
	function ajax(url, settings) {
		if (ajaxOptionsArray.length == 0)
			return;
		
		var mockOptions = ajaxOptionsArray.shift();
		if (mockOptions.result)
			mockOptions.success = true;
		else if (mockOptions.errorThrown)
			mockOptions.success = false;
		
		if (isFunction(mockOptions.onStart))
			mockOptions.onStart(url, settings);
		
		function asyncAjax() {
			var xhr = mockOptions.xhr ? mockOptions.xhr : {};
			if (mockOptions.success)
				settings.success(mockOptions.result);
			else
				settings.error(xhr, 'error', mockOptions.errorThrown);
			settings.complete(xhr, mockOptions.success ? 'success' : 'error');
			
			if (isFunction(mockOptions.onComplete))
				mockOptions.onComplete();
		}
		
		if (mockOptions.wait)
			nextResponses.push(asyncAjax);
		else if (settings.async)
			setTimeout(asyncAjax, 20);
		else
			asyncAjax();
	}
	
	function giveNextResponse() {
		var response = nextResponses.shift();
		response();
	}
	
	return {
		isFunction: isFunction,
		Deferred: Deferred,
		mockAjax: mockAjax,
		ajax: ajax,
		giveNextResponse: giveNextResponse
	};
});

