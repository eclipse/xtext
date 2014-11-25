/**
 */
package org.eclipse.xtext.parsetree.reconstr.serializationBug269362TestLanguage;

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
 *   <li>{@link org.eclipse.xtext.parsetree.reconstr.serializationBug269362TestLanguage.Model#getFoo <em>Foo</em>}</li>
 *   <li>{@link org.eclipse.xtext.parsetree.reconstr.serializationBug269362TestLanguage.Model#getBar <em>Bar</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.parsetree.reconstr.serializationBug269362TestLanguage.SerializationBug269362TestLanguagePackage#getModel()
 * @model
 * @generated
 */
public interface Model extends EObject
{
  /**
   * Returns the value of the '<em><b>Foo</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Foo</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Foo</em>' attribute.
   * @see #setFoo(String)
   * @see org.eclipse.xtext.parsetree.reconstr.serializationBug269362TestLanguage.SerializationBug269362TestLanguagePackage#getModel_Foo()
   * @model
   * @generated
   */
  String getFoo();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parsetree.reconstr.serializationBug269362TestLanguage.Model#getFoo <em>Foo</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Foo</em>' attribute.
   * @see #getFoo()
   * @generated
   */
  void setFoo(String value);

  /**
   * Returns the value of the '<em><b>Bar</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Bar</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Bar</em>' attribute.
   * @see #setBar(String)
   * @see org.eclipse.xtext.parsetree.reconstr.serializationBug269362TestLanguage.SerializationBug269362TestLanguagePackage#getModel_Bar()
   * @model
   * @generated
   */
  String getBar();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parsetree.reconstr.serializationBug269362TestLanguage.Model#getBar <em>Bar</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Bar</em>' attribute.
   * @see #getBar()
   * @generated
   */
  void setBar(String value);

} // Model
