/*******************************************************************************
 * @license
 * Copyright (c) 2014 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v1.0
 * (http://www.eclipse.org/legal/epl-v10.html), and the Eclipse Distribution
 * License v1.0 (http://www.eclipse.org/org/documents/edl-v10.html).
 *
 * Contributors: IBM Corporation - initial API and implementation
 ******************************************************************************/

/*eslint-env browser, amd*/
define([], function() {

	var _services = [];

	function init(services, args) {
		/* the following definitions are from https://developers.google.com/analytics/devguides/collection/analyticsjs/pages */
		var href = window.location.protocol + '//' + window.location.hostname + window.location.pathname + window.location.search; //$NON-NLS-0$
		var page = window.location.pathname + window.location.search;
		var title = document.title;

		_services = services;
		_services.forEach(function(current) {
			current.pageLoad(href, page, title, args);
		});
	};

	function initFromRegistry(serviceRegistry, args) {
		var refs = serviceRegistry.getServiceReferences("orion.metrics"); //$NON-NLS-0$
		var services = [];
		refs.forEach(function(current) {
			services.push(serviceRegistry.getService(current));
		});
		init(services, args);
	};

	function logEvent(category, action, label, value) {
		_services.forEach(function(current) {
			current.logEvent(category, action, label, value);
		});
	}

	function logPageLoadTiming(timingVar, timingLabel) {
		/* 
		 * The level of window.performance implementation varies across the browsers,
		 * so check for the existence of all utilized functions up-front.
		 */
		if (window.performance && window.performance.getEntriesByName && window.performance.mark && !window.performance.getEntriesByName(timingVar).length) {
			window.performance.mark(timingVar); /* ensure that no more timings of this type are logged for this page */
			logTiming("page", timingVar, window.performance.now(), timingLabel); //$NON-NLS-0$
		}
	}

	function logTiming(timingCategory, timingVar, timingValue, timingLabel) {
		_services.forEach(function(current) {
			current.logTiming(timingCategory, timingVar, timingValue, timingLabel);
		});
	}

	return {
		init: init,
		initFromRegistry: initFromRegistry,
		logEvent: logEvent,
		logPageLoadTiming: logPageLoadTiming,
		logTiming: logTiming
	};
});
