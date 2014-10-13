package org.eclipse.xtext.idea.types.psi.search;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.intellij.lang.Language;
import com.intellij.openapi.application.QueryExecutorBase;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNamedElement;
import com.intellij.psi.PsiReference;
import com.intellij.psi.search.SearchRequestCollector;
import com.intellij.psi.search.SearchScope;
import com.intellij.psi.search.searches.ReferencesSearch;
import com.intellij.util.Processor;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.idea.lang.IXtextLanguage;
import org.eclipse.xtext.psi.IPsiModelAssociations;
import org.eclipse.xtext.psi.PsiNamedEObject;
import org.eclipse.xtext.service.OperationCanceledError;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class JvmElementsReferencesSearch extends QueryExecutorBase<PsiReference, ReferencesSearch.SearchParameters> {
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
  
  public void processQuery(final ReferencesSearch.SearchParameters queryParameters, final Processor<PsiReference> consumer) {
    final PsiElement element = queryParameters.getElementToSearch();
    Language _language = element.getLanguage();
    boolean _notEquals = (!Objects.equal(_language, this.language));
    if (_notEquals) {
      return;
    }
    try {
      if ((element instanceof PsiNamedEObject<?>)) {
        EObject _eObject = ((PsiNamedEObject<?>)element).getEObject();
        Set<EObject> _jvmElements = this._iJvmModelAssociations.getJvmElements(_eObject);
        final Function1<EObject, PsiElement> _function = new Function1<EObject, PsiElement>() {
          public PsiElement apply(final EObject it) {
            return JvmElementsReferencesSearch.this._iPsiModelAssociations.getPsiElement(it);
          }
        };
        Iterable<PsiElement> _map = IterableExtensions.<EObject, PsiElement>map(_jvmElements, _function);
        Iterable<PsiNamedElement> _filter = Iterables.<PsiNamedElement>filter(_map, PsiNamedElement.class);
        for (final PsiNamedElement psiJvmElement : _filter) {
          SearchRequestCollector _optimizer = queryParameters.getOptimizer();
          String _name = psiJvmElement.getName();
          SearchScope _effectiveSearchScope = queryParameters.getEffectiveSearchScope();
          _optimizer.searchWord(_name, _effectiveSearchScope, true, psiJvmElement);
        }
      }
    } catch (final Throwable _t) {
      if (_t instanceof OperationCanceledError) {
        final OperationCanceledError e = (OperationCanceledError)_t;
        throw e.getWrapped();
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
}
