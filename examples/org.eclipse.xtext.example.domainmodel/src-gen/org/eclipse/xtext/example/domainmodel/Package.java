/**
 * <copyright>
 * </copyright>
 *
 * $Id: Package.java,v 1.5 2009/02/19 21:06:38 sefftinge Exp $
 */
package org.eclipse.xtext.example.domainmodel;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Package</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.example.domainmodel.Package#getNamedElements <em>Named Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.example.domainmodel.DomainmodelPackage#getPackage()
 * @model
 * @generated
 */
public interface Package extends NamedElement
{
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
   * @see org.eclipse.xtext.example.domainmodel.DomainmodelPackage#getPackage_NamedElements()
   * @model containment="true"
   * @generated
   */
  EList<NamedElement> getNamedElements();

} // Package
