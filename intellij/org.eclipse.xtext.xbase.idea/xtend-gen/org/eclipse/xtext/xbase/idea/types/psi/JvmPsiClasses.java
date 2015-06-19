/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.idea.types.psi;

import com.google.inject.Singleton;
import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiElement;
import com.intellij.psi.search.GlobalSearchScope;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

@Singleton
@SuppressWarnings("all")
public class JvmPsiClasses {
  public Iterable<PsiClass> getPsiClassesByName(final BaseXtextFile xtextFile, final String name) {
    return CollectionLiterals.<PsiClass>emptyList();
  }
  
  public Iterable<PsiClass> getPsiClassesByName(final String name, final GlobalSearchScope scope) {
    return CollectionLiterals.<PsiClass>emptyList();
  }
  
  public Iterable<PsiClass> getPsiClassesByQualifiedName(final BaseXtextFile xtextFile, final QualifiedName qualifiedName) {
    return CollectionLiterals.<PsiClass>emptyList();
  }
  
  public Iterable<PsiClass> getPsiClassesByQualifiedName(final QualifiedName qualifiedName, final GlobalSearchScope scope) {
    return CollectionLiterals.<PsiClass>emptyList();
  }
  
  public Iterable<PsiClass> getPsiClasses(final PsiElement element) {
    return CollectionLiterals.<PsiClass>emptyList();
  }
  
  public Iterable<PsiClass> findPsiClasses(final PsiElement element) {
    return CollectionLiterals.<PsiClass>emptyList();
  }
  
  /**
   * Computes a short name from a qualified name. If the qualified name is a name with a name of a nested type,
   * only the innermost name is returned as the short name, e.g {@code 'java.util.Map$Entry'.shortName} yields {@code 'Entry'}
   */
  public String getShortName(final QualifiedName qualifiedName) {
    String _xblockexpression = null;
    {
      final String lastSegment = qualifiedName.getLastSegment();
      final int index = lastSegment.lastIndexOf("$");
      String _xifexpression = null;
      if ((index == (-1))) {
        _xifexpression = lastSegment;
      } else {
        _xifexpression = lastSegment.substring(index);
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
}
