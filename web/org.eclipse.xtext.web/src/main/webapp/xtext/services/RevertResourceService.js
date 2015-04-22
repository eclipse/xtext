/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

define(["xtext/services/AbstractXtextService"], function(AbstractXtextService) {
	
	function RevertResourceService(serverUrl, resourceUri) {
		this.initialize(serverUrl, resourceUri, "revert");
		this._lastRequestId = 0;
	};

	RevertResourceService.prototype = new AbstractXtextService();

	RevertResourceService.prototype.revertResource = function(editorContext, params) {
		var requestId = ++this._lastRequestId;
		var serverData = {
			contentType : params.contentType,
			requestId : requestId
		};
		
		var self = this;
		this.sendRequest(editorContext, {
			type : "POST",
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
	
	return RevertResourceService;
});