/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

define([
	'jquery',
    'xtext/compatibility',
	'xtext/MockEditorContext',
	'xtext/services/XtextService',
	'xtext/services/LoadResourceService',
	'xtext/services/SaveResourceService',
	'xtext/services/UpdateService',
	'xtext/services/ContentAssistService',
	'xtext/services/HighlightingService',
	'xtext/services/ValidationService',
	'xtext/services/HoverService',
	'xtext/services/OccurrencesService',
	'xtext/services/FormattingService'
], function(mjQuery, compatibility, EditorContext, XtextService, LoadResourceService,
		SaveResourceService, UpdateService, ContentAssistService, HighlightingService,
		ValidationService, HoverService, OccurrencesService, FormattingService) {
	
	function _copy(obj) {
		var copy = {};
		for (var p in obj) {
			if (obj.hasOwnProperty(p))
				copy[p] = obj[p];
		}
		return copy;
	}
	
	function Tester(editorContext, doneCallback) {
		this._editorContext = editorContext;
		this._doneCallback = doneCallback;
		mjQuery.reset();
	}
	
	Tester.prototype = {
			
		setup: function(setupAction) {
			setupAction(this._editorContext);
			return this;
		},
		
		setText: function(text, start, end) {
			this._editorContext.setText(text, start, end);
			return this;
		},
		
		setCaretOffset: function(offset) {
			this._editorContext.setCaretOffset(offset);
			return this;
		},
		
		markClean: function(clean) {
			this._editorContext.markClean(clean);
			return this;
		},
		
		invokeService: function(service, invokeOptions) {
			var result = this._editorContext.invokeXtextService(service, invokeOptions);
			if (result !== undefined)
				this._lastResult = result;
			return this;
		},
			
		triggerModelChange: function(text, start, end) {
			this._editorContext.setText(text, start, end);
			var listeners = this._editorContext.getModelChangeListeners();
			for (var i = 0; i < listeners.length; i++) {
				var listener = listeners[i];
				listener(text);
			}
			return this;
		},
		
		checkResult: function(checker) {
			var self = this;
			if (self._lastResult) {
				if (self._lastResult.done)
					self._lastResult.done(function(result) {
						checker(self._editorContext, result);
					});
				else
					checker(self._editorContext, self._lastResult);
			} else
				checker(self._editorContext);
			return this;
		},
		
		checkRequest: function(checker) {
			var request = mjQuery.getNextRequest();
			if (request) {
				checker(request.url, request.settings);
			}
			return this;
		},
		
		respond: function(result) {
			mjQuery.respond(result);
			return this;
		},
		
		httpError: function(errorThrown, xhr) {
			mjQuery.httpError(errorThrown, xhr);
			return this;
		},
		
		done: function() {
			this._doneCallback();
		}
	
	}
	
	var exports = {};
	
	exports.testEditor = function(options) {
		if (!options)
			options = {};
		var editorContext = exports.createEditor(options);
		return new Tester(editorContext, options.doneCallback);
	}
	
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
			options.serverUrl = 'test://xtext-service';
		var loadResourceService, saveResourceService, revertResourceService;
		if (options.resourceId) {
			if (options.loadFromServer === undefined || options.loadFromServer) {
				options.loadFromServer = true;
				loadResourceService = new LoadResourceService(options.serverUrl, options.resourceId, false);
				loadResourceService.loadResource(editorContext, options);
				saveResourceService = new SaveResourceService(options.serverUrl, options.resourceId);
				revertResourceService = new LoadResourceService(options.serverUrl, options.resourceId, true);
			}
		} else {
			if (options.loadFromServer === undefined)
				options.loadFromServer = false;
			if (options.xtextLang)
				options.resourceId = 'text.' + options.xtextLang;
		}
		
		//---- Highlighting Service
		
		var highlightingService;
		if (options.enableHighlightingService || options.enableHighlightingService === undefined) {
			highlightingService = new HighlightingService(options.serverUrl, options.resourceId)
		}
		
		//---- Validation Service
		
		var validationService;
		if (options.enableValidationService || options.enableValidationService === undefined) {
			validationService = new ValidationService(options.serverUrl, options.resourceId);
		}
		
		//---- Update Service
		
		function refreshDocument() {
			if (highlightingService) {
				highlightingService.setState(undefined);
				highlightingService.computeHighlighting(editorContext, options);
			}
			if (validationService) {
				validationService.setState(undefined);
				validationService.computeProblems(editorContext, options);
			}
		}
		var updateService;
		if (!options.sendFullText) {
			updateService = new UpdateService(options.serverUrl, options.resourceId);
			if (saveResourceService)
				saveResourceService._updateService = updateService;
			editorContext.addServerStateListener(refreshDocument);
		}
		editorContext.addModelChangeListener(function(event) {
			if (options.sendFullText)
				refreshDocument();
			else
				updateService.update(editorContext, options);
		});
		
		//---- Content Assist Service
		
		var contentAssistService;
		if (options.enableContentAssistService || options.enableContentAssistService === undefined) {
			contentAssistService = new ContentAssistService(options.serverUrl, options.resourceId, updateService);
		}
		
		//---- Hover Service
		
		var hoverService;
		if (options.enableHoverService || options.enableHoverService === undefined) {
			hoverService = new HoverService(options.serverUrl, options.resourceId, updateService);
		}
		
		//---- Occurrences Service
		
		var occurrencesService;
		if (options.enableOccurrencesService || options.enableOccurrencesService === undefined) {
			occurrencesService = new OccurrencesService(options.serverUrl, options.resourceId, updateService);
		}
		
		//---- Formatting Service
		
		var formattingService;
		if (options.enableFormattingService || options.enableFormattingService === undefined) {
			formattingService = new FormattingService(options.serverUrl, options.resourceId, updateService);
		}
		
		//---- Generator Service
		
		var generatorService;
		if (options.enableGeneratorService || options.enableGeneratorService === undefined) {
			generatorService = new XtextService();
			generatorService.initialize(options.serverUrl, options.resourceId, 'generate', updateService);
		}
		
		editorContext.invokeXtextService = function(service, invokeOptions) {
			var optionsCopy = _copy(options);
			for (var p in invokeOptions) {
				if (invokeOptions.hasOwnProperty(p)) {
					optionsCopy[p] = invokeOptions[p];
				}
			}
			if (service === 'load' && loadResourceService)
				return loadResourceService.loadResource(editorContext, optionsCopy);
			else if (service === 'save' && saveResourceService)
				return saveResourceService.saveResource(editorContext, optionsCopy);
			else if (service === 'revert' && revertResourceService)
				return revertResourceService.loadResource(editorContext, optionsCopy);
			else if (service === 'update' && updateService)
				return updateService.update(editorContext, optionsCopy);
			else if (service === 'highlight' && highlightingService)
				return highlightingService.computeHighlighting(editorContext, optionsCopy);
			else if (service === 'validate' && validationService)
				return validationService.computeProblems(editorContext, optionsCopy);
			else if (service === 'assist' && contentAssistService) {
				optionsCopy.offset = editorContext.getCaretOffset();
				optionsCopy.selection = editorContext.getSelection();
				return contentAssistService.computeContentAssist(editorContext, optionsCopy);
			} else if (service === 'hover' && hoverService)
				return hoverService.computeHoverInfo(editorContext, options);
			else if (service === 'occurrences' && occurrencesService)
				return occurrencesService.getOccurrences(editorContext, optionsCopy);
			else if (service === 'format' && formattingService)
				return formattingService.format(editorContext, options);
			else if (service === 'generate' && generatorService)
				return generatorService.invoke(editorContext, options);
			else
				throw new Error('Service \'' + service + '\' is not available.');
		};
		editorContext.xtextServiceSuccessListeners = [];
		editorContext.xtextServiceErrorListeners = [];
	}
	
	return exports;
});

