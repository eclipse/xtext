/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.macro.declaration;

import java.util.List;
import org.eclipse.xtend.lib.macro.declaration.ResolvedTypeParameter;
import org.eclipse.xtend.lib.macro.declaration.TypeParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;

@SuppressWarnings("all")
public class ResolvedTypeParameterImpl implements ResolvedTypeParameter {
  private TypeParameterDeclaration declaration;
  
  private List<? extends TypeReference> resolvedUpperBounds;
  
  public ResolvedTypeParameterImpl(final TypeParameterDeclaration declaration, final List<? extends TypeReference> resolvedUpperBounds) {
    this.declaration = declaration;
    this.resolvedUpperBounds = resolvedUpperBounds;
  }
  
  public TypeParameterDeclaration getDeclaration() {
    return this.declaration;
  }
  
  public List<? extends TypeReference> getResolvedUpperBounds() {
    return this.resolvedUpperBounds;
  }
}
