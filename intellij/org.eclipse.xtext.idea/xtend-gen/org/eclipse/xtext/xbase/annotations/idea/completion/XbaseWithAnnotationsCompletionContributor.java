/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.annotations.idea.completion;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.intellij.codeInsight.completion.CompletionParameters;
import com.intellij.codeInsight.completion.CompletionProvider;
import com.intellij.codeInsight.completion.CompletionResultSet;
import com.intellij.codeInsight.completion.CompletionType;
import com.intellij.codeInsight.completion.JavaPsiClassReferenceElement;
import com.intellij.openapi.util.Condition;
import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiElement;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.ProcessingContext;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.psi.IPsiModelAssociations;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsPackage;
import org.eclipse.xtext.xbase.idea.completion.XbaseCompletionContributor;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class XbaseWithAnnotationsCompletionContributor extends XbaseCompletionContributor {
  @Inject
  @Extension
  private IPsiModelAssociations _iPsiModelAssociations;
  
  public XbaseWithAnnotationsCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
    this.completeXAnnotation_AnnotationType();
    this.completeXAnnotation_Value();
  }
  
  protected void completeXAnnotation_AnnotationType() {
    final Function1<JavaPsiClassReferenceElement, Boolean> _function = new Function1<JavaPsiClassReferenceElement, Boolean>() {
      @Override
      public Boolean apply(final JavaPsiClassReferenceElement it) {
        PsiClass _object = it.getObject();
        return Boolean.valueOf(_object.isAnnotationType());
      }
    };
    this.completeJavaTypes(XAnnotationsPackage.Literals.XANNOTATION__ANNOTATION_TYPE, true, _function);
  }
  
  protected void completeXAnnotation_Value() {
    final CompletionProvider<CompletionParameters> _function = new CompletionProvider<CompletionParameters>() {
      @Override
      protected void addCompletions(final CompletionParameters $0, final ProcessingContext $1, final CompletionResultSet $2) {
        PsiElement _position = $0.getPosition();
        final Condition<PsiElement> _function = new Condition<PsiElement>() {
          @Override
          public boolean value(final PsiElement it) {
            EObject _eObject = XbaseWithAnnotationsCompletionContributor.this._iPsiModelAssociations.getEObject(it);
            return (!Objects.equal(_eObject, null));
          }
        };
        final PsiElement psiElement = PsiTreeUtil.findFirstParent(_position, false, _function);
        EObject _eObject = XbaseWithAnnotationsCompletionContributor.this._iPsiModelAssociations.getEObject(psiElement);
        final XAnnotation annotation = EcoreUtil2.<XAnnotation>getContainerOfType(_eObject, XAnnotation.class);
        JvmType _annotationType = null;
        if (annotation!=null) {
          _annotationType=annotation.getAnnotationType();
        }
        final JvmType annotationType = _annotationType;
        boolean _matched = false;
        if (annotationType instanceof JvmAnnotationType) {
          boolean _eIsProxy = ((JvmAnnotationType)annotationType).eIsProxy();
          boolean _not = (!_eIsProxy);
          if (_not) {
            _matched=true;
            Iterable<JvmOperation> _declaredOperations = ((JvmAnnotationType)annotationType).getDeclaredOperations();
            final List<JvmOperation> operations = IterableExtensions.<JvmOperation>toList(_declaredOperations);
            Iterable<JvmOperation> _tail = IterableExtensions.<JvmOperation>tail(operations);
            boolean _isEmpty = IterableExtensions.isEmpty(_tail);
            if (_isEmpty) {
              final JvmOperation singleOperation = IterableExtensions.<JvmOperation>head(operations);
              String _simpleName = singleOperation.getSimpleName();
              boolean _equals = Objects.equal("value", _simpleName);
              if (_equals) {
                String _name = Class.class.getName();
                JvmTypeReference _returnType = singleOperation.getReturnType();
                JvmType _type = null;
                if (_returnType!=null) {
                  _type=_returnType.getType();
                }
                String _qualifiedName = null;
                if (_type!=null) {
                  _qualifiedName=_type.getQualifiedName();
                }
                boolean _equals_1 = Objects.equal(_name, _qualifiedName);
                if (_equals_1) {
                  final Function1<JavaPsiClassReferenceElement, Boolean> _function_1 = new Function1<JavaPsiClassReferenceElement, Boolean>() {
                    @Override
                    public Boolean apply(final JavaPsiClassReferenceElement it) {
                      return Boolean.valueOf(true);
                    }
                  };
                  XbaseWithAnnotationsCompletionContributor.this.completeJavaTypes($0, $2, true, _function_1);
                }
              }
            }
          }
        }
      }
    };
    this.extend(
      CompletionType.BASIC, 
      XAnnotationsPackage.Literals.XANNOTATION__VALUE, _function);
  }
}
