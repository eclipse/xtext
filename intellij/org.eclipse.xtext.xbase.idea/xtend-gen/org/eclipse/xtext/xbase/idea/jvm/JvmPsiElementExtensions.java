/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.idea.jvm;

import com.google.inject.Provider;
import com.intellij.openapi.util.Key;
import com.intellij.psi.PsiElement;
import org.eclipse.emf.ecore.EObject;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class JvmPsiElementExtensions {
  public final static Key<EObject> JVM_ELEMENT_KEY = Key.<EObject>create("org.eclipse.xtext.jvm.jvmElement");
  
  public final static Key<Provider<PsiElement>> NAVIGATION_ELEMENT_PROVIDER_KEY = Key.<Provider<PsiElement>>create(
    "org.eclipse.xtext.jvm.navigationElementProvider");
  
  public static EObject getJvmElement(final PsiElement it) {
    return it.<EObject>getUserData(JvmPsiElementExtensions.JVM_ELEMENT_KEY);
  }
  
  public static void setJvmElement(final PsiElement it, final EObject jvmElement) {
    it.<EObject>putUserData(JvmPsiElementExtensions.JVM_ELEMENT_KEY, jvmElement);
  }
  
  public static PsiElement getNavigationElement(final PsiElement it) {
    Provider<PsiElement> _navigationElementProvider = JvmPsiElementExtensions.getNavigationElementProvider(it);
    PsiElement _get = null;
    if (_navigationElementProvider!=null) {
      _get=_navigationElementProvider.get();
    }
    return _get;
  }
  
  public static Provider<PsiElement> getNavigationElementProvider(final PsiElement it) {
    return it.<Provider<PsiElement>>getUserData(JvmPsiElementExtensions.NAVIGATION_ELEMENT_PROVIDER_KEY);
  }
  
  public static void setNavigationElementProvider(final PsiElement it, final Provider<PsiElement> navigationElementProvider) {
    it.<Provider<PsiElement>>putUserData(JvmPsiElementExtensions.NAVIGATION_ELEMENT_PROVIDER_KEY, navigationElementProvider);
  }
}
