package org.eclipse.xtend.ide.tests.refactoring;

import com.google.inject.Inject;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.participants.RenameRefactoring;
import org.eclipse.ltk.internal.core.refactoring.resource.RenameResourceProcessor;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtend.ide.tests.refactoring.ApplyChangeOperation;
import org.eclipse.xtend.ide.tests.refactoring.FileAsserts;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class RenameFileTest extends AbstractXtendUITestCase {
  @Inject
  private WorkbenchTestHelper testHelper;
  
  @Inject
  private FileAsserts _fileAsserts;
  
  public void tearDown() throws Exception {
    this.testHelper.tearDown();
    super.tearDown();
  }
  
  @Test
  public void testRenameClass() {
    try {
      try {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("class Foo {}");
        _builder.newLine();
        final IFile fooFile = this.testHelper.createFile("Foo", _builder.toString());
        IResourcesSetupUtil.waitForAutoBuild();
        RenameResourceProcessor _renameResourceProcessor = new RenameResourceProcessor(fooFile);
        final RenameResourceProcessor processor = _renameResourceProcessor;
        RenameRefactoring _renameRefactoring = new RenameRefactoring(processor);
        final RenameRefactoring refactoring = _renameRefactoring;
        processor.setNewResourceName("Bar.xtend");
        NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
        final RefactoringStatus status = refactoring.checkAllConditions(_nullProgressMonitor);
        String _string = status.toString();
        boolean _hasError = status.hasError();
        Assert.assertFalse(_string, _hasError);
        NullProgressMonitor _nullProgressMonitor_1 = new NullProgressMonitor();
        final Change change = refactoring.createChange(_nullProgressMonitor_1);
        ApplyChangeOperation _applyChangeOperation = new ApplyChangeOperation(change);
        final ApplyChangeOperation applyOperation = _applyChangeOperation;
        NullProgressMonitor _nullProgressMonitor_2 = new NullProgressMonitor();
        applyOperation.run(_nullProgressMonitor_2);
        final IFile barFile = this._fileAsserts.assertFileExists("src/Bar.xtend");
        this._fileAsserts.assertFileContains(barFile, "class Bar {}");
      } finally {
        IProject _project = this.testHelper.getProject();
        IFile _file = _project.getFile("src/Bar.xtend");
        NullProgressMonitor _nullProgressMonitor_3 = new NullProgressMonitor();
        _file.delete(true, _nullProgressMonitor_3);
      }
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testDontRenameClass() {
    try {
      try {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("class FooBar {}");
        _builder.newLine();
        final IFile fooFile = this.testHelper.createFile("Foo", _builder.toString());
        IResourcesSetupUtil.waitForAutoBuild();
        RenameResourceProcessor _renameResourceProcessor = new RenameResourceProcessor(fooFile);
        final RenameResourceProcessor processor = _renameResourceProcessor;
        RenameRefactoring _renameRefactoring = new RenameRefactoring(processor);
        final RenameRefactoring refactoring = _renameRefactoring;
        processor.setNewResourceName("Bar.xtend");
        NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
        final RefactoringStatus status = refactoring.checkAllConditions(_nullProgressMonitor);
        String _string = status.toString();
        boolean _hasError = status.hasError();
        Assert.assertFalse(_string, _hasError);
        NullProgressMonitor _nullProgressMonitor_1 = new NullProgressMonitor();
        final Change change = refactoring.createChange(_nullProgressMonitor_1);
        ApplyChangeOperation _applyChangeOperation = new ApplyChangeOperation(change);
        final ApplyChangeOperation applyOperation = _applyChangeOperation;
        NullProgressMonitor _nullProgressMonitor_2 = new NullProgressMonitor();
        applyOperation.run(_nullProgressMonitor_2);
        final IFile barFile = this._fileAsserts.assertFileExists("src/Bar.xtend");
        this._fileAsserts.assertFileContains(barFile, "class FooBar {}");
      } finally {
        IProject _project = this.testHelper.getProject();
        IFile _file = _project.getFile("src/Bar.xtend");
        NullProgressMonitor _nullProgressMonitor_3 = new NullProgressMonitor();
        _file.delete(true, _nullProgressMonitor_3);
      }
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
