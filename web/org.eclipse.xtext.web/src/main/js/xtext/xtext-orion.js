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
 * autoCompleteComments = true {Boolean}
 *     Whether comments shall be auto-completed.
 * autoPairAngleBrackets = true {Boolean}
 *     Whether <angle brackets> shall be auto-completed.
 * autoPairBraces = true {Boolean}
 *     Whether {braces} shall be auto-completed.
 * autoPairParentheses = true {Boolean}
 *     Whether (parentheses) shall be auto-completed.
 * autoPairQuotations = true {Boolean}
 *     Whether "quotations" shall be auto-completed.
 * autoPairSquareBrackets = true {Boolean}
 *     Whether [square brackets] shall be auto-completed.
 * computeSize = true {Boolean}
 *     Whether to enable automatic computation of the widget height.
 * contents = '' {String}
 *     The editor contents.
 * contentType {String}
 *     The content type included in requests to the Xtext server.
 * dirtyElement {String | DOMElement}
 *     An element into which the dirty status class is written when the editor is marked dirty;
 *     it can be either a DOM element or an ID for a DOM element.
 * dirtyStatusClass = 'dirty' {String}
 *     A CSS class name written into the dirtyElement when the editor is marked dirty.
 * document {Document}
 *     The document.
 * enableContentAssistService = true {Boolean}
 *     Whether content assist should be enabled.
 * enableFormattingAction = false {Boolean}
 *     Whether the formatting action should be bound to the standard keystroke ctrl+shift+f / cmd+shift+f.
 * enableFormattingService = true {Boolean}
 *     Whether text formatting should be enabled.
 * enableHoverService = true {Boolean}
 *     Whether mouse hover information should be enabled.
 * enableOccurrencesService = true {Boolean}
 *     Whether marking occurrences should be enabled.
 * enableSaveAction = false {Boolean}
 *     Whether the save action should be bound to the standard keystroke ctrl+s / cmd+s.
 * enableValidationService = true {Boolean}
 *     Whether validation should be enabled.
 * expandTab = false {Boolean}
 *     Whether the tab key inserts white spaces.
 * firstLineIndex = 1 {Number}
 *     The line index displayed for the first line of text.
 * fullSelection = true {Boolean}
 *     Whether or not the view is in full selection mode.
 * loadFromServer = true {Boolean}
 *     Whether to load the editor content from the server.
 * model {TextModel}
 *     The base text model.
 * mouseHoverDelay = 500 {Number}
 *     The number of milliseconds to wait after a mouse hover before the information tooltip is displayed.
 * parent {String | DOMElement}
 *     The parent element for the view; it can be either a DOM element or an ID or class name for a DOM element.
 * readonly = false {Boolean}
 *     Whether the view is read-only.
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
 * setFocus = false {Boolean}
 *     Whether to focus the editor after creation.
 * showAnnotationRuler = true {Boolean}
 *     Whether the annotation ruler is shown.
 * showErrorDialogs = false {Boolean}
 *     Whether errors should be displayed in popup dialogs.
 * showFoldingRuler = true {Boolean}
 *     Whether the folding ruler is shown.
 * showLinesRuler = true {Boolean}
 *     Whether the lines ruler is shown.
 * showOverviewRuler = true {Boolean}
 *     Whether the overview ruler is shown.
 * showZoomRuler = false {Boolean}
 *     Whether the zoom ruler is shown.
 * singleMode = false {Boolean}
 *     Whether the editor is in single line mode.
 * smartIndentation = true {Boolean}
 *     Whether to enable smart indentation.
 * statusElement {String | DOMElement}
 *     An element into which the status message is written if no status reporter is given;
 *     it can be either a DOM element or an ID for a DOM element.
 * statusReporter {Function}
 *     A status reporter function.
 * syntaxDefinition {String}
 *     A path to a JS file defining an Orion syntax definition (see orion/editor/stylers/lib/syntax.js);
 *     if no path is given, it is built from the 'xtextLang' option in the form 'xtext/<xtextLang>-syntax'.
 * tabMode = true {Boolean}
 *     Whether the tab key is consumed by the view or is used for focus traversal.
 * tabSize = 4 {Number}
 *     The number of spaces in a tab.
 * textUpdateDelay = 500 {Number}
 *     The number of milliseconds to wait after a text change before Xtext services are invoked.
 * theme {String | TextTheme}
 *     The CSS file for the view theming or the actual theme.
 * themeClass {String}
 *     The CSS class for the view theming.
 * title = '' {String}
 *     The editor title.
 * wrappable = false {Boolean}
 *     Whether the view is wrappable.
 * wrapMode = false {Boolean}
 *     Whether the view wraps lines.
 * xtextLang {String}
 *     The language name (usually the file extension configured for the language).
 */
define([
    'jquery',
    'orion/editor/edit',
    'orion/Deferred',
    'orion/keyBinding',
    'orion/editor/textStyler',
    'xtext/compatibility',
	'xtext/OrionEditorContext',
	'xtext/services/LoadResourceService',
	'xtext/services/RevertResourceService',
	'xtext/services/SaveResourceService',
	'xtext/services/UpdateService',
	'xtext/services/ContentAssistService',
	'xtext/services/ValidationService',
	'xtext/services/HoverService',
	'xtext/services/OccurrencesService',
	'xtext/services/FormattingService'
], function(jQuery, orionEdit, Deferred, mKeyBinding, mTextStyler, compatibility, EditorContext,
		LoadResourceService, RevertResourceService, SaveResourceService, UpdateService,
		ContentAssistService, ValidationService, HoverService, OccurrencesService, FormattingService) {
	
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
	
	
	var _internals = {}
	
	/**
	 * Set the default options for Xtext editors.
	 */
	function _setDefaultOptions(options) {
		if (!options.xtextLang && options.lang)
			options.xtextLang = options.lang
		if (!options.xtextLang && options.resourceId)
			options.xtextLang = options.resourceId.split('.').pop();
		if (!options.statusReporter && options.statusElement) {
			var statusElement = options.statusElement;
			if (typeof(statusElement) === 'string') {
				var doc = options.document || document;
				statusElement = doc.getElementById(statusElement);
			}
			if (statusElement !== undefined) {
				options.statusReporter = function(message, isError) {
					statusElement.textContent = message;
				};
			}
		}
		options.noFocus = !options.setFocus;
		options.noComputeSize = options.computeSize !== undefined && !options.computeSize;
		if (options.autoCompleteComments === undefined)
			options.autoCompleteComments = true;
		if (options.autoPairAngleBrackets === undefined)
			options.autoPairAngleBrackets = true;
		if (options.autoPairBraces === undefined)
			options.autoPairBraces = true;
		if (options.autoPairParentheses === undefined)
			options.autoPairParentheses = true;
		if (options.autoPairQuotations === undefined)
			options.autoPairQuotations = true;
		if (options.autoPairSquareBrackets === undefined)
			options.autoPairSquareBrackets = true;
		if (options.smartIndentation === undefined)
			options.smartIndentation = true;
		if (options.hoverFactory === undefined) {
			var hover = {
				clearQuickFixes: function() {},
				renderQuickFixes: function() {}
			};
			_internals.hoverDelegate = hover;
			options.hoverFactory = {
				createHover: function() {
					return hover;
				}
			};
		}
	}
	
	var exports = {};
	
	/**
	 * Create an Xtext editor instance configured with the given options.
	 * 
	 * Hint: Orion does not allow to configure the syntax file path (https://bugs.eclipse.org/bugs/show_bug.cgi?id=469249),
	 *       so the options 'lang' and 'contentType' should be avoided with the current version. Use 'xtextLang' instead.
	 */
	exports.createEditor = function(options) {
		if (!options)
			options = {};
		if (!options.parent)
			options.parent = 'xtext-editor';
		if (!options.className)
			options.className = 'xtext-editor';
		
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
		
		if (parents.length == 1) {
			var editorOptions = _mergeOptions(parents[0], options);
			_setDefaultOptions(editorOptions);
			
			var editor = orionEdit(editorOptions);
			
			if (jQuery.isArray(editor))
				editor = editor[0];
			exports.configureServices(editor, editorOptions);
			return editor;
		} else {
			_setDefaultOptions(options);
			
			var editors = orionEdit(options);
			
			if (!jQuery.isArray(editors))
				editors = [editors];
			for (var i = 0; i < editors.length; i++) {
				var editorOptions = _mergeOptions(parents[i], options);
				exports.configureServices(editors[i], editorOptions);
			}
			return editors;
		}
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
			editor.addEventListener('DirtyChanged', function(event) {
				if (editor.isDirty())
					dirtyElement.addClass(dirtyStatusClass);
				else
					dirtyElement.removeClass(dirtyStatusClass);
			});
		}
		
		var textView = editor.getTextView();
		textView._setLinksVisible(true);
		var editorContext = new EditorContext(editor);
		var editorContextProvider = {
			getEditorContext: function() {
				return editorContext;
			},
			getOptions: function() {
				return options;
			}
		};
		if (!editor.getEditorContext)
			editor.getEditorContext = editorContextProvider.getEditorContext;
		if (!editor.getOptions)
			editor.getOptions = editorContextProvider.getOptions;
		
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
				if (options.enableSaveAction) {
					textView.setKeyBinding(new mKeyBinding.KeyStroke('s', true), 'saveXtextDocument');
					textView.setAction('saveXtextDocument', function() {
						saveResourceService.saveResource(editorContext, options);
						return true;
					}, {name: 'Save'});
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
		
		if (options.xtextLang) {
			var contentType = 'xtext/' + options.xtextLang;
			var syntaxDefinition = options.syntaxDefinition;
			if (!syntaxDefinition) {
				syntaxDefinition = contentType + '-syntax';
			}
			require([syntaxDefinition], function(grammar) {
				var annotationModel = editor.getAnnotationModel();
				var stylerAdapter = new mTextStyler.createPatternBasedAdapter(grammar.grammars, grammar.id, contentType);
				new mTextStyler.TextStyler(textView, annotationModel, stylerAdapter);
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
				validationService.computeProblems(editorContext, options).done(function(entries) {
					editor.showProblems(entries.map(function(entry) {
						return {
							description: entry.description,
							start: entry.startOffset,
							end: entry.endOffset,
							severity: entry.severity
						};
					}));
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
			if (editorContext._modelChangeTimeout) {
				clearTimeout(editorContext._modelChangeTimeout);
			}
			editorContext._modelChangeTimeout = setTimeout(function() {
				if (options.sendFullText)
					refreshDocument();
				else
					updateService.update(editorContext, options);
			}, textUpdateDelay);
		};
		if (!options.resourceId || !options.loadFromServer) {
			modelChangeListener(null);
		}
		textView.addEventListener('ModelChanged', modelChangeListener);
		
		//---- Content Assist Service
		
		var contentAssist = editor.getContentAssist();
		if (contentAssist && (options.enableContentAssistService || options.enableContentAssistService === undefined)) {
			contentAssist.setEditorContextProvider(editorContextProvider);
			var contentAssistService = new ContentAssistService(options.serverUrl, options.resourceId);
			if (updateService)
				contentAssistService.setUpdateService(updateService);
			contentAssist.setProviders([{
				id: 'xtext.service',
				provider: {
					computeContentAssist: function(editorContext, params) {
						var deferred = new Deferred();
						contentAssistService.computeContentAssist(editorContext, params).done(function(entries) {
							deferred.resolve(entries.map(function(entry) {
								var p = {
									proposal: entry.proposal,
									prefix: entry.prefix,
									overwrite: true,
									name: (entry.label ? entry.label: entry.proposal),
									description: entry.description,
									style: entry.style,
									additionalEdits: entry.textReplacements,
									positions: entry.editPositions,
								};
								if (entry.escapePosition)
									p.escapePosition = entry.escapePosition;
								return p;
							}));
						}).fail(function() {
							deferred.reject();
						});
						return deferred.promise;
					}
				}
			}]);
		}
		
		//---- Hover Service
		
		if (_internals.hoverDelegate && (options.enableHoverService || options.enableHoverService === undefined)) {
			var hoverService = new HoverService(options.serverUrl, options.resourceId);
			if (updateService)
				hoverService.setUpdateService(updateService);
			_internals.hoverDelegate.computeHoverInfo = function(context) {
				var deferred = new Deferred();
				hoverService.computeHoverInfo(editorContext, context).done(function(entry) {
					deferred.resolve({ 
						content: entry.content,
						title: entry.title,
						type: 'html' 
					});
				}).fail(function() {
					deferred.resolve(null);
				});
				return [ deferred.promise ];
			}
			delete _internals.hoverDelegate;
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
			textView.addEventListener('Selection', function() {
				if (editorContext._selectionChangeTimeout) {
					clearTimeout(editorContext._selectionChangeTimeout);
				}
				editorContext._selectionChangeTimeout = setTimeout(function() {
					var params = _copy(options);
					params.offset = textView.getCaretOffset();
					occurrencesService.markOccurrences(editorContext, params).done(function(occurrencesResult) {
						var readAnnotations = occurrencesResult.readRegions.map(function(region) {
							return {
								start: region.offset,
								end: region.offset + region.length,
								readAccess: true
							};
						});
						var writeAnnotations = occurrencesResult.writeRegions.map(function(region) {
							return {
								start: region.offset,
								end: region.offset + region.length,
								readAccess: false
							};
						});
						editor.showOccurrences(readAnnotations.concat(writeAnnotations));
					}).fail(function() {
						editor.showOccurrences({});
					});
				}, selectionUpdateDelay);
			});
		}
		
		//---- Formatting Service
		
		var formattingService;
		if (options.enableFormattingService || options.enableFormattingService === undefined) {
			formattingService = new FormattingService(options.serverUrl, options.resourceId);
			if (updateService)
				formattingService.setUpdateService(updateService);
			if (options.enableFormattingAction) {
				textView.setKeyBinding(new mKeyBinding.KeyStroke('f', true, true), 'formatXtextDocument');
				textView.setAction('formatXtextDocument', function() {
					formattingService.format(editorContext, options);
					return true;
				}, {name: 'Format'});
			}
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
			else if (service === 'validate' && validationService)
				return validationService.computeProblems(editorContext, optionsCopy);
			else if (service === 'occurrences' && occurrencesService)
				return occurrencesService.markOccurrences(editorContext, optionsCopy);
			else if (service === 'format' && formattingService)
				return formattingService.format(editorContext, options);
			else
				throw new Error('Service \'' + service + '\' is not available.');
		}
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

