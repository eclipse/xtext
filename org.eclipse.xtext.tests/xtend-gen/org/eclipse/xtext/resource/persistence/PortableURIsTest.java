/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.resource.persistence;

import com.google.common.collect.Iterables;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.linking.LangATestLanguageStandaloneSetup;
import org.eclipse.xtext.linking.langATestLanguage.Main;
import org.eclipse.xtext.linking.langATestLanguage.Type;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.resource.persistence.PortableURIs;
import org.eclipse.xtext.resource.persistence.ResourceStorageLoadable;
import org.eclipse.xtext.resource.persistence.ResourceStorageWritable;
import org.eclipse.xtext.resource.persistence.StorageAwareResource;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class PortableURIsTest extends AbstractXtextTests {
  @Override
  public void setUp() throws Exception {
    super.setUp();
    LangATestLanguageStandaloneSetup _langATestLanguageStandaloneSetup = new LangATestLanguageStandaloneSetup();
    this.with(_langATestLanguageStandaloneSetup);
  }
  
  @Test
  public void testPortableUris() {
    try {
      final XtextResourceSet resourceSet = this.<XtextResourceSet>get(XtextResourceSet.class);
      Resource _createResource = resourceSet.createResource(URI.createURI("hubba:/bubba.langatestlanguage"));
      final StorageAwareResource resourceA = ((StorageAwareResource) _createResource);
      Resource _createResource_1 = resourceSet.createResource(URI.createURI("hubba:/bubba2.langatestlanguage"));
      final StorageAwareResource resourceB = ((StorageAwareResource) _createResource_1);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("type B");
      _builder.newLine();
      resourceB.load(this.getAsStream(_builder.toString()), null);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("import \'hubba:/bubba2.langatestlanguage\'");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("type A extends B");
      _builder_1.newLine();
      resourceA.load(this.getAsStream(_builder_1.toString()), null);
      final Type extended = IterableExtensions.<Type>head(IterableExtensions.<Main>head(Iterables.<Main>filter(resourceA.getContents(), Main.class)).getTypes()).getExtends();
      final URI uri = EcoreUtil.getURI(extended);
      final URI portableURI = resourceA.getPortableURIs().toPortableURI(resourceA, uri);
      Assert.assertEquals(resourceA.getURI(), portableURI.trimFragment());
      Assert.assertTrue(resourceA.getPortableURIs().isPortableURIFragment(portableURI.fragment()));
      Assert.assertSame(extended, resourceA.getEObject(portableURI.fragment()));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testPortableReferenceDescriptions() {
    try {
      final XtextResourceSet resourceSet = this.<XtextResourceSet>get(XtextResourceSet.class);
      Resource _createResource = resourceSet.createResource(URI.createURI("hubba:/bubba.langatestlanguage"));
      final StorageAwareResource resourceA = ((StorageAwareResource) _createResource);
      Resource _createResource_1 = resourceSet.createResource(URI.createURI("hubba:/bubba2.langatestlanguage"));
      final StorageAwareResource resourceB = ((StorageAwareResource) _createResource_1);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("type B");
      _builder.newLine();
      resourceB.load(this.getAsStream(_builder.toString()), null);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("import \'hubba:/bubba2.langatestlanguage\'");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("type A extends B");
      _builder_1.newLine();
      resourceA.load(this.getAsStream(_builder_1.toString()), null);
      final ByteArrayOutputStream bout = new ByteArrayOutputStream();
      final ResourceStorageWritable writable = resourceA.getResourceStorageFacade().createResourceStorageWritable(bout);
      writable.writeResource(resourceA);
      byte[] _byteArray = bout.toByteArray();
      ByteArrayInputStream _byteArrayInputStream = new ByteArrayInputStream(_byteArray);
      final ResourceStorageLoadable loadable = resourceA.getResourceStorageFacade().createResourceStorageLoadable(_byteArrayInputStream);
      Resource _createResource_2 = resourceSet.createResource(URI.createURI("hubba:/bubba3.langatestlanguage"));
      final StorageAwareResource resourceC = ((StorageAwareResource) _createResource_2);
      resourceC.loadFromStorage(loadable);
      final IReferenceDescription refDesc = IterableExtensions.<IReferenceDescription>head(resourceC.getResourceDescription().getReferenceDescriptions());
      EObject _head = IterableExtensions.<EObject>head(resourceB.getContents());
      Assert.assertSame(IterableExtensions.<Type>head(((Main) _head).getTypes()), resourceSet.getEObject(refDesc.getTargetEObjectUri(), false));
      EObject _head_1 = IterableExtensions.<EObject>head(resourceC.getContents());
      Assert.assertSame(IterableExtensions.<Type>head(((Main) _head_1).getTypes()), resourceSet.getEObject(refDesc.getSourceEObjectUri(), false));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testEObjectRelativeFragments() {
    this.checkFragmentBothDirections(EcorePackage.eINSTANCE, EcorePackage.eINSTANCE.getEAnnotation_Details());
    this.checkFragmentBothDirections(EcorePackage.eINSTANCE.getEAttribute_EAttributeType(), EcorePackage.eINSTANCE.getEAttribute_EAttributeType());
    try {
      this.checkFragmentBothDirections(EcorePackage.eINSTANCE.getEAnnotation_EModelElement(), EcorePackage.eINSTANCE.getEAttribute_EAttributeType());
      Assert.fail();
    } catch (final Throwable _t) {
      if (_t instanceof IllegalStateException) {
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  public void checkFragmentBothDirections(final EObject container, final EObject child) {
    final PortableURIs portableURIs = new PortableURIs();
    final String fragment = portableURIs.getFragment(container, child);
    Assert.assertSame(child, portableURIs.getEObject(container, fragment));
  }
}
