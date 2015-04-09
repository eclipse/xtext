/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.builder.standalone.incremental;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

/**
 * @author koehnlein - Initial contribution and API
 * @since 2.9
 */
@SuppressWarnings("all")
public class ResourceSetClearer {
  /**
   * Clears the content of the resource set without sending notifications.
   * This avoids unnecessary, explicit unloads.
   */
  public void clearResourceSet(final ResourceSet resourceSet) {
    final boolean wasDeliver = resourceSet.eDeliver();
    try {
      resourceSet.eSetDeliver(false);
      EList<Resource> _resources = resourceSet.getResources();
      _resources.clear();
    } finally {
      resourceSet.eSetDeliver(wasDeliver);
    }
  }
}
