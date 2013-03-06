package org.eclipse.xtend.ide.tests.refactoring;

import javax.inject.Inject;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtend2.lib.StringConcatenation;
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
      Assert.assertTrue((file instanceof IFile));
      boolean _exists = file.exists();
      Assert.assertTrue(_exists);
      _xblockexpression = (((IFile) file));
    }
    return _xblockexpression;
  }
  
  public void assertFileContains(final IFile file, final String expectedContents) throws Exception {
    file.refreshLocal(IResource.DEPTH_ZERO, null);
    final String fileContents = this._workbenchTestHelper.getContents(file);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Substring \'");
    _builder.append(expectedContents, "");
    _builder.append("\' not found in \'");
    _builder.append(fileContents, "");
    _builder.append("\' ");
    boolean _contains = fileContents.contains(expectedContents);
    Assert.assertTrue(_builder.toString(), _contains);
  }
}
