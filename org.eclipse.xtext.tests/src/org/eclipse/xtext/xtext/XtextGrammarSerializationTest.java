/**
 * Copyright (c) 2015, 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ContentHandler;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.resource.SaveOptions;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.services.XtextGrammarAccess;
import org.eclipse.xtext.testing.AbstractXtextTests;
import org.eclipse.xtext.tests.LineDelimiters;
import org.junit.Assert;
import org.junit.Test;

public class XtextGrammarSerializationTest extends AbstractXtextTests {
	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(XtextStandaloneSetup.class);
	}

	@Test
	public void testParameters() throws Exception {
		String model =
				"grammar foo with org.eclipse.xtext.common.Terminals\n" +
				"generate mm \"http://bar\"\n" +
				"MyRule<MyParam>:\n" +
				"    <MyParam> name=ID\n" +
				"  | <!MyParam> name=STRING\n" +
				"  | name=\'name\'\n" +
				";\n";
		String expectedModel =
				"grammar foo with org.eclipse.xtext.common.Terminals\n" +
				"\n" +
				"generate mm \"http://bar\"\n" +
				"\n" +
				"MyRule <MyParam>:\n" +
				"	<MyParam> name=ID\n" +
				"	| <!MyParam> name=STRING\n" +
				"	| name=\'name\';\n";
		doTestSerialization(model, expectedModel);
	}

	@Test
	public void testArguments_01() throws Exception {
		String model =
				"grammar foo with org.eclipse.xtext.common.Terminals\n" +
				"generate mm \"http://bar\"\n" +
				"Rule  < arg  > :\n" +
				"	name=ID child=Rule< arg >\n" +
				";\n";
		String expectedModel = "grammar foo with org.eclipse.xtext.common.Terminals\n" +
				"\n" +
				"generate mm \"http://bar\"\n" +
				"\n" +
				"Rule <arg>:\n" +
				"	name=ID child=Rule<arg>;\n";
		doTestSerialization(model, expectedModel);
	}

	@Test
	public void testArguments_02() throws Exception {
		String model =
				"grammar foo with org.eclipse.xtext.common.Terminals\n" +
				"generate mm \"http://bar\"\n" +
				"MyRule<host>:\n" +
				"	value1=MyParameterizedRule< arg = true >\n" +
				"	value2=MyParameterizedRule<  arg   = false >\n" +
				"	value3=MyParameterizedRule < arg = host >\n" +
				";\n" +
				"MyParameterizedRule  < arg  > :\n" +
				"	name=ID child=MyParameterizedRule< arg >\n" +
				";\n";
		String expectedModel =
				"grammar foo with org.eclipse.xtext.common.Terminals\n" +
				"\n" +
				"generate mm \"http://bar\"\n" +
				"\n" +
				"MyRule <host>:\n" +
				"	value1=MyParameterizedRule<arg=true>\n" +
				"	value2=MyParameterizedRule<arg=false>\n" +
				"	value3=MyParameterizedRule<arg=host>;\n" +
				"\n" +
				"MyParameterizedRule <arg>:\n" +
				"	name=ID child=MyParameterizedRule<arg>;\n";
		doTestSerialization(model, expectedModel);
	}

	@Test
	public void testSimpleSerialization() throws Exception {
		String model =
				"grammar foo with org.eclipse.xtext.common.Terminals\n" +
				"generate mm \"http://bar\" as fooMM\n" +
				"StartRule returns fooMM::T: name=ID;\n";
		String expectedModel =
				"grammar foo with org.eclipse.xtext.common.Terminals\n" +
				"\n" +
				"generate mm \"http://bar\" as fooMM\n" +
				"\n" +
				"StartRule returns fooMM::T:\n" +
				"	name=ID;\n";
		doTestSerialization(model, expectedModel);
	}

	@Test
	public void testSerializationWithCardinalityOverride() throws Exception {
		String model =
				"grammar foo with org.eclipse.xtext.common.Terminals\n" +
				"generate mm \"http://bar\" as fooMM\n" +
				"StartRule returns fooMM::T: (name+=ID?)+;\n";
		String expectedModel =
				"grammar foo with org.eclipse.xtext.common.Terminals\n" +
				"\n" +
				"generate mm \"http://bar\" as fooMM\n" +
				"\n" +
				"StartRule returns fooMM::T:\n" +
				"	(name+=ID)*;\n";
		doTestSerialization(model, expectedModel);
	}

	@Test
	public void testSerializationSuperCall() throws Exception {
		String model =
				"grammar foo with org.eclipse.xtext.common.Terminals\n" +
				"generate mm \"http://bar\" as fooMM\n" +
				"StartRule returns fooMM::T: name=super::ID value=Terminals::STRING thing=STRING;\n" +
				"terminal STRING: super;\n";
		String expectedModel =
				"grammar foo with org.eclipse.xtext.common.Terminals\n" +
				"\n" +
				"generate mm \"http://bar\" as fooMM\n" +
				"\n" +
				"StartRule returns fooMM::T:\n" +
				"	name=super::ID value=Terminals::STRING thing=STRING;\n" +
				"\n" +
				"terminal STRING:\n" +
				"	super;\n";
		doTestSerialization(model, expectedModel);
	}

	private void doTestSerialization(String model, String expectedModel) throws Exception {
		XtextResource resource = getResourceFromString(model);
		Assert.assertTrue(resource.getErrors().isEmpty());
		Grammar g = (Grammar) resource.getParseResult().getRootASTElement();
		Assert.assertNotNull(g);
		OutputStream outputStream = new ByteArrayOutputStream();
		resource.save(outputStream, SaveOptions.newBuilder().format().getOptions().toOptionsMap());
		String serializedModel = outputStream.toString();
		Assert.assertEquals(LineDelimiters.toPlatform(expectedModel), serializedModel);
	}

	@Test
	public void testMetamodelRefSerialization() throws Exception {
		String model =
				"grammar foo with org.eclipse.xtext.common.Terminals\n" +
				"import \"http://www.eclipse.org/2008/Xtext\" as xtext\n" +
				"generate mm \"http://bar\" as fooMM\n" +
				"Foo returns fooMM::Foo: name=ID (nameRefs+=NameRef)*;\n" +
				"NameRef returns xtext::RuleCall : rule=[xtext::ParserRule];\n" +
				"MyRule returns xtext::ParserRule : name=ID;\n";
		String expectedModel =
				"grammar foo with org.eclipse.xtext.common.Terminals\n" +
				"\n" +
				"import \"http://www.eclipse.org/2008/Xtext\" as xtext\n" +
				"generate mm \"http://bar\" as fooMM\n" +
				"\n" +
				"Foo returns fooMM::Foo:\n" +
				"	name=ID (nameRefs+=NameRef)*;\n" +
				"\n" +
				"NameRef returns xtext::RuleCall:\n" +
				"	rule=[xtext::ParserRule];\n" +
				"\n" +
				"MyRule returns xtext::ParserRule:\n" +
				"	name=ID;\n";
		doTestSerialization(model, expectedModel);
	}

	public void _testXtestSerializationSelfTest() throws Exception {
		Resource res = get(XtextResourceSet.class).createResource(URI.createURI("myfile.xtext"),
				ContentHandler.UNSPECIFIED_CONTENT_TYPE);
		res.getContents().add(get(XtextGrammarAccess.class).getGrammar());
		OutputStream outputStream = new ByteArrayOutputStream();
		res.save(outputStream, Collections.emptyMap());
	}
}
