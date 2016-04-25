/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.example.entities.formatting2;

import com.google.inject.Inject;
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
import org.eclipse.xtext.idea.example.entities.domainmodel.AbstractElement;
import org.eclipse.xtext.idea.example.entities.domainmodel.Entities;
import org.eclipse.xtext.idea.example.entities.domainmodel.PackageDeclaration;
import org.eclipse.xtext.idea.example.entities.services.EntitiesGrammarAccess;
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
import org.eclipse.xtext.xtype.XFunctionTypeRef;
import org.eclipse.xtext.xtype.XImportDeclaration;
import org.eclipse.xtext.xtype.XImportSection;

@SuppressWarnings("all")
public class EntitiesFormatter extends XbaseFormatter {
  @Inject
  @Extension
  private EntitiesGrammarAccess _entitiesGrammarAccess;
  
  protected void _format(final Entities entities, @Extension final IFormattableDocument document) {
    XImportSection _importSection = entities.getImportSection();
    document.<XImportSection>format(_importSection);
    EList<AbstractElement> _elements = entities.getElements();
    for (final AbstractElement elements : _elements) {
      document.<AbstractElement>format(elements);
    }
  }
  
  protected void _format(final PackageDeclaration packageDeclaration, @Extension final IFormattableDocument document) {
    EList<AbstractElement> _elements = packageDeclaration.getElements();
    for (final AbstractElement elements : _elements) {
      document.<AbstractElement>format(elements);
    }
  }
  
  public void format(final Object packageDeclaration, final IFormattableDocument document) {
    if (packageDeclaration instanceof JvmTypeParameter) {
      _format((JvmTypeParameter)packageDeclaration, document);
      return;
    } else if (packageDeclaration instanceof JvmFormalParameter) {
      _format((JvmFormalParameter)packageDeclaration, document);
      return;
    } else if (packageDeclaration instanceof XtextResource) {
      _format((XtextResource)packageDeclaration, document);
      return;
    } else if (packageDeclaration instanceof XAssignment) {
      _format((XAssignment)packageDeclaration, document);
      return;
    } else if (packageDeclaration instanceof XBinaryOperation) {
      _format((XBinaryOperation)packageDeclaration, document);
      return;
    } else if (packageDeclaration instanceof XDoWhileExpression) {
      _format((XDoWhileExpression)packageDeclaration, document);
      return;
    } else if (packageDeclaration instanceof XFeatureCall) {
      _format((XFeatureCall)packageDeclaration, document);
      return;
    } else if (packageDeclaration instanceof XMemberFeatureCall) {
      _format((XMemberFeatureCall)packageDeclaration, document);
      return;
    } else if (packageDeclaration instanceof XPostfixOperation) {
      _format((XPostfixOperation)packageDeclaration, document);
      return;
    } else if (packageDeclaration instanceof XWhileExpression) {
      _format((XWhileExpression)packageDeclaration, document);
      return;
    } else if (packageDeclaration instanceof XFunctionTypeRef) {
      _format((XFunctionTypeRef)packageDeclaration, document);
      return;
    } else if (packageDeclaration instanceof JvmGenericArrayTypeReference) {
      _format((JvmGenericArrayTypeReference)packageDeclaration, document);
      return;
    } else if (packageDeclaration instanceof JvmParameterizedTypeReference) {
      _format((JvmParameterizedTypeReference)packageDeclaration, document);
      return;
    } else if (packageDeclaration instanceof JvmWildcardTypeReference) {
      _format((JvmWildcardTypeReference)packageDeclaration, document);
      return;
    } else if (packageDeclaration instanceof PackageDeclaration) {
      _format((PackageDeclaration)packageDeclaration, document);
      return;
    } else if (packageDeclaration instanceof XBasicForLoopExpression) {
      _format((XBasicForLoopExpression)packageDeclaration, document);
      return;
    } else if (packageDeclaration instanceof XBlockExpression) {
      _format((XBlockExpression)packageDeclaration, document);
      return;
    } else if (packageDeclaration instanceof XCastedExpression) {
      _format((XCastedExpression)packageDeclaration, document);
      return;
    } else if (packageDeclaration instanceof XClosure) {
      _format((XClosure)packageDeclaration, document);
      return;
    } else if (packageDeclaration instanceof XCollectionLiteral) {
      _format((XCollectionLiteral)packageDeclaration, document);
      return;
    } else if (packageDeclaration instanceof XConstructorCall) {
      _format((XConstructorCall)packageDeclaration, document);
      return;
    } else if (packageDeclaration instanceof XForLoopExpression) {
      _format((XForLoopExpression)packageDeclaration, document);
      return;
    } else if (packageDeclaration instanceof XIfExpression) {
      _format((XIfExpression)packageDeclaration, document);
      return;
    } else if (packageDeclaration instanceof XInstanceOfExpression) {
      _format((XInstanceOfExpression)packageDeclaration, document);
      return;
    } else if (packageDeclaration instanceof XReturnExpression) {
      _format((XReturnExpression)packageDeclaration, document);
      return;
    } else if (packageDeclaration instanceof XSwitchExpression) {
      _format((XSwitchExpression)packageDeclaration, document);
      return;
    } else if (packageDeclaration instanceof XSynchronizedExpression) {
      _format((XSynchronizedExpression)packageDeclaration, document);
      return;
    } else if (packageDeclaration instanceof XThrowExpression) {
      _format((XThrowExpression)packageDeclaration, document);
      return;
    } else if (packageDeclaration instanceof XTryCatchFinallyExpression) {
      _format((XTryCatchFinallyExpression)packageDeclaration, document);
      return;
    } else if (packageDeclaration instanceof XTypeLiteral) {
      _format((XTypeLiteral)packageDeclaration, document);
      return;
    } else if (packageDeclaration instanceof XVariableDeclaration) {
      _format((XVariableDeclaration)packageDeclaration, document);
      return;
    } else if (packageDeclaration instanceof JvmTypeConstraint) {
      _format((JvmTypeConstraint)packageDeclaration, document);
      return;
    } else if (packageDeclaration instanceof Entities) {
      _format((Entities)packageDeclaration, document);
      return;
    } else if (packageDeclaration instanceof XExpression) {
      _format((XExpression)packageDeclaration, document);
      return;
    } else if (packageDeclaration instanceof XImportDeclaration) {
      _format((XImportDeclaration)packageDeclaration, document);
      return;
    } else if (packageDeclaration instanceof XImportSection) {
      _format((XImportSection)packageDeclaration, document);
      return;
    } else if (packageDeclaration instanceof EObject) {
      _format((EObject)packageDeclaration, document);
      return;
    } else if (packageDeclaration == null) {
      _format((Void)null, document);
      return;
    } else if (packageDeclaration != null) {
      _format(packageDeclaration, document);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(packageDeclaration, document).toString());
    }
  }
}
