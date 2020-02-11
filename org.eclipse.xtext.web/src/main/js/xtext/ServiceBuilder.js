/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/

define([
    'jquery',
    'xtext/services/XtextService',
	'xtext/services/LoadResourceService',
	'xtext/services/SaveResourceService',
	'xtext/services/HighlightingService',
	'xtext/services/ValidationService',
	'xtext/services/UpdateService',
	'xtext/services/ContentAssistService',
	'xtext/services/HoverService',
	'xtext/services/OccurrencesService',
	'xtext/services/FormattingService'
], function(jQuery, XtextService, LoadResourceService, SaveResourceService, HighlightingService,
		ValidationService, UpdateService, ContentAssistService, HoverService, OccurrencesService,
		FormattingService) {
	
	/**
	 * Builder class for the Xtext services.
	 */
	function ServiceBuilder(xtextServices) {
		this.services = xtextServices;
	};

	/**
	 * Create all the available Xtext services depending on the configuration.
	 */
	ServiceBuilder.prototype.createServices = function() {
		var services = this.services;
		var options = services.options;
		var editorContext = services.editorContext;
		editorContext.xtextServices = services;
		var self = this;
		if (!options.serviceUrl) {
			if (!options.baseUrl)
				options.baseUrl = '/';
			else if (options.baseUrl.charAt(0) != '/')
				options.baseUrl = '/' + options.baseUrl;
			options.serviceUrl = window.location.protocol + '//' + window.location.host + options.baseUrl + 'xtext-service';
		}
		if (options.resourceId) {
			if (!options.xtextLang)
				options.xtextLang = options.resourceId.split(/[?#]/)[0].split('.').pop();
			if (options.loadFromServer === undefined)
				options.loadFromServer = true;
			if (options.loadFromServer && this.setupPersistenceServices) {
				services.loadResourceService = new LoadResourceService(options.serviceUrl, options.resourceId, false);
				services.loadResource = function(addParams) {
					return services.loadResourceService.invoke(editorContext, ServiceBuilder.mergeOptions(addParams, options));
				}
				services.saveResourceService = new SaveResourceService(options.serviceUrl, options.resourceId);
				services.saveResource = function(addParams) {
					return services.saveResourceService.invoke(editorContext, ServiceBuilder.mergeOptions(addParams, options));
				}
				services.revertResourceService = new LoadResourceService(options.serviceUrl, options.resourceId, true);
				services.revertResource = function(addParams) {
					return services.revertResourceService.invoke(editorContext, ServiceBuilder.mergeOptions(addParams, options));
				}
				this.setupPersistenceServices();
				services.loadResource();
			}
		} else {
			if (options.loadFromServer === undefined)
				options.loadFromServer = false;
			if (options.xtextLang) {
				var randomId = Math.floor(Math.random() * 2147483648).toString(16);
				options.resourceId = randomId + '.' + options.xtextLang;
			}
		}
		
		if (this.setupSyntaxHighlighting) {
			this.setupSyntaxHighlighting();
		}
		if (options.enableHighlightingService || options.enableHighlightingService === undefined) {
			services.highlightingService = new HighlightingService(options.serviceUrl, options.resourceId);
			services.computeHighlighting = function(addParams) {
				return services.highlightingService.invoke(editorContext, ServiceBuilder.mergeOptions(addParams, options));
			}
		}
		if (options.enableValidationService || options.enableValidationService === undefined) {
			services.validationService = new ValidationService(options.serviceUrl, options.resourceId);
			services.validate = function(addParams) {
				return services.validationService.invoke(editorContext, ServiceBuilder.mergeOptions(addParams, options));
			}
		}
		if (this.setupUpdateService) {
			function refreshDocument() {
				if (services.highlightingService && self.doHighlighting) {
					services.highlightingService.setState(undefined);
					self.doHighlighting();
				}
				if (services.validationService && self.doValidation) {
					services.validationService.setState(undefined);
					self.doValidation();
				}
			}
			if (!options.sendFullText) {
				services.updateService = new UpdateService(options.serviceUrl, options.resourceId);
				services.update = function(addParams) {
					return services.updateService.invoke(editorContext, ServiceBuilder.mergeOptions(addParams, options));
				}
				if (services.saveResourceService)
					services.saveResourceService._updateService = services.updateService;
				editorContext.addServerStateListener(refreshDocument);
			}
			this.setupUpdateService(refreshDocument);
		}
		if ((options.enableContentAssistService || options.enableContentAssistService === undefined)
				&& this.setupContentAssistService) {
			services.contentAssistService = new ContentAssistService(options.serviceUrl, options.resourceId, services.updateService);
			services.getContentAssist = function(addParams) {
				return services.contentAssistService.invoke(editorContext, ServiceBuilder.mergeOptions(addParams, options));
			}
			this.setupContentAssistService();
		}
		if ((options.enableHoverService || options.enableHoverService === undefined)
				&& this.setupHoverService) {
			services.hoverService = new HoverService(options.serviceUrl, options.resourceId, services.updateService);
			services.getHoverInfo = function(addParams) {
				return services.hoverService.invoke(editorContext, ServiceBuilder.mergeOptions(addParams, options));
			}
			this.setupHoverService();
		}
		if ((options.enableOccurrencesService || options.enableOccurrencesService === undefined)
				&& this.setupOccurrencesService) {
			services.occurrencesService = new OccurrencesService(options.serviceUrl, options.resourceId, services.updateService);
			services.getOccurrences = function(addParams) {
				return services.occurrencesService.invoke(editorContext, ServiceBuilder.mergeOptions(addParams, options));
			}
			this.setupOccurrencesService();
		}
		if ((options.enableFormattingService || options.enableFormattingService === undefined)
				&& this.setupFormattingService) {
			services.formattingService = new FormattingService(options.serviceUrl, options.resourceId, services.updateService);
			services.format = function(addParams) {
				return services.formattingService.invoke(editorContext, ServiceBuilder.mergeOptions(addParams, options));
			}
			this.setupFormattingService();
		}
		if (options.enableGeneratorService || options.enableGeneratorService === undefined) {
			services.generatorService = new XtextService();
			services.generatorService.initialize(services, 'generate');
			services.generatorService._initServerData = function(serverData, editorContext, params) {
				if (params.allArtifacts)
					serverData.allArtifacts = params.allArtifacts;
				else if (params.artifactId)
					serverData.artifact = params.artifactId;
				if (params.includeContent !== undefined)
					serverData.includeContent = params.includeContent;
			}
			services.generate = function(addParams) {
				return services.generatorService.invoke(editorContext, ServiceBuilder.mergeOptions(addParams, options));
			}
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
			editorContext.addDirtyStateListener(function(dirty) {
				if (dirty)
					dirtyElement.addClass(dirtyStatusClass);
				else
					dirtyElement.removeClass(dirtyStatusClass);
			});
		}
		
		services.successListeners = [];
		services.errorListeners = [function(serviceType, severity, message, requestData) {
			if (options.showErrorDialogs)
				window.alert('Xtext service \'' + serviceType + '\' failed: ' + message);
			else
				console.log('Xtext service \'' + serviceType + '\' failed: ' + message);
		}];
	}
	
	/**
	 * Change the resource associated with this service builder.
	 */
	ServiceBuilder.prototype.changeResource = function(resourceId) {
		var services = this.services;
		var options = services.options;
		options.resourceId = resourceId;
		for (var p in services) {
			if (services.hasOwnProperty(p)) {
				var service = services[p];
				if (service._serviceType && jQuery.isFunction(service.initialize))
					services[p].initialize(options.serviceUrl, service._serviceType, resourceId, services.updateService);
			}
		}
		var knownServerState = services.editorContext.getServerState();
		delete knownServerState.stateId;
		delete knownServerState.text;
		if (options.loadFromServer && jQuery.isFunction(services.loadResource)) {
			services.loadResource();
		}
	}
	
	/**
	 * Create a copy of the given object.
	 */
	ServiceBuilder.copy = function(obj) {
		var copy = {};
		for (var p in obj) {
			if (obj.hasOwnProperty(p))
				copy[p] = obj[p];
		}
		return copy;
	}
	
	/**
	 * Translate an HTML attribute name to a JS option name.
	 */
	ServiceBuilder.optionName = function(name) {
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
	 * Copy all default options into the given set of additional options.
	 */
	ServiceBuilder.mergeOptions = function(options, defaultOptions) {
		if (options) {
			for (var p in defaultOptions) {
				if (defaultOptions.hasOwnProperty(p))
					options[p] = defaultOptions[p];
			}
			return options;
		} else {
			return ServiceBuilder.copy(defaultOptions);
		}
	}
	
	/**
	 * Merge all properties of the given parent element with the given default options.
	 */
	ServiceBuilder.mergeParentOptions = function(parent, defaultOptions) {
		var options = ServiceBuilder.copy(defaultOptions);
		for (var attr, j = 0, attrs = parent.attributes, l = attrs.length; j < l; j++) {
			attr = attrs.item(j);
			var key = ServiceBuilder.optionName(attr.nodeName);
			if (key) {
				var value = attr.nodeValue;
				if (value === 'true' || value === 'false')
					value = value === 'true';
				options[key] = value;
			}
		}
		return options;
	}
	
	return ServiceBuilder;
});