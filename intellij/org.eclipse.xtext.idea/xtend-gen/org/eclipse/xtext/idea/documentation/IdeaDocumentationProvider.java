/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.documentation;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.intellij.codeInsight.documentation.DocumentationManager;
import com.intellij.lang.documentation.AbstractDocumentationProvider;
import com.intellij.lang.documentation.DocumentationProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiIdentifier;
import java.util.List;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.idea.documentation.IdeaDeclarationDocumentationProvider;
import org.eclipse.xtext.idea.trace.ITraceForVirtualFileProvider;
import org.eclipse.xtext.psi.PsiEObject;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@SuppressWarnings("all")
public class IdeaDocumentationProvider extends AbstractDocumentationProvider {
  @Accessors
  public static class GeneratedCodeDelegate {
    private final PsiElement generatedElement;
    
    private final PsiElement generatedOriginalElement;
    
    private final DocumentationProvider delegate;
    
    public GeneratedCodeDelegate(final PsiElement generatedElement, final PsiElement generatedOriginalElement, final DocumentationProvider delegate) {
      super();
      this.generatedElement = generatedElement;
      this.generatedOriginalElement = generatedOriginalElement;
      this.delegate = delegate;
    }
    
    @Pure
    public PsiElement getGeneratedElement() {
      return this.generatedElement;
    }
    
    @Pure
    public PsiElement getGeneratedOriginalElement() {
      return this.generatedOriginalElement;
    }
    
    @Pure
    public DocumentationProvider getDelegate() {
      return this.delegate;
    }
  }
  
  @Inject
  private IResourceServiceProvider.Registry resourceServiceProviderRegistry;
  
  @Inject
  private ITraceForVirtualFileProvider traceProvider;
  
  @Override
  public String getQuickNavigateInfo(final PsiElement element, final PsiElement originalElement) {
    final IdeaDocumentationProvider.GeneratedCodeDelegate gen = this.findDocumentationInGeneratedCode(element, originalElement);
    boolean _notEquals = (!Objects.equal(gen, null));
    if (_notEquals) {
      final String result = gen.delegate.getQuickNavigateInfo(gen.generatedElement, gen.generatedOriginalElement);
      boolean _notEquals_1 = (!Objects.equal(result, null));
      if (_notEquals_1) {
        return result;
      }
    }
    if ((element instanceof PsiEObject)) {
      final EObject eobj = ((PsiEObject)element).getEObject();
      IdeaDeclarationDocumentationProvider _calleeDocumentationProvider = this.getCalleeDocumentationProvider(eobj);
      String _quickNavigateInfo = null;
      if (_calleeDocumentationProvider!=null) {
        _quickNavigateInfo=_calleeDocumentationProvider.getQuickNavigateInfo(((PsiEObject)element));
      }
      final String result_1 = _quickNavigateInfo;
      boolean _notEquals_2 = (!Objects.equal(result_1, null));
      if (_notEquals_2) {
        return result_1;
      }
      URI _uRI = EcoreUtil.getURI(eobj);
      return _uRI.toString();
    }
    return null;
  }
  
  @Override
  public String generateDoc(final PsiElement element, final PsiElement originalElement) {
    final IdeaDocumentationProvider.GeneratedCodeDelegate gen = this.findDocumentationInGeneratedCode(element, originalElement);
    boolean _notEquals = (!Objects.equal(gen, null));
    if (_notEquals) {
      final String result = gen.delegate.generateDoc(gen.generatedElement, gen.generatedOriginalElement);
      boolean _notEquals_1 = (!Objects.equal(result, null));
      if (_notEquals_1) {
        return result;
      }
    }
    if ((element instanceof PsiEObject)) {
      final EObject eobj = ((PsiEObject)element).getEObject();
      IdeaDeclarationDocumentationProvider _calleeDocumentationProvider = this.getCalleeDocumentationProvider(eobj);
      String _generateDoc = null;
      if (_calleeDocumentationProvider!=null) {
        _generateDoc=_calleeDocumentationProvider.generateDoc(((PsiEObject)element));
      }
      final String result_1 = _generateDoc;
      boolean _notEquals_2 = (!Objects.equal(result_1, null));
      if (_notEquals_2) {
        return result_1;
      }
      URI _uRI = EcoreUtil.getURI(eobj);
      return _uRI.toString();
    }
    return null;
  }
  
  protected IdeaDeclarationDocumentationProvider getCalleeDocumentationProvider(final EObject object) {
    if ((Objects.equal(object, null) || object.eIsProxy())) {
      return null;
    }
    Resource _eResource = object.eResource();
    final URI uri = _eResource.getURI();
    final IResourceServiceProvider resourceServiceProvider = this.resourceServiceProviderRegistry.getResourceServiceProvider(uri);
    boolean _equals = Objects.equal(resourceServiceProvider, null);
    if (_equals) {
      return null;
    }
    IdeaDeclarationDocumentationProvider _get = null;
    if (resourceServiceProvider!=null) {
      _get=resourceServiceProvider.<IdeaDeclarationDocumentationProvider>get(IdeaDeclarationDocumentationProvider.class);
    }
    return _get;
  }
  
  protected IdeaDocumentationProvider.GeneratedCodeDelegate findDocumentationInGeneratedCode(final PsiElement element, final PsiElement originalElement) {
    final PsiElement generatedElement = this.getGeneratedElement(element);
    boolean _equals = Objects.equal(generatedElement, null);
    if (_equals) {
      return null;
    }
    PsiElement _elvis = null;
    PsiElement _generatedElement = this.getGeneratedElement(originalElement);
    if (_generatedElement != null) {
      _elvis = _generatedElement;
    } else {
      _elvis = originalElement;
    }
    final PsiElement generatedOriginalElement = _elvis;
    final DocumentationProvider delegate = DocumentationManager.getProviderFromElement(generatedElement, generatedOriginalElement);
    boolean _equals_1 = Objects.equal(delegate, null);
    if (_equals_1) {
      return null;
    }
    return new IdeaDocumentationProvider.GeneratedCodeDelegate(generatedElement, generatedOriginalElement, delegate);
  }
  
  private PsiElement getGeneratedElement(final PsiElement element) {
    final List<? extends PsiElement> elements = this.traceProvider.getGeneratedElements(element);
    final PsiElement result = IterableExtensions.head(elements);
    if ((result instanceof PsiIdentifier)) {
      return ((PsiIdentifier)result).getParent();
    }
    return result;
  }
}
