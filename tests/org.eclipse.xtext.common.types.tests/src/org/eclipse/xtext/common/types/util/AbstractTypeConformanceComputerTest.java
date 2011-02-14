/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.util;

import java.io.Serializable;
import java.nio.CharBuffer;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl;
import org.eclipse.xtext.common.types.JvmArrayType;
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmLowerBound;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.access.IJvmTypeProvider;
import org.eclipse.xtext.common.types.access.impl.DeclaredTypeFactory;

import com.google.common.collect.Lists;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Module;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public abstract class AbstractTypeConformanceComputerTest extends TestCase {

	@Inject
	private TypeConformanceComputer computer;
	
	@Inject
	private DeclaredTypeFactory factory;

	@Inject
	private ResourceSetImpl resourceSet;
	
	@Inject
	private IJvmTypeProvider.Factory typeProviderFactory;

	private XMLResourceImpl syntheticResource;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		Injector injector = Guice.createInjector(getModule());
		injector.injectMembers(this);
		typeProviderFactory.findOrCreateTypeProvider(resourceSet);
		syntheticResource = new XMLResourceImpl(URI.createURI("http://synthetic.resource"));
		resourceSet.getResources().add(syntheticResource);
	}
	
	protected abstract Module getModule();
	
	@Override
	protected void tearDown() throws Exception {
		computer = null;
		factory = null;
		resourceSet = null;
		syntheticResource = null;
		typeProviderFactory = null;
		super.tearDown();
	}
	
	protected JvmTypeReference ref(java.lang.reflect.Type type, JvmTypeReference... arguments) {
		JvmTypeReference result = factory.createTypeReference(type);
		if (arguments.length > 0) {
			for (JvmTypeReference typeArgument : arguments) {
				((JvmParameterizedTypeReference) result).getArguments().add(typeArgument);
			}
		}
		Resource syntheticResource = getSyntheticResource();
		syntheticResource.getContents().add(result);
		EcoreUtil.resolveAll(syntheticResource);
		return result;
	}

	protected JvmGenericArrayTypeReference array(JvmTypeReference typeRef, int i) {
		JvmGenericArrayTypeReference result = TypesFactory.eINSTANCE.createJvmGenericArrayTypeReference();
		JvmArrayType arrayType = TypesFactory.eINSTANCE.createJvmArrayType();
		result.setType(arrayType);
		if (i == 1) {
			arrayType.setComponentType(typeRef);
		} else {
			arrayType.setComponentType(array(typeRef, i - 1));
		}
		return result;
	}

	protected JvmWildcardTypeReference wc() {
		JvmWildcardTypeReference result = TypesFactory.eINSTANCE.createJvmWildcardTypeReference();
		return result;
	}

	protected JvmWildcardTypeReference wc_extends(JvmTypeReference typeRef) {
		JvmWildcardTypeReference result = TypesFactory.eINSTANCE.createJvmWildcardTypeReference();
		JvmUpperBound upperBound = TypesFactory.eINSTANCE.createJvmUpperBound();
		upperBound.setTypeReference(typeRef);
		result.getConstraints().add(upperBound);
		return result;
	}

	protected JvmWildcardTypeReference wc_super(JvmTypeReference typeRef) {
		JvmWildcardTypeReference result = TypesFactory.eINSTANCE.createJvmWildcardTypeReference();
		JvmLowerBound lowerBound = TypesFactory.eINSTANCE.createJvmLowerBound();
		lowerBound.setTypeReference(typeRef);
		result.getConstraints().add(lowerBound);
		return result;
	}

	protected IJvmTypeProvider getTypeProvider() {
		return typeProviderFactory.findOrCreateTypeProvider(resourceSet);
	}

	protected Resource getSyntheticResource() {
		return syntheticResource;
	}
	
	public void testWildCardWithDefaultUpper() throws Exception {
		JvmTypeReference left = ref(Iterable.class, wc_extends(ref(Object.class)));
		JvmTypeReference right = ref(List.class, wc());
		assertTrue(getComputer().isConformant(left, right, true));
		assertTrue(getComputer().isConformant(left, right, false));
	}

	public void testIgnoreGenrics_00() throws Exception {
		JvmTypeReference list = ref(List.class, wc_super(ref(Integer.class)));
		JvmTypeReference iterable = ref(Iterable.class, wc_super(ref(String.class)));
		assertTrue(getComputer().isConformant(iterable, list, true));
		assertFalse(getComputer().isConformant(iterable, list, false));
	}
	public void testIgnoreGenrics_01() throws Exception {
		JvmTypeReference list = ref(List.class, wc_super(ref(Integer.class)));
		JvmTypeReference list2 = ref(List.class, wc_super(ref(String.class)));
		assertTrue(getComputer().isConformant(list2, list, true));
		assertFalse(getComputer().isConformant(list2, list, false));
	}
	public void testIgnoreGenrics_02() throws Exception {
		JvmTypeReference left = ref(CharSequence.class);
		JvmTypeReference right = ref(List.class, wc_super(ref(Integer.class)));
		assertFalse(getComputer().isConformant(left, right, true));
		assertFalse(getComputer().isConformant(left, right, false));
	}
	public void testIgnoreGenrics_03() throws Exception {
		JvmTypeReference left = ref(Integer.TYPE);
		JvmTypeReference right = ref(Long.TYPE);
		assertTrue(getComputer().isConformant(left, right, false));
		assertTrue(getComputer().isConformant(left, right, true));
	}
	
	/**
	 * List <= List<? super CharSequence>
	 * and
	 * List<? super CharSequence> <= List
	 */
	public void testRawTypes_super() throws Exception {
//		List<? super String> foo = null;
//		List zonk = null;
//		foo = zonk; // ok
//		zonk = foo; // ok
		JvmTypeReference rawList = ref(List.class);
		JvmTypeReference List_of_super_String = ref(List.class, wc_super(ref(String.class)));
		assertTrue(getComputer().isConformant(rawList, List_of_super_String));
		assertTrue(getComputer().isConformant(List_of_super_String, rawList));
	}
	
	/**
	 * List<String> <= List
	 * and
	 * List <= List<String>
	 */
	public void testRawtype_generics() throws Exception {
//		List<String> foo = null;
//		List zonk = null;
//		foo = zonk; // ok
//		zonk = foo; // ok
		JvmTypeReference List_String = ref(List.class, ref(String.class));
		JvmTypeReference List_rawtype = ref(List.class);
		assertTrue(getComputer().isConformant(List_String, List_rawtype));
		assertTrue(getComputer().isConformant(List_rawtype, List_String));
	}
	
	/**
	 * List<? extends String> <= List
	 * and
	 * List <= List<String>
	 */
	public void testRawType_extends() throws Exception {
//		List<? extends String> foo = null;
//		List zonk = null;
//		foo = zonk; // ok
//		zonk = foo; // ok
		JvmTypeReference List_String = ref(List.class, wc_extends(ref(String.class)));
		JvmTypeReference List_rawtype = ref(List.class);
		assertTrue(getComputer().isConformant(List_String, List_rawtype));
		assertTrue(getComputer().isConformant(List_rawtype, List_String));
	}
	
	
	public void testInterfacesConformToObject() throws Exception {
		JvmTypeReference interfaceType = ref(CharSequence.class);
		JvmTypeReference objectType = ref(Object.class);
		assertTrue(getComputer().isConformant(objectType, interfaceType));
	}
	
	public void testStringAndInteger() throws Exception {
		JvmTypeReference stringType = ref(String.class);
		JvmTypeReference integerType = ref(Integer.class);
		assertFalse(getComputer().isConformant(integerType, stringType));
		assertFalse(getComputer().isConformant(integerType, stringType));
	}
	
	/**
	 * List<? super String> <= List<? super CharSequence> (but not vice versa)
	 */
	public void testGenerics_super_1() throws Exception {
		JvmTypeReference List_of_super_CharSequence = ref(List.class, wc_super(ref(CharSequence.class)));
		JvmTypeReference List_of_super_String = ref(List.class, wc_super(ref(String.class)));
		assertTrue(getComputer().isConformant(List_of_super_String, List_of_super_CharSequence));
		assertFalse(getComputer().isConformant(List_of_super_CharSequence, List_of_super_String));
	}

	/**
	 * List<?> <= List<CharSequence>
	 */
	public void testGenerics_UnconstraintWildcard_1() throws Exception {
		JvmTypeReference List_CharSequence = ref(List.class, ref(CharSequence.class));
		JvmTypeReference List_of_wildcard = ref(List.class, wc());
		assertTrue(getComputer().isConformant(List_of_wildcard, List_CharSequence));
		assertFalse(getComputer().isConformant(List_CharSequence, List_of_wildcard));
	}
	
	/**
	 * List<?> <= List<? super CharSequence> 
	 */
	public void testGenerics_UnconstraintWildcard_2() throws Exception {
		JvmTypeReference List_of_super_CharSequence = ref(List.class, wc_super(ref(CharSequence.class)));
		JvmTypeReference List_of_wildcard = ref(List.class, wc());
		assertTrue(getComputer().isConformant(List_of_wildcard, List_of_super_CharSequence));
		assertFalse(getComputer().isConformant(List_of_super_CharSequence, List_of_wildcard));
	}
	/**
	 * List<?> <= List<? extends CharSequence> 
	 */
	public void testGenerics_UnconstraintWildcard_3() throws Exception {
		JvmTypeReference List_of_extends_CharSequence = ref(List.class, wc_extends(ref(CharSequence.class)));
		JvmTypeReference List_of_wildcard = ref(List.class, wc());
		assertTrue(getComputer().isConformant(List_of_wildcard, List_of_extends_CharSequence));
		assertFalse(getComputer().isConformant(List_of_extends_CharSequence, List_of_wildcard));
	}

	public void testGenerics_1() throws Exception {
		JvmTypeReference List_of_String = ref(List.class, ref(String.class));
		JvmTypeReference List_of_extends_String = ref(List.class, wc_extends(ref(String.class)));
		assertTrue(getComputer().isConformant(List_of_extends_String, List_of_String));
		assertFalse(getComputer().isConformant(List_of_String, List_of_extends_String));
	}
	
	public void testGenerics_2() throws Exception {
		JvmTypeReference List_of_String = ref(List.class, ref(String.class));
		JvmTypeReference Collection_of_String = ref(Collection.class, ref(String.class));
		assertTrue(getComputer().isConformant(Collection_of_String, List_of_String));
		assertFalse(getComputer().isConformant(List_of_String, Collection_of_String));
	}

	public void testGenerics_3() throws Exception {
		JvmTypeReference Func_of_String_String = ref(Map.class, ref(String.class), ref(String.class));
		JvmTypeReference Func_of_extends_String_String = ref(Map.class, wc_extends(ref(String.class)), ref(String.class));
		assertTrue(getComputer().isConformant(Func_of_extends_String_String, Func_of_String_String));
		assertFalse(getComputer().isConformant(Func_of_String_String, Func_of_extends_String_String));
	}

	public void testGenerics_4() throws Exception {
		JvmTypeReference Func_of_String_String = ref(Map.class, ref(String.class), ref(String.class));
		JvmTypeReference Func_of_extends_String_String = ref(Map.class, ref(String.class), ref(String.class));
		assertTrue(getComputer().isConformant(Func_of_extends_String_String, Func_of_String_String));
		assertTrue(getComputer().isConformant(Func_of_String_String, Func_of_extends_String_String));
	}
	
	/**
	 * List<CharSequence> =/= List<String>  
	 */
	public void testGenerics_5() throws Exception {
		JvmTypeReference List_of_String = ref(List.class, ref(String.class));
		JvmTypeReference List_of_CharSequence = ref(List.class, ref(CharSequence.class));
		assertFalse(getComputer().isConformant(List_of_CharSequence, List_of_String));
		assertFalse(getComputer().isConformant(List_of_String, List_of_CharSequence));
	}
	
	public void testGenerics_6() throws Exception {
		JvmTypeReference List_of_List_of_String = ref(List.class, ref(List.class, ref(String.class)));
		JvmTypeReference List_of_List_of_CharSequence = ref(List.class, ref(List.class, ref(CharSequence.class)));
		assertFalse(getComputer().isConformant(List_of_List_of_CharSequence, List_of_List_of_String));
		assertFalse(getComputer().isConformant(List_of_List_of_String, List_of_List_of_CharSequence));
	}

	public void testSameType() throws Exception {
		assertTrue(getComputer().isConformant(ref(String.class), ref(String.class)));
	}

	public void testInheritanceCompatibility() throws Exception {
		assertTrue(getComputer().isConformant(ref(CharSequence.class), ref(String.class)));
		assertFalse(getComputer().isConformant(ref(String.class), ref(CharSequence.class)));
	}

	public void testAutoBoxingInteger_00() throws Exception {
		assertTrue(getComputer().isConformant(ref(Integer.TYPE), ref(Integer.class)));
	}
	public void testAutoBoxingInteger_01() throws Exception {
		assertTrue(getComputer().isConformant(ref(Integer.class), ref(Integer.TYPE)));
	}
	public void testAutoBoxingInteger_02() throws Exception {
		assertTrue(getComputer().isConformant(ref(Serializable.class), ref(Integer.TYPE)));
	}
	public void testAutoBoxingInteger_03() throws Exception {
		assertTrue(getComputer().isConformant(ref(Comparable.class), ref(Integer.TYPE)));
	}
	public void testAutoBoxingInteger_04() throws Exception {
		assertTrue(getComputer().isConformant(ref(Number.class), ref(Integer.TYPE)));
	}
	public void testAutoBoxingInteger_05() throws Exception {
		assertTrue(getComputer().isConformant(ref(Object.class), ref(Integer.TYPE)));
	}
	public void testAutoBoxingInteger_06() throws Exception {
		assertFalse(getComputer().isConformant(ref(String.class), ref(Integer.TYPE)));
	}

	public void testAutoBoxingBoolean() throws Exception {
		assertTrue(getComputer().isConformant(ref(Boolean.TYPE), ref(Boolean.class)));
		assertTrue(getComputer().isConformant(ref(Boolean.class), ref(Boolean.TYPE)));
	}

	public void testAutoBoxingLong() throws Exception {
		assertTrue(getComputer().isConformant(ref(Long.TYPE), ref(Long.class)));
		assertTrue(getComputer().isConformant(ref(Long.class), ref(Long.TYPE)));
	}

	public void testAutoBoxingFloat() throws Exception {
		assertTrue(getComputer().isConformant(ref(Float.TYPE), ref(Float.class)));
		assertTrue(getComputer().isConformant(ref(Float.class), ref(Float.TYPE)));
	}

	public void testAutoBoxingDouble() throws Exception {
		assertTrue(getComputer().isConformant(ref(Double.TYPE), ref(Double.class)));
		assertTrue(getComputer().isConformant(ref(Double.class), ref(Double.TYPE)));
	}

	public void testAutoBoxingByte() throws Exception {
		assertTrue(getComputer().isConformant(ref(Byte.TYPE), ref(Byte.class)));
		assertTrue(getComputer().isConformant(ref(Byte.class), ref(Byte.TYPE)));
	}

	public void testArrayType() throws Exception {
		assertTrue(getComputer().isConformant(array(ref(String.class), 1), array(ref(String.class), 1)));
		assertFalse(getComputer().isConformant(array(ref(String.class), 1), array(ref(CharSequence.class), 1)));
		assertFalse(getComputer().isConformant(array(ref(String.class), 2), array(ref(String.class), 1)));
		assertFalse(getComputer().isConformant(array(ref(String.class), 1), array(ref(String.class), 2)));
	}
	
	protected void assertCommonSuperType(Class<?> expected, Class<?> ...types) {
		List<JvmTypeReference> refs = Lists.newArrayList();
		for (int i = 0; i < types.length; i++) {
			Class<?> class1 = types[i];
			refs.add(ref(class1));
		}
		assertCommonSuperType(expected.getCanonicalName(), refs);
	}
	
	protected void assertCommonSuperType(String expected, JvmTypeReference... types) {
		assertCommonSuperType(expected, Arrays.asList(types));
	}
	
	protected void assertCommonSuperType(String expected, List<JvmTypeReference> refs) {
		JvmTypeReference type = getComputer().getCommonSuperType(refs);
		assertEquals(expected, type.getCanonicalName());
	}
	
	public void testCommonSuperType_0() throws Exception {
		assertCommonSuperType(
				Serializable.class,
				String.class,
				StringBuilder.class);
	}
	

	public void testCommonSuperType_1() throws Exception {
		assertCommonSuperType(
				CharSequence.class,
				String.class,
				StringBuilder.class,
				CharSequence.class
				);
	}
	
	public void testCommonSuperType_2() throws Exception {
		assertCommonSuperType(Object.class,
				String.class,
				StringBuilder.class,
				CharSequence.class,
				Object.class
		);
	}
	
	public void testCommonSuperType_3() throws Exception {
		assertCommonSuperType(String.class,
				String.class,
				String.class
		);
	}
	
	public void testCommonSuperType_4() throws Exception {
		assertCommonSuperType(String.class,
				String.class
		);
	}
	
	public void testCommonSuperType_5() throws Exception {
		assertCommonSuperType(
				Serializable.class,
				String.class,
				StringBuilder.class,
				Serializable.class);
	}
	
	public void testCommonSuperType_6() throws Exception {
		assertCommonSuperType(
				Serializable.class,
				StringBuilder.class,
				String.class);
	}
	
	public void testCommonSuperType_7() throws Exception {
		assertCommonSuperType(
				Appendable.class,
				StringBuilder.class,
				CharBuffer.class);
	}
	
	public void testCommonSuperType_8() throws Exception {
		assertCommonSuperType(
				"java.util.Collection<java.lang.String>",
				ref(Set.class, ref(String.class)),
				ref(List.class, ref(String.class)));
	}
	
	public void testCommonSuperType_9() throws Exception {
		assertCommonSuperType(
				"java.util.Collection<? extends E>", // one raw type - super type is raw type
				ref(Set.class, ref(String.class)),
				ref(List.class));
	}
	
	public void testCommonSuperType_10() throws Exception {
		assertCommonSuperType(
				"java.util.Collection<? extends java.lang.CharSequence>",
				ref(Set.class, ref(String.class)),
				ref(List.class, ref(CharSequence.class)));
	}
	
	public void testCommonSuperType_11() throws Exception {
		assertCommonSuperType(
				"java.lang.Comparable<? extends java.lang.Object>",
				ref(String.class),
				ref(Integer.class));
	}
	
	public void testCommonSuperType_12() throws Exception {
		assertCommonSuperType(
				"java.lang.Number",
				ref(Double.class),
				ref(Integer.class));
	}
	
	public void testConformanceWithTypeParameter() throws Exception {
		JvmTypeParameter typeParam = ((JvmGenericType)ref(List.class).getType()).getTypeParameters().get(0);
		JvmParameterizedTypeReference reference = TypesFactory.eINSTANCE.createJvmParameterizedTypeReference();
		reference.setType(typeParam);
		assertTrue(getComputer().isConformant(reference, ref(Object.class)));
		assertTrue(getComputer().isConformant(reference, ref(String.class)));
		assertTrue(getComputer().isConformant(reference, ref(CharSequence.class)));
		assertTrue(getComputer().isConformant(reference, ref(Serializable.class)));
	}
	
	public TypeConformanceComputer getComputer() {
		return computer;
	}

}
