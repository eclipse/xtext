/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.idea.validation;

import com.intellij.openapi.application.Application;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.roots.ContentEntry;
import com.intellij.openapi.roots.ModifiableRootModel;
import com.intellij.openapi.roots.ModuleRootManager;
import com.intellij.openapi.vfs.VfsUtil;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiFile;
import org.eclipse.xtend.idea.LightXtendTest;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtendIdeaValidationTests extends LightXtendTest {
  public void testWrongPackage() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package <error descr=\"The declared package \'my.foo.pack\' does not match the expected package \'\'\">my.foo.pack</error>");
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.configureByText(_builder.toString());
    this.myFixture.checkHighlighting();
  }
  
  public void testExcludedFile() {
    Application _application = ApplicationManager.getApplication();
    final Runnable _function = new Runnable() {
      @Override
      public void run() {
        try {
          Module _module = XtendIdeaValidationTests.this.myFixture.getModule();
          ModuleRootManager _instance = ModuleRootManager.getInstance(_module);
          final ModifiableRootModel model = _instance.getModifiableModel();
          ContentEntry[] _contentEntries = model.getContentEntries();
          final ContentEntry contentEntry = IterableExtensions.<ContentEntry>head(((Iterable<ContentEntry>)Conversions.doWrapArray(_contentEntries)));
          VirtualFile _file = contentEntry.getFile();
          final VirtualFile excludedDir = VfsUtil.createDirectoryIfMissing(_file, "excluded");
          contentEntry.addExcludeFolder(excludedDir);
          model.commit();
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      }
    };
    _application.runWriteAction(_function);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package mypackage");
    _builder.newLine();
    _builder.append("class Foo extends <error descr=\"Bar cannot be resolved to a type.\"><error descr=\"Superclass must be a class\">Bar</error></error> {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    PsiFile _addFileToProject = this.myFixture.addFileToProject("excluded/Foo.xtend", _builder.toString());
    final VirtualFile file = _addFileToProject.getVirtualFile();
    this.myFixture.testHighlighting(true, true, true, file);
  }
}
