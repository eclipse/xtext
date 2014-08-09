/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.smoke;

import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.smoketest.IgnoredBySmokeTest;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class SmokeTestCases extends AbstractXtendTestCase {
  @Test
  public void test_00() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package org.eclipse.xtend.core.tests.smoke");
      _builder.newLine();
      _builder.newLine();
      _builder.append("@Data");
      _builder.newLine();
      _builder.append("class Case_0 {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("int id");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def String foo(String a, String b) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("var list = newArrayList()");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("for(i: 0..list.size - 1) {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("println(i.toString + \" \" + list.get(i))");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("if (isUpper(a)) {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("another(a,b+\'holla\')");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("} else {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("var x = a;");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("for (y : b.toCharArray) {");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("x = x+y");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("x");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def isUpper(String s) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("s.toUpperCase == s");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def another(String x, String y) { ");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("y+x");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.file(_builder.toString());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void test_00_b() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package org.eclipse.xtend.core.tests.smoke");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import org.eclipse.xtend.lib.annotations.Data");
      _builder.newLine();
      _builder.newLine();
      _builder.append("@Data");
      _builder.newLine();
      _builder.append("class Case_0 {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("int id");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def String foo(String a, String b) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("var list = newArrayList()");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("for(i: 0..list.size - 1) {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("println(i.toString + \" \" + list.get(i))");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("if (isUpper(a)) {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("another(a,b+\'holla\')");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("} else {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("var x = a;");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("for (y : b.toCharArray) {");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("x = x+y");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("x");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def isUpper(String s) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("s.toUpperCase == s");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def another(String x, String y) { ");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("y+x");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.file(_builder.toString());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void test_01() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package org.eclipse.xtend.core.tests.smoke");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import org.eclipse.xtend.lib.Property");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Case_1 {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Property");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("int id");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def testFunction1() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("42");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def testFunction2() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("42");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("} ");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def Integer testFunction3() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("42");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("} ");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.file(_builder.toString());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void test_02() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package org.eclipse.xtend.core.tests.smoke");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Case_2 {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def aOrB(String a, String b) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("if (a.isNullOrEmpty()) ");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("b");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("else");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("a ");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def returnInIf() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("if (\'x\'!=\'x\') return \'xx\' else return \'yy\'");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.file(_builder.toString());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void test_03() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package org.eclipse.xtend.core.tests.smoke");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Case_3 {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def testReturnExpression_06() {");
      _builder.newLine();
      _builder.append("\t    ");
      _builder.append("val (Integer) => Integer closure = [Integer i| return i]");
      _builder.newLine();
      _builder.append("\t    ");
      _builder.append("for (x : 1..100) closure.apply(x)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def testReturnExpression_07() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("if (typeof(Case_3) != null) {");
      _builder.newLine();
      _builder.append("\t\t    ");
      _builder.append("val (int)=>int closure = [Integer i| return i]");
      _builder.newLine();
      _builder.append("\t\t    ");
      _builder.append("for (x : 1..100) closure.apply(x)");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def testOverriddenLocalVariable() {");
      _builder.newLine();
      _builder.append("\t  ");
      _builder.append("val x = 3");
      _builder.newLine();
      _builder.append("\t  ");
      _builder.append("var y = 2");
      _builder.newLine();
      _builder.append("\t  ");
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t  \t");
      _builder.append("x.toString // just to get rid of the unused warning");
      _builder.newLine();
      _builder.append("\t    ");
      _builder.append("var x2 = y");
      _builder.newLine();
      _builder.append("\t    ");
      _builder.append("val y2 = 1");
      _builder.newLine();
      _builder.append("\t    ");
      _builder.append("x2+y2");
      _builder.newLine();
      _builder.append("\t  ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def testFeatureCall_03() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("{ ");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("var java.util.List<Character> x = (\'abc\'.toCharArray as Iterable<Character>).toList() ");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("x ");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.file(_builder.toString());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @IgnoredBySmokeTest("see https://bugs.eclipse.org/bugs/show_bug.cgi?id=394277")
  @Test
  public void test_04() {
    try {
      this.file("\n\t\t\tpackage org.eclipse.xtend.core.tests.smoke\n\t\t\t\n\t\t\tclass Case_4 {\n\t\t\t\tdef richStrings_01() {\n\t\t\t\t\t\'\'\'foobar\'\'\'\n\t\t\t\t}\n\t\t\t\tdef richStrings_02()\n\t\t\t\t\t\'\'\'«\'start\'»\n\t\t\t\t\t  first line\n\t\t\t\t\t  second line\n\t\t\t\t    \t\t\'\'\'\n\t\t\t\tdef richStrings_03() {\n\t\t\t\t\t\'\'\'«IF false»foobar«ELSEIF false»foobar«ELSE»zonk«ENDIF»\'\'\'\n\t\t\t\t}\n\t\t\t\tdef richStrings_04() {\n\t\t\t\t\t\'\'\'  «FOR a:\'1\'.toCharArray»«FOR a2:\'1\'.toCharArray»foobar«ENDFOR»«ENDFOR»\'\'\'\n\t\t\t\t}\n\t\t\t\tdef richStrings_05() {\n\t\t\t\t\t\'\'\'\n\t\t\t\t\t\t«FOR a:\'1\'.toCharArray»\n\t\t\t\t\t\t  «FOR a2:\'12\'.toCharArray»foobar«ENDFOR»\n\t\t\t\t\t\t«ENDFOR»\n\t\t\t\t\t\'\'\'\n\t\t\t\t}\n\t\t\t}\n\t\t");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void test_05() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package org.eclipse.xtend.core.tests.smoke");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import com.google.inject.Inject");
      _builder.newLine();
      _builder.append("import java.util.ArrayList");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import static java.util.Arrays.*");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import static extension java.util.Collections.*");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Case_5 {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Inject");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("ArrayList myList");
      _builder.newLine();
      _builder.append("//\tArrayList as list");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Inject extension");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("String s");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def boolean something(int i) {");
      _builder.newLine();
      _builder.append("\t  ");
      _builder.append("if (i.indexOf() == 0) {");
      _builder.newLine();
      _builder.append("//\t    return list.contains(i)");
      _builder.newLine();
      _builder.append("\t    ");
      _builder.append("return myList.contains(i)");
      _builder.newLine();
      _builder.append("\t  ");
      _builder.append("} ");
      _builder.newLine();
      _builder.append("\t  ");
      _builder.append("asList(i)");
      _builder.newLine();
      _builder.append("\t  ");
      _builder.append("i.singletonList()");
      _builder.newLine();
      _builder.append("\t  ");
      _builder.append("false");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.file(_builder.toString());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void test_06() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package org.eclipse.xtend.core.tests.smoke");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import org.eclipse.emf.ecore.EClass");
      _builder.newLine();
      _builder.append("import org.eclipse.emf.ecore.EObject");
      _builder.newLine();
      _builder.append("import org.eclipse.emf.ecore.EPackage");
      _builder.newLine();
      _builder.append("import org.eclipse.emf.ecore.EStructuralFeature");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Case_6 {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def dispatch transform(EPackage packageDecl) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("packageDecl.eContents.map(e | transform(e as EStructuralFeature))");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def dispatch transform(EStructuralFeature entity) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("val inferredType = null");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("newArrayList(inferredType as EObject) \t ");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def dispatch transform(EClass model) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("model.ETypeParameters.map(e| transform(e))");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.file(_builder.toString());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void test_07() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package org.eclipse.xtend.core.tests.smoke");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import java.util.Map");
      _builder.newLine();
      _builder.append("import java.util.List");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Case_7 {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def bug345449() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("val result = <Map$Entry<String, List<String>>>newArrayList()");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("result?.head");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def Object bug345452() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("var CharSequence x = null");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("if(x instanceof Map$Entry)");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("null");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.file(_builder.toString());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void test_08() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package org.eclipse.xtend.core.tests.smoke");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import com.google.inject.Inject");
      _builder.newLine();
      _builder.append("import java.util.List");
      _builder.newLine();
      _builder.append("import org.eclipse.emf.ecore.EObject");
      _builder.newLine();
      _builder.append("import org.eclipse.emf.ecore.util.EcoreUtil");
      _builder.newLine();
      _builder.append("import org.eclipse.xtext.junit4.util.ParseHelper");
      _builder.newLine();
      _builder.append("import org.eclipse.xtext.naming.IQualifiedNameProvider");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import static org.junit.Assert.*");
      _builder.newLine();
      _builder.newLine();
      _builder.append("@SuppressWarnings(\"all\")");
      _builder.newLine();
      _builder.append("class Case_8 {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("    ");
      _builder.append("@Inject");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("extension ParseHelper<EObject> helper");
      _builder.newLine();
      _builder.newLine();
      _builder.append("    ");
      _builder.append("@Inject");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("extension IQualifiedNameProvider qualifiedNameProvider");
      _builder.newLine();
      _builder.newLine();
      _builder.append("    ");
      _builder.append("def getErrors(EObject obj) {");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("obj.eResource.errors");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("    ");
      _builder.append("def resolve(EObject obj) {");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("EcoreUtil::resolveAll(obj.eResource)");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("    ");
      _builder.append("def parseAcme(CharSequence seq) {");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("seq.parse.eContents.head");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("    ");
      _builder.append("@Inject");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("def explicitName() {");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("val element = \'");
      _builder.append("\'\'");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("com.acme.SimpleElement as FooBar {}");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("\'\'");
      _builder.append("\'.parseAcme");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("assertEquals(\"FooBar\", element.fullyQualifiedName.toString)");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def <T1  extends  Object> List<List<T1>> foo(T1 t) {");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("return null");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.file(_builder.toString());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void test_09() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("/*");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* generated by Xtext");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("*/");
      _builder.newLine();
      _builder.append("package org.eclipse.xtend.core.tests.smoke");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import org.eclipse.emf.ecore.ENamedElement");
      _builder.newLine();
      _builder.append("import org.eclipse.emf.ecore.EObject");
      _builder.newLine();
      _builder.append("import java.util.List");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Case_9 extends Case_8 {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def dispatch CharSequence generateTypeRef(ENamedElement c) {");
      _builder.newLine();
      _builder.append("\t\t  ");
      _builder.append("if (c.eContainer != null)");
      _builder.newLine();
      _builder.append("\t\t    ");
      _builder.append("c.eContainer.generateTypeRef");
      _builder.newLine();
      _builder.append("\t\t  ");
      _builder.append("else if (c.eIsProxy)");
      _builder.newLine();
      _builder.append("\t\t    ");
      _builder.append("\'\'");
      _builder.append("\'");
      _builder.append("«", "\t\t    ");
      _builder.append("c.name»\'");
      _builder.append("\'\'");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t  ");
      _builder.append("else");
      _builder.newLine();
      _builder.append("\t\t    ");
      _builder.append("\'\'");
      _builder.append("\'\'");
      _builder.append("\'\'");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def dispatch CharSequence generateTypeRef(EObject o) {");
      _builder.newLine();
      _builder.append("\t  \t");
      _builder.append("o.eContainer.generateTypeRef");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}  ");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("override <T1> /*List<List<T1>>*/ foo(T1 t) {");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("val List<List<T1>> x = super.foo(t)");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("return null");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.file(_builder.toString());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void test_14() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package org.eclipse.xtend.core.tests.smoke");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import com.google.inject.Inject");
      _builder.newLine();
      _builder.append("import org.eclipse.emf.common.util.URI");
      _builder.newLine();
      _builder.append("import org.eclipse.emf.ecore.EcoreFactory");
      _builder.newLine();
      _builder.append("import org.eclipse.xtend.core.tests.AbstractXtendTestCase");
      _builder.newLine();
      _builder.append("import org.eclipse.xtext.common.types.JvmConstructor");
      _builder.newLine();
      _builder.append("import org.eclipse.xtext.common.types.JvmDeclaredType");
      _builder.newLine();
      _builder.append("import org.eclipse.xtext.common.types.JvmGenericType");
      _builder.newLine();
      _builder.append("import org.eclipse.xtext.resource.DerivedStateAwareResource");
      _builder.newLine();
      _builder.append("import org.eclipse.xtext.resource.XtextResourceSet");
      _builder.newLine();
      _builder.append("import org.eclipse.xtext.xbase.jvmmodel.JvmModelAssociator");
      _builder.newLine();
      _builder.append("import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder");
      _builder.newLine();
      _builder.append("import org.junit.Test");
      _builder.newLine();
      _builder.append("import org.junit.Ignore");
      _builder.newLine();
      _builder.newLine();
      _builder.append("@Ignore");
      _builder.newLine();
      _builder.append("class Case_14 extends AbstractXtendTestCase {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("       ");
      _builder.append("@Inject extension JvmTypesBuilder");
      _builder.newLine();
      _builder.append("       ");
      _builder.append("@Inject JvmModelAssociator assoc");
      _builder.newLine();
      _builder.append("       ");
      _builder.append("@Inject XtextResourceSet resourceSet");
      _builder.newLine();
      _builder.append("       ");
      _builder.append("@Inject DerivedStateAwareResource resource");
      _builder.newLine();
      _builder.newLine();
      _builder.append("       ");
      _builder.append("@Test");
      _builder.newLine();
      _builder.append("       ");
      _builder.append("def void testInference() {");
      _builder.newLine();
      _builder.append("               ");
      _builder.append("assoc.inferrer = [obj, acceptor, preIndexing|");
      _builder.newLine();
      _builder.append("                       ");
      _builder.append("val firstType = obj.toClass(\'foo.Bar\')");
      _builder.newLine();
      _builder.append("                       ");
      _builder.append("val secondType = obj.toClass(\'foo.Baz\')");
      _builder.newLine();
      _builder.append("                       ");
      _builder.append("assertNull(secondType.eResource)");
      _builder.newLine();
      _builder.append("                       ");
      _builder.append("acceptor.accept(firstType).initializeLater[");
      _builder.newLine();
      _builder.append("                               ");
      _builder.append("^abstract = true");
      _builder.newLine();
      _builder.append("                               ");
      _builder.append("assertNotNull(firstType.eResource)");
      _builder.newLine();
      _builder.append("                               ");
      _builder.append("assertNotNull(secondType.eResource)");
      _builder.newLine();
      _builder.append("                       ");
      _builder.append("]");
      _builder.newLine();
      _builder.append("                       ");
      _builder.append("acceptor.accept(secondType).initializeLater[");
      _builder.newLine();
      _builder.append("                               ");
      _builder.append("^abstract = true");
      _builder.newLine();
      _builder.append("                               ");
      _builder.append("assertNotNull(firstType.eResource)");
      _builder.newLine();
      _builder.append("                       ");
      _builder.append("]");
      _builder.newLine();
      _builder.append("               ");
      _builder.append("]");
      _builder.newLine();
      _builder.append("               ");
      _builder.append("resource.setDerivedStateComputer(null)");
      _builder.newLine();
      _builder.append("               ");
      _builder.append("resource.URI = URI::createURI(\'foo.txt\')");
      _builder.newLine();
      _builder.append("               ");
      _builder.append("resourceSet.classpathURIContext = getClass()");
      _builder.newLine();
      _builder.append("               ");
      _builder.append("resourceSet.resources += resource");
      _builder.newLine();
      _builder.append("               ");
      _builder.append("resource.contents += EcoreFactory::eINSTANCE.createEClass");
      _builder.newLine();
      _builder.append("               ");
      _builder.append("assoc.installDerivedState(resource,true)");
      _builder.newLine();
      _builder.append("               ");
      _builder.append("assertFalse((resource.contents.get(1) as JvmDeclaredType).^abstract)");
      _builder.newLine();
      _builder.newLine();
      _builder.append("               ");
      _builder.append("resource.contents.clear");
      _builder.newLine();
      _builder.append("               ");
      _builder.append("resource.contents += EcoreFactory::eINSTANCE.createEClass");
      _builder.newLine();
      _builder.append("               ");
      _builder.append("assoc.installDerivedState(resource,false)");
      _builder.newLine();
      _builder.append("               ");
      _builder.append("val type = (resource.contents.get(1) as JvmGenericType)");
      _builder.newLine();
      _builder.append("               ");
      _builder.append("assertTrue(type.^abstract)");
      _builder.newLine();
      _builder.newLine();
      _builder.append("               ");
      _builder.append("// test extends object and default constructor");
      _builder.newLine();
      _builder.append("               ");
      _builder.append("assertEquals(1, type.members.filter(typeof(JvmConstructor)).size)");
      _builder.newLine();
      _builder.append("               ");
      _builder.append("assertEquals(\"java.lang.Object\", type.superTypes.head?.qualifiedName)");
      _builder.newLine();
      _builder.append("       ");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.file(_builder.toString());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
