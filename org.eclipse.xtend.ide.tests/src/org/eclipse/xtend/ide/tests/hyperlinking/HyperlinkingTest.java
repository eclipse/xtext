/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.hyperlinking;

import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtext.common.types.xtext.ui.JdtHyperlink;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.hyperlinking.IHyperlinkHelper;
import org.eclipse.xtext.ui.editor.hyperlinking.XtextHyperlink;
import org.junit.Test;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class HyperlinkingTest extends AbstractXtendUITestCase {

	@Inject
	private IHyperlinkHelper hyperlinkHelper;

	@Inject
	private WorkbenchTestHelper testHelper;
	
	@Test public void testDispatchMethod() throws Exception {
		String modelAsString = "class Foo {\n"
				+ "  def bar() { foo(new Object()) }\n"
				+ "  def dispatch foo(Object o) { null }\n"
				+ "  def dispatch foo(String s) { null }\n"
				+ "  def dispatch foo(Number n) { null }\n"
				+ "}";
		XtextResource resource = (XtextResource) testHelper.xtendFile("Foo", modelAsString).eResource();
		IHyperlink[] hyperlinks = hyperlinkHelper.createHyperlinksByOffset(resource, modelAsString.indexOf("foo"), true);
		assertEquals(4, hyperlinks.length);
		assertEquals("Open Declaration - foo(Number) : Object", hyperlinks[0].getHyperlinkText());
		assertTrue(((XtextHyperlink)hyperlinks[0]).getURI().isPlatformResource());
		assertEquals("Open Declaration - foo(String) : Object", hyperlinks[1].getHyperlinkText());
		assertTrue(((XtextHyperlink)hyperlinks[1]).getURI().isPlatformResource());
		assertEquals("Open Declaration - foo(Object) : Object", hyperlinks[2].getHyperlinkText());
		assertTrue(((XtextHyperlink)hyperlinks[2]).getURI().isPlatformResource());
		assertEquals("Open Return Type - Object", hyperlinks[3].getHyperlinkText());
		assertEquals("Object", ((JdtHyperlink) hyperlinks[3]).getJavaElement().getElementName());
	}
	
	@Test public void testPlainMethod() throws Exception {
		String modelAsString = "class Foo {\n"
				+ "  def bar() { foo() }\n"
				+ "  def foo() { null }\n"
				+ "}";
		XtextResource resource = (XtextResource) testHelper.xtendFile("Foo", modelAsString).eResource();
		IHyperlink[] hyperlinks = hyperlinkHelper.createHyperlinksByOffset(resource, modelAsString.indexOf("foo"), true);
		assertEquals(2, hyperlinks.length);
		assertEquals("Open Declaration - foo() : Object", hyperlinks[0].getHyperlinkText());
		assertTrue(((XtextHyperlink) hyperlinks[0]).getURI().isPlatformResource());
		assertEquals("Open Return Type - Object", hyperlinks[1].getHyperlinkText());
		assertEquals("Object", ((JdtHyperlink) hyperlinks[1]).getJavaElement().getElementName());
	}
	
	@Test public void testConstructor() throws Exception {
		String modelAsString =
			"class Foo {\n"
			+ "  def bar() { new Foo() }\n"
			+ "}";
		XtextResource resource = (XtextResource) testHelper.xtendFile("Foo", modelAsString).eResource();
		IHyperlink[] hyperlinks = hyperlinkHelper.createHyperlinksByOffset(resource, modelAsString.indexOf("Foo", 10), true);
		assertEquals(1, hyperlinks.length);
		assertEquals("Open Declaration - Foo", hyperlinks[0].getHyperlinkText());
		assertTrue(((XtextHyperlink)hyperlinks[0]).getURI().isPlatformResource());
	}

	@Test public void testSuperClass() throws Exception {
		String modelAsString =
			"class Foo extends Object {\n"
				+ "}";
		XtextResource resource = (XtextResource) testHelper.xtendFile("Foo", modelAsString).eResource();
		IHyperlink[] hyperlinks = hyperlinkHelper.createHyperlinksByOffset(resource, modelAsString.indexOf("Object"), true);
		assertEquals(1, hyperlinks.length);
		assertEquals("Object", hyperlinks[0].getHyperlinkText());
	}
	
	@Test public void testPackageFragment() throws Exception {
		String modelAsString = "class C { val x = java.lang.String }";
		XtextResource resource = (XtextResource) testHelper.xtendFile("C", modelAsString).eResource();
		IHyperlink[] hyperlinks = hyperlinkHelper.createHyperlinksByOffset(resource, modelAsString.indexOf("lang"), true);
		assertEquals(1, hyperlinks.length);
		assertEquals("String", hyperlinks[0].getHyperlinkText());
		assertEquals(modelAsString.indexOf("java"), hyperlinks[0].getHyperlinkRegion().getOffset());
		assertEquals("java.lang.String".length(), hyperlinks[0].getHyperlinkRegion().getLength());
	}
	
	@Test public void testTypeLiteral() throws Exception {
		String modelAsString = "class C { val x = java.lang.String }";
		XtextResource resource = (XtextResource) testHelper.xtendFile("C", modelAsString).eResource();
		IHyperlink[] hyperlinks = hyperlinkHelper.createHyperlinksByOffset(resource, modelAsString.indexOf("String"), true);
		assertEquals(1, hyperlinks.length);
		assertEquals("String", hyperlinks[0].getHyperlinkText());
		assertEquals(modelAsString.indexOf("java"), hyperlinks[0].getHyperlinkRegion().getOffset());
		assertEquals("java.lang.String".length(), hyperlinks[0].getHyperlinkRegion().getLength());
	}
	
	@Test public void testNestedTypePackageFragment() throws Exception {
		String modelAsString = "class C { val x = java.util.Map.Entry }";
		XtextResource resource = (XtextResource) testHelper.xtendFile("C", modelAsString).eResource();
		IHyperlink[] hyperlinks = hyperlinkHelper.createHyperlinksByOffset(resource, modelAsString.indexOf("util"), true);
		assertEquals(1, hyperlinks.length);
		assertEquals("Map<K, V>", hyperlinks[0].getHyperlinkText());
		assertEquals(modelAsString.indexOf("java"), hyperlinks[0].getHyperlinkRegion().getOffset());
		assertEquals("java.util.Map".length(), hyperlinks[0].getHyperlinkRegion().getLength());
	}
	
	@Test public void testOuterTypeLiteral() throws Exception {
		String modelAsString = "class C { val x = java.util.Map.Entry }";
		XtextResource resource = (XtextResource) testHelper.xtendFile("C", modelAsString).eResource();
		IHyperlink[] hyperlinks = hyperlinkHelper.createHyperlinksByOffset(resource, modelAsString.indexOf("Map"), true);
		assertEquals(1, hyperlinks.length);
		assertEquals("Map<K, V>", hyperlinks[0].getHyperlinkText());
		assertEquals(modelAsString.indexOf("java"), hyperlinks[0].getHyperlinkRegion().getOffset());
		assertEquals("java.util.Map".length(), hyperlinks[0].getHyperlinkRegion().getLength());
	}
	
	@Test public void testOuterTypeLiteralWithDollar() throws Exception {
		String modelAsString = "class C { val x = java.util.Map$Entry }";
		XtextResource resource = (XtextResource) testHelper.xtendFile("C", modelAsString).eResource();
		IHyperlink[] hyperlinks = hyperlinkHelper.createHyperlinksByOffset(resource, modelAsString.indexOf("Map"), true);
		assertEquals(1, hyperlinks.length);
		assertEquals("Entry<K, V>", hyperlinks[0].getHyperlinkText());
		assertEquals(modelAsString.indexOf("java"), hyperlinks[0].getHyperlinkRegion().getOffset());
		assertEquals("java.util.Map$Entry".length(), hyperlinks[0].getHyperlinkRegion().getLength());
	}
	
	@Test public void testNestedTypeLiteral() throws Exception {
		String modelAsString = "class C { val x = java.util.Map.Entry }";
		XtextResource resource = (XtextResource) testHelper.xtendFile("C", modelAsString).eResource();
		IHyperlink[] hyperlinks = hyperlinkHelper.createHyperlinksByOffset(resource, modelAsString.indexOf("Entry"), true);
		assertEquals(1, hyperlinks.length);
		assertEquals("Entry<K, V>", hyperlinks[0].getHyperlinkText());
		assertEquals(modelAsString.indexOf("Entry"), hyperlinks[0].getHyperlinkRegion().getOffset());
		assertEquals("Entry".length(), hyperlinks[0].getHyperlinkRegion().getLength());
	}
	
	@Test public void testNestedTypeLiteralWithDollar() throws Exception {
		String modelAsString = "class C { val x = java.util.Map$Entry }";
		XtextResource resource = (XtextResource) testHelper.xtendFile("C", modelAsString).eResource();
		IHyperlink[] hyperlinks = hyperlinkHelper.createHyperlinksByOffset(resource, modelAsString.indexOf("Entry"), true);
		assertEquals(1, hyperlinks.length);
		assertEquals("Entry<K, V>", hyperlinks[0].getHyperlinkText());
		assertEquals(modelAsString.indexOf("java"), hyperlinks[0].getHyperlinkRegion().getOffset());
		assertEquals("java.util.Map$Entry".length(), hyperlinks[0].getHyperlinkRegion().getLength());
	}

	@Test public void testStaticFeatureCall() throws Exception {
		String modelAsString = "class C { val x = java.lang.String.valueOf('') }";
		XtextResource resource = (XtextResource) testHelper.xtendFile("C", modelAsString).eResource();
		IHyperlink[] hyperlinks = hyperlinkHelper.createHyperlinksByOffset(resource, modelAsString.indexOf("lang"), true);
		assertEquals(1, hyperlinks.length);
		assertEquals("String", hyperlinks[0].getHyperlinkText());
		assertEquals(modelAsString.indexOf("java"), hyperlinks[0].getHyperlinkRegion().getOffset());
		assertEquals("java.lang.String".length(), hyperlinks[0].getHyperlinkRegion().getLength());
	}
	
	@Test public void testStaticFeatureCallWithColon() throws Exception {
		String modelAsString = "class C { val x = java.lang.String::valueOf('') }";
		XtextResource resource = (XtextResource) testHelper.xtendFile("C", modelAsString).eResource();
		IHyperlink[] hyperlinks = hyperlinkHelper.createHyperlinksByOffset(resource, modelAsString.indexOf("lang"), true);
		assertEquals(1, hyperlinks.length);
		assertEquals("String", hyperlinks[0].getHyperlinkText());
		assertEquals(modelAsString.indexOf("java"), hyperlinks[0].getHyperlinkRegion().getOffset());
		assertEquals("java.lang.String".length(), hyperlinks[0].getHyperlinkRegion().getLength());
	}
	
	@Test public void testStaticFeatureCallWithAllColon() throws Exception {
		String modelAsString = "class C { val x = java::lang::String::valueOf('') }";
		XtextResource resource = (XtextResource) testHelper.xtendFile("C", modelAsString).eResource();
		IHyperlink[] hyperlinks = hyperlinkHelper.createHyperlinksByOffset(resource, modelAsString.indexOf("lang"), true);
		assertEquals(1, hyperlinks.length);
		assertEquals("String", hyperlinks[0].getHyperlinkText());
		assertEquals(modelAsString.indexOf("java"), hyperlinks[0].getHyperlinkRegion().getOffset());
		assertEquals("java::lang::String".length(), hyperlinks[0].getHyperlinkRegion().getLength());
	}
	
	@Test public void testReturnTypeLabel() throws Exception {
		String modelAsString = "class Baz {def Baz meth(Baz baz, String str) { var vv='' x = baz j = str vv=j x.meth(baz,str) } var x = new Baz var j = '' }";
		XtextResource resource = (XtextResource) testHelper.xtendFile("Baz", modelAsString).eResource();
		int indexOf_x_FieldRef = modelAsString.indexOf("x");
		IHyperlink[] hyperlinks = hyperlinkHelper.createHyperlinksByOffset(resource, indexOf_x_FieldRef, true);
		assertEquals(2, hyperlinks.length);
		assertEquals("Open Declaration - x : Baz", hyperlinks[0].getHyperlinkText());
		assertEquals("Open Field Type - Baz", hyperlinks[1].getHyperlinkText());
		
		int indexOf_Baz_ParamRef = modelAsString.indexOf("baz", indexOf_x_FieldRef);
		hyperlinks = hyperlinkHelper.createHyperlinksByOffset(resource, indexOf_Baz_ParamRef, true);
		assertEquals(2, hyperlinks.length);
		assertEquals("Open Declaration - Baz baz", hyperlinks[0].getHyperlinkText());
		assertEquals("Open Parameter Type - Baz", hyperlinks[1].getHyperlinkText());
		
		int indexOf_j_FieldRef = modelAsString.indexOf("j", indexOf_Baz_ParamRef);
		hyperlinks = hyperlinkHelper.createHyperlinksByOffset(resource, indexOf_j_FieldRef, true);
		assertEquals(2, hyperlinks.length);
		assertEquals("Open Declaration - j : String", hyperlinks[0].getHyperlinkText());
		assertEquals("Open Field Type - String", hyperlinks[1].getHyperlinkText());
		assertEquals("String", ((JdtHyperlink) hyperlinks[1]).getJavaElement().getElementName());

		int indexOf_vv_VarRef = modelAsString.indexOf("vv", indexOf_j_FieldRef);
		hyperlinks = hyperlinkHelper.createHyperlinksByOffset(resource, indexOf_vv_VarRef, true);
		assertEquals(2, hyperlinks.length);
		assertEquals("Open Declaration - String vv", hyperlinks[0].getHyperlinkText());
		assertEquals("Open Variable Type - String", hyperlinks[1].getHyperlinkText());
		
		int indexOf_meth_MethodeCall = modelAsString.indexOf("meth", indexOf_vv_VarRef);
		hyperlinks = hyperlinkHelper.createHyperlinksByOffset(resource, indexOf_meth_MethodeCall, true);
		assertEquals(2, hyperlinks.length);
		assertEquals("Open Declaration - meth(Baz, String) : Baz", hyperlinks[0].getHyperlinkText());
		assertEquals("Open Return Type - Baz", hyperlinks[1].getHyperlinkText());
	}
	
	@Test public void testOpenInferredType() throws Exception {
		String modelAsString = "class Baz { def void foo() { var myVar='' println(myVar) } }";
		XtextResource resource = (XtextResource) testHelper.xtendFile("Baz", modelAsString).eResource();
		int indexOf_x_FieldRef = modelAsString.indexOf("myVar");
		IHyperlink[] hyperlinks = hyperlinkHelper.createHyperlinksByOffset(resource, indexOf_x_FieldRef, true);
		assertEquals(1, hyperlinks.length);
		assertEquals("Open Inferred Type - String", hyperlinks[0].getHyperlinkText());
	}
	
	// see https://bugs.eclipse.org/bugs/show_bug.cgi?id=463247
	@Test public void testOpenInferredType_on_any() throws Exception {
		String modelAsString = "class Baz { def void foo() { var myVar=null println(myVar) } }";
		XtextResource resource = (XtextResource) testHelper.xtendFile("Baz", modelAsString).eResource();
		int indexOf_x_FieldRef = modelAsString.indexOf("myVar");
		IHyperlink[] hyperlinks = hyperlinkHelper.createHyperlinksByOffset(resource, indexOf_x_FieldRef, true);
		assertNull(hyperlinks);
	}
	
	@Test public void testOpenInferredTypeOnReference() throws Exception {
		String modelAsString = "class Baz { def void foo() { var myVar='' println(myVar) } }";
		XtextResource resource = (XtextResource) testHelper.xtendFile("Baz", modelAsString).eResource();
		int indexOf_x_FieldRef = modelAsString.indexOf("myVar)");
		IHyperlink[] hyperlinks = hyperlinkHelper.createHyperlinksByOffset(resource, indexOf_x_FieldRef, true);
		assertEquals(2, hyperlinks.length);
		assertEquals("Open Declaration - String myVar", hyperlinks[0].getHyperlinkText());
		assertEquals("Open Variable Type - String", hyperlinks[1].getHyperlinkText());
	}	
	
	@Test public void testOpenInferredType_01() throws Exception {
		String modelAsString = "class Baz { def void foo() { for (myVar : #[1,2,3]) { println(myVar) } } }";
		XtextResource resource = (XtextResource) testHelper.xtendFile("Baz", modelAsString).eResource();
		int indexOf_x_FieldRef = modelAsString.indexOf("myVar");
		IHyperlink[] hyperlinks = hyperlinkHelper.createHyperlinksByOffset(resource, indexOf_x_FieldRef, true);
		assertEquals(1, hyperlinks.length);
		assertEquals("Open Inferred Type - Integer", hyperlinks[0].getHyperlinkText());
	}
	
	@Test public void testOpenInferredTypeOnReference_01() throws Exception {
		String modelAsString = "class Baz { def void foo() { for (myVar : #[1,2,3]) { println(myVar) } } }";
		XtextResource resource = (XtextResource) testHelper.xtendFile("Baz", modelAsString).eResource();
		int indexOf_x_FieldRef = modelAsString.indexOf("myVar)");
		IHyperlink[] hyperlinks = hyperlinkHelper.createHyperlinksByOffset(resource, indexOf_x_FieldRef, true);
		assertEquals(2, hyperlinks.length);
		assertEquals("Open Declaration - myVar", hyperlinks[0].getHyperlinkText());
		assertEquals("Open Variable Type - Integer", hyperlinks[1].getHyperlinkText());
	}	
	
	@Test public void testOpenInferredType_02() throws Exception {
		IHyperlink[] hyperlinks = getHyperLinks("class Baz { def void foo() { switch my|Var : #[1,2,3] { default : {} } } }");
		assertEquals(1, hyperlinks.length);
		assertEquals("Open Inferred Type - List<Integer>", hyperlinks[0].getHyperlinkText());
	}
	
	@Test public void testOpenInferredType_03() throws Exception {
		IHyperlink[] hyperlinks = getHyperLinks("class Baz { val f|oo='' }");
		assertEquals(1, hyperlinks.length);
		assertEquals("Open Inferred Type - String", hyperlinks[0].getHyperlinkText());
	}
	
	@Test public void testOpenInferredType_04() throws Exception {
		IHyperlink[] hyperlinks = getHyperLinks("class Baz { def f|oo(){ 'foo' } }");
		assertEquals(1, hyperlinks.length);
		assertEquals("Open Inferred Type - String", hyperlinks[0].getHyperlinkText());
	}
	
	@Test public void testOpenInferredType_05() throws Exception {
		IHyperlink[] hyperlinks = getHyperLinks("class Baz { def String f|oo(){ 'foo' } }");
		assertNull(hyperlinks);
	}
	
	@Test 
	public void testBug_454412() throws Exception {
		IHyperlink[] hyperlinks = getHyperLinks("class Baz { def QWERTZ foo(String param ){ 'Foo' } def bar(){ fo|o(variable) } }");
		assertEquals(1, hyperlinks.length);
		assertEquals("Open Declaration - foo(String) : QWERTZ", hyperlinks[0].getHyperlinkText());
	}
	protected IHyperlink[] getHyperLinks(String modelAsString) throws Exception {
		XtextResource resource = (XtextResource) testHelper.xtendFile("MyFile", modelAsString.replace("|", "")).eResource();
		int indexOf_x_FieldRef = modelAsString.indexOf("|");
		return hyperlinkHelper.createHyperlinksByOffset(resource, indexOf_x_FieldRef, true);
	}
}
