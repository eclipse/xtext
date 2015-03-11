/**
 */
package org.eclipse.xtext.grammarinheritance.inheritanceTest2;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.grammarinheritance.inheritanceTest2.Model#getIds <em>Ids</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.grammarinheritance.inheritanceTest2.InheritanceTest2Package#getModel()
 * @model
 * @generated
 */
public interface Model extends org.eclipse.xtext.grammarinheritance.inheritanceTest.Model
{
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
   * @see org.eclipse.xtext.grammarinheritance.inheritanceTest2.InheritanceTest2Package#getModel_Ids()
   * @model unique="false"
   * @generated
   */
  EList<String> getIds();

} // Model
