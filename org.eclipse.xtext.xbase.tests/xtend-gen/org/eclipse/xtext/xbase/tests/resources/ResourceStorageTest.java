/**
 * Copyright (c) 2016 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.tests.resources;

import com.google.common.base.Objects;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ExtensibleURIConverterImpl;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.nodemodel.BidiTreeIterable;
import org.eclipse.xtext.nodemodel.BidiTreeIterator;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.persistence.IResourceStorageFacade;
import org.eclipse.xtext.resource.persistence.ResourceStorageFacade;
import org.eclipse.xtext.resource.persistence.ResourceStorageLoadable;
import org.eclipse.xtext.resource.persistence.ResourceStorageWritable;
import org.eclipse.xtext.resource.persistence.StorageAwareResource;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.resource.BatchLinkableResourceStorageFacade;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.eclipse.xtext.xbase.tests.XbaseInjectorProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Test for {@link BatchLinkableResourceStorageFacade} Node Model Serialization
 * 
 * @author Christian Dietrich - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(ResourceStorageTest.XbaseWithResourceStorageFacadeInjectorProvider.class)
@SuppressWarnings("all")
public class ResourceStorageTest extends AbstractXbaseTestCase {
  public static class XbaseWithResourceStorageFacadeInjectorProvider extends XbaseInjectorProvider {
    @Override
    protected Injector internalCreateInjector() {
      ResourceStorageTest.XbaseTestWithResourceStorageFacadeStandaloneSetup _xbaseTestWithResourceStorageFacadeStandaloneSetup = new ResourceStorageTest.XbaseTestWithResourceStorageFacadeStandaloneSetup();
      return _xbaseTestWithResourceStorageFacadeStandaloneSetup.createInjectorAndDoEMFRegistration();
    }
  }
  
  public static class XbaseTestWithResourceStorageFacadeStandaloneSetup extends XbaseInjectorProvider.XbaseTestStandaloneSetup {
    @Override
    public Injector createInjector() {
      ResourceStorageTest.XbaseTestWithResourceStorageFacadeRuntimeModule _xbaseTestWithResourceStorageFacadeRuntimeModule = new ResourceStorageTest.XbaseTestWithResourceStorageFacadeRuntimeModule();
      return Guice.createInjector(_xbaseTestWithResourceStorageFacadeRuntimeModule);
    }
  }
  
  public static class XbaseTestWithResourceStorageFacadeRuntimeModule extends XbaseInjectorProvider.XbaseTestRuntimeModule {
    public Class<? extends IResourceStorageFacade> bindIResourceStorageFacade() {
      return BatchLinkableResourceStorageFacade.class;
    }
  }
  
  public static class InMemoryURIConverter extends ExtensibleURIConverterImpl {
    private final Map<URI, InputStream> models = new HashMap<URI, InputStream>();
    
    public void addModel(final String uri, final String content) {
      URI _createURI = URI.createURI(uri);
      StringInputStream _stringInputStream = new StringInputStream(content);
      this.models.put(_createURI, _stringInputStream);
    }
    
    @Override
    public boolean exists(final URI uri, final Map<?, ?> options) {
      boolean result = this.models.containsKey(uri);
      if ((!result)) {
        Set<URI> _keySet = this.models.keySet();
        for (final URI knownUri : _keySet) {
          String _string = uri.toString();
          String _string_1 = knownUri.toString();
          boolean _endsWith = _string.endsWith(_string_1);
          if (_endsWith) {
            return true;
          }
        }
      }
      return result;
    }
    
    @Override
    public InputStream createInputStream(final URI uri, final Map<?, ?> options) throws IOException {
      return this.models.get(uri);
    }
  }
  
  @Inject
  private IResourceStorageFacade resourceStorageFacade;
  
  @Test
  public void testWriteAndLoad() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("var x = \"Hello\"");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("var y = \"\"");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val it = x");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("y = length.toString");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("println(x)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("y = length.toString");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("println(x)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("y = length.toString");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("println(x)");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String contents = _builder.toString();
      final XExpression file = this.expression(contents);
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
      URI _createURI = URI.createURI("synthetic:/Test.___xbase");
      Resource _createResource = _resourceSet.createResource(_createURI);
      final StorageAwareResource resource = ((StorageAwareResource) _createResource);
      final ResourceStorageTest.InMemoryURIConverter converter = new ResourceStorageTest.InMemoryURIConverter();
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
      EObject _get = _contents.get(0);
      final XExpression root = ((XExpression) _get);
      Assert.assertTrue((root instanceof XBlockExpression));
      EList<EObject> _contents_1 = resource.getContents();
      EObject _head = IterableExtensions.<EObject>head(_contents_1);
      ICompositeNode _findActualNodeFor = NodeModelUtils.findActualNodeFor(_head);
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
          EObject _grammarElement = orig.getGrammarElement();
          EObject _grammarElement_1 = rest.getGrammarElement();
          Assert.assertSame(_grammarElement, _grammarElement_1);
          Assert.assertTrue((((orig.getSemanticElement() != null) && (rest.getSemanticElement() != null)) || ((orig.getSemanticElement() == null) && (rest.getSemanticElement() == null))));
          EObject _semanticElement = orig.getSemanticElement();
          boolean _notEquals = (!Objects.equal(_semanticElement, null));
          if (_notEquals) {
            Resource _eResource_3 = file.eResource();
            EObject _semanticElement_1 = orig.getSemanticElement();
            String _uRIFragment = _eResource_3.getURIFragment(_semanticElement_1);
            EObject _semanticElement_2 = rest.getSemanticElement();
            String _uRIFragment_1 = resource.getURIFragment(_semanticElement_2);
            Assert.assertEquals(_uRIFragment, _uRIFragment_1);
          }
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
}
