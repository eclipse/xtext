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
	function HighlightingService(serverUrl, resourceId) {
		this.initialize(serverUrl, resourceId, 'highlighting');
	};

	HighlightingService.prototype = new AbstractXtextService();

	HighlightingService.prototype.computeHighlighting = function(editorContext, params, deferred) {
		if (deferred === undefined) {
			deferred = jQuery.Deferred();
		}
		if (editorContext.getClientServiceState().highlighting) {
			// Validation has already been triggered by another event
			deferred.reject();
			return deferred.promise();
		}
		
		var serverData = {
			contentType: params.contentType
		};
		var httpMethod = 'GET';
		if (params.sendFullText) {
			serverData.fullText = editorContext.getText();
			httpMethod = 'POST';
		} else {
			if (editorContext.getClientServiceState().update == 'started') {
				// An update is currently running - it will retrigger validation on completion
				deferred.reject();
				return deferred.promise();
			}
			var knownServerState = editorContext.getServerState();
			if (knownServerState.stateId !== undefined) {
				serverData.requiredStateId = knownServerState.stateId;
			}
		}

		var self = this;
		this.sendRequest(editorContext, {
			type: httpMethod,
			data: serverData,
			
			success: function(result) {
				if (result.conflict) {
					if (self.increaseRecursionCount(editorContext)) {
						delete editorContext.getClientServiceState().highlighting;
						self.computeHighlighting(editorContext, params, deferred);
					}
					deferred.reject(result.conflict);
					return false;
				}
				deferred.resolve(result.regions)
			},
			
			error: function(xhr, textStatus, errorThrown) {
				deferred.reject(errorThrown);
			}
		});
		return deferred.promise();
	};
	
	return HighlightingService;
});