/**
 * Copyright (c) 2014, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
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
