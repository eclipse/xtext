/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

define(['xtext/services/AbstractXtextService', 'jquery'], function(AbstractXtextService, jQuery) {
	
	/**
	 * Service class for generating code.
	 */
	function GeneratorService(serverUrl, resourceId) {
		this.initialize(serverUrl, resourceId, 'generate');
	};

	GeneratorService.prototype = new AbstractXtextService();

	GeneratorService.prototype.generate = function(editorContext, params, deferred) {
		if (deferred === undefined) {
			deferred = jQuery.Deferred();
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
				var self = this;
				this._updateService.addCompletionCallback(function() {
					self.generate(editorContext, params, deferred);
				});
				return deferred.promise();
			}
			var knownServerState = editorContext.getServerState();
			if (knownServerState.stateId !== undefined) {
				serverData.requiredStateId = knownServerState.stateId;
			}
		}
		
		var self = this;
		self.sendRequest(editorContext, {
			type: httpMethod,
			data: serverData,
			
			success: function(result) {
				if (result.conflict) {
					if (self.increaseRecursionCount(editorContext)) {
						if (!params.sendFullText && result.conflict == 'invalidStateId') {
							self._updateService.addCompletionCallback(function() {
								self.generate(editorContext, params, deferred);
							});
							var newParams = {};
							for (var p in params) {
								if (params.hasOwnProperty(p))
									newParams[p] = params[p];
							}
							newParams.sendFullText = true;
							delete editorContext.getServerState().stateId;
							self._updateService.update(editorContext, newParams);
						} else {
							self.generate(editorContext, params, deferred);
						}
					}
					deferred.reject();
					return false;
				}
				deferred.resolve(result);
			},
			
			error: function(xhr, textStatus, errorThrown) {
				deferred.reject(errorThrown);
			}
		});
		return deferred.promise();
	};
	
	return GeneratorService;
});