/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

define(['xtext/services/XtextService', 'jquery'], function(XtextService, jQuery) {
	
	/**
	 * Service class for formatting text.
	 */
	function FormattingService(serviceUrl, resourceId, updateService) {
		this.initialize(serviceUrl, 'format', resourceId, updateService);
	};

	FormattingService.prototype = new XtextService();

	FormattingService.prototype._initServerData = function(serverData, editorContext, params) {
		var selection = params.selection ? params.selection : editorContext.getSelection();
		if (selection.end > selection.start) {
			serverData.selectionStart = selection.start;
			serverData.selectionEnd = selection.end;
		}
		return {
			httpMethod: 'POST'
		};
	};
	
	FormattingService.prototype._processResult = function(result, editorContext) {
		if (result.replaceRegion)
			editorContext.setText(result.formattedText, result.replaceRegion.offset,
					result.replaceRegion.offset + result.replaceRegion.length);
		else
			editorContext.setText(result.formattedText);
		var listeners = editorContext.updateServerState(editorContext.getText(), result.stateId);
		for (var i = 0; i < listeners.length; i++) {
			listeners[i]({});
		}
	};
	
	return FormattingService;
});