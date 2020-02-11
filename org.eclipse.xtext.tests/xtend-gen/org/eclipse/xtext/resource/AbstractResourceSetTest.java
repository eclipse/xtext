/**
 * Copyright (c) 2012, 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.resource;

import com.google.common.base.Objects;
import java.io.File;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.resource.NullResource;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.xbase.lib.Exceptions;
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
  
  @Test
  public void testResourceLocatorIsUsed() {
    final ResourceSetImpl rs = this.createEmptyResourceSet();
    final XtextResource resource = new XtextResource();
    resource.setURI(URI.createFileURI(new File("foo").getAbsolutePath()));
    new ResourceSetImpl.ResourceLocator(rs) {
      @Override
      public Resource getResource(final URI uri, final boolean loadOnDemand) {
        URI _uRI = resource.getURI();
        boolean _equals = Objects.equal(uri, _uRI);
        if (_equals) {
          return resource;
        }
        String _string = uri.toString();
        throw new IllegalArgumentException(_string);
      }
    };
    Assert.assertSame(resource, rs.getResource(resource.getURI(), true));
    Assert.assertTrue(rs.getResources().isEmpty());
    Assert.assertNull(resource.getResourceSet());
    try {
      rs.getResource(resource.getURI().appendSegment("doesNotExist"), true);
      Assert.fail();
    } catch (final Throwable _t) {
      if (_t instanceof IllegalArgumentException) {
        final IllegalArgumentException e = (IllegalArgumentException)_t;
        Assert.assertTrue(e.getMessage().endsWith("doesNotExist"));
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
}
