/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.tests.formatting;

import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.xtend2.formatting.OrganizeImports;
import org.eclipse.xtext.xtend2.tests.AbstractXtend2TestCase;
import org.eclipse.xtext.xtend2.xtend2.XtendFile;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class OrganizeImportsTest extends AbstractXtend2TestCase {
	
	@Inject
	private OrganizeImports organizeImports;
	
	public void testGetOrganizedImportSection_01() throws Exception {
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
	
	public void testGetOrganizedImportSection_02() throws Exception {
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
	
	public void testGetOrganizedImportSection_03() throws Exception {
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
	
	public void testGetOrganizedImportSection_04() throws Exception {
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
	
	public void testGetOrganizedImportSection_05() throws Exception {
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
	
	public void testGetOrganizedImportSectionWithInnerClasses_01() throws Exception {
		String model = 
						"class Foo {\n" +
						"  def void test(org.eclipse.emf.ecore.resource.Resource$Factory a, org.eclipse.emf.ecore.resource.Resource$Factory$Registry b) {\n" +
						"  }\n" +
						"}\n";
		XtendFile file = file(model,true);
		String section = organizeImports.getOrganizedImportSection((XtextResource) file.eResource());
		
		assertEquals(
				"\n" +
				"\nimport org.eclipse.emf.ecore.resource.Resource$Factory" + 
				"\nimport org.eclipse.emf.ecore.resource.Resource$Factory$Registry", section);
	}
	
	public void testGetOrganizedImportSectionWithInnerClasses_02() throws Exception {
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
				"\nimport org.eclipse.emf.ecore.EPackage$Registry" + 
				"\nimport org.eclipse.emf.ecore.resource.Resource$Factory$Registry", section);
	}
	
	public void testGetOrganizedImportSectionWithNameClash_01() throws Exception {
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
	
	public void testGetOrganizedImportSectionWithNameClash_02() throws Exception {
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
	
	public void testGetOrganizedImportSectionWithStaticImport_01() throws Exception {
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
	
	public void testGetOrganizedImportSectionWithStaticImport_02() throws Exception {
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
	
	public void testGetOrganizedImportSectionWithImplicitExtensions() throws Exception {
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

	
	public void testGetRegion_01() throws Exception {
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
	
	public void testGetRegion_02() throws Exception {
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
	
	public void testGetRegion_03() throws Exception {
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
	
	public void testInnerClassImport() throws Exception {
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
	
	public void testFunctionTypes_afterResolve() throws Exception {
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
	
	public void testFunctionTypes_beforeResolve() throws Exception {
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
}
