/**
 * Copyright (c) 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.resources;

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
import org.eclipse.xtext.nodemodel.BidiTreeIterator;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.persistence.IResourceStorageFacade;
import org.eclipse.xtext.resource.persistence.ResourceStorageFacade;
import org.eclipse.xtext.resource.persistence.ResourceStorageLoadable;
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
      return new ResourceStorageTest.XbaseTestWithResourceStorageFacadeStandaloneSetup().createInjectorAndDoEMFRegistration();
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
          boolean _endsWith = uri.toString().endsWith(knownUri.toString());
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
      Resource _eResource = file.eResource();
      this.resourceStorageFacade.createResourceStorageWritable(bout).writeResource(((StorageAwareResource) _eResource));
      byte[] _byteArray = bout.toByteArray();
      ByteArrayInputStream _byteArrayInputStream = new ByteArrayInputStream(_byteArray);
      final ResourceStorageLoadable in = this.resourceStorageFacade.createResourceStorageLoadable(_byteArrayInputStream);
      Resource _createResource = file.eResource().getResourceSet().createResource(URI.createURI("synthetic:/Test.___xbase"));
      final StorageAwareResource resource = ((StorageAwareResource) _createResource);
      final ResourceStorageTest.InMemoryURIConverter converter = new ResourceStorageTest.InMemoryURIConverter();
      converter.addModel(resource.getURI().toString(), contents);
      ResourceSet _resourceSet = resource.getResourceSet();
      _resourceSet.setURIConverter(converter);
      EList<Resource> _resources = file.eResource().getResourceSet().getResources();
      _resources.add(resource);
      resource.loadFromStorage(in);
      EObject _get = resource.getContents().get(0);
      final XExpression root = ((XExpression) _get);
      Assert.assertTrue((root instanceof XBlockExpression));
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
          Assert.assertTrue((((orig.getSemanticElement() != null) && (rest.getSemanticElement() != null)) || ((orig.getSemanticElement() == null) && (rest.getSemanticElement() == null))));
          EObject _semanticElement = orig.getSemanticElement();
          boolean _tripleNotEquals = (_semanticElement != null);
          if (_tripleNotEquals) {
            Assert.assertEquals(file.eResource().getURIFragment(orig.getSemanticElement()), resource.getURIFragment(rest.getSemanticElement()));
          }
          Assert.assertEquals(orig.getText(), rest.getText());
        }
      }
      Assert.assertFalse(originalNodes.hasNext());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
