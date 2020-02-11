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
	 * Service class for saving resources.
	 */
	function SaveResourceService(serviceUrl, resourceId) {
		this.initialize(serviceUrl, 'save', resourceId);
	};

	SaveResourceService.prototype = new XtextService();

	SaveResourceService.prototype._initServerData = function(serverData, editorContext, params) {
		return {
			httpMethod: 'POST'
		};
	};
	
	SaveResourceService.prototype._processResult = function(result, editorContext) {
		editorContext.setDirty(false);
	};
	
	return SaveResourceService;
});