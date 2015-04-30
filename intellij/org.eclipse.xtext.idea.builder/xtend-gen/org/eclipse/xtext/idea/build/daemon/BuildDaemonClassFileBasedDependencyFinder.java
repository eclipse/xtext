/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.build.daemon;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.builder.standalone.incremental.FilesAndURIs;
import org.eclipse.xtext.builder.standalone.incremental.IClassFileBasedDependencyFinder;
import org.eclipse.xtext.idea.build.daemon.IBuildSessionSingletons;
import org.eclipse.xtext.idea.build.net.ObjectChannel;
import org.eclipse.xtext.idea.build.net.Protocol;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("all")
public class BuildDaemonClassFileBasedDependencyFinder implements IClassFileBasedDependencyFinder {
  @Inject
  @Extension
  private IBuildSessionSingletons _iBuildSessionSingletons;
  
  @Override
  public Iterable<URI> getDependentJavaFiles(final Iterable<URI> dirtyJavaFiles, final Iterable<URI> deletedJavaFiles) {
    boolean _and = false;
    boolean _isEmpty = IterableExtensions.isEmpty(dirtyJavaFiles);
    if (!_isEmpty) {
      _and = false;
    } else {
      boolean _isEmpty_1 = IterableExtensions.isEmpty(deletedJavaFiles);
      _and = _isEmpty_1;
    }
    if (_and) {
      return Collections.<URI>unmodifiableList(CollectionLiterals.<URI>newArrayList());
    }
    Protocol.JavaDependencyRequest _javaDependencyRequest = new Protocol.JavaDependencyRequest();
    final Procedure1<Protocol.JavaDependencyRequest> _function = new Procedure1<Protocol.JavaDependencyRequest>() {
      @Override
      public void apply(final Protocol.JavaDependencyRequest it) {
        List<String> _dirtyJavaFiles = it.getDirtyJavaFiles();
        final Function1<URI, String> _function = new Function1<URI, String>() {
          @Override
          public String apply(final URI it) {
            return it.toString();
          }
        };
        Iterable<String> _map = IterableExtensions.<URI, String>map(dirtyJavaFiles, _function);
        Iterables.<String>addAll(_dirtyJavaFiles, _map);
        List<String> _deletedJavaFiles = it.getDeletedJavaFiles();
        final Function1<URI, String> _function_1 = new Function1<URI, String>() {
          @Override
          public String apply(final URI it) {
            return it.toString();
          }
        };
        Iterable<String> _map_1 = IterableExtensions.<URI, String>map(deletedJavaFiles, _function_1);
        Iterables.<String>addAll(_deletedJavaFiles, _map_1);
      }
    };
    final Protocol.JavaDependencyRequest request = ObjectExtensions.<Protocol.JavaDependencyRequest>operator_doubleArrow(_javaDependencyRequest, _function);
    ObjectChannel _objectChannel = this._iBuildSessionSingletons.getObjectChannel();
    _objectChannel.writeObject(request);
    ObjectChannel _objectChannel_1 = this._iBuildSessionSingletons.getObjectChannel();
    final Serializable response = _objectChannel_1.readObject();
    if ((response instanceof Protocol.JavaDependencyResult)) {
      List<String> _dependentJavaFiles = ((Protocol.JavaDependencyResult)response).getDependentJavaFiles();
      final Function1<String, URI> _function_1 = new Function1<String, URI>() {
        @Override
        public URI apply(final String it) {
          return FilesAndURIs.asURI(it);
        }
      };
      return ListExtensions.<String, URI>map(_dependentJavaFiles, _function_1);
    } else {
      Class<? extends Serializable> _class = null;
      if (response!=null) {
        _class=response.getClass();
      }
      String _string = null;
      if (_class!=null) {
        _string=_class.toString();
      }
      String _plus = ("Invalid answer from builder process. Expected JavaDependencyResult but got " + _string);
      throw new RuntimeException(_plus);
    }
  }
}
