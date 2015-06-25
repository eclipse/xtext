/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

define(['xtext/services/AbstractXtextService'], function(AbstractXtextService) {
	
	/**
	 * Service class for reverting resources. The resulting text is passed to the editor context.
	 */
	function RevertResourceService(serverUrl, resourceId) {
		this.initialize(serverUrl, resourceId, 'revert');
	};

	RevertResourceService.prototype = new AbstractXtextService();

	RevertResourceService.prototype.revertResource = function(editorContext, params) {
		var serverData = {
			contentType: params.contentType
		};
		
		var self = this;
		this.sendRequest(editorContext, {
			type: 'POST',
			data: serverData,
			success: function(result) {
				editorContext.setText(result.fullText);
				editorContext.clearUndoStack();
				editorContext.markClean(!result.dirty);
				var listeners = editorContext.updateServerState(result.fullText, result.stateId);
				for (var i = 0; i < listeners.length; i++) {
					listeners[i]();
				}
			}
		});
	};
	
	return RevertResourceService;
});