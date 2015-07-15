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
				var pr = {
					done: function(callback) {
						if (deferred._result)
							callback(deferred._result);
						deferred._done = callback;
						return pr;
					},
					fail: function(callback) {
						if (deferred._error)
							callback(deferred.error);
						deferred._fail = callback;
						return pr;
					},
					always: function(callback) {
						if (deferred._result || deferred._error)
							callback();
						deferred._always = callback;
						return pr;
					}
				};
				return pr;
			},
			resolve: function(result) {
				deferred._result = result;
				if (deferred._done)
					deferred._done(result);
				if (deferred._always)
					deferred._always();
			},
			reject: function(error) {
				deferred._error = error;
				if (deferred._fail)
					deferred._fail(error);
				if (deferred._always)
					deferred._always();
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
		if (isFunction(request.settings.complete))
			request.settings.complete(xhr, response.success ? 'success' : 'error');
	}
	
	var requests;
	
	function reset() {
		requests = [];
	}
	
	function respond(result) {
		var response = {success: true, result: result};
		if (requests.length == 0)
			throw new Error('Response without matching request');
		var request = requests.shift();
		invokeResponseCallbacks(request, response);
	}
	
	function httpError(errorThrown, xhr) {
		var response = {success: false, errorThrown: errorThrown, xhr: xhr};
		if (requests.length == 0)
			throw new Error('Response without matching request');
		var request = requests.shift();
		invokeResponseCallbacks(request, response);
	}
	
	function getNextRequest() {
		return requests[0];
	}
	
	function ajax(url, settings) {
		var request = {url: url, settings: settings};
		requests.push(request);
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

