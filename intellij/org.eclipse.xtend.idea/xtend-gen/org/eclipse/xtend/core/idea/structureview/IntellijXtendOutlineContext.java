/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.idea.structureview;

import org.eclipse.xtend.ide.common.outline.DefaultXtendOutlineContext;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.idea.structureview.ModifiableStructureViewTreeElement;
import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author kosyakov - Initial contribution and API
 */
@Accessors
@SuppressWarnings("all")
public class IntellijXtendOutlineContext extends DefaultXtendOutlineContext {
  private BaseXtextFile xtextFile;
  
  private ModifiableStructureViewTreeElement structureViewTreeElement;
  
  public IntellijXtendOutlineContext withStructureViewTreeElement(final ModifiableStructureViewTreeElement structureViewTreeElement) {
    IntellijXtendOutlineContext _xblockexpression = null;
    {
      this.structureViewTreeElement.addChild(structureViewTreeElement);
      IntellijXtendOutlineContext _cloneContext = this.cloneContext();
      final Procedure1<IntellijXtendOutlineContext> _function = new Procedure1<IntellijXtendOutlineContext>() {
        @Override
        public void apply(final IntellijXtendOutlineContext context) {
          context.structureViewTreeElement = structureViewTreeElement;
        }
      };
      _xblockexpression = ObjectExtensions.<IntellijXtendOutlineContext>operator_doubleArrow(_cloneContext, _function);
    }
    return _xblockexpression;
  }
  
  @Override
  protected IntellijXtendOutlineContext cloneContext() {
    IntellijXtendOutlineContext _intellijXtendOutlineContext = new IntellijXtendOutlineContext();
    return this.cloneContext(_intellijXtendOutlineContext);
  }
  
  protected IntellijXtendOutlineContext cloneContext(final IntellijXtendOutlineContext clonedContext) {
    IntellijXtendOutlineContext _xblockexpression = null;
    {
      super.cloneContext(clonedContext);
      clonedContext.xtextFile = this.xtextFile;
      clonedContext.structureViewTreeElement = this.structureViewTreeElement;
      _xblockexpression = clonedContext;
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
  
  @Pure
  public ModifiableStructureViewTreeElement getStructureViewTreeElement() {
    return this.structureViewTreeElement;
  }
  
  public void setStructureViewTreeElement(final ModifiableStructureViewTreeElement structureViewTreeElement) {
    this.structureViewTreeElement = structureViewTreeElement;
  }
}
