/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.util;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import com.google.common.collect.Lists;

public abstract class AbstractLinkedStack<THIS extends AbstractLinkedStack<?, ELEMENT>, ELEMENT> implements
		Iterable<ELEMENT> {

	protected static class Element<T> {
		protected Element<T> parent;
		protected T value;

		public Element(Element<T> parent, T value) {
			super();
			this.parent = parent;
			this.value = value;
		}
	}

	private final class ElementIterator implements Iterator<ELEMENT> {
		private Element<ELEMENT> ele;

		public ElementIterator(Element<ELEMENT> ele) {
			super();
			this.ele = ele;
		}

		@Override
		public boolean hasNext() {
			return ele != null;
		}

		@Override
		public ELEMENT next() {
			if (!hasNext())
				throw new NoSuchElementException();
			Element<ELEMENT> prev = ele;
			ele = ele.parent;
			return prev.value;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	protected Element<ELEMENT> top = null;

	@Override
	public THIS clone() {
		THIS result = createStack();
		init(result);
		return result;
	}

	public THIS cloneAndPop() {
		THIS stack = clone();
		stack.pop();
		return stack;
	}

	public THIS cloneAndPush(ELEMENT element) {
		THIS stack = clone();
		stack.push(element);
		return stack;
	}

	public boolean contains(ELEMENT value) {
		Element<ELEMENT> t = top;
		while (t != null) {
			if (t.value == value)
				return true;
			t = t.parent;
		}
		return false;
	}

	protected Element<ELEMENT> createElement(Element<ELEMENT> parent, ELEMENT value) {
		return new Element<ELEMENT>(parent, value);
	}

	protected abstract THIS createStack();

	public String elementToStr(ELEMENT value) {
		return value == null ? "null" : value.toString();
	}

	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public boolean equals(Object obj) {
		if (!(obj instanceof AbstractLinkedStack))
			return false;
		Element<ELEMENT> t1 = top;
		Element<ELEMENT> t2 = ((AbstractLinkedStack) obj).top;
		while (true) {
			if (t1 == null && t2 == null)
				return true;
			if (t1 == null || t2 == null || t1.value != t2.value)
				return false;
			t1 = t1.parent;
			t2 = t2.parent;
		}
	}

	@Override
	public int hashCode() {
		// same algorithm as in java.util.AbstractList.hashCode()
		int hashCode = 1;
		Element<ELEMENT> t = top;
		while (t != null) {
			hashCode = 31 * hashCode + (t.value == null ? 0 : t.value.hashCode());
			t = t.parent;
		}
		return hashCode;
	}

	protected void init(THIS result) {
		result.top = top;
	}

	public boolean isEmpty() {
		return top == null;
	}

	/**
	 * @since 2.0
	 */
	@Override
	public Iterator<ELEMENT> iterator() {
		return new ElementIterator(top);
	}

	public ELEMENT peek() {
		return top != null ? top.value : null;
	}

	public ELEMENT pop() {
		if (top != null) {
			ELEMENT result = top.value;
			top = top.parent;
			return result;
		}
		return null;
	}

	public void push(ELEMENT value) {
		top = createElement(top, value);
	}

	@Override
	public String toString() {
		List<String> values = Lists.newArrayList();
		Element<ELEMENT> t = top;
		while (t != null) {
			values.add(elementToStr(t.value));
			t = t.parent;
		}
		return values.toString();
	}
}