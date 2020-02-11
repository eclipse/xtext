/**
 * Copyright (c) 2012, 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.resource;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.resource.AbstractResourceSetTest;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class ResourceSetTest extends AbstractResourceSetTest {
  @Override
  protected ResourceSetImpl createEmptyResourceSet() {
    ResourceSetImpl _resourceSetImpl = new ResourceSetImpl();
    final Procedure1<ResourceSetImpl> _function = (ResourceSetImpl it) -> {
      it.setURIResourceMap(CollectionLiterals.<URI, Resource>newHashMap());
    };
    return ObjectExtensions.<ResourceSetImpl>operator_doubleArrow(_resourceSetImpl, _function);
  }
}
