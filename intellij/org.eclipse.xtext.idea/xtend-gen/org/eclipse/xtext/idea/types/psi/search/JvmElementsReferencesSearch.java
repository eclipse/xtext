package org.eclipse.xtext.idea.types.psi.search;

import com.google.inject.Inject;
import org.eclipse.xtext.idea.lang.IXtextLanguage;
import org.eclipse.xtext.psi.IPsiModelAssociations;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class JvmElementsReferencesSearch /* implements QueryExecutorBase<PsiReference, ReferencesSearch.SearchParameters>  */{
  @Inject
  @Extension
  private IPsiModelAssociations _iPsiModelAssociations;
  
  @Inject
  @Extension
  private IJvmModelAssociations _iJvmModelAssociations;
  
  private final IXtextLanguage language;
  
  public JvmElementsReferencesSearch(final IXtextLanguage language) {
    this.language = language;
    this.language.injectMembers(this);
  }
  
  public void processQuery(final /* SearchParameters */Object queryParameters, final /* Processor<PsiReference> */Object consumer) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field psiElement is undefined for the type JvmElementsReferencesSearch"
      + "\nThe method or field PsiNamedElement is undefined for the type JvmElementsReferencesSearch"
      + "\nelementToSearch cannot be resolved"
      + "\nlanguage cannot be resolved"
      + "\n!= cannot be resolved"
      + "\nEObject cannot be resolved"
      + "\njvmElements cannot be resolved"
      + "\nmap cannot be resolved"
      + "\nfilter cannot be resolved"
      + "\noptimizer cannot be resolved"
      + "\nsearchWord cannot be resolved"
      + "\nname cannot be resolved"
      + "\neffectiveSearchScope cannot be resolved");
  }
}
