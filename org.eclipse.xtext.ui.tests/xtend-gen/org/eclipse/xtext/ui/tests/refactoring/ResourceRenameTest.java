/**
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ui.tests.refactoring;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.ltk.core.refactoring.resource.RenameResourceDescriptor;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testlanguages.fileAware.ui.tests.FileAwareTestLanguageUiInjectorProvider;
import org.eclipse.xtext.ui.tests.refactoring.AbstractResourceRelocationTest;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author koehnlein - Initial contribution and API
 */
@InjectWith(FileAwareTestLanguageUiInjectorProvider.class)
@RunWith(XtextRunner.class)
@SuppressWarnings("all")
public class ResourceRenameTest extends AbstractResourceRelocationTest {
  @Test
  public void testRenameDir() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo.bar");
    _builder.newLine();
    _builder.append("element X {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("ref X");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final IFile x = this.file("foo/bar/X.fileawaretestlanguage", _builder);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package foo");
    _builder_1.newLine();
    _builder_1.append("element Y {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("ref bar.X");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.file("foo/Y.fileawaretestlanguage", _builder_1);
    this.performRename(x.getParent(), "baz");
    Assert.assertFalse(x.exists());
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("package foo.baz");
    _builder_2.newLine();
    _builder_2.append("element X {");
    _builder_2.newLine();
    _builder_2.append("\t");
    _builder_2.append("ref X");
    _builder_2.newLine();
    _builder_2.append("}");
    _builder_2.newLine();
    this.assertFileContents("foo/baz/X.fileawaretestlanguage", _builder_2.toString());
    StringConcatenation _builder_3 = new StringConcatenation();
    _builder_3.append("package foo");
    _builder_3.newLine();
    _builder_3.append("element Y {");
    _builder_3.newLine();
    _builder_3.append("\t");
    _builder_3.append("ref baz.X");
    _builder_3.newLine();
    _builder_3.append("}");
    _builder_3.newLine();
    this.assertFileContents("foo/Y.fileawaretestlanguage", _builder_3.toString());
  }
  
  @Test
  public void testRenameDir_2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.append("element X {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("ref X");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.file("foo/X.fileawaretestlanguage", _builder);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package foo.bar");
    _builder_1.newLine();
    _builder_1.append("element Y {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("ref foo.X");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    final IFile y = this.file("foo/bar/Y.fileawaretestlanguage", _builder_1);
    this.performRename(y.getParent(), "baz");
    Assert.assertFalse(y.exists());
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("package foo");
    _builder_2.newLine();
    _builder_2.append("element X {");
    _builder_2.newLine();
    _builder_2.append("\t");
    _builder_2.append("ref X");
    _builder_2.newLine();
    _builder_2.append("}");
    _builder_2.newLine();
    this.assertFileContents("foo/X.fileawaretestlanguage", _builder_2.toString());
    StringConcatenation _builder_3 = new StringConcatenation();
    _builder_3.append("package foo.baz");
    _builder_3.newLine();
    _builder_3.append("element Y {");
    _builder_3.newLine();
    _builder_3.append("\t");
    _builder_3.append("ref foo.X");
    _builder_3.newLine();
    _builder_3.append("}");
    _builder_3.newLine();
    this.assertFileContents("foo/baz/Y.fileawaretestlanguage", _builder_3.toString());
  }
  
  @Test
  public void testRenameCommonDir() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo.bar");
    _builder.newLine();
    _builder.append("element X {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("ref X");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final IFile x = this.file("foo/X.fileawaretestlanguage", _builder);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package foo");
    _builder_1.newLine();
    _builder_1.append("element Y {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("ref X");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    final IFile y = this.file("foo/Y.fileawaretestlanguage", _builder_1);
    this.performRename(x.getParent(), "baz");
    Assert.assertFalse(x.exists());
    Assert.assertFalse(y.exists());
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("package baz");
    _builder_2.newLine();
    _builder_2.append("element X {");
    _builder_2.newLine();
    _builder_2.append("\t");
    _builder_2.append("ref X");
    _builder_2.newLine();
    _builder_2.append("}");
    _builder_2.newLine();
    this.assertFileContents("baz/X.fileawaretestlanguage", _builder_2.toString());
    StringConcatenation _builder_3 = new StringConcatenation();
    _builder_3.append("package baz");
    _builder_3.newLine();
    _builder_3.append("element Y {");
    _builder_3.newLine();
    _builder_3.append("\t");
    _builder_3.append("ref X");
    _builder_3.newLine();
    _builder_3.append("}");
    _builder_3.newLine();
    this.assertFileContents("baz/Y.fileawaretestlanguage", _builder_3.toString());
  }
  
  @Test
  public void testRenameCommonDir_2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo.bar");
    _builder.newLine();
    _builder.append("element X {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("ref X");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final IFile x = this.file("foo/bar/X.fileawaretestlanguage", _builder);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package foo");
    _builder_1.newLine();
    _builder_1.append("element Y {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("ref bar.X");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    final IFile y = this.file("foo/Y.fileawaretestlanguage", _builder_1);
    this.performRename(y.getParent(), "baz");
    Assert.assertFalse(x.exists());
    Assert.assertFalse(y.exists());
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("package baz.bar");
    _builder_2.newLine();
    _builder_2.append("element X {");
    _builder_2.newLine();
    _builder_2.append("\t");
    _builder_2.append("ref X");
    _builder_2.newLine();
    _builder_2.append("}");
    _builder_2.newLine();
    this.assertFileContents("baz/bar/X.fileawaretestlanguage", _builder_2.toString());
    StringConcatenation _builder_3 = new StringConcatenation();
    _builder_3.append("package baz");
    _builder_3.newLine();
    _builder_3.append("element Y {");
    _builder_3.newLine();
    _builder_3.append("\t");
    _builder_3.append("ref bar.X");
    _builder_3.newLine();
    _builder_3.append("}");
    _builder_3.newLine();
    this.assertFileContents("baz/Y.fileawaretestlanguage", _builder_3.toString());
  }
  
  protected void performRename(final IResource theResource, final String theNewName) {
    RenameResourceDescriptor _renameResourceDescriptor = new RenameResourceDescriptor();
    final Procedure1<RenameResourceDescriptor> _function = (RenameResourceDescriptor it) -> {
      it.setResourcePath(theResource.getFullPath());
      it.setNewName(theNewName);
      it.setProject(this.project.getName());
    };
    RenameResourceDescriptor _doubleArrow = ObjectExtensions.<RenameResourceDescriptor>operator_doubleArrow(_renameResourceDescriptor, _function);
    this.performRefactoring(_doubleArrow);
  }
}
