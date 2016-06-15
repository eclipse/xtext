/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.descriptions;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.builder.builderState.BuilderStateFactory;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.impl.AbstractResourceDescription;
import org.junit.Test;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class EObjectDescriptionBasedStubGeneratorTest {
	
	private EObjectDescriptionBasedStubGenerator gen = new EObjectDescriptionBasedStubGenerator();

	
	@Test
	public void testStubGenerator() throws Exception {
		EObjectDescription _class = new EObjectDescription(QualifiedName.create("foo","Bar"), TypesFactory.eINSTANCE.createJvmGenericType(), Collections.<String,String>emptyMap());
		EObjectDescription _class_with_typeParam = new EObjectDescription(QualifiedName.create("foo","Bar"), TypesFactory.eINSTANCE.createJvmGenericType(), Collections.singletonMap(JvmTypesResourceDescriptionStrategy.TYPE_PARAMETERS, "<A,B>"));
		EObjectDescription _nested_class = new EObjectDescription(QualifiedName.create("foo","Bar$Baz"), TypesFactory.eINSTANCE.createJvmGenericType(), Collections.singletonMap(JvmTypesResourceDescriptionStrategy.IS_NESTED_TYPE, Boolean.TRUE.toString()));
		EObjectDescription _interface = new EObjectDescription(QualifiedName.create("foo","Bar"), TypesFactory.eINSTANCE.createJvmGenericType(), Collections.singletonMap(JvmTypesResourceDescriptionStrategy.IS_INTERFACE, Boolean.TRUE.toString()));
		EObjectDescription _enum = new EObjectDescription(QualifiedName.create("foo","Bar"), TypesFactory.eINSTANCE.createJvmEnumerationType(), Collections.<String,String>emptyMap());
		EObjectDescription _annotation = new EObjectDescription(QualifiedName.create("foo","Bar"), TypesFactory.eINSTANCE.createJvmAnnotationType(), Collections.<String,String>emptyMap());
		IResourceDescription emptyResource = BuilderStateFactory.eINSTANCE.createResourceDescription();

		assertEquals("package foo;\npublic class Bar{\n}",gen.getJavaStubSource(_class, emptyResource));
		assertEquals("package foo;\npublic class Bar<A,B>{\n}",gen.getJavaStubSource(_class_with_typeParam, emptyResource));
		assertNull(gen.getJavaStubSource(_nested_class, emptyResource));
		assertEquals("package foo;\npublic interface Bar{\n}",gen.getJavaStubSource(_interface, emptyResource));
		assertEquals("package foo;\npublic enum Bar{\n}",gen.getJavaStubSource(_enum, emptyResource));
		assertEquals("package foo;\npublic @interface Bar{\n}",gen.getJavaStubSource(_annotation, emptyResource));
	}
	
	@Test 
	public void testNested() {
		final EObjectDescription _top = new EObjectDescription(QualifiedName.create("foo","Bar"), TypesFactory.eINSTANCE.createJvmGenericType(), Collections.<String,String>emptyMap());
		final EObjectDescription _nested0 = new EObjectDescription(QualifiedName.create("foo","Bar$Baz0"), TypesFactory.eINSTANCE.createJvmGenericType(), Collections.singletonMap(JvmTypesResourceDescriptionStrategy.IS_NESTED_TYPE, Boolean.TRUE.toString()));
		final EObjectDescription _nested1 = new EObjectDescription(QualifiedName.create("foo","Bar$Baz1"), TypesFactory.eINSTANCE.createJvmGenericType(), Collections.singletonMap(JvmTypesResourceDescriptionStrategy.IS_NESTED_TYPE, Boolean.TRUE.toString()));
		final EObjectDescription _nested10 = new EObjectDescription(QualifiedName.create("foo","Bar$Baz1$FooBar0"), TypesFactory.eINSTANCE.createJvmGenericType(), Collections.singletonMap(JvmTypesResourceDescriptionStrategy.IS_NESTED_TYPE, Boolean.TRUE.toString()));
		final EObjectDescription _nested11 = new EObjectDescription(QualifiedName.create("foo","Bar$Baz1$FooBar0"), TypesFactory.eINSTANCE.createJvmGenericType(), Collections.singletonMap(JvmTypesResourceDescriptionStrategy.IS_NESTED_TYPE, Boolean.TRUE.toString()));
		IResourceDescription resourceDescription = new AbstractResourceDescription( ) {
			
			@Override
			public URI getURI() {
				return null;
			}
			
			@Override
			public Iterable<IReferenceDescription> getReferenceDescriptions() {
				return Collections.emptyList();
			}
			
			@Override
			public Iterable<QualifiedName> getImportedNames() {
				return Collections.emptyList();
			}
			
			@Override
			protected List<IEObjectDescription> computeExportedObjects() {
				return Arrays.asList(new IEObjectDescription[] {_top, _nested0, _nested1, _nested10, _nested11});
			}
		};
		assertEquals("package foo;\n"
				+ "public class Bar{\n"
				+ "public static class Baz0{\n"
				+ "}\n"
				+ "public static class Baz1{\n"
				+ "public static class FooBar0{\n"
				+ "}\n"
				+ "public static class FooBar0{\n"
				+ "}\n"
				+ "}\n"
				+ "}"
				, gen.getJavaStubSource(_top, resourceDescription));
	}
}
