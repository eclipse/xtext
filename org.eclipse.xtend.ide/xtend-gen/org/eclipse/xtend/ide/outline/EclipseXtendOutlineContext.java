/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.ide.outline;

import org.eclipse.xtend.ide.common.outline.DefaultXtendOutlineContext;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author kosyakov - Initial contribution and API
 */
@Accessors
@SuppressWarnings("all")
public class EclipseXtendOutlineContext extends DefaultXtendOutlineContext {
  private IOutlineNode parentNode;

  public EclipseXtendOutlineContext withParentNode(final IOutlineNode parentNode) {
    EclipseXtendOutlineContext _cloneContext = this.cloneContext();
    final Procedure1<EclipseXtendOutlineContext> _function = (EclipseXtendOutlineContext context) -> {
      context.parentNode = parentNode;
    };
    return ObjectExtensions.<EclipseXtendOutlineContext>operator_doubleArrow(_cloneContext, _function);
  }

  @Override
  protected EclipseXtendOutlineContext cloneContext() {
    EclipseXtendOutlineContext _eclipseXtendOutlineContext = new EclipseXtendOutlineContext();
    return this.cloneContext(_eclipseXtendOutlineContext);
  }

  protected EclipseXtendOutlineContext cloneContext(final EclipseXtendOutlineContext clonedContext) {
    EclipseXtendOutlineContext _xblockexpression = null;
    {
      super.cloneContext(clonedContext);
      clonedContext.parentNode = this.parentNode;
      _xblockexpression = clonedContext;
    }
    return _xblockexpression;
  }

  @Pure
  public IOutlineNode getParentNode() {
    return this.parentNode;
  }

  public void setParentNode(final IOutlineNode parentNode) {
    this.parentNode = parentNode;
  }
}
