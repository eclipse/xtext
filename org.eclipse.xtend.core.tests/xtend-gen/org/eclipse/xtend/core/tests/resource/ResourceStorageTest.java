/**
 * Copyright (c) 2014, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.tests.resource;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.tests.util.InMemoryURIConverter;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.nodemodel.BidiTreeIterator;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.persistence.IResourceStorageFacade;
import org.eclipse.xtext.resource.persistence.ResourceStorageFacade;
import org.eclipse.xtext.resource.persistence.ResourceStorageLoadable;
import org.eclipse.xtext.resource.persistence.StorageAwareResource;
import org.eclipse.xtext.xbase.compiler.DocumentationAdapter;
import org.eclipse.xtext.xbase.jvmmodel.JvmModelAssociator;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.resource.BatchLinkableResource;
import org.eclipse.xtext.xbase.resource.BatchLinkableResourceStorageWritable;
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
  public void testWriteAndLoad() {
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
      _builder.append("/**");
      _builder.newLine();
      _builder.append("\t ");
      _builder.append("* Hello myMethod");
      _builder.newLine();
      _builder.append("\t ");
      _builder.append("*/");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def dispatch myMethod(CharSequence cs) {}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def dispatch other(String it) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("var x = \"\"");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("x = length.toString");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("println(x)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String contents = _builder.toString();
      final XtendFile file = this.file(contents);
      Resource _eResource = file.eResource();
      final StorageAwareResource originalResource = ((StorageAwareResource) _eResource);
      Adapter _existingAdapter = EcoreUtil.getExistingAdapter(originalResource, JvmModelAssociator.Adapter.class);
      final JvmModelAssociator.Adapter originalAdapter = ((JvmModelAssociator.Adapter) _existingAdapter);
      final ByteArrayOutputStream bout = new ByteArrayOutputStream();
      ((ResourceStorageFacade) this.resourceStorageFacade).setStoreNodeModel(true);
      this.resourceStorageFacade.createResourceStorageWritable(bout).writeResource(originalResource);
      byte[] _byteArray = bout.toByteArray();
      ByteArrayInputStream _byteArrayInputStream = new ByteArrayInputStream(_byteArray);
      final ResourceStorageLoadable in = this.resourceStorageFacade.createResourceStorageLoadable(_byteArrayInputStream);
      Resource _createResource = file.eResource().getResourceSet().createResource(URI.createURI("synthetic:/test/MyClass.xtend"));
      final StorageAwareResource resource = ((StorageAwareResource) _createResource);
      final InMemoryURIConverter converter = new InMemoryURIConverter();
      converter.addModel(resource.getURI().toString(), contents);
      ResourceSet _resourceSet = resource.getResourceSet();
      _resourceSet.setURIConverter(converter);
      EList<Resource> _resources = file.eResource().getResourceSet().getResources();
      _resources.add(resource);
      resource.loadFromStorage(in);
      EObject _get = resource.getContents().get(1);
      final JvmGenericType jvmClass = ((JvmGenericType) _get);
      Assert.assertEquals("java.lang.CharSequence", IterableExtensions.<JvmFormalParameter>head((((JvmOperation[])Conversions.unwrapArray(jvmClass.getDeclaredOperations(), JvmOperation.class))[2]).getParameters()).getParameterType().getQualifiedName());
      Assert.assertEquals("java.lang.Object", (((JvmOperation[])Conversions.unwrapArray(jvmClass.getDeclaredOperations(), JvmOperation.class))[2]).getReturnType().getQualifiedName());
      Assert.assertEquals("Hello myMethod", IterableExtensions.<DocumentationAdapter>head(Iterables.<DocumentationAdapter>filter((((JvmOperation[])Conversions.unwrapArray(jvmClass.getDeclaredOperations(), JvmOperation.class))[1]).eAdapters(), DocumentationAdapter.class)).getDocumentation());
      Assert.assertEquals(resource.getURI(), resource.getResourceDescription().getURI());
      Assert.assertEquals(2, IterableExtensions.size(resource.getResourceDescription().getExportedObjects()));
      Assert.assertEquals("foo.Bar", IterableExtensions.<IEObjectDescription>head(resource.getResourceDescription().getExportedObjects()).getQualifiedName().toString());
      final BidiTreeIterator<INode> restoredNodes = NodeModelUtils.findActualNodeFor(IterableExtensions.<EObject>head(resource.getContents())).getAsTreeIterable().iterator();
      final BidiTreeIterator<INode> originalNodes = NodeModelUtils.findActualNodeFor(file).getAsTreeIterable().iterator();
      while (restoredNodes.hasNext()) {
        {
          final INode rest = restoredNodes.next();
          final INode orig = originalNodes.next();
          Assert.assertEquals(orig.getStartLine(), rest.getStartLine());
          Assert.assertEquals(orig.getEndLine(), rest.getEndLine());
          Assert.assertEquals(orig.getOffset(), rest.getOffset());
          Assert.assertEquals(orig.getEndOffset(), rest.getEndOffset());
          Assert.assertEquals(orig.getLength(), rest.getLength());
          Assert.assertEquals(orig.getTotalStartLine(), rest.getTotalStartLine());
          Assert.assertEquals(orig.getTotalEndLine(), rest.getTotalEndLine());
          Assert.assertEquals(orig.getTotalOffset(), rest.getTotalOffset());
          Assert.assertEquals(orig.getTotalEndOffset(), rest.getTotalEndOffset());
          Assert.assertEquals(orig.getTotalLength(), rest.getTotalLength());
          Assert.assertSame(orig.getGrammarElement(), rest.getGrammarElement());
          Assert.assertEquals(file.eResource().getURIFragment(orig.getSemanticElement()), resource.getURIFragment(rest.getSemanticElement()));
          Assert.assertEquals(orig.getText(), rest.getText());
        }
      }
      Assert.assertFalse(originalNodes.hasNext());
      Adapter _existingAdapter_1 = EcoreUtil.getExistingAdapter(resource, JvmModelAssociator.Adapter.class);
      final JvmModelAssociator.Adapter restoredAdapter = ((JvmModelAssociator.Adapter) _existingAdapter_1);
      Assert.assertEquals(originalAdapter.logicalContainerMap.size(), restoredAdapter.logicalContainerMap.size());
      Assert.assertEquals(originalAdapter.sourceToTargetMap.size(), restoredAdapter.sourceToTargetMap.size());
      Assert.assertEquals(originalAdapter.targetToSourceMap.size(), restoredAdapter.targetToSourceMap.size());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test(expected = IOException.class)
  public void testFailedWrite() throws Exception {
    final XtendFile file = this.file("class C{}");
    ByteArrayOutputStream _byteArrayOutputStream = new ByteArrayOutputStream();
    Resource _eResource = file.eResource();
    new BatchLinkableResourceStorageWritable(_byteArrayOutputStream, false) {
      @Override
      protected void writeAssociationsAdapter(final BatchLinkableResource resource, final OutputStream zipOut) throws IOException {
        final Function1<Adapter, Boolean> _function = (Adapter it) -> {
          return Boolean.valueOf((it instanceof JvmModelAssociator.Adapter));
        };
        final Adapter removeMe = IterableExtensions.<Adapter>findFirst(resource.eAdapters(), _function);
        Assert.assertTrue(resource.eAdapters().remove(removeMe));
        super.writeAssociationsAdapter(resource, zipOut);
      }
    }.writeResource(((StorageAwareResource) _eResource));
  }

  @Test
  public void testConstantValueIsPersisted() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class C {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("static val CONSTANT = \'a\' + \'b\' + 0");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String contents = _builder.toString();
      final XtendFile file = this.file(contents);
      final ByteArrayOutputStream bout = new ByteArrayOutputStream();
      ((ResourceStorageFacade) this.resourceStorageFacade).setStoreNodeModel(true);
      Resource _eResource = file.eResource();
      this.resourceStorageFacade.createResourceStorageWritable(bout).writeResource(((StorageAwareResource) _eResource));
      byte[] _byteArray = bout.toByteArray();
      ByteArrayInputStream _byteArrayInputStream = new ByteArrayInputStream(_byteArray);
      final ResourceStorageLoadable in = this.resourceStorageFacade.createResourceStorageLoadable(_byteArrayInputStream);
      Resource _createResource = file.eResource().getResourceSet().createResource(URI.createURI("synthetic:/test/MyClass.xtend"));
      final StorageAwareResource resource = ((StorageAwareResource) _createResource);
      final InMemoryURIConverter converter = new InMemoryURIConverter();
      converter.addModel(resource.getURI().toString(), contents);
      ResourceSet _resourceSet = resource.getResourceSet();
      _resourceSet.setURIConverter(converter);
      EList<Resource> _resources = file.eResource().getResourceSet().getResources();
      _resources.add(resource);
      resource.loadFromStorage(in);
      EObject _get = resource.getContents().get(1);
      final JvmGenericType jvmClass = ((JvmGenericType) _get);
      JvmMember _lastOrNull = IterableExtensions.<JvmMember>lastOrNull(jvmClass.getMembers());
      final JvmField field = ((JvmField) _lastOrNull);
      Assert.assertTrue(field.isConstant());
      Assert.assertTrue(field.isSetConstant());
      Assert.assertEquals("ab0", field.getConstantValue());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testConstantValueIsPersisted_01() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class C {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("static val CONSTANT = Object");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String contents = _builder.toString();
      final XtendFile file = this.file(contents);
      final ByteArrayOutputStream bout = new ByteArrayOutputStream();
      ((ResourceStorageFacade) this.resourceStorageFacade).setStoreNodeModel(true);
      Resource _eResource = file.eResource();
      this.resourceStorageFacade.createResourceStorageWritable(bout).writeResource(((StorageAwareResource) _eResource));
      byte[] _byteArray = bout.toByteArray();
      ByteArrayInputStream _byteArrayInputStream = new ByteArrayInputStream(_byteArray);
      final ResourceStorageLoadable in = this.resourceStorageFacade.createResourceStorageLoadable(_byteArrayInputStream);
      Resource _createResource = file.eResource().getResourceSet().createResource(URI.createURI("synthetic:/test/MyClass.xtend"));
      final StorageAwareResource resource = ((StorageAwareResource) _createResource);
      final InMemoryURIConverter converter = new InMemoryURIConverter();
      converter.addModel(resource.getURI().toString(), contents);
      ResourceSet _resourceSet = resource.getResourceSet();
      _resourceSet.setURIConverter(converter);
      EList<Resource> _resources = file.eResource().getResourceSet().getResources();
      _resources.add(resource);
      resource.loadFromStorage(in);
      EObject _get = resource.getContents().get(1);
      final JvmGenericType jvmClass = ((JvmGenericType) _get);
      JvmMember _lastOrNull = IterableExtensions.<JvmMember>lastOrNull(jvmClass.getMembers());
      final JvmField field = ((JvmField) _lastOrNull);
      Assert.assertFalse(field.isConstant());
      Assert.assertTrue(field.isSetConstant());
      Assert.assertNull(field.getConstantValue());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
