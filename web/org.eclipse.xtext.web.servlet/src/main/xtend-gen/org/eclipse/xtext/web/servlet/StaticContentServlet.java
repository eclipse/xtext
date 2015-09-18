/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.web.servlet;

import com.google.common.io.ByteStreams;
import java.io.InputStream;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.eclipse.xtext.xbase.lib.Exceptions;

/**
 * This servlet is required only in servlet containers that do not support the servlet 3.0 API.
 */
@SuppressWarnings("all")
public class StaticContentServlet extends HttpServlet {
  private final static long DEFAULT_EXPIRE_TIME_MS = 86400000L;
  
  private final static long DEFAULT_EXPIRE_TIME_S = 86400L;
  
  private boolean disableCache = false;
  
  @Override
  public void init(final ServletConfig config) throws ServletException {
    String disableCache = config.getInitParameter("disableCache");
    if ((disableCache != null)) {
      boolean _parseBoolean = Boolean.parseBoolean(disableCache);
      this.disableCache = _parseBoolean;
    }
  }
  
  @Override
  public void doGet(final HttpServletRequest request, final HttpServletResponse response) {
    try {
      String _servletPath = request.getServletPath();
      String _plus = ("/META-INF/resources" + _servletPath);
      String _pathInfo = request.getPathInfo();
      final String resourceURI = (_plus + _pathInfo);
      Class<? extends StaticContentServlet> _class = this.getClass();
      final InputStream inputStream = _class.getResourceAsStream(resourceURI);
      if ((inputStream != null)) {
        final String[] tokens = resourceURI.split("/");
        int _length = tokens.length;
        int _minus = (_length - 1);
        final String fileName = tokens[_minus];
        boolean _and = false;
        if (!(!this.disableCache)) {
          _and = false;
        } else {
          int _length_1 = tokens.length;
          boolean _greaterThan = (_length_1 > 4);
          _and = _greaterThan;
        }
        if (_and) {
          final String version = tokens[3];
          response.setHeader("ETag", ((fileName + "_") + version));
          long _currentTimeMillis = System.currentTimeMillis();
          long _plus_1 = (_currentTimeMillis + StaticContentServlet.DEFAULT_EXPIRE_TIME_MS);
          response.setDateHeader("Expires", _plus_1);
          response.addHeader("Cache-Control", ("private, max-age=" + Long.valueOf(StaticContentServlet.DEFAULT_EXPIRE_TIME_S)));
        }
        HttpSession _session = request.getSession();
        ServletContext _servletContext = _session.getServletContext();
        final String mimeType = _servletContext.getMimeType(fileName);
        String _elvis = null;
        if (mimeType != null) {
          _elvis = mimeType;
        } else {
          _elvis = "application/octet-stream";
        }
        response.setContentType(_elvis);
        ServletOutputStream _outputStream = response.getOutputStream();
        ByteStreams.copy(inputStream, _outputStream);
      } else {
        response.sendError(HttpServletResponse.SC_NOT_FOUND);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
