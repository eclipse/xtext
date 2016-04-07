package org.eclipse.xtend.ide.tests.refactoring;

import com.google.inject.Inject;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
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
      IProject _project = this._workbenchTestHelper.getProject();
      final IResource file = _project.findMember(fileName);
      Assert.assertTrue((fileName + " is not an IFile"), (file instanceof IFile));
      boolean _exists = file.exists();
      Assert.assertTrue((("File " + fileName) + " doesn\'t exist"), _exists);
      _xblockexpression = ((IFile) file);
    }
    return _xblockexpression;
  }
  
  public void assertFileDoesntExists(final String fileName) throws Exception {
    IProject _project = this._workbenchTestHelper.getProject();
    final IResource file = _project.findMember(fileName);
    Assert.assertNull(file);
  }
  
  public void assertFileContains(final IFile file, final String... expectedContents) throws Exception {
    file.refreshLocal(IResource.DEPTH_ZERO, null);
    final String fileContents = WorkbenchTestHelper.getContentsAsString(file);
    for (final String expectation : expectedContents) {
      boolean _contains = fileContents.contains(expectation);
      boolean _not = (!_contains);
      if (_not) {
        Assert.assertEquals(expectation, fileContents);
      }
    }
  }
}
