package org.eclipse.xtext.xbase.tests.typing;

import com.google.inject.Singleton;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XAbstractWhileExpression;
import org.eclipse.xtext.xbase.XAssignment;
import org.eclipse.xtext.xbase.XBinaryOperation;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XBooleanLiteral;
import org.eclipse.xtext.xbase.XCasePart;
import org.eclipse.xtext.xbase.XCastedExpression;
import org.eclipse.xtext.xbase.XCatchClause;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XForLoopExpression;
import org.eclipse.xtext.xbase.XIfExpression;
import org.eclipse.xtext.xbase.XInstanceOfExpression;
import org.eclipse.xtext.xbase.XIntLiteral;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XNullLiteral;
import org.eclipse.xtext.xbase.XReturnExpression;
import org.eclipse.xtext.xbase.XStringLiteral;
import org.eclipse.xtext.xbase.XSwitchExpression;
import org.eclipse.xtext.xbase.XThrowExpression;
import org.eclipse.xtext.xbase.XTryCatchFinallyExpression;
import org.eclipse.xtext.xbase.XTypeLiteral;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.annotations.typing.XbaseWithAnnotationsTypeProvider;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationElementValueBinaryOperation;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationElementValuePair;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationValueArray;

@SuppressWarnings("all")
@Singleton
public class SomeCustomTypeProviderWithXtend extends XbaseWithAnnotationsTypeProvider {
  protected JvmTypeReference _type(final XBinaryOperation binaryOperation, final JvmTypeReference rawExpectation, final boolean rawType) {
    JvmTypeReference _xifexpression = null;
    if (true) {
      RuntimeException _runtimeException = new RuntimeException("This is expected");
      throw _runtimeException;
    } else {
      _xifexpression = ((JvmTypeReference) null);
    }
    return _xifexpression;
  }
  
  protected JvmTypeReference _expectedType(final XMemberFeatureCall container, final EReference reference, final int index, final boolean rawType) {
    JvmTypeReference _xifexpression = null;
    if (true) {
      RuntimeException _runtimeException = new RuntimeException("This is expected");
      throw _runtimeException;
    } else {
      _xifexpression = ((JvmTypeReference) null);
    }
    return _xifexpression;
  }
  
  protected JvmTypeReference _typeForIdentifiable(final JvmDeclaredType identifiable, final boolean rawType) {
    JvmTypeReference _xifexpression = null;
    if (true) {
      RuntimeException _runtimeException = new RuntimeException("This is expected");
      throw _runtimeException;
    } else {
      _xifexpression = ((JvmTypeReference) null);
    }
    return _xifexpression;
  }
  
  public JvmTypeReference type(final XExpression binaryOperation, final JvmTypeReference rawExpectation, final boolean rawType) {
    if ((binaryOperation instanceof XBinaryOperation)) {
      return _type((XBinaryOperation)binaryOperation, (JvmTypeReference)rawExpectation, (Boolean)rawType);
    } else if ((binaryOperation instanceof XAbstractFeatureCall)) {
      return _type((XAbstractFeatureCall)binaryOperation, (JvmTypeReference)rawExpectation, (Boolean)rawType);
    } else if ((binaryOperation instanceof XAbstractWhileExpression)) {
      return _type((XAbstractWhileExpression)binaryOperation, (JvmTypeReference)rawExpectation, (Boolean)rawType);
    } else if ((binaryOperation instanceof XBlockExpression)) {
      return _type((XBlockExpression)binaryOperation, (JvmTypeReference)rawExpectation, (Boolean)rawType);
    } else if ((binaryOperation instanceof XBooleanLiteral)) {
      return _type((XBooleanLiteral)binaryOperation, (JvmTypeReference)rawExpectation, (Boolean)rawType);
    } else if ((binaryOperation instanceof XCastedExpression)) {
      return _type((XCastedExpression)binaryOperation, (JvmTypeReference)rawExpectation, (Boolean)rawType);
    } else if ((binaryOperation instanceof XClosure)) {
      return _type((XClosure)binaryOperation, (JvmTypeReference)rawExpectation, (Boolean)rawType);
    } else if ((binaryOperation instanceof XConstructorCall)) {
      return _type((XConstructorCall)binaryOperation, (JvmTypeReference)rawExpectation, (Boolean)rawType);
    } else if ((binaryOperation instanceof XForLoopExpression)) {
      return _type((XForLoopExpression)binaryOperation, (JvmTypeReference)rawExpectation, (Boolean)rawType);
    } else if ((binaryOperation instanceof XIfExpression)) {
      return _type((XIfExpression)binaryOperation, (JvmTypeReference)rawExpectation, (Boolean)rawType);
    } else if ((binaryOperation instanceof XInstanceOfExpression)) {
      return _type((XInstanceOfExpression)binaryOperation, (JvmTypeReference)rawExpectation, (Boolean)rawType);
    } else if ((binaryOperation instanceof XIntLiteral)) {
      return _type((XIntLiteral)binaryOperation, (JvmTypeReference)rawExpectation, (Boolean)rawType);
    } else if ((binaryOperation instanceof XNullLiteral)) {
      return _type((XNullLiteral)binaryOperation, (JvmTypeReference)rawExpectation, (Boolean)rawType);
    } else if ((binaryOperation instanceof XReturnExpression)) {
      return _type((XReturnExpression)binaryOperation, (JvmTypeReference)rawExpectation, (Boolean)rawType);
    } else if ((binaryOperation instanceof XStringLiteral)) {
      return _type((XStringLiteral)binaryOperation, (JvmTypeReference)rawExpectation, (Boolean)rawType);
    } else if ((binaryOperation instanceof XSwitchExpression)) {
      return _type((XSwitchExpression)binaryOperation, (JvmTypeReference)rawExpectation, (Boolean)rawType);
    } else if ((binaryOperation instanceof XThrowExpression)) {
      return _type((XThrowExpression)binaryOperation, (JvmTypeReference)rawExpectation, (Boolean)rawType);
    } else if ((binaryOperation instanceof XTryCatchFinallyExpression)) {
      return _type((XTryCatchFinallyExpression)binaryOperation, (JvmTypeReference)rawExpectation, (Boolean)rawType);
    } else if ((binaryOperation instanceof XTypeLiteral)) {
      return _type((XTypeLiteral)binaryOperation, (JvmTypeReference)rawExpectation, (Boolean)rawType);
    } else if ((binaryOperation instanceof XVariableDeclaration)) {
      return _type((XVariableDeclaration)binaryOperation, (JvmTypeReference)rawExpectation, (Boolean)rawType);
    } else if ((binaryOperation instanceof XAnnotation)) {
      return _type((XAnnotation)binaryOperation, (JvmTypeReference)rawExpectation, (Boolean)rawType);
    } else if ((binaryOperation instanceof XAnnotationElementValueBinaryOperation)) {
      return _type((XAnnotationElementValueBinaryOperation)binaryOperation, (JvmTypeReference)rawExpectation, (Boolean)rawType);
    } else if ((binaryOperation instanceof XAnnotationValueArray)) {
      return _type((XAnnotationValueArray)binaryOperation, (JvmTypeReference)rawExpectation, (Boolean)rawType);
    } else {
      return _type((XExpression)binaryOperation, (JvmTypeReference)rawExpectation, (Boolean)rawType);
    }
  }
  
  public JvmTypeReference expectedType(final EObject assignment, final EReference reference, final int index, final boolean rawType) {
    if ((assignment instanceof XAssignment)) {
      return _expectedType((XAssignment)assignment, (EReference)reference, (Integer)index, (Boolean)rawType);
    } else if ((assignment instanceof XBinaryOperation)) {
      return _expectedType((XBinaryOperation)assignment, (EReference)reference, (Integer)index, (Boolean)rawType);
    } else if ((assignment instanceof XMemberFeatureCall)) {
      return _expectedType((XMemberFeatureCall)assignment, (EReference)reference, (Integer)index, (Boolean)rawType);
    } else if ((assignment instanceof XAbstractFeatureCall)) {
      return _expectedType((XAbstractFeatureCall)assignment, (EReference)reference, (Integer)index, (Boolean)rawType);
    } else if ((assignment instanceof XAbstractWhileExpression)) {
      return _expectedType((XAbstractWhileExpression)assignment, (EReference)reference, (Integer)index, (Boolean)rawType);
    } else if ((assignment instanceof XBlockExpression)) {
      return _expectedType((XBlockExpression)assignment, (EReference)reference, (Integer)index, (Boolean)rawType);
    } else if ((assignment instanceof XCasePart)) {
      return _expectedType((XCasePart)assignment, (EReference)reference, (Integer)index, (Boolean)rawType);
    } else if ((assignment instanceof XCastedExpression)) {
      return _expectedType((XCastedExpression)assignment, (EReference)reference, (Integer)index, (Boolean)rawType);
    } else if ((assignment instanceof XClosure)) {
      return _expectedType((XClosure)assignment, (EReference)reference, (Integer)index, (Boolean)rawType);
    } else if ((assignment instanceof XConstructorCall)) {
      return _expectedType((XConstructorCall)assignment, (EReference)reference, (Integer)index, (Boolean)rawType);
    } else if ((assignment instanceof XForLoopExpression)) {
      return _expectedType((XForLoopExpression)assignment, (EReference)reference, (Integer)index, (Boolean)rawType);
    } else if ((assignment instanceof XIfExpression)) {
      return _expectedType((XIfExpression)assignment, (EReference)reference, (Integer)index, (Boolean)rawType);
    } else if ((assignment instanceof XReturnExpression)) {
      return _expectedType((XReturnExpression)assignment, (EReference)reference, (Integer)index, (Boolean)rawType);
    } else if ((assignment instanceof XSwitchExpression)) {
      return _expectedType((XSwitchExpression)assignment, (EReference)reference, (Integer)index, (Boolean)rawType);
    } else if ((assignment instanceof XThrowExpression)) {
      return _expectedType((XThrowExpression)assignment, (EReference)reference, (Integer)index, (Boolean)rawType);
    } else if ((assignment instanceof XTryCatchFinallyExpression)) {
      return _expectedType((XTryCatchFinallyExpression)assignment, (EReference)reference, (Integer)index, (Boolean)rawType);
    } else if ((assignment instanceof XVariableDeclaration)) {
      return _expectedType((XVariableDeclaration)assignment, (EReference)reference, (Integer)index, (Boolean)rawType);
    } else if ((assignment instanceof XAnnotation)) {
      return _expectedType((XAnnotation)assignment, (EReference)reference, (Integer)index, (Boolean)rawType);
    } else if ((assignment instanceof XAnnotationElementValueBinaryOperation)) {
      return _expectedType((XAnnotationElementValueBinaryOperation)assignment, (EReference)reference, (Integer)index, (Boolean)rawType);
    } else if ((assignment instanceof XAnnotationValueArray)) {
      return _expectedType((XAnnotationValueArray)assignment, (EReference)reference, (Integer)index, (Boolean)rawType);
    } else if ((assignment instanceof XCatchClause)) {
      return _expectedType((XCatchClause)assignment, (EReference)reference, (Integer)index, (Boolean)rawType);
    } else if ((assignment instanceof XAnnotationElementValuePair)) {
      return _expectedType((XAnnotationElementValuePair)assignment, (EReference)reference, (Integer)index, (Boolean)rawType);
    } else {
      return _expectedType((EObject)assignment, (EReference)reference, (Integer)index, (Boolean)rawType);
    }
  }
  
  public JvmTypeReference typeForIdentifiable(final JvmIdentifiableElement constructor, final boolean rawType) {
    if ((constructor instanceof JvmConstructor)) {
      return _typeForIdentifiable((JvmConstructor)constructor, (Boolean)rawType);
    } else if ((constructor instanceof JvmGenericType)) {
      return _typeForIdentifiable((JvmGenericType)constructor, (Boolean)rawType);
    } else if ((constructor instanceof JvmOperation)) {
      return _typeForIdentifiable((JvmOperation)constructor, (Boolean)rawType);
    } else if ((constructor instanceof JvmDeclaredType)) {
      return _typeForIdentifiable((JvmDeclaredType)constructor, (Boolean)rawType);
    } else if ((constructor instanceof JvmField)) {
      return _typeForIdentifiable((JvmField)constructor, (Boolean)rawType);
    } else if ((constructor instanceof JvmFormalParameter)) {
      return _typeForIdentifiable((JvmFormalParameter)constructor, (Boolean)rawType);
    } else if ((constructor instanceof JvmType)) {
      return _typeForIdentifiable((JvmType)constructor, (Boolean)rawType);
    } else if ((constructor instanceof XCasePart)) {
      return _typeForIdentifiable((XCasePart)constructor, (Boolean)rawType);
    } else if ((constructor instanceof XSwitchExpression)) {
      return _typeForIdentifiable((XSwitchExpression)constructor, (Boolean)rawType);
    } else if ((constructor instanceof XVariableDeclaration)) {
      return _typeForIdentifiable((XVariableDeclaration)constructor, (Boolean)rawType);
    } else {
      return _typeForIdentifiable((JvmIdentifiableElement)constructor, (Boolean)rawType);
    }
  }
}
