/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.ide.common.outline;

import org.eclipse.xtext.common.types.JvmMember;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public interface IXtendOutlineContext {
  public abstract IXtendOutlineContext newContext();
  
  public abstract boolean isShowInherited();
  
  public abstract IXtendOutlineContext showInherited();
  
  public abstract IXtendOutlineContext hideInherited();
  
  public abstract int getInheritanceDepth();
  
  public abstract IXtendOutlineContext increaseInheritanceDepth();
  
  public abstract IXtendOutlineContext decreaseInheritanceDepth();
  
  public abstract boolean isProcessed(final JvmMember member);
  
  public abstract IXtendOutlineContext markAsProcessed(final JvmMember member);
}
