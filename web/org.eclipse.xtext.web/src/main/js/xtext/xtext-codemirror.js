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
 * In addition to the options supported by CodeMirror (https://codemirror.net/doc/manual.html#config),
 * the following options are available:
 *
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
 * enableFormattingAction = false {Boolean}
 *     Whether the formatting action should be bound to the standard keystroke ctrl+shift+f / cmd+shift+f.
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
 * parent {String | DOMElement}
 *     The parent element for the view; it can be either a DOM element or an ID for a DOM element.
 * resourceId {String}
 *     The identifier of the resource displayed in the text editor; this option is sent to the server to
 *     communicate required information on the respective resource.
 * selectionUpdateDelay = 550 {Number}
 *     The number of milliseconds to wait after a selection change before Xtext services are invoked.
 * sendFullText = false {Boolean}
 *     Whether the full text shall be sent to the server with each request; use this if you want
 *     the server to run in stateless mode. If the option is inactive, the server state is updated regularly.
 * serverUrl {String}
 *     The URL of the Xtext server.
 * showErrorDialogs = false {Boolean}
 *     Whether errors should be displayed in popup dialogs.
 * syntaxDefinition {String}
 *     A path to a JS file defining a CodeMirror syntax definition; if no path is given, it is built from
 *     the 'xtextLang' option in the form 'xtext/mode-<xtextLang>'.
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
		if (!options.parent)
			options.parent = 'xtext-editor';
		
		var parentsSpec;
		if (jQuery.isArray(options.parent)) {
			parentsSpec = options.parent;
		} else {
			parentsSpec = [options.parent];
		}
		var parents = [];
		var doc = options.document || document;
		for (var i = 0; i < parentsSpec.length; i++) {
			var spec = parentsSpec[i];
			if (typeof(spec) === 'string') {
				var element = doc.getElementById(spec);
				if (element)
					parents.push(element);
				else
					parents.concat(doc.getElementsByClassName(options.parent));
			} else {
				parents.push(spec);
			}
		}
		
		var editors = [];
		for (var i = 0; i < parents.length; i++) {
			var editorOptions = ServiceBuilder.mergeOptions(parents[i], options);
			if (!editorOptions.value)
				editorOptions.value = jQuery(parents[i]).text();
			var editor = CodeMirror(function(element) {
				jQuery(parents[i]).empty().append(element);
			}, editorOptions);
			
			exports.createServices(editor, editorOptions);
			editors[i] = editor;
		}
		
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
		editor.xtextServices = xtextServices;
		return xtextServices;
	}
	
	/**
	 * Syntax highlighting (without semantic highlighting).
	 */
//	CodeMirrorServiceBuilder.prototype.setupSyntaxHighlighting = function() {
//		TODO
//	}
		
	/**
	 * Document update service.
	 */
	CodeMirrorServiceBuilder.prototype.setupUpdateService = function(refreshDocument) {
		var services = this.services;
		var editorContext = services.editorContext;
		var textUpdateDelay = services.options.textUpdateDelay;
		if (!textUpdateDelay)
			textUpdateDelay = 500;
		function modelChangeListener(event) {
			if (!event._xtext_init)
				editorContext.markClean(false);
			if (editorContext._modelChangeTimeout){
				clearTimeout(editorContext._modelChangeTimeout);
			}
			editorContext._modelChangeTimeout = setTimeout(function() {
				if (services.options.sendFullText)
					refreshDocument();
				else
					services.update();
			}, textUpdateDelay);
		}
		if (!services.options.resourceId || !services.options.loadFromServer)
			modelChangeListener({_xtext_init: true});
		this.editor.on('changes', modelChangeListener);
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
			this.editor.addKeyMap(/mac os/.test(userAgent) ? {'Cmd-S': saveFunction}: {'Ctrl-S': saveFunction});
		}
	}
		
	/**
	 * Content assist service.
	 */
	CodeMirrorServiceBuilder.prototype.setupContentAssistService = function() {
		var services = this.services;
		var editorContext = services.editorContext;
		this.editor.addKeyMap({'Ctrl-Space': function(editor) {
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
			    			return {
			    				text: entry.proposal,
			    				displayText: displayText,
			    				from: {
			    					line: cursor.line,
			    					ch: cursor.ch - entry.prefix.length
			    				}
			    			};
						}),
						to: cursor
					};
				}});
			});
		}});
	}
		
	/**
	 * Semantic highlighting service.
	 */
	CodeMirrorServiceBuilder.prototype.doHighlighting = function() {
		var services = this.services;
		var editorContext = services.editorContext;
		var editor = this.editor;
		services.computeHighlighting().always(function() {
			editor.clearGutter('annotations-gutter');
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
	
	/**
	 * Validation service.
	 */
	CodeMirrorServiceBuilder.prototype.doValidation = function() {
		var services = this.services;
		var editorContext = services.editorContext;
		var editor = this.editor;
		services.validate().always(function() {
			editor.clearGutter('annotations-gutter');
			var validationMarkers = editorContext._validationMarkers;
			if (validationMarkers) {
				for (var i = 0; i < validationMarkers.length; i++) {
					validationMarkers[i].clear();
				}
			}
			editorContext._validationMarkers = [];
		}).done(function(result) {
			for (var i = 0; i < result.issues.length; i++) {
				var entry = result.issues[i];
				var element = jQuery('<div class="xtext-annotation_' + entry.severity
						+ '" title="' + entry.description + '"></div>').get(0);
				editor.setGutterMarker(entry.line - 1, 'annotations-gutter', element);
				var from = editor.posFromIndex(entry.offset);
				var to = editor.posFromIndex(entry.offset + entry.length);
				var marker =  editor.markText(from, to, {
					className: 'xtext-marker_' + entry.severity,
					title: entry.description
				});
				editorContext._validationMarkers.push(marker);
			}
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
		editor.on('cursorActivity', function() {
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
		});
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
			this.editor.addKeyMap(/mac os/.test(userAgent) ? {'Shift-Cmd-F': formatFunction}: {'Shift-Ctrl-S': formatFunction});
		}
	}
	
	CodeMirrorServiceBuilder.prototype.setupDirtyListener = function(dirtyElement, dirtyStatusClass) {
		var editorContext = this.services.editorContext;
		editorContext.addDirtyStateListener(function(clean) {
			if (clean)
				dirtyElement.removeClass(dirtyStatusClass);
			else
				dirtyElement.addClass(dirtyStatusClass);
		});
	}
	
	return exports;
});

