/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

define([
	'jquery',
	'assert',
    'xtext/compatibility',
    'xtext/ServiceBuilder',
	'xtext/MockEditorContext',
], function(mjQuery, assert, compatibility, ServiceBuilder, EditorContext) {
	
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
		
		setDirty: function(dirty) {
			this._editorContext.setDirty(dirty);
			return this;
		},
		
		invokeService: function(serviceType) {
			var result = this._editorContext.xtextServices.invoke(serviceType);
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
			assert(request);
			checker(request.url, request.settings);
			return this;
		},
		
		checkSuccess: function(checker) {
			var lastSuccess = this._lastSuccess;
			assert(lastSuccess);
			checker(lastSuccess.serviceType, lastSuccess.result);
			return this;
		},
		
		checkError: function(checker) {
			var lastError = this._lastError;
			assert(lastError);
			checker(lastError.serviceType, lastError.severity, lastError.message, lastError.requestData);
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
		var tester = new Tester(editorContext, options.doneCallback);
		editorContext.xtextServices.successListeners.push(function(serviceType, result) {
			tester._lastSuccess = {
				serviceType: serviceType,
				result: result
			};
		});
		editorContext.xtextServices.errorListeners.push(function(serviceType, severity, message, requestData) {
			tester._lastError = {
				serviceType: serviceType,
				severity: severity,
				message: message,
				requestData: requestData
			};
		});
		mjQuery.reset();
		return tester;
	}
	
	exports.createEditor = function(options) {
		if (!options)
			options = {};
		var editorContext = new EditorContext();
		exports.createServices(editorContext, options);
		return editorContext;
	}
	
	function TestServiceBuilder(xtextServices) {
		ServiceBuilder.call(this, xtextServices);
	}
	TestServiceBuilder.prototype = new ServiceBuilder();

	exports.createServices = function(editorContext, options) {
		options.serviceUrl = 'test://xtext-service';
		var xtextServices = {
			options: options,
			editorContext: editorContext,
			serviceTypes: {}
		};
		var serviceBuilder = new TestServiceBuilder(xtextServices);
		serviceBuilder.createServices();
		xtextServices.serviceTypes.generate = function() {
			return xtextServices.generate();
		}
		xtextServices.invoke = function(serviceType) {
			var invokeFunction = xtextServices.serviceTypes[serviceType];
			if (invokeFunction)
				return invokeFunction();
			else
				throw new Error('Service \'' + service + '\' is not available.');
		};
		xtextServices.errorListeners = [];
		editorContext.xtextServices = xtextServices;
		return xtextServices;
	}
	
	/**
	 * Document update service.
	 */
	TestServiceBuilder.prototype.setupUpdateService = function(refreshDocument) {
		var services = this.services;
		var editorContext = services.editorContext;
		services.editorContext.addModelChangeListener(function(event) {
			if (!event._xtext_init)
				editorContext.setDirty(true);
			if (services.options.sendFullText)
				refreshDocument();
			else
				services.update();
		});
		services.serviceTypes.update = function() {
			return services.update();
		}
		services.serviceTypes.validate = function() {
			return services.validate();
		}
		services.serviceTypes.highlight = function() {
			return services.computeHighlighting();
		}
	}
	
	/**
	 * Persistence services: load, save, and revert.
	 */
	TestServiceBuilder.prototype.setupPersistenceServices = function() {
		var services = this.services;
		services.serviceTypes.load = function() {
			return services.loadResource();
		}
		services.serviceTypes.save = function() {
			return services.saveResource();
		}
		services.serviceTypes.revert = function() {
			return services.revertResource();
		}
	}
	
	/**
	 * Content assist service.
	 */
	TestServiceBuilder.prototype.setupContentAssistService = function() {
		var services = this.services;
		services.serviceTypes.assist = function() {
			return services.getContentAssist();
		}
	}
	
	/**
	 * Semantic highlighting service.
	 */
	TestServiceBuilder.prototype.doHighlighting = function() {
		this.services.computeHighlighting();
	}
			
	/**
	 * Validation service.
	 */
	TestServiceBuilder.prototype.doValidation = function() {
		this.services.validate();
	}
	
	/**
	 * Hover service.
	 */
	TestServiceBuilder.prototype.setupHoverService = function() {
		var services = this.services;
		services.serviceTypes.hover = function() {
			return services.getHoverInfo();
		}
	}
	
	/**
	 * Occurrences service.
	 */
	TestServiceBuilder.prototype.setupOccurrencesService = function() {
		var services = this.services;
		services.serviceTypes.occurrences = function() {
			return services.getOccurrences();
		}
	}
	
	/**
	 * Formatting service.
	 */
	TestServiceBuilder.prototype.setupFormattingService = function() {
		var services = this.services;
		services.serviceTypes.format = function() {
			return services.format();
		}
	}
	
	return exports;
});

