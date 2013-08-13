/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.resource.uriHell;

import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class UnexpectedResourcesException extends RuntimeException {
  public UnexpectedResourcesException(final ResourceSet resourceSet) {
    super(new Function0<String>() {
      public String apply() {
        EList<Resource> _resources = resourceSet.getResources();
        final Function1<Resource,String> _function = new Function1<Resource,String>() {
          public String apply(final Resource it) {
            URI _uRI = it.getURI();
            String _string = _uRI.toString();
            return _string;
          }
        };
        List<String> _map = ListExtensions.<Resource, String>map(_resources, _function);
        String _string = _map.toString();
        return _string;
      }
    }.apply());
  }
}
