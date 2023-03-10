/*******************************************************************************
 * Copyright (c) 2010, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.contentassist;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.ui.testing.AbstractContentAssistTest;
import org.eclipse.xtext.ui.testing.ContentAssistProcessorTestBuilder;
import org.eclipse.xtext.ui.tests.editor.contentassist.ui.tests.Bug304681TestLanguageUiInjectorProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@InjectWith(Bug304681TestLanguageUiInjectorProvider.class)
@RunWith(XtextRunner.class)
public class Bug304681Test extends AbstractContentAssistTest {
	
	@Test public void testEmptyModel() throws Exception {
		super.newBuilder().assertText("1", "2");
	}
	
	@Test public void testAfterPackageDecl() throws Exception {
		newBuilder1().assertText("object", "abstract", "enabled");
	}
	
	@Test public void testInObject() throws Exception {
		newBuilder1().appendNl("object MyObject {").assertText(
				"shortDescription", 
				"longDescription", 
				"serialUID",
				"cloneable",
				"Attribute",
				"Reference",
				"before",
				"optionalLoop",
				"mandatoryLoop",
				"}");
	}
	
	@Test public void testAfterAttribute_01() throws Exception {
		newBuilder1()
			.appendNl("object MyObject {")
			.appendNl("Attribute type name;")
			.assertText(
				"shortDescription", 
				"longDescription", 
				"serialUID",
				"cloneable",
				"Attribute",
				"Reference",
				"before",
				"optionalLoop",
				"mandatoryLoop",
				"}");
	}
	
	@Test public void testAfterAttribute_02() throws Exception {
		newBuilder1()
			.appendNl("object MyObject {")
			.appendNl("before Attribute type name;")
			.assertText(
				"Attribute",
				"Reference",
				"after");
	}
	
	@Test public void testAfterAttribute_03() throws Exception {
		newBuilder1()
			.appendNl("object MyObject {")
			.appendNl("optionalLoop Attribute type name;")
			.assertText(
				"shortDescription", 
				"longDescription", 
				"serialUID",
				"cloneable",
				"Attribute",
				"Reference",
				"before",
				"mandatoryLoop",
				"}");
	}
	
	@Test public void testAfterAttribute_04() throws Exception {
		newBuilder1()
			.appendNl("object MyObject {")
			.appendNl("cloneable;")
			.appendNl("optionalLoop Attribute type name;")
			.assertText(
				"shortDescription", 
				"longDescription", 
				"serialUID",
				"Attribute",
				"Reference",
				"before",
				"mandatoryLoop",
				"}");
	}
	
	@Test public void testAfterAttribute_05() throws Exception {
		newBuilder1()
			.appendNl("object MyObject {")
			.appendNl("cloneable;")
			.appendNl("optionalLoop")
			.assertText(
				"shortDescription", 
				"longDescription", 
				"serialUID",
				"Attribute",
				"Reference",
				"before",
				"mandatoryLoop",
				"}"
				);
	}
	
	@Test public void testAfterAttribute_06() throws Exception {
		newBuilder1()
			.appendNl("object MyObject {")
			.appendNl("cloneable;")
			.appendNl("mandatoryLoop")
			.assertText(
				"Attribute",
				"Reference");
	}
	
	@Test public void testAfterAttribute_07() throws Exception {
		newBuilder1()
			.appendNl("object MyObject {")
			.appendNl("cloneable;")
			.appendNl("mandatoryLoop Attribute type name;")
			.assertText(
				"shortDescription", 
				"longDescription", 
				"serialUID",
				"Attribute",
				"Reference",
				"before",
				"optionalLoop",
				"}"
				);
	}
	
	@Test public void testAfterAttribute_08() throws Exception {
		newBuilder1()
			.appendNl("object MyObject {")
			.appendNl("Attribute type name;")
			.appendNl("Attribute type name;")
			.assertText(
				"shortDescription", 
				"longDescription", 
				"serialUID",
				"cloneable",
				"Attribute",
				"Reference",
				"before",
				"optionalLoop",
				"mandatoryLoop",
				"}");
	}
	
	@Test public void testAfterAttribute_09() throws Exception {
		newBuilder1()
		.appendNl("object MyObject {")
		.appendNl("before Attribute type name;")
		.appendNl("Attribute type name;")
		.assertText(
				"Attribute",
				"Reference",
				"after");
	}
	
	@Test public void testAfterAttribute_10() throws Exception {
		newBuilder1()
		.appendNl("object MyObject {")
		.appendNl("optionalLoop Attribute type name;")
		.appendNl("Attribute type name;")
		.assertText(
				"shortDescription", 
				"longDescription", 
				"serialUID",
				"cloneable",
				"Attribute",
				"Reference",
				"before",
				"mandatoryLoop",
				"}");
	}
	
	@Test public void testAfterAttribute_11() throws Exception {
		newBuilder1()
		.appendNl("object MyObject {")
		.appendNl("cloneable;")
		.appendNl("optionalLoop Attribute type name;")
		.appendNl("Attribute type name;")
		.assertText(
				"shortDescription", 
				"longDescription", 
				"serialUID",
				"Attribute",
				"Reference",
				"before",
				"mandatoryLoop",
				"}");
	}
	
	@Test public void testAfterAttribute_12() throws Exception {
		newBuilder1()
		.appendNl("object MyObject {")
		.appendNl("cloneable;")
		.appendNl("mandatoryLoop Attribute type name;")
		.appendNl("Attribute type name;")
		.assertText(
				"shortDescription", 
				"longDescription", 
				"serialUID",
				"Attribute",
				"Reference",
				"before",
				"optionalLoop",
				"}"
		);
	}
	
	@Test public void testAfterPackageDecl2() throws Exception {
		newBuilder2().assertText("object", "abstract", "enabled");
	}
	
	@Test public void testInObject2() throws Exception {
		newBuilder2().appendNl("object MyObject {").assertText(
				"shortDescription", 
				"longDescription", 
				"serialUID",
				"cloneable",
				"Attribute",
				"Reference",
				"}");
	}
	
	@Test public void testAfterAttribute2_01() throws Exception {
		newBuilder2()
			.appendNl("object MyObject {")
			.appendNl("Attribute type name;")
			.assertText(
				"shortDescription", 
				"longDescription", 
				"serialUID",
				"cloneable",
				"Attribute",
				"Reference",
				"}");
	}
	
	@Test public void testAfterAttribute2_02() throws Exception {
		newBuilder2()
			.appendNl("object MyObject {")
			.appendNl("Attribute type name;")
			.appendNl("Attribute type name;")
			.assertText(
				"shortDescription", 
				"longDescription", 
				"serialUID",
				"cloneable",
				"Attribute",
				"Reference",
				"}");
	}
	
	@Test public void testAfterAttribute2_03() throws Exception {
		newBuilder2()
			.appendNl("object MyObject {")
			.appendNl("shortDescription 'descr';")
			.appendNl("Attribute type name;")
			.appendNl("Attribute type name;")
			.assertText(
				"longDescription", 
				"serialUID",
				"cloneable",
				"Attribute",
				"Reference",
				"}");
	}
	
	@Test public void testAfterAttribute2_04() throws Exception {
		newBuilder2()
			.appendNl("object MyObject {")
			.appendNl("Attribute type name;")
			.appendNl("shortDescription 'descr';")
			.assertText(
				"longDescription", 
				"serialUID",
				"cloneable",
				"}");
	}
	
	protected ContentAssistProcessorTestBuilder newBuilder1() throws Exception {
		ContentAssistProcessorTestBuilder result = newBuilder();
		return result.appendNl("1 package myPack;");
	}
	
	protected ContentAssistProcessorTestBuilder newBuilder2() throws Exception {
		ContentAssistProcessorTestBuilder result = newBuilder();
		return result.appendNl("2 package myPack;");
	}

}
