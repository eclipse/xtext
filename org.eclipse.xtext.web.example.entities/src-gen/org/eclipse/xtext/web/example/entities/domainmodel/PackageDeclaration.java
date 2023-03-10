/**
 * Copyright (c) 2015, 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.web.example.entities.domainmodel;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Package Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.web.example.entities.domainmodel.PackageDeclaration#getElements <em>Elements</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.web.example.entities.domainmodel.DomainmodelPackage#getPackageDeclaration()
 * @model
 * @generated
 */
public interface PackageDeclaration extends AbstractElement
{
  /**
   * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.web.example.entities.domainmodel.AbstractElement}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Elements</em>' containment reference list.
   * @see org.eclipse.xtext.web.example.entities.domainmodel.DomainmodelPackage#getPackageDeclaration_Elements()
   * @model containment="true"
   * @generated
   */
  EList<AbstractElement> getElements();

} // PackageDeclaration
