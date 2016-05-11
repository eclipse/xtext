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
import org.eclipse.xtext.web.server.XtextServiceDispatcher;
import org.eclipse.xtext.xbase.lib.Exceptions;

/**
 * This servlet is required only in servlet containers that do not support the servlet 3.0 API.
 */
@SuppressWarnings("all")
public class XtextResourcesServlet extends HttpServlet {
  private final static long DEFAULT_EXPIRE_TIME_MS = 86400000L;
  
  private final static long DEFAULT_EXPIRE_TIME_S = 86400L;
  
  private boolean disableCache = false;
  
  @Override
  public void init(final ServletConfig config) throws ServletException {
    super.init(config);
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
      String _plus = ("META-INF/resources" + _servletPath);
      String _pathInfo = request.getPathInfo();
      final String resourceURI = (_plus + _pathInfo);
      final InputStream inputStream = this.getResourceAsStream(resourceURI);
      if ((inputStream != null)) {
        final String[] tokens = resourceURI.split("/");
        int _length = tokens.length;
        int _minus = (_length - 1);
        final String fileName = tokens[_minus];
        if (((!this.disableCache) && (tokens.length > 4))) {
          final String version = tokens[3];
          response.setHeader("ETag", ((fileName + "_") + version));
          long _currentTimeMillis = System.currentTimeMillis();
          long _plus_1 = (_currentTimeMillis + XtextResourcesServlet.DEFAULT_EXPIRE_TIME_MS);
          response.setDateHeader("Expires", _plus_1);
          response.addHeader("Cache-Control", ("private, max-age=" + Long.valueOf(XtextResourcesServlet.DEFAULT_EXPIRE_TIME_S)));
        }
        ServletContext _servletContext = this.getServletContext();
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
  
  protected InputStream getResourceAsStream(final String resourceURI) {
    ClassLoader _classLoader = XtextServiceDispatcher.class.getClassLoader();
    return _classLoader.getResourceAsStream(resourceURI);
  }
}
