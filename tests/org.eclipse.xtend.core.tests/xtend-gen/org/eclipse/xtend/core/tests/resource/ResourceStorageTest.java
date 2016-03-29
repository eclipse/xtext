/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.AbstractGrammarElement;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.junit4.util.InMemoryURIConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.nodemodel.BidiTreeIterable;
import org.eclipse.xtext.nodemodel.BidiTreeIterator;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.persistence.IResourceStorageFacade;
import org.eclipse.xtext.resource.persistence.ResourceStorageFacade;
import org.eclipse.xtext.resource.persistence.ResourceStorageLoadable;
import org.eclipse.xtext.resource.persistence.ResourceStorageWritable;
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
      _builder.append("* Hello myMethod ");
      _builder.newLine();
      _builder.append("\t ");
      _builder.append("*/");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def dispatch myMethod(CharSequence cs) {}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String contents = _builder.toString();
      final XtendFile file = this.file(contents);
      final ByteArrayOutputStream bout = new ByteArrayOutputStream();
      ((ResourceStorageFacade) this.resourceStorageFacade).setStoreNodeModel(true);
      ResourceStorageWritable _createResourceStorageWritable = this.resourceStorageFacade.createResourceStorageWritable(bout);
      Resource _eResource = file.eResource();
      _createResourceStorageWritable.writeResource(((StorageAwareResource) _eResource));
      byte[] _byteArray = bout.toByteArray();
      ByteArrayInputStream _byteArrayInputStream = new ByteArrayInputStream(_byteArray);
      final ResourceStorageLoadable in = this.resourceStorageFacade.createResourceStorageLoadable(_byteArrayInputStream);
      Resource _eResource_1 = file.eResource();
      ResourceSet _resourceSet = _eResource_1.getResourceSet();
      URI _createURI = URI.createURI("synthetic:/test/MyClass.xtend");
      Resource _createResource = _resourceSet.createResource(_createURI);
      final StorageAwareResource resource = ((StorageAwareResource) _createResource);
      final InMemoryURIConverter converter = new InMemoryURIConverter();
      URI _uRI = resource.getURI();
      String _string = _uRI.toString();
      converter.addModel(_string, contents);
      ResourceSet _resourceSet_1 = resource.getResourceSet();
      _resourceSet_1.setURIConverter(converter);
      Resource _eResource_2 = file.eResource();
      ResourceSet _resourceSet_2 = _eResource_2.getResourceSet();
      EList<Resource> _resources = _resourceSet_2.getResources();
      _resources.add(resource);
      resource.loadFromStorage(in);
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
      Iterable<JvmOperation> _declaredOperations_2 = jvmClass.getDeclaredOperations();
      JvmOperation _get_3 = ((JvmOperation[])Conversions.unwrapArray(_declaredOperations_2, JvmOperation.class))[1];
      EList<Adapter> _eAdapters = _get_3.eAdapters();
      Iterable<DocumentationAdapter> _filter = Iterables.<DocumentationAdapter>filter(_eAdapters, DocumentationAdapter.class);
      DocumentationAdapter _head_1 = IterableExtensions.<DocumentationAdapter>head(_filter);
      String _documentation = _head_1.getDocumentation();
      Assert.assertEquals("Hello myMethod", _documentation);
      URI _uRI_1 = resource.getURI();
      IResourceDescription _resourceDescription = resource.getResourceDescription();
      URI _uRI_2 = _resourceDescription.getURI();
      Assert.assertEquals(_uRI_1, _uRI_2);
      IResourceDescription _resourceDescription_1 = resource.getResourceDescription();
      Iterable<IEObjectDescription> _exportedObjects = _resourceDescription_1.getExportedObjects();
      int _size = IterableExtensions.size(_exportedObjects);
      Assert.assertEquals(1, _size);
      IResourceDescription _resourceDescription_2 = resource.getResourceDescription();
      Iterable<IEObjectDescription> _exportedObjects_1 = _resourceDescription_2.getExportedObjects();
      IEObjectDescription _head_2 = IterableExtensions.<IEObjectDescription>head(_exportedObjects_1);
      QualifiedName _qualifiedName_2 = _head_2.getQualifiedName();
      String _string_1 = _qualifiedName_2.toString();
      Assert.assertEquals("foo.Bar", _string_1);
      EList<EObject> _contents_1 = resource.getContents();
      EObject _head_3 = IterableExtensions.<EObject>head(_contents_1);
      ICompositeNode _findActualNodeFor = NodeModelUtils.findActualNodeFor(_head_3);
      BidiTreeIterable<INode> _asTreeIterable = _findActualNodeFor.getAsTreeIterable();
      final BidiTreeIterator<INode> restoredNodes = _asTreeIterable.iterator();
      ICompositeNode _findActualNodeFor_1 = NodeModelUtils.findActualNodeFor(file);
      BidiTreeIterable<INode> _asTreeIterable_1 = _findActualNodeFor_1.getAsTreeIterable();
      final BidiTreeIterator<INode> originalNodes = _asTreeIterable_1.iterator();
      while (restoredNodes.hasNext()) {
        {
          final INode rest = restoredNodes.next();
          final INode orig = originalNodes.next();
          int _startLine = orig.getStartLine();
          int _startLine_1 = rest.getStartLine();
          Assert.assertEquals(_startLine, _startLine_1);
          int _endLine = orig.getEndLine();
          int _endLine_1 = rest.getEndLine();
          Assert.assertEquals(_endLine, _endLine_1);
          int _offset = orig.getOffset();
          int _offset_1 = rest.getOffset();
          Assert.assertEquals(_offset, _offset_1);
          int _endOffset = orig.getEndOffset();
          int _endOffset_1 = rest.getEndOffset();
          Assert.assertEquals(_endOffset, _endOffset_1);
          int _length = orig.getLength();
          int _length_1 = rest.getLength();
          Assert.assertEquals(_length, _length_1);
          int _totalStartLine = orig.getTotalStartLine();
          int _totalStartLine_1 = rest.getTotalStartLine();
          Assert.assertEquals(_totalStartLine, _totalStartLine_1);
          int _totalEndLine = orig.getTotalEndLine();
          int _totalEndLine_1 = rest.getTotalEndLine();
          Assert.assertEquals(_totalEndLine, _totalEndLine_1);
          int _totalOffset = orig.getTotalOffset();
          int _totalOffset_1 = rest.getTotalOffset();
          Assert.assertEquals(_totalOffset, _totalOffset_1);
          int _totalEndOffset = orig.getTotalEndOffset();
          int _totalEndOffset_1 = rest.getTotalEndOffset();
          Assert.assertEquals(_totalEndOffset, _totalEndOffset_1);
          int _totalLength = orig.getTotalLength();
          int _totalLength_1 = rest.getTotalLength();
          Assert.assertEquals(_totalLength, _totalLength_1);
          AbstractGrammarElement _grammarElement = orig.getGrammarElement();
          AbstractGrammarElement _grammarElement_1 = rest.getGrammarElement();
          Assert.assertSame(_grammarElement, _grammarElement_1);
          Resource _eResource_3 = file.eResource();
          EObject _semanticElement = orig.getSemanticElement();
          String _uRIFragment = _eResource_3.getURIFragment(_semanticElement);
          EObject _semanticElement_1 = rest.getSemanticElement();
          String _uRIFragment_1 = resource.getURIFragment(_semanticElement_1);
          Assert.assertEquals(_uRIFragment, _uRIFragment_1);
          String _text = orig.getText();
          String _text_1 = rest.getText();
          Assert.assertEquals(_text, _text_1);
        }
      }
      boolean _hasNext = originalNodes.hasNext();
      Assert.assertFalse(_hasNext);
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
        EList<Adapter> _eAdapters = resource.eAdapters();
        final Function1<Adapter, Boolean> _function = new Function1<Adapter, Boolean>() {
          @Override
          public Boolean apply(final Adapter it) {
            return Boolean.valueOf((it instanceof JvmModelAssociator.Adapter));
          }
        };
        final Adapter removeMe = IterableExtensions.<Adapter>findFirst(_eAdapters, _function);
        EList<Adapter> _eAdapters_1 = resource.eAdapters();
        boolean _remove = _eAdapters_1.remove(removeMe);
        Assert.assertTrue(_remove);
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
      ResourceStorageWritable _createResourceStorageWritable = this.resourceStorageFacade.createResourceStorageWritable(bout);
      Resource _eResource = file.eResource();
      _createResourceStorageWritable.writeResource(((StorageAwareResource) _eResource));
      byte[] _byteArray = bout.toByteArray();
      ByteArrayInputStream _byteArrayInputStream = new ByteArrayInputStream(_byteArray);
      final ResourceStorageLoadable in = this.resourceStorageFacade.createResourceStorageLoadable(_byteArrayInputStream);
      Resource _eResource_1 = file.eResource();
      ResourceSet _resourceSet = _eResource_1.getResourceSet();
      URI _createURI = URI.createURI("synthetic:/test/MyClass.xtend");
      Resource _createResource = _resourceSet.createResource(_createURI);
      final StorageAwareResource resource = ((StorageAwareResource) _createResource);
      final InMemoryURIConverter converter = new InMemoryURIConverter();
      URI _uRI = resource.getURI();
      String _string = _uRI.toString();
      converter.addModel(_string, contents);
      ResourceSet _resourceSet_1 = resource.getResourceSet();
      _resourceSet_1.setURIConverter(converter);
      Resource _eResource_2 = file.eResource();
      ResourceSet _resourceSet_2 = _eResource_2.getResourceSet();
      EList<Resource> _resources = _resourceSet_2.getResources();
      _resources.add(resource);
      resource.loadFromStorage(in);
      EList<EObject> _contents = resource.getContents();
      EObject _get = _contents.get(1);
      final JvmGenericType jvmClass = ((JvmGenericType) _get);
      EList<JvmMember> _members = jvmClass.getMembers();
      JvmMember _last = IterableExtensions.<JvmMember>last(_members);
      final JvmField field = ((JvmField) _last);
      boolean _isConstant = field.isConstant();
      Assert.assertTrue(_isConstant);
      boolean _isSetConstant = field.isSetConstant();
      Assert.assertTrue(_isSetConstant);
      Object _constantValue = field.getConstantValue();
      Assert.assertEquals("ab0", _constantValue);
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
      ResourceStorageWritable _createResourceStorageWritable = this.resourceStorageFacade.createResourceStorageWritable(bout);
      Resource _eResource = file.eResource();
      _createResourceStorageWritable.writeResource(((StorageAwareResource) _eResource));
      byte[] _byteArray = bout.toByteArray();
      ByteArrayInputStream _byteArrayInputStream = new ByteArrayInputStream(_byteArray);
      final ResourceStorageLoadable in = this.resourceStorageFacade.createResourceStorageLoadable(_byteArrayInputStream);
      Resource _eResource_1 = file.eResource();
      ResourceSet _resourceSet = _eResource_1.getResourceSet();
      URI _createURI = URI.createURI("synthetic:/test/MyClass.xtend");
      Resource _createResource = _resourceSet.createResource(_createURI);
      final StorageAwareResource resource = ((StorageAwareResource) _createResource);
      final InMemoryURIConverter converter = new InMemoryURIConverter();
      URI _uRI = resource.getURI();
      String _string = _uRI.toString();
      converter.addModel(_string, contents);
      ResourceSet _resourceSet_1 = resource.getResourceSet();
      _resourceSet_1.setURIConverter(converter);
      Resource _eResource_2 = file.eResource();
      ResourceSet _resourceSet_2 = _eResource_2.getResourceSet();
      EList<Resource> _resources = _resourceSet_2.getResources();
      _resources.add(resource);
      resource.loadFromStorage(in);
      EList<EObject> _contents = resource.getContents();
      EObject _get = _contents.get(1);
      final JvmGenericType jvmClass = ((JvmGenericType) _get);
      EList<JvmMember> _members = jvmClass.getMembers();
      JvmMember _last = IterableExtensions.<JvmMember>last(_members);
      final JvmField field = ((JvmField) _last);
      boolean _isConstant = field.isConstant();
      Assert.assertFalse(_isConstant);
      boolean _isSetConstant = field.isSetConstant();
      Assert.assertTrue(_isSetConstant);
      Object _constantValue = field.getConstantValue();
      Assert.assertNull(_constantValue);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
