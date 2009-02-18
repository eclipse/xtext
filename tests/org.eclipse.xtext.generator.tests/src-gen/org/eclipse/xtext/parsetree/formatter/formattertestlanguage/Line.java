/**
 * <copyright>
 * </copyright>
 *
 * $Id: Line.java,v 1.2 2009/02/18 21:22:45 sefftinge Exp $
 */
package org.eclipse.xtext.parsetree.formatter.formattertestlanguage;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Line</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.Line#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.Line#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.FormattertestlanguagePackage#getLine()
 * @model
 * @generated
 */
public interface Line extends EObject
{
  /**
   * Returns the value of the '<em><b>Type</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' attribute list.
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.FormattertestlanguagePackage#getLine_Type()
   * @model unique="false"
   * @generated
   */
  EList<String> getType();

  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute list.
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.FormattertestlanguagePackage#getLine_Name()
   * @model unique="false"
   * @generated
   */
  EList<String> getName();

} // Line
