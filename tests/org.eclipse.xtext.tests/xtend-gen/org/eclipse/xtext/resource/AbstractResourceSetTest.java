/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.resource;

import java.util.Map;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.resource.NullResource;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public abstract class AbstractResourceSetTest {
  protected abstract ResourceSetImpl createEmptyResourceSet();
  
  @Test
  public void testDemandLoadedResourcesAreInMap() {
    final ResourceSetImpl rs = this.createEmptyResourceSet();
    final Resource.Factory _function = (URI uri) -> {
      NullResource _xblockexpression = null;
      {
        final NullResource result = new NullResource();
        result.setURI(uri);
        _xblockexpression = result;
      }
      return _xblockexpression;
    };
    final Resource.Factory nullFactory = _function;
    Resource.Factory.Registry _resourceFactoryRegistry = rs.getResourceFactoryRegistry();
    Map<String, Object> _extensionToFactoryMap = _resourceFactoryRegistry.getExtensionToFactoryMap();
    _extensionToFactoryMap.put("xmi", nullFactory);
    Map<URI, Resource> _uRIResourceMap = rs.getURIResourceMap();
    int _size = _uRIResourceMap.size();
    Assert.assertEquals(0, _size);
    final URI uri = URI.createURI("file:/does/not/exist.xmi");
    final Resource demandLoaded = rs.getResource(uri, true);
    Assert.assertNotNull(demandLoaded);
    final Resource second = rs.getResource(uri, true);
    Assert.assertSame(demandLoaded, second);
    Map<URI, Resource> _uRIResourceMap_1 = rs.getURIResourceMap();
    int _size_1 = _uRIResourceMap_1.size();
    Assert.assertEquals(1, _size_1);
  }
}
