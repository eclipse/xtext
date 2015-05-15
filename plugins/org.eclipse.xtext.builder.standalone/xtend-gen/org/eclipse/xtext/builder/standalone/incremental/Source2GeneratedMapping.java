/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.builder.standalone.incremental;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@FinalFieldsConstructor
@SuppressWarnings("all")
public class Source2GeneratedMapping {
  private final Multimap<URI, URI> source2generated;
  
  private final Multimap<URI, URI> generated2source;
  
  public Source2GeneratedMapping() {
    this(HashMultimap.<URI, URI>create(), HashMultimap.<URI, URI>create());
  }
  
  public Source2GeneratedMapping copy() {
    return new Source2GeneratedMapping(this.source2generated, this.generated2source);
  }
  
  public void addSource2Generated(final URI source, final URI generated) {
    this.source2generated.put(source, generated);
    this.generated2source.put(generated, source);
  }
  
  public void removeSource2Generated(final URI source, final URI generated) {
    this.source2generated.remove(source, generated);
    this.generated2source.remove(generated, source);
  }
  
  public Set<URI> deleteSource(final URI source) {
    Collection<URI> _removeAll = this.source2generated.removeAll(source);
    final HashSet<URI> generated = new HashSet<URI>(_removeAll);
    final Procedure1<URI> _function = new Procedure1<URI>() {
      @Override
      public void apply(final URI it) {
        Source2GeneratedMapping.this.generated2source.remove(it, source);
      }
    };
    IterableExtensions.<URI>forEach(generated, _function);
    return generated;
  }
  
  public void deleteGenerated(final URI generated) {
    Collection<URI> _removeAll = this.generated2source.removeAll(generated);
    final Procedure1<URI> _function = new Procedure1<URI>() {
      @Override
      public void apply(final URI it) {
        Source2GeneratedMapping.this.source2generated.remove(it, generated);
      }
    };
    IterableExtensions.<URI>forEach(_removeAll, _function);
  }
  
  public Iterable<URI> getGenerated(final URI source) {
    return this.source2generated.get(source);
  }
  
  public Iterable<URI> getSource(final URI generated) {
    return this.generated2source.get(generated);
  }
  
  public Source2GeneratedMapping(final Multimap<URI, URI> source2generated, final Multimap<URI, URI> generated2source) {
    super();
    this.source2generated = source2generated;
    this.generated2source = generated2source;
  }
}
