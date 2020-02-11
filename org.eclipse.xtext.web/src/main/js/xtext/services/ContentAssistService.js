/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/

define(['xtext/services/XtextService', 'jquery'], function(XtextService, jQuery) {

	/**
	 * Service class for content assist proposals. The proposals are returned as promise of
	 * a Deferred object.
	 */
	function ContentAssistService(serviceUrl, resourceId, updateService) {
		this.initialize(serviceUrl, 'assist', resourceId, updateService);
	}

	ContentAssistService.prototype = new XtextService();
	
	ContentAssistService.prototype.invoke = function(editorContext, params, deferred) {
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
				if (knownServerState.text === undefined || knownServerState.updateInProgress) {
					var self = this;
					this._updateService.addCompletionCallback(function() {
						self.invoke(editorContext, params, deferred);
					});
					return deferred.promise();
				}
				knownServerState.updateInProgress = true;
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
					if (self._increaseRecursionCount(editorContext)) {
						if (onComplete) {
							delete knownServerState.updateInProgress;
							delete knownServerState.text;
							delete knownServerState.stateId;
							self._updateService.addCompletionCallback(function() {
								self.invoke(editorContext, params, deferred);
							});
							self._updateService.invoke(editorContext, params);
						} else {
							var paramsCopy = {};
							for (var p in params) {
								if (params.hasOwnProperty(p))
									paramsCopy[p] = params[p];
							}
							paramsCopy.sendFullText = true;
							self.invoke(editorContext, paramsCopy, deferred);
						}
					} else {
						deferred.reject(result.conflict);
					}
					return false;
				}
				if (onComplete && result.stateId !== undefined && result.stateId != editorContext.getServerState().stateId) {
					var listeners = editorContext.updateServerState(currentText, result.stateId);
					for (var i = 0; i < listeners.length; i++) {
						self._updateService.addCompletionCallback(listeners[i], params);
					}
				}
				deferred.resolve(result.entries);
			},
			
			error: function(xhr, textStatus, errorThrown) {
				if (onComplete && xhr.status == 404 && !params.loadFromServer && knownServerState.text !== undefined) {
					// The server has lost its session state and the resource is not loaded from the server
					delete knownServerState.updateInProgress;
					delete knownServerState.text;
					delete knownServerState.stateId;
					self._updateService.addCompletionCallback(function() {
						self.invoke(editorContext, params, deferred);
					});
					self._updateService.invoke(editorContext, params);
					return true;
				}
				deferred.reject(errorThrown);
			},
			
			complete: onComplete
		}, !params.sendFullText);
		var result = deferred.promise();
		if (onComplete) {
			result.always(function() {
				knownServerState.updateInProgress = false;
			});
		}
		return result;
	};

	return ContentAssistService;
});
