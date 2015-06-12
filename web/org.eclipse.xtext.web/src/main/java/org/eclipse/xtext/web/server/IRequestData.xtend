/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.server

import java.util.Collection

interface IRequestData {
	
	public static val METADATA_REQUEST_TYPE = 'requestType'
	
	def Collection<String> getParameterKeys()
	
	def String getParameter(String key)
	
	def Collection<String> getMetadataKeys()
	
	def String getMetadata(String key)
	
}