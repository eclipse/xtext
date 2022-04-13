/**
 * Copyright (c) 2012, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.ide.tests.refactoring;

import com.google.inject.Inject;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.junit.Assert;

@SuppressWarnings("all")
public class FileAsserts {
  @Inject
  @Extension
  private WorkbenchTestHelper _workbenchTestHelper;

  public IFile assertFileExists(final String fileName) throws Exception {
    IFile _xblockexpression = null;
    {
      final IResource file = this._workbenchTestHelper.getProject().findMember(fileName);
      Assert.assertTrue((fileName + " is not an IFile"), (file instanceof IFile));
      Assert.assertTrue((("File " + fileName) + " doesn\'t exist"), file.exists());
      _xblockexpression = ((IFile) file);
    }
    return _xblockexpression;
  }

  public void assertFileDoesntExists(final String fileName) throws Exception {
    final IResource file = this._workbenchTestHelper.getProject().findMember(fileName);
    Assert.assertNull(file);
  }

  public void assertFileContains(final IFile file, final String... expectedContents) throws Exception {
    file.refreshLocal(IResource.DEPTH_ZERO, null);
    final String fileContents = WorkbenchTestHelper.getContentsAsString(file);
    final Consumer<String> _function = (String expectation) -> {
      boolean _contains = fileContents.contains(expectation);
      boolean _not = (!_contains);
      if (_not) {
        Assert.assertEquals(expectation, fileContents);
      }
    };
    ((List<String>)Conversions.doWrapArray(expectedContents)).forEach(_function);
  }
}
