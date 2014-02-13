/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.ide.tests.builder;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFileState;
import org.eclipse.core.resources.IProject;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.builder.EclipseOutputConfigurationProvider;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreAccess;
import org.eclipse.xtext.ui.editor.preferences.PreferenceConstants;
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
  private final static String FILE_NAME = "foo/Foo.xtend";
  
  private final static String GENERATE_FILE_NAME = "../xtend-gen/foo/Foo.java";
  
  private final static String GENERATE_TRACK_FILE_NAME = "../xtend-gen/foo/.Foo.java._trace";
  
  private final static String CONTENT_WITHOUT_BODY = "package foo class Foo {}";
  
  private final static String CONTENT_WITH_BODY = "package foo class Foo { def foo() {} }";
  
  @Inject
  @Extension
  private WorkbenchTestHelper workbenchTestHelper;
  
  @Inject
  @Extension
  private IPreferenceStoreAccess _iPreferenceStoreAccess;
  
  public void setUp() throws Exception {
    super.setUp();
    this.setOverride(true);
    this.setCleanDirectory(false);
    this.setCleanupDerived(true);
  }
  
  @After
  public void tearDown() throws Exception {
    this.workbenchTestHelper.tearDown();
  }
  
  @Test
  public void testTurnOffLocalHistoryKeeping() {
    this.setKeepLocalHistory(false);
    IFile _assertCreateFile = this.assertCreateFile(0);
    final Procedure1<IFile> _function = new Procedure1<IFile>() {
      public void apply(final IFile it) {
        KeepLocalHistoryTest.this.assertChangeContentByAnotherContent(it, 0);
        KeepLocalHistoryTest.this.assertChangeContentByTheSameContent(it, 0);
        KeepLocalHistoryTest.this.setCleanupDerived(false);
        KeepLocalHistoryTest.this.setOverride(false);
        KeepLocalHistoryTest.this.assertChangeContentByAnotherContent(it, 0);
        KeepLocalHistoryTest.this.assertChangeContentByTheSameContent(it, 0);
        KeepLocalHistoryTest.this.setOverride(true);
        KeepLocalHistoryTest.this.setCleanupDerived(true);
        KeepLocalHistoryTest.this.assertDelete(it, 0);
      }
    };
    ObjectExtensions.<IFile>operator_doubleArrow(_assertCreateFile, _function);
    IFile _assertCreateFile_1 = this.assertCreateFile(0);
    final Procedure1<IFile> _function_1 = new Procedure1<IFile>() {
      public void apply(final IFile it) {
        KeepLocalHistoryTest.this.setCleanupDerived(true);
        KeepLocalHistoryTest.this.assertCleanBuild(0);
        KeepLocalHistoryTest.this.setCleanDirectory(true);
        KeepLocalHistoryTest.this.assertCleanBuild(0);
      }
    };
    ObjectExtensions.<IFile>operator_doubleArrow(_assertCreateFile_1, _function_1);
  }
  
  @Test
  public void testTurnOnLocalHistoryKeeping() {
    this.setKeepLocalHistory(true);
    IFile _assertCreateFile = this.assertCreateFile(0);
    final Procedure1<IFile> _function = new Procedure1<IFile>() {
      public void apply(final IFile it) {
        KeepLocalHistoryTest.this.assertChangeContentByAnotherContent(it, 1);
        KeepLocalHistoryTest.this.assertChangeContentByTheSameContent(it, 1);
        KeepLocalHistoryTest.this.setCleanupDerived(false);
        KeepLocalHistoryTest.this.setOverride(false);
        KeepLocalHistoryTest.this.assertChangeContentByAnotherContent(it, 1);
        KeepLocalHistoryTest.this.assertChangeContentByTheSameContent(it, 1);
        KeepLocalHistoryTest.this.setOverride(true);
        KeepLocalHistoryTest.this.setCleanupDerived(true);
        KeepLocalHistoryTest.this.assertDelete(it, 2);
      }
    };
    ObjectExtensions.<IFile>operator_doubleArrow(_assertCreateFile, _function);
    IFile _assertCreateFile_1 = this.assertCreateFile(2);
    final Procedure1<IFile> _function_1 = new Procedure1<IFile>() {
      public void apply(final IFile it) {
        KeepLocalHistoryTest.this.setCleanupDerived(true);
        KeepLocalHistoryTest.this.assertCleanBuild(3);
        KeepLocalHistoryTest.this.setCleanDirectory(true);
        KeepLocalHistoryTest.this.assertCleanBuild(4);
      }
    };
    ObjectExtensions.<IFile>operator_doubleArrow(_assertCreateFile_1, _function_1);
  }
  
  public IFile assertCreateFile(final int expectedLocalHistorySize) {
    try {
      IFile _createFile = this.workbenchTestHelper.createFile(KeepLocalHistoryTest.FILE_NAME, KeepLocalHistoryTest.CONTENT_WITHOUT_BODY);
      final Procedure1<IFile> _function = new Procedure1<IFile>() {
        public void apply(final IFile it) {
          KeepLocalHistoryTest.this.assertGeneratedFiles(expectedLocalHistorySize);
        }
      };
      return ObjectExtensions.<IFile>operator_doubleArrow(_createFile, _function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void assertChangeContentByAnotherContent(final IFile it, final int expectedLocalHistorySize) {
    try {
      XtextEditor _openEditor = this.workbenchTestHelper.openEditor(it);
      final Procedure1<XtextEditor> _function = new Procedure1<XtextEditor>() {
        public void apply(final XtextEditor it) {
          IXtextDocument _document = it.getDocument();
          final String currentContent = _document.get();
          boolean _equals = currentContent.equals(KeepLocalHistoryTest.CONTENT_WITHOUT_BODY);
          if (_equals) {
            IXtextDocument _document_1 = it.getDocument();
            _document_1.set(KeepLocalHistoryTest.CONTENT_WITH_BODY);
          } else {
            IXtextDocument _document_2 = it.getDocument();
            _document_2.set(KeepLocalHistoryTest.CONTENT_WITHOUT_BODY);
          }
          KeepLocalHistoryTest.this.workbenchTestHelper.saveEditor(it, false);
        }
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
      final Procedure1<XtextEditor> _function = new Procedure1<XtextEditor>() {
        public void apply(final XtextEditor it) {
          IXtextDocument _document = it.getDocument();
          IXtextDocument _document_1 = it.getDocument();
          String _get = _document_1.get();
          _document.set(_get);
          KeepLocalHistoryTest.this.workbenchTestHelper.saveEditor(it, false);
        }
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
      String _assertExist = this.assertExist(KeepLocalHistoryTest.GENERATE_FILE_NAME);
      this.assertFileLocalHistory(_assertExist, expectedLocalHistorySize);
      String _assertExist_1 = this.assertExist(KeepLocalHistoryTest.GENERATE_TRACK_FILE_NAME);
      this.assertFileLocalHistoryEmpty(_assertExist_1);
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
      IFile _file = this.workbenchTestHelper.getFile(it);
      boolean _exists = _file.exists();
      Assert.assertTrue(_exists);
      _xblockexpression = it;
    }
    return _xblockexpression;
  }
  
  public void assertFileLocalHistory(final String it, final int expectedLocalHistorySize) {
    try {
      IFile _file = this.workbenchTestHelper.getFile(it);
      IFileState[] _history = _file.getHistory(null);
      int _size = ((List<IFileState>)Conversions.doWrapArray(_history)).size();
      Assert.assertEquals(expectedLocalHistorySize, _size);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void setKeepLocalHistory(final boolean keepLocalHistory) {
    this.setValue(EclipseOutputConfigurationProvider.OUTPUT_KEEP_LOCAL_HISTORY, keepLocalHistory);
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
    IProject _project = this.workbenchTestHelper.getProject();
    IPreferenceStore _writablePreferenceStore = this._iPreferenceStoreAccess.getWritablePreferenceStore(_project);
    String _key = this.getKey(preferenceName);
    _writablePreferenceStore.setValue(_key, value);
  }
  
  public String getKey(final String preferenceName) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(EclipseOutputConfigurationProvider.OUTPUT_PREFERENCE_TAG, "");
    _builder.append(PreferenceConstants.SEPARATOR, "");
    _builder.append(IFileSystemAccess.DEFAULT_OUTPUT, "");
    _builder.append(PreferenceConstants.SEPARATOR, "");
    _builder.append(preferenceName, "");
    return _builder.toString();
  }
}
