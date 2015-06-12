/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.servlet

import com.google.gson.Gson
import com.google.inject.Injector
import java.io.IOException
import javax.servlet.ServletException
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import org.apache.log4j.Logger
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.resource.IResourceServiceProvider
import org.eclipse.xtext.web.server.IRequestData
import org.eclipse.xtext.web.server.InvalidRequestException
import org.eclipse.xtext.web.server.XtextServiceDispatcher

import static org.eclipse.xtext.web.server.InvalidRequestException.Type.*

class XtextServlet extends HttpServlet {
	
	val LOG = Logger.getLogger(class)
	
	val serviceProviderRegistry = IResourceServiceProvider.Registry.INSTANCE
	
	val gson = new Gson
	
	override protected service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			super.service(req, resp)
		} catch (InvalidRequestException ire) {
			LOG.trace('Invalid request (' + req.requestURI + '): ' + ire.message)
			val statusCode = switch ire.type {
				case RESOURCE_NOT_FOUND: HttpServletResponse.SC_NOT_FOUND
				case INVALID_DOCUMENT_STATE: HttpServletResponse.SC_CONFLICT
				case PERMISSION_DENIED: HttpServletResponse.SC_FORBIDDEN
				default: HttpServletResponse.SC_BAD_REQUEST
			}
			resp.sendError(statusCode, ire.message)
		}
	}
	
	override protected doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		val service = getService(req)
		if (!service.hasConflict && (service.hasSideEffects || service.hasTextInput)) {
			// Send error 405 (method not allowed)
			super.doGet(req, resp)
		} else {
			doService(service, resp)
		}
	}
	
	override protected doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		val service = getService(req)
		if (!service.hasConflict && service.type != 'update') {
			// Send error 405 (method not allowed)
			super.doPut(req, resp)
		} else {
			doService(service, resp)
		}
	}
	
	override protected doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		val service = getService(req)
		if (!service.hasConflict && (!service.hasSideEffects && !service.hasTextInput || service.type == 'update')) {
			// Send error 405 (method not allowed)
			super.doPost(req, resp)
		} else {
			doService(service, resp)
		}
	}
	
	protected def doService(XtextServiceDispatcher.ServiceDescriptor service, HttpServletResponse response) {
		val result = service.service.apply()
		response.setStatus(HttpServletResponse.SC_OK)
		response.setContentType("text/x-json;charset=UTF-8")
		response.setHeader("Cache-Control", "no-cache")
		gson.toJson(result, response.writer)
	}
	
	protected def getService(HttpServletRequest request) {
		val sessionStore = new HttpServletSessionStore(request.session)
		val requestData = new HttpServletRequestData(request)
		val injector = getInjector(requestData)
		val serviceDispatcher = injector.getInstance(XtextServiceDispatcher)
		val service = serviceDispatcher.getService(requestData, sessionStore)
		checkPermission(request, service)
		return service
	}
	
	protected def void checkPermission(HttpServletRequest request, XtextServiceDispatcher.ServiceDescriptor service) {
		// Subclasses may throw InvalidRequestException(PERMISSION_DENIED, '...')
	}
	
	protected def getInjector(IRequestData requestData) throws InvalidRequestException {
		var IResourceServiceProvider resourceServiceProvider
		
		val emfURI = URI.createURI(requestData.getParameter('resource') ?: '')
		val contentType = requestData.getParameter('contentType')
		if (contentType === null)
			resourceServiceProvider = serviceProviderRegistry.getResourceServiceProvider(emfURI)
		else
			resourceServiceProvider = serviceProviderRegistry.getResourceServiceProvider(emfURI, contentType)
		
		if (resourceServiceProvider == null)
			throw new InvalidRequestException(UNKNOWN_LANGUAGE, 'Unable to identify the Xtext language.')
		
		return resourceServiceProvider.get(Injector)
	}
	
}