/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.typesystem

import com.google.inject.Inject
import java.util.ArrayList
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations
import org.eclipse.xtext.xbase.lib.Pair
import org.eclipse.xtext.xbase.typesystem.references.AnyTypeReference
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference
import org.junit.Test

import static org.junit.Assert.*

/**
 * @author Sebastian Zarnekow
 */
class CommonSuperTypeTest extends AbstractTestingTypeReferenceOwner {
	
	@Inject
	extension IXtendJvmAssociations
	
	def isSuperTypeOf(String superType, String... types) {
		(superType->null).isSuperTypeOf(types)
	}
	
	def isSuperTypeOf(Pair<String, String> superTypeAndParam, String... types) {
		// TODO synthesize unique variable names as soon as the function should be validated
		val signature = '''def «IF !superTypeAndParam.value.nullOrEmpty»<«superTypeAndParam.value»> «ENDIF»void method(«
			FOR type: types SEPARATOR ', '»«type.fixup» t«ENDFOR») {}'''
		val function = function(signature.toString)
		val operation = function.directlyInferredOperation
		val typeReferences = new ArrayList(operation.parameters.map [ parameterType.toLightweightReference ])
		var computedSuperType = services.typeConformanceComputer.getCommonSuperType(typeReferences)
		assertEquals(superTypeAndParam.key, computedSuperType?.simpleName)
		computedSuperType = services.typeConformanceComputer.getCommonSuperType((typeReferences + typeReferences).toList)
		assertEquals(superTypeAndParam.key, computedSuperType?.simpleName)
		computedSuperType = services.typeConformanceComputer.getCommonSuperType(typeReferences.reverseView)
		assertEquals(superTypeAndParam.key, computedSuperType?.simpleName)
		if (!(computedSuperType?.primitiveVoid || computedSuperType?.primitive)) {
			computedSuperType = services.typeConformanceComputer.getCommonSuperType((typeReferences + newImmutableList(new AnyTypeReference(this), new AnyTypeReference(this))).toList)
			assertEquals(superTypeAndParam.key, computedSuperType?.simpleName)
		}
		if (computedSuperType != null) {
			for(subType: typeReferences) {
				assertTrue(computedSuperType.isAssignableFrom(subType))
			}
		}
	}
	
	def private String fixup(String type) {
		type?.replace("$Procedure", "org.eclipse.xtext.xbase.lib.Procedures$Procedure")
			?.replace("$Function<", "com.google.common.base.Function<")
			?.replace("$Predicate<", "com.google.common.base.Predicate<")
			?.replace("$Function", "org.eclipse.xtext.xbase.lib.Functions$Function")
			?:'Object'
	}
	
	@Test
	def void testCommonSuperType_01() {
		"Serializable & CharSequence".isSuperTypeOf("String", "StringBuilder")
	}
	
	@Test
	def void testCommonSuperType_02() {
		"CharSequence".isSuperTypeOf("String", "StringBuilder", "CharSequence")
	}
	
	@Test
	def void testCommonSuperType_03() {
		"Object".isSuperTypeOf("String", "StringBuilder", "CharSequence", "Object")
	}
	
	@Test
	def void testCommonSuperType_04() {
		"String".isSuperTypeOf("String", "String")
	}
	
	@Test
	def void testCommonSuperType_05() {
		"String".isSuperTypeOf("String")
	}
	
	@Test
	def void testCommonSuperType_06() {
		"Serializable".isSuperTypeOf("String", "StringBuilder", "java.io.Serializable")
	}
	
	@Test
	def void testCommonSuperType_07() {
		"Appendable & CharSequence".isSuperTypeOf("StringBuilder", "java.nio.CharBuffer")
	}
	
	@Test
	def void testCommonSuperType_08() {
		"Collection<String>".isSuperTypeOf("java.util.Set<String>", "java.util.List<String>")
	}
	
	@Test
	def void testCommonSuperType_09() {
		"Collection".isSuperTypeOf("java.util.Set<String>", "java.util.List")
	}
	
	@Test
	def void testCommonSuperType_10() {
		"Collection<? extends CharSequence>".isSuperTypeOf("java.util.Set<String>", "java.util.List<CharSequence>")
	}
	
	@Test
	def void testCommonSuperType_11() {
		"Comparable<?> & Serializable".isSuperTypeOf("String", "Integer")
	}
	
	@Test
	def void testCommonSuperType_12() {
		"Number & Comparable<?>".isSuperTypeOf("Double", "Integer")
	}
	
	@Test
	def void testCommonSuperType_13() {
		"AbstractStringBuilder & Serializable".isSuperTypeOf("StringBuilder", "StringBuffer")
	}
	
	@Test
	def void testCommonSuperType_14() {
		("Serializable & CharSequence"->"T extends CharSequence & java.io.Serializable, V extends CharSequence & java.io.Serializable").isSuperTypeOf("T", "V")
	}
	
	@Test
	def void testCommonSuperType_15() {
		("Serializable & CharSequence"->"T extends CharSequence & java.io.Serializable, V extends java.io.Serializable & CharSequence").isSuperTypeOf("T", "V")
	}
	
	@Test
	def void testCommonSuperType_16() {
		("T"->"T extends CharSequence & java.io.Serializable").isSuperTypeOf("T", "T")
	}
	
	@Test
	def void testCommonSuperType_17() {
		("Serializable & CharSequence"->"T extends CharSequence & java.io.Serializable & Comparable, V extends java.io.Serializable & CharSequence").isSuperTypeOf("T", "V")
	}
	
	@Test
	def void testCommonSuperType_18() {
		("T"->"T, V extends T").isSuperTypeOf("T", "V")
	}
	
	@Test
	def void testCommonSuperType_19() {
		("Collection<String>"->"T extends java.util.List<String>, V extends T").isSuperTypeOf("java.util.Set<String>", "V")
	}
	
	@Test
	def void testCommonSuperType_20() {
		("Object"->"T extends CharSequence & java.io.Serializable, V extends Appendable & Comparable").isSuperTypeOf("T", "V")
	}
	
	@Test
	def void testCommonSuperType_21() {
		("Object"->"T extends CharSequence & java.io.Serializable").isSuperTypeOf("T", "CharSequence", "java.io.Serializable")
	}
	
	@Test
	def void testCommonSuperType_22() {
		("CharSequence"->"T extends CharSequence & java.io.Serializable").isSuperTypeOf("T", "CharSequence")
	}
	
	@Test
	def void testCommonSuperType_23() {
		val types = <LightweightTypeReference>newImmutableList(new AnyTypeReference(this), new AnyTypeReference(this))
		val superType = services.typeConformanceComputer.getCommonSuperType(types)
		assertEquals("null", superType.simpleName)
	}
	
	@Test
	def void testCommonSuperType_24() {
		"Collection<? extends AbstractStringBuilder & Serializable>".isSuperTypeOf("java.util.List<StringBuilder>", "java.util.Set<StringBuffer>")
	}
	
	@Test
	def void testCommonSuperType_25() {
		"Iterable".isSuperTypeOf("java.util.List<StringBuilder>", "org.eclipse.xtext.common.types.testSetups.RawIterable")
	}
	
	@Test
	def void testCommonSuperType_26() {
		"Iterable".isSuperTypeOf("java.util.List<StringBuilder>", "org.eclipse.xtend.core.tests.typesystem.CharIterable")
	}
	
	@Test
	def void testCommonSuperType_27() {
		"Iterable<? extends CharSequence>".isSuperTypeOf("java.util.List<StringBuilder>", "org.eclipse.xtend.core.tests.typesystem.CharIterable<CharSequence>")
	}
	
	@Test
	def void testCommonSuperType_28() {
		"Number[] & Comparable<?>[]".isSuperTypeOf("Integer[]", "Double[]")
	}
	
	@Test
	def void testCommonSuperType_29() {
		"Serializable & Cloneable".isSuperTypeOf("int[]", "double[]")
	}
	
	@Test
	def void testCommonSuperType_30() {
		"Serializable & Cloneable".isSuperTypeOf("int[][]", "int[]")
	}
	
	@Test
	def void testCommonSuperType_31() {
		"Object[]".isSuperTypeOf("CharSequence[][]", "CharSequence[]")
	}
	
	@Test
	def void testCommonSuperType_32() {
		"Number[]".isSuperTypeOf("Number[]", "Integer[]", "Double[]")
	}
	
	@Test
	def void testCommonSuperType_33() {
		("T[]"->"T, V extends T").isSuperTypeOf("V[]", "T[]")
	}
	
	@Test
	def void testCommonSuperType_34() {
		("Iterable<? extends CharSequence>"->"T extends CharSequence, V extends T").isSuperTypeOf("Iterable<CharSequence>", "Iterable<V>")
	}
	
	@Test
	def void testCommonSuperType_35() {
		"Iterable<? extends CharSequence>".isSuperTypeOf("Iterable<CharSequence>", "Iterable<? extends CharSequence>")
	}
	
	@Test
	def void testCommonSuperType_36() {
		"Iterable<? super CharSequence>".isSuperTypeOf("Iterable<CharSequence>", "Iterable<? super CharSequence>")
	}
	
	@Test
	def void testCommonSuperType_37() {
		"Iterable<?>".isSuperTypeOf("Iterable<? super CharSequence>", "Iterable<? extends CharSequence>")
	}
	
	@Test
	def void testCommonSuperType_38() {
		("CharSequence[]"->"T extends CharSequence, V extends T").isSuperTypeOf("V[]", "String[]")
	}
	
	@Test
	def void testCommonSuperType_39() {
		"Number[][][] & Comparable<?>[][][]".isSuperTypeOf("Integer[][][]", "Double[][][]")
	}
	
	@Test
	def void testCommonSuperType_40() {
		"Serializable[]".isSuperTypeOf("Number[][]", "Number[]")
	}
	
	@Test
	def void testCommonSuperType_41() {
		"Comparable<?> & Serializable".isSuperTypeOf("String", "int")
	}
	
	@Test
	def void testCommonSuperType_42() {
		"AbstractList<String> & Serializable & Cloneable".isSuperTypeOf("java.util.LinkedList<String>", "java.util.ArrayList<String>")
	}
	
	@Test
	def void testCommonSuperType_43() {
		isSuperTypeOf(null as String, "String", "void")
	}
	
	@Test
	def void testCommonSuperType_44() {
		"void".isSuperTypeOf("void", "void")
	}
	
	@Test
	def void testCommonSuperType_45() {
		"Class<?>".isSuperTypeOf("Class<Void>", "Class<String>")
	}
	
	@Test
	def void testCommonSuperType_46() {
		"Collection<?>".isSuperTypeOf("java.util.Collection<Void>", "java.util.List<String>")
	}
	
	@Test
	def void testCommonSuperType_47() {
		"long".isSuperTypeOf("long", "int")
	}
	
	@Test
	def void testCommonSuperType_48() {
		"double".isSuperTypeOf("long", "double")
	}
}

