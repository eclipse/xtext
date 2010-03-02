/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.xbase;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.xtype.XTypeRef;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XClass</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.xbase.XClass#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.XClass#getExtends <em>Extends</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.XClass#getImplements <em>Implements</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.XClass#getFunctions <em>Functions</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.xbase.XbasePackage#getXClass()
 * @model
 * @generated
 */
public interface XClass extends EObject
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
   * @see org.eclipse.xtext.xbase.XbasePackage#getXClass_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.xbase.XClass#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Extends</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Extends</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Extends</em>' containment reference.
   * @see #setExtends(XTypeRef)
   * @see org.eclipse.xtext.xbase.XbasePackage#getXClass_Extends()
   * @model containment="true"
   * @generated
   */
  XTypeRef getExtends();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.xbase.XClass#getExtends <em>Extends</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Extends</em>' containment reference.
   * @see #getExtends()
   * @generated
   */
  void setExtends(XTypeRef value);

  /**
   * Returns the value of the '<em><b>Implements</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.xtype.XTypeRef}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Implements</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Implements</em>' containment reference list.
   * @see org.eclipse.xtext.xbase.XbasePackage#getXClass_Implements()
   * @model containment="true"
   * @generated
   */
  EList<XTypeRef> getImplements();

  /**
   * Returns the value of the '<em><b>Functions</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.xbase.XFunction}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Functions</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Functions</em>' containment reference list.
   * @see org.eclipse.xtext.xbase.XbasePackage#getXClass_Functions()
   * @model containment="true"
   * @generated
   */
  EList<XFunction> getFunctions();

} // XClass
