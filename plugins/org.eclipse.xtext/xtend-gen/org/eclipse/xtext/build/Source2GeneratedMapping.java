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
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.ExclusiveRange;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@FinalFieldsConstructor
@SuppressWarnings("all")
public class Source2GeneratedMapping implements Externalizable {
  private final Multimap<URI, URI> source2generated;
  
  private final Multimap<URI, URI> generated2source;
  
  private final Map<URI, String> generated2OutputConfigName;
  
  public Source2GeneratedMapping() {
    this(HashMultimap.<URI, URI>create(), HashMultimap.<URI, URI>create(), CollectionLiterals.<URI, String>newHashMap());
  }
  
  public Source2GeneratedMapping copy() {
    HashMultimap<URI, URI> _create = HashMultimap.<URI, URI>create(this.source2generated);
    HashMultimap<URI, URI> _create_1 = HashMultimap.<URI, URI>create(this.generated2source);
    HashMap<URI, String> _hashMap = new HashMap<URI, String>(this.generated2OutputConfigName);
    return new Source2GeneratedMapping(_create, _create_1, _hashMap);
  }
  
  public void addSource2Generated(final URI source, final URI generated) {
    this.addSource2Generated(source, generated, IFileSystemAccess.DEFAULT_OUTPUT);
  }
  
  public void addSource2Generated(final URI source, final URI generated, final String outputCfgName) {
    this.source2generated.put(source, generated);
    this.generated2source.put(generated, source);
    this.generated2OutputConfigName.put(generated, outputCfgName);
  }
  
  public void removeSource2Generated(final URI source, final URI generated) {
    this.source2generated.remove(source, generated);
    this.generated2source.remove(generated, source);
  }
  
  public Set<URI> deleteSource(final URI source) {
    Collection<URI> _removeAll = this.source2generated.removeAll(source);
    final HashSet<URI> generated = new HashSet<URI>(_removeAll);
    for (final URI it : generated) {
      this.generated2source.remove(it, source);
    }
    return generated;
  }
  
  public void deleteGenerated(final URI generated) {
    Collection<URI> _removeAll = this.generated2source.removeAll(generated);
    for (final URI it : _removeAll) {
      this.source2generated.remove(it, generated);
    }
    this.generated2OutputConfigName.remove(generated);
  }
  
  public String getOutputConfigName(final URI generated) {
    return this.generated2OutputConfigName.get(generated);
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
  
  @Override
  public void readExternal(final ObjectInput in) throws IOException, ClassNotFoundException {
    final int numEntries = in.readInt();
    ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, numEntries, true);
    for (final Integer i : _doubleDotLessThan) {
      {
        String _readUTF = in.readUTF();
        final URI source = URI.createURI(_readUTF);
        final int numGenerated = in.readInt();
        ExclusiveRange _doubleDotLessThan_1 = new ExclusiveRange(0, numGenerated, true);
        for (final Integer j : _doubleDotLessThan_1) {
          {
            String _readUTF_1 = in.readUTF();
            final URI generated = URI.createURI(_readUTF_1);
            final String outputConfig = in.readUTF();
            this.addSource2Generated(source, generated, outputConfig);
          }
        }
      }
    }
  }
  
  @Override
  public void writeExternal(final ObjectOutput out) throws IOException {
    Map<URI, Collection<URI>> _asMap = this.source2generated.asMap();
    final Set<Map.Entry<URI, Collection<URI>>> entries = _asMap.entrySet();
    int _size = entries.size();
    out.writeInt(_size);
    for (final Map.Entry<URI, Collection<URI>> it : entries) {
      {
        URI _key = it.getKey();
        String _string = _key.toString();
        out.writeUTF(_string);
        Collection<URI> _value = it.getValue();
        int _size_1 = _value.size();
        out.writeInt(_size_1);
        Collection<URI> _value_1 = it.getValue();
        for (final URI it_1 : _value_1) {
          {
            String _string_1 = it_1.toString();
            out.writeUTF(_string_1);
            String _elvis = null;
            String _get = this.generated2OutputConfigName.get(it_1);
            if (_get != null) {
              _elvis = _get;
            } else {
              _elvis = IFileSystemAccess.DEFAULT_OUTPUT;
            }
            out.writeUTF(_elvis);
          }
        }
      }
    }
  }
  
  public Source2GeneratedMapping(final Multimap<URI, URI> source2generated, final Multimap<URI, URI> generated2source, final Map<URI, String> generated2OutputConfigName) {
    super();
    this.source2generated = source2generated;
    this.generated2source = generated2source;
    this.generated2OutputConfigName = generated2OutputConfigName;
  }
}
