/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.server.generator

import java.net.URLConnection

/**
 * The default content type provider uses {@link URLConnection#guessContentTypeFromName(String)}
 * to determine content types.
 */
class DefaultContentTypeProvider implements IContentTypeProvider {
	
	override getContentType(String fileName) {
		if (fileName !== null) {
			return URLConnection.guessContentTypeFromName(fileName)
		}
	}
	
}