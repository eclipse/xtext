/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.testSetups;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;

import com.google.common.collect.Multimap;

/**
 * See also {@linkplain https://bugs.eclipse.org/bugs/show_bug.cgi?id=438740}
 * @author Sebastian Zarnekow - Initial contribution and API
 */
abstract class Bug438740<K, V> implements Multimap<K, V> {
  
  abstract class Coll extends AbstractCollection<V> {
    Collection<V> delegate;

    Coll(K key, Collection<V> delegate,
        Coll ancestor) {
      this.delegate = delegate;
    }

    abstract class Iter implements Iterator<V> {

      Iter() {
      }

      Iter(Iterator<V> delegateIterator) {
      }

    }
  }

}
