/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse def License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.typesystem

import com.google.inject.Inject
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.xbase.typesystem.computation.SynonymTypesProvider
import org.junit.Test

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class SynonmyTypesTest extends AbstractTestingTypeReferenceOwner {
	
	@Inject
	extension IXtendJvmAssociations
	
	@Inject
	extension SynonymTypesProvider
	
	def hasSynonyms(String type, String... expectedSynonyms) {
		(type->null).hasSynonyms(expectedSynonyms)
	}
	
	def hasSynonyms(Pair<String, String> typeAndTypeParams, String... expectedSynonyms) {
		val signature = '''def «IF !typeAndTypeParams.value.nullOrEmpty»<«typeAndTypeParams.value»> «ENDIF»void method(«
			typeAndTypeParams.key» p) {}'''
		val function = function(signature.toString)
		val operation = function.directlyInferredOperation
		val primary = if (typeAndTypeParams.key != null) operation.parameters.head.parameterType.toLightweightTypeReference else owner.newAnyTypeReference
		val actualSynonyms = newHashSet
		primary.collectSynonymTypes [ type, conformance | actualSynonyms.add(type.simpleName) ]
		assertEquals(actualSynonyms.toString, expectedSynonyms.length, actualSynonyms.size)
		assertTrue(actualSynonyms.toString, actualSynonyms.containsAll(expectedSynonyms))
	}
	
	@Test def void testInt() {
		"int".hasSynonyms("Integer")
		"Integer".hasSynonyms("int")
	}
	@Test def void testShort() {
		"short".hasSynonyms("Short")
		"Short".hasSynonyms("short")
	}
	@Test def void testDouble() {
		"double".hasSynonyms("Double")
		"Double".hasSynonyms("double")
	}
	@Test def void testBoolean() {
		"boolean".hasSynonyms("Boolean")
		"Boolean".hasSynonyms("boolean")
	}
	@Test def void testVoid() {
		"void".hasSynonyms()
		"Void".hasSynonyms()
	}
	
	@Test def void testListToArray() {
		"char[]".hasSynonyms("List<Character>")
		"java.util.List<String>".hasSynonyms("String[]")
	}
	
	@Test def void testIterableToArray_01() {
		"Iterable<? extends Integer>".hasSynonyms("Integer[]", "int[]")
	}
	
	@Test def void testArrayListToArray_02() {
		"java.util.ArrayList<? extends Integer>".hasSynonyms("Integer[]", "int[]")
	}
	
	@Test def void testListWithUpperBound_01() {
		"java.util.List<? super Integer>".hasSynonyms("Object[]")
	}
	
	@Test def void testListWithTypeParameter_01() {
		("java.util.List<T>" -> 'T extends String').hasSynonyms("T[]")
		("java.util.List<? extends T>" -> 'T extends String').hasSynonyms("T[]")
	}
	
	@Test def void testListWithTypeParameter_02() {
		("java.util.List<T>" -> 'T extends Integer').hasSynonyms("T[]", "int[]")
		("java.util.List<? extends T>" -> 'T extends Integer').hasSynonyms("T[]", "int[]")
	}
	
	@Test def void testArrayWithTypeParameter_01() {
		("T[]" -> 'T extends String').hasSynonyms("List<T>")
		("T[][]" -> 'T extends String').hasSynonyms("List<T[]>")
	}
	
	@Test def void testArrayWithTypeParameter_02() {
		("T[]" -> 'T extends Integer').hasSynonyms("List<T>")
		("T[][]" -> 'T extends Integer').hasSynonyms("List<T[]>")
	}
	
	@Test def void testTypeParameter_01() {
		("T" -> 'V, T extends Iterable<V>').hasSynonyms("V[]")
	}
	
	@Test def void testTypeParameter_02() {
		("T" -> 'T extends Iterable<Integer>').hasSynonyms("Integer[]", "int[]")
	}
	
	@Test def void testTypeParameter_03() {
		("T" -> 'V extends Integer, T extends Iterable<V>').hasSynonyms("V[]", "int[]")
	}
	
}

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@InjectWith(RuntimeInjectorProviderWithCustomSynonyms)
class CustomSynonmyTypesTest extends SynonmyTypesTest {
	@Test def void testBigIntegerToBigDecimal() {
		"java.math.BigInteger".hasSynonyms("BigDecimal")
	}
}