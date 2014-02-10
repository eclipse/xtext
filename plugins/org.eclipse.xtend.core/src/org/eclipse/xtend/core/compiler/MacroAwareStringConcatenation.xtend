/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.compiler

import org.eclipse.xtend.core.macro.declaration.TypeReferenceImpl
import org.eclipse.xtext.xbase.compiler.output.ImportingStringConcatenation
import org.eclipse.xtext.xbase.compiler.output.SharedAppendableState
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class MacroAwareStringConcatenation extends ImportingStringConcatenation {
	
	new(SharedAppendableState state, ITypeReferenceOwner typeReferenceOwner) {
		super(state, typeReferenceOwner)
	}
	
	def dispatch protected String getStringRepresentation(TypeReferenceImpl object) {
		return _getStringRepresentation(object.delegate)
	}
	
}