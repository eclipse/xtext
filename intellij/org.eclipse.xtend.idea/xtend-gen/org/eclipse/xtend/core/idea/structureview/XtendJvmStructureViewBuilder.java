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
import org.eclipse.xtend.core.idea.structureview.AbstractXtendStructureViewBuilder;
import org.eclipse.xtend.core.idea.structureview.XtendStructureViewTreeElementProvider;
import org.eclipse.xtend.ide.common.outline.XtendOutlineJvmTreeBuilder;
import org.eclipse.xtext.idea.structureview.IStructureViewTreeElementProvider;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtendJvmStructureViewBuilder extends AbstractXtendStructureViewBuilder {
  @Inject
  private Provider<XtendOutlineJvmTreeBuilder> xtendOutlineJvmTreeBuilderProvider;
  
  @Inject
  private Provider<XtendStructureViewTreeElementProvider> xtendStructureViewTreeElementProviderProvider;
  
  public IStructureViewTreeElementProvider createStructureViewTreeElementProvider() {
    XtendStructureViewTreeElementProvider _xblockexpression = null;
    {
      final XtendStructureViewTreeElementProvider jvmProvider = this.xtendStructureViewTreeElementProviderProvider.get();
      final XtendOutlineJvmTreeBuilder jvmBuilder = this.xtendOutlineJvmTreeBuilderProvider.get();
      jvmBuilder.setXtendOutlineNodeBuilder(jvmProvider);
      jvmProvider.setXtendOutlineTreeBuilder(jvmBuilder);
      _xblockexpression = jvmProvider;
    }
    return _xblockexpression;
  }
}
