/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

define([
    "jquery",
	"xtext/AceEditorContext",
	"xtext/services/ValidationService"
], function(jQuery, EditorContext, ValidationService) {
	
	var exports = {};
	
	/**
	 * Configure Xtext services for the given editor.
	 */
	exports.configureServices = function(editor, options) {
		var editorContext = new EditorContext(editor);
		editor.getEditorContext = function() {
			return editorContext;
		};
		
		var serverUrl = options.serverUrl;
		if (!serverUrl) {
			serverUrl = "http://" + location.host + "/xtext-service";
		}
		var lang = options.lang;
		var resourceId = options.resourceId;
		if (resourceId) {
			if (!lang) {
				lang = resourceId.split('.').pop();
			}
		} else {
			if (lang) {
				resourceId = "text." + lang;
			}
		}
		
		var validationService = new ValidationService(serverUrl, resourceId);
		
		function refreshDocument() {
			editorContext.clearClientServiceState();
			validationService.computeProblems(editorContext, options);
		}
		function modelChangeListener(event) {
			if (editor._modelChangeTimeout){
				clearTimeout(editor._modelChangeTimeout);
			}
			editor._modelChangeTimeout = setTimeout(function() {
				refreshDocument();
			}, 500);
		};
		editor.on("change", modelChangeListener)
	}
	
	return exports;
});

