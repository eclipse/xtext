package org.eclipse.xtext.resource;

import com.google.common.collect.Iterables;
import java.util.ArrayList;
import java.util.Map;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class XtextResourceSetTest {
  @Test
  public void testResourcesAreInMap() {
    XtextResourceSet _xtextResourceSet = new XtextResourceSet();
    final XtextResourceSet rs = _xtextResourceSet;
    Map<URI,Resource> _uRIResourceMap = rs.getURIResourceMap();
    int _size = _uRIResourceMap.size();
    Assert.assertEquals(0, _size);
    XtextResource _xtextResource = new XtextResource();
    final XtextResource resource = _xtextResource;
    URI _createURI = URI.createURI("foo");
    resource.setURI(_createURI);
    EList<Resource> _resources = rs.getResources();
    _resources.add(resource);
    Map<URI,Resource> _uRIResourceMap_1 = rs.getURIResourceMap();
    int _size_1 = _uRIResourceMap_1.size();
    Assert.assertEquals(2, _size_1);
    Map<URI,Resource> _uRIResourceMap_2 = rs.getURIResourceMap();
    InputOutput.<Map<URI,Resource>>println(_uRIResourceMap_2);
    EList<Resource> _resources_1 = rs.getResources();
    _resources_1.remove(resource);
    Map<URI,Resource> _uRIResourceMap_3 = rs.getURIResourceMap();
    int _size_2 = _uRIResourceMap_3.size();
    Assert.assertEquals(0, _size_2);
  }
  
  @Test
  public void testResourcesAreInMap_02() {
    XtextResourceSet _xtextResourceSet = new XtextResourceSet();
    final XtextResourceSet rs = _xtextResourceSet;
    Map<URI,Resource> _uRIResourceMap = rs.getURIResourceMap();
    int _size = _uRIResourceMap.size();
    Assert.assertEquals(0, _size);
    XtextResource _xtextResource = new XtextResource();
    final XtextResource resource = _xtextResource;
    URI _createURI = URI.createURI("foo");
    resource.setURI(_createURI);
    EList<Resource> _resources = rs.getResources();
    ArrayList<XtextResource> _newArrayList = CollectionLiterals.<XtextResource>newArrayList(resource);
    Iterables.<Resource>addAll(_resources, _newArrayList);
    Map<URI,Resource> _uRIResourceMap_1 = rs.getURIResourceMap();
    int _size_1 = _uRIResourceMap_1.size();
    Assert.assertEquals(2, _size_1);
    Map<URI,Resource> _uRIResourceMap_2 = rs.getURIResourceMap();
    InputOutput.<Map<URI,Resource>>println(_uRIResourceMap_2);
    EList<Resource> _resources_1 = rs.getResources();
    _resources_1.remove(resource);
    Map<URI,Resource> _uRIResourceMap_3 = rs.getURIResourceMap();
    int _size_2 = _uRIResourceMap_3.size();
    Assert.assertEquals(0, _size_2);
  }
}
