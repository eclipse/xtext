/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.web.servlet;

import com.google.common.base.Objects;
import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.google.inject.Injector;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.web.server.IServiceResult;
import org.eclipse.xtext.web.server.InvalidRequestException;
import org.eclipse.xtext.web.server.XtextServiceDispatcher;
import org.eclipse.xtext.web.servlet.HttpServletSessionStore;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

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
              _switchResult = 404;
              break;
            case INVALID_DOCUMENT_STATE:
              _switchResult = 409;
              break;
            default:
              _switchResult = 400;
              break;
          }
        } else {
          _switchResult = 400;
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
  
  protected void doService(final XtextServiceDispatcher.ServiceDescriptor service, final HttpServletResponse resp) {
    try {
      Function0<? extends IServiceResult> _service = service.getService();
      final IServiceResult result = _service.apply();
      resp.setStatus(HttpServletResponse.SC_OK);
      resp.setContentType("text/x-json;charset=UTF-8");
      resp.setHeader("Cache-Control", "no-cache");
      PrintWriter _writer = resp.getWriter();
      this.gson.toJson(result, _writer);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected XtextServiceDispatcher.ServiceDescriptor getService(final HttpServletRequest req) {
    try {
      HttpSession _session = req.getSession();
      final HttpServletSessionStore sessionStore = new HttpServletSessionStore(_session);
      final Map<String, String> parameters = this.getParameterMap(req);
      final Injector injector = this.getInjector(parameters);
      final XtextServiceDispatcher serviceDispatcher = injector.<XtextServiceDispatcher>getInstance(XtextServiceDispatcher.class);
      String _elvis = null;
      String _pathInfo = req.getPathInfo();
      if (_pathInfo != null) {
        _elvis = _pathInfo;
      } else {
        _elvis = "";
      }
      return serviceDispatcher.getService(_elvis, parameters, sessionStore);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected Map<String, String> getParameterMap(final HttpServletRequest req) {
    Map<String, String[]> _parameterMap = req.getParameterMap();
    final Map<String, String[]> paramMultiMap = ((Map<String, String[]>) _parameterMap);
    int _size = paramMultiMap.size();
    final HashMap<String, String> result = Maps.<String, String>newHashMapWithExpectedSize(_size);
    Set<Map.Entry<String, String[]>> _entrySet = paramMultiMap.entrySet();
    final Function1<Map.Entry<String, String[]>, Boolean> _function = new Function1<Map.Entry<String, String[]>, Boolean>() {
      @Override
      public Boolean apply(final Map.Entry<String, String[]> it) {
        String[] _value = it.getValue();
        int _length = _value.length;
        return Boolean.valueOf((_length > 0));
      }
    };
    Iterable<Map.Entry<String, String[]>> _filter = IterableExtensions.<Map.Entry<String, String[]>>filter(_entrySet, _function);
    final Procedure1<Map.Entry<String, String[]>> _function_1 = new Procedure1<Map.Entry<String, String[]>>() {
      @Override
      public void apply(final Map.Entry<String, String[]> it) {
        String _key = it.getKey();
        String[] _value = it.getValue();
        String _get = _value[0];
        result.put(_key, _get);
      }
    };
    IterableExtensions.<Map.Entry<String, String[]>>forEach(_filter, _function_1);
    return Collections.<String, String>unmodifiableMap(result);
  }
  
  protected Injector getInjector(final Map<String, String> parameters) throws InvalidRequestException {
    IResourceServiceProvider resourceServiceProvider = null;
    String _elvis = null;
    String _get = parameters.get("resource");
    if (_get != null) {
      _elvis = _get;
    } else {
      _elvis = "";
    }
    final URI emfURI = URI.createURI(_elvis);
    final String contentType = parameters.get("contentType");
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
