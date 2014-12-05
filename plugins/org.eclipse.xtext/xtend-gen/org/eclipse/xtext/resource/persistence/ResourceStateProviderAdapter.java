/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.resource.persistence;

import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * An adapter that can be installed into a SerializableResource,
 * to provide resource state. It is used with dirty editors providing the dirty non persisted
 * state to other editors.
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class ResourceStateProviderAdapter extends AdapterImpl {
  public boolean hasStateFor(final URI uri) {
    return false;
  }
  
  public void installState(final Resource resource) {
    throw new UnsupportedOperationException();
  }
}
