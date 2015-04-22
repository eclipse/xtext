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
define(["orion/Deferred"], function(Deferred) {
	var GA_ID = "OrionGA"; //$NON-NLS-0$
	var queue = [];

	var init = function(services, args) {
		var service = services.shift();
		if (!service) {
			queue = null; /* no more services to try, so will not track */
			return;
		}

		if (service.init) {
			service.init().then(
				function(result) {
					/* service succeeded */
					if (!result.tid) {
						/* not tracking */
						queue = null;
						return;
					}

					(function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
					(i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
					m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
					})(window,document,'script','//www.google-analytics.com/analytics.js',GA_ID);

					args = args || {};
					if (result.siteSpeedSampleRate) {
						args.siteSpeedSampleRate = result.siteSpeedSampleRate;
					}
					window[GA_ID]("create", result.tid, args); //$NON-NLS-0$
					window[GA_ID]("send", "pageview"); //$NON-NLS-1$ //$NON-NLS-0$

					/* process events logged while initialization was occurring */
					queue.forEach(function(current) {
						window[GA_ID](current.command, current.arg0, current.arg1, current.arg2, current.arg3, current.arg4); //$NON-NLS-0$
					});
					queue = null; /* no longer needed */
				},
				/* @callback */ function(error) {
					init(services, args); /* service failed, try the next one */
				}
			);
		} else {
			init(services, args); /* invalid service, try the next one */
		}
	};

	var initFromRegistry = function(serviceRegistry, args) {
		var refs = serviceRegistry.getServiceReferences("orion.analytics.google"); //$NON-NLS-0$
		var services = [];
		refs.forEach(function(current) {
			services.push(serviceRegistry.getService(current));
		});
		init(services, args);
	};

	function logEvent(category, action, label, value) {
		if (window[GA_ID]) {
			window[GA_ID]("send", "event", category, action, label, value); //$NON-NLS-1$ //$NON-NLS-0$
		} else {
			if (queue) {
				queue.push({command: "send", arg0: "event", arg1: category, arg2: action, arg3: label, arg4: value}); //$NON-NLS-1$ //$NON-NLS-0$
			}
		}
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
		if (window[GA_ID]) {
			window[GA_ID]("send", "timing", timingCategory, timingVar, Math.round(timingValue), timingLabel); //$NON-NLS-1$ //$NON-NLS-0$
		} else {
			if (queue) {
				queue.push({command: "send", arg0: "timing", arg1: timingCategory, arg2: timingVar, arg3: Math.round(timingValue), arg4: timingLabel}); //$NON-NLS-1$ //$NON-NLS-0$
			}
		}
	}

	function setDimension(dimensionId, value) {
		if (window[GA_ID]) {
			window[GA_ID]("set", dimensionId, value); //$NON-NLS-0$
		} else {
			if (queue) {
				queue.push({command: "set", arg0: dimensionId, arg1: value}); //$NON-NLS-0$
			}
		}
	}

	return {
		init: init,
		initFromRegistry: initFromRegistry,
		logEvent: logEvent,
		logPageLoadTiming: logPageLoadTiming,
		logTiming: logTiming,
		setDimension: setDimension
	};
});
