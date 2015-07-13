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
		 * Initialize the request metadata this service class.
		 */
		initialize: function(serverUrl, resourceId, requestType, updateService) {
			this._requestType = requestType;
			if (resourceId === undefined) {
				this._requestUrl = serverUrl + '/' + requestType;
			} else {
				this._requestUrl = serverUrl + '/' + requestType + '?resource=' + encodeURIComponent(resourceId);
			}
			this._updateService = updateService;
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
					if (editorContext.getClientServiceState().update == 'started') {
						if (self._updateService) {
							self._updateService.addCompletionCallback(function() {
								self.invoke(editorContext, params, deferred);
							});
						} else {
							deferred.reject();
						}
						return deferred.promise();
					}
					var knownServerState = editorContext.getServerState();
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
									&& result.conflict == 'invalidStateId') {
								self._updateService.addCompletionCallback(function() {
									self.invoke(editorContext, params, deferred);
								});
								var knownServerState = editorContext.getServerState();
								delete knownServerState.stateId;
								delete knownServerState.text;
								self._updateService.update(editorContext, params);
							} else {
								self.invoke(editorContext, params, deferred);
							}
						}
						deferred.reject();
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
			
			self.sendRequest(editorContext, {
				type: httpMethod,
				data: serverData,
				success: onSuccess,
				error: function(xhr, textStatus, errorThrown) {
					deferred.reject(errorThrown);
				}
			});
			return deferred.promise();
		},

		/**
		 * Send an HTTP request to invoke the service.
		 */
		sendRequest: function(editorContext, settings) {
			var self = this;
			editorContext.getClientServiceState()[self._requestType] = 'started';
			
			var success = settings.success;
			settings.success = function(result) {
				var accepted = true;
				if (jQuery.isFunction(success)) {
					accepted = success(result);
				}
				if (accepted || accepted === undefined) {
					editorContext.getClientServiceState()[self._requestType] = 'finished';
					if (editorContext.getEditor) {
						var successListeners = editorContext.getEditor().xtextServiceSuccessListeners;
						if (successListeners) {
							for (var i = 0; i < successListeners.length; i++) {
								var listener = successListeners[i];
								if (jQuery.isFunction(listener)) {
									listener(self._requestType, result);
								}
							}
						}
					}
				}
			};
			
			var error = settings.error;
			settings.error = function(xhr, textStatus, errorThrown) {
				var resolved = false;
				if (jQuery.isFunction(error)) {
					resolved = error(xhr, textStatus, errorThrown);
				}
				if (!resolved) {
					delete editorContext.getClientServiceState()[self._requestType];
					self._reportError(editorContext, textStatus, errorThrown);
				}
			};
			
			var complete = settings.complete;
			settings.complete = function(xhr, textStatus) {
				if (jQuery.isFunction(complete)) {
					complete(xhr, textStatus);
				}
				self._recursionCount = undefined;
			};

			if (self._resourceId && settings.data)
				settings.data.resource = self._resourceId;
			settings.async = true;
			jQuery.ajax(this._requestUrl, settings);
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
				this._reportError(editorContext, 'warning', 'Xtext service request failed after 10 attempts.');
				this._recursionCount = undefined;
				return false;
			}
			return true;
		},
		
		/**
		 * Report an error to the listeners.
		 */
		_reportError: function(editorContext, severity, message) {
			if (editorContext.getEditor) {
				var errorListeners = editorContext.getEditor().xtextServiceErrorListeners;
				if (errorListeners) {
					for (var i = 0; i < errorListeners.length; i++) {
						var listener = errorListeners[i];
						if (jQuery.isFunction(listener)) {
							listener(this._requestType, {}, severity, message);
						}
					}
				}
			}
		}
	};
	
	return XtextService;
});