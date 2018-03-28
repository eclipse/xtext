/*******************************************************************************
 * Copyright (c) 2016, 2017 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator

import org.eclipse.emf.ecore.ENamedElement
import org.eclipse.emf.ecore.EcorePackage
import org.eclipse.xtext.xtext.generator.formatting.Formatter2Fragment2
import org.junit.Test

import static extension org.junit.Assert.*
import org.eclipse.emf.ecore.EcoreFactory

/**
 * @author Lorenzo Bettini - Initial contribution and API
 */
class Formatter2Fragment2Test {
	
	var TestableFormatter2Fragment2 fragment = new TestableFormatter2Fragment2

	static class TestableFormatter2Fragment2 extends Formatter2Fragment2 {
		
		override toVarName(ENamedElement element, String... reservedNames) {
			super.toVarName(element, reservedNames)
		}
		
	}

	@Test def void testVarNameWithEClass() {
		"eClass".assertEquals(fragment.toVarName(EcorePackage.eINSTANCE.EClass))
	}

	@Test def void testVarNameWithMultiReference() {
		"eOperation".assertEquals(fragment.toVarName(EcorePackage.eINSTANCE.EClass_EAllOperations))
	}

	@Test def void testVarNameWithSingleReference() {
		"name".assertEquals(fragment.toVarName(EcorePackage.eINSTANCE.ENamedElement_Name))
	}

	@Test def void testVarNameConflictingWithXtendKeyword() {
		"_abstract".assertEquals(fragment.toVarName(EcorePackage.eINSTANCE.EClass_Abstract))
	}

	@Test def void testVarNameConflictingWithParam() {
		"_xxx".assertEquals(fragment.toVarName(EcoreFactory.eINSTANCE.createEAttribute=>[name="xxx"]),"xxx")
	}

	@Test def void testVarNameConflictingWithXtendKeywordAndParam() {
		"__abstract".assertEquals(fragment.toVarName(EcorePackage.eINSTANCE.EClass_Abstract, "_abstract"))
	}
}
