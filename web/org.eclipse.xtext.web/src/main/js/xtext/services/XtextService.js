/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

define(['jquery'], function(jQuery) {
	
	/**
	 * Generic service implementation that can serve as superclass for specialized services.
	 */
	function XtextService() {};

	XtextService.prototype = {
		
		/**
		 * Initialize the request metadata for this service class.
		 */
		initialize: function(serviceUrl, serviceType, resourceId, updateService) {
			this._requestUrl = serviceUrl + '/' + serviceType;
			this._serviceType = serviceType;
			if (resourceId)
				this._encodedResourceId = encodeURIComponent(resourceId);
			if (updateService)
				this._updateService = updateService;
		},
		
		setState: function(state) {
			this._state = state;
		},
		
		/**
		 * Invoke the service with default service behavior.
		 */
		invoke: function(editorContext, params, deferred, callbacks) {
			if (deferred === undefined) {
				deferred = jQuery.Deferred();
			}
			if (jQuery.isFunction(this._checkPreconditions) && !this._checkPreconditions(editorContext, params)) {
				deferred.reject();
				return deferred.promise();
			}
			var serverData = {
				contentType: params.contentType
			};
			var initResult;
			if (jQuery.isFunction(this._initServerData))
				initResult = this._initServerData(serverData, editorContext, params);
			var httpMethod = 'GET';
			if (initResult && initResult.httpMethod)
				httpMethod = initResult.httpMethod;
			var self = this;
			if (!(initResult && initResult.suppressContent)) {
				if (params.sendFullText) {
					serverData.fullText = editorContext.getText();
					httpMethod = 'POST';
				} else {
					var knownServerState = editorContext.getServerState();
					if (knownServerState.updateInProgress) {
						if (self._updateService) {
							self._updateService.addCompletionCallback(function() {
								self.invoke(editorContext, params, deferred);
							});
						} else {
							deferred.reject();
						}
						return deferred.promise();
					}
					if (knownServerState.stateId !== undefined) {
						serverData.requiredStateId = knownServerState.stateId;
					}
				}
			}
			
			var onSuccess;
			if (jQuery.isFunction(this._getSuccessCallback)) {
				onSuccess = this._getSuccessCallback(editorContext, params, deferred);
			} else {
				onSuccess = function(result) {
					if (result.conflict) {
						if (self._increaseRecursionCount(editorContext)) {
							var onConflictResult;
							if (jQuery.isFunction(self._onConflict)) {
								onConflictResult = self._onConflict(editorContext, result.conflict);
							}
							if (!(onConflictResult && onConflictResult.suppressForcedUpdate) && !params.sendFullText
									&& result.conflict == 'invalidStateId' && self._updateService) {
								self._updateService.addCompletionCallback(function() {
									self.invoke(editorContext, params, deferred);
								});
								var knownServerState = editorContext.getServerState();
								delete knownServerState.stateId;
								delete knownServerState.text;
								self._updateService.invoke(editorContext, params);
							} else {
								self.invoke(editorContext, params, deferred);
							}
						} else {
							deferred.reject();
						}
						return false;
					}
					if (jQuery.isFunction(self._processResult)) {
						var processedResult = self._processResult(result, editorContext);
						if (processedResult) {
							deferred.resolve(processedResult);
							return true;
						}
					}
					deferred.resolve(result);
				};
			}
			
			var onError = function(xhr, textStatus, errorThrown) {
				if (xhr.status == 404 && !params.loadFromServer && self._increaseRecursionCount(editorContext)) {
					var onConflictResult;
					if (jQuery.isFunction(self._onConflict)) {
						onConflictResult = self._onConflict(editorContext, errorThrown);
					}
					var knownServerState = editorContext.getServerState();
					if (!(onConflictResult && onConflictResult.suppressForcedUpdate)
							&& knownServerState.text !== undefined && self._updateService) {
						self._updateService.addCompletionCallback(function() {
							self.invoke(editorContext, params, deferred);
						});
						delete knownServerState.stateId;
						delete knownServerState.text;
						self._updateService.invoke(editorContext, params);
						return true;
					}
				}
				deferred.reject(errorThrown);
			}
			
			self.sendRequest(editorContext, {
				type: httpMethod,
				data: serverData,
				success: onSuccess,
				error: onError
			});
			return deferred.promise().always(function() {
				self._recursionCount = undefined;
			});
		},

		/**
		 * Send an HTTP request to invoke the service.
		 */
		sendRequest: function(editorContext, settings) {
			var self = this;
			self.setState('started');
			
			var onSuccess = settings.success;
			settings.success = function(result) {
				var accepted = true;
				if (jQuery.isFunction(onSuccess)) {
					accepted = onSuccess(result);
				}
				if (accepted || accepted === undefined) {
					self.setState('finished');
					if (editorContext.xtextServices) {
						var successListeners = editorContext.xtextServices.successListeners;
						if (successListeners) {
							for (var i = 0; i < successListeners.length; i++) {
								var listener = successListeners[i];
								if (jQuery.isFunction(listener)) {
									listener(self._serviceType, result);
								}
							}
						}
					}
				}
			};
			
			var onError = settings.error;
			settings.error = function(xhr, textStatus, errorThrown) {
				var resolved = false;
				if (jQuery.isFunction(onError)) {
					resolved = onError(xhr, textStatus, errorThrown);
				}
				if (!resolved) {
					self.setState(undefined);
					self._reportError(editorContext, textStatus, errorThrown, xhr);
				}
			};
			
			settings.async = true;
			var requestUrl = self._requestUrl;
			if (!settings.data.resource && self._encodedResourceId) {
				if (requestUrl.indexOf('?') >= 0)
					requestUrl += '&resource=' + self._encodedResourceId;
				else
					requestUrl += '?resource=' + self._encodedResourceId;
			}
			jQuery.ajax(requestUrl, settings);
		},
		
		/**
		 * Use this in case of a conflict before retrying the service invocation. If the number
		 * of retries exceeds the limit, an error is reported and the function returns false.
		 */
		_increaseRecursionCount: function(editorContext) {
			if (this._recursionCount === undefined)
				this._recursionCount = 1;
			else
				this._recursionCount++;

			if (this._recursionCount >= 10) {
				this._reportError(editorContext, 'warning', 'Xtext service request failed after 10 attempts.', {});
				return false;
			}
			return true;
		},
		
		/**
		 * Report an error to the listeners.
		 */
		_reportError: function(editorContext, severity, message, requestData) {
			if (editorContext.xtextServices) {
				var errorListeners = editorContext.xtextServices.errorListeners;
				if (errorListeners) {
					for (var i = 0; i < errorListeners.length; i++) {
						var listener = errorListeners[i];
						if (jQuery.isFunction(listener)) {
							listener(this._serviceType, severity, message, requestData);
						}
					}
				}
			}
		}
	};
	
	return XtextService;
});