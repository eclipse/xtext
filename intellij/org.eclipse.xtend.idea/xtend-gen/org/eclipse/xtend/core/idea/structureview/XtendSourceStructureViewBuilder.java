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
import org.eclipse.xtend.ide.common.outline.XtendOutlineSourceTreeBuilder;
import org.eclipse.xtext.idea.structureview.IStructureViewTreeElementProvider;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtendSourceStructureViewBuilder extends AbstractXtendStructureViewBuilder {
  @Inject
  private Provider<XtendOutlineSourceTreeBuilder> xtendOutlineSourceTreeBuilderProvider;
  
  @Inject
  private Provider<XtendStructureViewTreeElementProvider> xtendStructureViewTreeElementProviderProvider;
  
  @Override
  public IStructureViewTreeElementProvider createStructureViewTreeElementProvider() {
    XtendStructureViewTreeElementProvider _xblockexpression = null;
    {
      final XtendStructureViewTreeElementProvider sourceProvider = this.xtendStructureViewTreeElementProviderProvider.get();
      final XtendOutlineSourceTreeBuilder sourceBuilder = this.xtendOutlineSourceTreeBuilderProvider.get();
      sourceBuilder.setXtendOutlineNodeBuilder(sourceProvider);
      sourceProvider.setXtendOutlineTreeBuilder(sourceBuilder);
      _xblockexpression = sourceProvider;
    }
    return _xblockexpression;
  }
}
