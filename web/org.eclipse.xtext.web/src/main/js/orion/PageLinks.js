/*******************************************************************************
 * @license
 * Copyright (c) 2012, 2014 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 
 * (http://www.eclipse.org/legal/epl-v10.html), and the Eclipse Distribution 
 * License v1.0 (http://www.eclipse.org/org/documents/edl-v10.html). 
 * 
 ******************************************************************************/
/*eslint-env browser, amd*/
/*global URL*/
define([
	"require",
	"orion/Deferred",
	"orion/PageUtil",
	"orion/URITemplate",
	"orion/i18nUtil",
	"orion/objects",
	"orion/URL-shim"
], function(require, Deferred, PageUtil, URITemplate, i18nUtil, objects) {

	/**
	 * Returns the value of the <code>{OrionHome}</code> variable.
	 * @memberOf orion.PageLinks
	 * @function
	 * @returns {String} The value of the <code>{OrionHome}</code> variable.
	 */
	function getOrionHome() {
		if(!require.toUrl){
			return new URL("/", window.location.href).href.slice(0, -1);
		} else {
			// The idea here is to find the path of `orion/*` modules from the loader, and go up one folder to
			// the servlet context path. Finally, return a complete URL, slicing off the trailing `/`.
			// RequireJS 2.1.15:
			var orionSrcURL = new URL(require.toUrl("orion/"), window.location.href); //$NON-NLS-0$
			return new URL("../", orionSrcURL).href.slice(0, -1); //$NON-NLS-0$
		}
	}

	/**
	 * Reads metadata from an <code>orion.page.xxxxx</code> service extension.
	 * @memberOf orion.PageLinks
	 * @function
	 * @param {orion.ServiceRegistry} serviceRegistry The service registry.
	 * @param {String} [serviceName="orion.page.link"] Service name to read extensions from.
	 * @return {orion.Promise} A promise that resolves to an {@link orion.PageLinks.PageLinksInfo} object.
	 */
	function getPageLinksInfo(serviceRegistry, serviceName) {
		return _readPageLinksMetadata(serviceRegistry, serviceName).then(function(metadata) {
			return new PageLinksInfo(metadata);
		});
	}

	function _getPropertiesMap(serviceRef) {
		var props = {};
		serviceRef.getPropertyKeys().forEach(function(key) {
			if (key !== "objectClass" && key !== "service.names" && key !== "service.id" && key !== "__plugin__") //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
				props[key] = serviceRef.getProperty(key);
		});
		return props;
	}

	function _readPageLinksMetadata(serviceRegistry, serviceName) {
		serviceName = serviceName || "orion.page.link"; //$NON-NLS-0$

		// Read page links.
		// https://wiki.eclipse.org/Orion/Documentation/Developer_Guide/Plugging_into_Orion_pages
		var navLinks= serviceRegistry.getServiceReferences(serviceName);
		var params = PageUtil.matchResourceParameters(window.location.href);
		// TODO: should not be necessary, see bug https://bugs.eclipse.org/bugs/show_bug.cgi?id=373450
		var orionHome = getOrionHome();
		var locationObject = {OrionHome: orionHome, Location: params.resource};
		var navLinkInfos = [];
		navLinks.forEach(function(navLink) {
			var info = _getPropertiesMap(navLink);
			if (!info.uriTemplate || (!info.nls && !info.name)) {
				return; // missing data, skip
			}

			var uriTemplate = new URITemplate(info.uriTemplate);
			var expandedHref = uriTemplate.expand(locationObject);
			expandedHref = PageUtil.validateURLScheme(expandedHref);
			info.href = expandedHref;

			info.textContent = info.name || info.nameKey;
			navLinkInfos.push(new Deferred().resolve(info));
		});
		return Deferred.all(navLinkInfos);
	}

	// Categories apply to all orion.page.link* serviceNames, so cache them.
	var _cachedCategories;
	/**
	 * Reads info about page link categories.
	 * @returns {orion.Promise} Resolving to {@link orion.PageLinks.CategoriesInfo}
	 */
	function getCategoriesInfo(serviceRegistry) {
		// Read categories.
		var categoryInfos;
		if (!_cachedCategories) {
			categoryInfos = [];
			var navLinkCategories = serviceRegistry.getServiceReferences("orion.page.link.category"); //$NON-NLS-0$
			navLinkCategories.forEach(function(serviceRef) {
				var info = _getPropertiesMap(serviceRef);
				if (!info.id || (!info.name && !info.nameKey)) {
					return;
				}
				info.service = serviceRegistry.getService(serviceRef);
				info.textContent = info.name;
				categoryInfos.push(new Deferred().resolve(info));				
			});
			return Deferred.all(categoryInfos).then(function(infos) {
				_cachedCategories = new CategoriesInfo(infos);
				return _cachedCategories;
			});
		}
		return new Deferred().resolve(_cachedCategories);
	}

	function CategoriesInfo(categoriesArray) {
		var categories = this.categories = Object.create(null); // Maps category id {String} to category {Object}

		categoriesArray.forEach(function(category) {
			categories[category.id] = category;
		});
	}
	objects.mixin(CategoriesInfo.prototype, /** @lends orion.CategoriesInfo.CategoriesInfo.prototype */ {
		/**
		 * Returns the category IDs.
		 * @returns {String[]} The category IDs.
		 */
		getCategoryIDs: function() {
			return Object.keys(this.categories);
		},
		/**
		 * Returns the data for a given category.
		 * @param {String} id The category ID.
		 * @returns {Object} The category data.
		 */
		getCategory: function(id) {
			return this.categories[id] || null;
		}
	});

	/**
	 * @name orion.PageLinks.PageLinksInfo
	 * @class
	 * @description Provides access to info about page links read from an extension point.
	 */
	function PageLinksInfo(allPageLinks) {
		this.allPageLinks = allPageLinks;
		this.allPageLinks.sort(_comparePageLinks);
	}
	objects.mixin(PageLinksInfo.prototype, /** @lends orion.PageLinks.PageLinksInfo.prototype */ {
		/**
		 * Builds DOM elements for links
		 * @returns {Element[]} The links.
		 */
		createLinkElements: function() {
			return this.allPageLinks.map(function(info) {
				return _createLink(info.href, "_self", info.textContent); //$NON-NLS-0$
			});
		},
		/**
		 * @returns {Object[]} The links.
		 */
		getAllLinks: function() {
			return this.allPageLinks;
		}
	});

	function _comparePageLinks(a, b) {
		var n1 = a.textContent && a.textContent.toLowerCase();
		var n2 = b.textContent && b.textContent.toLowerCase();
		if (n1 < n2) { return -1; }
		if (n1 > n2) { return 1; }
		return 0;
	}

	function _createLink(href, target, textContent) {
		var a = document.createElement("a");
		a.href = href;
		a.target = target;
		a.classList.add("targetSelector");
		a.textContent = textContent;
		return a;
	}

	/**
	 * @name orion.PageLinks
	 * @class Utilities for reading <code>orion.page.link</code> services.
	 * @description Utilities for reading <code>orion.page.link</code> services.
	 */
	return {
		getCategoriesInfo: getCategoriesInfo,
		getPageLinksInfo: getPageLinksInfo,
		getOrionHome: getOrionHome
	};
});
