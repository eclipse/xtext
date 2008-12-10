/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parsetree.reconstr.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.xtext.AbstractElement;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public abstract class AbstractFormattingConfig {

	public abstract class ConfigRunner {

		protected Set<ElementLocator> activeLocators = new HashSet<ElementLocator>();

		private List<ElementLocator> activeRangeLocators = new ArrayList<ElementLocator>();

		protected ConfigRunner() {
			super();
		}

		public void collectLocators(AbstractElement left, AbstractElement right) {
			activeLocators.addAll(activeRangeLocators);
			List<ElementLocator> a = after.get(left);
			if (a != null) {
				activeLocators.addAll(a);
				for (ElementLocator l : a)
					if (l.type == LocatorType.RANGE)
						activeRangeLocators.add(l);
			}
			List<ElementLocator> b = before.get(right);
			if (b != null) {
				activeLocators.addAll(b);
				for (ElementLocator l : b)
					if (l.type == LocatorType.RANGE)
						activeRangeLocators.remove(l);
			}
		}

		public abstract String getSummarizedSpaces();

		public void startCollectingLocators() {
			activeLocators.clear();
		}

	}

	public class ElementLocator {
		private AbstractElement left;
		private AbstractElement right;
		private LocatorType type;

		protected void after(AbstractElement left) {
			this.type = LocatorType.AFTER;
			this.left = left;
			this.right = null;
			list(after, left).add(this);
		}

		protected void before(AbstractElement right) {
			this.type = LocatorType.BEFORE;
			this.right = right;
			this.left = null;
			list(before, right).add(this);
		}

		protected void between(AbstractElement left, AbstractElement right) {
			this.type = LocatorType.BETWEEN;
			this.left = left;
			this.right = right;
			list(after, left).add(this);
			list(before, right).add(this);
		}
		
		protected void around(AbstractElement ele) {
			this.type = LocatorType.BETWEEN;
			this.left = ele;
			this.right = ele;
			list(after, ele).add(this);
			list(before, ele).add(this);
		}

		protected void bounds(AbstractElement left, AbstractElement right) {
			this.type = LocatorType.BOUNDS;
			this.left = left;
			this.right = right;
			list(after, left).add(this);
			list(before, right).add(this);
		}

		public AbstractElement getLeft() {
			return left;
		}

		public AbstractElement getRight() {
			return right;
		}

		public LocatorType getType() {
			return type;
		}

		protected void range(AbstractElement left, AbstractElement right) {
			type = LocatorType.RANGE;
			this.left = left;
			this.right = right;
			list(after, left).add(this);
			list(before, right).add(this);
		}
	}

	public enum LocatorType {
		AFTER, BEFORE, BETWEEN, BOUNDS, RANGE, AROUND
	}

	private static List<ElementLocator> list(
			Map<AbstractElement, List<ElementLocator>> map, AbstractElement ele) {
		List<ElementLocator> l = map.get(ele);
		if (l == null)
			map.put(ele, l = new ArrayList<ElementLocator>());
		return l;
	}

	private Map<AbstractElement, List<ElementLocator>> after = new HashMap<AbstractElement, List<ElementLocator>>();

	private Map<AbstractElement, List<ElementLocator>> before = new HashMap<AbstractElement, List<ElementLocator>>();

	public abstract ConfigRunner run();

}
