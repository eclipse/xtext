/**
 */
package org.eclipse.xtext.resource.bug385636.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.eclipse.xtext.resource.bug385636.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.resource.bug385636.Bug385636Package
 * @generated
 */
public class Bug385636Switch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static Bug385636Package modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Bug385636Switch()
  {
    if (modelPackage == null)
    {
      modelPackage = Bug385636Package.eINSTANCE;
    }
  }

  /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(EPackage ePackage)
  {
    return ePackage == modelPackage;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @Override
  protected T doSwitch(int classifierID, EObject theEObject)
  {
    switch (classifierID)
    {
      case Bug385636Package.PROGRAM:
      {
        Program program = (Program)theEObject;
        T result = caseProgram(program);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Bug385636Package.DEFINE_VARIABLES:
      {
        DefineVariables defineVariables = (DefineVariables)theEObject;
        T result = caseDefineVariables(defineVariables);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Bug385636Package.DEFINE_VARIABLE:
      {
        DefineVariable defineVariable = (DefineVariable)theEObject;
        T result = caseDefineVariable(defineVariable);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Bug385636Package.NVARIABLE_ACCESS:
      {
        NVariableAccess nVariableAccess = (NVariableAccess)theEObject;
        T result = caseNVariableAccess(nVariableAccess);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Bug385636Package.EXPRESSION:
      {
        Expression expression = (Expression)theEObject;
        T result = caseExpression(expression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Bug385636Package.EXPRESSION_VARIABLE_NAME:
      {
        Expression_VariableName expression_VariableName = (Expression_VariableName)theEObject;
        T result = caseExpression_VariableName(expression_VariableName);
        if (result == null) result = caseExpression(expression_VariableName);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Bug385636Package.EXPRESSION_LARGER_EQUAL:
      {
        Expression_Larger_Equal expression_Larger_Equal = (Expression_Larger_Equal)theEObject;
        T result = caseExpression_Larger_Equal(expression_Larger_Equal);
        if (result == null) result = caseExpression(expression_Larger_Equal);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Bug385636Package.EXPRESSION_SMALLER:
      {
        Expression_Smaller expression_Smaller = (Expression_Smaller)theEObject;
        T result = caseExpression_Smaller(expression_Smaller);
        if (result == null) result = caseExpression(expression_Smaller);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Bug385636Package.EXPRESSION_SMALLER_EQUAL:
      {
        Expression_Smaller_Equal expression_Smaller_Equal = (Expression_Smaller_Equal)theEObject;
        T result = caseExpression_Smaller_Equal(expression_Smaller_Equal);
        if (result == null) result = caseExpression(expression_Smaller_Equal);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Bug385636Package.EXPRESSION_EQUAL:
      {
        Expression_Equal expression_Equal = (Expression_Equal)theEObject;
        T result = caseExpression_Equal(expression_Equal);
        if (result == null) result = caseExpression(expression_Equal);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Bug385636Package.EXPRESSION_NOT_EQUAL:
      {
        Expression_Not_Equal expression_Not_Equal = (Expression_Not_Equal)theEObject;
        T result = caseExpression_Not_Equal(expression_Not_Equal);
        if (result == null) result = caseExpression(expression_Not_Equal);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Bug385636Package.EXPRESSION_NOT_LESS:
      {
        Expression_Not_Less expression_Not_Less = (Expression_Not_Less)theEObject;
        T result = caseExpression_Not_Less(expression_Not_Less);
        if (result == null) result = caseExpression(expression_Not_Less);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Bug385636Package.EXPRESSION_NOT_GREATER:
      {
        Expression_Not_Greater expression_Not_Greater = (Expression_Not_Greater)theEObject;
        T result = caseExpression_Not_Greater(expression_Not_Greater);
        if (result == null) result = caseExpression(expression_Not_Greater);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Program</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Program</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseProgram(Program object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Define Variables</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Define Variables</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDefineVariables(DefineVariables object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Define Variable</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Define Variable</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDefineVariable(DefineVariable object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>NVariable Access</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>NVariable Access</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNVariableAccess(NVariableAccess object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExpression(Expression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Expression Variable Name</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Expression Variable Name</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExpression_VariableName(Expression_VariableName object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Expression Larger Equal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Expression Larger Equal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExpression_Larger_Equal(Expression_Larger_Equal object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Expression Smaller</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Expression Smaller</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExpression_Smaller(Expression_Smaller object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Expression Smaller Equal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Expression Smaller Equal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExpression_Smaller_Equal(Expression_Smaller_Equal object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Expression Equal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Expression Equal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExpression_Equal(Expression_Equal object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Expression Not Equal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Expression Not Equal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExpression_Not_Equal(Expression_Not_Equal object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Expression Not Less</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Expression Not Less</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExpression_Not_Less(Expression_Not_Less object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Expression Not Greater</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Expression Not Greater</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExpression_Not_Greater(Expression_Not_Greater object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  @Override
  public T defaultCase(EObject object)
  {
    return null;
  }

} //Bug385636Switch
