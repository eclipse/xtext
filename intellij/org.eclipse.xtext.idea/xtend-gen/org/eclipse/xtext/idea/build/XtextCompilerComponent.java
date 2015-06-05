/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.build;

import com.intellij.openapi.components.AbstractProjectComponent;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.EditorFactory;
import com.intellij.openapi.editor.event.DocumentAdapter;
import com.intellij.openapi.editor.event.DocumentEvent;
import com.intellij.openapi.editor.event.EditorEventMulticaster;
import com.intellij.openapi.fileEditor.FileDocumentManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.vfs.VirtualFileAdapter;
import com.intellij.openapi.vfs.VirtualFileEvent;
import com.intellij.openapi.vfs.VirtualFileManager;
import com.intellij.openapi.vfs.VirtualFileMoveEvent;
import org.eclipse.xtext.idea.build.XtextAutoBuilder;
import org.eclipse.xtext.resource.IResourceDescriptions;

@SuppressWarnings("all")
public class XtextCompilerComponent extends AbstractProjectComponent {
  private XtextAutoBuilder autoBuilder;
  
  private VirtualFileAdapter virtualFileListener;
  
  private DocumentAdapter documentListener;
  
  public XtextCompilerComponent(final Project project) {
    super(project);
    XtextAutoBuilder _xtextAutoBuilder = new XtextAutoBuilder(project);
    this.autoBuilder = _xtextAutoBuilder;
    this.documentListener = new DocumentAdapter() {
      @Override
      public void documentChanged(final DocumentEvent event) {
        FileDocumentManager _instance = FileDocumentManager.getInstance();
        Document _document = event.getDocument();
        VirtualFile file = _instance.getFile(_document);
        XtextCompilerComponent.this.autoBuilder.fileModified(file);
      }
    };
    EditorFactory _instance = EditorFactory.getInstance();
    EditorEventMulticaster _eventMulticaster = _instance.getEventMulticaster();
    _eventMulticaster.addDocumentListener(this.documentListener, project);
    this.virtualFileListener = new VirtualFileAdapter() {
      @Override
      public void contentsChanged(final VirtualFileEvent event) {
        VirtualFile _file = event.getFile();
        XtextCompilerComponent.this.autoBuilder.fileModified(_file);
      }
      
      @Override
      public void fileCreated(final VirtualFileEvent event) {
        VirtualFile _file = event.getFile();
        XtextCompilerComponent.this.autoBuilder.fileAdded(_file);
      }
      
      @Override
      public void fileDeleted(final VirtualFileEvent event) {
        VirtualFile _file = event.getFile();
        XtextCompilerComponent.this.autoBuilder.fileDeleted(_file);
      }
      
      @Override
      public void fileMoved(final VirtualFileMoveEvent event) {
      }
    };
    VirtualFileManager _instance_1 = VirtualFileManager.getInstance();
    _instance_1.addVirtualFileListener(this.virtualFileListener, project);
  }
  
  @Override
  public String getComponentName() {
    return "Xtext Compiler Component";
  }
  
  public IResourceDescriptions getResourceDescriptions() {
    return this.autoBuilder.getResourceDescriptions();
  }
}
