/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

define(["xtext/services/AbstractXtextService", "orion/Deferred"], function(AbstractXtextService, Deferred) {

	function ContentAssistService(serverUrl, resourceUri, updateService) {
		this.initialize(serverUrl, resourceUri, "content-assist");
		this._updateService = updateService;
	}

	ContentAssistService.prototype = new AbstractXtextService();
		
	ContentAssistService.prototype.computeContentAssist = function(editorContext, params) {
		var deferred = new Deferred();
		var serverData = {
			contentType : params.contentType,
			caretOffset : params.offset,
			selectionStart : params.selection.start,
			selectionEnd : params.selection.end
		};
		var currentText = editorContext.getText();
		var updateServerState = false;
		var httpMethod = "GET";
		if (params.sendFullText) {
			serverData.fullText = editorContext.getText();
			httpMethod = "POST";
		} else if (this._updateService) {
			var knownServerState = editorContext.getServerState();
			if (knownServerState.text !== undefined) {
				if (this._updateService.checkRunningUpdate(function() {
						this.computeContentAssist(editorContext, params).then(
							function(value) {deferred.resolve(value)},
							function(error) {deferred.reject(error)},
							function(update) {deferred.progress(update)});
					})) {
					return deferred.promise;
				}
				this._updateService.computeDelta(knownServerState.text, currentText, serverData);
				if (serverData.deltaText !== undefined) {
					httpMethod = "POST";
					serverData.requiredStateId = knownServerState.stateId;
					updateServerState = true;
				}
			}
		}
		
		this.sendRequest(editorContext, {
			type : httpMethod,
			data : serverData,
			success : function(result) {
				if (updateServerState) {
					editorContext.updateServerState(currentText, result.stateId);
				}
				var proposals = [];
				for (var i = 0; i < result.entries.length; i++) {
					var e = result.entries[i];
					proposals.push({
						proposal : e.proposal,
						name : e.name,
						description : e.description,
						style : e.style,
						additionalEdits : e.textReplacements,
						positions : e.editPositions
					});
				}
				deferred.resolve(proposals);
				return true;
			},
			error : function(xhr, textStatus, errorThrown) {
				deferred.reject(errorThrown);
				return false;
			}
		});
		return deferred.promise;
	};
	
	return ContentAssistService;
});
