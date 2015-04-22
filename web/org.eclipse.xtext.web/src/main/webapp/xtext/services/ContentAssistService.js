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
		this._lastRequestId = 0;
	}

	ContentAssistService.prototype = new AbstractXtextService();
		
	ContentAssistService.prototype.computeContentAssist = function(editorContext, params) {
		var requestId = ++this._lastRequestId;
		var serverData = {
			contentType : params.contentType,
			requestId : requestId,
			caretOffset : params.offset,
			selectionStart : params.selection.start,
			selectionEnd : params.selection.end
		};
		var httpMethod = "GET";
		if (params.sendFullText) {
			serverData.fullText = editorContext.getText();
			httpMethod = "POST";
		}
		
		var deferred = new Deferred();
		var proposals = [];
		var self = this;
		this.sendRequest(editorContext, {
			type : httpMethod,
			data : serverData,
			success : function(result) {
				if (parseInt(result.requestId, 10) == self._lastRequestId) {
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
				}
				return false;
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
