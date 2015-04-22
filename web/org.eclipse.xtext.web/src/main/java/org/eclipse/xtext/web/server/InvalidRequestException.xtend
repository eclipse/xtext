/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.server

import java.lang.Exception
import org.eclipse.xtend.lib.annotations.Accessors

@Accessors
class InvalidRequestException extends Exception {
	
	val int statusCode
	
	// TODO move status codes to servlet
	new(int statusCode, String message) {
		super(message)
		this.statusCode = statusCode
	}
	
}