/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

define(["xtext/services/AbstractXtextService"], function(AbstractXtextService) {
	
	function SaveResourceService(serverUrl, resourceUri) {
		this.initialize(serverUrl, resourceUri, "save");
	};

	SaveResourceService.prototype = new AbstractXtextService();

	SaveResourceService.prototype.saveResource = function(editorContext, params) {
		var serverData = {
			contentType : params.contentType
		};
		if (params.sendFullText) {
			serverData.fullText = editorContext.getText();
		}
		
		this.sendRequest(editorContext, {
			type : "POST",
			data : serverData,
			success : function(result) {
				editorContext.markClean(true);
			}
		});
	};
	
	return SaveResourceService;
});