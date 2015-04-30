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
	};

	LoadResourceService.prototype = new AbstractXtextService();

	LoadResourceService.prototype.loadResource = function(editorContext, params) {
		var serverData = {
			contentType : params.contentType
		};
		
		var self = this;
		this.sendRequest(editorContext, {
			type : "GET",
			data : serverData,
			success : function(result) {
				editorContext.setText(result.fullText);
				editorContext.getEditor().getUndoStack().reset();
				editorContext.markClean(!result.dirty);
				var listeners = editorContext.updateServerState(result.fullText, result.stateId);
				for (i in listeners) {
					listeners[i]();
				}
			}
		});
	};
	
	return LoadResourceService;
});