/**
 * Copyright (c) 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.purexbase.formatting2;

import com.google.inject.Inject;
import java.util.Arrays;
import java.util.function.Consumer;
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
import org.eclipse.xtext.purexbase.pureXbase.Model;
import org.eclipse.xtext.purexbase.services.PureXbaseGrammarAccess;
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
import org.eclipse.xtext.xbase.formatting2.XbaseFormatter;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xtype.XFunctionTypeRef;
import org.eclipse.xtext.xtype.XImportDeclaration;
import org.eclipse.xtext.xtype.XImportSection;

@SuppressWarnings("all")
public class PureXbaseFormatter extends XbaseFormatter {
  @Inject
  @Extension
  private PureXbaseGrammarAccess _pureXbaseGrammarAccess;

  protected void _format(final Model model, @Extension final IFormattableDocument document) {
    document.<XImportSection>format(model.getImportSection());
    document.<XBlockExpression>format(model.getBlock());
  }

  @Override
  protected void _format(final XBlockExpression xBlockExpression, @Extension final IFormattableDocument document) {
    final Consumer<ISemanticRegion> _function = (ISemanticRegion it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
        it_1.newLine();
      };
      document.append(it, _function_1);
    };
    this.textRegionExtensions.regionFor(xBlockExpression).keywords(this._pureXbaseGrammarAccess.getSpecialBlockExpressionAccess().getSemicolonKeyword_1_1()).forEach(_function);
    EList<XExpression> _expressions = xBlockExpression.getExpressions();
    for (final XExpression xExpression : _expressions) {
      document.<XExpression>format(xExpression);
    }
  }

  @Override
  public void format(final Object xBlockExpression, final IFormattableDocument document) {
    if (xBlockExpression instanceof JvmTypeParameter) {
      _format((JvmTypeParameter)xBlockExpression, document);
      return;
    } else if (xBlockExpression instanceof JvmFormalParameter) {
      _format((JvmFormalParameter)xBlockExpression, document);
      return;
    } else if (xBlockExpression instanceof XtextResource) {
      _format((XtextResource)xBlockExpression, document);
      return;
    } else if (xBlockExpression instanceof XAssignment) {
      _format((XAssignment)xBlockExpression, document);
      return;
    } else if (xBlockExpression instanceof XBinaryOperation) {
      _format((XBinaryOperation)xBlockExpression, document);
      return;
    } else if (xBlockExpression instanceof XDoWhileExpression) {
      _format((XDoWhileExpression)xBlockExpression, document);
      return;
    } else if (xBlockExpression instanceof XFeatureCall) {
      _format((XFeatureCall)xBlockExpression, document);
      return;
    } else if (xBlockExpression instanceof XMemberFeatureCall) {
      _format((XMemberFeatureCall)xBlockExpression, document);
      return;
    } else if (xBlockExpression instanceof XPostfixOperation) {
      _format((XPostfixOperation)xBlockExpression, document);
      return;
    } else if (xBlockExpression instanceof XWhileExpression) {
      _format((XWhileExpression)xBlockExpression, document);
      return;
    } else if (xBlockExpression instanceof XFunctionTypeRef) {
      _format((XFunctionTypeRef)xBlockExpression, document);
      return;
    } else if (xBlockExpression instanceof JvmGenericArrayTypeReference) {
      _format((JvmGenericArrayTypeReference)xBlockExpression, document);
      return;
    } else if (xBlockExpression instanceof JvmParameterizedTypeReference) {
      _format((JvmParameterizedTypeReference)xBlockExpression, document);
      return;
    } else if (xBlockExpression instanceof JvmWildcardTypeReference) {
      _format((JvmWildcardTypeReference)xBlockExpression, document);
      return;
    } else if (xBlockExpression instanceof XBasicForLoopExpression) {
      _format((XBasicForLoopExpression)xBlockExpression, document);
      return;
    } else if (xBlockExpression instanceof XBlockExpression) {
      _format((XBlockExpression)xBlockExpression, document);
      return;
    } else if (xBlockExpression instanceof XCastedExpression) {
      _format((XCastedExpression)xBlockExpression, document);
      return;
    } else if (xBlockExpression instanceof XClosure) {
      _format((XClosure)xBlockExpression, document);
      return;
    } else if (xBlockExpression instanceof XCollectionLiteral) {
      _format((XCollectionLiteral)xBlockExpression, document);
      return;
    } else if (xBlockExpression instanceof XConstructorCall) {
      _format((XConstructorCall)xBlockExpression, document);
      return;
    } else if (xBlockExpression instanceof XForLoopExpression) {
      _format((XForLoopExpression)xBlockExpression, document);
      return;
    } else if (xBlockExpression instanceof XIfExpression) {
      _format((XIfExpression)xBlockExpression, document);
      return;
    } else if (xBlockExpression instanceof XInstanceOfExpression) {
      _format((XInstanceOfExpression)xBlockExpression, document);
      return;
    } else if (xBlockExpression instanceof XReturnExpression) {
      _format((XReturnExpression)xBlockExpression, document);
      return;
    } else if (xBlockExpression instanceof XSwitchExpression) {
      _format((XSwitchExpression)xBlockExpression, document);
      return;
    } else if (xBlockExpression instanceof XSynchronizedExpression) {
      _format((XSynchronizedExpression)xBlockExpression, document);
      return;
    } else if (xBlockExpression instanceof XThrowExpression) {
      _format((XThrowExpression)xBlockExpression, document);
      return;
    } else if (xBlockExpression instanceof XTryCatchFinallyExpression) {
      _format((XTryCatchFinallyExpression)xBlockExpression, document);
      return;
    } else if (xBlockExpression instanceof XTypeLiteral) {
      _format((XTypeLiteral)xBlockExpression, document);
      return;
    } else if (xBlockExpression instanceof XVariableDeclaration) {
      _format((XVariableDeclaration)xBlockExpression, document);
      return;
    } else if (xBlockExpression instanceof JvmTypeConstraint) {
      _format((JvmTypeConstraint)xBlockExpression, document);
      return;
    } else if (xBlockExpression instanceof Model) {
      _format((Model)xBlockExpression, document);
      return;
    } else if (xBlockExpression instanceof XExpression) {
      _format((XExpression)xBlockExpression, document);
      return;
    } else if (xBlockExpression instanceof XImportDeclaration) {
      _format((XImportDeclaration)xBlockExpression, document);
      return;
    } else if (xBlockExpression instanceof XImportSection) {
      _format((XImportSection)xBlockExpression, document);
      return;
    } else if (xBlockExpression instanceof EObject) {
      _format((EObject)xBlockExpression, document);
      return;
    } else if (xBlockExpression == null) {
      _format((Void)null, document);
      return;
    } else if (xBlockExpression != null) {
      _format(xBlockExpression, document);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(xBlockExpression, document).toString());
    }
  }
}
