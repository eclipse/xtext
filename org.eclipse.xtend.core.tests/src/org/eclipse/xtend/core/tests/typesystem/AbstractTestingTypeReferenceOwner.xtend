/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.tests.typesystem

import com.google.inject.Inject
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.xtend.core.tests.AbstractXtendTestCase
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner
import org.eclipse.xtext.xbase.typesystem.references.StandardTypeReferenceOwner
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices
import org.junit.After

/**
 * @author Sebastian Zarnekow
 */
abstract class AbstractTestingTypeReferenceOwner extends AbstractXtendTestCase {
	
	@Accessors(PROTECTED_GETTER)
	@Inject
	CommonTypeComputationServices services
	
	@Accessors(PROTECTED_GETTER)
	ResourceSet contextResourceSet
	
	@Accessors(PROTECTED_GETTER)
	ITypeReferenceOwner owner
	
	@After
	def void tearDown() {
		contextResourceSet = null
	}
	
	def toLightweightTypeReference(JvmTypeReference reference) {
		return owner.toLightweightTypeReference(reference)
	}
	
	override protected function(String string) throws Exception {
		val result = super.function(string)
		contextResourceSet = result.eResource.resourceSet
		owner = createOwner()
		return result
	}
	
	protected def createOwner() {
		new StandardTypeReferenceOwner(services, contextResourceSet)
	}

}