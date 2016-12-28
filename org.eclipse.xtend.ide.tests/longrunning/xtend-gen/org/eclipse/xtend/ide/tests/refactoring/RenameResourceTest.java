package org.eclipse.xtend.ide.tests.refactoring;

import com.google.inject.Inject;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.participants.RenameRefactoring;
import org.eclipse.ltk.internal.core.refactoring.resource.RenameResourceProcessor;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtend.ide.tests.refactoring.FileAsserts;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class RenameResourceTest extends AbstractXtendUITestCase {
  @Inject
  @Extension
  private WorkbenchTestHelper _workbenchTestHelper;
  
  @Inject
  private IWorkspace workspace;
  
  @Inject
  @Extension
  private FileAsserts _fileAsserts;
  
  @Test
  public void testRenameClassWithSameName() {
    try {
      try {
        this._fileAsserts.assertFileContains(this.renameTo(this._workbenchTestHelper.createFile("Foo", "class Foo {}"), "Bar.xtend"), "class Bar {}");
      } finally {
        this._workbenchTestHelper.getFile("Bar.xtend").delete(true, null);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testDontRenameClassWithDifferenName() {
    try {
      try {
        this._fileAsserts.assertFileContains(this.renameTo(this._workbenchTestHelper.createFile("Foo", "class FooBar {}"), "Bar.xtend"), "class FooBar {}");
      } finally {
        this._workbenchTestHelper.getFile("Bar.xtend").delete(true, null);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testGuardMissingFileExtension() {
    try {
      try {
        this._fileAsserts.assertFileContains(this.renameTo(this._workbenchTestHelper.createFile("Foo", "class Foo {}"), "Bar"), "class Foo {}");
      } finally {
        this._workbenchTestHelper.getFile("Bar").delete(true, null);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected IFile renameTo(final IFile file, final String newFileName) {
    try {
      IFile _xblockexpression = null;
      {
        final RenameResourceProcessor renameResourceProcessor = new RenameResourceProcessor(file);
        renameResourceProcessor.setNewResourceName(newFileName);
        final RenameRefactoring renameRefactoring = new RenameRefactoring(renameResourceProcessor);
        NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
        renameRefactoring.checkAllConditions(_nullProgressMonitor);
        NullProgressMonitor _nullProgressMonitor_1 = new NullProgressMonitor();
        final Change change = renameRefactoring.createChange(_nullProgressMonitor_1);
        final IWorkspaceRunnable _function = (IProgressMonitor it) -> {
          change.perform(it);
        };
        NullProgressMonitor _nullProgressMonitor_2 = new NullProgressMonitor();
        this.workspace.run(_function, _nullProgressMonitor_2);
        IProject _project = this._workbenchTestHelper.getProject();
        Path _path = new Path(("src/" + newFileName));
        final IResource newFile = _project.findMember(_path);
        Assert.assertTrue(newFile.exists());
        Assert.assertTrue((newFile instanceof IFile));
        _xblockexpression = ((IFile) newFile);
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
