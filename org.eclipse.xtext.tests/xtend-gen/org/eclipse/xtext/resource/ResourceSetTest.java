/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.resource;

import java.util.HashMap;
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
      HashMap<URI, Resource> _newHashMap = CollectionLiterals.<URI, Resource>newHashMap();
      it.setURIResourceMap(_newHashMap);
    };
    return ObjectExtensions.<ResourceSetImpl>operator_doubleArrow(_resourceSetImpl, _function);
  }
}
