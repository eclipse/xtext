/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.web.servlet;

import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.eclipse.xtext.web.server.IServiceContext;
import org.eclipse.xtext.web.server.ISession;
import org.eclipse.xtext.xbase.lib.Exceptions;

import com.google.common.io.CharStreams;

/**
 * Provides the parameters and metadata of an {@link HttpServletRequest}.
 */
public class HttpServiceContext implements IServiceContext {
	private final HttpServletRequest request;

	private final Map<String, String> parameters = new HashMap<>();

	private HttpSessionWrapper sessionWrapper;

	public HttpServiceContext(HttpServletRequest request) {
		this.request = request;
		this.initializeParameters();
	}

	private String initializeParameters() {
		try {
			String[] contentType = null;
			if (request.getContentType() != null) {
				contentType = request.getContentType().split(";(\\s*)");
			}
			if (contentType != null && "application/x-www-form-urlencoded".equals(contentType[0])) {
				String charset = null;
				if (contentType != null && contentType.length >= 2 && contentType[1].startsWith("charset=")) {
					charset = (contentType[1]).substring("charset=".length());
				} else {
					charset = Charset.defaultCharset().toString();
				}
				String[] encodedParams = CharStreams.toString(request.getReader()).split("&");
				for (String param : encodedParams) {
					int nameEnd = param.indexOf("=");
					if (nameEnd > 0) {
						String key = param.substring(0, nameEnd);
						String value = URLDecoder.decode(param.substring(nameEnd + 1), charset);
						parameters.put(key, value);
					}
				}
			}
			Enumeration<String> paramNames = request.getParameterNames();
			while (paramNames.hasMoreElements()) {
				String name = paramNames.nextElement();
				parameters.put(name, request.getParameter(name));
			}
			if (!parameters.containsKey(IServiceContext.SERVICE_TYPE)) {
				String substring = null;
				if (request.getPathInfo() != null) {
					substring = request.getPathInfo().substring(1);
				}
				return parameters.put(IServiceContext.SERVICE_TYPE, substring);
			}
			return null;
		} catch (IOException e) {
			throw Exceptions.sneakyThrow(e);
		}
	}

	@Override
	public Set<String> getParameterKeys() {
		return Collections.unmodifiableSet(parameters.keySet());
	}

	@Override
	public String getParameter(String key) {
		return parameters.get(key);
	}

	@Override
	public ISession getSession() {
		if (sessionWrapper == null) {
			sessionWrapper = new HttpSessionWrapper(request.getSession(true));
		}
		return sessionWrapper;
	}

	public HttpServletRequest getRequest() {
		return request;
	}
}
