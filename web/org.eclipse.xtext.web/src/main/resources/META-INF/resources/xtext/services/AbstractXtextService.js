/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

define(["jquery"], function(jQuery) {
	
	function AbstractXtextService() {};

	AbstractXtextService.prototype = {
		
		initialize : function(serverUrl, resourceUri, requestType) {
			this._requestType = requestType;
			if (resourceUri === undefined) {
				this._requestUrl = serverUrl + "/" + requestType;
			} else {
				this._requestUrl = serverUrl + "/" + requestType + "?resource=" + encodeURIComponent(resourceUri);
			}
			this._recursionCount = 0;
		},
		
		setUpdateService : function(updateService) {
			this._updateService = updateService;
		},

		sendRequest : function(editorContext, settings) {
			var self = this;
			editorContext.getClientServiceState()[self._requestType] = "started";
			var success = settings.success;
			settings.success = function(result) {
				var accepted = true;
				if (jQuery.isFunction(success)) {
					accepted = success(result);
				}
				if (accepted || accepted === undefined) {
					editorContext.getClientServiceState()[self._requestType] = "finished";
					var successListeners = editorContext.getEditor().xtextServiceSuccessListeners;
					for (var i in successListeners) {
						var listener = successListeners[i];
						if (jQuery.isFunction(listener)) {
							listener(self._requestType, result);
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
					self.reportError(editorContext, textStatus, errorThrown);
				}
			};
			var complete = settings.complete;
			settings.complete = function(xhr, textStatus) {
				if (jQuery.isFunction(complete)) {
					complete(xhr, textStatus);
				}
				self._recursionCount = 0;
			};
			settings.async = true;
			settings.dataType = "json";
			jQuery.ajax(this._requestUrl, settings);
		},
		
		increaseRecursionCount : function(editorContext) {
			if (this._recursionCount++ >= 10) {
				this.reportError(editorContext, "warning", "Xtext service request failed after 10 attempts.");
				return false;
			}
			return true;
		},
		
		reportError : function(editorContext, severity, message) {
			var errorListeners = editorContext.getEditor().xtextServiceErrorListeners;
			for (var i in errorListeners) {
				var listener = errorListeners[i];
				if (jQuery.isFunction(listener)) {
					listener(this._requestType, {}, severity, message);
				}
			}
		}
	};
	
	return AbstractXtextService;
});