/**
 * Copyright (c) 2013, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.ide.tests.builder;

import com.google.inject.Inject;
import java.lang.reflect.Method;
import java.util.List;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFileState;
import org.eclipse.core.resources.IWorkspaceDescription;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.builder.EclipseOutputConfigurationProvider;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreAccess;
import org.eclipse.xtext.ui.editor.preferences.PreferenceConstants;
import org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class KeepLocalHistoryTest extends AbstractXtendUITestCase {
  private static final String FILE_NAME = "foo/Foo.xtend";

  private static final String GENERATE_FILE_NAME = "../xtend-gen/foo/Foo.java";

  private static final String GENERATE_TRACK_FILE_NAME = "../xtend-gen/foo/.Foo.java._trace";

  private static final String CONTENT_WITHOUT_BODY = "package foo class Foo {}";

  private static final String CONTENT_WITH_BODY = "package foo class Foo { def foo() {} }";

  @Inject
  @Extension
  private WorkbenchTestHelper workbenchTestHelper;

  @Inject
  @Extension
  private IPreferenceStoreAccess _iPreferenceStoreAccess;

  @Override
  public void setUp() throws Exception {
    super.setUp();
    this.setOverride(true);
    this.setCleanDirectory(false);
    this.setCleanupDerived(true);
  }

  @After
  @Override
  public void tearDown() throws Exception {
    this.workbenchTestHelper.tearDown();
  }

  @Test
  public void testTurnOffLocalHistoryKeeping() {
    this.setKeepLocalHistory(false);
    IFile _assertCreateFile = this.assertCreateFile(0);
    final Procedure1<IFile> _function = (IFile it) -> {
      this.assertChangeContentByAnotherContent(it, 0);
      this.assertChangeContentByTheSameContent(it, 0);
      this.setCleanupDerived(false);
      this.setOverride(false);
      this.assertChangeContentByAnotherContent(it, 0);
      this.assertChangeContentByTheSameContent(it, 0);
      this.setOverride(true);
      this.setCleanupDerived(true);
      this.assertDelete(it, 0);
    };
    ObjectExtensions.<IFile>operator_doubleArrow(_assertCreateFile, _function);
    IFile _assertCreateFile_1 = this.assertCreateFile(0);
    final Procedure1<IFile> _function_1 = (IFile it) -> {
      this.setCleanupDerived(true);
      this.assertCleanBuild(0);
      this.setCleanDirectory(true);
      this.assertCleanBuild(0);
    };
    ObjectExtensions.<IFile>operator_doubleArrow(_assertCreateFile_1, _function_1);
  }

  @Test
  public void testTurnOnLocalHistoryKeeping() {
    this.setKeepLocalHistory(true);
    IFile _assertCreateFile = this.assertCreateFile(0);
    final Procedure1<IFile> _function = (IFile it) -> {
      this.assertChangeContentByAnotherContent(it, 1);
      this.assertChangeContentByTheSameContent(it, 1);
      this.setCleanupDerived(false);
      this.setOverride(false);
      this.assertChangeContentByAnotherContent(it, 1);
      this.assertChangeContentByTheSameContent(it, 1);
      this.setOverride(true);
      this.setCleanupDerived(true);
      this.assertDelete(it, 2);
    };
    ObjectExtensions.<IFile>operator_doubleArrow(_assertCreateFile, _function);
    IFile _assertCreateFile_1 = this.assertCreateFile(2);
    final Procedure1<IFile> _function_1 = (IFile it) -> {
      this.setCleanupDerived(true);
      this.assertCleanBuild(3);
      this.setCleanDirectory(true);
      this.assertCleanBuild(4);
    };
    ObjectExtensions.<IFile>operator_doubleArrow(_assertCreateFile_1, _function_1);
  }

  public IFile assertCreateFile(final int expectedLocalHistorySize) {
    try {
      IFile _createFile = this.workbenchTestHelper.createFile(KeepLocalHistoryTest.FILE_NAME, KeepLocalHistoryTest.CONTENT_WITHOUT_BODY);
      final Procedure1<IFile> _function = (IFile it) -> {
        this.assertGeneratedFiles(expectedLocalHistorySize);
      };
      return ObjectExtensions.<IFile>operator_doubleArrow(_createFile, _function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  public void assertChangeContentByAnotherContent(final IFile it, final int expectedLocalHistorySize) {
    try {
      XtextEditor _openEditor = this.workbenchTestHelper.openEditor(it);
      final Procedure1<XtextEditor> _function = (XtextEditor it_1) -> {
        final String currentContent = it_1.getDocument().get();
        boolean _equals = currentContent.equals(KeepLocalHistoryTest.CONTENT_WITHOUT_BODY);
        if (_equals) {
          it_1.getDocument().set(KeepLocalHistoryTest.CONTENT_WITH_BODY);
        } else {
          it_1.getDocument().set(KeepLocalHistoryTest.CONTENT_WITHOUT_BODY);
        }
        this.workbenchTestHelper.saveEditor(it_1, false);
      };
      ObjectExtensions.<XtextEditor>operator_doubleArrow(_openEditor, _function);
      this.assertGeneratedFiles(expectedLocalHistorySize);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  public void assertChangeContentByTheSameContent(final IFile it, final int expectedLocalHistorySize) {
    try {
      XtextEditor _openEditor = this.workbenchTestHelper.openEditor(it);
      final Procedure1<XtextEditor> _function = (XtextEditor it_1) -> {
        it_1.getDocument().set(it_1.getDocument().get());
        this.workbenchTestHelper.saveEditor(it_1, false);
      };
      ObjectExtensions.<XtextEditor>operator_doubleArrow(_openEditor, _function);
      this.assertGeneratedFiles(expectedLocalHistorySize);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  public void assertDelete(final IFile it, final int expectedLocalHistorySize) {
    try {
      it.delete(true, null);
      IResourcesSetupUtil.fullBuild();
      this.assertFileLocalHistory(KeepLocalHistoryTest.GENERATE_FILE_NAME, expectedLocalHistorySize);
      this.assertFileLocalHistoryEmpty(KeepLocalHistoryTest.GENERATE_TRACK_FILE_NAME);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  public void assertCleanBuild(final int expectedLocalHistorySize) {
    try {
      IResourcesSetupUtil.cleanBuild();
      this.assertGeneratedFiles(expectedLocalHistorySize);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  public void assertGeneratedFiles(final int expectedLocalHistorySize) {
    try {
      IResourcesSetupUtil.fullBuild();
      this.assertFileLocalHistory(this.assertExist(KeepLocalHistoryTest.GENERATE_FILE_NAME), expectedLocalHistorySize);
      this.assertFileLocalHistoryEmpty(this.assertExist(KeepLocalHistoryTest.GENERATE_TRACK_FILE_NAME));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  public void assertFileLocalHistoryEmpty(final String it) {
    this.assertFileLocalHistory(it, 0);
  }

  public String assertExist(final String it) {
    String _xblockexpression = null;
    {
      Assert.assertTrue(this.workbenchTestHelper.getFile(it).exists());
      _xblockexpression = it;
    }
    return _xblockexpression;
  }

  public void assertFileLocalHistory(final String it, final int expectedLocalHistorySize) {
    try {
      Assert.assertEquals(expectedLocalHistorySize, ((List<IFileState>)Conversions.doWrapArray(this.workbenchTestHelper.getFile(it).getHistory(null))).size());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  public void setKeepLocalHistory(final boolean keepLocalHistory) {
    try {
      this.setValue(EclipseOutputConfigurationProvider.OUTPUT_KEEP_LOCAL_HISTORY, keepLocalHistory);
      final IWorkspaceDescription description = ResourcesPlugin.getWorkspace().getDescription();
      try {
        final Method setKeepDerivedStateMethod = description.getClass().getDeclaredMethod("setKeepDerivedState", Boolean.TYPE);
        if ((setKeepDerivedStateMethod != null)) {
          setKeepDerivedStateMethod.invoke(description, Boolean.valueOf(keepLocalHistory));
        }
      } catch (final Throwable _t) {
        if (_t instanceof NoSuchMethodException || _t instanceof SecurityException) {
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
      try {
        ResourcesPlugin.getWorkspace().setDescription(description);
      } catch (final Throwable _t) {
        if (_t instanceof CoreException) {
          final CoreException e = (CoreException)_t;
          throw new RuntimeException(e);
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  public void setOverride(final boolean override) {
    this.setValue(EclipseOutputConfigurationProvider.OUTPUT_OVERRIDE, override);
  }

  public void setCleanupDerived(final boolean cleanupDerived) {
    this.setValue(EclipseOutputConfigurationProvider.OUTPUT_CLEANUP_DERIVED, cleanupDerived);
  }

  public void setCleanDirectory(final boolean cleanDirectory) {
    this.setValue(EclipseOutputConfigurationProvider.OUTPUT_CLEAN_DIRECTORY, cleanDirectory);
  }

  public void setValue(final String preferenceName, final boolean value) {
    this._iPreferenceStoreAccess.getWritablePreferenceStore(this.workbenchTestHelper.getProject()).setValue(this.getKey(preferenceName), value);
  }

  public String getKey(final String preferenceName) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(EclipseOutputConfigurationProvider.OUTPUT_PREFERENCE_TAG);
    _builder.append(PreferenceConstants.SEPARATOR);
    _builder.append(IFileSystemAccess.DEFAULT_OUTPUT);
    _builder.append(PreferenceConstants.SEPARATOR);
    _builder.append(preferenceName);
    return _builder.toString();
  }
}
