/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.util.formallang;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;
import com.google.inject.internal.Lists;

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

	protected void collectByParent(E element, Set<E> result) {
		E container = production.getParent(element);
		Iterable<E> children;
		if (container == null)
			result.add(null);
		else if ((children = production.getSequentialChildren(container)) != null)
			collectByParentSequence(element, container, children, result);
		else if ((children = production.getUnorderedChildren(container)) != null)
			switch (unorderedStrategy) {
				case SEQUENCE:
					collectByParentSequence(element, container, children, result);
					break;
				case MULIT_ALTERNATIVE:
					collectElement(container, result);
					collectByParent(container, result);
					break;
			}
		else {
			if (production.isMany(container))
				collectElement(container, result);
			collectByParent(container, result);
		}
	}

	protected void collectByParentSequence(E element, E container, Iterable<E> children, Set<E> result) {
		List<E> sequentialChildren = orderedList(children);
		int i = sequentialChildren.indexOf(element) + 1;
		while (i < sequentialChildren.size()) {
			E next = sequentialChildren.get(i);
			collectElement(next, result);
			if (production.isOptional(next))
				i++;
			else
				break;
		}
		if (i >= sequentialChildren.size())
			collectByParent(container, result);
	}

	protected void collectChildren(E element, Set<E> result) {
		Iterable<E> children;
		if ((children = production.getSequentialChildren(element)) != null)
			collectChildrenSequence(element, children, result);
		else if ((children = production.getAlternativeChildren(element)) != null)
			collectChildrenAlternative(element, children, result);
		else if ((children = production.getUnorderedChildren(element)) != null)
			switch (unorderedStrategy) {
				case SEQUENCE:
					collectChildrenSequence(element, children, result);
					break;
				case MULIT_ALTERNATIVE:
					collectChildrenUnorderedAlt(element, children, result);
					break;
			}
		else {
			if (production.isMany(element) && filter(element))
				collectElement(element, result);
			collectByParent(element, result);
		}
	}

	protected void collectChildrenAlternative(E element, Iterable<E> alternativeChildren, Set<E> result) {
		boolean hasOptional = false;
		for (E child : orderedIterable(alternativeChildren)) {
			hasOptional |= production.isOptional(child);
			collectElement(child, result);
		}
		if (hasOptional)
			collectByParent(element, result);
	}

	protected void collectChildrenSequence(E element, Iterable<E> sequentialChildren, Set<E> result) {
		boolean reachedEnd = true;
		for (E child : orderedIterable(sequentialChildren)) {
			collectElement(child, result);
			if (!production.isOptional(child)) {
				reachedEnd = false;
				break;
			}
		}
		if (reachedEnd)
			collectByParent(element, result);
	}

	protected void collectChildrenUnorderedAlt(E element, Iterable<E> alternativeChildren, Set<E> result) {
		boolean hasMandatory = false;
		for (E child : orderedIterable(alternativeChildren)) {
			hasMandatory |= !production.isOptional(child);
			collectElement(child, result);
		}
		if (!hasMandatory)
			collectByParent(element, result);
	}

	protected void collectElement(E ele, Set<E> result) {
		if (filter(ele))
			result.add(ele);
		else
			collectChildren(ele, result);
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

	public Iterable<E> getFollowers(E element) {
		if (filter(element)) {
			if (element == null)
				throw new NullPointerException();
			Set<E> outgoing = Sets.newLinkedHashSet();
			collectChildren(element, outgoing);
			return outgoing;
		} else
			return Collections.emptyList();
	}

	public Production<E, ?> getProduction() {
		return production;
	}

	public Iterable<E> getStarts(E root) {
		if (root == null)
			throw new NullPointerException();
		Set<E> outgoing = Sets.newLinkedHashSet();
		collectElement(root, outgoing);
		return outgoing;
	}

	public UnorderedStrategy getUnorderedStrategy() {
		return unorderedStrategy;
	}

	protected Iterable<E> orderedIterable(Iterable<E> elements) {
		return direction == Direction.L2R ? elements : Iterables.reverse(toList(elements));
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
