/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.web.servlet;

import com.google.common.base.Objects;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.web.server.IRequestData;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * Provides the parameters and metadata of an {@link HttpServletRequest}.
 */
@SuppressWarnings("all")
public class HttpServletRequestData implements IRequestData {
  private final HttpServletRequest request;
  
  @Accessors
  private final Collection<String> parameterKeys;
  
  @Accessors
  private final Collection<String> metadataKeys;
  
  public HttpServletRequestData(final HttpServletRequest request) {
    this.request = request;
    final Enumeration<String> paramNames = request.getParameterNames();
    final HashSet<String> set = CollectionLiterals.<String>newHashSet();
    while (paramNames.hasMoreElements()) {
      String _nextElement = paramNames.nextElement();
      set.add(_nextElement);
    }
    Set<String> _unmodifiableSet = Collections.<String>unmodifiableSet(set);
    this.parameterKeys = _unmodifiableSet;
    this.metadataKeys = Collections.<String>unmodifiableSet(CollectionLiterals.<String>newHashSet(IRequestData.REQUEST_TYPE, "authType", "characterEncoding", "contentType", "contextPath", "localAddr", "localName", "localPort", "method", "pathInfo", "pathTranslated", "protocol", "queryString", "remoteAddr", "remoteHost", "remotePort", "remoteUser", "requestedSessionId", "requestURI", "scheme", "serverName", "serverPort", "servletPath"));
  }
  
  @Override
  public String getParameter(final String key) {
    return this.request.getParameter(key);
  }
  
  @Override
  public String getMetadata(final String key) {
    String _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(key, IRequestData.REQUEST_TYPE)) {
        _matched=true;
        String _pathInfo = this.request.getPathInfo();
        String _substring = null;
        if (_pathInfo!=null) {
          _substring=_pathInfo.substring(1);
        }
        _switchResult = _substring;
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
  public Collection<String> getParameterKeys() {
    return this.parameterKeys;
  }
  
  @Pure
  public Collection<String> getMetadataKeys() {
    return this.metadataKeys;
  }
}
