/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.ide.tests.editor;

import com.google.inject.Inject;
import java.lang.reflect.Method;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IStorage;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil;
import org.eclipse.xtext.junit4.ui.util.JavaProjectSetupUtil;
import org.eclipse.xtext.ui.editor.model.IResourceForEditorInputFactory;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtendEditorValidationDisabledTest extends AbstractXtendUITestCase {
  @Inject
  private IResourceForEditorInputFactory resourceForEditorInputFactory;
  
  @After
  public void tearDown() throws Exception {
    IResourcesSetupUtil.cleanWorkspace();
  }
  
  @Test
  public void testIsValidationEnabled() {
    try {
      IJavaProject _createJavaProject = JavaProjectSetupUtil.createJavaProject("testProject");
      final Procedure1<IJavaProject> _function = new Procedure1<IJavaProject>() {
        public void apply(final IJavaProject it) {
          try {
            JavaProjectSetupUtil.addSourceFolder(it, "filtered-src", null, new String[] { "**.xtend" });
          } catch (Throwable _e) {
            throw Exceptions.sneakyThrow(_e);
          }
        }
      };
      ObjectExtensions.<IJavaProject>operator_doubleArrow(_createJavaProject, _function);
      final IFile file = IResourcesSetupUtil.createFile("testProject/filtered-src/Foo.xtend", "class Foo {}");
      boolean _isValidationDisabled = this.isValidationDisabled(file);
      Assert.assertTrue(_isValidationDisabled);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testIsValidationDisabled() {
    try {
      IJavaProject _createJavaProject = JavaProjectSetupUtil.createJavaProject("testProject");
      final Procedure1<IJavaProject> _function = new Procedure1<IJavaProject>() {
        public void apply(final IJavaProject it) {
          try {
            JavaProjectSetupUtil.addSourceFolder(it, "filtered-src", null, null);
          } catch (Throwable _e) {
            throw Exceptions.sneakyThrow(_e);
          }
        }
      };
      ObjectExtensions.<IJavaProject>operator_doubleArrow(_createJavaProject, _function);
      final IFile file = IResourcesSetupUtil.createFile("testProject/filtered-src/Foo.xtend", "class Foo {}");
      boolean _isValidationDisabled = this.isValidationDisabled(file);
      Assert.assertFalse(_isValidationDisabled);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public boolean isValidationDisabled(final IStorage storage) {
    try {
      Class<? extends IResourceForEditorInputFactory> _class = this.resourceForEditorInputFactory.getClass();
      final Method method = _class.getDeclaredMethod("isValidationDisabled", IStorage.class);
      method.setAccessible(true);
      try {
        Object _invoke = method.invoke(this.resourceForEditorInputFactory, storage);
        return (((Boolean) _invoke)).booleanValue();
      } catch (Throwable _e) {
        throw Exceptions.sneakyThrow(_e);
      }
    } catch (Throwable _e_1) {
      throw Exceptions.sneakyThrow(_e_1);
    }
  }
}
