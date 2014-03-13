package org.eclipse.xtext.resource;

import java.util.HashMap;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.resource.AbstractResourceSetTest;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class ResourceSetTest extends AbstractResourceSetTest {
  protected ResourceSetImpl createEmptyResourceSet() {
    ResourceSetImpl _resourceSetImpl = new ResourceSetImpl();
    final Procedure1<ResourceSetImpl> _function = new Procedure1<ResourceSetImpl>() {
      public void apply(final ResourceSetImpl it) {
        HashMap<URI, Resource> _newHashMap = CollectionLiterals.<URI, Resource>newHashMap();
        it.setURIResourceMap(_newHashMap);
      }
    };
    return ObjectExtensions.<ResourceSetImpl>operator_doubleArrow(_resourceSetImpl, _function);
  }
}
