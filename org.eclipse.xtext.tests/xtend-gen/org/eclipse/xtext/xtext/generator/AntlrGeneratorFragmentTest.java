/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator;

import com.google.inject.Guice;
import com.google.inject.Injector;
import java.util.Collection;
import java.util.Map;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.generator.InMemoryFileSystemAccess;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xtext.generator.DefaultGeneratorModule;
import org.eclipse.xtext.xtext.generator.model.IXtextGeneratorFileSystemAccess;
import org.eclipse.xtext.xtext.generator.parser.antlr.AntlrDebugGrammarGenerator;
import org.eclipse.xtext.xtext.generator.parser.antlr.AntlrOptions;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class AntlrGeneratorFragmentTest extends AbstractXtextTests {
  public static class InMemFSA extends InMemoryFileSystemAccess implements IXtextGeneratorFileSystemAccess {
    @Override
    public String getPath() {
      return "./";
    }
    
    @Override
    public boolean isOverwrite() {
      return true;
    }
    
    @Override
    public void initialize(final Injector injector) {
      injector.injectMembers(this);
    }
  }
  
  @Override
  public void setUp() throws Exception {
    super.setUp();
    this.with(XtextStandaloneSetup.class);
  }
  
  @Test
  public void testDebugGrammar_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar com.foo.bar ");
    _builder.newLine();
    _builder.append("import \"http://www.eclipse.org/emf/2002/Ecore\" as ecore");
    _builder.newLine();
    _builder.append("generate myPack \'http://mypack\'");
    _builder.newLine();
    _builder.newLine();
    _builder.append("MyRule :");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("->((\'a\'|\'b\'|\'c\') \'d\') ");
    _builder.newLine();
    _builder.append(";");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("grammar DebugInternalbar;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("// Rule MyRule");
    _builder_1.newLine();
    _builder_1.append("ruleMyRule:");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("(");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("(\'a\' | \'b\' | \'c\')=>");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("(");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("\'a\'");
    _builder_1.newLine();
    _builder_1.append("\t\t\t    ");
    _builder_1.append("|");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("\'b\'");
    _builder_1.newLine();
    _builder_1.append("\t\t\t    ");
    _builder_1.append("|");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("\'c\'");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append(")");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("\'d\'");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append(")");
    _builder_1.newLine();
    _builder_1.append(";");
    _builder_1.newLine();
    this.asserTranslatesToDebugGrammar(_builder, _builder_1.toString());
  }
  
  @Test
  public void testDebugGrammar_Bug482677() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar com.foo.bar ");
    _builder.newLine();
    _builder.append("import \"http://www.eclipse.org/emf/2002/Ecore\" as ecore");
    _builder.newLine();
    _builder.append("generate myPack \'http://mypack\'");
    _builder.newLine();
    _builder.newLine();
    _builder.append("MyRule :");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("->(x=(\'a\'|\'b\'|\'c\') y=\'d\') ");
    _builder.newLine();
    _builder.append(";");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("grammar DebugInternalbar;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("// Rule MyRule");
    _builder_1.newLine();
    _builder_1.append("ruleMyRule:");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("(");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("(\'a\' | \'b\' | \'c\')=>");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("(");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("\'a\'");
    _builder_1.newLine();
    _builder_1.append("\t\t\t    ");
    _builder_1.append("|");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("\'b\'");
    _builder_1.newLine();
    _builder_1.append("\t\t\t    ");
    _builder_1.append("|");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("\'c\'");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append(")");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("\'d\'");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append(")");
    _builder_1.newLine();
    _builder_1.append(";");
    _builder_1.newLine();
    this.asserTranslatesToDebugGrammar(_builder, _builder_1.toString());
  }
  
  @Test
  public void testDebugGrammar_Bug482677_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar com.foo.bar ");
    _builder.newLine();
    _builder.append("import \"http://www.eclipse.org/emf/2002/Ecore\" as ecore");
    _builder.newLine();
    _builder.append("generate myPack \'http://mypack\'");
    _builder.newLine();
    _builder.newLine();
    _builder.append("MyRule :");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\'foo\' ->(\'bar\' prop=(\'a\'|\'b\'|\'c\') more=\'more\')?");
    _builder.newLine();
    _builder.append(";");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("grammar DebugInternalbar;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("// Rule MyRule");
    _builder_1.newLine();
    _builder_1.append("ruleMyRule:");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("\'foo\'");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("(");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("(\'bar\')=>");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("\'bar\'");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("(");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("\'a\'");
    _builder_1.newLine();
    _builder_1.append("\t\t\t    ");
    _builder_1.append("|");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("\'b\'");
    _builder_1.newLine();
    _builder_1.append("\t\t\t    ");
    _builder_1.append("|");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("\'c\'");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append(")");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("\'more\'");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append(")?");
    _builder_1.newLine();
    _builder_1.append(";");
    _builder_1.newLine();
    this.asserTranslatesToDebugGrammar(_builder, _builder_1.toString());
  }
  
  protected void asserTranslatesToDebugGrammar(final CharSequence xtextGrammar, final String expectedDebugGrammar) {
    try {
      String _string = xtextGrammar.toString();
      EObject _model = super.getModel(_string);
      final Grammar grammar = ((Grammar) _model);
      DefaultGeneratorModule _defaultGeneratorModule = new DefaultGeneratorModule();
      final Injector injector = Guice.createInjector(_defaultGeneratorModule);
      final AntlrGeneratorFragmentTest.InMemFSA inMem = new AntlrGeneratorFragmentTest.InMemFSA();
      final AntlrOptions options = new AntlrOptions();
      AntlrDebugGrammarGenerator _instance = injector.<AntlrDebugGrammarGenerator>getInstance(AntlrDebugGrammarGenerator.class);
      _instance.generate(grammar, options, inMem);
      Map<String, Object> _allFiles = inMem.getAllFiles();
      Collection<Object> _values = _allFiles.values();
      Object _head = IterableExtensions.<Object>head(_values);
      String _string_1 = _head.toString();
      Assert.assertEquals(expectedDebugGrammar, _string_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
