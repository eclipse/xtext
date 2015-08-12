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
 * @author efftinge - Initial contribution and API
 */
@Log
@SuppressWarnings("all")
public class BreakpointTest extends AbstractDebuggerTestCase {
  @Override
  public void configureModule(final Module module, final ModifiableRootModel model, final ContentEntry entry) {
    try {
      LibraryUtil.addXtendLibrary(model);
      Project _project = this.getProject();
      VirtualFile _baseDir = _project.getBaseDir();
      final VirtualFile srcGenFolder = _baseDir.createChildDirectory(null, "xtend-gen");
      entry.addSourceFolder(srcGenFolder, false);
      String _iD = XtendLanguage.INSTANCE.getID();
      LightToolingTest.addFacetToModule(module, _iD);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void testLineBreakpoint() {
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
      this.addLineBreakpoint(file, 3);
      this.startDebugProcess("MyClass");
      this.assertCurrentLine(file, "println(\"Hello\")");
      this.resume();
      this.assertCurrentLine(file, "println(\"World\")");
      this.resume();
      this.assertProcessTerminated();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void testLineBreakpoint_01() {
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
      _builder.append("\t\t");
      _builder.append("foo(\'Hello\',\'Woo\')");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def static void foo(String... woo) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("println(\"Hi\")");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("if (woo.length == 2) {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("println(woo.get(1))");
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
      this.addLineBreakpoint(file, 4);
      this.addLineBreakpoint(file, 14);
      this.addLineBreakpoint(file, 15);
      this.startDebugProcess("MyClass");
      this.assertCurrentLine(file, "foo(\'Hello\',\'Woo\')");
      this.resume();
      this.assertCurrentLine(file, "if (woo.length == 2) {");
      this.resume();
      this.assertCurrentLine(file, "println(woo.get(1))");
      this.resume();
      this.assertProcessTerminated();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void testLineBreakpoint_02() {
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
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("foo [ println(\"World\") ]");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def static void foo(Runnable runnable) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("println(\"Hi\")");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("runnable.run");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      Pair<String, String> _mappedTo = Pair.<String, String>of("MyClass.xtend", _builder.toString());
      final VirtualFile file = this.addFile(_mappedTo);
      this.compile();
      this.addLineBreakpoint(file, 4);
      this.addLineBreakpoint(file, 12);
      this.startDebugProcess("MyClass");
      this.assertCurrentLine(file, "foo [ println(\"World\") ]");
      this.resume();
      this.assertCurrentLine(file, "println(\"Hi\")");
      this.resume();
      this.assertCurrentLine(file, "foo [ println(\"World\") ]");
      this.resume();
      this.assertProcessTerminated();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private final static Logger LOG = Logger.getLogger(BreakpointTest.class);
}
