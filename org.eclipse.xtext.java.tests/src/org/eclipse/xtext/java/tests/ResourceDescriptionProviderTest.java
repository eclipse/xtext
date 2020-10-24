/**
 * Copyright (c) 2056, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.java.tests;

import java.io.OutputStream;
import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmEnumerationType;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.descriptions.JvmTypesResourceDescriptionStrategy;
import org.eclipse.xtext.resource.CompilerPhases;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.InMemoryURIHandler;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.Provider;

@RunWith(XtextRunner.class)
@InjectWith(JavaInjectorProvider.class)
public class ResourceDescriptionProviderTest {
	@Test
	public void testStubGeneration_01() throws Exception {
		String model =
				"public class MyTest {\n" +
				"	public String helloWorld() {\n" +
				"		return \"Hello\";\n" +
				"	}\n" +
				"}\n";
		resultsIn(model, (IResourceDescription it) -> {
			Assert.assertEquals("MyTest", firstExported(it).getQualifiedName().toString());
			Assert.assertFalse(((JvmGenericType) firstExported(it).getEObjectOrProxy()).isInterface());
			Assert.assertEquals(1, Iterables.size(it.getExportedObjects()));
		});
	}

	private IEObjectDescription firstExported(IResourceDescription it) {
		return Iterables.getFirst(it.getExportedObjects(), null);
	}

	@Test
	public void testStubGeneration_02() throws Exception {
		String model =
				"public interface MyTest {\n" +
				"	public String helloWorld();\n" +
				"}\n";
		resultsIn(model, (IResourceDescription it) -> {
			Assert.assertEquals("MyTest", firstExported(it).getQualifiedName().toString());
			Assert.assertTrue(((JvmGenericType) firstExported(it).getEObjectOrProxy()).isInterface());
			Assert.assertEquals(1, Iterables.size(it.getExportedObjects()));
		});
	}

	@Test
	public void testStubGeneration_03() throws Exception {
		String model =
				"public enum MyTest {\n" +
				"	FOO, BAR\n" +
				"}\n";
		resultsIn(model, (IResourceDescription it) -> {
			Assert.assertEquals("MyTest", firstExported(it).getQualifiedName().toString());
			Assert.assertTrue(firstExported(it).getEObjectOrProxy() instanceof JvmEnumerationType);
			Assert.assertEquals(1, Iterables.size(it.getExportedObjects()));
		});
	}

	@Test
	public void testStubGeneration_04() throws Exception {
		String model =
				"public @interface MyTest {\n" +
				"	String value();\n" +
				"}\n";
		resultsIn(model,(IResourceDescription it) -> {
			Assert.assertEquals("MyTest", firstExported(it).getQualifiedName().toString());
			Assert.assertTrue(firstExported(it).getEObjectOrProxy() instanceof JvmAnnotationType);
			Assert.assertEquals(1, Iterables.size(it.getExportedObjects()));
		});
	}

	@Test
	public void testStubGeneration_05() throws Exception {
		String model =
				"package my.pack;\n" +
				"public abstract class MyTest {\n" +
				"	abstract String value();\n" +
				"}\n";
		resultsIn(model, (IResourceDescription it) -> {
			Assert.assertEquals("my.pack.MyTest", firstExported(it).getQualifiedName().toString());
			Assert.assertEquals(1, Iterables.size(it.getExportedObjects()));
		});
	}

	@Test
	public void testStubGenerationWithNestedTypes_01() throws Exception {
		String model =
				"package my.pack;\n" +
				"public class MyTest {\n" +
				"	class InnerClass {}\n" +
				"	interface InnerInterface {}\n" +
				"	enum InnerEnum {}\n" +
				"	@interface InnerAnnotation {}\n" +
				"}\n";
		resultsIn(model, (IResourceDescription it) -> {
			Assert.assertEquals("my.pack.MyTest", firstExported(it).getQualifiedName().toString());
			Assert.assertEquals(5, Iterables.size(it.getExportedObjects()));
			IEObjectDescription innerClass = Iterables.get(it.getExportedObjects(), 1);
			Assert.assertEquals("my.pack.MyTest.InnerClass", innerClass.getQualifiedName().toString());
			Assert.assertTrue(innerClass.getEObjectOrProxy() instanceof JvmGenericType);
			IEObjectDescription innerInterface = Iterables.get(it.getExportedObjects(), 2);
			Assert.assertEquals("my.pack.MyTest.InnerInterface", innerInterface.getQualifiedName().toString());
			Assert.assertTrue(innerInterface.getEObjectOrProxy() instanceof JvmGenericType);
			IEObjectDescription innerEnum = Iterables.get(it.getExportedObjects(), 3);
			Assert.assertEquals("my.pack.MyTest.InnerEnum", innerEnum.getQualifiedName().toString());
			Assert.assertTrue(innerEnum.getEObjectOrProxy() instanceof JvmEnumerationType);
			IEObjectDescription innerAnnotation = Iterables.get(it.getExportedObjects(), 4);
			Assert.assertEquals("my.pack.MyTest.InnerAnnotation", innerAnnotation.getQualifiedName().toString());
			Assert.assertTrue(innerAnnotation.getEObjectOrProxy() instanceof JvmAnnotationType);
		});
	}

	@Test
	public void testStubGenerationWithTypeParamers_01() throws Exception {
		String model =
				"package my.pack;\n" +
				"public class MyTest<T extends CharSequence> {\n" +
				"	interface InnerInterface<A,B> {\n" +
				"		static class DeepNested<X> {}\n" +
				"	}\n" +
				"}\n";
		resultsIn(model, (IResourceDescription it) -> {
			IEObjectDescription mytest = firstExported(it);
			Assert.assertEquals("my.pack.MyTest", mytest.getQualifiedName().toString());
			Assert.assertEquals("<T>", mytest.getUserData(JvmTypesResourceDescriptionStrategy.TYPE_PARAMETERS));
			IEObjectDescription innerinterface = Iterables.get(it.getExportedObjects(), 1);
			Assert.assertEquals("my.pack.MyTest.InnerInterface", innerinterface.getQualifiedName().toString());
			Assert.assertEquals("<A,B>",
					innerinterface.getUserData(JvmTypesResourceDescriptionStrategy.TYPE_PARAMETERS));
			Assert.assertEquals(Boolean.TRUE.toString(),
					innerinterface.getUserData(JvmTypesResourceDescriptionStrategy.IS_INTERFACE));
			IEObjectDescription deepNested = Iterables.get(it.getExportedObjects(), 2);
			Assert.assertEquals("my.pack.MyTest.InnerInterface.DeepNested", deepNested.getQualifiedName().toString());
			Assert.assertEquals("<X>", deepNested.getUserData(JvmTypesResourceDescriptionStrategy.TYPE_PARAMETERS));
		});
	}

	@Test
	public void testEmptyFile() throws Exception {
		String model = "//package my.pack;";
		resultsIn(model, (IResourceDescription it) -> {
			Assert.assertTrue(Iterables.isEmpty(it.getExportedObjects()));
		});
	}

	protected void resultsIn(CharSequence javaCode, Procedure1<? super IResourceDescription> assertion) throws Exception {
		XtextResourceSet resourceSet = resourceSet(Pair.of("SomeJava.java", javaCode.toString()));
		compilerPhases.setIndexing(resourceSet, true);
		Resource resource = Iterables.getFirst(resourceSet.getResources(), null);
		IResourceDescription description = resourceDesriptionManager.getResourceDescription(resource);
		assertion.apply(description);
	}

	@Inject
	private CompilerPhases compilerPhases;

	@Inject
	private Provider<XtextResourceSet> resourceSetProvider;

	@Inject
	private IResourceDescription.Manager resourceDesriptionManager;

	protected XtextResourceSet resourceSet(Pair<String, String> file) throws Exception {
		XtextResourceSet result = this.resourceSetProvider.get();
		result.getURIConverter().getURIHandlers().clear();
		InMemoryURIHandler uriHandler = new InMemoryURIHandler();
		URI uri = URI.createURI(InMemoryURIHandler.SCHEME + ":/"+ file.getKey());
		try (OutputStream out = uriHandler.createOutputStream(uri,
				Collections.emptyMap())) {
			out.write(file.getValue().getBytes());
		}
		result.getURIConverter().getURIHandlers().add(uriHandler);
			result.getResource(uri, true);
		return result;
	}
}
