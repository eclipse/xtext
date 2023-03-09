/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.util;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.google.common.base.Joiner;
import com.google.common.base.Joiner.MapJoiner;
import com.google.common.collect.Multimap;

/**
 * An object that joins multimaps in the same manner as {@code Joiner} joins iterables and arrays. Like {@code Joiner}, 
 * it is thread-safe and immutable.
 * 
 * <p>
 * In contrast to using a {@link MapJoiner} in conjunction with {@link Multimap}, the {@link MultimapJoiner} allows to use
 * a custom joiner for the values of an entry.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class MultimapJoiner {
	private final Joiner entryJoiner;
	private final String keyValueSeparator;
	private final String separator;

	public MultimapJoiner(Joiner entryJoiner, String separator, String keyValueSeparator) {
		this.entryJoiner = entryJoiner;
		this.separator = separator;
		this.keyValueSeparator = keyValueSeparator;
	}

	/**
	 * Appends the string representation of each entry of {@code map}, using the previously configured separator and
	 * key-value separator, to {@code appendable}.
	 */
	public <A extends Appendable> A appendTo(A appendable, Multimap<?, ?> map) throws IOException {
		return appendTo(appendable, map.asMap().entrySet());
	}
	
	/**
	 * Appends the string representation of each entry of {@code map}, using the previously configured separator and
	 * key-value separator, to {@code appendable}.
	 */
	public <A extends Appendable> A appendTo(A appendable, Map<?, ? extends Collection<?>> map) throws IOException {
		return appendTo(appendable, map.entrySet());
	}

	/**
	 * Appends the string representation of each entry of {@code map}, using the previously configured separator and
	 * key-value separator, to {@code builder}. Identical to {@link #appendTo(Appendable, Multimap)}, except that it
	 * does not throw {@link IOException}.
	 */
	public StringBuilder appendTo(StringBuilder builder, Multimap<?, ?> map) {
		return appendTo(builder, map.asMap().entrySet());
	}
	
	/**
	 * Appends the string representation of each entry of {@code map}, using the previously configured separator and
	 * key-value separator, to {@code builder}. Identical to {@link #appendTo(Appendable, Map)}, except that it
	 * does not throw {@link IOException}.
	 */
	public StringBuilder appendTo(StringBuilder builder, Map<?, ? extends Collection<?>> map) {
		return appendTo(builder, map.entrySet());
	}

	/**
	 * Returns a string containing the string representation of each entry of {@code map}, using the previously
	 * configured separator and key-value separator.
	 */
	public String join(Multimap<?, ?> map) {
		return join(map.asMap().entrySet());
	}

	/**
	 * Appends the string representation of each entry in {@code entries}, using the previously configured separator and
	 * key-value separator, to {@code appendable}.
	 */
	public <A extends Appendable> A appendTo(A appendable, Iterable<? extends Entry<?, ? extends Collection<?>>> entries)
			throws IOException {
		//    checkNotNull(appendable);
		Iterator<? extends Entry<?, ? extends Collection<?>>> iterator = entries.iterator();
		if (iterator.hasNext()) {
			Entry<?, ? extends Collection<?>> entry = iterator.next();
			appendable.append(toString(entry.getKey()));
			appendable.append(keyValueSeparator);
			entryJoiner.appendTo(appendable, entry.getValue());
			while (iterator.hasNext()) {
				appendable.append(separator);
				Entry<?, ? extends Collection<?>> e = iterator.next();
				appendable.append(toString(e.getKey()));
				appendable.append(keyValueSeparator);
				entryJoiner.appendTo(appendable, e.getValue());
			}
		}
		return appendable;
	}

	/**
	 * Appends the string representation of each entry in {@code entries}, using the previously configured separator and
	 * key-value separator, to {@code builder}. Identical to {@link #appendTo(Appendable, Iterable)}, except that it
	 * does not throw {@link IOException}.
	 */
	public StringBuilder appendTo(StringBuilder builder, Iterable<? extends Entry<?, ? extends Collection<?>>> entries) {
		try {
			appendTo((Appendable) builder, entries);
		} catch (IOException impossible) {
			throw new AssertionError(impossible);
		}
		return builder;
	}

	/**
	 * Returns a string containing the string representation of each entry in {@code entries}, using the previously
	 * configured separator and key-value separator.
	 */
	public String join(Iterable<? extends Entry<?, ? extends Collection<?>>> entries) {
		return appendTo(new StringBuilder(), entries).toString();
	}

	protected CharSequence toString(Object part) {
		return (part instanceof CharSequence) ? (CharSequence) part : part.toString();
	}

	public MultimapJoiner skipNulls() {
		return new MultimapJoiner(entryJoiner.skipNulls(), separator, keyValueSeparator);
	}

	/**
	 * Returns a multimap joiner with the same behavior as this one, except automatically substituting {@code nullText} for
	 * any provided null keys or values.
	 */
	public MultimapJoiner useForNull(final String nullText) {
		return new MultimapJoiner(entryJoiner.useForNull(nullText), separator, keyValueSeparator) {
			@Override
			protected CharSequence toString(Object part) {
				return (part == null) ? nullText : MultimapJoiner.this.toString(part);
			}

			@Override
			public MultimapJoiner useForNull(String nullText) {
				throw new UnsupportedOperationException("already specified useForNull");
			}

			@Override
			public MultimapJoiner skipNulls() {
				throw new UnsupportedOperationException("already specified useForNull");
			}
		};
	}
}
