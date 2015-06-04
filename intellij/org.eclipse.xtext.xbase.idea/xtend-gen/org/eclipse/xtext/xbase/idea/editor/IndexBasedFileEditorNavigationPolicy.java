/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.idea.editor;

import com.google.common.base.Objects;
import com.intellij.ide.projectView.impl.ProjectViewTree;
import com.intellij.openapi.fileEditor.OpenFileDescriptor;
import com.intellij.openapi.fileEditor.impl.FileEditorNavigationPolicy;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ProjectUtil;
import com.intellij.openapi.vfs.VfsUtil;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.wm.ex.WindowManagerEx;
import java.awt.Component;
import java.io.File;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.builder.standalone.incremental.FilesAndURIs;
import org.eclipse.xtext.builder.standalone.incremental.IndexState;
import org.eclipse.xtext.builder.standalone.incremental.Source2GeneratedMapping;
import org.eclipse.xtext.idea.build.XtextAutoBuilder;
import org.eclipse.xtext.idea.build.XtextCompilerComponent;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * @author kosyakov - Initial contribution and API
 */
@FinalFieldsConstructor
@SuppressWarnings("all")
public class IndexBasedFileEditorNavigationPolicy extends FileEditorNavigationPolicy {
  private final XtextCompilerComponent compilerComponent;
  
  @Override
  public VirtualFile getNavigationFile(final VirtualFile requestedFile) {
    Project _guessProjectForFile = ProjectUtil.guessProjectForFile(requestedFile);
    return this.getSourceFile(requestedFile, _guessProjectForFile);
  }
  
  @Override
  public OpenFileDescriptor getNavigationDescriptor(final OpenFileDescriptor requestedDescriptor) {
    VirtualFile _file = requestedDescriptor.getFile();
    Project _project = requestedDescriptor.getProject();
    final VirtualFile sourceFile = this.getSourceFile(_file, _project);
    boolean _notEquals = (!Objects.equal(sourceFile, null));
    if (_notEquals) {
      Project _project_1 = requestedDescriptor.getProject();
      return new OpenFileDescriptor(_project_1, sourceFile);
    }
    return null;
  }
  
  protected VirtualFile getSourceFile(final VirtualFile generatedFile, final Project project) {
    VirtualFile _xblockexpression = null;
    {
      String _extension = generatedFile.getExtension();
      boolean _notEquals = (!Objects.equal(_extension, "java"));
      if (_notEquals) {
        return null;
      }
      XtextAutoBuilder _autoBuilder = this.compilerComponent.getAutoBuilder();
      final IndexState indexState = _autoBuilder.getIndexState();
      boolean _equals = Objects.equal(indexState, null);
      if (_equals) {
        return null;
      }
      WindowManagerEx _instanceEx = WindowManagerEx.getInstanceEx();
      final Component component = _instanceEx.getFocusedComponent(project);
      if ((component instanceof ProjectViewTree)) {
        return null;
      }
      String _url = generatedFile.getUrl();
      final URI uri = URI.createURI(_url);
      Source2GeneratedMapping _fileMappings = indexState.getFileMappings();
      Iterable<URI> _source = _fileMappings.getSource(uri);
      URI _head = null;
      if (_source!=null) {
        _head=IterableExtensions.<URI>head(_source);
      }
      final URI sourceURI = _head;
      VirtualFile _xifexpression = null;
      boolean _notEquals_1 = (!Objects.equal(sourceURI, null));
      if (_notEquals_1) {
        File _asFile = FilesAndURIs.asFile(sourceURI);
        _xifexpression = VfsUtil.findFileByIoFile(_asFile, true);
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public IndexBasedFileEditorNavigationPolicy(final XtextCompilerComponent compilerComponent) {
    super();
    this.compilerComponent = compilerComponent;
  }
}
