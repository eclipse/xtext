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
import org.eclipse.xtext.xbase.typesystem.references.OwnedConverter
import org.eclipse.xtext.xbase.typesystem.references.TypeReferenceOwner
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices
import org.eclipse.xtext.xbase.typesystem.util.DeclaratorTypeArgumentCollector
import org.eclipse.xtext.xbase.typesystem.util.StandardTypeParameterSubstitutor

/**
 * @author Sebastian Zarnekow
 */
class TypeParameterSubstitutorTest extends AbstractTypeParameterSubstitutorTest {
	
	@Inject CommonTypeComputationServices services
	
	override resolve(JvmTypeReference declaration, JvmTypeReference reference) {
		val mapping = new DeclaratorTypeArgumentCollector().getTypeParameterMapping(declaration)
		return new StandardTypeParameterSubstitutor(mapping, services).substitute(reference).simpleName
	}
	
}

/**
 * @author Sebastian Zarnekow
 */
class LightweightTypeParameterSubstitutorTest extends AbstractTypeParameterSubstitutorTest implements TypeReferenceOwner {
	
	@Inject CommonTypeComputationServices services
	
	extension OwnedConverter = new OwnedConverter(this)
	
	override resolve(JvmTypeReference declaration, JvmTypeReference reference) {
		val mapping = new org.eclipse.xtext.xbase.typesystem.references.DeclaratorTypeArgumentCollector().getTypeParameterMapping(declaration.toLightweightReference)
		return new org.eclipse.xtext.xbase.typesystem.references.StandardTypeParameterSubstitutor(mapping, this).substitute(reference.toLightweightReference).toString
	}

	override getServices() {
		return services
	}
	
}