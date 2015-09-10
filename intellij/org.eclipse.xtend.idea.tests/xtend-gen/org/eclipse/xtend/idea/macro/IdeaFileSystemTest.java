/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.idea.macro;

import com.google.inject.Inject;
import com.google.inject.Provider;
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
    protected Object createProject(final String name) {
      return this._ideaFileSystemTest.createModule(name);
    }
    
    @Override
    public void assertToURI(final Path file, final String expectedContent) {
      IdeaResourceSetProvider.VirtualFileBasedUriHandler _find = IdeaResourceSetProvider.VirtualFileBasedUriHandler.find(this._ideaFileSystemTest.resourceSet);
      _find.flushToDisk();
      super.assertToURI(file, expectedContent);
    }
    
    public Delegate(final IdeaFileSystemTest _ideaFileSystemTest) {
      super();
      this._ideaFileSystemTest = _ideaFileSystemTest;
    }
  }
  
  @Inject
  private IdeaResourceSetProvider ideaResourceSetProvider;
  
  @Inject
  private Provider<IdeaFileSystemSupport> fileSystemSupportProvider;
  
  private final IdeaFileSystemTest.Delegate delegate = new IdeaFileSystemTest.Delegate(this);
  
  private XtextResourceSet resourceSet;
  
  @Override
  protected void setUp() throws Exception {
    super.setUp();
    XtendLanguage.INSTANCE.injectMembers(this);
    Module _module = this.getModule();
    XtextResourceSet _get = this.ideaResourceSetProvider.get(_module);
    this.resourceSet = _get;
    final IdeaFileSystemSupport fileSystemSupport = this.fileSystemSupportProvider.get();
    fileSystemSupport.setContext(this.resourceSet);
    this.delegate.setFileSystemSupport(fileSystemSupport);
  }
  
  @Override
  protected Module createMainModule() throws IOException {
    return this.createModule("foo");
  }
  
  @Override
  protected Module createModule(final String moduleName) {
    Module _xblockexpression = null;
    {
      final Module module = super.createModule(moduleName);
      Project _project = this.getProject();
      VirtualFile _baseDir = _project.getBaseDir();
      final VirtualFile moduleDir = PlatformTestCase.createChildDirectory(_baseDir, moduleName);
      final VirtualFile srcDir = PlatformTestCase.createChildDirectory(moduleDir, "src");
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
  
  public void testDeleteWorkspace() {
    delegate.testDeleteWorkspace();
  }
  
  public void testGetFileChildren() {
    delegate.testGetFileChildren();
  }
  
  public void testGetFileURI() {
    delegate.testGetFileURI();
  }
  
  public void testGetFolderChildren() {
    delegate.testGetFolderChildren();
  }
  
  public void testGetFolderURI() {
    delegate.testGetFolderURI();
  }
  
  public void testGetProjectChildren() {
    delegate.testGetProjectChildren();
  }
  
  public void testGetProjectURI() {
    delegate.testGetProjectURI();
  }
  
  public void testGetWorkspaceCharset() {
    delegate.testGetWorkspaceCharset();
  }
  
  public void testGetWorkspaceChildren() {
    delegate.testGetWorkspaceChildren();
  }
  
  public void testGetWorkspaceContent() {
    delegate.testGetWorkspaceContent();
  }
  
  public void testGetWorkspaceContentAsSteam() {
    delegate.testGetWorkspaceContentAsSteam();
  }
  
  public void testGetWorkspaceLastModification() {
    delegate.testGetWorkspaceLastModification();
  }
  
  public void testGetWorkspaceURI() {
    delegate.testGetWorkspaceURI();
  }
  
  public void testMakeAndDeleteFile() {
    delegate.testMakeAndDeleteFile();
  }
  
  public void testMakeAndDeleteFolder() {
    delegate.testMakeAndDeleteFolder();
  }
  
  public void testModificationStamp_01() {
    delegate.testModificationStamp_01();
  }
  
  public void testModificationStamp_02() {
    delegate.testModificationStamp_02();
  }
  
  public void testSetWorkspaceContents() {
    delegate.testSetWorkspaceContents();
  }
  
  public void testSetWorkspaceContentsAsStream() {
    delegate.testSetWorkspaceContentsAsStream();
  }
  
  public void testWorkspaceIsFile() {
    delegate.testWorkspaceIsFile();
  }
  
  public void testWorkspaceIsFolder() {
    delegate.testWorkspaceIsFolder();
  }
}
