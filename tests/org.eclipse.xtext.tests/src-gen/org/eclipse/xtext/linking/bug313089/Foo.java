/**
 */
package org.eclipse.xtext.linking.bug313089;

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
 *   <li>{@link org.eclipse.xtext.linking.bug313089.Foo#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.linking.bug313089.Foo#getBar <em>Bar</em>}</li>
 *   <li>{@link org.eclipse.xtext.linking.bug313089.Foo#getBaz <em>Baz</em>}</li>
 *   <li>{@link org.eclipse.xtext.linking.bug313089.Foo#getRef <em>Ref</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.linking.bug313089.Bug313089Package#getFoo()
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
   * @see org.eclipse.xtext.linking.bug313089.Bug313089Package#getFoo_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.linking.bug313089.Foo#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Bar</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Bar</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Bar</em>' containment reference.
   * @see #setBar(Bar)
   * @see org.eclipse.xtext.linking.bug313089.Bug313089Package#getFoo_Bar()
   * @model containment="true"
   * @generated
   */
  Bar getBar();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.linking.bug313089.Foo#getBar <em>Bar</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Bar</em>' containment reference.
   * @see #getBar()
   * @generated
   */
  void setBar(Bar value);

  /**
   * Returns the value of the '<em><b>Baz</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Baz</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Baz</em>' containment reference.
   * @see #setBaz(Baz)
   * @see org.eclipse.xtext.linking.bug313089.Bug313089Package#getFoo_Baz()
   * @model containment="true"
   * @generated
   */
  Baz getBaz();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.linking.bug313089.Foo#getBaz <em>Baz</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Baz</em>' containment reference.
   * @see #getBaz()
   * @generated
   */
  void setBaz(Baz value);

  /**
   * Returns the value of the '<em><b>Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ref</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ref</em>' reference.
   * @see #setRef(Foo)
   * @see org.eclipse.xtext.linking.bug313089.Bug313089Package#getFoo_Ref()
   * @model
   * @generated
   */
  Foo getRef();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.linking.bug313089.Foo#getRef <em>Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ref</em>' reference.
   * @see #getRef()
   * @generated
   */
  void setRef(Foo value);

} // Foo
