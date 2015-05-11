/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

define(["xtext/services/AbstractXtextService", "orion/Deferred"], function(AbstractXtextService, Deferred) {

	function ContentAssistService(serverUrl, resourceUri) {
		this.initialize(serverUrl, resourceUri, "content-assist");
	}

	ContentAssistService.prototype = new AbstractXtextService();
		
	ContentAssistService.prototype.computeContentAssist = function(editorContext, params, deferred) {
		if (deferred === undefined) {
			deferred = new Deferred();
		}
		var serverData = {
			contentType : params.contentType,
			caretOffset : params.offset
		};
		if (params.selection.start != params.offset || params.selection.end != params.offset) {
			serverData.selectionStart = params.selection.start;
			serverData.selectionEnd = params.selection.end;
		}
		var currentText = editorContext.getText();
		var httpMethod = "GET";
		var onComplete = undefined;
		if (params.sendFullText) {
			serverData.fullText = editorContext.getText();
			httpMethod = "POST";
		} else {
			var knownServerState = editorContext.getServerState();
			if (knownServerState.stateId !== undefined) {
				serverData.requiredStateId = knownServerState.stateId;
			}
			if (this._updateService && knownServerState.text !== undefined) {
				if (editorContext.getClientServiceState().update == "started") {
					var self = this;
					this._updateService.addCompletionCallback(function() {
						self.computeContentAssist(editorContext, params, deferred);
					});
					return deferred.promise;
				}
				editorContext.getClientServiceState().update = "started";
				onComplete = this._updateService.onComplete.bind(this._updateService);
				this._updateService.computeDelta(knownServerState.text, currentText, serverData);
				if (serverData.deltaText !== undefined) {
					httpMethod = "POST";
				}
			}
		}
		
		var self = this;
		self.sendRequest(editorContext, {
			type : httpMethod,
			data : serverData,
			success : function(result) {
				if (result.conflict) {
					// This can only happen if the server has lost its session state
					if (self.increaseRecursionCount(editorContext)) {
						params.sendFullText = true;
						self.computeContentAssist(editorContext, params, deferred);
					}
					return false;
				}
				if (onComplete) {
					if (result.stateId !== undefined && result.stateId != editorContext.getServerState().stateId) {
						var listeners = editorContext.updateServerState(currentText, result.stateId);
						for (i in listeners) {
							self._updateService.addCompletionCallback(listeners[i]);
						}
					}
					editorContext.getClientServiceState().update = "finished";
				}
				var proposals = [];
				for (var i = 0; i < result.entries.length; i++) {
					var e = result.entries[i];
					var p = {
						proposal : e.proposal,
						prefix : e.prefix,
						overwrite : true,
						name : (e.name ? e.name : e.proposal),
						description : e.description,
						style : e.style,
						additionalEdits : e.textReplacements,
						positions : e.editPositions,
					};
					if (e.escapePosition) {
						p.escapePosition = e.escapePosition;
					}
					proposals.push(p);
				}
				deferred.resolve(proposals);
			},
			error : function(xhr, textStatus, errorThrown) {
				if (onComplete) {
					delete editorContext.getClientServiceState().update;
				}
				deferred.reject(errorThrown);
			},
			complete: onComplete
		});
		return deferred.promise;
	};
	
	return ContentAssistService;
});
