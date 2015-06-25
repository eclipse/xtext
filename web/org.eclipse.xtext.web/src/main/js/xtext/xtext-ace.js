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
 * dirtyElement {String | DOMElement}
 *     An element into which the dirty status class is written when the editor is marked dirty;
 *     it can be either a DOM element or an ID for a DOM element.
 * dirtyStatusClass = 'dirty' {String}
 *     A CSS class name written into the dirtyElement when the editor is marked dirty.
 * enableContentAssistService = true {Boolean}
 *     Whether content assist should be enabled.
 * enableOccurrencesService = true {Boolean}
 *     Whether marking occurrences should be enabled.
 * enableSaveAction = false {Boolean}
 *     Whether the save action should be bound to the standard keystroke ctrl+s / cmd+s.
 * enableValidationService = true {Boolean}
 *     Whether validation should be enabled.
 * loadFromServer = true {Boolean}
 *     Whether to load the editor content from the server.
 * parent {String | DOMElement}
 *     The parent element for the view; it can be either a DOM element or an ID for a DOM element.
 * sendFullText = false {Boolean}
 *     Whether the full text shall be sent to the server with each request; use this if you want
 *     the server to run in stateless mode. If the option is inactive, the server state is updated regularly.
 * selectionUpdateDelay = 550 {Number}
 *     The number of milliseconds to wait after a selection change before Xtext services are invoked.
 * showErrorDialogs = false {Boolean}
 *     Whether errors should be displayed in popup dialogs.
 * textUpdateDelay = 500 {Number}
 *     The number of milliseconds to wait after a text change before Xtext services are invoked.
 * theme {String}
 *     The path name of the Ace theme for the editor.
 * xtextLang {String}
 *     The language name (usually the file extension configured for the language).
 */
define([
    'jquery',
    'ace/ace',
    'ace/ext/language_tools',
	'xtext/AceEditorContext',
	'xtext/services/LoadResourceService',
	'xtext/services/RevertResourceService',
	'xtext/services/SaveResourceService',
	'xtext/services/UpdateService',
	'xtext/services/ContentAssistService',
	'xtext/services/ValidationService',
	'xtext/services/OccurrencesService'
], function(jQuery, ace, languageTools, EditorContext, LoadResourceService, RevertResourceService,
		SaveResourceService, UpdateService, ContentAssistService, ValidationService, OccurrencesService) {
	
	/**
	 * Add a problem marker to an editor session.
	 */
	function _addMarker(session, startOffset, endOffset, clazz, type) {
		var document = session.getDocument();
		var start = document.indexToPosition(startOffset);
		var end = document.indexToPosition(endOffset);
		var mRange = require('ace/range');
		var range = new mRange.Range(start.row, start.column, end.row, end.column);
		return session.addMarker(range, 'xtext-marker_' + clazz, 'text');
	}
	
	/**
	 * Translate an HTML attribute name to a JS option name.
	 */
	function _optionName(name) {
		var prefix = 'data-editor-';
		if (name.substring(0, prefix.length) === prefix) {
			var key = name.substring(prefix.length);
			key = key.replace(/-([a-z])/ig, function(all, character) {
				return character.toUpperCase();
			});
			return key;
		}
		return undefined;
	}
	
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
	
	/**
	 * Merge all properties of the given parent element with the given default options.
	 */
	function _mergeOptions(parent, defaultOptions) {
		var options = _copy(defaultOptions);
		for (var attr, j = 0, attrs = parent.attributes, l = attrs.length; j < l; j++) {
			attr = attrs.item(j);
			var key = _optionName(attr.nodeName);
			if (key) {
				var value = attr.nodeValue;
				if (value === 'true' || value === 'false')
					value = value === 'true';
				options[key] = value;
			}
		}
		return options;
	}
	
	/**
	 * Set the default options for Xtext editors.
	 */
	function _setDefaultOptions(options) {
		if (!options.xtextLang && options.lang)
			options.xtextLang = options.lang
		if (!options.xtextLang && options.resourceId)
			options.xtextLang = options.resourceId.split('.').pop();
		if (!options.theme)
			options.theme = 'ace/theme/eclipse';
	}
	
	var exports = {};
	
	/**
	 * Create an Xtext editor instance configured with the given options.
	 */
	exports.createEditor = function(options) {
		if (!options)
			options = {};
		if (!options.parent)
			options.parent = 'xtext-editor';
		
		var parents;
		if (typeof(options.parent) === 'string') {
			var doc = options.document || document;
			var element = doc.getElementById(options.parent);
			if (element)
				parents = [element];
			else
				parents = doc.getElementsByClassName(options.parent);
		} else {
			parents = [options.parent];
		}
		
		var editors = [];
		for (var i = 0; i < parents.length; i++) {
			var editor = ace.edit(parents[i]);
			editor.$blockScrolling = Infinity;
			
			var editorOptions = _mergeOptions(parents[i], options);
			_setDefaultOptions(editorOptions);
			exports.configureServices(editor, editorOptions);
			editors[i] = editor;
		}
		
		if (editors.length == 1)
			return editors[0];
		else
			return editors;
	}
	
	/**
	 * Configure Xtext services for the given editor. The editor does not have to be created
	 * with createEditor(options).
	 */
	exports.configureServices = function(editor, options) {
		if (!options.xtextLang && options.lang)
			options.xtextLang = options.lang
		if (!options.xtextLang && options.resourceId)
			options.xtextLang = options.resourceId.split('.').pop();
		if (options.theme)
			editor.setTheme(options.theme)
		
		var editorContext = new EditorContext(editor);
		editor.getEditorContext = function() {
			return editorContext;
		};
		editor.getOptions = function() {
			return options;
		}
		if (options.dirtyElement) {
			var doc = options.document || document;
			var dirtyElement;
			if (typeof(options.dirtyElement) === 'string')
				dirtyElement = jQuery('#' + options.dirtyElement, doc);
			else
				dirtyElement = jQuery(options.dirtyElement);
			var dirtyStatusClass = options.dirtyStatusClass;
			if (!dirtyStatusClass)
				dirtyStatusClass = 'dirty';
			editorContext.addDirtyStateListener(function(clean) {
				if (clean)
					dirtyElement.removeClass(dirtyStatusClass);
				else
					dirtyElement.addClass(dirtyStatusClass);
			});
		}
		
		//---- Persistence Services
		
		if (!options.serverUrl)
			options.serverUrl = 'http://' + location.host + '/xtext-service';
		var loadResourceService = undefined, saveResourceService = undefined, revertResourceService = undefined;
		if (options.resourceId) {
			if (options.loadFromServer === undefined || options.loadFromServer) {
				options.loadFromServer = true;
				loadResourceService = new LoadResourceService(options.serverUrl, options.resourceId);
				loadResourceService.loadResource(editorContext, options);
				saveResourceService = new SaveResourceService(options.serverUrl, options.resourceId);
				if (options.enableSaveAction && editor.commands) {
					editor.commands.addCommand({
						name: 'save',
						bindKey: {win: 'Ctrl-S', mac: 'Command-S'},
						exec: function(editor) {
							saveResourceService.saveResource(editorContext, options);
						}
					});
				}
				revertResourceService = new RevertResourceService(options.serverUrl, options.resourceId);
			}
		} else {
			if (options.loadFromServer === undefined)
				options.loadFromServer = false;
			if (options.xtextLang)
				options.resourceId = 'text.' + options.xtextLang;
		}
		
		//---- Syntax Highlighting Service
		
		var session = editor.getSession();
		if (options.syntaxDefinition || options.xtextLang) {
			var syntaxDefinition = options.syntaxDefinition;
			if (!syntaxDefinition)
				syntaxDefinition = 'xtext/mode-' + options.xtextLang;
			require([syntaxDefinition], function(mode) {
				session.setMode(new mode.Mode);
			});
		}
		
		//---- Validation Service
		
		var validationService;
		if (options.enableValidationService || options.enableValidationService === undefined) {
			validationService = new ValidationService(options.serverUrl, options.resourceId);
		}
		
		//---- Update Service
		
		function refreshDocument() {
			editorContext.clearClientServiceState();
			if (validationService) {
				validationService.computeProblems(editorContext, options).always(function() {
					var annotations = editorContext._annotations;
					if (annotations) {
						for (var i = 0; i < annotations.length; i++) {
							var annotation = annotations[i];
							session.removeMarker(annotation.markerId);
						}
					}
					editorContext._annotations = [];
				}).done(function(entries) {
					for (var i = 0; i < entries.length; i++) {
						var entry = entries[i];
						var marker = _addMarker(session, entry.startOffset, entry.endOffset, entry.severity);
						var start = session.getDocument().indexToPosition(entry.startOffset);
						editorContext._annotations.push({
							row: start.row,
							column: start.column,
							text: entry.description,
							type: entry.severity,
							markerId: marker
						});
					}
					session.setAnnotations(editorContext._annotations);
				});
			}
		}
		var updateService = undefined;
		if (!options.sendFullText) {
			updateService = new UpdateService(options.serverUrl, options.resourceId);
			if (saveResourceService)
				saveResourceService.setUpdateService(updateService);
			editorContext.addServerStateListener(refreshDocument);
		}
		var textUpdateDelay = options.textUpdateDelay;
		if (!textUpdateDelay)
			textUpdateDelay = 500;
		function modelChangeListener(event) {
			if (!event.init)
				editorContext.markClean(false);
			if (editor._modelChangeTimeout){
				clearTimeout(editor._modelChangeTimeout);
			}
			editor._modelChangeTimeout = setTimeout(function() {
				if (options.sendFullText)
					refreshDocument();
				else
					updateService.update(editorContext, options);
			}, textUpdateDelay);
		};
		if (!options.resourceId || !options.loadFromServer) {
			modelChangeListener({init: true});
		}
		editor.on('change', modelChangeListener)
		
		//---- Content Assist Service
		
		if (options.enableContentAssistService || options.enableContentAssistService === undefined) {
			var contentAssistService = new ContentAssistService(options.serverUrl, options.resourceId);
			if (updateService)
				contentAssistService.setUpdateService(updateService);
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
					contentAssistService.computeContentAssist(editorContext, params).done(function(entries) {
						callback(null, entries.map(function(entry) {
			    			return {
			    				value: entry.proposal,
			    				caption: (entry.label ? entry.label: entry.proposal),
			    				meta: entry.description
			    			};
						}));
					});
				}
			}
			languageTools.setCompleters([completer]);
			editor.setOptions({ enableBasicAutocompletion: true });
		}
		
		//---- Occurrences Service
		
		var occurrencesService;
		if (options.enableOccurrencesService || options.enableOccurrencesService === undefined) {
			occurrencesService = new OccurrencesService(options.serverUrl, options.resourceId);
			if (updateService)
				occurrencesService.setUpdateService(updateService);
			var selectionUpdateDelay = options.selectionUpdateDelay;
			if (!selectionUpdateDelay)
				selectionUpdateDelay = 550;
			editor.getSelection().on('changeCursor', function() {
				if (editorContext._selectionChangeTimeout) {
					clearTimeout(editorContext._selectionChangeTimeout);
				}
				editorContext._selectionChangeTimeout = setTimeout(function() {
					var params = _copy(options);
					params.offset = session.getDocument().positionToIndex(editor.getSelection().getCursor());
					occurrencesService.markOccurrences(editorContext, params).always(function() {
						var occurrenceMarkers = editorContext._occurrenceMarkers;
						if (occurrenceMarkers) {
							for (var i = 0; i < occurrenceMarkers.length; i++)  {
								var marker = occurrenceMarkers[i];
								session.removeMarker(marker);
							}
						}
						editorContext._occurrenceMarkers = [];
					}).done(function(occurrencesResult) {
						for (var i = 0; i < occurrencesResult.readRegions.length; i++) {
							var region = occurrencesResult.readRegions[i];
							var marker = _addMarker(session, region.offset, region.offset + region.length, 'read');
							editorContext._occurrenceMarkers.push(marker);
						}
						for (var i = 0; i < occurrencesResult.writeRegions.length; i++) {
							var region = occurrencesResult.writeRegions[i];
							var marker = _addMarker(session, region.offset, region.offset + region.length, 'write');
							editorContext._occurrenceMarkers.push(marker);
						}
					});
				}, selectionUpdateDelay);
			});
		}
		
		editor.invokeXtextService = function(service, invokeOptions) {
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
				return revertResourceService.revertResource(editorContext, optionsCopy);
			else if (service === 'validation' && validationService)
				return validationService.computeProblems(editorContext, optionsCopy);
			else if (service === 'occurrences' && occurrencesService)
				return occurrencesService.markOccurrences(editorContext, optionsCopy);
			else
				throw new Error('Service \'' + service + '\' is not available.');
		};
		editor.xtextServiceSuccessListeners = [];
		editor.xtextServiceErrorListeners = [function(requestType, xhr, textStatus, errorThrown) {
			if (options.showErrorDialogs)
				window.alert('Xtext service \'' + requestType + '\' failed: ' + errorThrown);
			else
				console.log('Xtext service \'' + requestType + '\' failed: ' + errorThrown);
		}];
	}
	
	/**
	 * Invoke an Xtext service.
	 * 
	 * @param editor
	 *     The editor for which the service shall be invoked.
	 * @param service
	 *     A service type identifier, e.g. 'save'.
	 * @param invokeOptions
	 *     Additional options to pass to the service (optional).
	 */
	exports.invokeService = function(editor, service, invokeOptions) {
		if (editor.invokeXtextService)
			editor.invokeXtextService(service, invokeOptions);
		else
			throw new Error('The editor has not been configured with Xtext.');
	}
	
	return exports;
});

