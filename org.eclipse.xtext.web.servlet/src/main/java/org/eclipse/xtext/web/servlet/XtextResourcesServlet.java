/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.web.servlet;

import com.google.common.io.ByteStreams;

import java.io.IOException;
import java.io.InputStream;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.eclipse.xtext.web.server.XtextServiceDispatcher;
import org.eclipse.xtext.xbase.lib.Exceptions;

/**
 * This servlet is required only in servlet containers that do not support the
 * servlet 3.0 API.
 */
public class XtextResourcesServlet extends HttpServlet {

	private static final long serialVersionUID = 4318411920672654776L;

	private static final long DEFAULT_EXPIRE_TIME_MS = 86400000L; // 1 day

	private static final long DEFAULT_EXPIRE_TIME_S = 86400L; // 1 day

	private boolean disableCache = false;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		String disableCache = config.getInitParameter("disableCache");
		if (disableCache != null) {
			this.disableCache = Boolean.parseBoolean(disableCache);
		}
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			String resourceURI = "META-INF/resources" + request.getServletPath() + request.getPathInfo();
			try (InputStream inputStream = getResourceAsStream(resourceURI)) {
				if (inputStream != null) {
					String[] tokens = resourceURI.split("/");
					String fileName = tokens[tokens.length - 1];
					if (!disableCache && tokens.length > 4) {
						String version = tokens[3];
						response.setHeader("ETag", fileName + "_" + version);
						response.setDateHeader("Expires",
								System.currentTimeMillis() + XtextResourcesServlet.DEFAULT_EXPIRE_TIME_MS);
						response.addHeader("Cache-Control",
								("private, max-age=" + XtextResourcesServlet.DEFAULT_EXPIRE_TIME_S));
					}
					String mimeType = getServletContext().getMimeType(fileName);
					String contentType = null;
					if (mimeType != null) {
						contentType = mimeType;
					} else {
						contentType = "application/octet-stream";
					}
					response.setContentType(contentType);
					ByteStreams.copy(inputStream, response.getOutputStream());
				} else {
					response.sendError(HttpServletResponse.SC_NOT_FOUND);
				}
			}
		} catch (IOException e) {
			throw Exceptions.sneakyThrow(e);
		}
	}

	protected InputStream getResourceAsStream(String resourceURI) {
		return XtextServiceDispatcher.class.getClassLoader().getResourceAsStream(resourceURI);
	}
}
