/*******************************************************************************
 * Copyright (c) 2017 Universite de Technologie de Belfort-Montbeliard (http://www.utbm.fr) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.lib.internal;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.function.BiFunction;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterators;

/**
 * Map implementation that is merging two maps.
 *
 * <p>If a key exists within the two merged maps, then the retained value is the one of the right map.
 *
 * @author Stephane Galland - Initial contribution and API
 * @since 2.15
 * @param <K> the type of the keys.
 * @param <V> the type of the values in the maps.
 */
@GwtCompatible
public class UnmodifiableMergingMapView<K, V> extends AbstractMap<K, V> {

	private final Map<? extends K, ? extends V> left;

	private final Map<? extends K, ? extends V> right;

	/** Construct the wrapping map.
	 *
	 * @param left the left operand to merge.
	 * @param right the right operand to merge.
	 */
	public UnmodifiableMergingMapView(Map<? extends K, ? extends V> left, Map<? extends K, ? extends V> right) {
		assert left != null : "left must not be null"; //$NON-NLS-1$
		assert right != null : "right must not be null"; //$NON-NLS-1$
		this.left = left;
		this.right = right;
	}

	@Override
	public Set<Entry<K, V>> entrySet() {
		// A call to "Sets.union(ks1, ks2)" does not work because of the equals() definition on Map.Entry.
		// This equality test breaks the unicity of the keys over the resulting Set.
		// In other words, "Sets.union(ks1, ks2)" replies all the entries that
		// are different on their keys or values.

		final Set<Entry<K, V>> diff =  difference(this.left, this.right);
		return new AbstractEarlyFailingSet<Entry<K, V>>() {
			@SuppressWarnings({ "unchecked", "rawtypes", "synthetic-access" })
			@Override
			public Iterator<Entry<K, V>> iterator() {
				return Iterators.unmodifiableIterator((Iterator) Iterators.concat(
						UnmodifiableMergingMapView.this.right.entrySet().iterator(), diff.iterator()));
			}

			@Override
			public int size() {
				return Iterators.size(iterator());
			}
		};
	}

	private static <K, V> Set<Entry<K, V>> difference(final Map<? extends K, ? extends V> left, final Map<? extends K, ? extends V> right) {
		final Predicate<Entry<? extends K, ? extends V>> notInSet = new Predicate<Map.Entry<? extends K, ? extends V>>() {
			@Override
			public boolean apply(Entry<? extends K, ? extends V> it) {
				if (it == null) {
					return false;
				}
				return !right.containsKey(it.getKey());
			}
		};

		return new AbstractEarlyFailingSet<Entry<K, V>>() {
			@SuppressWarnings({ "unchecked", "rawtypes" })
			@Override
			public Iterator<Entry<K, V>> iterator() {
				return Iterators.unmodifiableIterator((Iterator) Iterators.filter(left.entrySet().iterator(), notInSet));
			}

			@Override
			public int size() {
				return Iterators.size(iterator());
			}
		};
	}

	@Override
	public void clear() {
		// Fail even if the set is empty.
		throw new UnsupportedOperationException();
	}

	@Override
	public V put(K key, V value) {
		// Fail even if the set is empty.
		throw new UnsupportedOperationException();
	}

	@Override
	public V remove(Object key) {
		// Fail even if the set is empty.
		throw new UnsupportedOperationException();
	}

	@Override
	public void replaceAll(BiFunction<? super K, ? super V, ? extends V> function) {
		// Fail even if the set is empty.
		throw new UnsupportedOperationException();
	}

	/**
	 * Abstract implements of a set that is failing as soon as possible
	 * when modifiers are called.
	 *
	 * @param <T> the type of the set elements.
	 * @author $Author: sgalland$
	 * @version $FullVersion$
	 * @mavengroupid $GroupId$
	 * @mavenartifactid $ArtifactId$
	 */
	@GwtCompatible
	private abstract static class AbstractEarlyFailingSet<T> extends AbstractSet<T> {

		AbstractEarlyFailingSet() {
			//
		}

		@Override
		public void clear() {
			// Fail even if the set is empty.
			throw new UnsupportedOperationException();
		}

		@Override
		public boolean add(T entry) {
			// Fail even if the set is empty.
			throw new UnsupportedOperationException();
		}

		@Override
		public boolean remove(Object element) {
			// Fail even if the set is empty.
			throw new UnsupportedOperationException();
		}

	}

}
