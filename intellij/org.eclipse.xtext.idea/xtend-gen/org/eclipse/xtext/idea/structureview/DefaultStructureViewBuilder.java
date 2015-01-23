/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.structureview;

import com.google.inject.Inject;
import com.intellij.ide.structureView.StructureView;
import org.eclipse.xtext.idea.structureview.AbstractStructureViewBuilder;
import org.eclipse.xtext.idea.structureview.IStructureViewTreeElementProvider;
import org.eclipse.xtext.idea.structureview.XtextFileTreeModel;

@SuppressWarnings("all")
public class DefaultStructureViewBuilder extends AbstractStructureViewBuilder {
  @Inject
  private IStructureViewTreeElementProvider structureViewTreeElementProvider;
  
  @Override
  public IStructureViewTreeElementProvider createStructureViewTreeElementProvider() {
    return this.structureViewTreeElementProvider;
  }
  
  @Override
  public void configureStructureViewTreeElementProvider(final IStructureViewTreeElementProvider structureViewTreeElementProvider, final XtextFileTreeModel model, final StructureView view) {
  }
}
