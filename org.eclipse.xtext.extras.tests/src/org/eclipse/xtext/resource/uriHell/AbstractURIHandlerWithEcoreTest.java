/**
 * Copyright (c) 2013, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.resource.uriHell;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EcoreFactory;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractURIHandlerWithEcoreTest extends AbstractURIHandlerTest {
  @Override
  public void setUp() {
    super.setUp();
    EcoreFactory factory = EcoreFactory.eINSTANCE;
    EClass baseClass = factory.createEClass();
    baseClass.setName("Base");
    primaryResource.getContents().add(baseClass);
    EClass superClass = factory.createEClass();
    superClass.setName("SuperClass");
    referencedResource.getContents().add(superClass);
    baseClass.getESuperTypes().add(superClass);
  }
}
