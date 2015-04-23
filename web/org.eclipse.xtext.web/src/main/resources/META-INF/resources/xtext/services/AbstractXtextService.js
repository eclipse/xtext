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
		},

		sendRequest : function(editorContext, settings) {
			var self = this;
			var success = settings.success;
			settings.success = function(result) {
				var accepted = true;
				if (jQuery.isFunction(success)) {
					accepted = success(result);
				}
				if (accepted) {
					var listener = editorContext.getEditor().xtextServiceSuccessListener;
					if (jQuery.isFunction(listener)) {
						listener(self._requestType, result);
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
					var listener = editorContext.getEditor().xtextServiceErrorListener;
					if (jQuery.isFunction(listener)) {
						listener(self._requestType, xhr, textStatus, errorThrown);
					}
				}
			};
			settings.async = true;
			settings.dataType = "json";
			jQuery.ajax(this._requestUrl, settings);
		}
	};
	
	return AbstractXtextService;
});