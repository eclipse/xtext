/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.idea.autobuild;

import com.google.common.io.CharStreams;
import com.google.inject.Provider;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.ModuleRootModificationUtil;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiFile;
import com.intellij.testFramework.PsiTestCase;
import java.io.InputStream;
import java.io.InputStreamReader;
import junit.framework.TestCase;
import org.eclipse.xtend.core.idea.lang.XtendLanguage;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.idea.tests.LightToolingTest;
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
      VirtualFile _parent = null;
      if (_virtualFile!=null) {
        _parent=_virtualFile.getParent();
      }
      VirtualFile _findChild = null;
      if (_parent!=null) {
        _findChild=_parent.findChild("xtend-gen");
      }
      VirtualFile _findChild_1 = null;
      if (_findChild!=null) {
        _findChild_1=_findChild.findChild("OtherClass.java");
      }
      final VirtualFile generatedReferencing = _findChild_1;
      VirtualFile _virtualFile_1 = referenced.getVirtualFile();
      VirtualFile _parent_1 = null;
      if (_virtualFile_1!=null) {
        _parent_1=_virtualFile_1.getParent();
      }
      VirtualFile _findChild_2 = null;
      if (_parent_1!=null) {
        _findChild_2=_parent_1.findChild("xtend-gen");
      }
      VirtualFile _findChild_3 = null;
      if (_findChild_2!=null) {
        _findChild_3=_findChild_2.findChild("MyClass.java");
      }
      final VirtualFile generatedReferenced = _findChild_3;
      TestCase.assertNotNull(generatedReferencing);
      TestCase.assertNotNull(generatedReferenced);
      VirtualFile _virtualFile_2 = referenced.getVirtualFile();
      VirtualFile _parent_2 = _virtualFile_2.getParent();
      VirtualFile _findChild_4 = _parent_2.findChild("xtend-gen");
      VirtualFile _findChild_5 = _findChild_4.findChild("OtherClass.java");
      TestCase.assertNull(_findChild_5);
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
      final Provider<VirtualFile> _function = new Provider<VirtualFile>() {
        @Override
        public VirtualFile get() {
          VirtualFile _virtualFile = referencing.getVirtualFile();
          VirtualFile _parent = _virtualFile.getParent();
          VirtualFile _findChild = _parent.findChild("xtend-gen");
          return _findChild.findChild("OtherClass.java");
        }
      };
      final Provider<VirtualFile> generatedReferencing = _function;
      final Provider<VirtualFile> _function_1 = new Provider<VirtualFile>() {
        @Override
        public VirtualFile get() {
          VirtualFile _virtualFile = referenced.getVirtualFile();
          VirtualFile _parent = _virtualFile.getParent();
          VirtualFile _findChild = _parent.findChild("xtend-gen");
          return _findChild.findChild("MyClass.java");
        }
      };
      final Provider<VirtualFile> generatedReferenced = _function_1;
      VirtualFile _get = generatedReferencing.get();
      TestCase.assertNotNull(_get);
      VirtualFile _get_1 = generatedReferenced.get();
      TestCase.assertNotNull(_get_1);
      VirtualFile _virtualFile = referenced.getVirtualFile();
      VirtualFile _parent = _virtualFile.getParent();
      VirtualFile _findChild = _parent.findChild("xtend-gen");
      VirtualFile _findChild_1 = _findChild.findChild("OtherClass.java");
      TestCase.assertNull(_findChild_1);
      VirtualFile _get_2 = generatedReferencing.get();
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("public class OtherClass /* implements MyClass  */{");
      _builder_2.newLine();
      _builder_2.append("}");
      _builder_2.newLine();
      this.assertFileContains(_get_2, _builder_2.toString());
      VirtualFile _get_3 = generatedReferenced.get();
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("public class MyClass {");
      _builder_3.newLine();
      _builder_3.append("}");
      _builder_3.newLine();
      this.assertFileContains(_get_3, _builder_3.toString());
      ModuleRootModificationUtil.addDependency(moduleB, moduleA);
      VirtualFile _get_4 = generatedReferencing.get();
      StringConcatenation _builder_4 = new StringConcatenation();
      _builder_4.append("public class OtherClass extends MyClass {");
      _builder_4.newLine();
      _builder_4.append("}");
      _builder_4.newLine();
      this.assertFileContains(_get_4, _builder_4.toString());
      VirtualFile _get_5 = generatedReferenced.get();
      StringConcatenation _builder_5 = new StringConcatenation();
      _builder_5.append("public class MyClass {");
      _builder_5.newLine();
      _builder_5.append("}");
      _builder_5.newLine();
      this.assertFileContains(_get_5, _builder_5.toString());
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
  
  @Override
  protected Module createModule(final String moduleName) {
    final Module module = super.createModule(moduleName);
    String _iD = XtendLanguage.INSTANCE.getID();
    LightToolingTest.addFacetToModule(module, _iD);
    return module;
  }
}
