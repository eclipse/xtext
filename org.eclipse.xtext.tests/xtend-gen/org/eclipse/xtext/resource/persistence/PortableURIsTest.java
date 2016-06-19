/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.resource.persistence;

import com.google.common.collect.Iterables;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.linking.LangATestLanguageStandaloneSetup;
import org.eclipse.xtext.linking.langATestLanguage.Main;
import org.eclipse.xtext.linking.langATestLanguage.Type;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.resource.persistence.IResourceStorageFacade;
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
      URI _createURI = URI.createURI("hubba:/bubba.langatestlanguage");
      Resource _createResource = resourceSet.createResource(_createURI);
      final StorageAwareResource resourceA = ((StorageAwareResource) _createResource);
      URI _createURI_1 = URI.createURI("hubba:/bubba2.langatestlanguage");
      Resource _createResource_1 = resourceSet.createResource(_createURI_1);
      final StorageAwareResource resourceB = ((StorageAwareResource) _createResource_1);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("type B");
      _builder.newLine();
      InputStream _asStream = this.getAsStream(_builder.toString());
      resourceB.load(_asStream, null);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("import \'hubba:/bubba2.langatestlanguage\'");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("type A extends B");
      _builder_1.newLine();
      InputStream _asStream_1 = this.getAsStream(_builder_1.toString());
      resourceA.load(_asStream_1, null);
      EList<EObject> _contents = resourceA.getContents();
      Iterable<Main> _filter = Iterables.<Main>filter(_contents, Main.class);
      Main _head = IterableExtensions.<Main>head(_filter);
      EList<Type> _types = _head.getTypes();
      Type _head_1 = IterableExtensions.<Type>head(_types);
      final Type extended = _head_1.getExtends();
      final URI uri = EcoreUtil.getURI(extended);
      PortableURIs _portableURIs = resourceA.getPortableURIs();
      final URI portableURI = _portableURIs.toPortableURI(resourceA, uri);
      URI _uRI = resourceA.getURI();
      URI _trimFragment = portableURI.trimFragment();
      Assert.assertEquals(_uRI, _trimFragment);
      PortableURIs _portableURIs_1 = resourceA.getPortableURIs();
      String _fragment = portableURI.fragment();
      boolean _isPortableURIFragment = _portableURIs_1.isPortableURIFragment(_fragment);
      Assert.assertTrue(_isPortableURIFragment);
      String _fragment_1 = portableURI.fragment();
      EObject _eObject = resourceA.getEObject(_fragment_1);
      Assert.assertSame(extended, _eObject);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testPortableReferenceDescriptions() {
    try {
      final XtextResourceSet resourceSet = this.<XtextResourceSet>get(XtextResourceSet.class);
      URI _createURI = URI.createURI("hubba:/bubba.langatestlanguage");
      Resource _createResource = resourceSet.createResource(_createURI);
      final StorageAwareResource resourceA = ((StorageAwareResource) _createResource);
      URI _createURI_1 = URI.createURI("hubba:/bubba2.langatestlanguage");
      Resource _createResource_1 = resourceSet.createResource(_createURI_1);
      final StorageAwareResource resourceB = ((StorageAwareResource) _createResource_1);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("type B");
      _builder.newLine();
      InputStream _asStream = this.getAsStream(_builder.toString());
      resourceB.load(_asStream, null);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("import \'hubba:/bubba2.langatestlanguage\'");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("type A extends B");
      _builder_1.newLine();
      InputStream _asStream_1 = this.getAsStream(_builder_1.toString());
      resourceA.load(_asStream_1, null);
      final ByteArrayOutputStream bout = new ByteArrayOutputStream();
      IResourceStorageFacade _resourceStorageFacade = resourceA.getResourceStorageFacade();
      final ResourceStorageWritable writable = _resourceStorageFacade.createResourceStorageWritable(bout);
      writable.writeResource(resourceA);
      IResourceStorageFacade _resourceStorageFacade_1 = resourceA.getResourceStorageFacade();
      byte[] _byteArray = bout.toByteArray();
      ByteArrayInputStream _byteArrayInputStream = new ByteArrayInputStream(_byteArray);
      final ResourceStorageLoadable loadable = _resourceStorageFacade_1.createResourceStorageLoadable(_byteArrayInputStream);
      URI _createURI_2 = URI.createURI("hubba:/bubba3.langatestlanguage");
      Resource _createResource_2 = resourceSet.createResource(_createURI_2);
      final StorageAwareResource resourceC = ((StorageAwareResource) _createResource_2);
      resourceC.loadFromStorage(loadable);
      IResourceDescription _resourceDescription = resourceC.getResourceDescription();
      Iterable<IReferenceDescription> _referenceDescriptions = _resourceDescription.getReferenceDescriptions();
      final IReferenceDescription refDesc = IterableExtensions.<IReferenceDescription>head(_referenceDescriptions);
      EList<EObject> _contents = resourceB.getContents();
      EObject _head = IterableExtensions.<EObject>head(_contents);
      EList<Type> _types = ((Main) _head).getTypes();
      Type _head_1 = IterableExtensions.<Type>head(_types);
      URI _targetEObjectUri = refDesc.getTargetEObjectUri();
      EObject _eObject = resourceSet.getEObject(_targetEObjectUri, false);
      Assert.assertSame(_head_1, _eObject);
      EList<EObject> _contents_1 = resourceC.getContents();
      EObject _head_2 = IterableExtensions.<EObject>head(_contents_1);
      EList<Type> _types_1 = ((Main) _head_2).getTypes();
      Type _head_3 = IterableExtensions.<Type>head(_types_1);
      URI _sourceEObjectUri = refDesc.getSourceEObjectUri();
      EObject _eObject_1 = resourceSet.getEObject(_sourceEObjectUri, false);
      Assert.assertSame(_head_3, _eObject_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testEObjectRelativeFragments() {
    EReference _eAnnotation_Details = EcorePackage.eINSTANCE.getEAnnotation_Details();
    this.checkFragmentBothDirections(EcorePackage.eINSTANCE, _eAnnotation_Details);
    EReference _eAttribute_EAttributeType = EcorePackage.eINSTANCE.getEAttribute_EAttributeType();
    EReference _eAttribute_EAttributeType_1 = EcorePackage.eINSTANCE.getEAttribute_EAttributeType();
    this.checkFragmentBothDirections(_eAttribute_EAttributeType, _eAttribute_EAttributeType_1);
    try {
      EReference _eAnnotation_EModelElement = EcorePackage.eINSTANCE.getEAnnotation_EModelElement();
      EReference _eAttribute_EAttributeType_2 = EcorePackage.eINSTANCE.getEAttribute_EAttributeType();
      this.checkFragmentBothDirections(_eAnnotation_EModelElement, _eAttribute_EAttributeType_2);
      Assert.fail();
    } catch (final Throwable _t) {
      if (_t instanceof IllegalStateException) {
        final IllegalStateException e = (IllegalStateException)_t;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  public void checkFragmentBothDirections(final EObject container, final EObject child) {
    final PortableURIs portableURIs = new PortableURIs();
    final String fragment = portableURIs.getFragment(container, child);
    EObject _eObject = portableURIs.getEObject(container, fragment);
    Assert.assertSame(child, _eObject);
  }
}
