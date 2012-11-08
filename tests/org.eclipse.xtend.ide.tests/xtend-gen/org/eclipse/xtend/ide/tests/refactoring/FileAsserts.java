package org.eclipse.xtend.ide.tests.refactoring;

import javax.inject.Inject;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.junit.Assert;

@SuppressWarnings("all")
public class FileAsserts {
  @Inject
  private WorkbenchTestHelper _workbenchTestHelper;
  
  public IFile assertFileExists(final String fileName) throws Exception {
    IProject _project = this._workbenchTestHelper.getProject();
    final IResource file = _project.findMember(fileName);
    Assert.assertTrue((file instanceof IFile));
    boolean _exists = file.exists();
    Assert.assertTrue(_exists);
    return ((IFile) file);
  }
  
  public void assertFileContains(final IFile file, final String contents) throws Exception {
    file.refreshLocal(IResource.DEPTH_ZERO, null);
    final String fileContents = this._workbenchTestHelper.getContents(file);
    boolean _contains = fileContents.contains(contents);
    Assert.assertTrue(fileContents, _contains);
  }
}
