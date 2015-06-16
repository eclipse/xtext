/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

define(["xtext/services/AbstractXtextService", "jquery"], function(AbstractXtextService) {
	
	function HoverService(serverUrl, resourceId) {
		this.initialize(serverUrl, resourceId, "hover");
	};
	
	HoverService.prototype = new AbstractXtextService();

	HoverService.prototype.computeHoverInfo = function(editorContext, params) {
		var serverData = {
			contentType : params.contentType,
			offset: params.offset
		};
		var httpMethod = "GET";
		var knownServerState = editorContext.getServerState();
		if (knownServerState.stateId !== undefined) {
			serverData.requiredStateId = knownServerState.stateId;
		}

		var deferred = new jQuery.Deferred();
		this.sendRequest(editorContext, {
			type : httpMethod,
			data : serverData,
			success : function(result) {
				if (!result.conflict) 
					deferred.resolve(editorContext.translateHoverInfo(result));
			}
		});
		var promise = deferred.promise();
		promise.cancel = function() {};
		return [ promise ];
	};
	
	return HoverService;
});