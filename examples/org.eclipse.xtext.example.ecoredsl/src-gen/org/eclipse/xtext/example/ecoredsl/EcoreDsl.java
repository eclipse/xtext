/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.example.ecoredsl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ecore Dsl</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.example.ecoredsl.EcoreDsl#getImports <em>Imports</em>}</li>
 *   <li>{@link org.eclipse.xtext.example.ecoredsl.EcoreDsl#getPackage <em>Package</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.example.ecoredsl.EcoredslPackage#getEcoreDsl()
 * @model
 * @generated
 */
public interface EcoreDsl extends EObject
{
  /**
   * Returns the value of the '<em><b>Imports</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.example.ecoredsl.ImportStatementDecl}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Imports</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Imports</em>' containment reference list.
   * @see org.eclipse.xtext.example.ecoredsl.EcoredslPackage#getEcoreDsl_Imports()
   * @model containment="true"
   * @generated
   */
  EList<ImportStatementDecl> getImports();

  /**
   * Returns the value of the '<em><b>Package</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Package</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Package</em>' containment reference.
   * @see #setPackage(EPackage)
   * @see org.eclipse.xtext.example.ecoredsl.EcoredslPackage#getEcoreDsl_Package()
   * @model containment="true"
   * @generated
   */
  EPackage getPackage();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.example.ecoredsl.EcoreDsl#getPackage <em>Package</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Package</em>' containment reference.
   * @see #getPackage()
   * @generated
   */
  void setPackage(EPackage value);

} // EcoreDsl
