/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.outline.impl;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.eclipse.xtext.ui.editor.outline.IOutlineNode;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class OutlineFilterAndSorter {

	public static interface IComparator extends Comparator<IOutlineNode> {
		boolean isEnabled();
	}

	public static interface IFilter extends Predicate<IOutlineNode> {
		boolean isEnabled();
	}

	private List<IFilter> filters = Lists.newArrayList();

	private IComparator comparator;

	public IOutlineNode[] filterAndSort(Iterable<IOutlineNode> nodes) {
		final Iterable<IFilter> enabledFilters = getEnabledFilters();
		Iterable<IOutlineNode> filteredNodes = null;
		if (Iterables.isEmpty(enabledFilters)) {
			filteredNodes = nodes;
		} else {
			filteredNodes = Iterables.filter(nodes, new Predicate<IOutlineNode>() {
				@Override
				public boolean apply(final IOutlineNode node) {
					return Iterables.all(enabledFilters, new Predicate<IFilter>() {
						@Override
						public boolean apply(IFilter filter) {
							return filter.apply(node);
						}
					});
				}
			});
		}
		IOutlineNode[] nodesAsArray = Iterables.toArray(filteredNodes, IOutlineNode.class);
		if (comparator != null && isSortingEnabled())
			Arrays.sort(nodesAsArray, comparator);
		return nodesAsArray;
	}

	/**
	 * @since 2.2
	 */
	protected boolean isSortingEnabled() {
		return comparator.isEnabled();
	}

	protected Iterable<IFilter> getEnabledFilters() {
		return Iterables.filter(filters, new Predicate<IFilter>() {
			@Override
			public boolean apply(IFilter filter) {
				return filter.isEnabled();
			}
		});
	}

	public void setComparator(IComparator comparator) {
		this.comparator = comparator;
	}
	
	public boolean addFilter(IFilter filter) {
		return filters.add(filter);
	}

	public boolean removeFilter(IFilter filter) {
		return filters.remove(filter);
	}
}
