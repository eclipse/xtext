package org.eclipse.xtext.example.domainmodel.formatting2;

import java.util.Arrays;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.example.domainmodel.domainmodel.AbstractElement;
import org.eclipse.xtext.example.domainmodel.domainmodel.DomainModel;
import org.eclipse.xtext.example.domainmodel.domainmodel.Entity;
import org.eclipse.xtext.example.domainmodel.domainmodel.Feature;
import org.eclipse.xtext.example.domainmodel.domainmodel.Operation;
import org.eclipse.xtext.example.domainmodel.domainmodel.PackageDeclaration;
import org.eclipse.xtext.example.domainmodel.domainmodel.Property;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.xbase.XAssignment;
import org.eclipse.xtext.xbase.XBasicForLoopExpression;
import org.eclipse.xtext.xbase.XBinaryOperation;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XCatchClause;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XCollectionLiteral;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XDoWhileExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XForLoopExpression;
import org.eclipse.xtext.xbase.XIfExpression;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XReturnExpression;
import org.eclipse.xtext.xbase.XSwitchExpression;
import org.eclipse.xtext.xbase.XSynchronizedExpression;
import org.eclipse.xtext.xbase.XThrowExpression;
import org.eclipse.xtext.xbase.XTryCatchFinallyExpression;
import org.eclipse.xtext.xbase.XTypeLiteral;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.XWhileExpression;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.formatting2.XbaseFormatter;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xtype.XFunctionTypeRef;
import org.eclipse.xtext.xtype.XImportSection;

@SuppressWarnings("all")
public class DomainmodelFormatter extends XbaseFormatter {
  protected void _format(final DomainModel domainmodel, @Extension final IFormattableDocument document) {
    XImportSection _importSection = domainmodel.getImportSection();
    this.format(_importSection, document);
    EList<AbstractElement> _elements = domainmodel.getElements();
    for (final AbstractElement elements : _elements) {
      this.format(elements, document);
    }
  }
  
  protected void _format(final PackageDeclaration packagedeclaration, @Extension final IFormattableDocument document) {
    EList<AbstractElement> _elements = packagedeclaration.getElements();
    for (final AbstractElement elements : _elements) {
      this.format(elements, document);
    }
  }
  
  protected void _format(final Entity entity, @Extension final IFormattableDocument document) {
    JvmParameterizedTypeReference _superType = entity.getSuperType();
    this.format(_superType, document);
    EList<Feature> _features = entity.getFeatures();
    for (final Feature features : _features) {
      this.format(features, document);
    }
  }
  
  protected void _format(final Property property, @Extension final IFormattableDocument document) {
    JvmTypeReference _type = property.getType();
    this.format(_type, document);
  }
  
  protected void _format(final Operation operation, @Extension final IFormattableDocument document) {
    EList<JvmFormalParameter> _params = operation.getParams();
    for (final JvmFormalParameter params : _params) {
      this.format(params, document);
    }
    JvmTypeReference _type = operation.getType();
    this.format(_type, document);
    XExpression _body = operation.getBody();
    this.format(_body, document);
  }
  
  protected void format(final EObject entity, final IFormattableDocument document) {
    if (entity instanceof JvmTypeParameter) {
      _format((JvmTypeParameter)entity, document);
      return;
    } else if (entity instanceof JvmFormalParameter) {
      _format((JvmFormalParameter)entity, document);
      return;
    } else if (entity instanceof XAssignment) {
      _format((XAssignment)entity, document);
      return;
    } else if (entity instanceof XBinaryOperation) {
      _format((XBinaryOperation)entity, document);
      return;
    } else if (entity instanceof XDoWhileExpression) {
      _format((XDoWhileExpression)entity, document);
      return;
    } else if (entity instanceof XFeatureCall) {
      _format((XFeatureCall)entity, document);
      return;
    } else if (entity instanceof XMemberFeatureCall) {
      _format((XMemberFeatureCall)entity, document);
      return;
    } else if (entity instanceof XWhileExpression) {
      _format((XWhileExpression)entity, document);
      return;
    } else if (entity instanceof XFunctionTypeRef) {
      _format((XFunctionTypeRef)entity, document);
      return;
    } else if (entity instanceof JvmGenericArrayTypeReference) {
      _format((JvmGenericArrayTypeReference)entity, document);
      return;
    } else if (entity instanceof JvmParameterizedTypeReference) {
      _format((JvmParameterizedTypeReference)entity, document);
      return;
    } else if (entity instanceof JvmWildcardTypeReference) {
      _format((JvmWildcardTypeReference)entity, document);
      return;
    } else if (entity instanceof Entity) {
      _format((Entity)entity, document);
      return;
    } else if (entity instanceof Operation) {
      _format((Operation)entity, document);
      return;
    } else if (entity instanceof PackageDeclaration) {
      _format((PackageDeclaration)entity, document);
      return;
    } else if (entity instanceof Property) {
      _format((Property)entity, document);
      return;
    } else if (entity instanceof XBasicForLoopExpression) {
      _format((XBasicForLoopExpression)entity, document);
      return;
    } else if (entity instanceof XBlockExpression) {
      _format((XBlockExpression)entity, document);
      return;
    } else if (entity instanceof XClosure) {
      _format((XClosure)entity, document);
      return;
    } else if (entity instanceof XCollectionLiteral) {
      _format((XCollectionLiteral)entity, document);
      return;
    } else if (entity instanceof XConstructorCall) {
      _format((XConstructorCall)entity, document);
      return;
    } else if (entity instanceof XForLoopExpression) {
      _format((XForLoopExpression)entity, document);
      return;
    } else if (entity instanceof XIfExpression) {
      _format((XIfExpression)entity, document);
      return;
    } else if (entity instanceof XReturnExpression) {
      _format((XReturnExpression)entity, document);
      return;
    } else if (entity instanceof XSwitchExpression) {
      _format((XSwitchExpression)entity, document);
      return;
    } else if (entity instanceof XSynchronizedExpression) {
      _format((XSynchronizedExpression)entity, document);
      return;
    } else if (entity instanceof XThrowExpression) {
      _format((XThrowExpression)entity, document);
      return;
    } else if (entity instanceof XTryCatchFinallyExpression) {
      _format((XTryCatchFinallyExpression)entity, document);
      return;
    } else if (entity instanceof XTypeLiteral) {
      _format((XTypeLiteral)entity, document);
      return;
    } else if (entity instanceof XVariableDeclaration) {
      _format((XVariableDeclaration)entity, document);
      return;
    } else if (entity instanceof XAnnotation) {
      _format((XAnnotation)entity, document);
      return;
    } else if (entity instanceof JvmTypeConstraint) {
      _format((JvmTypeConstraint)entity, document);
      return;
    } else if (entity instanceof DomainModel) {
      _format((DomainModel)entity, document);
      return;
    } else if (entity instanceof XCatchClause) {
      _format((XCatchClause)entity, document);
      return;
    } else if (entity instanceof XExpression) {
      _format((XExpression)entity, document);
      return;
    } else if (entity != null) {
      _format(entity, document);
      return;
    } else if (entity == null) {
      _format((Void)null, document);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(entity, document).toString());
    }
  }
}
