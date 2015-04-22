/*******************************************************************************
 * @license
 * Copyright (c) 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 
 * (http://www.eclipse.org/legal/epl-v10.html), and the Eclipse Distribution 
 * License v1.0 (http://www.eclipse.org/org/documents/edl-v10.html). 
 *
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
/*eslint-env browser, amd*/
/*global requirejs*/
define(['require', 'orion/Deferred'], function(require, Deferred) {
	/**
	 * Performs string substitution. Can be invoked in 2 ways:
	 *
	 * i) vargs giving numbered substition values:
	 *   formatMessage("${0} is ${1}", "foo", "bar")  // "foo is bar"
	 *
	 * ii) a map giving the substitutions:
	 *   formatMessage("${thing} is ${1}", {1: "bar", thing: "foo"})  // "foo is bar"
	 */
	function formatMessage(msg) {
		var pattern = /\$\{([^\}]+)\}/g, args = arguments;
		if (args.length === 2 && args[1] && typeof args[1] === "object") {
			return msg.replace(pattern, function(str, key) {
				return args[1][key];
			});
		}
		return msg.replace(pattern, function(str, index) {
			return args[(index << 0) + 1];
		});
	}
	return {
		formatMessage: formatMessage
	};
});