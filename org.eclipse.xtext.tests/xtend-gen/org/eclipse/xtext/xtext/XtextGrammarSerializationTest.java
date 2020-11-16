package org.eclipse.xtext.xtext;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.Collections;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ContentHandler;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.resource.SaveOptions;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.services.XtextGrammarAccess;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.eclipse.xtext.tests.LineDelimiters;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class XtextGrammarSerializationTest extends AbstractXtextTests {
  @Override
  public void setUp() throws Exception {
    super.setUp();
    this.with(XtextStandaloneSetup.class);
  }
  
  @Test
  public void testParameters() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar foo with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate mm \"http://bar\"");
    _builder.newLine();
    _builder.append("MyRule<MyParam>:");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("<MyParam> name=ID");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("| <!MyParam> name=STRING");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("| name=\'name\'");
    _builder.newLine();
    _builder.append(";");
    _builder.newLine();
    final String model = _builder.toString();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("grammar foo with org.eclipse.xtext.common.Terminals");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("generate mm \"http://bar\"");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("MyRule <MyParam>:");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("<MyParam> name=ID");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("| <!MyParam> name=STRING");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("| name=\'name\';");
    _builder_1.newLine();
    final String expectedModel = _builder_1.toString();
    this.doTestSerialization(model, expectedModel);
  }
  
  @Test
  public void testArguments_01() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar foo with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate mm \"http://bar\"");
    _builder.newLine();
    _builder.append("Rule  < arg  > :");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("name=ID child=Rule< arg >");
    _builder.newLine();
    _builder.append(";");
    _builder.newLine();
    final String model = _builder.toString();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("grammar foo with org.eclipse.xtext.common.Terminals");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("generate mm \"http://bar\"");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("Rule <arg>:");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("name=ID child=Rule<arg>;");
    _builder_1.newLine();
    final String expectedModel = _builder_1.toString();
    this.doTestSerialization(model, expectedModel);
  }
  
  @Test
  public void testArguments_02() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar foo with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate mm \"http://bar\"");
    _builder.newLine();
    _builder.append("MyRule<host>:");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("value1=MyParameterizedRule< arg = true >");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("value2=MyParameterizedRule<  arg   = false >");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("value3=MyParameterizedRule < arg = host >");
    _builder.newLine();
    _builder.append(";");
    _builder.newLine();
    _builder.append("MyParameterizedRule  < arg  > :");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("name=ID child=MyParameterizedRule< arg >");
    _builder.newLine();
    _builder.append(";");
    _builder.newLine();
    final String model = _builder.toString();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("grammar foo with org.eclipse.xtext.common.Terminals");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("generate mm \"http://bar\"");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("MyRule <host>:");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("value1=MyParameterizedRule<arg=true>");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("value2=MyParameterizedRule<arg=false>");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("value3=MyParameterizedRule<arg=host>;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("MyParameterizedRule <arg>:");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("name=ID child=MyParameterizedRule<arg>;");
    _builder_1.newLine();
    final String expectedModel = _builder_1.toString();
    this.doTestSerialization(model, expectedModel);
  }
  
  @Test
  public void testSimpleSerialization() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar foo with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate mm \"http://bar\" as fooMM");
    _builder.newLine();
    _builder.append("StartRule returns fooMM::T: name=ID;");
    _builder.newLine();
    final String model = _builder.toString();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("grammar foo with org.eclipse.xtext.common.Terminals");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("generate mm \"http://bar\" as fooMM");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("StartRule returns fooMM::T:");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("name=ID;");
    _builder_1.newLine();
    final String expectedModel = _builder_1.toString();
    this.doTestSerialization(model, expectedModel);
  }
  
  @Test
  public void testSerializationWithCardinalityOverride() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar foo with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate mm \"http://bar\" as fooMM");
    _builder.newLine();
    _builder.append("StartRule returns fooMM::T: (name+=ID?)+;");
    _builder.newLine();
    final String model = _builder.toString();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("grammar foo with org.eclipse.xtext.common.Terminals");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("generate mm \"http://bar\" as fooMM");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("StartRule returns fooMM::T:");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("(name+=ID)*;");
    _builder_1.newLine();
    final String expectedModel = _builder_1.toString();
    this.doTestSerialization(model, expectedModel);
  }
  
  @Test
  public void testSerializationSuperCall() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar foo with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate mm \"http://bar\" as fooMM");
    _builder.newLine();
    _builder.append("StartRule returns fooMM::T: name=super::ID value=Terminals::STRING thing=STRING;");
    _builder.newLine();
    _builder.append("terminal STRING: super;");
    _builder.newLine();
    final String model = _builder.toString();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("grammar foo with org.eclipse.xtext.common.Terminals");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("generate mm \"http://bar\" as fooMM");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("StartRule returns fooMM::T:");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("name=super::ID value=Terminals::STRING thing=STRING;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("terminal STRING:");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("super;");
    _builder_1.newLine();
    final String expectedModel = _builder_1.toString();
    this.doTestSerialization(model, expectedModel);
  }
  
  private void doTestSerialization(final String model, final String expectedModel) throws Exception {
    final XtextResource resource = this.getResourceFromString(model);
    Assert.assertTrue(resource.getErrors().isEmpty());
    EObject _rootASTElement = resource.getParseResult().getRootASTElement();
    final Grammar g = ((Grammar) _rootASTElement);
    Assert.assertNotNull(g);
    final OutputStream outputStream = new ByteArrayOutputStream();
    resource.save(outputStream, SaveOptions.newBuilder().format().getOptions().toOptionsMap());
    final String serializedModel = outputStream.toString();
    Assert.assertEquals(LineDelimiters.toPlatform(expectedModel), serializedModel);
  }
  
  @Test
  public void testMetamodelRefSerialization() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar foo with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("import \"http://www.eclipse.org/2008/Xtext\" as xtext");
    _builder.newLine();
    _builder.append("generate mm \"http://bar\" as fooMM");
    _builder.newLine();
    _builder.append("Foo returns fooMM::Foo: name=ID (nameRefs+=NameRef)*;");
    _builder.newLine();
    _builder.append("NameRef returns xtext::RuleCall : rule=[xtext::ParserRule];");
    _builder.newLine();
    _builder.append("MyRule returns xtext::ParserRule : name=ID;");
    _builder.newLine();
    final String model = _builder.toString();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("grammar foo with org.eclipse.xtext.common.Terminals");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("import \"http://www.eclipse.org/2008/Xtext\" as xtext");
    _builder_1.newLine();
    _builder_1.append("generate mm \"http://bar\" as fooMM");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("Foo returns fooMM::Foo:");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("name=ID (nameRefs+=NameRef)*;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("NameRef returns xtext::RuleCall:");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("rule=[xtext::ParserRule];");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("MyRule returns xtext::ParserRule:");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("name=ID;");
    _builder_1.newLine();
    final String expectedModel = _builder_1.toString();
    this.doTestSerialization(model, expectedModel);
  }
  
  public void _testXtestSerializationSelfTest() throws Exception {
    Resource res = this.<XtextResourceSet>get(XtextResourceSet.class).createResource(URI.createURI("myfile.xtext"), 
      ContentHandler.UNSPECIFIED_CONTENT_TYPE);
    res.getContents().add(this.<XtextGrammarAccess>get(XtextGrammarAccess.class).getGrammar());
    OutputStream outputStream = new ByteArrayOutputStream();
    res.save(outputStream, Collections.<Object, Object>emptyMap());
  }
}
