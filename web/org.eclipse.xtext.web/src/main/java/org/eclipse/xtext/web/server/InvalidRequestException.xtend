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
	
	static enum Type {
		INVALID_PARAMETERS,
		UNKNOWN_LANGUAGE,
		RESOURCE_NOT_FOUND,
		INVALID_DOCUMENT_STATE
	}
	
	val Type type
	
	new(Type type, String message) {
		super(message)
		this.type = type
	}
	
}