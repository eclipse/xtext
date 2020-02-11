/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.util.formallang;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import com.google.common.base.Predicate;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class FollowerFunctionImpl<E, T> implements FollowerFunction<E> {

	public enum Direction {
		L2R, R2L
	}

	public enum UnorderedStrategy {
		MULIT_ALTERNATIVE, SEQUENCE
	}

	protected Direction direction = Direction.L2R;

	protected Predicate<E> filter;

	protected Production<E, T> production;

	protected UnorderedStrategy unorderedStrategy = UnorderedStrategy.MULIT_ALTERNATIVE;

	public FollowerFunctionImpl(Production<E, T> production) {
		super();
		this.production = production;
	}

	protected void collectByParent(E element, Set<E> result, Set<E> visited) {
		E container = production.getParent(element);
		Iterable<E> children;
		if (container == null)
			result.add(null);
		else if ((children = production.getSequentialChildren(container)) != null)
			collectByParentSequence(element, container, children, result, visited);
		else if ((children = production.getUnorderedChildren(container)) != null)
			switch (unorderedStrategy) {
				case SEQUENCE:
					collectByParentSequence(element, container, children, result, visited);
					break;
				case MULIT_ALTERNATIVE:
					collectElement(container, result, visited);
					collectByParent(container, result, visited);
					break;
			}
		else {
			if (production.isMany(container))
				collectElement(container, result, visited);
			collectByParent(container, result, visited);
		}
	}

	protected void collectByParentSequence(E element, E container, Iterable<E> children, Set<E> result, Set<E> visited) {
		List<E> sequentialChildren = orderedList(children);
		int i = sequentialChildren.indexOf(element) + 1;
		while (i < sequentialChildren.size()) {
			E next = sequentialChildren.get(i);
			collectElement(next, result, visited);
			if (production.isOptional(next))
				i++;
			else
				break;
		}
		if (i >= sequentialChildren.size()) {
			if (production.isMany(container))
				collectElement(container, result, visited);
			collectByParent(container, result, visited);
		}
	}

	protected void collectChildren(E element, Set<E> result, Set<E> visited) {
		Iterable<E> children;
		if ((children = production.getSequentialChildren(element)) != null)
			collectChildrenSequence(element, children, result, visited);
		else if ((children = production.getAlternativeChildren(element)) != null)
			collectChildrenAlternative(element, children, result, visited);
		else if ((children = production.getUnorderedChildren(element)) != null)
			switch (unorderedStrategy) {
				case SEQUENCE:
					collectChildrenSequence(element, children, result, visited);
					break;
				case MULIT_ALTERNATIVE:
					collectChildrenUnorderedAlt(element, children, result, visited);
					break;
			}
		else {
			if (production.isMany(element) /* && filter(element) */)
				collectElement(element, result, visited);
			collectByParent(element, result, visited);
		}
	}

	protected void collectChildrenAlternative(E element, Iterable<E> alternativeChildren, Set<E> result, Set<E> visited) {
		boolean optional = production.isOptional(element);
		for (E child : orderedIterable(alternativeChildren)) {
			optional |= production.isOptional(child);
			collectElement(child, result, visited);
		}
		if (optional)
			collectByParent(element, result, visited);
	}

	protected void collectChildrenSequence(E element, Iterable<E> sequentialChildren, Set<E> result, Set<E> visited) {
		boolean reachedEnd = true;
		for (E child : orderedIterable(sequentialChildren)) {
			collectElement(child, result, visited);
			if (!production.isOptional(child)) {
				reachedEnd = false;
				break;
			}
		}
		if (reachedEnd || production.isOptional(element))
			collectByParent(element, result, visited);
	}

	protected void collectChildrenUnorderedAlt(E element, Iterable<E> alternativeChildren, Set<E> result, Set<E> visited) {
		boolean hasMandatory = false;
		for (E child : orderedIterable(alternativeChildren)) {
			hasMandatory |= !production.isOptional(child);
			collectElement(child, result, visited);
		}
		if (!hasMandatory || production.isOptional(element))
			collectByParent(element, result, visited);
	}

	protected void collectElement(E ele, Set<E> result, Set<E> visited) {
		if (!visited.add(ele))
			return;
		if (filter(ele))
			result.add(ele);
		else
			collectChildren(ele, result, visited);
	}

	protected boolean filter(E ele) {
		if (filter != null)
			return filter.apply(ele);
		return production.getSequentialChildren(ele) == null && production.getAlternativeChildren(ele) == null
				&& production.getUnorderedChildren(ele) == null;
	}

	public Direction getDirection() {
		return direction;
	}

	public Predicate<E> getFilter() {
		return filter;
	}

	@Override
	public Iterable<E> getFollowers(E element) {
		if (filter(element)) {
			if (element == null)
				throw new NullPointerException();
			Set<E> outgoing = Sets.newLinkedHashSet();
			collectChildren(element, outgoing, Sets.<E> newHashSet());
			return outgoing;
		} else
			return Collections.emptyList();
	}

	public Production<E, ?> getProduction() {
		return production;
	}

	@Override
	public Iterable<E> getStarts(E root) {
		if (root == null)
			throw new NullPointerException();
		Set<E> outgoing = Sets.newLinkedHashSet();
		if (filter(root)) {
			outgoing.add(root);
			if (production.isOptional(root))
				outgoing.add(null);
		} else
			collectChildren(root, outgoing, Sets.<E> newHashSet());
		return outgoing;
	}

	public UnorderedStrategy getUnorderedStrategy() {
		return unorderedStrategy;
	}

	protected Iterable<E> orderedIterable(Iterable<E> elements) {
		return direction == Direction.L2R ? elements : Lists.reverse(toList(elements));
	}

	protected List<E> orderedList(Iterable<E> elements) {
		if (direction == Direction.L2R)
			return toList(elements);
		List<E> result = Lists.newArrayList(elements);
		Collections.reverse(result);
		return result;
	}

	public FollowerFunctionImpl<E, T> setDirection(Direction direction) {
		this.direction = direction;
		return this;
	}

	public FollowerFunctionImpl<E, T> setFilter(Predicate<E> filter) {
		this.filter = filter;
		return this;
	}

	public FollowerFunctionImpl<E, T> setUnorderedStrategy(UnorderedStrategy unorderedStrategy) {
		this.unorderedStrategy = unorderedStrategy;
		return this;
	}

	protected List<E> toList(Iterable<E> elements) {
		return elements instanceof List<?> ? (List<E>) elements : Lists.newArrayList(elements);
	}

}
