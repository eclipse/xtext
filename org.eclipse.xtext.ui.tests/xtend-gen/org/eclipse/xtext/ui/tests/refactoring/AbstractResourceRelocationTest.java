/**
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ui.tests.refactoring;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.Refactoring;
import org.eclipse.ltk.core.refactoring.RefactoringDescriptor;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testlanguages.fileAware.ui.tests.FileAwareTestLanguageUiInjectorProvider;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.runner.RunWith;

/**
 * @author koehnlein - Initial contribution and API
 */
@InjectWith(FileAwareTestLanguageUiInjectorProvider.class)
@RunWith(XtextRunner.class)
@SuppressWarnings("all")
public class AbstractResourceRelocationTest {
  protected IProject project;
  
  @Before
  public void setup() {
    try {
      this.project = IResourcesSetupUtil.createProject("test");
      IResourcesSetupUtil.addNature(this.project, XtextProjectHelper.NATURE_ID);
      IResourcesSetupUtil.addBuilder(this.project, XtextProjectHelper.BUILDER_ID);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @After
  public void teardown() {
    try {
      NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
      this.project.delete(true, true, _nullProgressMonitor);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected IFile file(final String name, final CharSequence content) {
    try {
      String _name = this.project.getName();
      String _plus = (_name + "/");
      String _plus_1 = (_plus + name);
      return IResourcesSetupUtil.createFile(_plus_1, content.toString());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected IFolder folder(final String name) {
    try {
      String _name = this.project.getName();
      String _plus = (_name + "/");
      String _plus_1 = (_plus + name);
      return IResourcesSetupUtil.createFolder(_plus_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected void assertFileContents(final String filePath, final String expected) {
    try {
      IResource _findMember = this.project.findMember(filePath);
      final IFile file = ((IFile) _findMember);
      Assert.assertTrue(file.exists());
      final ByteArrayOutputStream buffer = new ByteArrayOutputStream();
      final byte[] array = new byte[2048];
      int bytesRead = 0;
      final InputStream inp = file.getContents();
      while (((bytesRead = inp.read(array)) != (-1))) {
        buffer.write(array, 0, bytesRead);
      }
      inp.close();
      byte[] _byteArray = buffer.toByteArray();
      String _charset = file.getCharset();
      final String text = new String(_byteArray, _charset);
      Assert.assertEquals(expected, text);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected void performRefactoring(final RefactoringDescriptor descriptor) {
    try {
      this.project.refreshLocal(IResource.DEPTH_INFINITE, null);
      this.project.build(IncrementalProjectBuilder.FULL_BUILD, null);
      final RefactoringStatus status = new RefactoringStatus();
      final Refactoring refactoring = descriptor.createRefactoring(status);
      NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
      refactoring.checkAllConditions(_nullProgressMonitor);
      Assert.assertTrue(status.isOK());
      NullProgressMonitor _nullProgressMonitor_1 = new NullProgressMonitor();
      final Change change = refactoring.createChange(_nullProgressMonitor_1);
      NullProgressMonitor _nullProgressMonitor_2 = new NullProgressMonitor();
      change.perform(_nullProgressMonitor_2);
      this.project.refreshLocal(IResource.DEPTH_INFINITE, null);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
