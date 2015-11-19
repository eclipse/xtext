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
import java.util.List;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.web.server.IServiceContext;
import org.eclipse.xtext.web.server.IServiceResult;
import org.eclipse.xtext.web.server.InvalidRequestException;
import org.eclipse.xtext.web.server.XtextServiceDispatcher;
import org.eclipse.xtext.web.server.generator.GeneratorResult;
import org.eclipse.xtext.web.servlet.HttpServiceContext;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
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
    boolean _and = false;
    boolean _isHasConflict = service.isHasConflict();
    boolean _not = (!_isHasConflict);
    if (!_not) {
      _and = false;
    } else {
      boolean _or = false;
      boolean _isHasSideEffects = service.isHasSideEffects();
      if (_isHasSideEffects) {
        _or = true;
      } else {
        boolean _hasTextInput = this.hasTextInput(service);
        _or = _hasTextInput;
      }
      _and = _or;
    }
    if (_and) {
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
    boolean _and = false;
    boolean _isHasConflict = service.isHasConflict();
    boolean _not = (!_isHasConflict);
    if (!_not) {
      _and = false;
    } else {
      boolean _notEquals = (!Objects.equal(type, "update"));
      _and = _notEquals;
    }
    if (_and) {
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
    boolean _and = false;
    boolean _isHasConflict = service.isHasConflict();
    boolean _not = (!_isHasConflict);
    if (!_not) {
      _and = false;
    } else {
      boolean _or = false;
      boolean _and_1 = false;
      boolean _isHasSideEffects = service.isHasSideEffects();
      boolean _not_1 = (!_isHasSideEffects);
      if (!_not_1) {
        _and_1 = false;
      } else {
        boolean _hasTextInput = this.hasTextInput(service);
        boolean _not_2 = (!_hasTextInput);
        _and_1 = _not_2;
      }
      if (_and_1) {
        _or = true;
      } else {
        boolean _equals = Objects.equal(type, "update");
        _or = _equals;
      }
      _and = _or;
    }
    if (_and) {
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
      boolean _or = false;
      boolean _contains = parameterKeys.contains("fullText");
      if (_contains) {
        _or = true;
      } else {
        boolean _contains_1 = parameterKeys.contains("deltaText");
        _or = _contains_1;
      }
      _xblockexpression = _or;
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
   * servlet response in Json format. An exception is made for code generation where exactly
   * one document is generated and a content type is assigned to it. In this case the document
   * itself is written into the response instead of wrapping it into a Json object.
   */
  protected void doService(final XtextServiceDispatcher.ServiceDescriptor service, final HttpServletResponse response) {
    try {
      Function0<? extends IServiceResult> _service = service.getService();
      final IServiceResult result = _service.apply();
      response.setStatus(HttpServletResponse.SC_OK);
      String _encoding = this.getEncoding(service);
      response.setCharacterEncoding(_encoding);
      response.setHeader("Cache-Control", "no-cache");
      boolean _and = false;
      if (!(result instanceof GeneratorResult)) {
        _and = false;
      } else {
        List<GeneratorResult.GeneratedDocument> _documents = ((GeneratorResult) result).getDocuments();
        int _size = _documents.size();
        boolean _equals = (_size == 1);
        _and = _equals;
      }
      if (_and) {
        List<GeneratorResult.GeneratedDocument> _documents_1 = ((GeneratorResult) result).getDocuments();
        final GeneratorResult.GeneratedDocument document = IterableExtensions.<GeneratorResult.GeneratedDocument>head(_documents_1);
        String _contentType = document.getContentType();
        boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(_contentType);
        boolean _not = (!_isNullOrEmpty);
        if (_not) {
          String _contentType_1 = document.getContentType();
          response.setContentType(_contentType_1);
          PrintWriter _writer = response.getWriter();
          String _content = document.getContent();
          _writer.write(_content);
          return;
        }
      }
      response.setContentType("text/x-json");
      PrintWriter _writer_1 = response.getWriter();
      this.gson.toJson(result, _writer_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * Determine the encoding to apply to servlet responses. The default is UTF-8.
   */
  protected String getEncoding(final XtextServiceDispatcher.ServiceDescriptor service) {
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
    if ((contentType == null)) {
      IResourceServiceProvider _resourceServiceProvider = this.serviceProviderRegistry.getResourceServiceProvider(emfURI);
      resourceServiceProvider = _resourceServiceProvider;
    } else {
      IResourceServiceProvider _resourceServiceProvider_1 = this.serviceProviderRegistry.getResourceServiceProvider(emfURI, contentType);
      resourceServiceProvider = _resourceServiceProvider_1;
    }
    boolean _equals = Objects.equal(resourceServiceProvider, null);
    if (_equals) {
      throw new InvalidRequestException.UnknownLanguageException("Unable to identify the Xtext language.");
    }
    return resourceServiceProvider.<Injector>get(Injector.class);
  }
}
