/**
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.resource.locationprovidertest;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Bus</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.resource.locationprovidertest.Bus#getPort <em>Port</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.resource.locationprovidertest.LocationprovidertestPackage#getBus()
 * @model
 * @generated
 */
public interface Bus extends Component
{
  /**
   * Returns the value of the '<em><b>Port</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.resource.locationprovidertest.Port}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Port</em>' containment reference list.
   * @see org.eclipse.xtext.resource.locationprovidertest.LocationprovidertestPackage#getBus_Port()
   * @model containment="true"
   * @generated
   */
  EList<Port> getPort();

} // Bus
