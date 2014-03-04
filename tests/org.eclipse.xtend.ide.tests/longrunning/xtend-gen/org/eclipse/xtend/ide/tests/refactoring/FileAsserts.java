package org.eclipse.xtend.ide.tests.refactoring;

import com.google.inject.Inject;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
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
    final String fileContents = this._workbenchTestHelper.getContents(file);
    final Procedure1<String> _function = new Procedure1<String>() {
      public void apply(final String expectation) {
        boolean _contains = fileContents.contains(expectation);
        boolean _not = (!_contains);
        if (_not) {
          Assert.assertEquals(expectation, fileContents);
        }
      }
    };
    IterableExtensions.<String>forEach(((Iterable<String>)Conversions.doWrapArray(expectedContents)), _function);
  }
}
