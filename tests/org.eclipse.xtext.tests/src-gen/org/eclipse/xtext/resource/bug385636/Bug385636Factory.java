/**
 */
package org.eclipse.xtext.resource.bug385636;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.resource.bug385636.Bug385636Package
 * @generated
 */
public interface Bug385636Factory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  Bug385636Factory eINSTANCE = org.eclipse.xtext.resource.bug385636.impl.Bug385636FactoryImpl.init();

  /**
   * Returns a new object of class '<em>Program</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Program</em>'.
   * @generated
   */
  Program createProgram();

  /**
   * Returns a new object of class '<em>Define Variables</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Define Variables</em>'.
   * @generated
   */
  DefineVariables createDefineVariables();

  /**
   * Returns a new object of class '<em>Define Variable</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Define Variable</em>'.
   * @generated
   */
  DefineVariable createDefineVariable();

  /**
   * Returns a new object of class '<em>NVariable Access</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>NVariable Access</em>'.
   * @generated
   */
  NVariableAccess createNVariableAccess();

  /**
   * Returns a new object of class '<em>Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Expression</em>'.
   * @generated
   */
  Expression createExpression();

  /**
   * Returns a new object of class '<em>Expression Variable Name</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Expression Variable Name</em>'.
   * @generated
   */
  Expression_VariableName createExpression_VariableName();

  /**
   * Returns a new object of class '<em>Expression Larger Equal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Expression Larger Equal</em>'.
   * @generated
   */
  Expression_Larger_Equal createExpression_Larger_Equal();

  /**
   * Returns a new object of class '<em>Expression Smaller</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Expression Smaller</em>'.
   * @generated
   */
  Expression_Smaller createExpression_Smaller();

  /**
   * Returns a new object of class '<em>Expression Smaller Equal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Expression Smaller Equal</em>'.
   * @generated
   */
  Expression_Smaller_Equal createExpression_Smaller_Equal();

  /**
   * Returns a new object of class '<em>Expression Equal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Expression Equal</em>'.
   * @generated
   */
  Expression_Equal createExpression_Equal();

  /**
   * Returns a new object of class '<em>Expression Not Equal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Expression Not Equal</em>'.
   * @generated
   */
  Expression_Not_Equal createExpression_Not_Equal();

  /**
   * Returns a new object of class '<em>Expression Not Less</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Expression Not Less</em>'.
   * @generated
   */
  Expression_Not_Less createExpression_Not_Less();

  /**
   * Returns a new object of class '<em>Expression Not Greater</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Expression Not Greater</em>'.
   * @generated
   */
  Expression_Not_Greater createExpression_Not_Greater();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  Bug385636Package getBug385636Package();

} //Bug385636Factory
