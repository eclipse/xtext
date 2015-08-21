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
 * enableHoverService = true {Boolean}
 *     Whether mouse hover information should be enabled.
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
 * mouseHoverDelay = 500 {Number}
 *     The number of milliseconds to wait after a mouse hover before the information tooltip is displayed.
 * parent {String | DOMElement}
 *     The parent element for the view; it can be either a DOM element or an ID or class name for a DOM element.
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
 *     A path to a JS file defining an Orion syntax definition; if no path is given, it is built from
 *     the 'xtextLang' option in the form 'xtext/<xtextLang>-syntax'.
 * textUpdateDelay = 500 {Number}
 *     The number of milliseconds to wait after a text change before Xtext services are invoked.
 * xtextLang {String}
 *     The language name (usually the file extension configured for the language).
 */
define([
    'jquery',
    'orion/Deferred',
    'orion/codeEdit',
    'orion/keyBinding',
    'orion/editor/annotations',
    'xtext/compatibility',
	'xtext/OrionEditorContext',
	'xtext/services/XtextService',
	'xtext/services/LoadResourceService',
	'xtext/services/SaveResourceService',
	'xtext/services/UpdateService',
	'xtext/services/ContentAssistService',
	'xtext/services/ValidationService',
	'xtext/services/HighlightingService',
	'xtext/services/HoverService',
	'xtext/services/OccurrencesService',
	'xtext/services/FormattingService'
], function(jQuery, OrionDeferred, CodeEdit, mKeyBinding, mAnnotations, compatibility, EditorContext,
		XtextService, LoadResourceService, SaveResourceService, UpdateService, ContentAssistService,
		ValidationService, HighlightingService, HoverService, OccurrencesService, FormattingService) {
	
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
	
	
	var exports = {};
	
	/**
	 * Create one or more Xtext editor instances configured with the given options.
	 * The return value is a Deferred object that eventually resolves to either an Orion
	 * editor viewer or an array of Orion editor viewers.
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
				if (element) {
					parents.push(element);
				} else {
					var elements = doc.getElementsByClassName(options.parent);
					for (var j = 0; j < elements.length; j++) {
						parents.push(elements[j]);
					}
				}
			} else {
				parents.push(spec);
			}
		}
		
		var editorViewers = [];
		editorViewers.length = parents.length;
		var finishedViewers = 0;
		var codeEdit = new CodeEdit();
		var deferred = jQuery.Deferred();
		for (var i = 0; i < parents.length; i++) {
			var editorOptions = _mergeOptions(parents[i], options);
			var content = jQuery(parents[i]).text();
			
			codeEdit.create({parent: parents[i]}).then(function(editorViewer) {
				try {
					var services = exports.configureServices(editorViewer, editorOptions);
				} catch (error) {
					console.log('Error while building Xtext services: ' + error);
					if (error.stack)
						console.log(error.stack);
					deferred.reject(error);
					return;
				}
				editorViewer.setContents(content, services.contentType);
				editorViewers[i] = editorViewer;
				finishedViewers++;
				if (finishedViewers == parents.length) {
					if (finishedViewers == 1)
						deferred.resolve(editorViewer);
					else
						deferred.resolve(editorViewers);
				}
			}, function(error) {
				deferred.reject(error);
			});
			
		}
		return deferred.promise();
	}
	
	function ServiceBuilder(editorViewer, xtextServices) {
		this.viewer = editorViewer;
		this.services = xtextServices;
	}
	
	/**
	 * Configure Xtext services for the given editor. The editor does not have to be created
	 * with createEditor(options).
	 */
	exports.configureServices = function(editorViewer, options) {
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
			var editor = editorViewer.editor;
			editor.addEventListener('DirtyChanged', function(event) {
				if (editor.isDirty())
					dirtyElement.addClass(dirtyStatusClass);
				else
					dirtyElement.removeClass(dirtyStatusClass);
			});
		}
		
		var xtextServices = {
			options: options,
			editorContext: new EditorContext(editorViewer.editor),
			contentType: options.contentType,
			_highlightAnnotationTypes: []
		};
		if (!xtextServices.contentType && options.xtextLang)
			xtextServices.contentType = 'xtext/' + options.xtextLang;
		else if (!xtextServices.contentType)
			xtextServices.contentType = 'xtext';
		var serviceBuilder = new ServiceBuilder(editorViewer, xtextServices);
		
		if (!options.serverUrl)
			options.serverUrl = 'http://' + location.host + '/xtext-service';
		if (options.resourceId) {
			if (options.loadFromServer === undefined || options.loadFromServer) {
				options.loadFromServer = true;
				serviceBuilder.createPersistenceServices();
			}
		} else {
			if (options.loadFromServer === undefined)
				options.loadFromServer = false;
			if (options.xtextLang)
				options.resourceId = 'text.' + options.xtextLang;
		}
		
		serviceBuilder.createUpdateService();
		if (options.enableContentAssistService || options.enableContentAssistService === undefined) {
			serviceBuilder.createContentAssistService();
		}
		if (options.enableHoverService || options.enableHoverService === undefined) {
			serviceBuilder.createHoverService();
		}
		if (options.enableOccurrencesService || options.enableOccurrencesService === undefined) {
			serviceBuilder.createOccurrencesService();
		}
		if (options.enableFormattingService || options.enableFormattingService === undefined) {
			serviceBuilder.createFormattingService();
		}
		if (options.enableGeneratorService || options.enableGeneratorService === undefined) {
			serviceBuilder.createGeneratorService();
		}
		
		//---- Syntax highlighting
		
		if (options.syntaxDefinition || options.xtextLang) {
			var syntaxDefinition = options.syntaxDefinition;
			if (!syntaxDefinition)
				syntaxDefinition = 'xtext/' + options.xtextLang + '-syntax';
			if (typeof(syntaxDefinition) === 'string') {
				require([syntaxDefinition], function(grammar) {
					editorViewer.serviceRegistry.registerService('orion.edit.highlighter', {}, grammar);
				});
			} else {
				editorViewer.serviceRegistry.registerService('orion.edit.highlighter', {}, syntaxDefinition);
			}
		}
		
		xtextServices.successListeners = [];
		xtextServices.errorListeners = [function(requestType, severity, message, requestData) {
			if (options.showErrorDialogs)
				window.alert('Xtext service \'' + requestType + '\' failed: ' + message);
			else
				console.log('Xtext service \'' + requestType + '\' failed: ' + message);
		}];
		editorViewer.xtextServices = xtextServices;
		xtextServices.editorContext.xtextServices = xtextServices;
		return xtextServices;
	}
	
	
	/**
	 * Builder class for the various Xtext services.
	 */
	ServiceBuilder.prototype = {
		
		/**
		 * On-demand registers and returns the annotation type with the given name.
		 */
		_getHighlightAnnotationType: function(typeName) {
			var type = mAnnotations.AnnotationType.getType(typeName);
			if (type)
				return typeName;
			var properties = {
				title: typeName,
				style: {styleClass: "annotation " + typeName},
				html: "<div class='annotationHTML " + typeName + "'></div>", 
				overviewStyle: {styleClass: "annotationOverview " + typeName}
			};
			properties.rangeStyle = {styleClass: "annotationRange " + typeName};
			var newType = mAnnotations.AnnotationType.registerType(typeName, properties);
			this.services._highlightAnnotationTypes.push(newType);
			this.viewer.editor.getAnnotationStyler().addAnnotationType(newType);
			return newType;
		},
		
		/**
		 * Document refresh services: semantic highlighting and validation.
		 */
		getRefreshFunction: function() {
			var editorViewer = this.viewer;
			var services = this.services;
			var self = this;
			return function() {
				var options = services.options;
				
				//---- Semantic highlighting service
				
				if (options.enableHighlightingService || options.enableHighlightingService === undefined) {
					if (!services.highlightingService)
						services.highlightingService = new HighlightingService(options.serverUrl, options.resourceId);
					services.highlightingService.setState(undefined);
					services.highlightingService.computeHighlighting(services.editorContext, options).done(function(result) {
						var annotations = [];
						for (var i = 0; i < result.regions.length; ++i) {
							var region = result.regions[i];
							region.styleClasses.forEach(function(styleClass) {
								annotations.push({
									description: '',
									start: region.offset,
									end: region.offset + region.length,
									styleClass: styleClass
								});
							});
							editorViewer.editor.showAnnotations(annotations, services._highlightAnnotationTypes, null, 
								function(annotation) {
									return self._getHighlightAnnotationType(annotation.styleClass, editorViewer, services);
								});
						}
					});
				}
				
				//---- Validation service
				
				if (options.enableValidationService || options.enableValidationService === undefined) {
					if (!services.validationService)
						services.validationService = new ValidationService(options.serverUrl, options.resourceId);
					services.validationService.setState(undefined);
					services.validationService.computeProblems(services.editorContext, options).done(function(result) {
						editorViewer.editor.showProblems(result.issues.map(function(entry) {
							return {
								description: entry.description,
								start: entry.offset,
								end: entry.offset + entry.length,
								severity: entry.severity
							};
						}));
					});
				}
			}
		},
		
		/**
		 * Document update service.
		 */
		createUpdateService: function() {
			var services = this.services;
			var refreshDocument = this.getRefreshFunction(this.viewer, services);
			var options = services.options;
			if (!options.sendFullText) {
				services.updateService = new UpdateService(options.serverUrl, options.resourceId);
				if (services.saveResourceService)
					services.saveResourceService._updateService = services.updateService;
				services.editorContext.addServerStateListener(refreshDocument);
			}
			var textUpdateDelay = options.textUpdateDelay;
			if (!textUpdateDelay)
				textUpdateDelay = 500;
			function modelChangeListener(event) {
				if (services._modelChangeTimeout) {
					clearTimeout(services._modelChangeTimeout);
				}
				services._modelChangeTimeout = setTimeout(function() {
					if (options.sendFullText)
						refreshDocument();
					else
						services.updateService.update(services.editorContext, options);
				}, textUpdateDelay);
			}
//			if (!options.resourceId || !options.loadFromServer)
//				modelChangeListener(null);
			this.viewer.serviceRegistry.registerService('orion.edit.model',
					{onModelChanged: modelChangeListener}, {contentType: [services.contentType]});
		},
		
		/**
		 * Persistence services: load, save, and revert.
		 */
		createPersistenceServices: function() {
			var services = this.services;
			var options = services.options;
			services.loadResourceService = new LoadResourceService(options.serverUrl, options.resourceId, false);
			services.loadResourceService.loadResource(services.editorContext, options);
			services.saveResourceService = new SaveResourceService(options.serverUrl, options.resourceId);
			if (options.enableSaveAction) {
				var textView = this.viewer.editor.getTextView();
				textView.setKeyBinding(new mKeyBinding.KeyStroke('s', true), 'saveXtextDocument');
				textView.setAction('saveXtextDocument', function() {
					services.saveResourceService.saveResource(services.editorContext, options);
					return true;
				}, {name: 'Save'});
			}
			services.revertResourceService = new LoadResourceService(options.serverUrl, options.resourceId, true);
		},
		
		/**
		 * Content assist service.
		 */
		createContentAssistService: function() {
			var services = this.services;
			var options = services.options;
			services.contentAssistService = new ContentAssistService(options.serverUrl, options.resourceId, services.updateService);
			function computeContentAssist(orionContext, params) {
				for (var p in options) {
					if (options.hasOwnProperty(p))
						params[p] = options[p];
				}
				var deferred = new OrionDeferred();
				services.contentAssistService.computeContentAssist(services.editorContext, params).done(function(entries) {
					deferred.resolve(entries.map(function(entry) {
						return {
							proposal: entry.proposal,
							prefix: entry.prefix,
							overwrite: true,
							name: (entry.label ? entry.label: entry.proposal),
							description: entry.description,
							style: entry.style,
							additionalEdits: entry.textReplacements,
							positions: entry.editPositions,
							escapePosition: entry.escapePosition
						};
					}));
				}).fail(function() {
					deferred.reject();
				});
				return deferred.promise;
			}
			this.viewer.serviceRegistry.registerService('orion.edit.contentAssist',
					{computeContentAssist: computeContentAssist},
					{name: 'Xtext content assist service', contentType: [services.contentType]});
		},
		
		/**
		 * Hover service.
		 */
		createHoverService: function() {
			var services = this.services;
			var options = services.options;
			services.hoverService = new HoverService(options.serverUrl, options.resourceId, services.updateService);
			function computeHoverInfo(orionContext, params) {
				var deferred = new OrionDeferred();
				for (var p in options) {
					if (options.hasOwnProperty(p))
						params[p] = options[p];
				}
				services.hoverService.computeHoverInfo(services.editorContext, params).done(function(entry) {
					deferred.resolve({ 
						content: entry.content,
						title: entry.title,
						type: 'html' 
					});
				}).fail(function() {
					deferred.resolve(null);
				});
				return deferred.promise;
			}
			this.viewer.serviceRegistry.registerService('orion.edit.hover',
					{computeHoverInfo: computeHoverInfo},
					{name: 'Xtext hover service', contentType: [services.contentType]});
		},
		
		/**
		 * Occurrences service.
		 */
		createOccurrencesService: function() {
			var services = this.services;
	//		textView._setLinksVisible(true);
			var options = services.options;
			services.occurrencesService = new OccurrencesService(options.serverUrl, options.resourceId, services.updateService);
	//		var selectionUpdateDelay = options.selectionUpdateDelay;
	//		if (!selectionUpdateDelay)
	//			selectionUpdateDelay = 550;
			function computeOccurrences(orionContext, params) {
				var deferred = new OrionDeferred();
				for (var p in options) {
					if (options.hasOwnProperty(p))
						params[p] = options[p];
				}
				services.occurrencesService.getOccurrences(services.editorContext, params).done(function(occurrencesResult) {
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
					deferred.resolve(readAnnotations.concat(writeAnnotations));
				}).fail(function() {
					deferred.resolve({});
				});
				return deferred.promise;
			}
			this.viewer.serviceRegistry.registerService('orion.edit.occurrences',
					{computeOccurrences: computeOccurrences}, {contentType: [services.contentType]});
		},
		
		/**
		 * Formatting service.
		 */
		createFormattingService: function() {
			var services = this.services;
			var options = services.options;
			services.formattingService = new FormattingService(options.serverUrl, options.resourceId, services.updateService);
			if (options.enableFormattingAction) {
				function execute(orionContext, params) {
					var deferred = new OrionDeferred();
					for (var p in options) {
						if (options.hasOwnProperty(p))
							params[p] = options[p];
					}
					services.formattingService.format(services.editorContext, params).done(function(result) {
						deferred.resolve();
					}).fail(function() {
						deferred.reject();
					});
					return deferred.promise;
				}
				this.viewer.serviceRegistry.registerService('orion.edit.command', {execute: execute}, {
					name: 'Xtext formatting service',
					id: 'xtext.formatter',
					key: ['f', true, true],
					contentType: [services.contentType]
				});
			}
		},
		
		/**
		 * Generator service.
		 */
		createGeneratorService: function() {
			var services = this.services;
			var options = services.options;
			services.generatorService = new XtextService();
			services.generatorService.initialize(options.serverUrl, options.resourceId, 'generate', services.updateService);
		}
		
	};
	
	return exports;
});

