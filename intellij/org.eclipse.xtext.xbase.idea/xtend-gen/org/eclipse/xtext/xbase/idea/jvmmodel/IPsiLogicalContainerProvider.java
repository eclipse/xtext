/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.idea.jvmmodel;

import com.google.inject.ImplementedBy;
import com.intellij.psi.PsiElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.idea.jvmmodel.PsiLogicalContainerProvider;
import org.eclipse.xtext.xbase.jvmmodel.ILogicalContainerProvider;

/**
 * An equivalent of {@link ILogicalContainerProvider ILogicalContainerProvider} for PSI model.
 * 
 * @author kosyakov - Initial contribution and API
 * @see ILogicalContainerProvider
 */
@ImplementedBy(PsiLogicalContainerProvider.class)
@SuppressWarnings("all")
public interface IPsiLogicalContainerProvider {
  public abstract PsiElement getNearestLogicalContainer(final PsiElement expr);
  
  public abstract PsiElement getNearestLogicalContainer(final EObject expr);
}
