/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.build.daemon;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Iterables;
import com.google.common.collect.Multimap;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.builder.standalone.incremental.IncrementalStandaloneBuilder;
import org.eclipse.xtext.idea.build.net.Protocol;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtextBuildResultCollector implements IncrementalStandaloneBuilder.FileListener {
  private Multimap<URI, URI> generatedFile2sourceURI = HashMultimap.<URI, URI>create();
  
  private Set<URI> deletedFiles = CollectionLiterals.<URI>newHashSet();
  
  public Protocol.BuildResultMessage getBuildResult() {
    Protocol.BuildResultMessage _buildResultMessage = new Protocol.BuildResultMessage();
    final Procedure1<Protocol.BuildResultMessage> _function = new Procedure1<Protocol.BuildResultMessage>() {
      @Override
      public void apply(final Protocol.BuildResultMessage it) {
        List<String> _deletedFiles = it.getDeletedFiles();
        String _string = XtextBuildResultCollector.this.deletedFiles.toString();
        _deletedFiles.add(_string);
        List<Protocol.GeneratedFile> _generatedFiles = it.getGeneratedFiles();
        Set<URI> _keySet = XtextBuildResultCollector.this.generatedFile2sourceURI.keySet();
        final Function1<URI, Protocol.GeneratedFile> _function = new Function1<URI, Protocol.GeneratedFile>() {
          @Override
          public Protocol.GeneratedFile apply(final URI generated) {
            Protocol.GeneratedFile _generatedFile = new Protocol.GeneratedFile();
            final Procedure1<Protocol.GeneratedFile> _function = new Procedure1<Protocol.GeneratedFile>() {
              @Override
              public void apply(final Protocol.GeneratedFile it) {
                String _string = generated.toString();
                it.setFile(_string);
                List<String> _sourceFiles = it.getSourceFiles();
                Collection<URI> _get = XtextBuildResultCollector.this.generatedFile2sourceURI.get(generated);
                final Function1<URI, String> _function = new Function1<URI, String>() {
                  @Override
                  public String apply(final URI it) {
                    return it.toString();
                  }
                };
                Iterable<String> _map = IterableExtensions.<URI, String>map(_get, _function);
                Iterables.<String>addAll(_sourceFiles, _map);
              }
            };
            return ObjectExtensions.<Protocol.GeneratedFile>operator_doubleArrow(_generatedFile, _function);
          }
        };
        Iterable<Protocol.GeneratedFile> _map = IterableExtensions.<URI, Protocol.GeneratedFile>map(_keySet, _function);
        Iterables.<Protocol.GeneratedFile>addAll(_generatedFiles, _map);
      }
    };
    return ObjectExtensions.<Protocol.BuildResultMessage>operator_doubleArrow(_buildResultMessage, _function);
  }
  
  @Override
  public void fileGenerated(final URI source, final URI target) {
    this.generatedFile2sourceURI.put(target, source);
  }
  
  @Override
  public void fileDeleted(final URI file) {
    this.deletedFiles.add(file);
  }
}
