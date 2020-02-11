/**
 * Copyright (c) 2014, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.annotations.formatting2;

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
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.noSpace();
    };
    document.append(this.textRegionExtensions.regionFor(ann).keyword("@"), _function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.noSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(ann).keyword("("), _function_1);
    XExpression _value = ann.getValue();
    boolean _tripleNotEquals = (_value != null);
    if (_tripleNotEquals) {
      document.<XExpression>format(ann.getValue());
      final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
        it.noSpace();
      };
      document.prepend(this.textRegionExtensions.regionFor(ann).keyword(")"), _function_2);
    } else {
      boolean _isEmpty = ann.getElementValuePairs().isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        EList<XAnnotationElementValuePair> _elementValuePairs = ann.getElementValuePairs();
        for (final XAnnotationElementValuePair pair : _elementValuePairs) {
          {
            final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
              it.noSpace();
            };
            document.surround(this.textRegionExtensions.regionFor(pair).keyword("="), _function_3);
            document.<XExpression>format(pair.getValue());
            final Procedure1<IHiddenRegionFormatter> _function_4 = (IHiddenRegionFormatter it) -> {
              it.noSpace();
            };
            final Procedure1<IHiddenRegionFormatter> _function_5 = (IHiddenRegionFormatter it) -> {
              it.oneSpace();
            };
            document.append(document.prepend(this.textRegionExtensions.immediatelyFollowing(pair).keyword(","), _function_4), _function_5);
          }
        }
        final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
          it.noSpace();
        };
        document.prepend(this.textRegionExtensions.regionFor(ann).keyword(")"), _function_3);
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
