/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.serializer.analysis;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.xtext.serializer.ISerializationContext;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class SerializationContextMap<T> {

	public static class Builder<T> {
		private Map<T, MutableEntry<T>> entries = Maps.newLinkedHashMap();

		protected Builder() {
		}

		public SerializationContextMap<T> create() {
			ImmutableList.Builder<Entry<T>> builder = ImmutableList.builder();
			for (MutableEntry<T> e : entries.values()) {
				builder.add(new Entry<T>(e.value, e.contexts));
			}
			return new SerializationContextMap<>(builder.build());
		}

		public void put(Collection<ISerializationContext> ctx, T value) {
			MutableEntry<T> entry = entries.get(value);
			if (entry == null) {
				entry = new MutableEntry<T>(value);
				entries.put(value, entry);
			}
			entry.contexts.addAll(ctx);
		}

		public void put(ISerializationContext ctx, T value) {
			MutableEntry<T> entry = entries.get(value);
			if (entry == null) {
				entry = new MutableEntry<T>(value);
				entries.put(value, entry);
			}
			entry.contexts.add(ctx);
		}
	}

	public static class Entry<T> {
		private final List<ISerializationContext> contexts;
		private final T value;

		protected Entry(T value, Collection<ISerializationContext> contexts) {
			super();
			this.value = value;
			this.contexts = ImmutableList.copyOf(contexts);
		}

		public List<ISerializationContext> getContexts() {
			return contexts;
		}

		public List<ISerializationContext> getContexts(EClass type) {
			ImmutableList.Builder<ISerializationContext> builder = ImmutableList.builder();
			for (ISerializationContext ctx : contexts) {
				if (ctx.getType() == type)
					builder.add(ctx);
			}
			return builder.build();
		}

		public Set<EClass> getTypes() {
			Set<EClass> types = Sets.newLinkedHashSet();
			for (ISerializationContext ctx : contexts) {
				types.add(ctx.getType());
			}
			return types;
		}

		public T getValue() {
			return value;
		}
	}

	protected static class MutableEntry<T> {
		private final Set<ISerializationContext> contexts = Sets.newLinkedHashSet();
		private final T value;

		protected MutableEntry(T value) {
			this.value = value;
		}
	}

	public static <T> Builder<T> builder() {
		return new Builder<T>();
	}

	private Map<ISerializationContext, T> keys = null;
	private List<Entry<T>> values;

	protected SerializationContextMap(List<Entry<T>> values) {
		super();
		this.values = values;
	}

	public T get(ISerializationContext ctx) {
		if (keys == null) {
			keys = Maps.newHashMap();
			for (Entry<T> e : values) {
				for (ISerializationContext c : e.getContexts()) {
					keys.put(c, e.getValue());
				}
			}
		}
		return keys.get(ctx);
	}

	public SerializationContextMap<T> sortedCopy() {
		List<Entry<T>> result = Lists.newArrayList();
		for (Entry<T> e : values) {
			List<ISerializationContext> ctx = Lists.newArrayList(e.getContexts());
			Collections.sort(ctx);
			result.add(new Entry<T>(e.value, ctx));
		}
		Collections.sort(result, new Comparator<Entry<T>>() {
			@Override
			public int compare(Entry<T> o1, Entry<T> o2) {
				return o1.getContexts().get(0).compareTo(o2.getContexts().get(0));
			}
		});
		return new SerializationContextMap<>(ImmutableList.copyOf(result));
	}

	public List<Entry<T>> values() {
		return values;
	}

}
