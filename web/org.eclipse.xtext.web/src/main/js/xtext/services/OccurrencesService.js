/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

define(["xtext/services/AbstractXtextService", "jquery"], function(AbstractXtextService, jQuery) {
	
	/**
	 * Service class for hover information. The information is returned as promise of
	 * a Deferred object.
	 */
	function OccurrencesService(serverUrl, resourceId) {
		this.initialize(serverUrl, resourceId, "occurrences");
		this._delay = 500
	};

	OccurrencesService.prototype = new AbstractXtextService();

	OccurrencesService.prototype.markOccurrences = function(editorContext, params) {
		var serverData = {
			contentType : params.contentType,
			offset: params.offset
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
		}

		this.sendRequest(editorContext, {
			type : httpMethod,
			data : serverData,
			success : function(result) {
				if (result && !result.conflict 
						&& (result.stateId === undefined || result.stateId == editorContext.getServerState().stateId)) 
					editorContext.showOccurrences(result);
				else 
					editorContext.showOccurrences(null);
			}
		});
	};
	
	return OccurrencesService;
});