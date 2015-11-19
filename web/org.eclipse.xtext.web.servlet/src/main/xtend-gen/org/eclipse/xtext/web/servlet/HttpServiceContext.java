/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.web.servlet;

import com.google.common.base.Objects;
import com.google.common.io.CharStreams;
import java.io.BufferedReader;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.web.server.IServiceContext;
import org.eclipse.xtext.web.server.ISession;
import org.eclipse.xtext.web.servlet.HttpSessionWrapper;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * Provides the parameters and metadata of an {@link HttpServletRequest}.
 */
@SuppressWarnings("all")
public class HttpServiceContext implements IServiceContext {
  @Accessors
  private final HttpServletRequest request;
  
  private final Map<String, String> parameters = CollectionLiterals.<String, String>newHashMap();
  
  private HttpSessionWrapper sessionWrapper;
  
  public HttpServiceContext(final HttpServletRequest request) {
    this.request = request;
    this.initializeParameters();
  }
  
  private String initializeParameters() {
    try {
      String _xblockexpression = null;
      {
        String _contentType = this.request.getContentType();
        String[] _split = null;
        if (_contentType!=null) {
          _split=_contentType.split(";(\\s*)");
        }
        final String[] contentType = _split;
        boolean _and = false;
        if (!(contentType != null)) {
          _and = false;
        } else {
          String _get = contentType[0];
          boolean _equals = Objects.equal(_get, "application/x-www-form-urlencoded");
          _and = _equals;
        }
        if (_and) {
          String _xifexpression = null;
          boolean _and_1 = false;
          boolean _and_2 = false;
          if (!(contentType != null)) {
            _and_2 = false;
          } else {
            int _length = contentType.length;
            boolean _greaterEqualsThan = (_length >= 2);
            _and_2 = _greaterEqualsThan;
          }
          if (!_and_2) {
            _and_1 = false;
          } else {
            String _get_1 = contentType[1];
            boolean _startsWith = _get_1.startsWith("charset=");
            _and_1 = _startsWith;
          }
          if (_and_1) {
            String _get_2 = contentType[1];
            int _length_1 = "charset=".length();
            _xifexpression = _get_2.substring(_length_1);
          } else {
            Charset _defaultCharset = Charset.defaultCharset();
            _xifexpression = _defaultCharset.toString();
          }
          String charset = _xifexpression;
          BufferedReader _reader = this.request.getReader();
          String _string = CharStreams.toString(_reader);
          final String[] encodedParams = _string.split("&");
          for (final String param : encodedParams) {
            {
              final int nameEnd = param.indexOf("=");
              if ((nameEnd > 0)) {
                final String key = param.substring(0, nameEnd);
                String _substring = param.substring((nameEnd + 1));
                final String value = URLDecoder.decode(_substring, charset);
                this.parameters.put(key, value);
              }
            }
          }
        }
        final Enumeration<String> paramNames = this.request.getParameterNames();
        while (paramNames.hasMoreElements()) {
          {
            final String name = paramNames.nextElement();
            String _parameter = this.request.getParameter(name);
            this.parameters.put(name, _parameter);
          }
        }
        String _xifexpression_1 = null;
        boolean _containsKey = this.parameters.containsKey(IServiceContext.SERVICE_TYPE);
        boolean _not = (!_containsKey);
        if (_not) {
          String _pathInfo = this.request.getPathInfo();
          String _substring = null;
          if (_pathInfo!=null) {
            _substring=_pathInfo.substring(1);
          }
          _xifexpression_1 = this.parameters.put(IServiceContext.SERVICE_TYPE, _substring);
        }
        _xblockexpression = _xifexpression_1;
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Override
  public Set<String> getParameterKeys() {
    Set<String> _keySet = this.parameters.keySet();
    return Collections.<String>unmodifiableSet(_keySet);
  }
  
  @Override
  public String getParameter(final String key) {
    return this.parameters.get(key);
  }
  
  @Override
  public ISession getSession() {
    boolean _equals = Objects.equal(this.sessionWrapper, null);
    if (_equals) {
      HttpSession _session = this.request.getSession(true);
      HttpSessionWrapper _httpSessionWrapper = new HttpSessionWrapper(_session);
      this.sessionWrapper = _httpSessionWrapper;
    }
    return this.sessionWrapper;
  }
  
  @Pure
  public HttpServletRequest getRequest() {
    return this.request;
  }
}
