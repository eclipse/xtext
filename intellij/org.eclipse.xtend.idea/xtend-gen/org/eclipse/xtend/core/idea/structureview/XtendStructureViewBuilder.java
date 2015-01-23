/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.idea.structureview;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.intellij.ide.structureView.StructureView;
import com.intellij.ide.structureView.impl.StructureViewComposite;
import com.intellij.openapi.fileEditor.FileEditor;
import com.intellij.openapi.project.Project;
import org.eclipse.xtend.core.idea.structureview.XtendJvmStructureViewBuilder;
import org.eclipse.xtend.core.idea.structureview.XtendSourceStructureViewBuilder;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.idea.structureview.XtextFileAwareStructureViewBuilder;
import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtendStructureViewBuilder implements XtextFileAwareStructureViewBuilder {
  @Accessors
  private BaseXtextFile xtextFile;
  
  @Inject
  private Provider<XtendJvmStructureViewBuilder> xtendJvmStructureViewBuilderProvider;
  
  @Inject
  private Provider<XtendSourceStructureViewBuilder> xtendSourceStructureViewBuilderProvider;
  
  @Override
  public StructureView createStructureView(final FileEditor fileEditor, final Project project) {
    StructureViewComposite _xblockexpression = null;
    {
      XtendSourceStructureViewBuilder _get = this.xtendSourceStructureViewBuilderProvider.get();
      final Procedure1<XtendSourceStructureViewBuilder> _function = new Procedure1<XtendSourceStructureViewBuilder>() {
        @Override
        public void apply(final XtendSourceStructureViewBuilder builder) {
          builder.setXtextFile(XtendStructureViewBuilder.this.xtextFile);
        }
      };
      final XtendSourceStructureViewBuilder xtendSourceStructureViewBuilder = ObjectExtensions.<XtendSourceStructureViewBuilder>operator_doubleArrow(_get, _function);
      XtendJvmStructureViewBuilder _get_1 = this.xtendJvmStructureViewBuilderProvider.get();
      final Procedure1<XtendJvmStructureViewBuilder> _function_1 = new Procedure1<XtendJvmStructureViewBuilder>() {
        @Override
        public void apply(final XtendJvmStructureViewBuilder builder) {
          builder.setXtextFile(XtendStructureViewBuilder.this.xtextFile);
        }
      };
      final XtendJvmStructureViewBuilder xtendJvmStructureViewBuilder = ObjectExtensions.<XtendJvmStructureViewBuilder>operator_doubleArrow(_get_1, _function_1);
      StructureView _createStructureView = xtendSourceStructureViewBuilder.createStructureView(fileEditor, project);
      StructureViewComposite.StructureViewDescriptor _structureViewDescriptor = new StructureViewComposite.StructureViewDescriptor(
        "Xtend View", _createStructureView, 
        null);
      StructureView _createStructureView_1 = xtendJvmStructureViewBuilder.createStructureView(fileEditor, project);
      StructureViewComposite.StructureViewDescriptor _structureViewDescriptor_1 = new StructureViewComposite.StructureViewDescriptor(
        "JVM View", _createStructureView_1, 
        null);
      _xblockexpression = new StructureViewComposite(_structureViewDescriptor, _structureViewDescriptor_1);
    }
    return _xblockexpression;
  }
  
  @Pure
  public BaseXtextFile getXtextFile() {
    return this.xtextFile;
  }
  
  public void setXtextFile(final BaseXtextFile xtextFile) {
    this.xtextFile = xtextFile;
  }
}
