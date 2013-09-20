/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.resource;

import static org.eclipse.xtext.util.Strings.*;

import java.util.Iterator;

import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.descriptions.JvmDeclaredTypeSignatureHashProvider;
import org.junit.Test;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class TypeSignatureHashTest extends AbstractXtendTestCase {

	@Inject
	private IXtendJvmAssociations associations;
	
	@Inject
	private Provider<JvmDeclaredTypeSignatureHashProvider.SignatureHashBuilder> signatureBuilderProvider;
	
	@Test
	public void testClassSignatureChange() throws Exception {
		assertSameSignature(
				"package test class Foo {}", 
				"package test class Foo {}");
		assertSameSignature(
				"package test class Foo {}", 
				"package test class Foo extends Object {}");
		assertDifferentSignature(
				"package test class Foo implements java.io.Serializable, Cloneable {}", 
				"package test class Foo implements Cloneable, java.io.Serializable {}");
		assertDifferentSignature(
				"package test class Foo {}", 
				"package test class Foo<T> {}");
		assertDifferentSignature(
				"package test class Foo {}", 
				"package test class Foo implements java.io.Serializable {}");
		assertSameSignature(
				"package test @SuppressWarnings('all') class Foo {}",
				"package test class Foo {}");
		assertDifferentSignature(
				"package test class Foo {}",
				"package test @Deprecated class Foo {}");
	}

	@Test
	public void testFieldSignatureChange() throws Exception {
		assertSameSignature(
				"package test class Foo { String bar }", 
				"package test class Foo { String bar }");
		assertSameSignature(
				"package test class Foo { private String bar }",
				"package test class Foo { private int bar }");
		assertDifferentSignature(
				"package test class Foo { public String bar public String baz }",
				"package test class Foo { public String baz public String bar }");
		assertDifferentSignature(
				"package test class Foo { public String bar }",
				"package test class Foo { public String baz }");
		assertDifferentSignature(
				"package test class Foo { String bar }",
				"package test class Foo { public String bar }");
		assertDifferentSignature(
				"package test class Foo { public String bar }",
				"package test class Foo { public static String bar }");
		assertSameSignature(
				"package test class Foo { @SuppressWarnings('all') public String foo }",
				"package test class Foo { public String foo }");
		assertDifferentSignature(
				"package test class Foo { public String foo }",
				"package test class Foo { @Deprecated public String foo }");

	}

	@Test
	public void testConstructorSignatureChange() throws Exception {
		assertSameSignature(
				"package test class Foo { new() {} }", 
				"package test class Foo { new() {} }");
		assertSameSignature(
				"package test class Foo { new() {} }",
				"package test class Foo { new() { return } }");
		assertSameSignature(
				"package test class Foo { new(String bar) {} }",
				"package test class Foo { new(String baz) {} }");
		assertDifferentSignature(
				"package test class Foo { new(String bar) {} }",
				"package test class Foo { new(int bar) {} }");
		assertDifferentSignature(
				"package test class Foo { new(String bar) {} }",
				"package test class Foo { private new(String bar) {} }");
		assertDifferentSignature(
				"package test class Foo { new(String bar) {} }",
				"package test class Foo { new(String bar) throws Exception { throw new Exception() } }");
		assertDifferentSignature(
				"package test class Foo { new <T> () {} }",
				"package test class Foo { new() {} }");
		assertSameSignature(
				"package test class Foo { @SuppressWarnings('all') new() {} }",
				"package test class Foo { new() {} }");
		assertDifferentSignature(
				"package test class Foo { new() {} }",
				"package test class Foo { @Deprecated new() {} }");
	}

	@Test
	public void testMethodSignatureChange() throws Exception {
		assertSameSignature(
				"package test class Foo { def void foo() {} }",
				"package test class Foo { def void foo() {} }");
		assertSameSignature(
				"package test class Foo { def void foo() {} }",
				"package test class Foo { def void foo() { retrun } }");
		assertDifferentSignature(
				"package test class Foo { def void foo() {} }",
				"package test class Foo { def void bar() {} }");
		assertDifferentSignature(
				"package test class Foo { def String foo() { '' } }",
				"package test class Foo { def CharSequence foo() { '' } }");
		assertDifferentSignature(
				"package test class Foo { def void foo() {} }",
				"package test class Foo { def private void foo() {} }");
		assertDifferentSignature(
				"package test class Foo { def void foo() {} }",
				"package test class Foo { def static void foo() {} }");
		assertDifferentSignature(
				"package test class Foo { def void foo(String x) {} }",
				"package test class Foo { def void foo(int x) {} }");
		assertDifferentSignature(
				"package test class Foo { def void foo() {} }",
				"package test class Foo { def void foo() throws Exception { throw new Exception() } }");
		assertDifferentSignature(
				"package test class Foo { def void foo() {} }",
				"package test class Foo { def <T> void foo() {} }");
		assertSameSignature(
				"package test class Foo { @SuppressWarnings('all') def void foo() {} }",
				"package test class Foo { def void foo() {} }");
		assertDifferentSignature(
				"package test class Foo { def void foo() {} }",
				"package test class Foo { @Deprecated def foo() {} }");
	}
	
	@Test
	public void testSuperSignatureChanges() throws Exception {
		Iterator<XtendFile> files0 = files(true, 
				"package test class Bar { def foo() {} }",
				"package test class Foo extends Bar {}").iterator();
		XtendFile barFile0 = files0.next();
		XtendFile fooFile0 = files0.next();
		Iterator<XtendFile> files1 = files(true, 
				"package test class Bar { def foo() { bar() } def private bar() {} }", 
				"package test class Foo extends Bar {}").iterator();
		XtendFile barFile1 = files1.next();
		XtendFile fooFile1 = files1.next();
		assertEquals(getTypeSignature(barFile0), getTypeSignature(barFile1));
		assertEquals(getTypeSignature(fooFile0), getTypeSignature(fooFile1));
		
		Iterator<XtendFile> files2 = files(true, 
				"package test class Bar { def foo(int x) {} }", 
				"package test class Foo extends Bar {}").iterator();
		XtendFile barFile2 = files2.next();
		XtendFile fooFile2 = files2.next();
		assertFalse(equal(getTypeSignature(barFile0), getTypeSignature(barFile2)));
		assertFalse(equal(getTypeSignature(fooFile0), getTypeSignature(fooFile2)));
	}

	@Test
	public void testTypeRecursion() throws Exception {
		getSignature("package test class Foo implements Comparable<Foo> { def compareTo(Foo x) { 0 } }");
	}
	
	@Test
	public void testInheritanceRecursion() throws Exception {
		getSignature("package test class Foo extends Foo {}");
	}
	
	@Test 
	public void testInheritanceCycles() throws Exception {
		getSignature("package test class Foo extends Bar {} class Bar extends Foo {}");
	}
	
	protected void assertSameSignature(String model0, String model1) throws Exception {
		assertEquals(getSignature(model0), getSignature(model1));
	}

	protected void assertDifferentSignature(String model0, String model1) throws Exception {
		String signature = getSignature(model0);
		assertFalse("Expected different signatures but got:\n" + signature, equal(signature,getSignature(model1)));
	}
	
	protected String getSignature(String model) throws Exception {
		XtendFile file = file(model);
		return getTypeSignature(file);
	}

	protected String getTypeSignature(XtendFile file) {
		JvmGenericType inferredType = associations.getInferredType((XtendClass) file.getXtendTypes().get(0));
		return signatureBuilderProvider.get().appendSignature(inferredType).hash();
	}
}
