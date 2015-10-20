/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator

import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor

/**
 * @noreference
 */
@FinalFieldsConstructor
class MweIssues implements Issues {
	
	@Accessors val XtextGenerator owner
	@Accessors val org.eclipse.emf.mwe.core.issues.Issues delegate
	
	override addError(String message) {
		delegate.addError(owner, message)
	}
	
	override addError(String message, Object source) {
		delegate.addError(owner, message, source)
	}
	
	override addWarning(String message) {
		delegate.addWarning(owner, message)
	}
	
	override addWarning(String message, Object source) {
		delegate.addWarning(owner, message, source)
	}
	
}