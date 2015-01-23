/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.structureview;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.intellij.ide.structureView.StructureViewBuilder;
import com.intellij.lang.PsiStructureViewFactory;
import com.intellij.psi.PsiFile;
import org.eclipse.xtext.idea.structureview.XtextFileAwareStructureViewBuilder;
import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class DefaultPsiStructureViewFactory implements PsiStructureViewFactory {
  @Inject
  private Provider<XtextFileAwareStructureViewBuilder> structureViewBuilderProvider;
  
  @Override
  public StructureViewBuilder getStructureViewBuilder(final PsiFile psiFile) {
    XtextFileAwareStructureViewBuilder _xifexpression = null;
    if ((psiFile instanceof BaseXtextFile)) {
      XtextFileAwareStructureViewBuilder _get = this.structureViewBuilderProvider.get();
      final Procedure1<XtextFileAwareStructureViewBuilder> _function = new Procedure1<XtextFileAwareStructureViewBuilder>() {
        @Override
        public void apply(final XtextFileAwareStructureViewBuilder it) {
          it.setXtextFile(((BaseXtextFile)psiFile));
        }
      };
      _xifexpression = ObjectExtensions.<XtextFileAwareStructureViewBuilder>operator_doubleArrow(_get, _function);
    }
    return _xifexpression;
  }
}
