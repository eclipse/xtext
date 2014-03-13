/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.resource.uriHell;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class UnexpectedResourcesException extends RuntimeException {
  public UnexpectedResourcesException(final ResourceSet resourceSet) {
    super(ListExtensions.<Resource, String>map(resourceSet.getResources(), new Function1<Resource, String>() {
      public String apply(final Resource it) {
        URI _uRI = it.getURI();
        return _uRI.toString();
      }
    }).toString());
  }
}
