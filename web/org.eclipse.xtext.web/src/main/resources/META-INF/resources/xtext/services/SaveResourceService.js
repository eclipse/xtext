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
			if (this._updateService && this._updateService.checkRunningUpdate(false)) {
				var self = this;
				this._updateService.addCompletionCallback(function() {
					self.saveResource(editorContext, params);
				});
				return;
			}
		}
		
		var self = this;
		self.sendRequest(editorContext, {
			type : "POST",
			data : serverData,
			success : function(result) {
				if (result.conflict) {
					if (self.increaseRecursionCount(editorContext)) {
						if (!params.sendFullText && result.conflict == "invalidStateId") {
							params.sendFullText = true;
							delete editorContext.getServerState().stateId;
							self._updateService.update(editorContext, params);
						}
						self.saveResource(editorContext, params);
						return true;
					}
					return false;
				}
				editorContext.markClean(true);
			}
		});
	};
	
	return SaveResourceService;
});