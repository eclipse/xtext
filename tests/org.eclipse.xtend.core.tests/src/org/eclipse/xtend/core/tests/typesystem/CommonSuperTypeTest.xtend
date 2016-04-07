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
import org.eclipse.xtext.xbase.typesystem.references.AnyTypeReference
import org.eclipse.xtext.xbase.typesystem.references.FunctionTypeReference
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference
import org.junit.Test

/**
 * @author Sebastian Zarnekow
 */
class CommonSuperTypeTest extends AbstractTestingTypeReferenceOwner {
	
	@Inject
	extension IXtendJvmAssociations
	
	def isSuperTypeOf(String superType, String... types) {
		(superType->null).isSuperTypeOf(types)
	}
	
	def Object isSuperTypeOf(Pair<String, String> superTypeAndParam, String... types) {
		// TODO synthesize unique variable names as soon as the function should be validated
		val signature = '''def «IF !superTypeAndParam.value.nullOrEmpty»<«superTypeAndParam.value»> «ENDIF»void method(«
			FOR type: types SEPARATOR ', '»«type.fixup» t«ENDFOR») {}'''
		val function = function(signature.toString)
		val operation = function.directlyInferredOperation
		val typeReferences = new ArrayList(operation.parameters.map [ parameterType.toLightweightTypeReference ])
		val conformanceComputer = getServices.typeConformanceComputer 
		var computedSuperType = conformanceComputer.getCommonSuperType(typeReferences, owner)
		assertEquals(superTypeAndParam.key, computedSuperType?.simpleName)
		computedSuperType = getServices.typeConformanceComputer.getCommonSuperType((typeReferences + typeReferences).toList, owner)
		assertEquals(superTypeAndParam.key, computedSuperType?.simpleName)
		computedSuperType = getServices.typeConformanceComputer.getCommonSuperType(typeReferences.reverseView, owner)
		assertEquals(superTypeAndParam.key, computedSuperType?.simpleName)
		if (!computedSuperType.isPrimitiveOrVoid) {
			computedSuperType = getServices.typeConformanceComputer.getCommonSuperType((typeReferences + newImmutableList(owner.newAnyTypeReference, owner.newAnyTypeReference)).toList, owner)
			assertEquals(superTypeAndParam.key, computedSuperType?.simpleName)
		}
		if (computedSuperType != null) {
			computedSuperType => [ superType |
				for (it : typeReferences) {
					assertEquals(superTypeAndParam.key, conformanceComputer.getCommonSuperType(#[it, superType], superType.owner)?.simpleName)
				}
			]
		}
		if (computedSuperType != null) {
			for(subType: typeReferences) {
				assertTrue(computedSuperType.isAssignableFrom(subType))
			}
		}
		return computedSuperType
	}
	
	private def isPrimitiveOrVoid(LightweightTypeReference computedSuperType) {
		if (computedSuperType === null)
			return false
		computedSuperType.primitiveVoid || computedSuperType.primitive
	}
	
	def void isFunctionAndEquivalentTo(Object reference, String type) {
		assertTrue(reference instanceof FunctionTypeReference)
		assertEquals(type, (reference as FunctionTypeReference).equivalent)
	}
	
	def String getEquivalent(ParameterizedTypeReference type) {
		if (type.typeArguments.empty)
			return type.type.simpleName
		return '''«type.type.simpleName»<«type.typeArguments.join(', ') [simpleName]»>'''
	}
	
	def protected String fixup(String type) {
		type?.replace("$$Procedure", "org.eclipse.xtext.xbase.lib.Procedures.Procedure")
			?.replace("$Procedure", "org.eclipse.xtext.xbase.lib.Procedures$Procedure")
			?.replace("$Function<", "com.google.common.base.Function<")
			?.replace("$Predicate<", "com.google.common.base.Predicate<")
			?.replace("$$Function", "org.eclipse.xtext.xbase.lib.Functions.Function")
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
		// dummy to init the owner
		function('def void m() {}')
		val types = <LightweightTypeReference>newImmutableList(new AnyTypeReference(owner), new AnyTypeReference(owner))
		val superType = getServices.typeConformanceComputer.getCommonSuperType(types, owner)
		assertEquals("null", superType.simpleName)
	}
	
	@Test
	def void testCommonSuperType_24() {
		"Collection<? extends AbstractStringBuilder & Serializable>".isSuperTypeOf("java.util.List<StringBuilder>", "java.util.Set<StringBuffer>")
	}
	
	@Test
	def void testCommonSuperType_25() {
		"Iterable".isSuperTypeOf("java.util.List<StringBuilder>", "org.eclipse.xtend.core.tests.typesystem.RawIterable")
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
	
	@Test
	def void testCommonSuperType_49() {
		"()=>void".isSuperTypeOf("()=>void", "()=>void").isFunctionAndEquivalentTo("Procedure0")
	}
	
	@Test
	def void testCommonSuperType_50() {
		"()=>long".isSuperTypeOf("()=>long", "()=>long").isFunctionAndEquivalentTo("Function0<? extends Long>")
	}
	
	@Test
	def void testCommonSuperType_51() {
		"()=>Number & Comparable<?>".isSuperTypeOf("()=>int", "()=>long").isFunctionAndEquivalentTo("Function0<? extends Number & Comparable<?>>")
	}
	
	@Test
	def void testCommonSuperType_52() {
		"()=>Number & Comparable<?>".isSuperTypeOf("()=>Integer", "()=>Long").isFunctionAndEquivalentTo("Function0<? extends Number & Comparable<?>>")
	}
	
	@Test
	def void testCommonSuperType_53() {
		"Object".isSuperTypeOf("()=>void", "()=>Void")
	}
	
	@Test
	def void testCommonSuperType_54() {
		"Object".isSuperTypeOf("(String)=>void", "()=>void")
	}
	
	@Test
	def void testCommonSuperType_55() {
		"(String)=>Integer".isSuperTypeOf("(String)=>Integer", "(String)=>Integer").isFunctionAndEquivalentTo("Function1<? super String, ? extends Integer>")
	}
	
	@Test
	def void testCommonSuperType_56() {
		"(String, String)=>int".isSuperTypeOf("java.util.Comparator<String>", "(String, String)=>int").isFunctionAndEquivalentTo("Function2<? super String, ? super String, ? extends Integer>")
	}
	
	@Test
	def void testCommonSuperType_57() {
		"(String)=>Integer".isSuperTypeOf("(String)=>Integer", "(Object)=>Integer").isFunctionAndEquivalentTo("Function1<? super String, ? extends Integer>")
	}
	
	@Test
	def void testCommonSuperType_58() {
		"(String)=>Object".isSuperTypeOf("(String)=>Appendable", "(CharSequence)=>CharSequence").isFunctionAndEquivalentTo("Function1<? super String, ?>")
	}
	
	@Test
	def void testCommonSuperType_59() {
		"(String, String)=>int".isSuperTypeOf("java.util.Comparator<? super String>", "(String, String)=>int").isFunctionAndEquivalentTo("Function2<? super String, ? super String, ? extends Integer>")
	}
	
	@Test
	def void testCommonSuperType_60() {
		"Object".isSuperTypeOf("java.util.Comparator<? extends String>", "(String, String)=>int")
	}
	
	@Test
	def void testCommonSuperType_61() {
		"Comparator<String>".isSuperTypeOf("java.util.Comparator<String>", "(CharSequence, CharSequence)=>int")
	}
	
	@Test
	def void testCommonSuperType_62() {
		"Comparator<? super String>".isSuperTypeOf("java.util.Comparator<? super String>", "(CharSequence, CharSequence)=>int")
	}
	
	@Test
	def void testCommonSuperType_63() {
		"Object".isSuperTypeOf("java.util.Comparator<? extends String>", "(CharSequence, CharSequence)=>int")
	}
	
	@Test
	def void testCommonSuperType_64() {
		"(String)=>Object".isSuperTypeOf("(String)=>String", "(Object)=>Object").isFunctionAndEquivalentTo("Function1<? super String, ?>")
	}
	
	@Test
	def void testCommonSuperType_65() {
		"(String)=>Object".isSuperTypeOf("$Function1<? super Object, ? extends Object>", "$Function1<? super String, ? extends String>").isFunctionAndEquivalentTo("Function1<? super String, ?>")
	}
	
	@Test
	def void testCommonSuperType_66() {
		"Function1<?, ?>".isSuperTypeOf("$Function1<Object, Object>", "$Function1<String, String>")
	}
	
	@Test
	def void testCommonSuperType_67() {
		"Comparable<?> & Serializable".isSuperTypeOf("Integer", "String")
	}
	
	@Test
	def void testCommonSuperType_68() {
		"Comparable<?> & Serializable".isSuperTypeOf("Integer", "String", "String")
	}
	
	@Test
	def void testCommonSuperType_69() {
		"Iterable<?>".isSuperTypeOf("Iterable<?>", "Iterable<? extends CharSequence>")
	}
	
	@Test
	def void testCommonSuperType_70() {
		"Iterable<?>".isSuperTypeOf("Iterable<? super CharSequence>", "Iterable<?>")
	}
	
	@Test
	def void testCommonSuperType_71() {
		"(String)=>Object".isSuperTypeOf("$$Function1<? super Object, ? extends Object>", "$$Function1<? super String, ? extends String>").isFunctionAndEquivalentTo("Function1<? super String, ?>")
	}
	
	@Test
	def void testCommonSuperType_72() {
		"Function1<?, ?>".isSuperTypeOf("$$Function1<Object, Object>", "$$Function1<String, String>")
	}
	
	@Test
	def void testCommonSuperType_73() {
		"Iterable<?>".isSuperTypeOf("Iterable<? super CharSequence>", "Iterable<String>")
	}
	
	@Test
	def void testCommonSuperType_74() {
		"Boolean".isSuperTypeOf("boolean", "Boolean")
	}
	
	@Test
	def void testCommonSuperType_75() {
		"Boolean".isSuperTypeOf("Boolean", "boolean")
	}
	
	@Test
	def void testCommonSuperType_76() {
		"Super<Number>$Inner<Number>".isSuperTypeOf("test.InnerClasses.Super<Number>.Inner<Number>", "test.InnerClasses.Super<Number>.SubInner<Number>")
	}
	
	@Test
	def void testCommonSuperType_77() {
		"Super<Number>$Inner<Number>".isSuperTypeOf("test.InnerClasses.Super<Number>.SubInner<Number>", "test.InnerClasses.Sub<Number>.SubInner2<String>")
	}
	
	@Test
	def void testCommonSuperType_78() {
		"Super<Number>$Inner<Number>".isSuperTypeOf("test.InnerClasses.Super<Number>.SubInner<Number>", "test.InnerClasses.Sub<Number>.SubInner2<Number>")
	}
	
	@Test
	def void testCommonSuperType_79() {
		"Super<Number>$Inner<Number>[]".isSuperTypeOf("test.InnerClasses.Super<Number>.SubInner<Number>[]", "test.InnerClasses.Sub<Number>.SubInner2<Number>[]")
	}
	
	@Test
	def void testCommonSuperType_80() {
		"Iterable<? extends Class<?>>".isSuperTypeOf("Iterable<Class<Number>>", "Iterable<Class<CharSequence>>")
	}
	
	@Test
	def void testCommonSuperType_81() {
		"Class<?>".isSuperTypeOf("Class<Number>", "Class<CharSequence>")
	}
}


