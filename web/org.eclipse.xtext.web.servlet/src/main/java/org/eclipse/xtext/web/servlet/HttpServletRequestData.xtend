/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.servlet

import com.google.common.io.CharStreams
import java.net.URLDecoder
import java.nio.charset.Charset
import java.util.Collections
import java.util.Map
import java.util.Set
import javax.servlet.http.HttpServletRequest
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.web.server.IRequestData

/**
 * Provides the parameters and metadata of an {@link HttpServletRequest}.
 */
class HttpServletRequestData implements IRequestData {
	
	val HttpServletRequest request
	
	val Map<String, String> parameters = newHashMap
	
	@Accessors
	val Set<String> metadataKeys = #{'authType', 'characterEncoding', 'contentType', 'contextPath',
		'localAddr', 'localName', 'localPort', 'method', 'pathInfo', 'pathTranslated',
		'protocol', 'queryString', 'remoteAddr', 'remoteHost', 'remotePort', 'remoteUser',
		'requestedSessionId', 'requestURI', 'scheme', 'serverName', 'serverPort', 'servletPath'}

	new(HttpServletRequest request) {
		this.request = request
		initializeParameters()
	}
	
	private def initializeParameters() {
		val contentType = request.contentType?.split(';(\\s*)')
		if (contentType !== null && contentType.get(0) == 'application/x-www-form-urlencoded') {
			var charset =
				if (contentType !== null && contentType.length >= 2 && contentType.get(1).startsWith('charset='))
					contentType.get(1).substring('charset='.length)
				else
					Charset.defaultCharset.toString
			val encodedParams = CharStreams.toString(request.reader).split('&')
			for (param : encodedParams) {
				val nameEnd = param.indexOf('=')
				if (nameEnd > 0) {
					val key = param.substring(0, nameEnd)
					val value = URLDecoder.decode(param.substring(nameEnd + 1), charset)
					parameters.put(key, value)
				}
			}
		}
		val paramNames = request.parameterNames
        while (paramNames.hasMoreElements) {
            val name = paramNames.nextElement
            parameters.put(name, request.getParameter(name))
        }
        if (!parameters.containsKey(IRequestData.SERVICE_TYPE))
        	parameters.put(IRequestData.SERVICE_TYPE, request.pathInfo?.substring(1))
	}
	
	override getParameterKeys() {
		Collections.unmodifiableSet(parameters.keySet)
	}
	
	override getParameter(String key) {
		parameters.get(key)
	}
	
	override getMetadata(String key) {
		switch key {
			case 'authType': request.authType
			case 'characterEncoding': request.characterEncoding
			case 'contentType': request.contentType
			case 'contextPath': request.contextPath
			case 'localAddr': request.localAddr
			case 'localName': request.localName
			case 'localPort': request.localPort.toString
			case 'method': request.method
			case 'pathInfo': request.pathInfo
			case 'pathTranslated': request.pathTranslated
			case 'protocol': request.protocol
			case 'queryString': request.queryString
			case 'remoteAddr': request.remoteAddr
			case 'remoteHost': request.remoteHost
			case 'remotePort': request.remotePort.toString
			case 'remoteUser': request.remoteUser
			case 'requestedSessionId': request.requestedSessionId
			case 'requestURI': request.requestURI
			case 'scheme': request.scheme
			case 'serverName': request.serverName
			case 'serverPort': request.serverPort.toString
			case 'servletPath': request.servletPath
		}
	}
	
}