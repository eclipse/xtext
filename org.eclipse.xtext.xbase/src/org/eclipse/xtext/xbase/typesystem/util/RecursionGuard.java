/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.util;

/**
 * A simple guard against infinite recursion.
 * 
 * Can be used as a stack or a sink. It uses identity comparison to detect
 * recursion.
 * 
 * It is designed to cause minimal overhead for recursive structures that 
 * are not deeper than approx 15 elements and has less elements in the average case. 
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class RecursionGuard<T> {
	
	private static class Item {
		Object element;
		Item next;
	}

	private Item head;

	public boolean tryNext(T element) {
		Item item = head;
		while (item != null) {
			if (item.element == element)
				return false;
			item = item.next;
		}
		Item newHead = new Item();
		newHead.element = element;
		newHead.next = head;
		head = newHead;
		return true;
	}

	public void done(T element) {
		Item item = head;
		Item prev = null;
		while (item != null) {
			if (item.element == element) {
				if (prev == null) {
					head = item.next;
				} else {
					prev.next = item.next;
				}
				return;
			}
			prev = item;
			item = item.next;
		}
		throw new IllegalStateException("Element not found: " + element);
	}

	public void clear() {
		head = null;
	}
}