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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.web.server.IRequestData;
import org.eclipse.xtext.web.server.IServiceResult;
import org.eclipse.xtext.web.server.InvalidRequestException;
import org.eclipse.xtext.web.server.XtextServiceDispatcher;
import org.eclipse.xtext.web.servlet.HttpServletRequestData;
import org.eclipse.xtext.web.servlet.HttpServletSessionStore;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;

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
      if (_t instanceof InvalidRequestException) {
        final InvalidRequestException ire = (InvalidRequestException)_t;
        String _requestURI = req.getRequestURI();
        String _plus = ("Invalid request (" + _requestURI);
        String _plus_1 = (_plus + "): ");
        String _message = ire.getMessage();
        String _plus_2 = (_plus_1 + _message);
        this.LOG.trace(_plus_2);
        int _switchResult = (int) 0;
        InvalidRequestException.Type _type = ire.getType();
        if (_type != null) {
          switch (_type) {
            case RESOURCE_NOT_FOUND:
              _switchResult = HttpServletResponse.SC_NOT_FOUND;
              break;
            case INVALID_DOCUMENT_STATE:
              _switchResult = HttpServletResponse.SC_CONFLICT;
              break;
            case PERMISSION_DENIED:
              _switchResult = HttpServletResponse.SC_FORBIDDEN;
              break;
            default:
              _switchResult = HttpServletResponse.SC_BAD_REQUEST;
              break;
          }
        } else {
          _switchResult = HttpServletResponse.SC_BAD_REQUEST;
        }
        final int statusCode = _switchResult;
        String _message_1 = ire.getMessage();
        resp.sendError(statusCode, _message_1);
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
        boolean _isHasTextInput = service.isHasTextInput();
        _or = _isHasTextInput;
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
    boolean _and = false;
    boolean _isHasConflict = service.isHasConflict();
    boolean _not = (!_isHasConflict);
    if (!_not) {
      _and = false;
    } else {
      String _type = service.getType();
      boolean _notEquals = (!Objects.equal(_type, "update"));
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
        boolean _isHasTextInput = service.isHasTextInput();
        boolean _not_2 = (!_isHasTextInput);
        _and_1 = _not_2;
      }
      if (_and_1) {
        _or = true;
      } else {
        String _type = service.getType();
        boolean _equals = Objects.equal(_type, "update");
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
  
  protected void doService(final XtextServiceDispatcher.ServiceDescriptor service, final HttpServletResponse response) {
    try {
      Function0<? extends IServiceResult> _service = service.getService();
      final IServiceResult result = _service.apply();
      response.setStatus(HttpServletResponse.SC_OK);
      response.setContentType("text/x-json;charset=UTF-8");
      response.setHeader("Cache-Control", "no-cache");
      PrintWriter _writer = response.getWriter();
      this.gson.toJson(result, _writer);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected XtextServiceDispatcher.ServiceDescriptor getService(final HttpServletRequest request) {
    try {
      HttpSession _session = request.getSession();
      final HttpServletSessionStore sessionStore = new HttpServletSessionStore(_session);
      final HttpServletRequestData requestData = new HttpServletRequestData(request);
      final Injector injector = this.getInjector(requestData);
      final XtextServiceDispatcher serviceDispatcher = injector.<XtextServiceDispatcher>getInstance(XtextServiceDispatcher.class);
      final XtextServiceDispatcher.ServiceDescriptor service = serviceDispatcher.getService(requestData, sessionStore);
      this.checkPermission(request, service);
      return service;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected void checkPermission(final HttpServletRequest request, final XtextServiceDispatcher.ServiceDescriptor service) {
  }
  
  protected Injector getInjector(final IRequestData requestData) throws InvalidRequestException {
    IResourceServiceProvider resourceServiceProvider = null;
    String _elvis = null;
    String _parameter = requestData.getParameter("resource");
    if (_parameter != null) {
      _elvis = _parameter;
    } else {
      _elvis = "";
    }
    final URI emfURI = URI.createURI(_elvis);
    final String contentType = requestData.getParameter("contentType");
    if ((contentType == null)) {
      IResourceServiceProvider _resourceServiceProvider = this.serviceProviderRegistry.getResourceServiceProvider(emfURI);
      resourceServiceProvider = _resourceServiceProvider;
    } else {
      IResourceServiceProvider _resourceServiceProvider_1 = this.serviceProviderRegistry.getResourceServiceProvider(emfURI, contentType);
      resourceServiceProvider = _resourceServiceProvider_1;
    }
    boolean _equals = Objects.equal(resourceServiceProvider, null);
    if (_equals) {
      throw new InvalidRequestException(InvalidRequestException.Type.UNKNOWN_LANGUAGE, "Unable to identify the Xtext language.");
    }
    return resourceServiceProvider.<Injector>get(Injector.class);
  }
}
