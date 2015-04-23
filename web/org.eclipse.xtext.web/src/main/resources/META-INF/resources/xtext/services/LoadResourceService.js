/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

define(["xtext/services/AbstractXtextService"], function(AbstractXtextService) {
	
	function LoadResourceService(serverUrl, resourceUri) {
		this.initialize(serverUrl, resourceUri, "load");
		this._lastRequestId = 0;
	};

	LoadResourceService.prototype = new AbstractXtextService();

	LoadResourceService.prototype.loadResource = function(editorContext, params) {
		var requestId = ++this._lastRequestId;
		var serverData = {
			contentType : params.contentType,
			requestId : requestId
		};
		
		var self = this;
		this.sendRequest(editorContext, {
			type : "GET",
			data : serverData,
			success : function(result) {
				if (parseInt(result.requestId, 10) == self._lastRequestId) {
					editorContext.setText(result.fullText);
					editorContext.getEditor().getUndoStack().reset();
					editorContext.markClean(!result.dirty);
					editorContext.updateServerState(result.fullText, result.stateId);
				}
			}
		});
	};
	
	return LoadResourceService;
});