/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.jvmmodel;

import com.google.common.base.Objects;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @noextend This class is not intended to be subclassed by clients.
 * @noinstantiate This class is not intended to be instantiated by clients.
 * @noreference This class is not intended to be referenced by clients.
 * 
 * @since 2.7
 */
@SuppressWarnings("all")
public class JvmIdentifiableMetaData extends AdapterImpl {
  @Accessors
  private boolean synthetic;
  
  @Override
  public boolean isAdapterForType(final Object type) {
    return Objects.equal(JvmIdentifiableMetaData.class, type);
  }
  
  @Pure
  public boolean isSynthetic() {
    return this.synthetic;
  }
  
  public void setSynthetic(final boolean synthetic) {
    this.synthetic = synthetic;
  }
}
