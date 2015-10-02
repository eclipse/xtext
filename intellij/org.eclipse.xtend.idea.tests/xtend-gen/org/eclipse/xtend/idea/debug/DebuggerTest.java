/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.idea.debug;

import com.intellij.openapi.module.Module;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.ContentEntry;
import com.intellij.openapi.roots.ModifiableRootModel;
import com.intellij.openapi.vfs.VfsUtil;
import com.intellij.openapi.vfs.VirtualFile;
import org.apache.log4j.Logger;
import org.eclipse.xtend.core.idea.lang.XtendLanguage;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.idea.tests.LibraryUtil;
import org.eclipse.xtext.idea.tests.LightToolingTest;
import org.eclipse.xtext.idea.tests.debug.AbstractDebuggerTestCase;
import org.eclipse.xtext.util.internal.Log;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Pair;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@Log
@SuppressWarnings("all")
public class DebuggerTest extends AbstractDebuggerTestCase {
  @Override
  public void configureModule(final Module module, final ModifiableRootModel model, final ContentEntry entry) {
    try {
      LibraryUtil.addXtendLibrary(model);
      Project _project = this.getProject();
      VirtualFile _baseDir = _project.getBaseDir();
      final VirtualFile srcGenFolder = VfsUtil.createDirectoryIfMissing(_baseDir, "xtend-gen");
      entry.addSourceFolder(srcGenFolder, false);
      String _iD = XtendLanguage.INSTANCE.getID();
      LightToolingTest.addFacetToModule(module, _iD);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void testSimpleDebug() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class MyClass {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def static void main(String[] args) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("println(\"Hello\")");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("println(\"World\")");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      Pair<String, String> _mappedTo = Pair.<String, String>of("MyClass.xtend", _builder.toString());
      final VirtualFile file = this.addFile(_mappedTo);
      this.compile();
      this.addLineBreakpoint(file, 2);
      this.startDebugProcess("MyClass");
      this.assertCurrentLine(file, "println(\"Hello\")");
      this.stepOver();
      this.assertCurrentLine(file, "println(\"World\")");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void testSimpleStepInto() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class MyClass {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def static void main(String[] args) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("doFoo(\"Hello\")");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def static doFoo(String x) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("println(x)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      Pair<String, String> _mappedTo = Pair.<String, String>of("MyClass.xtend", _builder.toString());
      final VirtualFile file = this.addFile(_mappedTo);
      this.compile();
      this.addLineBreakpoint(file, 2);
      this.startDebugProcess("MyClass");
      this.assertCurrentLine(file, "doFoo(\"");
      this.stepInto();
      this.assertCurrentLine(file, "println(x)");
      this.stepOut();
      this.assertCurrentLine(file, "doFoo(\"");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void testXtendAndJavaBackAndForth() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("public class MyJavaClass {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public static void doFoo(String x) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("System.out.println(x);");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      Pair<String, String> _mappedTo = Pair.<String, String>of("MyJavaClass.java", _builder.toString());
      final VirtualFile javaFile = this.addFile(_mappedTo);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("class MyClass {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("def static void main(String[] args) {");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("MyJavaClass.doFoo(\"Hello\")");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("System.out.println(\"done\");");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      Pair<String, String> _mappedTo_1 = Pair.<String, String>of("MyClass.xtend", _builder_1.toString());
      final VirtualFile file = this.addFile(_mappedTo_1);
      this.compile();
      this.addLineBreakpoint(file, 2);
      this.startDebugProcess("MyClass");
      this.assertCurrentLine(file, "MyJavaClass.doFoo(\"");
      this.stepInto();
      this.assertCurrentLine(javaFile, 2);
      this.stepOut();
      this.assertCurrentLine(file, "System.out.println(\"done\");");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void testTemplateExpression_for() {
    try {
      Pair<String, String> _mappedTo = Pair.<String, String>of("MyClass.xtend", "\n\t\t\t\tclass MyClass {\n\t\t\t\t\tdef static void main(String[] args) {\n\t\t\t\t\t\tprintln(foo)\n\t\t\t\t\t}\n\n\t\t\t\t\tdef static foo() \'\'\'\n\t\t\t\t\t\t«FOR x : 1..3»\n\t\t\t\t\t\t\tHello «x»,\n\t\t\t\t\t\t\tThis is a second Line\n\t\t\t\t\t\t«ENDFOR»\n\t\t\t\t\t\'\'\'//END\n\t\t\t\t}\n\t\t");
      final VirtualFile file = this.addFile(_mappedTo);
      this.compile();
      this.addLineBreakpoint(file, 3);
      this.startDebugProcess("MyClass");
      this.stepInto();
      this.stepOver(11);
      this.assertCurrentLine(file, "\'\'\'//END");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void testTemplateExpression_if() {
    try {
      Pair<String, String> _mappedTo = Pair.<String, String>of("MyClass.xtend", "\n\t\t\t\tclass MyClass {\n\t\t\t\t\tdef static void main(String[] args) {\n\t\t\t\t\t\tprintln(foo(\'xyz\'))\n\t\t\t\t\t}\n\t\t\t\t\n\t\t\t\t\tdef static foo(String text) \'\'\'\n\t\t\t\t\t\t«IF text.length>2»\n\t\t\t\t\t\t\tif «foo(\'xy\')»,\n\t\t\t\t\t\t«ELSEIF text.length==2»\n\t\t\t\t\t\t\telseif «foo(\'x\')»,\n\t\t\t\t\t\t«ELSE»\n\t\t\t\t\t\t\telse «text»\n\t\t\t\t\t\t«ENDIF»\n\t\t\t\t\t\'\'\'//END\n\t\t\t\t}\n\t\t");
      final VirtualFile file = this.addFile(_mappedTo);
      this.compile();
      this.addLineBreakpoint(file, 3);
      this.startDebugProcess("MyClass");
      this.stepInto();
      this.stepOver(2);
      this.stepInto();
      this.stepOver(3);
      this.stepInto();
      this.stepOver(4);
      this.assertCurrentLine(file, "text»");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void testSwitch() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class MyClass {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def static void main(String[] args) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("for (i : #[\'fii\',3,\'d\']) {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("switch i {");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("CharSequence case i.length == 1: {");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("println(\'a\')");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("Number case i.intValue == 3 : {");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("println(\'b\')");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("String : {");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("println(\'c\')");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      Pair<String, String> _mappedTo = Pair.<String, String>of("MyClass.xtend", _builder.toString());
      final VirtualFile file = this.addFile(_mappedTo);
      this.compile();
      this.addLineBreakpoint(file, 2);
      this.startDebugProcess("MyClass");
      this.stepOver(5);
      this.assertCurrentLine(file, "println(\'c\')");
      this.stepOver(2);
      this.stepOver(4);
      this.assertCurrentLine(file, "println(\'b\')");
      this.stepOver(3);
      this.stepOver(3);
      this.assertCurrentLine(file, "println(\'a\')");
      this.stepOver(4);
      this.assertCurrentLine(file, "i : #[\'fii\',3,\'d\']");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void testTryCatchFinally() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class MyClass {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def static void main(String[] args) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("call(null)");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("call(new NullPointerException())");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("call(new java.io.IOException())");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def static void call(Throwable t) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("try {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("if (t != null)");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("throw t");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("} catch (NullPointerException e) {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("println(\'npe\')");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("} catch (Throwable e) {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("println(\'other\')");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("} finally {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("println(\'finally\')");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      Pair<String, String> _mappedTo = Pair.<String, String>of("MyClass.xtend", _builder.toString());
      final VirtualFile file = this.addFile(_mappedTo);
      this.compile();
      this.addLineBreakpoint(file, 2);
      this.startDebugProcess("MyClass");
      this.stepInto();
      this.assertCurrentLine(file, "t != null");
      this.stepOver();
      this.assertCurrentLine(file, "println(\'finally\')");
      this.stepOver(3);
      this.assertCurrentLine(file, "call(new NullPointerException())");
      this.stepInto();
      this.assertCurrentLine(file, "t != null");
      this.stepOver(3);
      this.assertCurrentLine(file, "println(\'npe\')");
      this.stepOver(2);
      this.assertCurrentLine(file, "println(\'finally\')");
      this.stepOver(3);
      this.assertCurrentLine(file, "call(new java.io.IOException())");
      this.stepInto();
      this.assertCurrentLine(file, "t != null");
      this.stepOver(4);
      this.assertCurrentLine(file, "println(\'other\')");
      this.stepOver(2);
      this.assertCurrentLine(file, "println(\'finally\')");
      this.stepOver(3);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void testLambda() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class MyClass {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def static void main(String[] args) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("val list = #[1,2,3,4]");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("list.doForEach [");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("println(it)");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("]");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def static void doForEach(java.util.List<Integer> list, (Integer)=>void consumer) {");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("for (i : list) {");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("consumer.apply(i)");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      Pair<String, String> _mappedTo = Pair.<String, String>of("MyClass.xtend", _builder.toString());
      final VirtualFile file = this.addFile(_mappedTo);
      this.compile();
      this.addLineBreakpoint(file, 2);
      this.startDebugProcess("MyClass");
      this.stepOver();
      this.stepInto();
      this.assertCurrentLine(file, "for (i : list) {");
      this.stepOver();
      this.stepInto();
      this.assertCurrentLine(file, "println(it)");
      this.stepOut();
      this.stepOver(12);
      this.assertCurrentLine(file, 6);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private final static Logger LOG = Logger.getLogger(DebuggerTest.class);
}
