/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

define(['xtext/services/AbstractXtextService', 'jquery'], function(AbstractXtextService, jQuery) {
	
	/**
	 * Service class for hover information. The information is returned as promise of
	 * a Deferred object.
	 */
	function HoverService(serverUrl, resourceId) {
		this.initialize(serverUrl, resourceId, 'hover');
		this._delay = 500
	};

	HoverService.prototype = new AbstractXtextService();

	HoverService.prototype.setDelay = function(delay) {
		this._delay = delay
	};

	HoverService.prototype.computeHoverInfo = function(editorContext, params) {
		var serverData = {
			contentType: params.contentType,
			offset: params.offset
		};
		var httpMethod = 'GET';
		if (params.sendFullText) {
			serverData.fullText = editorContext.getText();
			httpMethod = 'POST';
		} else {
			var knownServerState = editorContext.getServerState();
			if (knownServerState.stateId !== undefined) {
				serverData.requiredStateId = knownServerState.stateId;
			}
		}

		var deferred = new jQuery.Deferred();
		var showTime = new Date().getTime() + this._delay;
		this.sendRequest(editorContext, {
			type: httpMethod,
			data: serverData,
			success: function(result) {
				if (result && !result.conflict) {
					var remainingTimeout = Math.max(0, showTime - new Date().getTime())
					setTimeout(function() {
						if (result.stateId !== undefined && result.stateId != editorContext.getServerState().stateId) 
							deferred.resolve(null);
						else 
							deferred.resolve(editorContext.translateHoverInfo(result));
					}, remainingTimeout);
				}
				else
					deferred.resolve(null);
			}
		});
		var promise = deferred.promise();
		promise.cancel = function() {};
		return [ promise ];
	};
	
	return HoverService;
});