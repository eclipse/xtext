package org.eclipse.xtext.xtext

import java.io.ByteArrayOutputStream
import java.io.OutputStream
import java.util.Collections
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.ContentHandler
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.XtextStandaloneSetup
import org.eclipse.xtext.resource.SaveOptions
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.services.XtextGrammarAccess
import org.eclipse.xtext.tests.AbstractXtextTests
import org.eclipse.xtext.tests.LineDelimiters
import org.junit.Test

class XtextGrammarSerializationTest extends AbstractXtextTests {
	override void setUp() throws Exception {
		super.setUp()
		with(XtextStandaloneSetup)
	}

	@Test def void testParameters() throws Exception {
		val String model = '''
			grammar foo with org.eclipse.xtext.common.Terminals
			generate mm "http://bar"
			MyRule<MyParam>:
			    <MyParam> name=ID
			  | <!MyParam> name=STRING
			  | name='name'
			;
		'''
		val String expectedModel = '''
			grammar foo with org.eclipse.xtext.common.Terminals
			
			generate mm "http://bar"
			
			MyRule <MyParam>:
				<MyParam> name=ID
				| <!MyParam> name=STRING
				| name='name';'''
		doTestSerialization(model, expectedModel)
	}
	
	@Test def void testArguments_01() throws Exception {
		val String model = '''
			grammar foo with org.eclipse.xtext.common.Terminals
			generate mm "http://bar"
			Rule  < arg  > :
				name=ID child=Rule< arg >
			;
		'''
		val String expectedModel = '''
			grammar foo with org.eclipse.xtext.common.Terminals
			
			generate mm "http://bar"
			
			Rule <arg>:
				name=ID child=Rule<arg>;'''
		doTestSerialization(model, expectedModel)
	}
	
	@Test def void testArguments_02() throws Exception {
		val String model = '''
			grammar foo with org.eclipse.xtext.common.Terminals
			generate mm "http://bar"
			MyRule<host>:
				value1=MyParameterizedRule< arg = true >
				value2=MyParameterizedRule<  arg   = false >
				value3=MyParameterizedRule < arg = host >
			;
			MyParameterizedRule  < arg  > :
				name=ID child=MyParameterizedRule< arg >
			;
		'''
		val String expectedModel = '''
			grammar foo with org.eclipse.xtext.common.Terminals
			
			generate mm "http://bar"
			
			MyRule <host>:
				value1=MyParameterizedRule<arg=true>
				value2=MyParameterizedRule<arg=false>
				value3=MyParameterizedRule<arg=host>;
			
			MyParameterizedRule <arg>:
				name=ID child=MyParameterizedRule<arg>;'''
		doTestSerialization(model, expectedModel)
	}

	@Test def void testSimpleSerialization() throws Exception {
		val String model = '''
			grammar foo with org.eclipse.xtext.common.Terminals
			generate mm "http://bar" as fooMM
			StartRule returns fooMM::T: name=ID;
		'''
		val String expectedModel = '''
			grammar foo with org.eclipse.xtext.common.Terminals
			
			generate mm "http://bar" as fooMM
			
			StartRule returns fooMM::T:
				name=ID;'''
		doTestSerialization(model, expectedModel)
	}

	@Test def void testSerializationWithCardinalityOverride() throws Exception {
		val String model = '''
			grammar foo with org.eclipse.xtext.common.Terminals
			generate mm "http://bar" as fooMM
			StartRule returns fooMM::T: (name+=ID?)+;
		'''
		val String expectedModel = '''
			grammar foo with org.eclipse.xtext.common.Terminals
			
			generate mm "http://bar" as fooMM
			
			StartRule returns fooMM::T:
				(name+=ID)*;'''
		doTestSerialization(model, expectedModel)
	}
	
	@Test def void testSerializationSuperCall() throws Exception {
		val String model = '''
			grammar foo with org.eclipse.xtext.common.Terminals
			generate mm "http://bar" as fooMM
			StartRule returns fooMM::T: name=super::ID value=Terminals::STRING thing=STRING;
			terminal STRING: super;
		'''
		val String expectedModel = '''
			grammar foo with org.eclipse.xtext.common.Terminals
			
			generate mm "http://bar" as fooMM
			
			StartRule returns fooMM::T:
				name=super::ID value=Terminals::STRING thing=STRING;
			
			terminal STRING:
				super;'''
		doTestSerialization(model, expectedModel)
	}

	def private void doTestSerialization(String model, String expectedModel) throws Exception {
		val XtextResource resource = getResourceFromString(model)
		assertTrue(resource.getErrors().isEmpty())
		val Grammar g = resource.getParseResult().getRootASTElement() as Grammar
		assertNotNull(g)
		val OutputStream outputStream = new ByteArrayOutputStream()
		resource.save(outputStream, SaveOptions.newBuilder().format().getOptions().toOptionsMap())
		val String serializedModel = outputStream.toString()
		assertEquals(LineDelimiters.toPlatform(expectedModel), serializedModel)
	}

	@Test def void testMetamodelRefSerialization() throws Exception {
		val String model = '''
			grammar foo with org.eclipse.xtext.common.Terminals
			import "http://www.eclipse.org/2008/Xtext" as xtext
			generate mm "http://bar" as fooMM
			Foo returns fooMM::Foo: name=ID (nameRefs+=NameRef)*;
			NameRef returns xtext::RuleCall : rule=[xtext::ParserRule];
			MyRule returns xtext::ParserRule : name=ID;
		'''
		val String expectedModel = '''
			grammar foo with org.eclipse.xtext.common.Terminals
			
			import "http://www.eclipse.org/2008/Xtext" as xtext
			generate mm "http://bar" as fooMM
			
			Foo returns fooMM::Foo:
				name=ID (nameRefs+=NameRef)*;
			
			NameRef returns xtext::RuleCall:
				rule=[xtext::ParserRule];
			
			MyRule returns xtext::ParserRule:
				name=ID;'''
		doTestSerialization(model, expectedModel)
	}

	def void _testXtestSerializationSelfTest() throws Exception {
		var Resource res = get(XtextResourceSet).createResource(URI.createURI("myfile.xtext"),
			ContentHandler.UNSPECIFIED_CONTENT_TYPE)
		res.getContents().add(get(XtextGrammarAccess).getGrammar())
		var OutputStream outputStream = new ByteArrayOutputStream()
		res.save(outputStream, Collections.emptyMap())
	}

}
