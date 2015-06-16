/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

define(["xtext/services/AbstractXtextService"], function(AbstractXtextService) {
	
	function UpdateService(serverUrl, resourceId) {
		this.initialize(serverUrl, resourceId, "update");
		this.setUpdateService(this);
		this._completionCallbacks = [];
	};
	
	UpdateService.prototype = new AbstractXtextService();
	
	UpdateService.prototype.computeDelta = function(s1, s2, result) {
		var start = 0, s1length = s1.length, s2length = s2.length;
		while (start < s1length && start < s2length && s1.charCodeAt(start) === s2.charCodeAt(start)) {
			start++;
		}
		if (start === s1length && start === s2length) {
			return;
		}
		result.deltaOffset = start;
		if (start === s1length) {
			result.deltaText = s2.substring(start, s2length);
			result.deltaReplaceLength = 0;
			return;
		} else if (start === s2length) {
			result.deltaText = "";
			result.deltaReplaceLength = s1length - start;
			return;
		}
		
		var end1 = s1length - 1, end2 = s2length - 1;
		while (end1 >= start && end2 >= start && s1.charCodeAt(end1) === s2.charCodeAt(end2)) {
			end1--;
			end2--;
		}
		result.deltaText = s2.substring(start, end2 + 1);
		result.deltaReplaceLength = end1 - start + 1;
	};
	
	UpdateService.prototype.onComplete = function(xhr, textStatus) {
		var callbacks = this._completionCallbacks;
		this._completionCallbacks = [];
		for (i in callbacks) {
			callbacks[i]();
		}
	}
	
	UpdateService.prototype.addCompletionCallback = function(callback) {
		this._completionCallbacks.push(callback);
	}

	UpdateService.prototype.update = function(editorContext, params) {
		if (editorContext.getClientServiceState().update == "started") {
			var self = this;
			this.addCompletionCallback(function() { self.update(editorContext, params) });
			return;
		}
		
		var serverData = {
			contentType : params.contentType
		};
		var currentText = editorContext.getText();
		var knownServerState = editorContext.getServerState();
		if (params.sendFullText || knownServerState.text === undefined) {
			serverData.fullText = currentText;
		} else {
			this.computeDelta(knownServerState.text, currentText, serverData);
			if (serverData.deltaText === undefined) {
				this.onComplete();
				return;
			}
			serverData.requiredStateId = knownServerState.stateId;
		}

		var self = this;
		self.sendRequest(editorContext, {
			type : "PUT",
			data : serverData,
			success : function(result) {
				if (result.conflict) {
					// The server has lost its session state and the resource is loaded from the server
					if (knownServerState.text !== undefined) {
						delete knownServerState.text;
						delete knownServerState.stateId;
						self.update(editorContext, params);
						return true;
					}
					return false;
				}
				var listeners = editorContext.updateServerState(currentText, result.stateId);
				for (i in listeners) {
					self.addCompletionCallback(listeners[i]);
				}
			},
			error: function(xhr, textStatus, errorThrown) {
				if (xhr.status == 404 && !params.loadFromServer && knownServerState.text !== undefined) {
					// The server has lost its session state and the resource is not loaded from the server
					delete editorContext.getClientServiceState().update;
					delete knownServerState.text;
					delete knownServerState.stateId;
					self.update(editorContext, params);
					return true;
				}
			},
			complete : self.onComplete.bind(self)
		});
	};
	
	return UpdateService;
});