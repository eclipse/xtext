/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

define(['xtext/services/AbstractXtextService', 'jquery'], function(AbstractXtextService, jQuery) {

	/**
	 * Service class for content assist proposals. The proposals are returned as promise of
	 * a Deferred object.
	 */
	function ContentAssistService(serverUrl, resourceId) {
		this.initialize(serverUrl, resourceId, 'content-assist');
	}

	ContentAssistService.prototype = new AbstractXtextService();
		
	ContentAssistService.prototype.computeContentAssist = function(editorContext, params, deferred) {
		if (deferred === undefined) {
			deferred = jQuery.Deferred();
		}
		var serverData = {
			contentType: params.contentType
		};
		if (params.offset)
			serverData.caretOffset = params.offset;
		else
			serverData.caretOffset = editorContext.getCaretOffset();
		var selection = params.selection ? params.selection : editorContext.getSelection();
		if (selection.start != serverData.caretOffset || selection.end != serverData.caretOffset) {
			serverData.selectionStart = selection.start;
			serverData.selectionEnd = selection.end;
		}
		var currentText;
		var httpMethod = 'GET';
		var onComplete = undefined;
		var knownServerState = editorContext.getServerState();
		if (params.sendFullText) {
			serverData.fullText = editorContext.getText();
			httpMethod = 'POST';
		} else {
			serverData.requiredStateId = knownServerState.stateId;
			if (this._updateService) {
				if (knownServerState.text === undefined
						|| editorContext.getClientServiceState().update == 'started') {
					var self = this;
					this._updateService.addCompletionCallback(function() {
						self.computeContentAssist(editorContext, params, deferred);
					});
					return deferred.promise();
				}
				editorContext.getClientServiceState().update = 'started';
				onComplete = this._updateService.onComplete.bind(this._updateService);
				currentText = editorContext.getText();
				this._updateService.computeDelta(knownServerState.text, currentText, serverData);
				if (serverData.deltaText !== undefined) {
					httpMethod = 'POST';
				}
			}
		}
		
		var self = this;
		self.sendRequest(editorContext, {
			type: httpMethod,
			data: serverData,
			
			success: function(result) {
				if (result.conflict) {
					// The server has lost its session state and the resource is loaded from the server
					if (self.increaseRecursionCount(editorContext)) {
						params.sendFullText = true;
						self.computeContentAssist(editorContext, params, deferred);
					}
					return false;
				}
				if (onComplete) {
					if (result.stateId !== undefined && result.stateId != editorContext.getServerState().stateId) {
						var listeners = editorContext.updateServerState(currentText, result.stateId);
						for (var i = 0; i < listeners.length; i++) {
							self._updateService.addCompletionCallback(listeners[i]);
						}
					}
					editorContext.getClientServiceState().update = 'finished';
				}
				deferred.resolve(result.entries);
			},
			
			error: function(xhr, textStatus, errorThrown) {
				if (onComplete) {
					delete editorContext.getClientServiceState().update;
					if (xhr.status == 404 && !params.loadFromServer && knownServerState.text !== undefined) {
						// The server has lost its session state and the resource is not loaded from the server
						delete editorContext.getClientServiceState()['content-assist'];
						delete knownServerState.text;
						delete knownServerState.stateId;
						self._updateService.addCompletionCallback(function() {
							self.computeContentAssist(editorContext, params, deferred);
						});
						self._updateService.update(editorContext, params);
						return true;
					}
				}
				deferred.reject(errorThrown);
			},
			
			complete: onComplete
		});
		return deferred.promise();
	};
	
	return ContentAssistService;
});
