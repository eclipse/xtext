/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/

define(['xtext/services/XtextService', 'jquery'], function(XtextService, jQuery) {
	
	/**
	 * Service class for hover information.
	 */
	function HoverService(serviceUrl, resourceId, updateService) {
		this.initialize(serviceUrl, 'hover', resourceId, updateService);
	};

	HoverService.prototype = new XtextService();

	HoverService.prototype._initServerData = function(serverData, editorContext, params) {
		// In order to display hover info for a selected completion proposal while the content
		// assist popup is shown, the selected proposal is passed as parameter
		if (params.proposal && params.proposal.proposal)
			serverData.proposal = params.proposal.proposal;
		if (params.offset)
			serverData.caretOffset = params.offset;
		else
			serverData.caretOffset = editorContext.getCaretOffset();
		var selection = params.selection ? params.selection : editorContext.getSelection();
		if (selection.start != serverData.caretOffset || selection.end != serverData.caretOffset) {
			serverData.selectionStart = selection.start;
			serverData.selectionEnd = selection.end;
		}
	};
	
	HoverService.prototype._getSuccessCallback = function(editorContext, params, deferred) {
		var delay = params.mouseHoverDelay;
		if (!delay)
			delay = 500;
		var showTime = new Date().getTime() + delay;
		return function(result) {
			if (result.conflict || !result.title && !result.content) {
				deferred.reject();
			} else {
				var remainingTimeout = Math.max(0, showTime - new Date().getTime());
				setTimeout(function() {
					if (!params.sendFullText && result.stateId !== undefined
							&& result.stateId != editorContext.getServerState().stateId) 
						deferred.reject();
					else
						deferred.resolve(result);
				}, remainingTimeout);
			}
		};
	};
	
	return HoverService;
});