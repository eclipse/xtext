/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.contentassist;

import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.ui.junit.editor.contentassist.AbstractContentAssistProcessorTest;
import org.eclipse.xtext.ui.junit.editor.contentassist.ContentAssistProcessorTestBuilder;
import org.eclipse.xtext.ui.shared.SharedStateModule;
import org.eclipse.xtext.ui.tests.Activator;
import org.eclipse.xtext.ui.tests.editor.contentassist.ui.Bug304681TestLanguageUiModule;
import org.eclipse.xtext.util.Modules2;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class Bug304681Test extends AbstractContentAssistProcessorTest {
	
	public ISetup getSetup() {
		return new Bug304681TestLanguageStandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(
						Modules2.mixin(
								new Bug304681TestLanguageRuntimeModule(), 
								new Bug304681TestLanguageUiModule(Activator.getInstance()), 
								new SharedStateModule()));
			}
		};
	}
	
	public void testEmptyModel() throws Exception {
		newBuilder(getSetup()).assertText("1", "2");
	}
	
	public void testAfterPackageDecl() throws Exception {
		newBuilder().assertText("object", "abstract", "enabled");
	}
	
	public void testInObject() throws Exception {
		newBuilder().appendNl("object MyObject {").assertText(
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
	
	public void testAfterAttribute_01() throws Exception {
		newBuilder()
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
	
	public void testAfterAttribute_02() throws Exception {
		newBuilder()
			.appendNl("object MyObject {")
			.appendNl("before Attribute type name;")
			.assertText(
				"Attribute",
				"Reference",
				"after");
	}
	
	public void testAfterAttribute_03() throws Exception {
		newBuilder()
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
	
	public void testAfterAttribute_04() throws Exception {
		newBuilder()
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
	
	public void testAfterAttribute_05() throws Exception {
		newBuilder()
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
	
	public void testAfterAttribute_06() throws Exception {
		newBuilder()
			.appendNl("object MyObject {")
			.appendNl("cloneable;")
			.appendNl("mandatoryLoop")
			.assertText(
				"Attribute",
				"Reference");
	}
	
	public void testAfterAttribute_07() throws Exception {
		newBuilder()
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
	
	public void testAfterAttribute_08() throws Exception {
		newBuilder()
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
	
	public void testAfterAttribute_09() throws Exception {
		newBuilder()
		.appendNl("object MyObject {")
		.appendNl("before Attribute type name;")
		.appendNl("Attribute type name;")
		.assertText(
				"Attribute",
				"Reference",
				"after");
	}
	
	public void testAfterAttribute_10() throws Exception {
		newBuilder()
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
	
	public void testAfterAttribute_11() throws Exception {
		newBuilder()
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
	
	public void testAfterAttribute_12() throws Exception {
		newBuilder()
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
	
	public void testAfterPackageDecl2() throws Exception {
		newBuilder2().assertText("object", "abstract", "enabled");
	}
	
	public void testInObject2() throws Exception {
		newBuilder2().appendNl("object MyObject {").assertText(
				"shortDescription", 
				"longDescription", 
				"serialUID",
				"cloneable",
				"Attribute",
				"Reference",
				"}");
	}
	
	public void testAfterAttribute2_01() throws Exception {
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
	
	public void testAfterAttribute2_02() throws Exception {
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
	
	public void testAfterAttribute2_03() throws Exception {
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
	
	public void testAfterAttribute2_04() throws Exception {
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
	
	protected ContentAssistProcessorTestBuilder newBuilder() throws Exception {
		ContentAssistProcessorTestBuilder result = newBuilder(getSetup());
		return result.appendNl("1 package myPack;");
	}
	
	protected ContentAssistProcessorTestBuilder newBuilder2() throws Exception {
		ContentAssistProcessorTestBuilder result = newBuilder(getSetup());
		return result.appendNl("2 package myPack;");
	}
	
	
}
