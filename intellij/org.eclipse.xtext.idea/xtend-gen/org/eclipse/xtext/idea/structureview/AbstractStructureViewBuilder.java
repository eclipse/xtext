/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.structureview;

import com.intellij.ide.structureView.StructureView;
import com.intellij.ide.structureView.StructureViewFactory;
import com.intellij.openapi.Disposable;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.fileEditor.FileEditor;
import com.intellij.openapi.fileEditor.TextEditor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.Disposer;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.idea.structureview.IStructureViewTreeElementProvider;
import org.eclipse.xtext.idea.structureview.XtextFileAwareStructureViewBuilder;
import org.eclipse.xtext.idea.structureview.XtextFileTreeModel;
import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public abstract class AbstractStructureViewBuilder implements XtextFileAwareStructureViewBuilder {
  @Accessors
  private BaseXtextFile xtextFile;
  
  @Override
  public StructureView createStructureView(final FileEditor fileEditor, final Project project) {
    Editor _xifexpression = null;
    if ((fileEditor instanceof TextEditor)) {
      _xifexpression = ((TextEditor)fileEditor).getEditor();
    } else {
      _xifexpression = null;
    }
    final Editor editor = _xifexpression;
    final XtextFileTreeModel model = this.createStructureViewModel(editor);
    final IStructureViewTreeElementProvider structureViewTreeElementProvider = this.createStructureViewTreeElementProvider();
    model.setStructureViewTreeElementProvider(structureViewTreeElementProvider);
    StructureViewFactory _instance = StructureViewFactory.getInstance(project);
    StructureView view = _instance.createStructureView(fileEditor, model, project, false);
    this.configureStructureViewTreeElementProvider(structureViewTreeElementProvider, model, view);
    Disposer.register(view, new Disposable() {
      @Override
      public void dispose() {
        model.dispose();
      }
    });
    return view;
  }
  
  public XtextFileTreeModel createStructureViewModel(final Editor editor) {
    return new XtextFileTreeModel(this.xtextFile, editor);
  }
  
  public abstract IStructureViewTreeElementProvider createStructureViewTreeElementProvider();
  
  public abstract void configureStructureViewTreeElementProvider(final IStructureViewTreeElementProvider structureViewTreeElementProvider, final XtextFileTreeModel model, final StructureView view);
  
  @Pure
  public BaseXtextFile getXtextFile() {
    return this.xtextFile;
  }
  
  public void setXtextFile(final BaseXtextFile xtextFile) {
    this.xtextFile = xtextFile;
  }
}
