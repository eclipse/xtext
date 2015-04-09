/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.idea.completion;

import com.intellij.codeInsight.completion.CompletionParameters;
import com.intellij.codeInsight.completion.CompletionProvider;
import com.intellij.codeInsight.completion.CompletionResultSet;
import com.intellij.codeInsight.completion.CompletionType;
import com.intellij.codeInsight.completion.JavaClassNameCompletionContributor;
import com.intellij.codeInsight.completion.JavaCompletionSorting;
import com.intellij.codeInsight.completion.JavaPsiClassReferenceElement;
import com.intellij.codeInsight.completion.PrefixMatcher;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.patterns.PsiElementPattern;
import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiModifier;
import com.intellij.util.Consumer;
import com.intellij.util.ProcessingContext;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.idea.completion.AbstractXbaseCompletionContributor;
import org.eclipse.xtext.xbase.idea.lang.XbaseLanguage;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xtype.XtypePackage;

@SuppressWarnings("all")
public class XbaseCompletionContributor extends AbstractXbaseCompletionContributor {
  public XbaseCompletionContributor() {
    this(XbaseLanguage.INSTANCE);
  }
  
  public XbaseCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
    this.completeJvmParameterizedTypeReference_Type();
    this.completeXImportDeclaration_ImportedType();
    this.completeXConstructorCall_Constructor();
    this.completeXTypeLiteral_Type();
  }
  
  protected void completeJvmParameterizedTypeReference_Type() {
    this.completeJavaTypes(TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE);
  }
  
  protected void completeXImportDeclaration_ImportedType() {
    this.completeJavaTypes(XtypePackage.Literals.XIMPORT_DECLARATION__IMPORTED_TYPE);
  }
  
  protected void completeXConstructorCall_Constructor() {
    final Function1<JavaPsiClassReferenceElement, Boolean> _function = new Function1<JavaPsiClassReferenceElement, Boolean>() {
      @Override
      public Boolean apply(final JavaPsiClassReferenceElement it) {
        boolean _xblockexpression = false;
        {
          final PsiClass type = it.getObject();
          boolean _and = false;
          boolean _hasModifierProperty = type.hasModifierProperty(PsiModifier.ABSTRACT);
          boolean _not = (!_hasModifierProperty);
          if (!_not) {
            _and = false;
          } else {
            boolean _isInterface = type.isInterface();
            boolean _not_1 = (!_isInterface);
            _and = _not_1;
          }
          _xblockexpression = _and;
        }
        return Boolean.valueOf(_xblockexpression);
      }
    };
    this.completeJavaTypes(XbasePackage.Literals.XCONSTRUCTOR_CALL__CONSTRUCTOR, _function);
  }
  
  protected void completeXTypeLiteral_Type() {
    this.completeJavaTypes(XbasePackage.Literals.XTYPE_LITERAL__TYPE);
  }
  
  protected void completeJavaTypes(final EReference reference) {
    final Function1<JavaPsiClassReferenceElement, Boolean> _function = new Function1<JavaPsiClassReferenceElement, Boolean>() {
      @Override
      public Boolean apply(final JavaPsiClassReferenceElement it) {
        return Boolean.valueOf(true);
      }
    };
    this.completeJavaTypes(reference, _function);
  }
  
  protected void completeJavaTypes(final EReference reference, final Function1<? super JavaPsiClassReferenceElement, ? extends Boolean> filter) {
    PsiElementPattern.Capture<PsiElement> _psiElement = PlatformPatterns.psiElement();
    PsiElementPattern.Capture<PsiElement> _withEReference = this._patternExtensions.withEReference(_psiElement, reference);
    final CompletionProvider<CompletionParameters> _function = new CompletionProvider<CompletionParameters>() {
      @Override
      protected void addCompletions(final CompletionParameters $0, final ProcessingContext $1, final CompletionResultSet $2) {
        XbaseCompletionContributor.this.completeJavaTypes($0, $2, filter);
      }
    };
    this.extend(CompletionType.BASIC, _withEReference, _function);
  }
  
  protected void completeJavaTypes(final CompletionParameters completionParameters, final CompletionResultSet completionResultSet, final Function1<? super JavaPsiClassReferenceElement, ? extends Boolean> filter) {
    int _invocationCount = completionParameters.getInvocationCount();
    boolean _lessEqualsThan = (_invocationCount <= 2);
    CompletionResultSet _addJavaSorting = JavaCompletionSorting.addJavaSorting(completionParameters, completionResultSet);
    PrefixMatcher _prefixMatcher = _addJavaSorting.getPrefixMatcher();
    final Consumer<LookupElement> _function = new Consumer<LookupElement>() {
      @Override
      public void consume(final LookupElement it) {
        if ((it instanceof JavaPsiClassReferenceElement)) {
          Boolean _apply = filter.apply(((JavaPsiClassReferenceElement)it));
          if ((_apply).booleanValue()) {
            completionResultSet.addElement(it);
          }
        }
      }
    };
    JavaClassNameCompletionContributor.addAllClasses(completionParameters, _lessEqualsThan, _prefixMatcher, _function);
  }
}
