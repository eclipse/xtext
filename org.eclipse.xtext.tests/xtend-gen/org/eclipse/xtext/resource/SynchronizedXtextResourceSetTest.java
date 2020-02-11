/**
 * Copyright (c) 2012, 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.resource;

import com.google.common.collect.Iterables;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.AbstractXtextResourceSetTest;
import org.eclipse.xtext.resource.NullResource;
import org.eclipse.xtext.resource.SynchronizedXtextResourceSet;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class SynchronizedXtextResourceSetTest extends AbstractXtextResourceSetTest {
  @Override
  protected XtextResourceSet createEmptyResourceSet() {
    return new SynchronizedXtextResourceSet();
  }
  
  @Test
  public void testSynchronization() {
    try {
      XtextResourceSet _createEmptyResourceSet = this.createEmptyResourceSet();
      final SynchronizedXtextResourceSet resourceSet = ((SynchronizedXtextResourceSet) _createEmptyResourceSet);
      final Resource.Factory _function = (URI uri) -> {
        NullResource _xblockexpression = null;
        {
          final NullResource result = new NullResource();
          result.setURI(uri);
          _xblockexpression = result;
        }
        return _xblockexpression;
      };
      final Resource.Factory nullFactory = _function;
      resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", nullFactory);
      final ArrayList<Thread> threads = CollectionLiterals.<Thread>newArrayList();
      final Consumer<Integer> _function_1 = (Integer i) -> {
        final Runnable _function_2 = () -> {
          final ArrayList<Resource> resources = CollectionLiterals.<Resource>newArrayList();
          for (int j = 0; (j < 5000); j++) {
            {
              String _plus = (i + " ");
              String _plus_1 = (_plus + Integer.valueOf(j));
              String _plus_2 = (_plus_1 + ".xmi");
              final Resource resource = resourceSet.createResource(URI.createURI(_plus_2));
              Assert.assertNotNull(resource);
              resources.add(resource);
              URI _uRI = resource.getURI();
              String _plus_3 = (_uRI + "b");
              resource.setURI(URI.createURI(_plus_3));
            }
          }
        };
        Thread _thread = new Thread(_function_2);
        threads.add(_thread);
      };
      new IntegerRange(1, 10).forEach(_function_1);
      for (final Thread thread : threads) {
        thread.start();
      }
      for (final Thread thread_1 : threads) {
        thread_1.join();
      }
      Assert.assertEquals(50000, resourceSet.getResources().size());
      Assert.assertEquals(IterableExtensions.<Resource>toSet(resourceSet.getResources()).size(), IterableExtensions.<Resource>toSet(resourceSet.getURIResourceMap().values()).size());
      final Function1<Resource, List<URI>> _function_2 = (Resource it) -> {
        URI _uRI = it.getURI();
        URI _normalize = resourceSet.getURIConverter().normalize(it.getURI());
        return Collections.<URI>unmodifiableList(CollectionLiterals.<URI>newArrayList(_uRI, _normalize));
      };
      Assert.assertEquals(IterableExtensions.<URI>toSet(Iterables.<URI>concat(ListExtensions.<Resource, List<URI>>map(resourceSet.getResources(), _function_2))), resourceSet.getURIResourceMap().keySet());
      final Function1<Resource, String> _function_3 = (Resource it) -> {
        return it.getURI().toString();
      };
      final Function1<URI, String> _function_4 = (URI it) -> {
        return it.toString();
      };
      Assert.assertEquals(IterableExtensions.join(IterableExtensions.<String>sort(IterableExtensions.<String>toList(ListExtensions.<Resource, String>map(resourceSet.getResources(), _function_3))), "\n"), IterableExtensions.join(IterableExtensions.<String>sort(IterableExtensions.<String>toList(IterableExtensions.<URI, String>map(resourceSet.getNormalizationMap().keySet(), _function_4))), "\n"));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
