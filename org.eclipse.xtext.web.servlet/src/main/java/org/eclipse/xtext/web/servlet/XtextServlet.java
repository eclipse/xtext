/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.web.servlet;

import java.io.IOException;
import java.util.Objects;
import java.util.Set;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.web.server.IServiceContext;
import org.eclipse.xtext.web.server.IServiceResult;
import org.eclipse.xtext.web.server.IUnwrappableServiceResult;
import org.eclipse.xtext.web.server.InvalidRequestException;
import org.eclipse.xtext.web.server.XtextServiceDispatcher;
import org.eclipse.xtext.xbase.lib.Exceptions;

import com.google.common.base.Strings;
import com.google.gson.Gson;
import com.google.inject.Injector;

/**
 * An HTTP servlet for publishing the Xtext services. Include this into your web
 * server by creating a subclass that executes the standalone setups of your
 * languages in its {@link #init()} method:
 * 
 * <pre>
 * &#64;WebServlet(name = "Xtext Services", urlPatterns = "/xtext-service/*")
 * class MyXtextServlet extends XtextServlet {
 * 	override init() {
 * 		super.init();
 * 		MyDslWebSetup.doSetup();
 * 	}
 * }
 * </pre>
 * 
 * Use the {@code WebServlet} annotation to register your servlet. The default
 * URL pattern for Xtext services is {@code "/xtext-service/*"}.
 */
public class XtextServlet extends HttpServlet {

	private static final long serialVersionUID = -6273795508296110114L;

	private final Logger LOG = Logger.getLogger(this.getClass());

	private final IResourceServiceProvider.Registry serviceProviderRegistry = IResourceServiceProvider.Registry.INSTANCE;

	private final Gson gson = new Gson();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			super.service(req, resp);
		} catch (InvalidRequestException.ResourceNotFoundException exception) {
			LOG.trace("Invalid request (" + req.getRequestURI() + "): " + exception.getMessage());
			resp.sendError(HttpServletResponse.SC_NOT_FOUND, exception.getMessage());
		} catch (InvalidRequestException.InvalidDocumentStateException exception) {
			LOG.trace("Invalid request (" + req.getRequestURI() + "): " + exception.getMessage());
			resp.sendError(HttpServletResponse.SC_CONFLICT, exception.getMessage());
		} catch (InvalidRequestException.PermissionDeniedException exception) {
			LOG.trace("Invalid request (" + req.getRequestURI() + "): " + exception.getMessage());
			resp.sendError(HttpServletResponse.SC_FORBIDDEN, exception.getMessage());
		} catch (InvalidRequestException exception) {
			LOG.trace("Invalid request (" + req.getRequestURI() + "): " + exception.getMessage());
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST, exception.getMessage());
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		XtextServiceDispatcher.ServiceDescriptor service = getService(req);
		if (!service.isHasConflict() && (service.isHasSideEffects() || hasTextInput(service))) {
			super.doGet(req, resp);
		} else {
			doService(service, resp);
		}
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		XtextServiceDispatcher.ServiceDescriptor service = getService(req);
		String type = service.getContext().getParameter(IServiceContext.SERVICE_TYPE);
		if (!service.isHasConflict() && !Objects.equals(type, "update")) {
			super.doPut(req, resp);
		} else {
			doService(service, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		XtextServiceDispatcher.ServiceDescriptor service = getService(req);
		String type = service.getContext().getParameter(IServiceContext.SERVICE_TYPE);
		if (!service.isHasConflict()
				&& (!service.isHasSideEffects() && !hasTextInput(service) || Objects.equals(type, "update"))) {
			super.doPost(req, resp);
		} else {
			doService(service, resp);
		}
	}

	protected boolean hasTextInput(XtextServiceDispatcher.ServiceDescriptor service) {
		Set<String> parameterKeys = service.getContext().getParameterKeys();
		return parameterKeys.contains("fullText") || parameterKeys.contains("deltaText");
	}

	/**
	 * Retrieve the service metadata for the given request. This involves resolving
	 * the Guice injector for the respective language, querying the
	 * {@link XtextServiceDispatcher}, and checking the permission to invoke the
	 * service.
	 */
	protected XtextServiceDispatcher.ServiceDescriptor getService(HttpServletRequest request)
			throws InvalidRequestException {
		HttpServiceContext serviceContext = new HttpServiceContext(request);
		Injector injector = getInjector(serviceContext);
		XtextServiceDispatcher serviceDispatcher = injector.getInstance(XtextServiceDispatcher.class);
		XtextServiceDispatcher.ServiceDescriptor service = serviceDispatcher.getService(serviceContext);
		return service;
	}

	/**
	 * Invoke the service function of the given service descriptor and write its
	 * result to the servlet response in Json format. An exception is made for
	 * {@link IUnwrappableServiceResult}: here the document itself is written into
	 * the response instead of wrapping it into a Json object.
	 */
	protected void doService(XtextServiceDispatcher.ServiceDescriptor service, HttpServletResponse response) {
		try {
			IServiceResult result = service.getService().apply();
			response.setStatus(HttpServletResponse.SC_OK);
			response.setCharacterEncoding(getEncoding(service, result));
			response.setHeader("Cache-Control", "no-cache");
			if (result instanceof IUnwrappableServiceResult
					&& ((IUnwrappableServiceResult) result).getContent() != null) {
				IUnwrappableServiceResult unwrapResult = ((IUnwrappableServiceResult) result);
				String contentType = null;
				if (unwrapResult.getContentType() != null) {
					contentType = unwrapResult.getContentType();
				} else {
					contentType = "text/plain";
				}
				response.setContentType(contentType);
				response.getWriter().write(unwrapResult.getContent());
			} else {
				response.setContentType("text/x-json");
				gson.toJson(result, response.getWriter());
			}
		} catch (IOException e) {
			throw Exceptions.sneakyThrow(e);
		}
	}

	/**
	 * Determine the encoding to apply to servlet responses. The default is UTF-8.
	 */
	protected String getEncoding(XtextServiceDispatcher.ServiceDescriptor service, IServiceResult result) {
		return "UTF-8";
	}

	/**
	 * Resolve the Guice injector for the language associated with the given
	 * context.
	 */
	protected Injector getInjector(HttpServiceContext serviceContext)
			throws InvalidRequestException.UnknownLanguageException {
		IResourceServiceProvider resourceServiceProvider = null;
		String parameter = serviceContext.getParameter("resource");
		if (parameter == null) {
			parameter = "";
		}
		URI emfURI = URI.createURI(parameter);
		String contentType = serviceContext.getParameter("contentType");
		if (Strings.isNullOrEmpty(contentType)) {
			resourceServiceProvider = serviceProviderRegistry.getResourceServiceProvider(emfURI);
			if (resourceServiceProvider == null) {
				if (emfURI.toString().isEmpty()) {
					throw new InvalidRequestException.UnknownLanguageException(
							"Unable to identify the Xtext language: missing parameter 'resource' or 'contentType'.");
				} else {
					throw new InvalidRequestException.UnknownLanguageException(
							"Unable to identify the Xtext language for resource " + emfURI + ".");
				}
			}
		} else {
			resourceServiceProvider = serviceProviderRegistry.getResourceServiceProvider(emfURI, contentType);
			if (resourceServiceProvider == null) {
				throw new InvalidRequestException.UnknownLanguageException(
						"Unable to identify the Xtext language for contentType " + contentType + ".");
			}
		}
		return resourceServiceProvider.get(Injector.class);
	}
}
