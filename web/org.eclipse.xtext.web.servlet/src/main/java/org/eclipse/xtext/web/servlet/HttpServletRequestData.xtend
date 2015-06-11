/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.servlet

import com.google.common.collect.Maps
import java.util.Collections
import java.util.Map
import javax.servlet.http.HttpServletRequest
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.web.server.IRequestData

class HttpServletRequestData implements IRequestData {
	
	val HttpServletRequest request

	@Accessors	
	val Map<String, String> parameters
	
	new(HttpServletRequest request) {
		this.request = request
		val paramMultiMap = request.parameterMap
		val result = Maps.newHashMapWithExpectedSize(paramMultiMap.size)
		paramMultiMap.entrySet.filter[value.length > 0].forEach[result.put(key, value.get(0))]
		this.parameters = Collections.unmodifiableMap(result)
	}
	
	override getMetadata(String key) {
		switch key {
			case 'requestType': request.pathInfo?.substring(1) ?: ''
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