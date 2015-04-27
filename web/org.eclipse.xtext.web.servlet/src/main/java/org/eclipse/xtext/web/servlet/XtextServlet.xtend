/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.servlet

import com.google.common.collect.Maps
import com.google.gson.Gson
import com.google.inject.Injector
import java.io.IOException
import java.util.Collections
import java.util.Map
import javax.servlet.ServletException
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import org.apache.log4j.Logger
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.resource.IResourceServiceProvider
import org.eclipse.xtext.service.OperationCanceledError
import org.eclipse.xtext.web.server.IServiceResult
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
				case RESOURCE_NOT_FOUND: 404
				case INVALID_DOCUMENT_STATE: 409
				default: 400
			}
			resp.sendError(statusCode, ire.message)
		} catch (OperationCanceledError oce) {
			LOG.trace('Service canceled (' + req.requestURI + ')')
			resp.sendError(409, 'The requested service has been canceled by another request.')
		}
	}
	
	override protected doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		val service = getService(req)
		if (service.hasSideEffects || service.hasTextInput) {
			// Send error 405 (method not allowed)
			super.doGet(req, resp)
		} else {
			doService(service, resp)
		}
	}
	
	override protected doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		val service = getService(req)
		if (service.type != 'update') {
			// Send error 405 (method not allowed)
			super.doPut(req, resp)
		} else {
			doService(service, resp)
		}
	}
	
	override protected doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		val service = getService(req)
		if (!service.hasSideEffects && !service.hasTextInput || service.type == 'update') {
			// Send error 405 (method not allowed)
			super.doPost(req, resp)
		} else {
			doService(service, resp)
		}
	}
	
	protected def doService(XtextServiceDispatcher.ServiceDescriptor service, HttpServletResponse resp) {
		var IServiceResult result
		result = service.service.apply()
		resp.setStatus(HttpServletResponse.SC_OK)
		resp.setContentType("text/x-json;charset=UTF-8")
		resp.setHeader("Cache-Control", "no-cache")
		resp.writer.write(gson.toJson(result))
	}
	
	protected def getService(HttpServletRequest req) {
		val sessionStore = new HttpServletSessionStore(req.session)
		val parameters = getParameterMap(req)
		val injector = getInjector(parameters)
		val serviceDispatcher = injector.getInstance(XtextServiceDispatcher)
		return serviceDispatcher.getService(req.pathInfo ?: '', parameters, sessionStore)
	}
	
	protected def getParameterMap(HttpServletRequest req) {
		val paramMultiMap = req.parameterMap as Map<String, String[]>
		val result = Maps.newHashMapWithExpectedSize(paramMultiMap.size)
		paramMultiMap.entrySet.filter[value.length > 0].forEach[result.put(key, value.get(0))]
		return Collections.unmodifiableMap(result)
	}
	
	protected def getInjector(Map<String, String> parameters) throws InvalidRequestException {
		var IResourceServiceProvider resourceServiceProvider
		
		val emfURI = URI.createURI(parameters.get('resource') ?: '')
		val contentType = parameters.get('contentType')
		if (contentType === null)
			resourceServiceProvider = serviceProviderRegistry.getResourceServiceProvider(emfURI)
		else
			resourceServiceProvider = serviceProviderRegistry.getResourceServiceProvider(emfURI, contentType)
		
		if (resourceServiceProvider == null)
			throw new InvalidRequestException(UNKNOWN_LANGUAGE, 'Unable to identify the Xtext language.')
		
		return resourceServiceProvider.get(Injector)
	}
	
}