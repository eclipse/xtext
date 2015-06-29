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
	};

	HoverService.prototype = new AbstractXtextService();

	HoverService.prototype.computeHoverInfo = function(editorContext, params, deferred) {
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
		var httpMethod = 'GET';
		if (params.sendFullText) {
			serverData.fullText = editorContext.getText();
			httpMethod = 'POST';
		} else {
			if (editorContext.getClientServiceState().update == 'started') {
				if (this._updateService) {
					var self = this;
					this._updateService.addCompletionCallback(function() {
						self.computeHoverInfo(editorContext, params, deferred);
					});
				} else {
					deferred.reject();
				}
				return deferred.promise();
			}
			var knownServerState = editorContext.getServerState();
			if (knownServerState.stateId !== undefined) {
				serverData.requiredStateId = knownServerState.stateId;
			}
		}

		var delay = params.mouseHoverDelay;
		if (!delay)
			delay = 500;
		var showTime = new Date().getTime() + delay;
		this.sendRequest(editorContext, {
			type: httpMethod,
			data: serverData,
			
			success: function(result) {
				if (result && !result.conflict) {
					var remainingTimeout = Math.max(0, showTime - new Date().getTime());
					setTimeout(function() {
						if (result.stateId !== undefined && result.stateId != editorContext.getServerState().stateId) 
							deferred.reject();
						else
							deferred.resolve(result);
					}, remainingTimeout);
				} else {
					deferred.reject();
				}
			},
			
			error: function(xhr, textStatus, errorThrown) {
				deferred.reject(errorThrown);
			}
		});
		return deferred.promise();
	};
	
	return HoverService;
});