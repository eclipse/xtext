/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

define(['xtext/services/XtextService', 'jquery'], function(XtextService, jQuery) {
	
	/**
	 * Service class for loading resources. The resulting text is passed to the editor context.
	 */
	function LoadResourceService(serviceUrl, resourceId, revert) {
		this.initialize(serviceUrl, revert ? 'revert' : 'load', resourceId);
	};

	LoadResourceService.prototype = new XtextService();
	
	LoadResourceService.prototype._initServerData = function(serverData, editorContext, params) {
		return {
			suppressContent: true,
			httpMethod: this._requestType == 'revert' ? 'POST' : 'GET'
		};
	};
	
	LoadResourceService.prototype._getSuccessCallback = function(editorContext, params, deferred) {
		return function(result) {
			editorContext.setText(result.fullText);
			editorContext.clearUndoStack();
			editorContext.markClean(!result.dirty);
			var listeners = editorContext.updateServerState(result.fullText, result.stateId);
			for (var i = 0; i < listeners.length; i++) {
				listeners[i]();
			}
			deferred.resolve(result);
		}
	}

	return LoadResourceService;
});