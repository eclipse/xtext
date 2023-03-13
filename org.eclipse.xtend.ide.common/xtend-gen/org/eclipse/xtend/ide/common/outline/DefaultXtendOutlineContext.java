/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.ide.common.outline;

import java.util.Set;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author kosyakov - Initial contribution and API
 */
@Accessors
@SuppressWarnings("all")
public class DefaultXtendOutlineContext implements IXtendOutlineContext {
  private int inheritanceDepth;

  private boolean showInherited;

  private Set<JvmMember> processedMembers;

  public DefaultXtendOutlineContext() {
    this.inheritanceDepth = 0;
    this.showInherited = false;
    this.processedMembers = CollectionLiterals.<JvmMember>newHashSet();
  }

  @Override
  public IXtendOutlineContext newContext() {
    DefaultXtendOutlineContext _cloneContext = this.cloneContext();
    final Procedure1<DefaultXtendOutlineContext> _function = (DefaultXtendOutlineContext it) -> {
      it.processedMembers = CollectionLiterals.<JvmMember>newHashSet();
    };
    return ObjectExtensions.<DefaultXtendOutlineContext>operator_doubleArrow(_cloneContext, _function);
  }

  @Override
  public IXtendOutlineContext showInherited() {
    DefaultXtendOutlineContext _xifexpression = null;
    if (this.showInherited) {
      _xifexpression = this;
    } else {
      DefaultXtendOutlineContext _cloneContext = this.cloneContext();
      final Procedure1<DefaultXtendOutlineContext> _function = (DefaultXtendOutlineContext it) -> {
        it.showInherited = true;
      };
      _xifexpression = ObjectExtensions.<DefaultXtendOutlineContext>operator_doubleArrow(_cloneContext, _function);
    }
    return _xifexpression;
  }

  @Override
  public IXtendOutlineContext hideInherited() {
    DefaultXtendOutlineContext _xifexpression = null;
    if ((!this.showInherited)) {
      _xifexpression = this;
    } else {
      DefaultXtendOutlineContext _cloneContext = this.cloneContext();
      final Procedure1<DefaultXtendOutlineContext> _function = (DefaultXtendOutlineContext it) -> {
        it.showInherited = false;
      };
      _xifexpression = ObjectExtensions.<DefaultXtendOutlineContext>operator_doubleArrow(_cloneContext, _function);
    }
    return _xifexpression;
  }

  @Override
  public IXtendOutlineContext increaseInheritanceDepth() {
    DefaultXtendOutlineContext _cloneContext = this.cloneContext();
    final Procedure1<DefaultXtendOutlineContext> _function = (DefaultXtendOutlineContext it) -> {
      it.inheritanceDepth++;
    };
    return ObjectExtensions.<DefaultXtendOutlineContext>operator_doubleArrow(_cloneContext, _function);
  }

  @Override
  public IXtendOutlineContext decreaseInheritanceDepth() {
    DefaultXtendOutlineContext _xifexpression = null;
    if ((this.inheritanceDepth == 0)) {
      _xifexpression = this;
    } else {
      DefaultXtendOutlineContext _cloneContext = this.cloneContext();
      final Procedure1<DefaultXtendOutlineContext> _function = (DefaultXtendOutlineContext it) -> {
        it.inheritanceDepth--;
      };
      _xifexpression = ObjectExtensions.<DefaultXtendOutlineContext>operator_doubleArrow(_cloneContext, _function);
    }
    return _xifexpression;
  }

  @Override
  public boolean isProcessed(final JvmMember member) {
    return this.processedMembers.contains(member);
  }

  @Override
  public IXtendOutlineContext markAsProcessed(final JvmMember member) {
    DefaultXtendOutlineContext _xblockexpression = null;
    {
      this.processedMembers.add(member);
      _xblockexpression = this;
    }
    return _xblockexpression;
  }

  protected DefaultXtendOutlineContext cloneContext() {
    DefaultXtendOutlineContext _defaultXtendOutlineContext = new DefaultXtendOutlineContext();
    return this.cloneContext(_defaultXtendOutlineContext);
  }

  protected DefaultXtendOutlineContext cloneContext(final DefaultXtendOutlineContext clonedContext) {
    DefaultXtendOutlineContext _xblockexpression = null;
    {
      clonedContext.inheritanceDepth = this.inheritanceDepth;
      clonedContext.showInherited = this.showInherited;
      clonedContext.processedMembers = this.processedMembers;
      _xblockexpression = clonedContext;
    }
    return _xblockexpression;
  }

  @Pure
  @Override
  public int getInheritanceDepth() {
    return this.inheritanceDepth;
  }

  public void setInheritanceDepth(final int inheritanceDepth) {
    this.inheritanceDepth = inheritanceDepth;
  }

  @Pure
  @Override
  public boolean isShowInherited() {
    return this.showInherited;
  }

  public void setShowInherited(final boolean showInherited) {
    this.showInherited = showInherited;
  }

  @Pure
  public Set<JvmMember> getProcessedMembers() {
    return this.processedMembers;
  }

  public void setProcessedMembers(final Set<JvmMember> processedMembers) {
    this.processedMembers = processedMembers;
  }
}
