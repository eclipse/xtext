/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.servlet

import java.util.Collections
import java.util.Set
import javax.servlet.http.HttpServletRequest
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.web.server.IRequestData

/**
 * Provides the parameters and metadata of an {@link HttpServletRequest}.
 */
class HttpServletRequestData implements IRequestData {
	
	val HttpServletRequest request
	
	@Accessors
	val Set<String> parameterKeys
	
	@Accessors
	val Set<String> metadataKeys

	new(HttpServletRequest request) {
		this.request = request
		val paramNames = request.parameterNames
		val set = newHashSet
        while (paramNames.hasMoreElements) {
            set += paramNames.nextElement
        }
        set += IRequestData.REQUEST_TYPE
		this.parameterKeys = Collections.unmodifiableSet(set)
		this.metadataKeys = #{'authType', 'characterEncoding', 'contentType', 'contextPath',
			'localAddr', 'localName', 'localPort', 'method', 'pathInfo', 'pathTranslated',
			'protocol', 'queryString', 'remoteAddr', 'remoteHost', 'remotePort', 'remoteUser',
			'requestedSessionId', 'requestURI', 'scheme', 'serverName', 'serverPort', 'servletPath'}
	}
	
	override getParameter(String key) {
		val value = request.getParameter(key)
		if (value === null && key == IRequestData.REQUEST_TYPE)
			return request.pathInfo?.substring(1)
		else
			return value
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