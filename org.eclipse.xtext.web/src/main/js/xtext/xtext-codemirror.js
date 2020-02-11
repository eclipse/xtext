/*******************************************************************************
 * Copyright (c) 2015, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/

/*
 * Use `createEditor(options)` to create an Xtext editor. You can specify options either
 * through the function parameter or through `data-editor-x` attributes, where x is an
 * option name with camelCase converted to hyphen-separated.
 * In addition to the options supported by CodeMirror (https://codemirror.net/doc/manual.html#config),
 * the following options are available:
 *
 * baseUrl = "/" {String}
 *     The path segment where the Xtext service is found; see serviceUrl option.
 * contentType {String}
 *     The content type included in requests to the Xtext server.
 * dirtyElement {String | DOMElement}
 *     An element into which the dirty status class is written when the editor is marked dirty;
 *     it can be either a DOM element or an ID for a DOM element.
 * dirtyStatusClass = 'dirty' {String}
 *     A CSS class name written into the dirtyElement when the editor is marked dirty.
 * document {Document}
 *     The document; if not specified, the global document is used.
 * enableContentAssistService = true {Boolean}
 *     Whether content assist should be enabled.
 * enableCors = true {Boolean}
 *     Whether CORS should be enabled for service request.
 * enableFormattingAction = false {Boolean}
 *     Whether the formatting action should be bound to the standard keystroke ctrl+shift+s / cmd+shift+f.
 * enableFormattingService = true {Boolean}
 *     Whether text formatting should be enabled.
 * enableGeneratorService = true {Boolean}
 *     Whether code generation should be enabled (must be triggered through JavaScript code).
 * enableHighlightingService = true {Boolean}
 *     Whether semantic highlighting (computed on the server) should be enabled.
 * enableOccurrencesService = true {Boolean}
 *     Whether marking occurrences should be enabled.
 * enableSaveAction = false {Boolean}
 *     Whether the save action should be bound to the standard keystroke ctrl+s / cmd+s.
 * enableValidationService = true {Boolean}
 *     Whether validation should be enabled.
 * loadFromServer = true {Boolean}
 *     Whether to load the editor content from the server.
 * mode {String}
 *     The name of the syntax highlighting mode to use; the mode has to be registered externally
 *     (see CodeMirror documentation).
 * parent = 'xtext-editor' {String | DOMElement}
 *     The parent element for the view; it can be either a DOM element or an ID for a DOM element.
 * parentClass = 'xtext-editor' {String}
 *     If the 'parent' option is not given, this option is used to find elements that match the given class name.
 * resourceId {String}
 *     The identifier of the resource displayed in the text editor; this option is sent to the server to
 *     communicate required information on the respective resource.
 * selectionUpdateDelay = 550 {Number}
 *     The number of milliseconds to wait after a selection change before Xtext services are invoked.
 * sendFullText = false {Boolean}
 *     Whether the full text shall be sent to the server with each request; use this if you want
 *     the server to run in stateless mode. If the option is inactive, the server state is updated regularly.
 * serviceUrl {String}
 *     The URL of the Xtext servlet; if no value is given, it is constructed using the baseUrl option in the form
 *     {location.protocol}//{location.host}{baseUrl}xtext-service
 * showErrorDialogs = false {Boolean}
 *     Whether errors should be displayed in popup dialogs.
 * syntaxDefinition {String}
 *     If the 'mode' option is not set, the default mode 'xtext/{xtextLang}' is used. Set this option to
 *     'none' to suppress this behavior and disable syntax highlighting.
 * textUpdateDelay = 500 {Number}
 *     The number of milliseconds to wait after a text change before Xtext services are invoked.
 * xtextLang {String}
 *     The language name (usually the file extension configured for the language).
 */
define([
    'jquery',
    'codemirror',
    'codemirror/addon/hint/show-hint',
    'xtext/compatibility',
    'xtext/ServiceBuilder',
	'xtext/CodeMirrorEditorContext',
	'codemirror/mode/javascript/javascript'
], function(jQuery, CodeMirror, ShowHint, compatibility, ServiceBuilder, EditorContext) {
	
	var exports = {};
	
	/**
	 * Create one or more Xtext editor instances configured with the given options.
	 * The return value is either a CodeMirror editor or an array of CodeMirror editors.
	 */
	exports.createEditor = function(options) {
		if (!options)
			options = {};
		
		var query;
		if (jQuery.type(options.parent) === 'string') {
			query = jQuery('#' + options.parent, options.document);
		} else if (options.parent) {
			query = jQuery(options.parent);
		} else if (jQuery.type(options.parentClass) === 'string') {
			query = jQuery('.' + options.parentClass, options.document);
		} else {
			query = jQuery('#xtext-editor', options.document);
			if (query.length == 0)
				query = jQuery('.xtext-editor', options.document);
		}
		
		var editors = [];
		query.each(function(index, parent) {
			var editorOptions = ServiceBuilder.mergeParentOptions(parent, options);
			if (!editorOptions.value)
				editorOptions.value = jQuery(parent).text();
			var editor = CodeMirror(function(element) {
				jQuery(parent).empty().append(element);
			}, editorOptions);
			
			exports.createServices(editor, editorOptions);
			editors[index] = editor;
		});
		
		if (editors.length == 1)
			return editors[0];
		else
			return editors;
	}
	
	function CodeMirrorServiceBuilder(editor, xtextServices) {
		this.editor = editor;
		xtextServices.editorContext._highlightingMarkers = [];
		xtextServices.editorContext._validationMarkers = [];
		xtextServices.editorContext._occurrenceMarkers = [];
		ServiceBuilder.call(this, xtextServices);
	}
	CodeMirrorServiceBuilder.prototype = new ServiceBuilder();
		
	/**
	 * Configure Xtext services for the given editor. The editor does not have to be created
	 * with createEditor(options).
	 */
	exports.createServices = function(editor, options) {
		if (options.enableValidationService || options.enableValidationService === undefined) {
			editor.setOption('gutters', ['annotations-gutter']);
		}
		var xtextServices = {
			options: options,
			editorContext: new EditorContext(editor)
		};
		var serviceBuilder = new CodeMirrorServiceBuilder(editor, xtextServices);
		serviceBuilder.createServices();
		xtextServices.serviceBuilder = serviceBuilder;
		editor.xtextServices = xtextServices;
		return xtextServices;
	}
	
	/**
	 * Remove all services and listeners that have been previously created with createServices(editor, options).
	 */
	exports.removeServices = function(editor) {
		if (!editor.xtextServices)
			return;
		var services = editor.xtextServices;
		if (services.modelChangeListener)
			editor.off('changes', services.modelChangeListener);
		if (services.cursorActivityListener)
			editor.off('cursorActivity', services.cursorActivityListener);
		if (services.saveKeyMap)
			editor.removeKeyMap(services.saveKeyMap);
		if (services.contentAssistKeyMap)
			editor.removeKeyMap(services.contentAssistKeyMap);
		if (services.formatKeyMap)
			editor.removeKeyMap(services.formatKeyMap);
		var editorContext = services.editorContext;
		var highlightingMarkers = editorContext._highlightingMarkers;
		if (highlightingMarkers) {
			for (var i = 0; i < highlightingMarkers.length; i++) {
				highlightingMarkers[i].clear();
			}
		}
		if (editorContext._validationAnnotations)
			services.serviceBuilder._clearAnnotations(editorContext._validationAnnotations);
		var validationMarkers = editorContext._validationMarkers;
		if (validationMarkers) {
			for (var i = 0; i < validationMarkers.length; i++) {
				validationMarkers[i].clear();
			}
		}
		var occurrenceMarkers = editorContext._occurrenceMarkers;
		if (occurrenceMarkers) {
			for (var i = 0; i < occurrenceMarkers.length; i++)  {
				occurrenceMarkers[i].clear();
			}
		}
		delete editor.xtextServices;
	}
	
	/**
	 * Syntax highlighting (without semantic highlighting).
	 */
	CodeMirrorServiceBuilder.prototype.setupSyntaxHighlighting = function() {
		var options = this.services.options;
		// If the mode option is set, syntax highlighting has already been configured by CM
		if (!options.mode && options.syntaxDefinition != 'none' && options.xtextLang) {
			this.editor.setOption('mode', 'xtext/' + options.xtextLang);
		}
	}
		
	/**
	 * Document update service.
	 */
	CodeMirrorServiceBuilder.prototype.setupUpdateService = function(refreshDocument) {
		var services = this.services;
		var editorContext = services.editorContext;
		var textUpdateDelay = services.options.textUpdateDelay;
		if (!textUpdateDelay)
			textUpdateDelay = 500;
		services.modelChangeListener = function(event) {
			if (!event._xtext_init)
				editorContext.setDirty(true);
			if (editorContext._modelChangeTimeout)
				clearTimeout(editorContext._modelChangeTimeout);
			editorContext._modelChangeTimeout = setTimeout(function() {
				if (services.options.sendFullText)
					refreshDocument();
				else
					services.update();
			}, textUpdateDelay);
		}
		if (!services.options.resourceId || !services.options.loadFromServer)
			services.modelChangeListener({_xtext_init: true});
		this.editor.on('changes', services.modelChangeListener);
	}
	
	/**
	 * Persistence services: load, save, and revert.
	 */
	CodeMirrorServiceBuilder.prototype.setupPersistenceServices = function() {
		var services = this.services;
		if (services.options.enableSaveAction) {
			var userAgent = navigator.userAgent.toLowerCase();
			var saveFunction = function(editor) {
				services.saveResource();
			};
			services.saveKeyMap = /mac os/.test(userAgent) ? {'Cmd-S': saveFunction}: {'Ctrl-S': saveFunction};
			this.editor.addKeyMap(services.saveKeyMap);
		}
	}
		
	/**
	 * Content assist service.
	 */
	CodeMirrorServiceBuilder.prototype.setupContentAssistService = function() {
		var services = this.services;
		var editorContext = services.editorContext;
		services.contentAssistKeyMap = {'Ctrl-Space': function(editor) {
			var params = ServiceBuilder.copy(services.options);
			var cursor = editor.getCursor();
			params.offset = editor.indexFromPos(cursor);
			services.contentAssistService.invoke(editorContext, params).done(function(entries) {
				editor.showHint({hint: function(editor, options) {
					return {
						list: entries.map(function(entry) {
							var displayText;
							if (entry.label)
								displayText = entry.label;
							else
								displayText = entry.proposal;
							if (entry.description)
								displayText += ' (' + entry.description + ')';
							var prefixLength = 0
							if (entry.prefix)
								prefixLength = entry.prefix.length
			    			return {
			    				text: entry.proposal,
			    				displayText: displayText,
			    				from: {
			    					line: cursor.line,
			    					ch: cursor.ch - prefixLength
			    				}
			    			};
						}),
						to: cursor
					};
				}});
			});
		}};
		this.editor.addKeyMap(services.contentAssistKeyMap);
	}
		
	/**
	 * Semantic highlighting service.
	 */
	CodeMirrorServiceBuilder.prototype.doHighlighting = function() {
		var services = this.services;
		var editorContext = services.editorContext;
		var editor = this.editor;
		services.computeHighlighting().always(function() {
			var highlightingMarkers = editorContext._highlightingMarkers;
			if (highlightingMarkers) {
				for (var i = 0; i < highlightingMarkers.length; i++) {
					highlightingMarkers[i].clear();
				}
			}
			editorContext._highlightingMarkers = [];
		}).done(function(result) {
			for (var i = 0; i < result.regions.length; ++i) {
				var region = result.regions[i];
				var from = editor.posFromIndex(region.offset);
				var to = editor.posFromIndex(region.offset + region.length);
				region.styleClasses.forEach(function(styleClass) {
					var marker =  editor.markText(from, to, {className: styleClass});
					editorContext._highlightingMarkers.push(marker);
				});
			}
		});
	}
	
	var annotationWeight = {
		error: 30,
		warning: 20,
		info: 10
	};
	CodeMirrorServiceBuilder.prototype._getAnnotationWeight = function(annotation) {
		if (annotationWeight[annotation] !== undefined)
			return annotationWeight[annotation];
		else
			return 0;
	}
	
	CodeMirrorServiceBuilder.prototype._clearAnnotations = function(annotations) {
		var editor = this.editor;
		for (var i = 0; i < annotations.length; i++) {
			var annotation = annotations[i];
			if (annotation) {
				editor.setGutterMarker(i, 'annotations-gutter', null);
				annotations[i] = undefined;
			}
		}
	}
	
	CodeMirrorServiceBuilder.prototype._refreshAnnotations = function(annotations) {
		var editor = this.editor;
		for (var i = 0; i < annotations.length; i++) {
			var annotation = annotations[i];
			if (annotation) {
				var classProp = ' class="xtext-annotation_' + annotation.type + '"';
				var titleProp = annotation.description ? ' title="' + annotation.description.replace(/"/g, '&quot;') + '"' : '';
				var element = jQuery('<div' + classProp + titleProp + '></div>').get(0);
				editor.setGutterMarker(i, 'annotations-gutter', element);
			}
		}
	}
	
	/**
	 * Validation service.
	 */
	CodeMirrorServiceBuilder.prototype.doValidation = function() {
		var services = this.services;
		var editorContext = services.editorContext;
		var editor = this.editor;
		var self = this;
		services.validate().always(function() {
			if (editorContext._validationAnnotations)
				self._clearAnnotations(editorContext._validationAnnotations);
			else
				editorContext._validationAnnotations = [];
			var validationMarkers = editorContext._validationMarkers;
			if (validationMarkers) {
				for (var i = 0; i < validationMarkers.length; i++) {
					validationMarkers[i].clear();
				}
			}
			editorContext._validationMarkers = [];
		}).done(function(result) {
			var validationAnnotations = editorContext._validationAnnotations;
			for (var i = 0; i < result.issues.length; i++) {
				var entry = result.issues[i];
				var annotation = validationAnnotations[entry.line - 1];
				var weight = self._getAnnotationWeight(entry.severity);
				if (annotation) {
					if (annotation.weight < weight) {
						annotation.type = entry.severity;
						annotation.weight = weight;
					}
					if (annotation.description)
						annotation.description += '\n' + entry.description;
					else
						annotation.description = entry.description;
				} else {
					validationAnnotations[entry.line - 1] = {
						type: entry.severity,
						weight: weight,
						description: entry.description
					};
				}
				var from = editor.posFromIndex(entry.offset);
				var to = editor.posFromIndex(entry.offset + entry.length);
				var marker =  editor.markText(from, to, {
					className: 'xtext-marker_' + entry.severity,
					title: entry.description
				});
				editorContext._validationMarkers.push(marker);
			}
			self._refreshAnnotations(validationAnnotations);
		});
	}
		
	/**
	 * Occurrences service.
	 */
	CodeMirrorServiceBuilder.prototype.setupOccurrencesService = function() {
		var services = this.services;
		var editorContext = services.editorContext;
		var selectionUpdateDelay = services.options.selectionUpdateDelay;
		if (!selectionUpdateDelay)
			selectionUpdateDelay = 550;
		var editor = this.editor;
		var self = this;
		services.cursorActivityListener = function() {
			if (editorContext._selectionChangeTimeout) {
				clearTimeout(editorContext._selectionChangeTimeout);
			}
			editorContext._selectionChangeTimeout = setTimeout(function() {
				var params = ServiceBuilder.copy(services.options);
				var cursor = editor.getCursor();
				params.offset = editor.indexFromPos(cursor);
				services.occurrencesService.invoke(editorContext, params).always(function() {
					var occurrenceMarkers = editorContext._occurrenceMarkers;
					if (occurrenceMarkers) {
						for (var i = 0; i < occurrenceMarkers.length; i++)  {
							occurrenceMarkers[i].clear();
						}
					}
					editorContext._occurrenceMarkers = [];
				}).done(function(occurrencesResult) {
					for (var i = 0; i < occurrencesResult.readRegions.length; i++) {
						var region = occurrencesResult.readRegions[i];
						var from = editor.posFromIndex(region.offset);
						var to = editor.posFromIndex(region.offset + region.length);
						var marker =  editor.markText(from, to, {className: 'xtext-marker_read'});
						editorContext._occurrenceMarkers.push(marker);
					}
					for (var i = 0; i < occurrencesResult.writeRegions.length; i++) {
						var region = occurrencesResult.writeRegions[i];
						var from = editor.posFromIndex(region.offset);
						var to = editor.posFromIndex(region.offset + region.length);
						var marker =  editor.markText(from, to, {className: 'xtext-marker_write'});
						editorContext._occurrenceMarkers.push(marker);
					}
				});
			}, selectionUpdateDelay);
		}
		editor.on('cursorActivity', services.cursorActivityListener);
	}
		
	/**
	 * Formatting service.
	 */
	CodeMirrorServiceBuilder.prototype.setupFormattingService = function() {
		var services = this.services;
		if (services.options.enableFormattingAction) {
			var userAgent = navigator.userAgent.toLowerCase();
			var formatFunction = function(editor) {
				services.format();
			};
			services.formatKeyMap = /mac os/.test(userAgent) ? {'Shift-Cmd-F': formatFunction}: {'Shift-Ctrl-S': formatFunction};
			this.editor.addKeyMap(services.formatKeyMap);
		}
	}
	
	return exports;
});

