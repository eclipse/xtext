package org.eclipse.xtend.ide.tests.refactoring;

import com.google.inject.Inject;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.participants.RenameRefactoring;
import org.eclipse.ltk.internal.core.refactoring.resource.RenameResourceProcessor;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtend.ide.tests.refactoring.FileAsserts;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class RenameResourceTest extends AbstractXtendUITestCase {
  @Inject
  private WorkbenchTestHelper _workbenchTestHelper;
  
  @Inject
  private IWorkspace workspace;
  
  @Inject
  private FileAsserts _fileAsserts;
  
  @Test
  public void testRenameClassWithSameName() {
    try {
      try {
        IFile _createFile = this._workbenchTestHelper.createFile("Foo", "class Foo {}");
        IFile _renameTo = this.renameTo(_createFile, "Bar.xtend");
        this._fileAsserts.assertFileContains(_renameTo, "class Bar {}");
      } finally {
        IFile _file = this._workbenchTestHelper.getFile("Bar.xtend");
        _file.delete(true, null);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testDontRenameClassWithDifferenName() {
    try {
      try {
        IFile _createFile = this._workbenchTestHelper.createFile("Foo", "class FooBar {}");
        IFile _renameTo = this.renameTo(_createFile, "Bar.xtend");
        this._fileAsserts.assertFileContains(_renameTo, "class FooBar {}");
      } finally {
        IFile _file = this._workbenchTestHelper.getFile("Bar.xtend");
        _file.delete(true, null);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected IFile renameTo(final IFile file, final String newFileName) {
    try {
      IFile _xblockexpression = null;
      {
        RenameResourceProcessor _renameResourceProcessor = new RenameResourceProcessor(file);
        final RenameResourceProcessor renameResourceProcessor = _renameResourceProcessor;
        renameResourceProcessor.setNewResourceName(newFileName);
        RenameRefactoring _renameRefactoring = new RenameRefactoring(renameResourceProcessor);
        final RenameRefactoring renameRefactoring = _renameRefactoring;
        NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
        renameRefactoring.checkAllConditions(_nullProgressMonitor);
        NullProgressMonitor _nullProgressMonitor_1 = new NullProgressMonitor();
        final Change change = renameRefactoring.createChange(_nullProgressMonitor_1);
        final Procedure1<IProgressMonitor> _function = new Procedure1<IProgressMonitor>() {
            public void apply(final IProgressMonitor it) {
              try {
                change.perform(it);
              } catch (Throwable _e) {
                throw Exceptions.sneakyThrow(_e);
              }
            }
          };
        NullProgressMonitor _nullProgressMonitor_2 = new NullProgressMonitor();
        this.workspace.run(new IWorkspaceRunnable() {
            public void run(IProgressMonitor monitor) {
              _function.apply(monitor);
            }
        }, _nullProgressMonitor_2);
        final IFile newFile = this._workbenchTestHelper.getFile(newFileName);
        boolean _exists = newFile.exists();
        Assert.assertTrue(_exists);
        _xblockexpression = (newFile);
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
