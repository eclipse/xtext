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
import org.eclipse.xtext.xbase.typesystem.references.StandardTypeReferenceOwner
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices
import org.eclipse.xtext.xbase.typesystem.util.DeclaratorTypeArgumentCollector
import org.eclipse.xtext.xbase.typesystem.util.StandardTypeParameterSubstitutor

/**
 * @author Sebastian Zarnekow
 */
class LightweightTypeParameterSubstitutorTest extends AbstractTypeParameterSubstitutorTest {
	
	@Inject CommonTypeComputationServices services
	
	override resolve(JvmTypeReference declaration, JvmTypeReference reference) {
		extension val owner = new StandardTypeReferenceOwner(services, declaration.type)
		val mapping = new DeclaratorTypeArgumentCollector().getTypeParameterMapping(declaration.toLightweightTypeReference)
		return new StandardTypeParameterSubstitutor(mapping, owner).substitute(reference.toLightweightTypeReference).toString
	}

}