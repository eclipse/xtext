/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

define(["xtext/services/AbstractXtextService"], function(AbstractXtextService) {
	
	function SaveResourceService(serverUrl, resourceUri) {
		this.initialize(serverUrl, resourceUri, "save");
	};

	SaveResourceService.prototype = new AbstractXtextService();

	SaveResourceService.prototype.saveResource = function(editorContext, params) {
		var serverData = {
			contentType : params.contentType
		};
		if (params.sendFullText) {
			serverData.fullText = editorContext.getText();
		} else {
			var knownServerState = editorContext.getServerState();
			if (knownServerState.stateId !== undefined) {
				serverData.requiredStateId = knownServerState.stateId;
			}
		}
		
		var self = this;
		self.sendRequest(editorContext, {
			type : "POST",
			data : serverData,
			success : function(result) {
				if (result.conflict) {
					// A conflict with another service occured - retry
					self.retry(self.saveResource, editorContext, params);
					return false;
				}
				editorContext.markClean(true);
			}
		});
	};
	
	return SaveResourceService;
});