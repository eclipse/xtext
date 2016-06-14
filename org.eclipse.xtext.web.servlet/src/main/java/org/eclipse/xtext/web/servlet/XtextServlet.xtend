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
import org.eclipse.xtext.web.server.IServiceContext
import org.eclipse.xtext.web.server.IServiceResult
import org.eclipse.xtext.web.server.IUnwrappableServiceResult
import org.eclipse.xtext.web.server.InvalidRequestException
import org.eclipse.xtext.web.server.InvalidRequestException.InvalidDocumentStateException
import org.eclipse.xtext.web.server.InvalidRequestException.PermissionDeniedException
import org.eclipse.xtext.web.server.InvalidRequestException.ResourceNotFoundException
import org.eclipse.xtext.web.server.InvalidRequestException.UnknownLanguageException
import org.eclipse.xtext.web.server.XtextServiceDispatcher

/**
 * An HTTP servlet for publishing the Xtext services. Include this into your web server by creating
 * a subclass that executes the standalone setups of your languages in its {@link #init()} method:
 * 
 * <pre>
 * &#64;WebServlet(name = "Xtext Services", urlPatterns = "/xtext-service/*")
 * class MyXtextServlet extends XtextServlet {
 *     override init() {
 *         super.init();
 *         MyDslWebSetup.doSetup();
 *     }
 * }
 * </pre>
 * 
 * Use the {@code WebServlet} annotation to register your servlet. The default URL pattern for
 * Xtext services is {@code "/xtext-service/*"}.
 */
class XtextServlet extends HttpServlet {
	
	val LOG = Logger.getLogger(class)
	
	val serviceProviderRegistry = IResourceServiceProvider.Registry.INSTANCE
	
	val gson = new Gson
	
	override protected service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			super.service(req, resp)
		} catch (ResourceNotFoundException exception) {
			LOG.trace('Invalid request (' + req.requestURI + '): ' + exception.message)
			resp.sendError(HttpServletResponse.SC_NOT_FOUND, exception.message)
		} catch (InvalidDocumentStateException exception) {
			LOG.trace('Invalid request (' + req.requestURI + '): ' + exception.message)
			resp.sendError(HttpServletResponse.SC_CONFLICT, exception.message)
		} catch (PermissionDeniedException exception) {
			LOG.trace('Invalid request (' + req.requestURI + '): ' + exception.message)
			resp.sendError(HttpServletResponse.SC_FORBIDDEN, exception.message)
		} catch (InvalidRequestException exception) {
			LOG.trace('Invalid request (' + req.requestURI + '): ' + exception.message)
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST, exception.message)
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
		val type = service.context.getParameter(IServiceContext.SERVICE_TYPE)
		if (!service.hasConflict && type != 'update') {
			// Send error 405 (method not allowed)
			super.doPut(req, resp)
		} else {
			doService(service, resp)
		}
	}
	
	override protected doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		val service = getService(req)
		val type = service.context.getParameter(IServiceContext.SERVICE_TYPE)
		if (!service.hasConflict && (!service.hasSideEffects && !service.hasTextInput || type == 'update')) {
			// Send error 405 (method not allowed)
			super.doPost(req, resp)
		} else {
			doService(service, resp)
		}
	}
	
	protected def hasTextInput(XtextServiceDispatcher.ServiceDescriptor service) {
		val parameterKeys = service.context.parameterKeys
		parameterKeys.contains('fullText') || parameterKeys.contains('deltaText')
	}
	
	/**
	 * Retrieve the service metadata for the given request. This involves resolving the Guice
	 * injector for the respective language, querying the {@link XtextServiceDispatcher}, and
	 * checking the permission to invoke the service.
	 */
	protected def XtextServiceDispatcher.ServiceDescriptor getService(HttpServletRequest request) throws InvalidRequestException {
		val serviceContext = new HttpServiceContext(request)
		val injector = getInjector(serviceContext)
		val serviceDispatcher = injector.getInstance(XtextServiceDispatcher)
		val service = serviceDispatcher.getService(serviceContext)
		return service
	}
	
	/**
	 * Invoke the service function of the given service descriptor and write its result to the
	 * servlet response in Json format. An exception is made for {@link IUnwrappableServiceResult}:
	 * here the document itself is written into the response instead of wrapping it into a Json object.
	 */
	protected def void doService(XtextServiceDispatcher.ServiceDescriptor service, HttpServletResponse response) {
		val result = service.service.apply()
		response.status = HttpServletResponse.SC_OK
		response.characterEncoding = getEncoding(service, result)
		response.setHeader('Cache-Control', 'no-cache')
		
		if (result instanceof IUnwrappableServiceResult && (result as IUnwrappableServiceResult).content !== null) {
			val unwrapResult = result as IUnwrappableServiceResult
			response.contentType = unwrapResult.contentType ?: 'text/plain'
			response.writer.write(unwrapResult.content)
		} else {
			response.contentType = 'text/x-json'
			gson.toJson(result, response.writer)
		}
	}
	
	/**
	 * Determine the encoding to apply to servlet responses. The default is UTF-8.
	 */
	protected def String getEncoding(XtextServiceDispatcher.ServiceDescriptor service, IServiceResult result) {
		'UTF-8'
	}
	
	/**
	 * Resolve the Guice injector for the language associated with the given context.
	 */
	protected def Injector getInjector(HttpServiceContext serviceContext) throws UnknownLanguageException {
		var IResourceServiceProvider resourceServiceProvider
		
		val emfURI = URI.createURI(serviceContext.getParameter('resource') ?: '')
		val contentType = serviceContext.getParameter('contentType')
		if (contentType.nullOrEmpty) {
			resourceServiceProvider = serviceProviderRegistry.getResourceServiceProvider(emfURI)
			if (resourceServiceProvider === null) {
				if (emfURI.toString.empty)
					throw new UnknownLanguageException('''Unable to identify the Xtext language: missing parameter 'resource' or 'contentType'.''')
				else
					throw new UnknownLanguageException('''Unable to identify the Xtext language for resource «emfURI».''')
			}
		}
		else {
			resourceServiceProvider = serviceProviderRegistry.getResourceServiceProvider(emfURI, contentType)
			if (resourceServiceProvider === null)
				throw new UnknownLanguageException('''Unable to identify the Xtext language for contentType «contentType».''')
		}
		return resourceServiceProvider.get(Injector)
	}
	
}