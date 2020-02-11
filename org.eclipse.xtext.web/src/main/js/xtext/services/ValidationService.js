/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/

define(['xtext/services/XtextService', 'jquery'], function(XtextService, jQuery) {
	
	/**
	 * Service class for validation.
	 */
	function ValidationService(serviceUrl, resourceId) {
		this.initialize(serviceUrl, 'validate', resourceId);
	};
	
	ValidationService.prototype = new XtextService();
	
	ValidationService.prototype._checkPreconditions = function(editorContext, params) {
		return this._state === undefined;
	}

	ValidationService.prototype._onConflict = function(editorContext, cause) {
		this.setState(undefined);
		return {
			suppressForcedUpdate: true
		};
	};
	
	return ValidationService;
});