/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.annotations.formatting2;

import com.google.common.base.Objects;
import java.util.Arrays;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.formatting2.IHiddenRegionFormatter;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegionFinder;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegionsFinder;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.xbase.XAssignment;
import org.eclipse.xtext.xbase.XBasicForLoopExpression;
import org.eclipse.xtext.xbase.XBinaryOperation;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XCastedExpression;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XCollectionLiteral;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XDoWhileExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XForLoopExpression;
import org.eclipse.xtext.xbase.XIfExpression;
import org.eclipse.xtext.xbase.XInstanceOfExpression;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XPostfixOperation;
import org.eclipse.xtext.xbase.XReturnExpression;
import org.eclipse.xtext.xbase.XSwitchExpression;
import org.eclipse.xtext.xbase.XSynchronizedExpression;
import org.eclipse.xtext.xbase.XThrowExpression;
import org.eclipse.xtext.xbase.XTryCatchFinallyExpression;
import org.eclipse.xtext.xbase.XTypeLiteral;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.XWhileExpression;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationElementValuePair;
import org.eclipse.xtext.xbase.formatting2.XbaseFormatter;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xtype.XFunctionTypeRef;
import org.eclipse.xtext.xtype.XImportDeclaration;
import org.eclipse.xtext.xtype.XImportSection;

/**
 * @author Moritz Eysholdt - Initial implementation and API
 */
@SuppressWarnings("all")
public class XbaseWithAnnotationsFormatter extends XbaseFormatter {
  protected void _format(final XAnnotation ann, @Extension final IFormattableDocument document) {
    ISemanticRegionsFinder _regionFor = this.textRegionExtensions.regionFor(ann);
    ISemanticRegion _keyword = _regionFor.keyword("@");
    final Procedure1<IHiddenRegionFormatter> _function = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.noSpace();
      }
    };
    document.append(_keyword, _function);
    ISemanticRegionsFinder _regionFor_1 = this.textRegionExtensions.regionFor(ann);
    ISemanticRegion _keyword_1 = _regionFor_1.keyword("(");
    final Procedure1<IHiddenRegionFormatter> _function_1 = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.noSpace();
      }
    };
    document.surround(_keyword_1, _function_1);
    XExpression _value = ann.getValue();
    boolean _notEquals = (!Objects.equal(_value, null));
    if (_notEquals) {
      XExpression _value_1 = ann.getValue();
      document.<XExpression>format(_value_1);
      ISemanticRegionsFinder _regionFor_2 = this.textRegionExtensions.regionFor(ann);
      ISemanticRegion _keyword_2 = _regionFor_2.keyword(")");
      final Procedure1<IHiddenRegionFormatter> _function_2 = new Procedure1<IHiddenRegionFormatter>() {
        @Override
        public void apply(final IHiddenRegionFormatter it) {
          it.noSpace();
        }
      };
      document.prepend(_keyword_2, _function_2);
    } else {
      EList<XAnnotationElementValuePair> _elementValuePairs = ann.getElementValuePairs();
      boolean _isEmpty = _elementValuePairs.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        EList<XAnnotationElementValuePair> _elementValuePairs_1 = ann.getElementValuePairs();
        for (final XAnnotationElementValuePair pair : _elementValuePairs_1) {
          {
            ISemanticRegionsFinder _regionFor_3 = this.textRegionExtensions.regionFor(pair);
            ISemanticRegion _keyword_3 = _regionFor_3.keyword("=");
            final Procedure1<IHiddenRegionFormatter> _function_3 = new Procedure1<IHiddenRegionFormatter>() {
              @Override
              public void apply(final IHiddenRegionFormatter it) {
                it.noSpace();
              }
            };
            document.surround(_keyword_3, _function_3);
            XExpression _value_2 = pair.getValue();
            document.<XExpression>format(_value_2);
            ISemanticRegionFinder _immediatelyFollowing = this.textRegionExtensions.immediatelyFollowing(pair);
            ISemanticRegion _keyword_4 = _immediatelyFollowing.keyword(",");
            final Procedure1<IHiddenRegionFormatter> _function_4 = new Procedure1<IHiddenRegionFormatter>() {
              @Override
              public void apply(final IHiddenRegionFormatter it) {
                it.noSpace();
              }
            };
            ISemanticRegion _prepend = document.prepend(_keyword_4, _function_4);
            final Procedure1<IHiddenRegionFormatter> _function_5 = new Procedure1<IHiddenRegionFormatter>() {
              @Override
              public void apply(final IHiddenRegionFormatter it) {
                it.oneSpace();
              }
            };
            document.append(_prepend, _function_5);
          }
        }
        ISemanticRegionsFinder _regionFor_3 = this.textRegionExtensions.regionFor(ann);
        ISemanticRegion _keyword_3 = _regionFor_3.keyword(")");
        final Procedure1<IHiddenRegionFormatter> _function_3 = new Procedure1<IHiddenRegionFormatter>() {
          @Override
          public void apply(final IHiddenRegionFormatter it) {
            it.noSpace();
          }
        };
        document.prepend(_keyword_3, _function_3);
      }
    }
  }
  
  public void format(final Object ann, final IFormattableDocument document) {
    if (ann instanceof JvmTypeParameter) {
      _format((JvmTypeParameter)ann, document);
      return;
    } else if (ann instanceof JvmFormalParameter) {
      _format((JvmFormalParameter)ann, document);
      return;
    } else if (ann instanceof XtextResource) {
      _format((XtextResource)ann, document);
      return;
    } else if (ann instanceof XAssignment) {
      _format((XAssignment)ann, document);
      return;
    } else if (ann instanceof XBinaryOperation) {
      _format((XBinaryOperation)ann, document);
      return;
    } else if (ann instanceof XDoWhileExpression) {
      _format((XDoWhileExpression)ann, document);
      return;
    } else if (ann instanceof XFeatureCall) {
      _format((XFeatureCall)ann, document);
      return;
    } else if (ann instanceof XMemberFeatureCall) {
      _format((XMemberFeatureCall)ann, document);
      return;
    } else if (ann instanceof XPostfixOperation) {
      _format((XPostfixOperation)ann, document);
      return;
    } else if (ann instanceof XWhileExpression) {
      _format((XWhileExpression)ann, document);
      return;
    } else if (ann instanceof XFunctionTypeRef) {
      _format((XFunctionTypeRef)ann, document);
      return;
    } else if (ann instanceof JvmGenericArrayTypeReference) {
      _format((JvmGenericArrayTypeReference)ann, document);
      return;
    } else if (ann instanceof JvmParameterizedTypeReference) {
      _format((JvmParameterizedTypeReference)ann, document);
      return;
    } else if (ann instanceof JvmWildcardTypeReference) {
      _format((JvmWildcardTypeReference)ann, document);
      return;
    } else if (ann instanceof XBasicForLoopExpression) {
      _format((XBasicForLoopExpression)ann, document);
      return;
    } else if (ann instanceof XBlockExpression) {
      _format((XBlockExpression)ann, document);
      return;
    } else if (ann instanceof XCastedExpression) {
      _format((XCastedExpression)ann, document);
      return;
    } else if (ann instanceof XClosure) {
      _format((XClosure)ann, document);
      return;
    } else if (ann instanceof XCollectionLiteral) {
      _format((XCollectionLiteral)ann, document);
      return;
    } else if (ann instanceof XConstructorCall) {
      _format((XConstructorCall)ann, document);
      return;
    } else if (ann instanceof XForLoopExpression) {
      _format((XForLoopExpression)ann, document);
      return;
    } else if (ann instanceof XIfExpression) {
      _format((XIfExpression)ann, document);
      return;
    } else if (ann instanceof XInstanceOfExpression) {
      _format((XInstanceOfExpression)ann, document);
      return;
    } else if (ann instanceof XReturnExpression) {
      _format((XReturnExpression)ann, document);
      return;
    } else if (ann instanceof XSwitchExpression) {
      _format((XSwitchExpression)ann, document);
      return;
    } else if (ann instanceof XSynchronizedExpression) {
      _format((XSynchronizedExpression)ann, document);
      return;
    } else if (ann instanceof XThrowExpression) {
      _format((XThrowExpression)ann, document);
      return;
    } else if (ann instanceof XTryCatchFinallyExpression) {
      _format((XTryCatchFinallyExpression)ann, document);
      return;
    } else if (ann instanceof XTypeLiteral) {
      _format((XTypeLiteral)ann, document);
      return;
    } else if (ann instanceof XVariableDeclaration) {
      _format((XVariableDeclaration)ann, document);
      return;
    } else if (ann instanceof XAnnotation) {
      _format((XAnnotation)ann, document);
      return;
    } else if (ann instanceof JvmTypeConstraint) {
      _format((JvmTypeConstraint)ann, document);
      return;
    } else if (ann instanceof XExpression) {
      _format((XExpression)ann, document);
      return;
    } else if (ann instanceof XImportDeclaration) {
      _format((XImportDeclaration)ann, document);
      return;
    } else if (ann instanceof XImportSection) {
      _format((XImportSection)ann, document);
      return;
    } else if (ann instanceof EObject) {
      _format((EObject)ann, document);
      return;
    } else if (ann == null) {
      _format((Void)null, document);
      return;
    } else if (ann != null) {
      _format(ann, document);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(ann, document).toString());
    }
  }
}
