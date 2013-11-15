package org.eclipse.xtend.core.macro;

import com.google.common.base.Objects;
import java.util.Arrays;
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.lib.macro.declaration.AnnotationReference;
import org.eclipse.xtend.lib.macro.declaration.TypeDeclaration;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XAssignment;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XBooleanLiteral;
import org.eclipse.xtext.xbase.XCastedExpression;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XDoWhileExpression;
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
import org.eclipse.xtext.xbase.XWhileExpression;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.interpreter.IEvaluationContext;
import org.eclipse.xtext.xbase.interpreter.impl.XbaseInterpreter;

@SuppressWarnings("all")
public class ConstantExpressionsInterpreter extends XbaseInterpreter {
  private CompilationUnitImpl _compilationUnit;
  
  public CompilationUnitImpl getCompilationUnit() {
    return this._compilationUnit;
  }
  
  public void setCompilationUnit(final CompilationUnitImpl compilationUnit) {
    this._compilationUnit = compilationUnit;
  }
  
  protected Object _doEvaluate(final XAnnotation literal, final IEvaluationContext context, final CancelIndicator indicator) {
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    AnnotationReference _annotationReference = _compilationUnit.toAnnotationReference(literal);
    return _annotationReference;
  }
  
  protected Object translateJvmTypeToResult(final JvmType type) {
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    return _compilationUnit.toType(type);
  }
  
  protected Class<? extends Object> getJavaType(final JvmType type) throws ClassNotFoundException {
    Class<? extends Object> _xblockexpression = null;
    {
      String _qualifiedName = type.getQualifiedName();
      boolean _equals = Objects.equal(_qualifiedName, "java.lang.Class");
      if (_equals) {
        return TypeDeclaration.class;
      }
      Class<? extends Object> _javaType = super.getJavaType(type);
      _xblockexpression = (_javaType);
    }
    return _xblockexpression;
  }
  
  protected Object doEvaluate(final XExpression assignment, final IEvaluationContext context, final CancelIndicator indicator) {
    if (assignment instanceof XAssignment) {
      return _doEvaluate((XAssignment)assignment, context, indicator);
    } else if (assignment instanceof XDoWhileExpression) {
      return _doEvaluate((XDoWhileExpression)assignment, context, indicator);
    } else if (assignment instanceof XFeatureCall) {
      return _doEvaluate((XFeatureCall)assignment, context, indicator);
    } else if (assignment instanceof XListLiteral) {
      return _doEvaluate((XListLiteral)assignment, context, indicator);
    } else if (assignment instanceof XMemberFeatureCall) {
      return _doEvaluate((XMemberFeatureCall)assignment, context, indicator);
    } else if (assignment instanceof XSetLiteral) {
      return _doEvaluate((XSetLiteral)assignment, context, indicator);
    } else if (assignment instanceof XWhileExpression) {
      return _doEvaluate((XWhileExpression)assignment, context, indicator);
    } else if (assignment instanceof XAbstractFeatureCall) {
      return _doEvaluate((XAbstractFeatureCall)assignment, context, indicator);
    } else if (assignment instanceof XBlockExpression) {
      return _doEvaluate((XBlockExpression)assignment, context, indicator);
    } else if (assignment instanceof XBooleanLiteral) {
      return _doEvaluate((XBooleanLiteral)assignment, context, indicator);
    } else if (assignment instanceof XCastedExpression) {
      return _doEvaluate((XCastedExpression)assignment, context, indicator);
    } else if (assignment instanceof XClosure) {
      return _doEvaluate((XClosure)assignment, context, indicator);
    } else if (assignment instanceof XConstructorCall) {
      return _doEvaluate((XConstructorCall)assignment, context, indicator);
    } else if (assignment instanceof XForLoopExpression) {
      return _doEvaluate((XForLoopExpression)assignment, context, indicator);
    } else if (assignment instanceof XIfExpression) {
      return _doEvaluate((XIfExpression)assignment, context, indicator);
    } else if (assignment instanceof XInstanceOfExpression) {
      return _doEvaluate((XInstanceOfExpression)assignment, context, indicator);
    } else if (assignment instanceof XNullLiteral) {
      return _doEvaluate((XNullLiteral)assignment, context, indicator);
    } else if (assignment instanceof XNumberLiteral) {
      return _doEvaluate((XNumberLiteral)assignment, context, indicator);
    } else if (assignment instanceof XReturnExpression) {
      return _doEvaluate((XReturnExpression)assignment, context, indicator);
    } else if (assignment instanceof XStringLiteral) {
      return _doEvaluate((XStringLiteral)assignment, context, indicator);
    } else if (assignment instanceof XSwitchExpression) {
      return _doEvaluate((XSwitchExpression)assignment, context, indicator);
    } else if (assignment instanceof XThrowExpression) {
      return _doEvaluate((XThrowExpression)assignment, context, indicator);
    } else if (assignment instanceof XTryCatchFinallyExpression) {
      return _doEvaluate((XTryCatchFinallyExpression)assignment, context, indicator);
    } else if (assignment instanceof XTypeLiteral) {
      return _doEvaluate((XTypeLiteral)assignment, context, indicator);
    } else if (assignment instanceof XVariableDeclaration) {
      return _doEvaluate((XVariableDeclaration)assignment, context, indicator);
    } else if (assignment instanceof XAnnotation) {
      return _doEvaluate((XAnnotation)assignment, context, indicator);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(assignment, context, indicator).toString());
    }
  }
}
