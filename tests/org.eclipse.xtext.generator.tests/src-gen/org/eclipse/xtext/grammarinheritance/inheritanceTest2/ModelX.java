/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.grammarinheritance.inheritanceTest2;

import org.eclipse.emf.common.util.EList;

import org.eclipse.xtext.grammarinheritance.inheritanceTest.Element;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model X</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.grammarinheritance.inheritanceTest2.ModelX#getElements2 <em>Elements2</em>}</li>
 *   <li>{@link org.eclipse.xtext.grammarinheritance.inheritanceTest2.ModelX#getIds <em>Ids</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.grammarinheritance.inheritanceTest2.InheritanceTest2Package#getModelX()
 * @model
 * @generated
 */
public interface ModelX extends Element
{
  /**
   * Returns the value of the '<em><b>Elements2</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.grammarinheritance.inheritanceTest2.ModelX}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Elements2</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Elements2</em>' containment reference list.
   * @see org.eclipse.xtext.grammarinheritance.inheritanceTest2.InheritanceTest2Package#getModelX_Elements2()
   * @model containment="true"
   * @generated
   */
  EList<ModelX> getElements2();

  /**
   * Returns the value of the '<em><b>Ids</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ids</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ids</em>' attribute list.
   * @see org.eclipse.xtext.grammarinheritance.inheritanceTest2.InheritanceTest2Package#getModelX_Ids()
   * @model unique="false"
   * @generated
   */
  EList<String> getIds();

} // ModelX
