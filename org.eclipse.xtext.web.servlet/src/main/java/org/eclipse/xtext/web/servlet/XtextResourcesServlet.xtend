/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.servlet

import com.google.common.io.ByteStreams
import java.io.InputStream
import javax.servlet.ServletConfig
import javax.servlet.ServletException
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import org.eclipse.xtext.web.server.XtextServiceDispatcher

/** 
 * This servlet is required only in servlet containers that do not support the servlet 3.0 API.
 */
class XtextResourcesServlet extends HttpServlet {
	
	static val DEFAULT_EXPIRE_TIME_MS = 86400000L // 1 day
	static val DEFAULT_EXPIRE_TIME_S = 86400L     // 1 day
	
	boolean disableCache = false

	override init(ServletConfig config) throws ServletException {
		super.init(config)
		var String disableCache = config.getInitParameter('disableCache')
		if (disableCache !== null) {
			disableCache = Boolean.parseBoolean(disableCache)
		}
	}

	override doGet(HttpServletRequest request, HttpServletResponse response) {
		val resourceURI = 'META-INF/resources' + request.servletPath + request.pathInfo
		val inputStream = getResourceAsStream(resourceURI)
		if (inputStream !== null) {
			val tokens = resourceURI.split('/')
			val fileName = tokens.get(tokens.length - 1)
			if (!disableCache && tokens.length > 4) {
				val version = tokens.get(3)
				response.setHeader('ETag', fileName + '_' + version)
				response.setDateHeader('Expires', System.currentTimeMillis + DEFAULT_EXPIRE_TIME_MS)
				response.addHeader('Cache-Control', 'private, max-age=' + DEFAULT_EXPIRE_TIME_S)
			}
			val mimeType = servletContext.getMimeType(fileName)
			response.setContentType(mimeType ?: 'application/octet-stream')
			ByteStreams.copy(inputStream, response.outputStream)
		} else {
			response.sendError(HttpServletResponse.SC_NOT_FOUND)
		}
	}
	
	protected def InputStream getResourceAsStream(String resourceURI) {
		XtextServiceDispatcher.classLoader.getResourceAsStream(resourceURI)
	}

}
