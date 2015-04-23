/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

define(["xtext/services/AbstractXtextService"], function(AbstractXtextService) {
	
	function computeDelta(s1, s2, result) {
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
	
	function UpdateService(serverUrl, resourceUri) {
		this.initialize(serverUrl, resourceUri, "update");
	};
	
	UpdateService.prototype = new AbstractXtextService();

	UpdateService.prototype.update = function(editorContext, params) {
		if (this._runningUpdate) {
			this._waitingUpdate = params;
			return;
		}
		this._runningUpdate = true;
		var self = this;
		function onComplete(xhr, textStatus) {
			self._runningUpdate = false;
			var waitingUpdateParams = self._waitingUpdate;
			if (waitingUpdateParams !== undefined) {
				self._waitingUpdate = undefined;
				self.update(editorContext, waitingUpdateParams);
			}
		}

		var serverData = {
			contentType : params.contentType
		};
		var currentText = editorContext.getText();
		var currentStateId = editorContext.computeState(currentText);
		var knownServerState = editorContext.getServerState();
		if (params.sendFullText || knownServerState.text === undefined) {
			serverData.fullText = currentText;
		} else {
			var noUpdateNecessary = true;
			if (currentText.length !== knownServerState.text.length || currentStateId !== knownServerState.state) {
				computeDelta(knownServerState.text, currentText, serverData);
				if (serverData.deltaText !== undefined) {
					noUpdateNecessary = false;
					serverData.requiredState = knownServerState.state;
				}
			}
			if (noUpdateNecessary) {
				onComplete();
				return;
			}
		}
		serverData.newState = currentStateId;
		
		self.sendRequest(editorContext, {
			type : "PUT",
			data : serverData,
			success : function(result) {
				if (result.stateId == currentStateId) {
					editorContext.updateServerState(currentText, currentStateId);
					return true;
				}
				return false;
			},
			error : function(xhr, textStatus, errorThrown) {
				if (serverData.requiredState) {
					// Maybe we have a conflict - try again with full text instead of delta
					params.sendFullText = true;
					self._waitingUpdate = params;
					return true;
				}
				return false;
			},
			complete : onComplete
		});
	};
	
	return UpdateService;
});