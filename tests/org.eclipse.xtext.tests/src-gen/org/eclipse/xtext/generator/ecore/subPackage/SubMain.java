/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.generator.ecore.subPackage;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.generator.ecore.superPackage.SuperMain;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sub Main</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.generator.ecore.subPackage.SubMain#getSuperMains <em>Super Mains</em>}</li>
 *   <li>{@link org.eclipse.xtext.generator.ecore.subPackage.SubMain#getAnother <em>Another</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.generator.ecore.subPackage.SubPackagePackage#getSubMain()
 * @model
 * @generated
 */
public interface SubMain extends EObject
{
  /**
   * Returns the value of the '<em><b>Super Mains</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.generator.ecore.superPackage.SuperMain}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Super Mains</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Super Mains</em>' containment reference list.
   * @see org.eclipse.xtext.generator.ecore.subPackage.SubPackagePackage#getSubMain_SuperMains()
   * @model containment="true"
   * @generated
   */
  EList<SuperMain> getSuperMains();

  /**
   * Returns the value of the '<em><b>Another</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Another</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Another</em>' containment reference.
   * @see #setAnother(AnotherSuperMain)
   * @see org.eclipse.xtext.generator.ecore.subPackage.SubPackagePackage#getSubMain_Another()
   * @model containment="true"
   * @generated
   */
  AnotherSuperMain getAnother();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.generator.ecore.subPackage.SubMain#getAnother <em>Another</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Another</em>' containment reference.
   * @see #getAnother()
   * @generated
   */
  void setAnother(AnotherSuperMain value);

} // SubMain
