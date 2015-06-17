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
		var deferred = {
			promise: function() {
				var result = {
					done: function(callback) {
						if (deferred.result)
							callback(deferred.result);
						deferred.resolve = callback;
						return result;
					},
					fail: function(callback) {
						if (deferred.error)
							callback(deferred.error);
						deferred.reject = callback;
						return result;
					}
				};
				return result;
			},
			resolve: function(result) {
				deferred.result = result;
			},
			reject: function(error) {
				deferred.error = error;
			}
		};
		return deferred;
	}
	
	function invokeResponseCallbacks(request, response) {
		var xhr = response.xhr ? response.xhr : {};
		if (response.success)
			request.settings.success(response.result);
		else
			request.settings.error(xhr, 'error', response.errorThrown);
		request.settings.complete(xhr, response.success ? 'success' : 'error');
	}
	
	var requests;
	var responses;
	
	function reset() {
		requests = [];
		responses = [];
	}
	
	function respond(result) {
		var response = {success: true, result: result};
		if (requests.length > 0) {
			var request = requests.shift();
			invokeResponseCallbacks(request, response);
		} else
			responses.push(response);
	}
	
	function httpError(errorThrown, xhr) {
		var response = {success: false, errorThrown: errorThrown, xhr: xhr};
		if (requests.length > 0) {
			var request = requests.shift();
			invokeResponseCallbacks(request, response);
		} else
			responses.push(response);
	}
	
	function getNextRequest() {
		return requests[0];
	}
	
	function ajax(url, settings) {
		var request = {url: url, settings: settings};
		if (responses.length > 0) {
			var response = responses.shift();
			invokeResponseCallbacks(request, response);
		} else {
			requests.push(request);
		}
	}
	
	return {
		isFunction: isFunction,
		Deferred: Deferred,
		reset: reset,
		respond: respond,
		httpError: httpError,
		getNextRequest: getNextRequest,
		ajax: ajax
	};
});

