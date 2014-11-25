/**
 */
package org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Foo</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage.Foo#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage.EObjectAtOffsetTestLanguagePackage#getFoo()
 * @model
 * @generated
 */
public interface Foo extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage.EObjectAtOffsetTestLanguagePackage#getFoo_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage.Foo#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

} // Foo
