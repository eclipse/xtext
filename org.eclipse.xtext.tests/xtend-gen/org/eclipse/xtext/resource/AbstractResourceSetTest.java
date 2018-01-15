/**
 * Copyright (c) 2012, 2016 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.resource;

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
    rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", nullFactory);
    Assert.assertEquals(0, rs.getURIResourceMap().size());
    final URI uri = URI.createURI("file:/does/not/exist.xmi");
    final Resource demandLoaded = rs.getResource(uri, true);
    Assert.assertNotNull(demandLoaded);
    final Resource second = rs.getResource(uri, true);
    Assert.assertSame(demandLoaded, second);
    Assert.assertEquals(1, rs.getURIResourceMap().size());
  }
}
