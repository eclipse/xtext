/**
 * Copyright (c) 2016, 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xtext.generator.formatting.Formatter2Fragment2;
import org.eclipse.xtext.xtext.generator.model.JavaFileAccess;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Lorenzo Bettini - Initial contribution and API
 */
public class Formatter2Fragment2Test extends AbstractGeneratorFragmentTests {
	public static class TestableFormatter2Fragment2 extends Formatter2Fragment2 {
		@Override
		public String toVarName(ENamedElement element, String... reservedNames) {
			return super.toVarName(element, reservedNames);
		}

		@Override
		public JavaFileAccess doGetStubFile() {
			return super.doGetStubFile();
		}
	}

	private TestableFormatter2Fragment2 fragment = new TestableFormatter2Fragment2();

	@Test
	public void testVarNameWithEClass() throws Exception {
		Assert.assertEquals("eClass", fragment.toVarName(EcorePackage.eINSTANCE.getEClass()));
	}

	@Test
	public void testVarNameWithMultiReference() throws Exception {
		Assert.assertEquals("eOperation", fragment.toVarName(EcorePackage.eINSTANCE.getEClass_EAllOperations()));
	}

	@Test
	public void testVarNameWithSingleReference() throws Exception {
		Assert.assertEquals("name", fragment.toVarName(EcorePackage.eINSTANCE.getENamedElement_Name()));
	}

	@Test
	public void testVarNameConflictingWithXtendKeyword() throws Exception {
		Assert.assertEquals("_abstract", fragment.toVarName(EcorePackage.eINSTANCE.getEClass_Abstract()));
	}

	@Test
	public void testVarNameConflictingWithParam() throws Exception {
		EAttribute attr = EcoreFactory.eINSTANCE.createEAttribute();
		attr.setName("xxx");
		Assert.assertEquals("_xxx", fragment.toVarName(attr), "xxx");
	}

	@Test
	public void testVarNameConflictingWithXtendKeywordAndParam() throws Exception {
		Assert.assertEquals("__abstract", fragment.toVarName(EcorePackage.eINSTANCE.getEClass_Abstract(), "_abstract"));
	}

	@Test
	public void testFormatMethodGeneration01() throws Exception {
		String grammar =
				"grammar org.xtext.example.mydsl.MyDsl with org.eclipse.xtext.common.Terminals\n" +
				"generate myDsl 'http://www.xtext.org/example/mydsl/MyDsl'\n" +
				"Model:\n" +
				"	greetings+=Greeting*;\n" +
				"Greeting:\n" +
				"	'Hello' name=ID '!';\n";
		fragment = initializeFragmentWithGrammarFromString(TestableFormatter2Fragment2.class, grammar);
		String actual = concatenationClientToString(fragment.doGetStubFile());
		String expected =
				"package org.xtext.example.mydsl.formatting2\n" +
				"\n" +
				"import com.google.inject.Inject\n" +
				"import org.eclipse.xtext.formatting2.AbstractFormatter2\n" +
				"import org.eclipse.xtext.formatting2.IFormattableDocument\n" +
				"import org.xtext.example.mydsl.myDsl.Model\n" +
				"import org.xtext.example.mydsl.services.MyDslGrammarAccess\n" +
				"\n" +
				"class MyDslFormatter extends AbstractFormatter2 {\n" +
				"	\n" +
				"	@Inject extension MyDslGrammarAccess\n" +
				"\n" +
				"	def dispatch void format(Model model, extension IFormattableDocument document) {\n" +
				"		// TODO: format HiddenRegions around keywords, attributes, cross references, etc. \n" +
				"		for (greeting : model.greetings) {\n" +
				"			greeting.format\n" +
				"		}\n" +
				"	}\n" +
				"	\n" +
				"}\n";
		Assert.assertEquals(Strings.toPlatformLineSeparator(expected), actual);
	}

	@Test
	public void testFormatMethodGeneration02() throws Exception {
		String grammar =
				"grammar org.xtext.example.mydsl.MyDsl with org.eclipse.xtext.common.Terminals\n" +
				"generate myDsl 'http://www.xtext.org/example/mydsl/MyDsl'\n" +
				"Model:\n" +
				"	greetings+=Greeting*\n" +
				"	description=Description;\n" +
				"Greeting:\n" +
				"	'Hello' person=Person '!';\n" +
				"Person:\n" +
				"	firstname=ID lastname=ID;\n" +
				"Description:\n" +
				"	text=STRING;\n";
		fragment = initializeFragmentWithGrammarFromString(TestableFormatter2Fragment2.class, grammar);
		String actual = concatenationClientToString(fragment.doGetStubFile());
		String expected =
				"package org.xtext.example.mydsl.formatting2\n" +
				"\n" +
				"import com.google.inject.Inject\n" +
				"import org.eclipse.xtext.formatting2.AbstractFormatter2\n" +
				"import org.eclipse.xtext.formatting2.IFormattableDocument\n" +
				"import org.xtext.example.mydsl.myDsl.Greeting\n" +
				"import org.xtext.example.mydsl.myDsl.Model\n" +
				"import org.xtext.example.mydsl.services.MyDslGrammarAccess\n" +
				"\n" +
				"class MyDslFormatter extends AbstractFormatter2 {\n" +
				"	\n" +
				"	@Inject extension MyDslGrammarAccess\n" +
				"\n" +
				"	def dispatch void format(Model model, extension IFormattableDocument document) {\n" +
				"		// TODO: format HiddenRegions around keywords, attributes, cross references, etc. \n" +
				"		for (greeting : model.greetings) {\n" +
				"			greeting.format\n" +
				"		}\n" +
				"		model.description.format\n" +
				"	}\n" +
				"\n" +
				"	def dispatch void format(Greeting greeting, extension IFormattableDocument document) {\n" +
				"		// TODO: format HiddenRegions around keywords, attributes, cross references, etc. \n" +
				"		greeting.person.format\n" +
				"	}\n" +
				"	\n" +
				"}\n";
		Assert.assertEquals(Strings.toPlatformLineSeparator(expected), actual);
	}

	@Test
	public void testFormatMethodJavaGeneration() throws Exception {
		String grammar =
				"grammar org.xtext.example.mydsl.MyDsl with org.eclipse.xtext.common.Terminals\n" +
				"generate myDsl 'http://www.xtext.org/example/mydsl/MyDsl'\n" +
				"Model:\n" +
				"	greetings+=Greeting*\n" +
				"	description=Description;\n" +
				"Greeting:\n" +
				"	'Hello' person=Person '!';\n" +
				"Person:\n" +
				"	firstname=ID lastname=ID;\n" +
				"Description:\n" +
				"	text=STRING;\n";
		fragment = initializeFragmentWithGrammarFromString(TestableFormatter2Fragment2.class, grammar);
		fragment.setGenerateXtendStub(false);
		String actual = concatenationClientToString(fragment.doGetStubFile());
		String expected =
				"package org.xtext.example.mydsl.formatting2;\n" +
				"\n" +
				"import org.eclipse.xtext.formatting2.AbstractJavaFormatter;\n" +
				"import org.eclipse.xtext.formatting2.IFormattableDocument;\n" +
				"import org.xtext.example.mydsl.myDsl.Greeting;\n" +
				"import org.xtext.example.mydsl.myDsl.Model;\n" +
				"\n" +
				"public class MyDslFormatter extends AbstractJavaFormatter {\n" +
				"\n" +
				"	protected void format(Model model, IFormattableDocument doc) {\n" +
				"		// TODO: format HiddenRegions around keywords, attributes, cross references, etc. \n" +
				"		for (Greeting greeting : model.getGreetings()) {\n" +
				"			doc.format(greeting);\n" +
				"		}\n" +
				"		doc.format(model.getDescription());\n" +
				"	}\n" +
				"\n" +
				"	protected void format(Greeting greeting, IFormattableDocument doc) {\n" +
				"		// TODO: format HiddenRegions around keywords, attributes, cross references, etc. \n" +
				"		doc.format(greeting.getPerson());\n" +
				"	}\n" +
				"	\n" +
				"}\n";
		Assert.assertEquals(Strings.toPlatformLineSeparator(expected), actual);
	}
}
