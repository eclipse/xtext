/**
 */
package org.eclipse.xtext.parser.antlr.bug296889Test;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parser.antlr.bug296889Test.Model#getExpressions <em>Expressions</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.antlr.bug296889Test.Model#getValues <em>Values</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.parser.antlr.bug296889Test.Bug296889TestPackage#getModel()
 * @model
 * @generated
 */
public interface Model extends EObject
{
  /**
   * Returns the value of the '<em><b>Expressions</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.parser.antlr.bug296889Test.Expression}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Expressions</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expressions</em>' containment reference list.
   * @see org.eclipse.xtext.parser.antlr.bug296889Test.Bug296889TestPackage#getModel_Expressions()
   * @model containment="true"
   * @generated
   */
  EList<Expression> getExpressions();

  /**
   * Returns the value of the '<em><b>Values</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Values</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Values</em>' attribute list.
   * @see org.eclipse.xtext.parser.antlr.bug296889Test.Bug296889TestPackage#getModel_Values()
   * @model unique="false"
   * @generated
   */
  EList<String> getValues();

} // Model
