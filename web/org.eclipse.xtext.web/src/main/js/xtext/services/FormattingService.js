/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

define(['xtext/services/AbstractXtextService', 'jquery'], function(AbstractXtextService, jQuery) {
	
	/**
	 * Service class for formatting text.
	 */
	function FormattingService(serverUrl, resourceId) {
		this.initialize(serverUrl, resourceId, 'format');
	};

	FormattingService.prototype = new AbstractXtextService();

	FormattingService.prototype.format = function(editorContext, params, deferred) {
		if (deferred === undefined) {
			deferred = jQuery.Deferred();
		}
		var serverData = {
			contentType: params.contentType
		};
		var selection = params.selection ? params.selection : editorContext.getSelection();
		if (selection.end > selection.start) {
			serverData.selectionStart = selection.start;
			serverData.selectionEnd = selection.end;
		}
		var httpMethod = 'GET';
		if (params.sendFullText) {
			serverData.fullText = editorContext.getText();
			httpMethod = 'POST';
		} else {
			if (editorContext.getClientServiceState().update == 'started') {
				if (this._updateService) {
					var self = this;
					this._updateService.addCompletionCallback(function() {
						self.format(editorContext, params, deferred);
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
		
		var self = this;
		this.sendRequest(editorContext, {
			type: httpMethod,
			data: serverData,
			
			success: function(result) {
				if (result.replaceRegion)
					editorContext.setText(result.formattedText, result.replaceRegion.offset,
							result.replaceRegion.offset + result.replaceRegion.length);
				else
					editorContext.setText(result.formattedText);
				var listeners = editorContext.updateServerState(editorContext.getText(), result.stateId);
				for (var i = 0; i < listeners.length; i++) {
					listeners[i]();
				}
				deferred.resolve(result);
			},
			
			error: function(xhr, textStatus, errorThrown) {
				deferred.reject(errorThrown);
			}
		});
		return deferred.promise();
	};
	
	return FormattingService;
});