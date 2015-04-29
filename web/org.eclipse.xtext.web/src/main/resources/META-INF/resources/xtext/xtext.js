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
 * contents = "" {String}
 *     The editor contents.
 * contentType {String}
 *     The content type included in requests to the Xtext server.
 * dirtyElement {String | DOMElement}
 *     An element into which the dirty status class is written when the editor is marked dirty;
 *     it can be either a DOM element or an ID for a DOM element.
 * dirtyStatusClass = "dirty" {String}
 *     A CSS class name written into the dirtyElement when the editor is marked dirty.
 * document {Document}
 *     The document.
 * enableSaveAction = false {Boolean}
 *     Whether the save action should be bound to the standard keystroke ctrl+s / cmd+s.
 * expandTab = false {Boolean}
 *     Whether the tab key inserts white spaces.
 * firstLineIndex = 1 {Number}
 *     The line index displayed for the first line of text.
 * fullSelection = true {Boolean}
 *     Whether or not the view is in full selection mode.
 * lang {String}
 *     The language name (usually the file extension configured for the language).
 * loadFromServer = true {Boolean}
 *     Whether to load the editor content from the server. If enabled, the client will try to
 *     send only deltas instead of the full text whenever possible.
 * model {TextModel}
 *     The base text model.
 * parent {String | DOMElement}
 *     The parent element for the view; it can be either a DOM element or an ID for a DOM element.
 * readonly = false {Boolean}
 *     Whether the view is read-only.
 * resourceUri {String}
 *     The URI of the resource displayed in the text editor; this option is sent to the server to
 *     communicate required information on the respective resource.
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
 * tabMode = true {Boolean}
 *     Whether the tab key is consumed by the view or is used for focus traversal.
 * tabSize = 4 {Number}
 *     The number of spaces in a tab.
 * theme {String | TextTheme}
 *     The CSS file for the view theming or the actual theme.
 * themeClass {String}
 *     The CSS class for the view theming.
 * title = "" {String}
 *     The editor title.
 * wrappable = false {Boolean}
 *     Whether the view is wrappable.
 * wrapMode = false {Boolean}
 *     Whether the view wraps lines.
 */
define([
    "jquery",
    "orion/keyBinding",
	"orion/editor/textView",
	"orion/editor/textModel",
	"orion/editor/textTheme",
	"orion/editor/projectionTextModel",
	"orion/editor/editor",
	"orion/editor/editorFeatures",
	"orion/editor/contentAssist",
	"orion/editor/textStyler",
	"xtext/services/EditorContext",
	"xtext/services/LoadResourceService",
	"xtext/services/RevertResourceService",
	"xtext/services/SaveResourceService",
	"xtext/services/UpdateService",
	"xtext/services/ContentAssistService",
	"xtext/services/ValidationService"
], function(jQuery, mKeyBinding, mTextView, mTextModel, mTextTheme, mProjModel, mEditor,
		mEditorFeatures, mContentAssist, mTextStyler, EditorContext, LoadResourceService,
		RevertResourceService, SaveResourceService, UpdateService, ContentAssistService,
		ValidationService) {
	
	/**
	 * Translate a JS option name to an HTML attribute name.
	 */
	function _optionName(name) {
		var prefix = "data-editor-";
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
			if (obj.hasOwnProperty(p)) {
				copy[p] = obj[p];
			}
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
				if (value === "true" || value === "false") {
					value = value === "true";
				}
				options[key] = value;
			}
		}
		return options;
	}
	
	/**
	 * Create and configure an Orion-based Xtext editor.
	 */
	function XtextEditor(options, parent, doc) {
		if (!options.theme) {
			options.theme = "orion/editor/themes/default.css";
		}
		if (typeof options.theme === "string") {
			var theme = mTextTheme.TextTheme.getTheme(options.theme);
			var index = options.theme.lastIndexOf("/");
			var themeClass = options.theme; 
			if (index !== -1) {
				themeClass = themeClass.substring(index + 1);
			}
			var extension = ".css";
			if (themeClass.substring(themeClass.length - extension.length) === extension) {
				themeClass = themeClass.substring(0, themeClass.length - extension.length);
			}
			theme.setThemeClass(themeClass, {href: options.theme});
			options.theme = theme;
		}
		var textViewFactory = function() {
			return new mTextView.TextView({
				parent: parent,
				model: new mProjModel.ProjectionTextModel(options.model ? options.model : new mTextModel.TextModel("")),
				tabSize: options.tabSize ? options.tabSize : 4,
				readonly: options.readonly,
				fullSelection: options.fullSelection,
				tabMode: options.tabMode,
				expandTab: options.expandTab,
				singleMode: options.singleMode,
				themeClass: options.themeClass,
				theme: options.theme,
				wrapMode: options.wrapMode,
				wrappable: options.wrappable
			});
		};

		var contentAssist, contentAssistFactory;
		if (!options.readonly) {
			contentAssistFactory = {
				createContentAssistMode: function(editor) {
					contentAssist = new mContentAssist.ContentAssist(editor.getTextView());
					var contentAssistWidget = new mContentAssist.ContentAssistWidget(contentAssist);
					var result = new mContentAssist.ContentAssistMode(contentAssist, contentAssistWidget);
					contentAssist.setMode(result);
					return result;
				}
			};
		}
	
		var statusReporter = options.statusReporter;
		if (!statusReporter && options.statusElement) {
			var statusElement = options.statusElement;
			if (typeof(statusElement) === "string") {
				var statusElement = doc.getElementById(statusElement);
			}
			statusReporter = function(message, isError) {
				statusElement.textContent = message;
			};
		}
		
		mEditor.Editor.call(this, {
			textViewFactory: textViewFactory,
			undoStackFactory: new mEditorFeatures.UndoFactory(),
			annotationFactory: new mEditorFeatures.AnnotationFactory(),
			lineNumberRulerFactory: new mEditorFeatures.LineNumberRulerFactory(),
			foldingRulerFactory: new mEditorFeatures.FoldingRulerFactory(),
			textDNDFactory: new mEditorFeatures.TextDNDFactory(),
			contentAssistFactory: contentAssistFactory,
			keyBindingFactory: new mEditorFeatures.KeyBindingsFactory(), 
			statusReporter: statusReporter,
			domNode: parent
		});
		var self = this;
		this.addEventListener("TextViewInstalled", function() {
			var ruler = self.getLineNumberRuler();
			if (ruler && options.firstLineIndex !== undefined) {
				ruler.setFirstLine(options.firstLineIndex);
			}
			var sourceCodeActions = self.getSourceCodeActions();
			if (sourceCodeActions) {
				sourceCodeActions.setAutoPairParentheses(
						options.autoPairParentheses === undefined || options.autoPairParentheses);
				sourceCodeActions.setAutoPairBraces(
						options.autoPairBraces === undefined || options.autoPairBraces);
				sourceCodeActions.setAutoPairSquareBrackets(
						options.autoPairSquareBrackets === undefined || options.autoPairSquareBrackets);
				sourceCodeActions.setAutoPairAngleBrackets(
						options.autoPairAngleBrackets === undefined || options.autoPairAngleBrackets);
				sourceCodeActions.setAutoPairQuotations(
						options.autoPairQuotations === undefined || options.autoPairQuotations);
				sourceCodeActions.setAutoCompleteComments(
						options.autoCompleteComments === undefined || options.autoCompleteComments);
				sourceCodeActions.setSmartIndentation(
						options.smartIndentation === undefined || options.smartIndentation);
			}
		});
		
		var contents = options.contents;
		if (contents === undefined) {
			contents = jQuery(parent).text();
		}
		
		this.installTextView();
		this.setLineNumberRulerVisible(options.showLinesRuler === undefined || options.showLinesRuler);
		this.setAnnotationRulerVisible(options.showAnnotationRuler === undefined || options.showFoldingRuler);
		this.setOverviewRulerVisible(options.showOverviewRuler === undefined || options.showOverviewRuler);
		this.setZoomRulerVisible(options.showZoomRuler === undefined || options.showZoomRuler);
		this.setFoldingRulerVisible(options.showFoldingRuler === undefined || options.showFoldingRuler);
		this.setInput(options.title, null, contents, false, !options.setFocus);
		this._contentAssist = contentAssist;
		
		if (options.dirtyElement) {
			var dirtyElement;
			if (typeof(options.dirtyElement) === "string") {
				dirtyElement = jQuery("#" + options.dirtyElement, doc);
			} else {
				dirtyElement = jQuery(options.dirtyElement);
			}
			var dirtyStatusClass = options.dirtyStatusClass;
			if (!dirtyStatusClass) {
				dirtyStatusClass = "dirty";
			}
			this.addEventListener("DirtyChanged", function(event) {
				if (self.isDirty()) {
					dirtyElement.addClass(dirtyStatusClass);
				} else {
					dirtyElement.removeClass(dirtyStatusClass);
				}
			});
		}
		
		var window = doc.defaultView || doc.parentWindow;
		var computeSize = options.computeSize === undefined || options.computeSize;
		if (computeSize && jQuery(parent).attr("display") !== "none" && parent.clientHeight <= 50) {
			var height = self.getTextView().computeSize().height;
			parent.style.height = height + "px";
		}
	}
	
	XtextEditor.prototype = new mEditor.Editor();
	XtextEditor.prototype.invokeXtextService = function(service, invokeOptions) {
		throw "The Xtext services have not been configured.";
	};
	XtextEditor.prototype.xtextServiceSuccessListeners = [];
	XtextEditor.prototype.xtextServiceErrorListeners = [];
	
	var publicFunctions = {};
	
	/**
	 * Create an Xtext editor instance configured with the given options.
	 * 
	 * @param options
	 *     The editor options.
	 */
	publicFunctions.createEditor = function(options) {
		if (!options) {
			options = {};
		}
		var doc = options.document || document;
		var parent = options.parent;
		if (!parent) {
			parent = "xtext-editor";
		}
		if (typeof(parent) === "string") {
			var element = doc.getElementById(parent);
			if (element) {
				parent = element;
			} else {
				var elements = doc.getElementsByClassName(parent);
				if (elements.length > 0) {
					var result = Array.prototype.map.call(elements, function(e) {
						var newOptions = _copy(options);
						newOptions.parent = e;
						return publicFunctions.createEditor(newOptions);
					});
					if (result.length === 1) {
						return result[0];
					} else {
						return result;
					}
				} else {
					throw "No element with id or class \"" + parent + "\" exists.";
				}
			}
		}
		options = _mergeOptions(parent, options);
	
		var editor = new XtextEditor(options, parent, doc)
		publicFunctions.configureServices(editor, options);
		return editor;
	}
	
	/**
	 * Configure Xtext services for the given editor.
	 * 
	 * @param editor
	 *     The editor to which Xtext services shall be added.
	 * @param options
	 *     The editor options.
	 */
	publicFunctions.configureServices = function(editor, options) {
		var textView = editor.getTextView();
		var editorContext = new EditorContext(editor);
		var editorContextProvider = {
			getEditorContext : function() {
				return editorContext;
			},
			getOptions : function() {
				return options;
			}
		};
		
		var serverUrl = options.serverUrl;
		if (!serverUrl) {
			serverUrl = "http://" + location.host + "/xtext-service";
		}
		var lang = options.lang;
		var resourceUri = options.resourceUri;
		var loadResourceService = undefined, saveResourceService = undefined, revertResourceService = undefined;
		if (resourceUri) {
			if (options.loadFromServer === undefined || options.loadFromServer) {
				options.loadFromServer = true;
				loadResourceService = new LoadResourceService(serverUrl, resourceUri);
				loadResourceService.loadResource(editorContext, _copy(options));
				saveResourceService = new SaveResourceService(serverUrl, resourceUri);
				if (options.enableSaveAction) {
					textView.setKeyBinding(new mKeyBinding.KeyStroke("s", true), "saveXtextDocument");
					textView.setAction("saveXtextDocument", function() {
						saveResourceService.saveResource(editorContext, _copy(options));
						return true;
					}, {name: "Save"});
				}
				revertResourceService = new RevertResourceService(serverUrl, resourceUri);
			}
			if (!lang) {
				lang = resourceUri.split('.').pop();
			}
		} else {
			if (options.loadFromServer === undefined) {
				options.loadFromServer = false;
			}
			if (lang) {
				resourceUri = "text." + lang;
			}
		}

		if (lang) {
			var contentType = "xtext/" + lang;
			require([contentType + "-syntax"], function(grammar) {
				var annotationModel = editor.getAnnotationModel();
				var stylerAdapter = new mTextStyler.createPatternBasedAdapter(grammar.grammars, grammar.id, contentType);
				new mTextStyler.TextStyler(textView, annotationModel, stylerAdapter);
			});
		}
		
		var validationService = new ValidationService(serverUrl, resourceUri);
		
		function refreshDocument() {
			editorContext.clearClientServiceState();
			validationService.computeProblems(editorContext, _copy(options));
		}
		var updateService = undefined;
		if (!options.sendFullText) {
			updateService = new UpdateService(serverUrl, resourceUri);
			validationService.setUpdateService(updateService);
			if (saveResourceService !== undefined) {
				saveResourceService.setUpdateService(updateService);
			}
			editorContext.addServerStateListener(refreshDocument);
		}
		function modelChangeListener(event) {
			if (editor._modelChangeTimeout){
				clearTimeout(editor._modelChangeTimeout);
			}
			editor._modelChangeTimeout = setTimeout(function() {
				if (options.sendFullText) {
					refreshDocument();
				} else {
					updateService.update(editorContext, _copy(options))
				}
			}, 500);
		};
		if (!options.resourceUri || !options.loadFromServer) {
			modelChangeListener(null);
		}
		textView.addEventListener("ModelChanged", modelChangeListener);
		
		var contentAssist = editor._contentAssist;
		if (contentAssist) {
			contentAssist.setEditorContextProvider(editorContextProvider);
			var contentAssistService = new ContentAssistService(serverUrl, resourceUri);
			if (updateService !== undefined) {
				contentAssistService.setUpdateService(updateService);
			}
			contentAssist.setProviders([{
				id : "xtext.service",
				provider : contentAssistService
			}]);
		}
		
		editor.invokeXtextService = function(service, invokeOptions) {
			var optionsCopy = _copy(options);
			for (var p in invokeOptions) {
				if (invokeOptions.hasOwnProperty(p)) {
					optionsCopy[p] = invokeOptions[p];
				}
			}
			if (service === "load" && loadResourceService) {
				loadResourceService.loadResource(editorContext, optionsCopy);
			} else if (service === "save" && saveResourceService) {
				saveResourceService.saveResource(editorContext, optionsCopy);
			} else if (service === "revert" && revertResourceService) {
				revertResourceService.revertResource(editorContext, optionsCopy);
			} else {
				throw "Service '" + service + "' is not available.";
			}
		};
		if (editor.xtextServiceSuccessListeners === undefined) {
			editor.xtextServiceSuccessListeners = [];
		}
		if (editor.xtextServiceErrorListeners === undefined) {
			editor.xtextServiceErrorListeners = [];
		}
		editor.xtextServiceErrorListeners.push(function(requestType, xhr, textStatus, errorThrown) {
			if (options.showErrorDialogs) {
				window.alert("Xtext service '" + requestType + "' failed: " + errorThrown);
			} else {
				console.log("Xtext service '" + requestType + "' failed: " + errorThrown);
			}
		});
	}
	
	/**
	 * Invoke an Xtext service.
	 * 
	 * @param editor
	 *     The editor for which the service shall be invoked.
	 * @param service
	 *     A service type identifier, e.g. "save".
	 * @param invokeOptions
	 *     Additional options to pass to the service (optional).
	 */
	publicFunctions.invokeService = function(editor, service, invokeOptions) {
		if (editor.invokeXtextService) {
			editor.invokeXtextService(service, invokeOptions);
		} else {
			throw "The editor has not been configured with Xtext.";
		}
	}
	
	return publicFunctions;
});

