/**
 * <copyright>
 * </copyright>
 *
 * $Id: MapEntry.java,v 1.6 2009/02/19 21:08:23 sefftinge Exp $
 */
package org.eclipse.xtext.example.ecoredsl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Map Entry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.example.ecoredsl.MapEntry#getDetailKey <em>Detail Key</em>}</li>
 *   <li>{@link org.eclipse.xtext.example.ecoredsl.MapEntry#getDetailValue <em>Detail Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.example.ecoredsl.EcoredslPackage#getMapEntry()
 * @model
 * @generated
 */
public interface MapEntry extends EObject
{
  /**
   * Returns the value of the '<em><b>Detail Key</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Detail Key</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Detail Key</em>' attribute.
   * @see #setDetailKey(String)
   * @see org.eclipse.xtext.example.ecoredsl.EcoredslPackage#getMapEntry_DetailKey()
   * @model
   * @generated
   */
  String getDetailKey();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.example.ecoredsl.MapEntry#getDetailKey <em>Detail Key</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Detail Key</em>' attribute.
   * @see #getDetailKey()
   * @generated
   */
  void setDetailKey(String value);

  /**
   * Returns the value of the '<em><b>Detail Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Detail Value</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Detail Value</em>' attribute.
   * @see #setDetailValue(String)
   * @see org.eclipse.xtext.example.ecoredsl.EcoredslPackage#getMapEntry_DetailValue()
   * @model
   * @generated
   */
  String getDetailValue();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.example.ecoredsl.MapEntry#getDetailValue <em>Detail Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Detail Value</em>' attribute.
   * @see #getDetailValue()
   * @generated
   */
  void setDetailValue(String value);

} // MapEntry
