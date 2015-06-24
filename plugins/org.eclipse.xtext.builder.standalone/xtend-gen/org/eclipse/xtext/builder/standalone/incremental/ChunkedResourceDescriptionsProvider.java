/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.builder.standalone.incremental;

import com.google.common.base.Objects;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.builder.standalone.incremental.ContextualChunkedResourceDescriptions;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 * @since 2.9
 */
@SuppressWarnings("all")
public class ChunkedResourceDescriptionsProvider extends ResourceDescriptionsProvider {
  @Override
  public IResourceDescriptions getResourceDescriptions(final ResourceSet resourceSet) {
    final ContextualChunkedResourceDescriptions contextual = ContextualChunkedResourceDescriptions.findInEmfObject(resourceSet);
    boolean _notEquals = (!Objects.equal(contextual, null));
    if (_notEquals) {
      return contextual;
    }
    throw new IllegalArgumentException("The given resourceSet doesn\'t contain ChunkedResourceDescriptions.");
  }
}
