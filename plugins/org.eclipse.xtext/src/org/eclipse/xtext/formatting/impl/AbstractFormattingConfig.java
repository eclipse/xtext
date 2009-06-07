/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public abstract class AbstractFormattingConfig {

	public class ElementLocator {
		private EObject left;
		private EObject right;
		private LocatorType type;

		protected void after(EObject left) {
			this.type = LocatorType.AFTER;
			this.left = left;
			this.right = null;
			list(after, left).add(this);
		}

		@Override
		public String toString() {
			return getClass().getSimpleName() + "-" + type.name();
		}

		protected void around(EObject ele) {
			this.type = LocatorType.AROUND;
			this.left = ele;
			this.right = ele;
			list(after, ele).add(this);
			list(before, ele).add(this);
		}

		protected void before(EObject right) {
			this.type = LocatorType.BEFORE;
			this.right = right;
			this.left = null;
			list(before, right).add(this);
		}

		protected void between(EObject left, EObject right) {
			this.type = LocatorType.BETWEEN;
			this.left = left;
			this.right = right;
			list(after, left).add(this);
			list(before, right).add(this);
		}

		protected void bounds(EObject left, EObject right) {
			this.type = LocatorType.BOUNDS;
			this.left = left;
			this.right = right;
			list(after, left).add(this);
			list(before, right).add(this);
		}

		public EObject getLeft() {
			return left;
		}

		public EObject getRight() {
			return right;
		}

		public LocatorType getType() {
			return type;
		}

		protected void range(EObject left, EObject right) {
			type = LocatorType.RANGE;
			this.left = left;
			this.right = right;
			list(after, left).add(this);
			list(before, right).add(this);
		}
	}

	public enum LocatorType {
		AFTER, //
		AROUND, // before + after
		BEFORE, //
		BETWEEN, // matches, if two elements follow each other
		BOUNDS, // after(left) + before(right)
		RANGE, // matches always between left and right
	} // FIXME: write tests for this!

	private static List<ElementLocator> list(
			Map<EObject, List<ElementLocator>> map, EObject ele) {
		List<ElementLocator> l = map.get(ele);
		if (l == null)
			map.put(ele, l = new ArrayList<ElementLocator>());
		return l;
	}

	private Map<EObject, List<ElementLocator>> after = new HashMap<EObject, List<ElementLocator>>();

	private Map<EObject, List<ElementLocator>> before = new HashMap<EObject, List<ElementLocator>>();

	public List<ElementLocator> getAfter(EObject element) {
		List<ElementLocator> r = after.get(element);
		if (r != null)
			return r;
		return Collections.emptyList();
	}

	public List<ElementLocator> getBefore(EObject element) {
		List<ElementLocator> r = before.get(element);
		if (r != null)
			return r;
		return Collections.emptyList();
	}
}
