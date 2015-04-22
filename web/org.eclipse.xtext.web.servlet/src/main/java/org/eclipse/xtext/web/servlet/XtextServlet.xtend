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
import java.io.IOException
import java.util.Collections
import java.util.Map
import javax.inject.Inject
import javax.servlet.ServletException
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import org.eclipse.xtext.web.server.InvalidRequestException
import org.eclipse.xtext.web.server.XtextServiceDispatcher

class XtextServlet extends HttpServlet {
	
	@Inject Gson gson
	
	@Inject XtextServiceDispatcher serviceDispatcher
	
	override protected service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			super.service(req, resp)
		} catch (InvalidRequestException exception) {
			resp.sendError(exception.statusCode, exception.message)
		}
	}
	
	override protected doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		val sessionStore = new HttpServletSessionStore(req.session)
		val service = serviceDispatcher.getService(req.pathInfo ?: '', getParameterMap(req), sessionStore)
		if (service.hasSideEffects || service.hasTextInput) {
			// Send error 405 (method not allowed)
			super.doGet(req, resp)
		} else {
			doService(service, resp)
		}
	}
	
	override protected doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		val sessionStore = new HttpServletSessionStore(req.session)
		val service = serviceDispatcher.getService(req.pathInfo ?: '', getParameterMap(req), sessionStore)
		if (service.type != 'update') {
			// Send error 405 (method not allowed)
			super.doPut(req, resp)
		} else {
			doService(service, resp)
		}
	}
	
	override protected doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		val sessionStore = new HttpServletSessionStore(req.session)
		val service = serviceDispatcher.getService(req.pathInfo ?: '', getParameterMap(req), sessionStore)
		if (!service.hasSideEffects && !service.hasTextInput || service.type == 'update') {
			// Send error 405 (method not allowed)
			super.doPost(req, resp)
		} else {
			doService(service, resp)
		}
	}
	
	protected def getParameterMap(HttpServletRequest req) {
		val paramMultiMap = req.parameterMap as Map<String, String[]>
		val result = Maps.newHashMapWithExpectedSize(paramMultiMap.size)
		paramMultiMap.entrySet.filter[value.length > 0].forEach[result.put(key, value.get(0))]
		return Collections.unmodifiableMap(result)
	}
	
	protected def doService(XtextServiceDispatcher.ServiceDescriptor service, HttpServletResponse resp) {
		val result = service.service.apply()
		resp.setStatus(HttpServletResponse.SC_OK)
		resp.setContentType("text/x-json;charset=UTF-8")
		resp.setHeader("Cache-Control", "no-cache")
		resp.writer.write(gson.toJson(result))
	}
	
}