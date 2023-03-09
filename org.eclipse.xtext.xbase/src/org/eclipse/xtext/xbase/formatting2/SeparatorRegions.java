/**
 * Copyright (c) 2014, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.formatting2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.xtext.formatting2.regionaccess.ITextSegment;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

import com.google.common.base.Joiner;
import com.google.common.collect.AbstractIterator;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class SeparatorRegions<T extends Object, R extends ITextSegment> implements Iterable<ObjectEntry<T, R>> {
	private final ITextSegment root;

	private ObjectEntry<T, R> first;

	public void prepend(T object) {
		ObjectEntry<T, R> newObject = new ObjectEntry<T, R>(this);
		newObject.setObject(object);
		if (first == null) {
			first = newObject;
		} else {
			newObject.next = first.getLeadingSeparator();
			first.getLeadingSeparator().next = newObject;
			first = newObject;
		}
	}

	public void prependWithLeadingSeparator(T object, R separator) {
		ObjectEntry<T, R> newObject = new ObjectEntry<T, R>(this);
		SeparatorEntry<T, R> newSeparator = new SeparatorEntry<T, R>();
		newObject.setObject(object);
		newSeparator.setSeparator(separator);
		newObject.previous = newSeparator;
		newSeparator.next = newObject;
		if (first == null) {
			first = newObject;
		} else {
			newObject.next = first.getLeadingSeparator();
			first.getLeadingSeparator().previous = newObject;
			first = newObject;
		}
	}

	public void appendWithTrailingSeparator(T object, R separator) {
		ObjectEntry<T, R> newObject = new ObjectEntry<T, R>(this);
		newObject.setObject(object);
		if (separator != null) {
			SeparatorEntry<T, R> newSeparator = new SeparatorEntry<T, R>();
			newSeparator.setSeparator(separator);
			newObject.next = newSeparator;
			newSeparator.previous = newObject;
		}
		if (first == null) {
			first = newObject;
		} else {
			SeparatorEntry<T, R> last = IterableExtensions.last(separators());
			newObject.previous = last;
			last.next = newObject;
		}
	}

	@Override
	public Iterator<ObjectEntry<T, R>> iterator() {
		return new AbstractIterator<ObjectEntry<T, R>>() {
			ObjectEntry<T, R> next = first;

			@Override
			protected ObjectEntry<T, R> computeNext() {
				if (next == null) {
					return endOfData();
				}
				ObjectEntry<T, R> current = next;
				next = next.getTrailingObject();
				return current;
			}
		};
	}

	public Iterable<SeparatorEntry<T, R>> separators() {
		return new Iterable<SeparatorEntry<T, R>>() {
			@Override
			public Iterator<SeparatorEntry<T, R>> iterator() {

				return new AbstractIterator<SeparatorEntry<T, R>>() {
					SeparatorEntry<T, R> next = first.getTrailingSeparator();

					@Override
					protected SeparatorEntry<T, R> computeNext() {
						if (next == null) {
							return endOfData();
						}
						SeparatorEntry<T, R> current = next;
						next = next.getTrailingSeparator();
						return current;
					}
				};
			}
		};
	}

	@Override
	public String toString() {
		if (first != null) {
			List<String> list = new ArrayList<>();
			Entry<T, R> current = first.getLeadingSeparator();
			while (current != null) {
				list.add(current.toString());
				current = current.next;
			}
			return Joiner.on("\n").join(list);
		} else {
			return "empty";
		}
	}

	public SeparatorRegions(ITextSegment root) {
		this.root = root;
	}

	public ITextSegment getRoot() {
		return root;
	}
}
