/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.resource;

import com.google.inject.Inject;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.resource.persistence.IResourceStorageFacade;
import org.eclipse.xtext.resource.persistence.ResourceStorageLoadable;
import org.eclipse.xtext.resource.persistence.ResourceStorageWriteable;
import org.eclipse.xtext.resource.persistence.StorageAwareResource;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class ResourceStorageTest extends AbstractXtendTestCase {
  @Inject
  private IResourceStorageFacade resourceStorageFacade;
  
  @Test
  public void testParsing() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package foo");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Bar {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def dispatch myMethod(String s) {}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def dispatch myMethod(CharSequence cs) {}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this.file(_builder.toString());
      final ByteArrayOutputStream bout = new ByteArrayOutputStream();
      ResourceStorageWriteable _createResourceStorageWriteable = this.resourceStorageFacade.createResourceStorageWriteable(bout);
      Resource _eResource = file.eResource();
      _createResourceStorageWriteable.writeResource(((StorageAwareResource) _eResource));
      byte[] _byteArray = bout.toByteArray();
      ByteArrayInputStream _byteArrayInputStream = new ByteArrayInputStream(_byteArray);
      final ResourceStorageLoadable in = this.resourceStorageFacade.createResourceStorageLoadable(_byteArrayInputStream);
      Resource _eResource_1 = file.eResource();
      ResourceSet _resourceSet = _eResource_1.getResourceSet();
      URI _createURI = URI.createURI("synthetic:/test/MyClass.xtend");
      final Resource resource = _resourceSet.createResource(_createURI);
      Resource _eResource_2 = file.eResource();
      ResourceSet _resourceSet_1 = _eResource_2.getResourceSet();
      EList<Resource> _resources = _resourceSet_1.getResources();
      _resources.add(resource);
      ((StorageAwareResource) resource).load(in);
      EList<EObject> _contents = resource.getContents();
      EObject _get = _contents.get(1);
      final JvmGenericType jvmClass = ((JvmGenericType) _get);
      Iterable<JvmOperation> _declaredOperations = jvmClass.getDeclaredOperations();
      JvmOperation _get_1 = ((JvmOperation[])Conversions.unwrapArray(_declaredOperations, JvmOperation.class))[2];
      EList<JvmFormalParameter> _parameters = _get_1.getParameters();
      JvmFormalParameter _head = IterableExtensions.<JvmFormalParameter>head(_parameters);
      JvmTypeReference _parameterType = _head.getParameterType();
      String _qualifiedName = _parameterType.getQualifiedName();
      Assert.assertEquals("java.lang.CharSequence", _qualifiedName);
      Iterable<JvmOperation> _declaredOperations_1 = jvmClass.getDeclaredOperations();
      JvmOperation _get_2 = ((JvmOperation[])Conversions.unwrapArray(_declaredOperations_1, JvmOperation.class))[2];
      JvmTypeReference _returnType = _get_2.getReturnType();
      String _qualifiedName_1 = _returnType.getQualifiedName();
      Assert.assertEquals("java.lang.Object", _qualifiedName_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
