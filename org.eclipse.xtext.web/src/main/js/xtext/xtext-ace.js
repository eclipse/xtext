/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
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
 * The following options are available:
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
 * enableFormattingAction = false {Boolean}
 *     Whether the formatting action should be bound to the standard keystroke ctrl+shift+f / cmd+shift+f.
 * enableFormattingService = true {Boolean}
 *     Whether text formatting should be enabled.
 * enableGeneratorService = true {Boolean}
 *     Whether code generation should be enabled (must be triggered through JavaScript code).
 * enableOccurrencesService = true {Boolean}
 *     Whether marking occurrences should be enabled.
 * enableSaveAction = false {Boolean}
 *     Whether the save action should be bound to the standard keystroke ctrl+s / cmd+s.
 * enableValidationService = true {Boolean}
 *     Whether validation should be enabled.
 * loadFromServer = true {Boolean}
 *     Whether to load the editor content from the server.
 * parent = 'xtext-editor' {String | DOMElement}
 *     The parent element for the view; it can be either a DOM element or an ID for a DOM element.
 * parentClass = 'xtext-editor' {String}
 *     If the 'parent' option is not given, this option is used to find elements that match the given class name.
 * position {String}
 *     If this option is set, the 'position' CSS attribute of the created editor is set accordingly.
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
 *     A path to a JS file defining an Ace syntax definition; if no path is given, it is built from
 *     the 'xtextLang' option in the form 'xtext-resources/mode-{xtextLang}'. Set this option to 'none' to
 *     disable syntax highlighting.
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
    'xtext/compatibility',
    'xtext/ServiceBuilder',
	'xtext/AceEditorContext'
], function(jQuery, ace, languageTools, compatibility, ServiceBuilder, EditorContext) {
	
	var exports = {};
	
	/**
	 * Create one or more Xtext editor instances configured with the given options.
	 * The return value is either an Ace editor or an array of Ace editors, which can
	 * be further configured using the Ace API.
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
			var editor = ace.edit(parent);
			editor.$blockScrolling = Infinity;
			if (options.position)
				jQuery(parent).css('position', options.position);
			
			var editorOptions = ServiceBuilder.mergeParentOptions(parent, options);
			exports.createServices(editor, editorOptions);
			if (editorOptions.theme)
				editor.setTheme(editorOptions.theme);
			else
				editor.setTheme('ace/theme/eclipse');
			editors[index] = editor;
		});
		
		if (editors.length == 1)
			return editors[0];
		else
			return editors;
	}
	
	function AceServiceBuilder(editor, xtextServices) {
		this.editor = editor;
		xtextServices.editorContext._annotations = [];
		xtextServices.editorContext._occurrenceMarkers = [];
		ServiceBuilder.call(this, xtextServices);
	}
	AceServiceBuilder.prototype = new ServiceBuilder();
		
	/**
	 * Configure Xtext services for the given editor. The editor does not have to be created
	 * with createEditor(options).
	 */
	exports.createServices = function(editor, options) {
		var xtextServices = {
			options: options,
			editorContext: new EditorContext(editor)
		};
		var serviceBuilder = new AceServiceBuilder(editor, xtextServices);
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
		var session = editor.getSession();
		if (services.modelChangeListener)
			editor.off('change', services.modelChangeListener);
		if (services.changeCursorListener)
			editor.getSelection().off('changeCursor', services.changeCursorListener);
		if (editor.commands) {
			if (services.options.enableSaveAction)
				editor.commands.removeCommand('xtext-save');
			if (services.options.enableFormattingAction)
				editor.commands.removeCommand('xtext-format');
		}
		if (services.contentAssistService)
			editor.setOptions({ enableBasicAutocompletion: false });
		var editorContext = services.editorContext;
		var annotations = editorContext._annotations;
		if (annotations) {
			for (var i = 0; i < annotations.length; i++) {
				session.removeMarker(annotations[i].markerId);
			}
			session.setAnnotations([]);
		}
		var occurrenceMarkers = editorContext._occurrenceMarkers;
		if (occurrenceMarkers) {
			for (var i = 0; i < occurrenceMarkers.length; i++)  {
				session.removeMarker(occurrenceMarkers[i]);
			}
		}
		delete editor.xtextServices;
	}
	
	/**
	 * Syntax highlighting (without semantic highlighting).
	 */
	AceServiceBuilder.prototype.setupSyntaxHighlighting = function() {
		var options = this.services.options;
		var session = this.editor.getSession();
		if (options.syntaxDefinition != 'none' && (options.syntaxDefinition || options.xtextLang)) {
			var syntaxDefinition = options.syntaxDefinition;
			if (!syntaxDefinition)
				syntaxDefinition = 'xtext-resources/mode-' + options.xtextLang;
			if (typeof(syntaxDefinition) === 'string') {
				require([syntaxDefinition], function(mode) {
					session.setMode(new mode.Mode);
				});
			} else if (syntaxDefinition.Mode) {
				session.setMode(new syntaxDefinition.Mode);
			}
		}
	}
		
	/**
	 * Document update service.
	 */
	AceServiceBuilder.prototype.setupUpdateService = function(refreshDocument) {
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
		this.editor.on('change', services.modelChangeListener);
	}
	
	/**
	 * Persistence services: load, save, and revert.
	 */
	AceServiceBuilder.prototype.setupPersistenceServices = function() {
		var services = this.services;
		if (services.options.enableSaveAction && this.editor.commands) {
			this.editor.commands.addCommand({
				name: 'xtext-save',
				bindKey: {win: 'Ctrl-S', mac: 'Command-S'},
				exec: function(editor) {
					services.saveResource();
				}
			});
		}
	}
		
	/**
	 * Content assist service.
	 */
	AceServiceBuilder.prototype.setupContentAssistService = function() {
		var completer = {
			getCompletions: function(editor, session, pos, prefix, callback) {
				// See https://bugs.eclipse.org/bugs/show_bug.cgi?id=486615
				var services = editor.xtextServices;
				var params = ServiceBuilder.copy(services.options);
				var document = session.getDocument();
				params.offset = document.positionToIndex(pos);
				var range = editor.getSelectionRange();
				params.selection = {
					start: document.positionToIndex(range.start),
					end: document.positionToIndex(range.end)
				};
				services.contentAssistService.invoke(services.editorContext, params).done(function(entries) {
					callback(null, entries.map(function(entry, index, a) {
						return {
							value: entry.proposal,
							caption: (entry.label ? entry.label : entry.proposal),
							meta: entry.description,
							score: a.length - index
						};
					}));
				});
			}
		}
		this.editor.setOptions({ enableBasicAutocompletion: [completer] });
	}
	
	/**
	 * Add a problem marker to an editor session.
	 */
	AceServiceBuilder.prototype._addMarker = function(session, startOffset, endOffset, clazz, type) {
		var document = session.getDocument();
		var start = document.indexToPosition(startOffset);
		var end = document.indexToPosition(endOffset);
		var mRange = require('ace/range');
		var range = new mRange.Range(start.row, start.column, end.row, end.column);
		return session.addMarker(range, 'xtext-marker_' + clazz, 'text');
	}
	
	/**
	 * Validation service.
	 */
	AceServiceBuilder.prototype.doValidation = function() {
		var services = this.services;
		var editorContext = services.editorContext;
		var session = this.editor.getSession();
		var self = this;
		services.validate().always(function() {
			var annotations = editorContext._annotations;
			if (annotations) {
				for (var i = 0; i < annotations.length; i++) {
					var annotation = annotations[i];
					session.removeMarker(annotation.markerId);
				}
			}
			editorContext._annotations = [];
		}).done(function(result) {
			for (var i = 0; i < result.issues.length; i++) {
				var entry = result.issues[i];
				var marker = self._addMarker(session, entry.offset, entry.offset + entry.length, entry.severity);
				var start = session.getDocument().indexToPosition(entry.offset);
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
		
	/**
	 * Occurrences service.
	 */
	AceServiceBuilder.prototype.setupOccurrencesService = function() {
		var services = this.services;
		var editorContext = services.editorContext;
		var selectionUpdateDelay = services.options.selectionUpdateDelay;
		if (!selectionUpdateDelay)
			selectionUpdateDelay = 550;
		var editor = this.editor;
		var session = editor.getSession();
		var self = this;
		services.changeCursorListener = function() {
			if (editorContext._selectionChangeTimeout) {
				clearTimeout(editorContext._selectionChangeTimeout);
			}
			editorContext._selectionChangeTimeout = setTimeout(function() {
				var params = ServiceBuilder.copy(services.options);
				params.offset = session.getDocument().positionToIndex(editor.getSelection().getCursor());
				services.occurrencesService.invoke(editorContext, params).always(function() {
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
						var marker = self._addMarker(session, region.offset, region.offset + region.length, 'read');
						editorContext._occurrenceMarkers.push(marker);
					}
					for (var i = 0; i < occurrencesResult.writeRegions.length; i++) {
						var region = occurrencesResult.writeRegions[i];
						var marker = self._addMarker(session, region.offset, region.offset + region.length, 'write');
						editorContext._occurrenceMarkers.push(marker);
					}
				});
			}, selectionUpdateDelay);
		};
		editor.getSelection().on('changeCursor', services.changeCursorListener);
	}
		
	/**
	 * Formatting service.
	 */
	AceServiceBuilder.prototype.setupFormattingService = function() {
		var services = this.services;
		if (services.options.enableFormattingAction && this.editor.commands) {
			this.editor.commands.addCommand({
				name: 'xtext-format',
				bindKey: {win: 'Ctrl-Shift-F', mac: 'Command-Shift-F'},
				exec: function(editor) {
					services.format();
				}
			});
		}
	}
	
	return exports;
});

