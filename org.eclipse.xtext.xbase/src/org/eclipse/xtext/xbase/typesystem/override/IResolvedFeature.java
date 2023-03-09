/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.override;

import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * A resolved representation of an {@link JvmFeature}.
 */
@SuppressWarnings("all")
public interface IResolvedFeature {
  /**
   * Returns the resolved signature of this feature. The resolved representation of
   * <code>List&lt;String&gt;.addAll(int, Collection&lt;E&gt;)</code> is
   * <code>addAll(int,java.util.Collection&lt;String&gt;)</code>.
   * 
   * @return the resolved signature.
   */
  public abstract String getResolvedSignature();
  
  /**
   * Returns the simple signature of this feature. The simple signature of
   * <code>List&lt;String&gt;.addAll(int, Collection&lt;E&gt;)</code> is
   * <code>addAll(int, Collection&lt;String&gt;)</code>.
   * 
   * @return the simple, human readable signature.
   */
  public abstract String getSimpleSignature();
  
  /**
   * Returns the resolved erased signature of this feature. The resolved representation of
   * <code>List&lt;String&gt;.addAll(int,java.util.Collection&lt;E&gt;)</code> is
   * <code>addAll(int,Collection)</code>.
   * 
   * @return the erased signature.
   */
  public abstract String getResolvedErasureSignature();
  
  /**
   * Returns the declared feature that is resolved.
   * 
   * @return the declaration.
   */
  public abstract JvmFeature getDeclaration();
  
  /**
   * Returns the current context type.
   * 
   * @return the context.
   */
  public abstract LightweightTypeReference getContextType();
  
  /**
   * Returns the resolved type of the declarator of this {@link #getDeclaration() declaration}.
   */
  public abstract LightweightTypeReference getResolvedDeclarator();
}
