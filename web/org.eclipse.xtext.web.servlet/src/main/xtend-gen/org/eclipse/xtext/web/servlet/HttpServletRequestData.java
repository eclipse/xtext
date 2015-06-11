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
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.web.server.IRequestData;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public class HttpServletRequestData implements IRequestData {
  private final HttpServletRequest request;
  
  @Accessors
  private final Map<String, String> parameters;
  
  public HttpServletRequestData(final HttpServletRequest request) {
    this.request = request;
    final Map<String, String[]> paramMultiMap = request.getParameterMap();
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
    Map<String, String> _unmodifiableMap = Collections.<String, String>unmodifiableMap(result);
    this.parameters = _unmodifiableMap;
  }
  
  @Override
  public String getMetadata(final String key) {
    String _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(key, "requestType")) {
        _matched=true;
        String _elvis = null;
        String _pathInfo = this.request.getPathInfo();
        String _substring = null;
        if (_pathInfo!=null) {
          _substring=_pathInfo.substring(1);
        }
        if (_substring != null) {
          _elvis = _substring;
        } else {
          _elvis = "";
        }
        _switchResult = _elvis;
      }
    }
    if (!_matched) {
      if (Objects.equal(key, "authType")) {
        _matched=true;
        _switchResult = this.request.getAuthType();
      }
    }
    if (!_matched) {
      if (Objects.equal(key, "characterEncoding")) {
        _matched=true;
        _switchResult = this.request.getCharacterEncoding();
      }
    }
    if (!_matched) {
      if (Objects.equal(key, "contentType")) {
        _matched=true;
        _switchResult = this.request.getContentType();
      }
    }
    if (!_matched) {
      if (Objects.equal(key, "contextPath")) {
        _matched=true;
        _switchResult = this.request.getContextPath();
      }
    }
    if (!_matched) {
      if (Objects.equal(key, "localAddr")) {
        _matched=true;
        _switchResult = this.request.getLocalAddr();
      }
    }
    if (!_matched) {
      if (Objects.equal(key, "localName")) {
        _matched=true;
        _switchResult = this.request.getLocalName();
      }
    }
    if (!_matched) {
      if (Objects.equal(key, "localPort")) {
        _matched=true;
        int _localPort = this.request.getLocalPort();
        _switchResult = Integer.valueOf(_localPort).toString();
      }
    }
    if (!_matched) {
      if (Objects.equal(key, "method")) {
        _matched=true;
        _switchResult = this.request.getMethod();
      }
    }
    if (!_matched) {
      if (Objects.equal(key, "pathInfo")) {
        _matched=true;
        _switchResult = this.request.getPathInfo();
      }
    }
    if (!_matched) {
      if (Objects.equal(key, "pathTranslated")) {
        _matched=true;
        _switchResult = this.request.getPathTranslated();
      }
    }
    if (!_matched) {
      if (Objects.equal(key, "protocol")) {
        _matched=true;
        _switchResult = this.request.getProtocol();
      }
    }
    if (!_matched) {
      if (Objects.equal(key, "queryString")) {
        _matched=true;
        _switchResult = this.request.getQueryString();
      }
    }
    if (!_matched) {
      if (Objects.equal(key, "remoteAddr")) {
        _matched=true;
        _switchResult = this.request.getRemoteAddr();
      }
    }
    if (!_matched) {
      if (Objects.equal(key, "remoteHost")) {
        _matched=true;
        _switchResult = this.request.getRemoteHost();
      }
    }
    if (!_matched) {
      if (Objects.equal(key, "remotePort")) {
        _matched=true;
        int _remotePort = this.request.getRemotePort();
        _switchResult = Integer.valueOf(_remotePort).toString();
      }
    }
    if (!_matched) {
      if (Objects.equal(key, "remoteUser")) {
        _matched=true;
        _switchResult = this.request.getRemoteUser();
      }
    }
    if (!_matched) {
      if (Objects.equal(key, "requestedSessionId")) {
        _matched=true;
        _switchResult = this.request.getRequestedSessionId();
      }
    }
    if (!_matched) {
      if (Objects.equal(key, "requestURI")) {
        _matched=true;
        _switchResult = this.request.getRequestURI();
      }
    }
    if (!_matched) {
      if (Objects.equal(key, "scheme")) {
        _matched=true;
        _switchResult = this.request.getScheme();
      }
    }
    if (!_matched) {
      if (Objects.equal(key, "serverName")) {
        _matched=true;
        _switchResult = this.request.getServerName();
      }
    }
    if (!_matched) {
      if (Objects.equal(key, "serverPort")) {
        _matched=true;
        int _serverPort = this.request.getServerPort();
        _switchResult = Integer.valueOf(_serverPort).toString();
      }
    }
    if (!_matched) {
      if (Objects.equal(key, "servletPath")) {
        _matched=true;
        _switchResult = this.request.getServletPath();
      }
    }
    return _switchResult;
  }
  
  @Pure
  public Map<String, String> getParameters() {
    return this.parameters;
  }
}
