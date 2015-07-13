/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

define(['xtext/services/XtextService', 'jquery'], function(XtextService, jQuery) {
	
	/**
	 * Service class for semantic highlighting.
	 */
	function HighlightingService(serverUrl, resourceId) {
		this.initialize(serverUrl, resourceId, 'highlight');
	};

	HighlightingService.prototype = new XtextService();
	HighlightingService.prototype.computeHighlighting = HighlightingService.prototype.invoke;
	
	HighlightingService.prototype._checkPreconditions = function(editorContext, params) {
		return editorContext.getClientServiceState().highlighting === undefined;
	}

	HighlightingService.prototype._onConflict = function(editorContext, cause) {
		delete editorContext.getClientServiceState().highlighting;
		return {
			suppressForcedUpdate: true
		};
	};
	
	return HighlightingService;
});