/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.psi;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.psi.PsiElementProvider;

@SuppressWarnings("all")
public interface IPsiModelAssociator {
  public abstract boolean associate(final EObject eObject, final PsiElementProvider psiElementProvider);
}
