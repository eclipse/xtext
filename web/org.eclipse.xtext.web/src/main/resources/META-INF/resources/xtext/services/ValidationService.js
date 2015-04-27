/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

define(["xtext/services/AbstractXtextService"], function(AbstractXtextService) {
	
	function ValidationService(serverUrl, resourceUri) {
		this.initialize(serverUrl, resourceUri, "validation");
	};
	
	ValidationService.prototype = new AbstractXtextService();

	ValidationService.prototype.computeProblems = function(editorContext, params) {
		var serverData = {
			contentType : params.contentType
		};
		var httpMethod = "GET";
		if (params.sendFullText) {
			serverData.fullText = editorContext.getText();
			httpMethod = "POST";
		}
		
		this.sendRequest(editorContext, {
			type : httpMethod,
			data : serverData,
			success : function(result) {
				var problems = [];
				for (var i = 0; i < result.entries.length; i++) {
					var e = result.entries[i];
					problems.push({
						description : e.description,
						start : e.startOffset,
						end : e.endOffset,
						severity : e.severity
					});
				}
				editorContext.showMarkers(problems)
			}
		});
	};
	
	return ValidationService;
});