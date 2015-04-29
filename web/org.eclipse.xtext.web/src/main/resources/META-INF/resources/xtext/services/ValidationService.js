/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

define(["xtext/services/AbstractXtextService"], function(AbstractXtextService) {
	
	function ValidationService(serverUrl, resourceUri) {
		this.initialize(serverUrl, resourceUri, "validation");
	};
	
	ValidationService.prototype = new AbstractXtextService();

	ValidationService.prototype.computeProblems = function(editorContext, params) {
		if (editorContext.getClientServiceState().validation) {
			// Validation has already been triggered by another event
			return;
		}
		
		var serverData = {
			contentType : params.contentType
		};
		var httpMethod = "GET";
		if (params.sendFullText) {
			serverData.fullText = editorContext.getText();
			httpMethod = "POST";
		} else {
			var knownServerState = editorContext.getServerState();
			if (knownServerState.stateId !== undefined) {
				serverData.requiredStateId = knownServerState.stateId;
			}
			if (this._updateService && this._updateService.checkRunningUpdate(false)) {
				// An update is currently running - it will retrigger validation on completion
				return;
			}
		}

		var self = this;
		this.sendRequest(editorContext, {
			type : httpMethod,
			data : serverData,
			success : function(result) {
				if (result.conflict) {
					if (self.increaseRecursionCount(editorContext)) {
						delete editorContext.getClientServiceState().validation;
						self.computeProblems(editorContext, params);
						return true;
					}
					return false;
				}
				var problems = [];
				for (var i = 0; i < result.entries.length; i++) {
					var e = result.entries[i];
					problems.push({
						description : e.description,
						start : e.startOffset,
						end : e.endOffset,
						severity : e.severity
					});
				}
				editorContext.showMarkers(problems)
				editorContext.getClientServiceState().validation = "finished";
			}
		});
	};
	
	return ValidationService;
});