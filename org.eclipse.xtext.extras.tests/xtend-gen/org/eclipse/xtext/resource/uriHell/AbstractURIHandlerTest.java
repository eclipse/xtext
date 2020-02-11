/**
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.resource.uriHell;

import com.google.inject.Inject;
import com.google.inject.Provider;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Collection;
import java.util.Map;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xml.namespace.XMLNamespacePackage;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.resource.uriHell.URIHandlerTestInjectorProvider;
import org.eclipse.xtext.resource.uriHell.UnexpectedProxiesException;
import org.eclipse.xtext.resource.uriHell.UnexpectedResourcesException;
import org.eclipse.xtext.testing.GlobalRegistries;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Base test case for different places in the workspace where
 * ecore resources may have been put.
 * 
 * The concrete test cases basically illustrate which patterns are bogus
 * and which work nicely in a dev environment and a deployed scenario.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(URIHandlerTestInjectorProvider.class)
@SuppressWarnings("all")
public abstract class AbstractURIHandlerTest extends Assert {
  public abstract URI getResourceURI();
  
  public abstract URI getPackagedResourceURI();
  
  public abstract URI getReferencedURI();
  
  public abstract URI getPackagedReferencedURI();
  
  @Inject
  protected Provider<XtextResourceSet> resourceSetProvider;
  
  @Inject
  protected ClassLoader classLoader;
  
  protected XtextResourceSet resourceSet;
  
  protected Resource primaryResource;
  
  protected Resource referencedResource;
  
  private GlobalRegistries.GlobalStateMemento globalState;
  
  @Before
  public void setUp() {
    this.globalState = GlobalRegistries.makeCopyOfGlobalState();
    EPackage.Registry.INSTANCE.put(XMLTypePackage.eNS_URI, XMLTypePackage.eINSTANCE);
    EPackage.Registry.INSTANCE.put(XMLNamespacePackage.eNS_URI, XMLNamespacePackage.eINSTANCE);
    this.resourceSet = this.getNewResourceSet();
    this.primaryResource = this.resourceSet.createResource(this.getResourceURI());
    this.referencedResource = this.resourceSet.createResource(this.getReferencedURI());
  }
  
  @After
  public void tearDown() {
    this.globalState.restoreGlobalState();
  }
  
  public XtextResourceSet getNewResourceSet() {
    XtextResourceSet _xblockexpression = null;
    {
      final XtextResourceSet result = this.resourceSetProvider.get();
      result.setClasspathURIContext(this.classLoader);
      _xblockexpression = result;
    }
    return _xblockexpression;
  }
  
  protected byte[] getBytes(final Resource resource) {
    try {
      byte[] _xblockexpression = null;
      {
        final ByteArrayOutputStream out = new ByteArrayOutputStream(1024);
        resource.save(out, null);
        final byte[] bytes = out.toByteArray();
        _xblockexpression = bytes;
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected void load(final Resource resource, final byte[] bytes) {
    try {
      final ByteArrayInputStream in = new ByteArrayInputStream(bytes);
      resource.load(in, resource.getResourceSet().getLoadOptions());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void doTest(final URI usedPrimaryURI, final URI initialReferencedURI, final URI usedReferencedURI) {
    this.referencedResource.setURI(initialReferencedURI);
    final byte[] primaryBytes = this.getBytes(this.primaryResource);
    final byte[] referencedBytes = this.getBytes(this.referencedResource);
    final XtextResourceSet otherResourceSet = this.getNewResourceSet();
    final Resource newPrimaryResource = otherResourceSet.createResource(usedPrimaryURI);
    this.load(newPrimaryResource, primaryBytes);
    final Resource newReferencedResource = otherResourceSet.createResource(usedReferencedURI);
    this.load(newReferencedResource, referencedBytes);
    EcoreUtil.resolveAll(otherResourceSet);
    int _size = otherResourceSet.getResources().size();
    boolean _notEquals = (_size != 2);
    if (_notEquals) {
      throw new UnexpectedResourcesException(otherResourceSet);
    }
    final Map<EObject, Collection<EStructuralFeature.Setting>> unresolved = EcoreUtil.UnresolvedProxyCrossReferencer.find(otherResourceSet);
    boolean _isEmpty = unresolved.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      throw new UnexpectedProxiesException(unresolved);
    }
  }
  
  @Test
  public void testLoadResourceWithPrimaryURIs() {
    this.doTest(this.getResourceURI(), this.getReferencedURI(), this.getReferencedURI());
  }
  
  @Test
  public void testLoadResourceWithPackagedURIs() {
    this.doTest(this.getPackagedResourceURI(), this.getReferencedURI(), this.getPackagedReferencedURI());
  }
}
