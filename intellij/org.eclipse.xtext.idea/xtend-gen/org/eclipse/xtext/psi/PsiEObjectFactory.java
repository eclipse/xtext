/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.psi;

import com.google.inject.ImplementedBy;
import com.intellij.lang.ASTNode;
import org.eclipse.xtext.psi.impl.PsiEObjectFactoryImpl;

@ImplementedBy(PsiEObjectFactoryImpl.class)
@SuppressWarnings("all")
public interface PsiEObjectFactory {
  public abstract ASTNode createLeafIdentifier(final String name, final ASTNode context);
  
  public abstract ASTNode createCompositeIdentifier(final String name, final String currentName, final ASTNode context);
}
