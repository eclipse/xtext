/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.findReferences;

import com.google.common.collect.Iterators;
import com.google.inject.Singleton;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.findReferences.TargetURIs;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

/**
 * It is used to look up all references for a resource or object scope.
 * 
 * @author kosyakov - Initial contribution and API
 * @since 2.10
 */
@Singleton
@SuppressWarnings("all")
class AnyTargetURISet implements TargetURIs {
  @Override
  public void addAllURIs(final Iterable<URI> uris) {
  }
  
  @Override
  public void addURI(final URI uri) {
  }
  
  @Override
  public Set<URI> asSet() {
    return CollectionLiterals.<URI>emptySet();
  }
  
  @Override
  public boolean contains(final URI uri) {
    return true;
  }
  
  @Override
  public boolean containsResource(final URI resourceURI) {
    return true;
  }
  
  @Override
  public Collection<URI> getEObjectURIs(final URI resourceURI) {
    return CollectionLiterals.<URI>emptySet();
  }
  
  @Override
  public Collection<URI> getTargetResourceURIs() {
    return CollectionLiterals.<URI>emptySet();
  }
  
  @Override
  public <T extends Object> T getUserData(final TargetURIs.Key<T> key) {
    return null;
  }
  
  @Override
  public boolean isEmpty() {
    return true;
  }
  
  @Override
  public <T extends Object> void putUserData(final TargetURIs.Key<T> key, final T data) {
  }
  
  @Override
  public int size() {
    return 0;
  }
  
  @Override
  public Iterator<URI> iterator() {
    return Iterators.<URI>emptyIterator();
  }
}
