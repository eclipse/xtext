/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

define(['xtext/services/AbstractXtextService', 'jquery'], function(AbstractXtextService, jQuery) {
	
	/**
	 * Service class for marking occurrences. The occurrences are returned as promise of a
	 * Deferred object.
	 */
	function OccurrencesService(serverUrl, resourceId) {
		this.initialize(serverUrl, resourceId, 'occurrences');
	};

	OccurrencesService.prototype = new AbstractXtextService();

	OccurrencesService.prototype.markOccurrences = function(editorContext, params, deferred) {
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
						self.markOccurrences(editorContext, params, deferred);
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

		this.sendRequest(editorContext, {
			type: httpMethod,
			data: serverData,
			
			success: function(result) {
				if (result && !result.conflict 
						&& (result.stateId === undefined || result.stateId == editorContext.getServerState().stateId)) 
					deferred.resolve(result);
				else 
					deferred.reject();
			},
			
			error: function(xhr, textStatus, errorThrown) {
				deferred.reject(errorThrown);
			}
		});
		return deferred.promise();
	};
	
	return OccurrencesService;
});