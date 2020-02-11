/**
 * Copyright (c) 2016, 2018 itemis AG (http://www.itemis.eu) and others.
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
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xtext.generator.AbstractGeneratorFragmentTests;
import org.eclipse.xtext.xtext.generator.formatting.Formatter2Fragment2;
import org.eclipse.xtext.xtext.generator.model.XtendFileAccess;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Lorenzo Bettini - Initial contribution and API
 */
@SuppressWarnings("all")
public class Formatter2Fragment2Test extends AbstractGeneratorFragmentTests {
  public static class TestableFormatter2Fragment2 extends Formatter2Fragment2 {
    @Override
    public String toVarName(final ENamedElement element, final String... reservedNames) {
      return super.toVarName(element, reservedNames);
    }
    
    @Override
    public XtendFileAccess doGetXtendStubFile() {
      return super.doGetXtendStubFile();
    }
  }
  
  private Formatter2Fragment2Test.TestableFormatter2Fragment2 fragment = new Formatter2Fragment2Test.TestableFormatter2Fragment2();
  
  @Test
  public void testVarNameWithEClass() {
    Assert.assertEquals("eClass", this.fragment.toVarName(EcorePackage.eINSTANCE.getEClass()));
  }
  
  @Test
  public void testVarNameWithMultiReference() {
    Assert.assertEquals("eOperation", this.fragment.toVarName(EcorePackage.eINSTANCE.getEClass_EAllOperations()));
  }
  
  @Test
  public void testVarNameWithSingleReference() {
    Assert.assertEquals("name", this.fragment.toVarName(EcorePackage.eINSTANCE.getENamedElement_Name()));
  }
  
  @Test
  public void testVarNameConflictingWithXtendKeyword() {
    Assert.assertEquals("_abstract", this.fragment.toVarName(EcorePackage.eINSTANCE.getEClass_Abstract()));
  }
  
  @Test
  public void testVarNameConflictingWithParam() {
    EAttribute _createEAttribute = EcoreFactory.eINSTANCE.createEAttribute();
    final Procedure1<EAttribute> _function = (EAttribute it) -> {
      it.setName("xxx");
    };
    EAttribute _doubleArrow = ObjectExtensions.<EAttribute>operator_doubleArrow(_createEAttribute, _function);
    Assert.assertEquals("_xxx", this.fragment.toVarName(_doubleArrow), "xxx");
  }
  
  @Test
  public void testVarNameConflictingWithXtendKeywordAndParam() {
    Assert.assertEquals("__abstract", this.fragment.toVarName(EcorePackage.eINSTANCE.getEClass_Abstract(), "_abstract"));
  }
  
  @Test
  public void testFormatMethodGeneration01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar org.xtext.example.mydsl.MyDsl with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate myDsl \"http://www.xtext.org/example/mydsl/MyDsl\"");
    _builder.newLine();
    _builder.append("Model:");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("greetings+=Greeting*;");
    _builder.newLine();
    _builder.append("Greeting:");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\'Hello\' name=ID \'!\';");
    _builder.newLine();
    this.fragment = this.<Formatter2Fragment2Test.TestableFormatter2Fragment2>initializeFragmentWithGrammarFromString(Formatter2Fragment2Test.TestableFormatter2Fragment2.class, _builder.toString());
    final String actual = this.concatenationClientToString(this.fragment.doGetXtendStubFile());
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package org.xtext.example.mydsl.formatting2");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("import com.google.inject.Inject");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.formatting2.AbstractFormatter2");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.formatting2.IFormattableDocument");
    _builder_1.newLine();
    _builder_1.append("import org.xtext.example.mydsl.myDsl.Model");
    _builder_1.newLine();
    _builder_1.append("import org.xtext.example.mydsl.services.MyDslGrammarAccess");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("class MyDslFormatter extends AbstractFormatter2 {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("@Inject extension MyDslGrammarAccess");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def dispatch void format(Model model, extension IFormattableDocument document) {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("// TODO: format HiddenRegions around keywords, attributes, cross references, etc. ");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("for (greeting : model.greetings) {");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("greeting.format");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("// TODO: implement for ");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    final String expected = _builder_1.toString();
    Assert.assertEquals(expected, actual);
  }
  
  @Test
  public void testFormatMethodGeneration02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar org.xtext.example.mydsl.MyDsl with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate myDsl \"http://www.xtext.org/example/mydsl/MyDsl\"");
    _builder.newLine();
    _builder.append("Model:");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("greetings+=Greeting*");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("description=Description;");
    _builder.newLine();
    _builder.append("Greeting:");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\'Hello\' person=Person \'!\';");
    _builder.newLine();
    _builder.append("Person:");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("firstname=ID lastname=ID;");
    _builder.newLine();
    _builder.append("Description:");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("text=STRING;");
    _builder.newLine();
    this.fragment = this.<Formatter2Fragment2Test.TestableFormatter2Fragment2>initializeFragmentWithGrammarFromString(Formatter2Fragment2Test.TestableFormatter2Fragment2.class, _builder.toString());
    final String actual = this.concatenationClientToString(this.fragment.doGetXtendStubFile());
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package org.xtext.example.mydsl.formatting2");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("import com.google.inject.Inject");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.formatting2.AbstractFormatter2");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.formatting2.IFormattableDocument");
    _builder_1.newLine();
    _builder_1.append("import org.xtext.example.mydsl.myDsl.Greeting");
    _builder_1.newLine();
    _builder_1.append("import org.xtext.example.mydsl.myDsl.Model");
    _builder_1.newLine();
    _builder_1.append("import org.xtext.example.mydsl.services.MyDslGrammarAccess");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("class MyDslFormatter extends AbstractFormatter2 {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("@Inject extension MyDslGrammarAccess");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def dispatch void format(Model model, extension IFormattableDocument document) {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("// TODO: format HiddenRegions around keywords, attributes, cross references, etc. ");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("for (greeting : model.greetings) {");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("greeting.format");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("model.description.format");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def dispatch void format(Greeting greeting, extension IFormattableDocument document) {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("// TODO: format HiddenRegions around keywords, attributes, cross references, etc. ");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("greeting.person.format");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("// TODO: implement for ");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    final String expected = _builder_1.toString();
    Assert.assertEquals(expected, actual);
  }
}
