package org.eclipse.xtext.xbase.tests.typing;

import com.google.inject.Singleton;
import java.util.Arrays;
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
import org.eclipse.xtext.xbase.XCollectionLiteral;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XForLoopExpression;
import org.eclipse.xtext.xbase.XIfExpression;
import org.eclipse.xtext.xbase.XInstanceOfExpression;
import org.eclipse.xtext.xbase.XListLiteral;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XNullLiteral;
import org.eclipse.xtext.xbase.XNumberLiteral;
import org.eclipse.xtext.xbase.XReturnExpression;
import org.eclipse.xtext.xbase.XSetLiteral;
import org.eclipse.xtext.xbase.XStringLiteral;
import org.eclipse.xtext.xbase.XSwitchExpression;
import org.eclipse.xtext.xbase.XThrowExpression;
import org.eclipse.xtext.xbase.XTryCatchFinallyExpression;
import org.eclipse.xtext.xbase.XTypeLiteral;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.annotations.typing.XbaseWithAnnotationsTypeProvider;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationElementValuePair;

@Singleton
@SuppressWarnings("all")
public class SomeCustomTypeProviderWithXtend extends XbaseWithAnnotationsTypeProvider {
  protected JvmTypeReference _type(final XBinaryOperation binaryOperation, final JvmTypeReference rawExpectation, final boolean rawType) {
    JvmTypeReference _xifexpression = null;
    if (true) {
      throw new RuntimeException("This is expected");
    } else {
      _xifexpression = ((JvmTypeReference) null);
    }
    return _xifexpression;
  }
  
  protected JvmTypeReference _expectedType(final XMemberFeatureCall container, final EReference reference, final int index, final boolean rawType) {
    JvmTypeReference _xifexpression = null;
    if (true) {
      throw new RuntimeException("This is expected");
    } else {
      _xifexpression = ((JvmTypeReference) null);
    }
    return _xifexpression;
  }
  
  protected JvmTypeReference _typeForIdentifiable(final JvmDeclaredType identifiable, final boolean rawType) {
    JvmTypeReference _xifexpression = null;
    if (true) {
      throw new RuntimeException("This is expected");
    } else {
      _xifexpression = ((JvmTypeReference) null);
    }
    return _xifexpression;
  }
  
  public JvmTypeReference type(final XExpression binaryOperation, final JvmTypeReference rawExpectation, final boolean rawType) {
    if (binaryOperation instanceof XBinaryOperation) {
      return _type((XBinaryOperation)binaryOperation, rawExpectation, rawType);
    } else if (binaryOperation instanceof XFeatureCall) {
      return _type((XFeatureCall)binaryOperation, rawExpectation, rawType);
    } else if (binaryOperation instanceof XListLiteral) {
      return _type((XListLiteral)binaryOperation, rawExpectation, rawType);
    } else if (binaryOperation instanceof XSetLiteral) {
      return _type((XSetLiteral)binaryOperation, rawExpectation, rawType);
    } else if (binaryOperation instanceof XAbstractFeatureCall) {
      return _type((XAbstractFeatureCall)binaryOperation, rawExpectation, rawType);
    } else if (binaryOperation instanceof XAbstractWhileExpression) {
      return _type((XAbstractWhileExpression)binaryOperation, rawExpectation, rawType);
    } else if (binaryOperation instanceof XBlockExpression) {
      return _type((XBlockExpression)binaryOperation, rawExpectation, rawType);
    } else if (binaryOperation instanceof XBooleanLiteral) {
      return _type((XBooleanLiteral)binaryOperation, rawExpectation, rawType);
    } else if (binaryOperation instanceof XCastedExpression) {
      return _type((XCastedExpression)binaryOperation, rawExpectation, rawType);
    } else if (binaryOperation instanceof XClosure) {
      return _type((XClosure)binaryOperation, rawExpectation, rawType);
    } else if (binaryOperation instanceof XConstructorCall) {
      return _type((XConstructorCall)binaryOperation, rawExpectation, rawType);
    } else if (binaryOperation instanceof XForLoopExpression) {
      return _type((XForLoopExpression)binaryOperation, rawExpectation, rawType);
    } else if (binaryOperation instanceof XIfExpression) {
      return _type((XIfExpression)binaryOperation, rawExpectation, rawType);
    } else if (binaryOperation instanceof XInstanceOfExpression) {
      return _type((XInstanceOfExpression)binaryOperation, rawExpectation, rawType);
    } else if (binaryOperation instanceof XNullLiteral) {
      return _type((XNullLiteral)binaryOperation, rawExpectation, rawType);
    } else if (binaryOperation instanceof XNumberLiteral) {
      return _type((XNumberLiteral)binaryOperation, rawExpectation, rawType);
    } else if (binaryOperation instanceof XReturnExpression) {
      return _type((XReturnExpression)binaryOperation, rawExpectation, rawType);
    } else if (binaryOperation instanceof XStringLiteral) {
      return _type((XStringLiteral)binaryOperation, rawExpectation, rawType);
    } else if (binaryOperation instanceof XSwitchExpression) {
      return _type((XSwitchExpression)binaryOperation, rawExpectation, rawType);
    } else if (binaryOperation instanceof XThrowExpression) {
      return _type((XThrowExpression)binaryOperation, rawExpectation, rawType);
    } else if (binaryOperation instanceof XTryCatchFinallyExpression) {
      return _type((XTryCatchFinallyExpression)binaryOperation, rawExpectation, rawType);
    } else if (binaryOperation instanceof XTypeLiteral) {
      return _type((XTypeLiteral)binaryOperation, rawExpectation, rawType);
    } else if (binaryOperation instanceof XVariableDeclaration) {
      return _type((XVariableDeclaration)binaryOperation, rawExpectation, rawType);
    } else if (binaryOperation instanceof XAnnotation) {
      return _type((XAnnotation)binaryOperation, rawExpectation, rawType);
    } else if (binaryOperation != null) {
      return _type(binaryOperation, rawExpectation, rawType);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(binaryOperation, rawExpectation, rawType).toString());
    }
  }
  
  public JvmTypeReference expectedType(final EObject assignment, final EReference reference, final int index, final boolean rawType) {
    if (assignment instanceof XAssignment) {
      return _expectedType((XAssignment)assignment, reference, index, rawType);
    } else if (assignment instanceof XBinaryOperation) {
      return _expectedType((XBinaryOperation)assignment, reference, index, rawType);
    } else if (assignment instanceof XMemberFeatureCall) {
      return _expectedType((XMemberFeatureCall)assignment, reference, index, rawType);
    } else if (assignment instanceof XAbstractFeatureCall) {
      return _expectedType((XAbstractFeatureCall)assignment, reference, index, rawType);
    } else if (assignment instanceof XAbstractWhileExpression) {
      return _expectedType((XAbstractWhileExpression)assignment, reference, index, rawType);
    } else if (assignment instanceof XBlockExpression) {
      return _expectedType((XBlockExpression)assignment, reference, index, rawType);
    } else if (assignment instanceof XCastedExpression) {
      return _expectedType((XCastedExpression)assignment, reference, index, rawType);
    } else if (assignment instanceof XClosure) {
      return _expectedType((XClosure)assignment, reference, index, rawType);
    } else if (assignment instanceof XCollectionLiteral) {
      return _expectedType((XCollectionLiteral)assignment, reference, index, rawType);
    } else if (assignment instanceof XConstructorCall) {
      return _expectedType((XConstructorCall)assignment, reference, index, rawType);
    } else if (assignment instanceof XForLoopExpression) {
      return _expectedType((XForLoopExpression)assignment, reference, index, rawType);
    } else if (assignment instanceof XIfExpression) {
      return _expectedType((XIfExpression)assignment, reference, index, rawType);
    } else if (assignment instanceof XReturnExpression) {
      return _expectedType((XReturnExpression)assignment, reference, index, rawType);
    } else if (assignment instanceof XSwitchExpression) {
      return _expectedType((XSwitchExpression)assignment, reference, index, rawType);
    } else if (assignment instanceof XThrowExpression) {
      return _expectedType((XThrowExpression)assignment, reference, index, rawType);
    } else if (assignment instanceof XTryCatchFinallyExpression) {
      return _expectedType((XTryCatchFinallyExpression)assignment, reference, index, rawType);
    } else if (assignment instanceof XVariableDeclaration) {
      return _expectedType((XVariableDeclaration)assignment, reference, index, rawType);
    } else if (assignment instanceof XAnnotation) {
      return _expectedType((XAnnotation)assignment, reference, index, rawType);
    } else if (assignment instanceof XCasePart) {
      return _expectedType((XCasePart)assignment, reference, index, rawType);
    } else if (assignment instanceof XCatchClause) {
      return _expectedType((XCatchClause)assignment, reference, index, rawType);
    } else if (assignment instanceof XAnnotationElementValuePair) {
      return _expectedType((XAnnotationElementValuePair)assignment, reference, index, rawType);
    } else if (assignment != null) {
      return _expectedType(assignment, reference, index, rawType);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(assignment, reference, index, rawType).toString());
    }
  }
  
  public JvmTypeReference typeForIdentifiable(final JvmIdentifiableElement constructor, final boolean rawType) {
    if (constructor instanceof JvmConstructor) {
      return _typeForIdentifiable((JvmConstructor)constructor, rawType);
    } else if (constructor instanceof JvmOperation) {
      return _typeForIdentifiable((JvmOperation)constructor, rawType);
    } else if (constructor instanceof JvmField) {
      return _typeForIdentifiable((JvmField)constructor, rawType);
    } else if (constructor instanceof JvmGenericType) {
      return _typeForIdentifiable((JvmGenericType)constructor, rawType);
    } else if (constructor instanceof JvmDeclaredType) {
      return _typeForIdentifiable((JvmDeclaredType)constructor, rawType);
    } else if (constructor instanceof JvmFormalParameter) {
      return _typeForIdentifiable((JvmFormalParameter)constructor, rawType);
    } else if (constructor instanceof JvmType) {
      return _typeForIdentifiable((JvmType)constructor, rawType);
    } else if (constructor instanceof XVariableDeclaration) {
      return _typeForIdentifiable((XVariableDeclaration)constructor, rawType);
    } else if (constructor != null) {
      return _typeForIdentifiable(constructor, rawType);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(constructor, rawType).toString());
    }
  }
}
