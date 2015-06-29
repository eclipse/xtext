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
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.idea.jvmmodel.PsiJvmModelAssociations;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;

/**
 * An equivalent of {@link IJvmModelAssociations IJvmModelAssociations} for PSI model.
 * 
 * @author kosyakov - Initial contribution and API
 * @see IJvmModelAssociations
 */
@ImplementedBy(PsiJvmModelAssociations.class)
@SuppressWarnings("all")
public interface IPsiJvmModelAssociations {
  public abstract Set<PsiElement> getSourceElements(final PsiElement jvmElement);
  
  public abstract Set<PsiElement> getSourceElements(final EObject jvmElement);
  
  public abstract Set<PsiElement> getJvmElements(final PsiElement sourceElement);
  
  public abstract Set<PsiElement> getJvmElements(final EObject sourceElement);
  
  public abstract PsiElement getPrimarySourceElement(final PsiElement jvmElement);
  
  public abstract PsiElement getPrimarySourceElement(final EObject jvmElement);
  
  public abstract PsiElement getPrimaryJvmElement(final PsiElement sourceElement);
  
  public abstract PsiElement getPrimaryJvmElement(final EObject sourceElement);
  
  public abstract boolean isPrimaryJvmElement(final PsiElement jvmElement);
  
  public abstract boolean isPrimaryJvmElement(final EObject jvmElement);
}
