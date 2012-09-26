/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.formatting;

import org.eclipse.xtend.core.formatting.OrganizeImports;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.TextRegion;
import org.junit.Test;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class OrganizeImportsTest extends AbstractXtendTestCase {
	
	@Inject
	private OrganizeImports organizeImports;
	
	@Test public void testGetOrganizedImportSection_01() throws Exception {
		String model = 
				"import java.lang.String\n" +
				"import java.util.List\n" +
				"\n" +
				"class Foo {\n" +
				"  def void test(List<String> s) {\n" +
				"  }\n" +
				"}\n";
		XtendFile file = file(model,true);
		String section = organizeImports.getOrganizedImportSection((XtextResource) file.eResource());
		
		assertEquals(
				"\n" +
				"\nimport java.util.List", section);
	}
	
	@Test public void testGetOrganizedImportSection_02() throws Exception {
		String model = 
				"import java.lang.String\n" +
				"import java.util.List\n" +
				"import java.util.List\n" +
				"import java.util.List\n" +
				"import java.lang.Integer\n" +
				"\n" +
				"class Foo {\n" +
				"  def void test(List<String> s) {\n" +
				"  }\n" +
				"}\n";
		XtendFile file = file(model,false);
		String section = organizeImports.getOrganizedImportSection((XtextResource) file.eResource());
		
		assertEquals(
				"\n" +
				"\nimport java.util.List", section);
	}
	
	@Test public void testGetOrganizedImportSection_03() throws Exception {
		String model = 
				"import java.util.*\n" +
				"\n" +
				"class Foo {\n" +
				"  def void test(List<String> s) {\n" +
				"    val x = newArrayList('foo','bar')\n" +
				"    Collections::sort(x)\n" +
				"  }\n" +
				"}\n";
		XtendFile file = file(model,false);
		String section = organizeImports.getOrganizedImportSection((XtextResource) file.eResource());
		
		assertEquals(
				"\n" +
				"\nimport java.util.Collections" +
				"\nimport java.util.List", section);
	}
	
	@Test public void testGetOrganizedImportSection_04() throws Exception {
		String model = 
				"import java.util.*\n" +
				"import java.io.*\n" +
				"\n" +
				"class Foo {\n" +
				"  def void test(List<String> s) {\n" +
				"    val x = new ArrayList<Map<StringBuilder,? extends Serializable>>()\n" +
				"  }\n" +
				"}\n";
		XtendFile file = file(model,false);
		String section = organizeImports.getOrganizedImportSection((XtextResource) file.eResource());
		
		assertEquals(
				"\n" +
				"\nimport java.io.Serializable" + 
				"\nimport java.util.ArrayList" + 
				"\nimport java.util.List" + 
				"\nimport java.util.Map", section);
	}
	
	@Test public void testGetOrganizedImportSection_05() throws Exception {
		String model = 
				"import java.util.*\n" +
				"import java.io.*\n" +
				"import com.google.inject.Inject\n" +
				"" +
				"\n" +
				"class Foo {\n" +
				"  @Inject String s\n" +
				"  def void test(List<String> s) {\n" +
				"    val x = new ArrayList<Map<StringBuilder,? extends Serializable>>()\n" +
				"  }\n" +
				"}\n";
		XtendFile file = file(model,false);
		String section = organizeImports.getOrganizedImportSection((XtextResource) file.eResource());
		
		assertEquals(
				"\n" +
				"\nimport com.google.inject.Inject" + 
				"\nimport java.io.Serializable" + 
				"\nimport java.util.ArrayList" + 
				"\nimport java.util.List" + 
				"\nimport java.util.Map", section);
	}
	
	@Test public void testGetOrganizedImportSectionWithInnerClasses_01() throws Exception {
		String model = 
						"class Foo {\n" +
						"  def void test(org.eclipse.emf.ecore.resource.Resource$Factory a, org.eclipse.emf.ecore.resource.Resource$Factory$Registry b) {\n" +
						"  }\n" +
						"}\n";
		XtendFile file = file(model,true);
		String section = organizeImports.getOrganizedImportSection((XtextResource) file.eResource());
		
		assertEquals(
				"\n" +
				"\nimport org.eclipse.emf.ecore.resource.Resource", section);
	}
	
	@Test public void testGetOrganizedImportSectionWithInnerClasses_02() throws Exception {
		String model = 
				"import org.eclipse.emf.ecore.resource.Resource\n" +
				"import org.eclipse.emf.ecore.EPackage\n" +
				"" +
				"\n" +
				"class Foo {\n" +
				"  def test() {\n" +
				"    val x = Resource$Factory$Registry::INSTANCE\n" +
				"    val y = EPackage$Registry::INSTANCE\n" +
				"  }\n" +
				"}\n";
		XtendFile file = file(model,true);
		String section = organizeImports.getOrganizedImportSection((XtextResource) file.eResource());
		
		assertEquals(
				"\n" +
				"\nimport org.eclipse.emf.ecore.EPackage" + 
				"\nimport org.eclipse.emf.ecore.resource.Resource", section);
	}
	
	@Test public void testGetOrganizedImportSectionWithInnerClasses_03() throws Exception {
		String model = 
				"class Foo {\n" +
				"  def test() {" +
				"	 typeof(org.eclipse.emf.ecore.resource.Resource$Factory) == typeof(org.eclipse.emf.ecore.resource.Resource$Factory$Registry)"+
				"  }\n" +
				"}\n";
		XtendFile file = file(model,true);
		String section = organizeImports.getOrganizedImportSection((XtextResource) file.eResource());
		
		assertEquals(
				"\n" +
				"\nimport org.eclipse.emf.ecore.resource.Resource", section);
	}
	
	@Test public void testGetOrganizedImportSectionWithInnerClasses_04() throws Exception {
		String model = 
				"import org.eclipse.emf.ecore.resource.Resource\n" +
				"import org.eclipse.emf.ecore.EPackage\n" +
				"" +
				"\n" +
				"class Foo {\n" +
				"  def test() {\n" +
				"    typeof(Resource$Factory$Registry) == typeof(EPackage$Registry)" +
				"  }\n" +
				"}\n";
		XtendFile file = file(model,true);
		String section = organizeImports.getOrganizedImportSection((XtextResource) file.eResource());
		
		assertEquals(
				"\n" +
				"\nimport org.eclipse.emf.ecore.EPackage" + 
				"\nimport org.eclipse.emf.ecore.resource.Resource", section);
	}
	
	@Test public void testGetOrganizedImportSectionWithInnerClasses_05() throws Exception {
		String model = 
				"import org.eclipse.emf.ecore.resource.Resource$Factory$Registry\n" +
				"" +
				"\n" +
				"class Foo {\n" +
				"  def test() {\n" +
				"    typeof(Registry)" +
				"  }\n" +
				"}\n";
		XtendFile file = file(model,true);
		String section = organizeImports.getOrganizedImportSection((XtextResource) file.eResource());
		
		assertEquals(
				"\n" +
				"\nimport org.eclipse.emf.ecore.resource.Resource$Factory$Registry", section);
	}
	
	@Test public void testGetOrganizedImportSectionWithNameClash_01() throws Exception {
		String model = 
				"\n" +
				"class Foo {\n" +
				"  def java.awt.List test(java.util.List<String> s) {\n" +
				"    return null\n" +
				"  }\n" +
				"}\n";
		XtendFile file = file(model,true);
		String section = organizeImports.getOrganizedImportSection((XtextResource) file.eResource());
		
		assertEquals(
				"\n" +
				"\nimport java.awt.List", section);
	}
	
	@Test public void testGetOrganizedImportSectionWithNameClash_02() throws Exception {
		String model = 
				"\n" +
				"class Foo {\n" +
				"  def java.util.List<String> test(java.awt.List s) {\n" +
				"    return null\n" +
				"  }\n" +
				"}\n";
		XtendFile file = file(model,true);
		String section = organizeImports.getOrganizedImportSection((XtextResource) file.eResource());
		
		assertEquals(
				"\n" +
				"\nimport java.util.List", section);
	}
	
	@Test public void testGetOrganizedImportSectionWithNameClash_03() throws Exception {
		String model = 
				"import org.eclipse.xtext.xbase.XbasePackage\n" +
				"import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsPackage\n" +
				"\n" +
				"class Foo {\n" +
				"  def void test(XbasePackage$Literals x, XAnnotationsPackage$Literals y) {\n" +
				"  }\n" +
				"}\n";
		XtendFile file = file(model,true);
		String section = organizeImports.getOrganizedImportSection((XtextResource) file.eResource());
		
		assertEquals(
				"\n" +
				"\nimport org.eclipse.xtext.xbase.XbasePackage" +
				"\nimport org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsPackage", section);
	}
	
	@Test public void testGetOrganizedImportSectionWithNameClash_04() throws Exception {
		String model = 
				"import org.eclipse.xtext.xbase.XbasePackage$Literals\n" +
				"import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsPackage\n" +
				"\n" +
				"class Foo {\n" +
				"  def void test(Literals x, XAnnotationsPackage$Literals y) {\n" +
				"  }\n" +
				"}\n";
		XtendFile file = file(model,true);
		String section = organizeImports.getOrganizedImportSection((XtextResource) file.eResource());
		
		assertEquals(
				"\n" +
				"\nimport org.eclipse.xtext.xbase.XbasePackage$Literals" +
				"\nimport org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsPackage", section);
	}
	
	@Test public void testGetOrganizedImportSectionWithStaticImport_01() throws Exception {
		String model = 
				"import static extension java.util.Collections.* \n" +
				"class Foo {\n" +
				"  def void test(java.util.List<String> s) {\n" +
				"  sort(s)\n" +
				"  }\n" +
				"}\n";
		XtendFile file = file(model,true);
		String section = organizeImports.getOrganizedImportSection((XtextResource) file.eResource());
		
		assertEquals(
				"\n" +
				"\nimport java.util.List" +
				"\n" +
				"\nimport static java.util.Collections.*", section);
	}
	
	@Test public void testGetOrganizedImportSectionWithStaticImport_02() throws Exception {
		String model = 
				"import static extension java.util.Collections.* \n" +
						"class Foo {\n" +
						"  def void test(java.util.List<String> s) {\n" +
						"  s.sort\n" +
						"  }\n" +
						"}\n";
		XtendFile file = file(model,true);
		String section = organizeImports.getOrganizedImportSection((XtextResource) file.eResource());
		
		assertEquals(
				"\n" +
				"\nimport java.util.List" +
				"\n" +
				"\nimport static extension java.util.Collections.*", section);
	}
	
	@Test public void testImportedOperators_01() throws Exception {
		String model = 
				"import static extension test.StaticOperators.* \n" +
				"class Foo {\n" +
				"  def void test(String s) {\n" +
				"    -s\n" +
				"  }\n" +
				"}\n";
		XtendFile file = file(model,true);
		String section = organizeImports.getOrganizedImportSection((XtextResource) file.eResource());
		
		assertEquals(
				"\n" +
				"\nimport static extension test.StaticOperators.*", section);
	}
	
	@Test public void testImportedOperators_02() throws Exception {
		String model = 
				"import static extension test.StaticOperators.* \n" +
				"class Foo {\n" +
				"  def void test(String s) {\n" +
				"    s-s\n" +
				"  }\n" +
				"}\n";
		XtendFile file = file(model,true);
		String section = organizeImports.getOrganizedImportSection((XtextResource) file.eResource());
		
		assertEquals(
				"\n" +
				"\nimport static extension test.StaticOperators.*", section);
	}
	
	@Test public void testImportedOperators_03() throws Exception {
		String model = 
				"import static extension test.StaticOperators.* \n" +
				"class Foo {\n" +
				"  def void test(String s) {\n" +
				"    s.assign = s\n" +
				"  }\n" +
				"}\n";
		XtendFile file = file(model,true);
		String section = organizeImports.getOrganizedImportSection((XtextResource) file.eResource());
		
		assertEquals(
				"\n" +
				"\nimport static extension test.StaticOperators.*", section);
	}
	
	@Test public void testImportedOperators_04() throws Exception {
		String model = 
				"import static extension test.StaticOperators.* \n" +
				"class Foo {\n" +
				"  def void test(String it) {\n" +
				"    assign = it\n" +
				"  }\n" +
				"}\n";
		XtendFile file = file(model,true);
		String section = organizeImports.getOrganizedImportSection((XtextResource) file.eResource());
		
		assertEquals(
				"\n" +
				"\nimport static extension test.StaticOperators.*", section);
	}
	
	@Test public void testGetOrganizedImportSectionWithImplicitExtensions() throws Exception {
		String model = 
						"class Foo {\n" +
						"  def void test(java.util.List<String> s) {\n" +
						"    s.head\n" +
						"  }\n" +
						"}\n";
		XtendFile file = file(model,true);
		String section = organizeImports.getOrganizedImportSection((XtextResource) file.eResource());
		
		assertEquals(
				"\n" +
				"\nimport java.util.List", section);
	}

	
	@Test public void testGetRegion_01() throws Exception {
		String model = 
				"class Foo {\n" +
				"  def void test() {\n" +
				"  }\n" +
				"}\n";
		XtendFile file = file(model, true);
		TextRegion region = organizeImports.computeRegion((XtextResource) file.eResource());
		assertEquals(0, region.getOffset());
		assertEquals(0, region.getLength());
	}
	
	@Test public void testGetRegion_02() throws Exception {
		String model = 
				"package foo.bar class Foo {\n" +
				"  def void test() {\n" +
				"  }\n" +
				"}\n";
		XtendFile file = file(model, true);
		TextRegion region = organizeImports.computeRegion((XtextResource) file.eResource());
		assertEquals(15, region.getOffset());
		assertEquals(0, region.getLength());
	}
	
	@Test public void testGetRegion_03() throws Exception {
		String model = 
				"package foo.bar\n" +
				"import java.util.*\n" +
				"/* foo \n" +
				"*/\n" +
				"class Foo {\n" +
				"  def void test() {\n" +
				"  }\n" +
				"}\n";
		XtendFile file = file(model, false);
		TextRegion region = organizeImports.computeRegion((XtextResource) file.eResource());
		assertEquals(15, region.getOffset());
		assertEquals(19, region.getLength());
	}
	
	@Test public void testInnerClassImport_01() throws Exception {
		String model = 
				"package foo.bar\n" +
				"import java.util.Map$Entry\n" +
				"class Foo {\n" +
				"  def Entry test() {" +
				"    return null\n" +
				"  }\n" +
				"}\n";
		XtendFile file = file(model, true);
		String section = organizeImports.getOrganizedImportSection((XtextResource) file.eResource());
		
		assertEquals(
				"\n" +
				"\nimport java.util.Map$Entry", section);
	}
	
	@Test public void testInnerClassImport_02() throws Exception {
		String model = 
				"package foo.bar\n" +
				"import java.util.Map\n" +
				"class Foo {\n" +
				"  def Map$Entry test() {" +
				"    return null\n" +
				"  }\n" +
				"}\n";
		XtendFile file = file(model, true);
		String section = organizeImports.getOrganizedImportSection((XtextResource) file.eResource());
		
		assertEquals(
				"\n" +
				"\nimport java.util.Map", section);
	}
	
	@Test public void testInnerClassImport_03() throws Exception {
		String model = 
				"package foo.bar\n" +
				"import java.util.Map$Entry\n" +
				"class Foo {\n" +
				"  def Map$Entry test() {" +
				"    return null\n" +
				"  }\n" +
				"}\n";
		XtendFile file = file(model, true);
		String section = organizeImports.getOrganizedImportSection((XtextResource) file.eResource());
		
		assertEquals(
				"\n" +
				"\nimport java.util.Map", section);
	}

	@Test public void testInnerClassImport_04() throws Exception {
		String model = 
				"package foo.bar\n" +
				"import org.eclipse.emf.ecore.resource.Resource\n" +
				"class Foo {\n" +
				"  def Resource$Factory$Descriptor test() {" +
				"    return null\n" +
				"  }\n" +
				"}\n";
		XtendFile file = file(model, true);
		String section = organizeImports.getOrganizedImportSection((XtextResource) file.eResource());
		
		assertEquals(
				"\n" +
				"\nimport org.eclipse.emf.ecore.resource.Resource", section);
	}
	
	@Test public void testInnerClassImport_05() throws Exception {
		String model = 
				"package foo.bar\n" +
				"import org.eclipse.emf.ecore.resource.Resource$Factory$Descriptor\n" +
				"class Foo {\n" +
				"  def Resource$Factory$Descriptor test() {" +
				"    return null\n" +
				"  }\n" +
				"}\n";
		XtendFile file = file(model, true);
		String section = organizeImports.getOrganizedImportSection((XtextResource) file.eResource());
		
		assertEquals(
				"\n" +
				"\nimport org.eclipse.emf.ecore.resource.Resource", section);
	}
	
	@Test public void testInnerClassImport_06() throws Exception {
		String model = 
				"package foo.bar\n" +
				"import org.eclipse.emf.ecore.resource.Resource$Factory$Descriptor\n" +
				"class Foo {\n" +
				"  def Descriptor test() {" +
				"    return null\n" +
				"  }\n" +
				"}\n";
		XtendFile file = file(model, true);
		String section = organizeImports.getOrganizedImportSection((XtextResource) file.eResource());
		
		assertEquals(
				"\n" +
				"\nimport org.eclipse.emf.ecore.resource.Resource$Factory$Descriptor", section);
	}
	
	@Test public void testFunctionTypes_afterResolve() throws Exception {
		String model = 
				"package foo.bar\n" +
				"import java.util.Map$Entry\n" +
				"class Foo {\n" +
				"  def (Entry)=>void test() {" +
				"    return null\n" +
				"  }\n" +
				"}\n";
		XtendFile file = file(model, true);
		String section = organizeImports.getOrganizedImportSection((XtextResource) file.eResource());
		
		assertEquals(
				"\n" +
				"\nimport java.util.Map$Entry", section);
	}
	
	@Test public void testFunctionTypes_beforeResolve() throws Exception {
		String model = 
				"package foo.bar\n" +
				"import java.util.Map$Entry\n" +
				"class Foo {\n" +
				"  def (Entry)=>void test() {" +
				"    return null\n" +
				"  }\n" +
				"}\n";
		XtendFile file = file(model, false);
		String section = organizeImports.getOrganizedImportSection((XtextResource) file.eResource());
		
		assertEquals(
				"\n" +
				"\nimport java.util.Map$Entry", section);
	}
	
	@Test public void testImport_PairOf() throws Exception {
		String model = 
				"package foo.bar\n" +
				"import static org.eclipse.xtext.xbase.lib.Pair.*\n" +
				"class Foo {\n" +
				"  def Object test() {" +
				"    return of('', '')\n" +
				"  }\n" +
				"}\n";
		XtendFile file = file(model, false);
		String section = organizeImports.getOrganizedImportSection((XtextResource) file.eResource());
		
		assertEquals(
				"\n" +
				"\nimport static org.eclipse.xtext.xbase.lib.Pair.*", section);
	}
	
	@Test public void testArrayType() throws Exception {
		String model = 
				"package foo.bar\n" +
				"import java.io.Serializable\n" +
				"class Foo {\n" +
				"  def Serializable[][] test() {" +
				"    return null\n" +
				"  }\n" +
				"}\n";
		XtendFile file = file(model, false);
		String section = organizeImports.getOrganizedImportSection((XtextResource) file.eResource());
		
		assertEquals(
				"\n" +
				"\nimport java.io.Serializable", section);
	}
	
	@Test public void testStaticImport_IterableExtensions() throws Exception {
		String model = 
				"package foo.bar\n" +
				"import static org.eclipse.xtext.xbase.lib.IterableExtensions.*\n" +
				"class Foo {\n" +
				"  def Object test() {" +
				"    return filter(null, null)\n" +
				"  }\n" +
				"}\n";
		XtendFile file = file(model, false);
		String section = organizeImports.getOrganizedImportSection((XtextResource) file.eResource());
		
		assertEquals(
				"\n" +
				"\nimport static org.eclipse.xtext.xbase.lib.IterableExtensions.*", section);
	}

	@Test public void testPropertyAnnotation() throws Exception {
		String model = 
				"package foo.bar\n" +
				"class Foo {\n" +
				"  @Property int prop\n" +
				"}\n";
		XtendFile file = file(model, true);
		String section = organizeImports.getOrganizedImportSection((XtextResource) file.eResource());
		
		assertEquals("", section);
	}
	
	@Test public void testNestedAnnotation_01() throws Exception {
		String model = 
				"package foo.bar\n" +
				"" +
				"import org.eclipse.xtext.service.DispatchingProvider$Runtime" +
				"" +
				"@Runtime\n" +
				"class Foo {\n" +
				"}\n";
		XtendFile file = file(model, true);
		String section = organizeImports.getOrganizedImportSection((XtextResource) file.eResource());
		
		assertEquals("\n\nimport org.eclipse.xtext.service.DispatchingProvider$Runtime", section);
	}
	
	@Test public void testNestedAnnotation_02() throws Exception {
		String model = 
				"package foo.bar\n" +
				"" +
				"import org.eclipse.xtext.service.DispatchingProvider$Runtime" +
				"" +
				"@DispatchingProvider$Runtime\n" +
				"class Foo {\n" +
				"}\n";
		XtendFile file = file(model, true);
		String section = organizeImports.getOrganizedImportSection((XtextResource) file.eResource());
		
		assertEquals("\n\nimport org.eclipse.xtext.service.DispatchingProvider", section);
	}
	
	@Test public void testBug388933_01() throws Exception {
		String model = 
				"import static extension MyExtensionLib.*\n" + 
				"\n" + 
				"class MyExtensionLib {\n" + 
				"    def static func1 (String a, int b) {  }\n" + 
				"}\n" + 
				"class MyClient {\n" + 
				"    def sample (String it) { func1(47)  }\n" + 
				"}";
		XtendFile file = file(model, false);
		String section = organizeImports.getOrganizedImportSection((XtextResource) file.eResource());
		
		assertEquals(
				"\n" +
				"\nimport static extension MyExtensionLib.*", section);
	}
	
	@Test public void testBug388933_02() throws Exception {
		String model = 
				"import static java.util.Arrays.*\n" + 
				"\n" + 
				"class C {\n" + 
				"    var x = asList\n" + 
				"}";
		XtendFile file = file(model, false);
		String section = organizeImports.getOrganizedImportSection((XtextResource) file.eResource());
		
		assertEquals(
				"\n" +
				"\nimport static java.util.Arrays.*", section);
	}
	
	@Test public void testBug380637_01() throws Exception {
		String model =  "class MyExtensionLib {\n" + 
						"    def static func1 (String a, int b) { " +
						"       func1(a,b)" +
						"    }\n" + 
						"}";
		XtendFile file = file(model, false);
		String section = organizeImports.getOrganizedImportSection((XtextResource) file.eResource());
		
		assertEquals("", section);
	}
	
	@Test public void testBug380637_02() throws Exception {
		String model =  
				"abstract class MyClass implements org.eclipse.xtext.scoping.IScope {\n" + 
				"    org.eclipse.xtext.scoping.IScope scope = NULLSCOPE" + 
				"}";
		XtendFile file = file(model, false);
		String section = organizeImports.getOrganizedImportSection((XtextResource) file.eResource());
		
		assertEquals("\n\nimport org.eclipse.xtext.scoping.IScope", section);
	}
	
	@Test public void testBug380637_03() throws Exception {
		String model =  
				"abstract class MyClass extends org.eclipse.xtext.scoping.impl.AbstractScope {\n" + 
				"    Object field = NULLSCOPE" + 
				"}";
		XtendFile file = file(model, false);
		String section = organizeImports.getOrganizedImportSection((XtextResource) file.eResource());
		
		assertEquals("\n\nimport org.eclipse.xtext.scoping.impl.AbstractScope", section);
	}
}
