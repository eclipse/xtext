package org.eclipse.xtext.resource;

import java.util.Map;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Factory;
import org.eclipse.emf.ecore.resource.Resource.Factory.Registry;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.resource.NullResource;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public abstract class AbstractResourceSetTest {
  protected abstract ResourceSetImpl createEmptyResourceSet();
  
  @Test
  public void testDemandLoadedResourcesAreInMap() {
    final ResourceSetImpl rs = this.createEmptyResourceSet();
    final Function1<URI,NullResource> _function = new Function1<URI,NullResource>() {
        public NullResource apply(final URI uri) {
          NullResource _xblockexpression = null;
          {
            NullResource _nullResource = new NullResource();
            final NullResource result = _nullResource;
            result.setURI(uri);
            _xblockexpression = (result);
          }
          return _xblockexpression;
        }
      };
    final Factory nullFactory = new Factory() {
        public Resource createResource(URI uri) {
          return _function.apply(uri);
        }
    };
    Registry _resourceFactoryRegistry = rs.getResourceFactoryRegistry();
    Map<String,Object> _extensionToFactoryMap = _resourceFactoryRegistry.getExtensionToFactoryMap();
    _extensionToFactoryMap.put("xmi", nullFactory);
    Map<URI,Resource> _uRIResourceMap = rs.getURIResourceMap();
    int _size = _uRIResourceMap.size();
    Assert.assertEquals(0, _size);
    final URI uri = URI.createURI("file:/does/not/exist.xmi");
    final Resource demandLoaded = rs.getResource(uri, true);
    Assert.assertNotNull(demandLoaded);
    final Resource second = rs.getResource(uri, true);
    Assert.assertSame(demandLoaded, second);
    Map<URI,Resource> _uRIResourceMap_1 = rs.getURIResourceMap();
    int _size_1 = _uRIResourceMap_1.size();
    Assert.assertEquals(1, _size_1);
  }
}
