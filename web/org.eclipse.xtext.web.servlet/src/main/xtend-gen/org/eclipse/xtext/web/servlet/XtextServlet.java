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
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.eclipse.xtext.web.server.InvalidRequestException;
import org.eclipse.xtext.web.server.XtextServiceDispatcher;
import org.eclipse.xtext.web.server.data.JsonObject;
import org.eclipse.xtext.web.servlet.HttpServletSessionStore;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class XtextServlet extends HttpServlet {
  @Inject
  private Gson gson;
  
  @Inject
  private XtextServiceDispatcher serviceDispatcher;
  
  @Override
  protected void service(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
    try {
      super.service(req, resp);
    } catch (final Throwable _t) {
      if (_t instanceof InvalidRequestException) {
        final InvalidRequestException exception = (InvalidRequestException)_t;
        int _statusCode = exception.getStatusCode();
        String _message = exception.getMessage();
        resp.sendError(_statusCode, _message);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  @Override
  protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
    try {
      HttpSession _session = req.getSession();
      final HttpServletSessionStore sessionStore = new HttpServletSessionStore(_session);
      String _elvis = null;
      String _pathInfo = req.getPathInfo();
      if (_pathInfo != null) {
        _elvis = _pathInfo;
      } else {
        _elvis = "";
      }
      Map<String, String> _parameterMap = this.getParameterMap(req);
      final XtextServiceDispatcher.ServiceDescriptor service = this.serviceDispatcher.getService(_elvis, _parameterMap, sessionStore);
      boolean _or = false;
      boolean _isHasSideEffects = service.isHasSideEffects();
      if (_isHasSideEffects) {
        _or = true;
      } else {
        boolean _isHasTextInput = service.isHasTextInput();
        _or = _isHasTextInput;
      }
      if (_or) {
        super.doGet(req, resp);
      } else {
        this.doService(service, resp);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Override
  protected void doPut(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
    try {
      HttpSession _session = req.getSession();
      final HttpServletSessionStore sessionStore = new HttpServletSessionStore(_session);
      String _elvis = null;
      String _pathInfo = req.getPathInfo();
      if (_pathInfo != null) {
        _elvis = _pathInfo;
      } else {
        _elvis = "";
      }
      Map<String, String> _parameterMap = this.getParameterMap(req);
      final XtextServiceDispatcher.ServiceDescriptor service = this.serviceDispatcher.getService(_elvis, _parameterMap, sessionStore);
      String _type = service.getType();
      boolean _notEquals = (!Objects.equal(_type, "update"));
      if (_notEquals) {
        super.doPut(req, resp);
      } else {
        this.doService(service, resp);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Override
  protected void doPost(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
    try {
      HttpSession _session = req.getSession();
      final HttpServletSessionStore sessionStore = new HttpServletSessionStore(_session);
      String _elvis = null;
      String _pathInfo = req.getPathInfo();
      if (_pathInfo != null) {
        _elvis = _pathInfo;
      } else {
        _elvis = "";
      }
      Map<String, String> _parameterMap = this.getParameterMap(req);
      final XtextServiceDispatcher.ServiceDescriptor service = this.serviceDispatcher.getService(_elvis, _parameterMap, sessionStore);
      boolean _or = false;
      boolean _and = false;
      boolean _isHasSideEffects = service.isHasSideEffects();
      boolean _not = (!_isHasSideEffects);
      if (!_not) {
        _and = false;
      } else {
        boolean _isHasTextInput = service.isHasTextInput();
        boolean _not_1 = (!_isHasTextInput);
        _and = _not_1;
      }
      if (_and) {
        _or = true;
      } else {
        String _type = service.getType();
        boolean _equals = Objects.equal(_type, "update");
        _or = _equals;
      }
      if (_or) {
        super.doPost(req, resp);
      } else {
        this.doService(service, resp);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected Map<String, String> getParameterMap(final HttpServletRequest req) {
    Map _parameterMap = req.getParameterMap();
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
    final Consumer<Map.Entry<String, String[]>> _function_1 = new Consumer<Map.Entry<String, String[]>>() {
      @Override
      public void accept(final Map.Entry<String, String[]> it) {
        String _key = it.getKey();
        String[] _value = it.getValue();
        String _get = _value[0];
        result.put(_key, _get);
      }
    };
    _filter.forEach(_function_1);
    return Collections.<String, String>unmodifiableMap(result);
  }
  
  protected void doService(final XtextServiceDispatcher.ServiceDescriptor service, final HttpServletResponse resp) {
    try {
      Function0<? extends JsonObject> _service = service.getService();
      final JsonObject result = _service.apply();
      resp.setStatus(HttpServletResponse.SC_OK);
      resp.setContentType("text/x-json;charset=UTF-8");
      resp.setHeader("Cache-Control", "no-cache");
      PrintWriter _writer = resp.getWriter();
      String _json = this.gson.toJson(result);
      _writer.write(_json);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
