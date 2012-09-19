/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.typesystem

import com.google.inject.Inject
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.xbase.typesystem.references.LightweightBoundTypeArgument
import org.eclipse.xtext.xbase.typesystem.references.OwnedConverter
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices
import org.eclipse.xtext.xbase.typesystem.util.DeclaratorTypeArgumentCollector
import org.eclipse.xtext.xbase.typesystem.util.StandardTypeParameterSubstitutor
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.InjectWith
import org.junit.runner.RunWith

/**
 * @author Sebastian Zarnekow
 */
@RunWith(typeof(XtextRunner))
@InjectWith(typeof(XbaseNewTypeSystemInjectorProvider))
class LightweightTypeParameterSubstitutorTest extends AbstractTypeParameterSubstitutorTest implements ITypeReferenceOwner {
	
	@Inject CommonTypeComputationServices services
	
	extension OwnedConverter = new OwnedConverter(this)
	
	override resolve(JvmTypeReference declaration, JvmTypeReference reference) {
		val mapping = new DeclaratorTypeArgumentCollector().getTypeParameterMapping(declaration.toLightweightReference)
		return new StandardTypeParameterSubstitutor(mapping, this).substitute(reference.toLightweightReference).toString
	}

	override getServices() {
		return services
	}
	
	override acceptHint(Object reference, LightweightBoundTypeArgument boundTypeArgument) {
		throw new UnsupportedOperationException("Should not be invoked")
	}
	
	override getAllHints(Object reference) {
		throw new UnsupportedOperationException("Should not be invoked")
	}
	
	override getContextResourceSet() {
		return contextResourceSet
	}
	
	override isResolved(Object handle) {
		throw new UnsupportedOperationException("Should not be invoked")
	}
	
}