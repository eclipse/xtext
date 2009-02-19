/**
 * <copyright>
 * </copyright>
 *
 * $Id: File.java,v 1.5 2009/02/19 21:06:41 sefftinge Exp $
 */
package org.eclipse.xtext.example.domainmodel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>File</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.example.domainmodel.File#getImports <em>Imports</em>}</li>
 *   <li>{@link org.eclipse.xtext.example.domainmodel.File#getNamedElements <em>Named Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.example.domainmodel.DomainmodelPackage#getFile()
 * @model
 * @generated
 */
public interface File extends EObject
{
  /**
   * Returns the value of the '<em><b>Imports</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.example.domainmodel.Import}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Imports</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Imports</em>' containment reference list.
   * @see org.eclipse.xtext.example.domainmodel.DomainmodelPackage#getFile_Imports()
   * @model containment="true"
   * @generated
   */
  EList<Import> getImports();

  /**
   * Returns the value of the '<em><b>Named Elements</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.example.domainmodel.NamedElement}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Named Elements</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Named Elements</em>' containment reference list.
   * @see org.eclipse.xtext.example.domainmodel.DomainmodelPackage#getFile_NamedElements()
   * @model containment="true"
   * @generated
   */
  EList<NamedElement> getNamedElements();

} // File
