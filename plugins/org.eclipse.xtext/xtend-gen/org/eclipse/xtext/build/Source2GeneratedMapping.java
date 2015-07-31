/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.build;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
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
    HashMultimap<URI, URI> _create = HashMultimap.<URI, URI>create(this.source2generated);
    HashMultimap<URI, URI> _create_1 = HashMultimap.<URI, URI>create(this.generated2source);
    return new Source2GeneratedMapping(_create, _create_1);
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
  
  public List<URI> getGenerated(final URI source) {
    Collection<URI> _get = this.source2generated.get(source);
    return Lists.<URI>newArrayList(_get);
  }
  
  public List<URI> getSource(final URI generated) {
    Collection<URI> _get = this.generated2source.get(generated);
    return Lists.<URI>newArrayList(_get);
  }
  
  public List<URI> getAllGenerated() {
    Set<URI> _keySet = this.generated2source.keySet();
    return Lists.<URI>newArrayList(_keySet);
  }
  
  public Source2GeneratedMapping(final Multimap<URI, URI> source2generated, final Multimap<URI, URI> generated2source) {
    super();
    this.source2generated = source2generated;
    this.generated2source = generated2source;
  }
}
