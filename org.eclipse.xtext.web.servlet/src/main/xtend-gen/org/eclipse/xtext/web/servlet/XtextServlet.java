/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.web.servlet;

import com.google.common.base.Objects;
import com.google.gson.Gson;
import com.google.inject.Injector;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.web.server.IServiceContext;
import org.eclipse.xtext.web.server.IServiceResult;
import org.eclipse.xtext.web.server.IUnwrappableServiceResult;
import org.eclipse.xtext.web.server.InvalidRequestException;
import org.eclipse.xtext.web.server.XtextServiceDispatcher;
import org.eclipse.xtext.web.servlet.HttpServiceContext;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.StringExtensions;

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
@SuppressWarnings("all")
public class XtextServlet extends HttpServlet {
  private final Logger LOG = Logger.getLogger(this.getClass());
  
  private final IResourceServiceProvider.Registry serviceProviderRegistry = IResourceServiceProvider.Registry.INSTANCE;
  
  private final Gson gson = new Gson();
  
  @Override
  protected void service(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
    try {
      super.service(req, resp);
    } catch (final Throwable _t) {
      if (_t instanceof InvalidRequestException.ResourceNotFoundException) {
        final InvalidRequestException.ResourceNotFoundException exception = (InvalidRequestException.ResourceNotFoundException)_t;
        String _requestURI = req.getRequestURI();
        String _plus = ("Invalid request (" + _requestURI);
        String _plus_1 = (_plus + "): ");
        String _message = exception.getMessage();
        String _plus_2 = (_plus_1 + _message);
        this.LOG.trace(_plus_2);
        String _message_1 = exception.getMessage();
        resp.sendError(HttpServletResponse.SC_NOT_FOUND, _message_1);
      } else if (_t instanceof InvalidRequestException.InvalidDocumentStateException) {
        final InvalidRequestException.InvalidDocumentStateException exception_1 = (InvalidRequestException.InvalidDocumentStateException)_t;
        String _requestURI_1 = req.getRequestURI();
        String _plus_3 = ("Invalid request (" + _requestURI_1);
        String _plus_4 = (_plus_3 + "): ");
        String _message_2 = exception_1.getMessage();
        String _plus_5 = (_plus_4 + _message_2);
        this.LOG.trace(_plus_5);
        String _message_3 = exception_1.getMessage();
        resp.sendError(HttpServletResponse.SC_CONFLICT, _message_3);
      } else if (_t instanceof InvalidRequestException.PermissionDeniedException) {
        final InvalidRequestException.PermissionDeniedException exception_2 = (InvalidRequestException.PermissionDeniedException)_t;
        String _requestURI_2 = req.getRequestURI();
        String _plus_6 = ("Invalid request (" + _requestURI_2);
        String _plus_7 = (_plus_6 + "): ");
        String _message_4 = exception_2.getMessage();
        String _plus_8 = (_plus_7 + _message_4);
        this.LOG.trace(_plus_8);
        String _message_5 = exception_2.getMessage();
        resp.sendError(HttpServletResponse.SC_FORBIDDEN, _message_5);
      } else if (_t instanceof InvalidRequestException) {
        final InvalidRequestException exception_3 = (InvalidRequestException)_t;
        String _requestURI_3 = req.getRequestURI();
        String _plus_9 = ("Invalid request (" + _requestURI_3);
        String _plus_10 = (_plus_9 + "): ");
        String _message_6 = exception_3.getMessage();
        String _plus_11 = (_plus_10 + _message_6);
        this.LOG.trace(_plus_11);
        String _message_7 = exception_3.getMessage();
        resp.sendError(HttpServletResponse.SC_BAD_REQUEST, _message_7);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  @Override
  protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
    final XtextServiceDispatcher.ServiceDescriptor service = this.getService(req);
    if (((!service.isHasConflict()) && (service.isHasSideEffects() || this.hasTextInput(service)))) {
      super.doGet(req, resp);
    } else {
      this.doService(service, resp);
    }
  }
  
  @Override
  protected void doPut(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
    final XtextServiceDispatcher.ServiceDescriptor service = this.getService(req);
    IServiceContext _context = service.getContext();
    final String type = _context.getParameter(IServiceContext.SERVICE_TYPE);
    if (((!service.isHasConflict()) && (!Objects.equal(type, "update")))) {
      super.doPut(req, resp);
    } else {
      this.doService(service, resp);
    }
  }
  
  @Override
  protected void doPost(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
    final XtextServiceDispatcher.ServiceDescriptor service = this.getService(req);
    IServiceContext _context = service.getContext();
    final String type = _context.getParameter(IServiceContext.SERVICE_TYPE);
    if (((!service.isHasConflict()) && (((!service.isHasSideEffects()) && (!this.hasTextInput(service))) || Objects.equal(type, "update")))) {
      super.doPost(req, resp);
    } else {
      this.doService(service, resp);
    }
  }
  
  protected boolean hasTextInput(final XtextServiceDispatcher.ServiceDescriptor service) {
    boolean _xblockexpression = false;
    {
      IServiceContext _context = service.getContext();
      final Set<String> parameterKeys = _context.getParameterKeys();
      _xblockexpression = (parameterKeys.contains("fullText") || parameterKeys.contains("deltaText"));
    }
    return _xblockexpression;
  }
  
  /**
   * Retrieve the service metadata for the given request. This involves resolving the Guice
   * injector for the respective language, querying the {@link XtextServiceDispatcher}, and
   * checking the permission to invoke the service.
   */
  protected XtextServiceDispatcher.ServiceDescriptor getService(final HttpServletRequest request) throws InvalidRequestException {
    final HttpServiceContext serviceContext = new HttpServiceContext(request);
    final Injector injector = this.getInjector(serviceContext);
    final XtextServiceDispatcher serviceDispatcher = injector.<XtextServiceDispatcher>getInstance(XtextServiceDispatcher.class);
    final XtextServiceDispatcher.ServiceDescriptor service = serviceDispatcher.getService(serviceContext);
    return service;
  }
  
  /**
   * Invoke the service function of the given service descriptor and write its result to the
   * servlet response in Json format. An exception is made for {@link IUnwrappableServiceResult}:
   * here the document itself is written into the response instead of wrapping it into a Json object.
   */
  protected void doService(final XtextServiceDispatcher.ServiceDescriptor service, final HttpServletResponse response) {
    try {
      Function0<? extends IServiceResult> _service = service.getService();
      final IServiceResult result = _service.apply();
      response.setStatus(HttpServletResponse.SC_OK);
      String _encoding = this.getEncoding(service, result);
      response.setCharacterEncoding(_encoding);
      response.setHeader("Cache-Control", "no-cache");
      if (((result instanceof IUnwrappableServiceResult) && (((IUnwrappableServiceResult) result).getContent() != null))) {
        final IUnwrappableServiceResult unwrapResult = ((IUnwrappableServiceResult) result);
        String _elvis = null;
        String _contentType = unwrapResult.getContentType();
        if (_contentType != null) {
          _elvis = _contentType;
        } else {
          _elvis = "text/plain";
        }
        response.setContentType(_elvis);
        PrintWriter _writer = response.getWriter();
        String _content = unwrapResult.getContent();
        _writer.write(_content);
      } else {
        response.setContentType("text/x-json");
        PrintWriter _writer_1 = response.getWriter();
        this.gson.toJson(result, _writer_1);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * Determine the encoding to apply to servlet responses. The default is UTF-8.
   */
  protected String getEncoding(final XtextServiceDispatcher.ServiceDescriptor service, final IServiceResult result) {
    return "UTF-8";
  }
  
  /**
   * Resolve the Guice injector for the language associated with the given context.
   */
  protected Injector getInjector(final HttpServiceContext serviceContext) throws InvalidRequestException.UnknownLanguageException {
    IResourceServiceProvider resourceServiceProvider = null;
    String _elvis = null;
    String _parameter = serviceContext.getParameter("resource");
    if (_parameter != null) {
      _elvis = _parameter;
    } else {
      _elvis = "";
    }
    final URI emfURI = URI.createURI(_elvis);
    final String contentType = serviceContext.getParameter("contentType");
    boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(contentType);
    if (_isNullOrEmpty) {
      IResourceServiceProvider _resourceServiceProvider = this.serviceProviderRegistry.getResourceServiceProvider(emfURI);
      resourceServiceProvider = _resourceServiceProvider;
      if ((resourceServiceProvider == null)) {
        String _string = emfURI.toString();
        boolean _isEmpty = _string.isEmpty();
        if (_isEmpty) {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("Unable to identify the Xtext language: missing parameter \'resource\' or \'contentType\'.");
          throw new InvalidRequestException.UnknownLanguageException(_builder.toString());
        } else {
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("Unable to identify the Xtext language for resource ");
          _builder_1.append(emfURI, "");
          _builder_1.append(".");
          throw new InvalidRequestException.UnknownLanguageException(_builder_1.toString());
        }
      }
    } else {
      IResourceServiceProvider _resourceServiceProvider_1 = this.serviceProviderRegistry.getResourceServiceProvider(emfURI, contentType);
      resourceServiceProvider = _resourceServiceProvider_1;
      if ((resourceServiceProvider == null)) {
        StringConcatenation _builder_2 = new StringConcatenation();
        _builder_2.append("Unable to identify the Xtext language for contentType ");
        _builder_2.append(contentType, "");
        _builder_2.append(".");
        throw new InvalidRequestException.UnknownLanguageException(_builder_2.toString());
      }
    }
    return resourceServiceProvider.<Injector>get(Injector.class);
  }
}
