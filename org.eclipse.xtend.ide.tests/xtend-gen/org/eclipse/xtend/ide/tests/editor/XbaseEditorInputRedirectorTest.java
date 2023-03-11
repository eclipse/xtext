/**
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.ide.tests.editor;

import com.google.inject.Inject;
import org.eclipse.core.resources.IFile;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.ide.ResourceUtil;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.ui.editor.XbaseEditorInputRedirector;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class XbaseEditorInputRedirectorTest extends AbstractXtendUITestCase {
  @Inject
  @Extension
  private WorkbenchTestHelper helper;

  @Inject
  private XbaseEditorInputRedirector redirector;

  @After
  @Override
  public void tearDown() {
    try {
      this.helper.tearDown();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testOpenDerivedFileFromBin() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package mypack");
      _builder.newLine();
      _builder.append("class HelloXtend {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def void doStuff() {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final IFile fileInSrc = this.helper.createFileImpl((WorkbenchTestHelper.TESTPROJECT_NAME + "/src/mypack/HelloXtend.xtend"), _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package mypack");
      _builder_1.newLine();
      _builder_1.append("class HelloXtend {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("def void doStuff() {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      final IFile fileInBin = this.helper.createFileImpl((WorkbenchTestHelper.TESTPROJECT_NAME + "/bin/mypack/HelloXtend.xtend"), _builder_1.toString());
      FileEditorInput _fileEditorInput = new FileEditorInput(fileInBin);
      final IEditorInput result = this.redirector.findOriginalSource(_fileEditorInput);
      Assert.assertEquals(fileInSrc, ResourceUtil.getFile(result));
      FileEditorInput _fileEditorInput_1 = new FileEditorInput(fileInSrc);
      final IEditorInput result2 = this.redirector.findOriginalSource(_fileEditorInput_1);
      Assert.assertEquals(fileInSrc, ResourceUtil.getFile(result2));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
