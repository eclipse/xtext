/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.util;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import junit.framework.TestCase;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
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
import org.eclipse.xtext.common.types.access.impl.ClassURIHelper;
import org.eclipse.xtext.common.types.access.impl.DeclaredTypeFactory;

import com.google.inject.internal.Lists;

/**
 * @author svenefftinge - Initial contribution and API
 */
public abstract class AbstractJvmTypeConformanceComputerTest extends TestCase {

	private IJvmTypeConformanceComputer computer = new IJvmTypeConformanceComputer.Impl(new SuperTypeCollector(TypesFactory.eINSTANCE));
	private DeclaredTypeFactory factory = new DeclaredTypeFactory(new ClassURIHelper());

	protected JvmTypeReference ref(java.lang.reflect.Type type, JvmTypeReference... arguments) {
		JvmTypeReference createTypeReference = factory.createTypeReference(type);
		if (arguments.length > 0) {
			for (JvmTypeReference typeArgument : arguments) {
				((JvmParameterizedTypeReference) createTypeReference).getArguments().add(typeArgument);
			}
		}
		Resource syntheticResource = getSyntheticResource();
		syntheticResource.getContents().add(createTypeReference);
		EcoreUtil.resolveAll(syntheticResource);
		return createTypeReference;
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

	protected abstract IJvmTypeProvider getTypeProvider();

	protected abstract Resource getSyntheticResource();

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
		assertTrue(computer.isConformant(rawList, List_of_super_String));
		assertTrue(computer.isConformant(List_of_super_String, rawList));
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
		assertTrue(computer.isConformant(List_String, List_rawtype));
		assertTrue(computer.isConformant(List_rawtype, List_String));
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
		assertTrue(computer.isConformant(List_String, List_rawtype));
		assertTrue(computer.isConformant(List_rawtype, List_String));
	}
	
	
	public void testInterfacesConformToObject() throws Exception {
		JvmTypeReference interfaceType = ref(CharSequence.class);
		JvmTypeReference objectType = ref(Object.class);
		assertTrue(computer.isConformant(objectType, interfaceType));
	}
	
	/**
	 * List<? super String> <= List<? super CharSequence> (but not vice versa)
	 */
	public void testGenerics_super_1() throws Exception {
		JvmTypeReference List_of_super_CharSequence = ref(List.class, wc_super(ref(CharSequence.class)));
		JvmTypeReference List_of_super_String = ref(List.class, wc_super(ref(String.class)));
		assertTrue(computer.isConformant(List_of_super_String, List_of_super_CharSequence));
		assertFalse(computer.isConformant(List_of_super_CharSequence, List_of_super_String));
	}

	/**
	 * List<?> <= List<CharSequence>
	 */
	public void testGenerics_UnconstraintWildcard_1() throws Exception {
		JvmTypeReference List_CharSequence = ref(List.class, ref(CharSequence.class));
		JvmTypeReference List_of_wildcard = ref(List.class, wc());
		assertTrue(computer.isConformant(List_of_wildcard, List_CharSequence));
		assertFalse(computer.isConformant(List_CharSequence, List_of_wildcard));
	}
	
	/**
	 * List<?> <= List<? super CharSequence> 
	 */
	public void testGenerics_UnconstraintWildcard_2() throws Exception {
		JvmTypeReference List_of_super_CharSequence = ref(List.class, wc_super(ref(CharSequence.class)));
		JvmTypeReference List_of_wildcard = ref(List.class, wc());
		assertTrue(computer.isConformant(List_of_wildcard, List_of_super_CharSequence));
		assertFalse(computer.isConformant(List_of_super_CharSequence, List_of_wildcard));
	}
	/**
	 * List<?> <= List<? extends CharSequence> 
	 */
	public void testGenerics_UnconstraintWildcard_3() throws Exception {
		JvmTypeReference List_of_extends_CharSequence = ref(List.class, wc_extends(ref(CharSequence.class)));
		JvmTypeReference List_of_wildcard = ref(List.class, wc());
		assertTrue(computer.isConformant(List_of_wildcard, List_of_extends_CharSequence));
		assertFalse(computer.isConformant(List_of_extends_CharSequence, List_of_wildcard));
	}

	public void testGenerics_1() throws Exception {
		JvmTypeReference List_of_String = ref(List.class, ref(String.class));
		JvmTypeReference List_of_extends_String = ref(List.class, wc_extends(ref(String.class)));
		assertTrue(computer.isConformant(List_of_extends_String, List_of_String));
		assertFalse(computer.isConformant(List_of_String, List_of_extends_String));
	}

	public void testGenerics_2() throws Exception {
		JvmTypeReference List_of_String = ref(List.class, ref(String.class));
		JvmTypeReference Collection_of_String = ref(Collection.class, ref(String.class));
		assertTrue(computer.isConformant(Collection_of_String, List_of_String));
		assertFalse(computer.isConformant(List_of_String, Collection_of_String));
	}

	public void testGenerics_3() throws Exception {
		JvmTypeReference Func_of_String_String = ref(Map.class, ref(String.class), ref(String.class));
		JvmTypeReference Func_of_extends_String_String = ref(Map.class, wc_extends(ref(String.class)), ref(String.class));
		assertTrue(computer.isConformant(Func_of_extends_String_String, Func_of_String_String));
		assertFalse(computer.isConformant(Func_of_String_String, Func_of_extends_String_String));
	}

	public void testGenerics_4() throws Exception {
		JvmTypeReference Func_of_String_String = ref(Map.class, ref(String.class), ref(String.class));
		JvmTypeReference Func_of_extends_String_String = ref(Map.class, ref(String.class), ref(String.class));
		assertTrue(computer.isConformant(Func_of_extends_String_String, Func_of_String_String));
		assertTrue(computer.isConformant(Func_of_String_String, Func_of_extends_String_String));
	}

	public void testSameType() throws Exception {
		assertTrue(computer.isConformant(ref(String.class), ref(String.class)));
	}

	public void testInheritanceCompatibility() throws Exception {
		assertTrue(computer.isConformant(ref(CharSequence.class), ref(String.class)));
		assertFalse(computer.isConformant(ref(String.class), ref(CharSequence.class)));
	}

	public void testAutoBoxingInteger() throws Exception {
		assertTrue(computer.isConformant(ref(Integer.TYPE), ref(Integer.class)));
		assertTrue(computer.isConformant(ref(Integer.class), ref(Integer.TYPE)));
	}

	public void testAutoBoxingBoolean() throws Exception {
		assertTrue(computer.isConformant(ref(Boolean.TYPE), ref(Boolean.class)));
		assertTrue(computer.isConformant(ref(Boolean.class), ref(Boolean.TYPE)));
	}

	public void testAutoBoxingLong() throws Exception {
		assertTrue(computer.isConformant(ref(Long.TYPE), ref(Long.class)));
		assertTrue(computer.isConformant(ref(Long.class), ref(Long.TYPE)));
	}

	public void testAutoBoxingFloat() throws Exception {
		assertTrue(computer.isConformant(ref(Float.TYPE), ref(Float.class)));
		assertTrue(computer.isConformant(ref(Float.class), ref(Float.TYPE)));
	}

	public void testAutoBoxingDouble() throws Exception {
		assertTrue(computer.isConformant(ref(Double.TYPE), ref(Double.class)));
		assertTrue(computer.isConformant(ref(Double.class), ref(Double.TYPE)));
	}

	public void testAutoBoxingByte() throws Exception {
		assertTrue(computer.isConformant(ref(Byte.TYPE), ref(Byte.class)));
		assertTrue(computer.isConformant(ref(Byte.class), ref(Byte.TYPE)));
	}

	public void testArrayType() throws Exception {
		assertTrue(computer.isConformant(array(ref(String.class), 1), array(ref(String.class), 1)));
		assertFalse(computer.isConformant(array(ref(String.class), 1), array(ref(CharSequence.class), 1)));
		assertFalse(computer.isConformant(array(ref(String.class), 2), array(ref(String.class), 1)));
		assertFalse(computer.isConformant(array(ref(String.class), 1), array(ref(String.class), 2)));
	}
	
	protected void assertCommonSuperType(Class<?> expected, Class<?> ...types) {
		List<JvmTypeReference> refs = Lists.newArrayList();
		for (int i = 0; i < types.length; i++) {
			Class<?> class1 = types[i];
			refs.add(ref(class1));
		}
		JvmTypeReference type = computer.getCommonSuperType(refs);
		assertEquals(expected.getCanonicalName(), type.getCanonicalName());
	}
	
	public void testCommonSuperType_0() throws Exception {
		assertCommonSuperType(
				CharSequence.class,
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
	
	public void testConformanceWithTypeParameter() throws Exception {
		JvmTypeParameter typeParam = ((JvmGenericType)ref(List.class).getType()).getTypeParameters().get(0);
		JvmParameterizedTypeReference reference = TypesFactory.eINSTANCE.createJvmParameterizedTypeReference();
		reference.setType(typeParam);
		assertTrue(computer.isConformant(reference, ref(Object.class)));
		assertTrue(computer.isConformant(reference, ref(String.class)));
		assertTrue(computer.isConformant(reference, ref(CharSequence.class)));
		assertTrue(computer.isConformant(reference, ref(Serializable.class)));
	}

}
