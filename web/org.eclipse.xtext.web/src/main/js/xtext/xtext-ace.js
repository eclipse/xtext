/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

/*
 * Use `createEditor(options)` to create an Xtext editor. You can specify options either
 * through the function parameter or through `data-editor-x` attributes, where x is an
 * option name with camelCase converted to hyphen-separated.
 * The following options are available:
 *
 * enableContentAssistService = true {Boolean}
 *     Whether content assist should be enabled.
 * enableValidationService = true {Boolean}
 *     Whether validation should be enabled.
 * parent {String | DOMElement}
 *     The parent element for the view; it can be either a DOM element or an ID for a DOM element.
 * xtextLang {String}
 *     The language name (usually the file extension configured for the language).
 */
define([
    "jquery",
    "ace/ext/language_tools",
	"xtext/AceEditorContext",
	"xtext/services/ContentAssistService",
	"xtext/services/ValidationService"
], function(jQuery, languageTools, EditorContext, ContentAssistService, ValidationService) {
	
	/**
	 * Create a copy of the given object.
	 */
	function _copy(obj) {
		var copy = {};
		for (var p in obj) {
			if (obj.hasOwnProperty(p))
				copy[p] = obj[p];
		}
		return copy;
	}
	
	var exports = {};
	
	/**
	 * Create an Xtext editor instance configured with the given options.
	 */
	exports.createEditor = function(options) {
		if (!options.parent)
			options.parent = "xtext-editor";
		
		var editor = ace.edit(options.parent);
		editor.$blockScrolling = Infinity;
		
		exports.configureServices(editor, options);
		
		return editor;
	}
	
	/**
	 * Configure Xtext services for the given editor.
	 */
	exports.configureServices = function(editor, options) {
		if (!options.xtextLang && options.lang)
			options.xtextLang = options.lang
		if (!options.xtextLang && options.resourceId)
			options.xtextLang = options.resourceId.split('.').pop();
	
		var editorContext = new EditorContext(editor);
		editor.getEditorContext = function() {
			return editorContext;
		};
		
		var serverUrl = options.serverUrl;
		if (!serverUrl) {
			serverUrl = "http://" + location.host + "/xtext-service";
		}
		var resourceId = options.resourceId;
		if (resourceId) {
		} else {
			if (options.xtextLang)
				resourceId = "text." + options.xtextLang;
		}
		
		//---- Syntax Highlighting Service
		
		if (options.syntaxDefinition || options.xtextLang) {
			var syntaxDefinition = options.syntaxDefinition;
			if (!syntaxDefinition)
				syntaxDefinition = "xtext/mode-" + options.xtextLang;
			require([syntaxDefinition], function(mode) {
				editor.getSession().setMode(new mode.Mode);
			});
		}
		
		//---- Validation Service
		
		var validationService;
		if (options.enableValidationService || options.enableValidationService === undefined) {
			validationService = new ValidationService(serverUrl, resourceId);
		}
		
		//---- Update Service
		
		function refreshDocument() {
			editorContext.clearClientServiceState();
			if (validationService)
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
		
		//---- Content Assist Service
		
		if (options.enableContentAssistService || options.enableContentAssistService === undefined) {
			editor.setOptions({ enableBasicAutocompletion: true });
			var contentAssistService = new ContentAssistService(serverUrl, resourceId);
			var completer = {
		        getCompletions: function(editor, session, pos, prefix, callback) {
		        	var params = _copy(options);
		        	var document = session.getDocument();
		        	params.offset = document.positionToIndex(pos);
		        	var range = editor.getSelectionRange();
		        	params.selection = {
		        		start: document.positionToIndex(range.start),
		        		end: document.positionToIndex(range.end)
		        	};
		        	contentAssistService.computeContentAssist(editorContext, params).done(function(proposals) {
		        		callback(null, proposals);
		        	});
		        }
		    }
			languageTools.addCompleter(completer);
		}
	}
	
	return exports;
});

