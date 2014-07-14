/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.macro

import java.lang.RuntimeException
import org.eclipse.emf.common.util.URI
import org.eclipse.xtend.lib.annotations.Accessors

class AnnotationProcessingException extends RuntimeException {
	
	@Accessors val URI problematicResource
	
	new(String message, URI problematicResource) {
		super(message)
		this.problematicResource = problematicResource
	}
	
	new(String message, Throwable cause, URI problematicResource) {
		super(message, cause)
		this.problematicResource = problematicResource
	}
	
}