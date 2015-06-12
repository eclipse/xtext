/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

define([
	"xtext/MockEditorContext",
	"xtext/services/LoadResourceService",
	"xtext/services/RevertResourceService",
	"xtext/services/SaveResourceService",
	"xtext/services/UpdateService",
	"xtext/services/ContentAssistService",
	"xtext/services/ValidationService"
], function(EditorContext, LoadResourceService, RevertResourceService, SaveResourceService,
		UpdateService, ContentAssistService, ValidationService) {
	
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
	
	exports.createEditor = function(options) {
		if (!options)
			options = {};
		var editorContext = new EditorContext();
		exports.configureServices(editorContext, options);
		return editorContext;
	}
	
	exports.configureServices = function(editorContext, options) {
		if (!options.xtextLang && options.resourceId)
			options.xtextLang = options.resourceId.split('.').pop();
		
		editorContext.getOptions = function() {
			return options;
		};
		
		//---- Persistence Services
		
		if (!options.serverUrl)
			options.serverUrl = "http://" + location.host + "/xtext-service";
		var loadResourceService = undefined, saveResourceService = undefined, revertResourceService = undefined;
		if (options.resourceId) {
			if (options.loadFromServer === undefined || options.loadFromServer) {
				options.loadFromServer = true;
				loadResourceService = new LoadResourceService(options.serverUrl, options.resourceId);
				loadResourceService.loadResource(editorContext, options);
				saveResourceService = new SaveResourceService(options.serverUrl, options.resourceId);
				revertResourceService = new RevertResourceService(options.serverUrl, options.resourceId);
			}
		} else {
			if (options.loadFromServer === undefined)
				options.loadFromServer = false;
			if (options.xtextLang)
				options.resourceId = "text." + options.xtextLang;
		}
		
		//---- Validation Service
		
		var validationService;
		if (options.enableValidationService || options.enableValidationService === undefined) {
			validationService = new ValidationService(options.serverUrl, options.resourceId);
		}
		
		//---- Update Service
		
		function refreshDocument() {
			editorContext.clearClientServiceState();
			if (validationService)
				validationService.computeProblems(editorContext, options);
		}
		var updateService = undefined;
		if (!options.sendFullText) {
			updateService = new UpdateService(options.serverUrl, options.resourceId);
			if (saveResourceService)
				saveResourceService.setUpdateService(updateService);
			editorContext.addServerStateListener(refreshDocument);
		}
		editorContext.addModelChangeListener(function(event) {
			if (options.sendFullText)
				refreshDocument();
			else
				updateService.update(editorContext, options);
		});
		
		//---- Content Assist Service
		
		if (options.enableContentAssistService || options.enableContentAssistService === undefined) {
			var contentAssistService = new ContentAssistService(options.serverUrl, options.resourceId);
			if (updateService)
				contentAssistService.setUpdateService(updateService);
			editorContext.triggerContentAssist = function() {
				var params = _copy(options);
				params.offset = editorContext.getCaretOffset();
				params.selection = editorContext.getSelection();
				return contentAssistService.computeContentAssist(editorContext, params);
			};
		}
		
		editorContext.invokeXtextService = function(service, invokeOptions) {
			var optionsCopy = _copy(options);
			for (var p in invokeOptions) {
				if (invokeOptions.hasOwnProperty(p)) {
					optionsCopy[p] = invokeOptions[p];
				}
			}
			if (service === "load" && loadResourceService)
				loadResourceService.loadResource(editorContext, optionsCopy);
			else if (service === "save" && saveResourceService)
				saveResourceService.saveResource(editorContext, optionsCopy);
			else if (service === "revert" && revertResourceService)
				revertResourceService.revertResource(editorContext, optionsCopy);
			else if (service === "validation" && validationService)
				validationService.computeProblems(editorContext, optionsCopy);
			else
				throw "Service '" + service + "' is not available.";
		};
		editorContext.xtextServiceSuccessListeners = [];
		editorContext.xtextServiceErrorListeners = [];
	}
	
	exports.invokeService = function(editorContext, service, invokeOptions) {
		if (editorContext.invokeXtextService)
			editorContext.invokeXtextService(service, invokeOptions);
		else
			throw "The editor has not been configured with Xtext.";
	}
	
	return exports;
});

