/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.idea.autobuild;

import com.google.common.io.CharStreams;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.ModuleRootModificationUtil;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiFile;
import com.intellij.testFramework.PsiTestCase;
import java.io.InputStream;
import java.io.InputStreamReader;
import junit.framework.TestCase;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.InputOutput;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class MultiModuleTest extends PsiTestCase {
  public void testTwoModulesWithDependency() {
    try {
      final Module moduleA = this.createModule("moduleA");
      final Module moduleB = this.createModule("moduleB");
      ModuleRootModificationUtil.addDependency(moduleB, moduleA);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class OtherClass extends MyClass {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final PsiFile referencing = this.createFile(moduleB, "OtherClass.xtend", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("class MyClass {");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      final PsiFile referenced = this.createFile(moduleA, "MyClass.xtend", _builder_1.toString());
      VirtualFile _virtualFile = referencing.getVirtualFile();
      VirtualFile _parent = _virtualFile.getParent();
      VirtualFile _findChild = _parent.findChild("src-gen");
      final VirtualFile generatedReferencing = _findChild.findChild("OtherClass.java");
      VirtualFile _virtualFile_1 = referenced.getVirtualFile();
      VirtualFile _parent_1 = _virtualFile_1.getParent();
      VirtualFile _findChild_1 = _parent_1.findChild("src-gen");
      final VirtualFile generatedReferenced = _findChild_1.findChild("MyClass.java");
      TestCase.assertNotNull(generatedReferencing);
      TestCase.assertNotNull(generatedReferenced);
      VirtualFile _virtualFile_2 = referenced.getVirtualFile();
      VirtualFile _parent_2 = _virtualFile_2.getParent();
      VirtualFile _findChild_2 = _parent_2.findChild("src-gen");
      VirtualFile _findChild_3 = _findChild_2.findChild("OtherClass.java");
      TestCase.assertNull(_findChild_3);
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("public class OtherClass extends MyClass {");
      _builder_2.newLine();
      _builder_2.append("}");
      _builder_2.newLine();
      this.assertFileContains(generatedReferencing, _builder_2.toString());
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("public class MyClass {");
      _builder_3.newLine();
      _builder_3.append("}");
      _builder_3.newLine();
      this.assertFileContains(generatedReferenced, _builder_3.toString());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void testTwoModulesWithoutDependency() {
    try {
      final Module moduleA = this.createModule("moduleA");
      final Module moduleB = this.createModule("moduleB");
      Project _project = this.getProject();
      VirtualFile _baseDir = _project.getBaseDir();
      InputOutput.<VirtualFile>println(_baseDir);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class OtherClass extends MyClass {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final PsiFile referencing = this.createFile(moduleB, "OtherClass.xtend", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("class MyClass {");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      final PsiFile referenced = this.createFile(moduleA, "MyClass.xtend", _builder_1.toString());
      VirtualFile _virtualFile = referencing.getVirtualFile();
      VirtualFile _parent = _virtualFile.getParent();
      VirtualFile _findChild = _parent.findChild("src-gen");
      final VirtualFile generatedReferencing = _findChild.findChild("OtherClass.java");
      VirtualFile _virtualFile_1 = referenced.getVirtualFile();
      VirtualFile _parent_1 = _virtualFile_1.getParent();
      VirtualFile _findChild_1 = _parent_1.findChild("src-gen");
      final VirtualFile generatedReferenced = _findChild_1.findChild("MyClass.java");
      TestCase.assertNotNull(generatedReferencing);
      TestCase.assertNotNull(generatedReferenced);
      VirtualFile _virtualFile_2 = referenced.getVirtualFile();
      VirtualFile _parent_2 = _virtualFile_2.getParent();
      VirtualFile _findChild_2 = _parent_2.findChild("src-gen");
      VirtualFile _findChild_3 = _findChild_2.findChild("OtherClass.java");
      TestCase.assertNull(_findChild_3);
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("public class OtherClass /* implements MyClass  */{");
      _builder_2.newLine();
      _builder_2.append("}");
      _builder_2.newLine();
      this.assertFileContains(generatedReferencing, _builder_2.toString());
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("public class MyClass {");
      _builder_3.newLine();
      _builder_3.append("}");
      _builder_3.newLine();
      this.assertFileContains(generatedReferenced, _builder_3.toString());
      ModuleRootModificationUtil.addDependency(moduleB, moduleA);
      StringConcatenation _builder_4 = new StringConcatenation();
      _builder_4.append("public class OtherClass extends MyClass {");
      _builder_4.newLine();
      _builder_4.append("}");
      _builder_4.newLine();
      this.assertFileContains(generatedReferencing, _builder_4.toString());
      StringConcatenation _builder_5 = new StringConcatenation();
      _builder_5.append("public class MyClass {");
      _builder_5.newLine();
      _builder_5.append("}");
      _builder_5.newLine();
      this.assertFileContains(generatedReferenced, _builder_5.toString());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void assertFileContains(final VirtualFile file, final String string) {
    try {
      InputStream _inputStream = file.getInputStream();
      InputStreamReader _inputStreamReader = new InputStreamReader(_inputStream);
      final String result = CharStreams.toString(_inputStreamReader);
      TestCase.assertEquals(string, result);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
