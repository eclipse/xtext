/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.idea.macro;

import com.google.inject.Inject;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.ContentEntry;
import com.intellij.openapi.roots.ModifiableRootModel;
import com.intellij.openapi.roots.ModuleRootModificationUtil;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.testFramework.PlatformTestCase;
import com.intellij.testFramework.PsiTestCase;
import com.intellij.util.Consumer;
import java.io.IOException;
import java.util.List;
import junit.framework.TestCase;
import org.eclipse.xtend.core.idea.lang.XtendLanguage;
import org.eclipse.xtend.core.idea.macro.IdeaFileSystemSupport;
import org.eclipse.xtend.core.tests.macro.JavaIoFileSystemTest;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtend.lib.macro.file.MutableFileSystemSupport;
import org.eclipse.xtend.lib.macro.file.Path;
import org.eclipse.xtext.idea.resource.IdeaResourceSetProvider;
import org.eclipse.xtext.idea.tests.TestDecorator;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * @author kosyakov - Initial contribution and API
 */
@TestDecorator
@SuppressWarnings("all")
public class IdeaFileSystemTest extends PsiTestCase {
  @FinalFieldsConstructor
  private static class Delegate extends JavaIoFileSystemTest {
    @Extension
    private final IdeaFileSystemTest _ideaFileSystemTest;
    
    public void setFileSystemSupport(final MutableFileSystemSupport fileSystemSupport) {
      this.fs = fileSystemSupport;
    }
    
    @Override
    public void testGetWorkspaceChildren() {
      Iterable<? extends Path> _children = this.fs.getChildren(Path.ROOT);
      final Function1<Path, CharSequence> _function = new Function1<Path, CharSequence>() {
        @Override
        public CharSequence apply(final Path it) {
          List<String> _segments = it.getSegments();
          return IterableExtensions.join(_segments, ".");
        }
      };
      String _join = IterableExtensions.join(_children, "[", ", ", "]", _function);
      Iterable<? extends Path> _children_1 = this.fs.getChildren(Path.ROOT);
      int _size = IterableExtensions.size(_children_1);
      TestCase.assertEquals(_join, 1, _size);
      this._ideaFileSystemTest.createModule("bar");
      Iterable<? extends Path> _children_2 = this.fs.getChildren(Path.ROOT);
      final Function1<Path, CharSequence> _function_1 = new Function1<Path, CharSequence>() {
        @Override
        public CharSequence apply(final Path it) {
          List<String> _segments = it.getSegments();
          return IterableExtensions.join(_segments, ".");
        }
      };
      String _join_1 = IterableExtensions.join(_children_2, "[", ", ", "]", _function_1);
      Iterable<? extends Path> _children_3 = this.fs.getChildren(Path.ROOT);
      int _size_1 = IterableExtensions.size(_children_3);
      TestCase.assertEquals(_join_1, 2, _size_1);
    }
    
    public Delegate(final IdeaFileSystemTest _ideaFileSystemTest) {
      super();
      this._ideaFileSystemTest = _ideaFileSystemTest;
    }
  }
  
  @Inject
  private IdeaResourceSetProvider ideaResourceSetProvider;
  
  private final IdeaFileSystemTest.Delegate delegate = new IdeaFileSystemTest.Delegate(this);
  
  @Override
  protected void setUp() throws Exception {
    super.setUp();
    XtendLanguage.INSTANCE.injectMembers(this);
    IdeaFileSystemSupport _ideaFileSystemSupport = new IdeaFileSystemSupport();
    final Procedure1<IdeaFileSystemSupport> _function = new Procedure1<IdeaFileSystemSupport>() {
      @Override
      public void apply(final IdeaFileSystemSupport it) {
        Module _module = IdeaFileSystemTest.this.getModule();
        XtextResourceSet _get = IdeaFileSystemTest.this.ideaResourceSetProvider.get(_module);
        it.setContext(_get);
      }
    };
    IdeaFileSystemSupport _doubleArrow = ObjectExtensions.<IdeaFileSystemSupport>operator_doubleArrow(_ideaFileSystemSupport, _function);
    this.delegate.setFileSystemSupport(_doubleArrow);
  }
  
  @Override
  protected Module createMainModule() throws IOException {
    return this.createModule("foo");
  }
  
  @Override
  protected Module createModule(final String moduleName) {
    Module _xblockexpression = null;
    {
      Project _project = this.getProject();
      VirtualFile _baseDir = _project.getBaseDir();
      final VirtualFile moduleDir = PlatformTestCase.createChildDirectory(_baseDir, moduleName);
      final VirtualFile srcDir = PlatformTestCase.createChildDirectory(moduleDir, "src");
      final Module module = super.createModule(moduleName);
      final Consumer<ModifiableRootModel> _function = new Consumer<ModifiableRootModel>() {
        @Override
        public void consume(final ModifiableRootModel rootModel) {
          final ContentEntry contentEntry = rootModel.addContentEntry(moduleDir);
          contentEntry.addSourceFolder(srcDir, false);
        }
      };
      ModuleRootModificationUtil.updateModel(module, _function);
      _xblockexpression = module;
    }
    return _xblockexpression;
  }
  
  public void testGetFileChildren() {
    delegate.testGetFileChildren();
  }
  
  public void testGetFolderChildren() {
    delegate.testGetFolderChildren();
  }
  
  public void testGetProjectChildren() {
    delegate.testGetProjectChildren();
  }
  
  public void testGetURI() {
    delegate.testGetURI();
  }
  
  public void testGetWorkspaceChildren() {
    delegate.testGetWorkspaceChildren();
  }
  
  public void testMakeandDeleteFile() {
    delegate.testMakeandDeleteFile();
  }
  
  public void testMakeandDeleteFolder() {
    delegate.testMakeandDeleteFolder();
  }
  
  public void testModificationStamp() {
    delegate.testModificationStamp();
  }
}
