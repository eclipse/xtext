/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.javaconverter;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.xtend.core.javaconverter.JavaCodeAnalyzer;
import org.eclipse.xtend.core.tests.RuntimeInjectorProvider;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author dhuebner - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(RuntimeInjectorProvider.class)
@SuppressWarnings("all")
public class JavaCodeAnalyzerTest {
  @Inject
  private JavaCodeAnalyzer analyzer;
  
  @Test
  public void testSimpleClass() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.Map;");
    _builder.newLine();
    _builder.append("public class JavaFoo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertJavaTypeIs(_builder, ASTParser.K_COMPILATION_UNIT);
  }
  
  @Test
  public void testSimpleBodyDeclaration_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public  void JavaFoo() {}");
    _builder.newLine();
    this.assertJavaTypeIs(_builder, ASTParser.K_CLASS_BODY_DECLARATIONS);
  }
  
  @Test
  public void testSimpleBodyDeclaratio_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("int i;");
    _builder.newLine();
    this.assertJavaTypeIs(_builder, ASTParser.K_CLASS_BODY_DECLARATIONS);
  }
  
  @Test
  public void testSimpleSatement_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("return true;");
    _builder.newLine();
    this.assertJavaTypeIs(_builder, ASTParser.K_STATEMENTS);
  }
  
  @Test
  public void testSimpleSatement_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("int i = 0;");
    _builder.newLine();
    _builder.append("return i;");
    _builder.newLine();
    JavaCodeAnalyzer.JavaParseResult<? extends ASTNode> _assertJavaTypeIs = this.assertJavaTypeIs(_builder, ASTParser.K_STATEMENTS);
    this.assertNodesCount(_assertJavaTypeIs, 2);
  }
  
  @Test
  public void tesTryCatchSatement_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("try {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("} catch (final Exception e) {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    JavaCodeAnalyzer.JavaParseResult<? extends ASTNode> _assertJavaTypeIs = this.assertJavaTypeIs(_builder, ASTParser.K_STATEMENTS);
    this.assertNodesCount(_assertJavaTypeIs, 1);
  }
  
  public JavaCodeAnalyzer.JavaParseResult<? extends ASTNode> assertNodesCount(final JavaCodeAnalyzer.JavaParseResult<? extends ASTNode> result, final int i) {
    List<? extends ASTNode> _nodes = result.getNodes();
    int _size = _nodes.size();
    Assert.assertEquals(i, _size);
    return result;
  }
  
  @Test
  public void testSimpleExpression() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("true");
    _builder.newLine();
    this.assertJavaTypeIs(_builder, ASTParser.K_EXPRESSION);
  }
  
  public JavaCodeAnalyzer.JavaParseResult<? extends ASTNode> assertJavaTypeIs(final CharSequence sequence, final int type) {
    String _string = sequence.toString();
    final JavaCodeAnalyzer.JavaParseResult<? extends ASTNode> javaParseResult = this.analyzer.determinateJavaType(_string);
    int _type = javaParseResult.getType();
    Assert.assertEquals(type, _type);
    return javaParseResult;
  }
}
