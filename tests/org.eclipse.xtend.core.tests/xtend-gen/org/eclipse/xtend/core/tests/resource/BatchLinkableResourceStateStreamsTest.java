/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.resource;

import com.google.inject.Inject;
import com.google.inject.Provider;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtend.core.tests.RuntimeInjectorProvider;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.resource.persistence.ResourceStorageInputStream;
import org.eclipse.xtext.resource.persistence.ResourceStorageOutputStream;
import org.eclipse.xtext.resource.persistence.StorageAwareResource;
import org.eclipse.xtext.util.EmfFormatter;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.resource.BatchLinkableResource;
import org.eclipse.xtext.xbase.resource.BatchLinkableResourceStorageFacade;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(RuntimeInjectorProvider.class)
@SuppressWarnings("all")
public class BatchLinkableResourceStateStreamsTest {
  @Inject
  private ParseHelper<XtendFile> parser;
  
  @Inject
  private BatchLinkableResourceStorageFacade resourceStorageFacade;
  
  @Inject
  private Provider<BatchLinkableResource> resourceProvider;
  
  @Test
  public void testSerialization() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package foo");
      _builder.newLine();
      _builder.newLine();
      _builder.append("@Data class SomeClass {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("String field");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def someMethod() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("return getField()");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this.parser.parse(_builder);
      final ByteArrayOutputStream out = new ByteArrayOutputStream();
      final ResourceStorageOutputStream out2 = this.resourceStorageFacade.createResourceStorageOutputStream(out);
      Resource _eResource = file.eResource();
      out2.writeResource(((StorageAwareResource) _eResource));
      final byte[] bytes = out.toByteArray();
      final ByteArrayInputStream in = new ByteArrayInputStream(bytes);
      final ResourceStorageInputStream in2 = this.resourceStorageFacade.createResourceStorageInputStream(in);
      final BatchLinkableResource copied = this.resourceProvider.get();
      URI _createURI = URI.createURI("synthetic:/foouupll.xtend");
      copied.setURI(_createURI);
      Resource _eResource_1 = file.eResource();
      ResourceSet _resourceSet = _eResource_1.getResourceSet();
      EList<Resource> _resources = _resourceSet.getResources();
      _resources.add(copied);
      copied.load(in2);
      Resource _eResource_2 = file.eResource();
      EList<EObject> _contents = _eResource_2.getContents();
      String _listToStr = EmfFormatter.listToStr(_contents);
      EList<EObject> _contents_1 = copied.getContents();
      String _listToStr_1 = EmfFormatter.listToStr(_contents_1);
      Assert.assertEquals(_listToStr, _listToStr_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
