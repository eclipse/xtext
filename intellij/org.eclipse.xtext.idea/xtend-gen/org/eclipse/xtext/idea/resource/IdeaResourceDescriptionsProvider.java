/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.resource;

import com.google.common.base.Objects;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.IResourceDescriptionsProvider;
import org.eclipse.xtext.resource.impl.ChunkedResourceDescriptions;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class IdeaResourceDescriptionsProvider implements IResourceDescriptionsProvider {
  @Override
  public IResourceDescriptions getResourceDescriptions(final ResourceSet resourceSet) {
    final ChunkedResourceDescriptions index = ChunkedResourceDescriptions.findInEmfObject(resourceSet);
    boolean _notEquals = (!Objects.equal(index, null));
    if (_notEquals) {
      return index;
    }
    throw new IllegalStateException("No index installed.");
  }
}
