/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.util.formallang;

import java.util.List;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Lists;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class ProductionUtil {

	protected <S, D, T> List<D> clone(Production<S, T> grammarAdapter, Iterable<S> eles, ProductionFactory<D, T> factory) {
		List<D> result = Lists.newArrayList();
		for (S ele : eles)
			result.add(clone(grammarAdapter, ele, factory));
		return result;
	}

	public <S, D, T> D clone(Production<S, T> production, ProductionFactory<D, T> factory) {
		return clone(production, production.getRoot(), factory);
	}

	public <S, D, T> D clone(Production<S, T> production, S ele, ProductionFactory<D, T> factory) {
		boolean many = production.isMany(ele);
		boolean optional = production.isOptional(ele);
		T token = production.getToken(ele);
		if (token != null)
			return factory.createForToken(many, optional, token);
		Iterable<S> alternative = production.getAlternativeChildren(ele);
		if (alternative != null)
			return factory.createForAlternativeChildren(many, optional, clone(production, alternative, factory));
		Iterable<S> group = production.getSequentialChildren(ele);
		if (group != null)
			return factory.createForSequentialChildren(many, optional, clone(production, group, factory));
		Iterable<S> unorderedgroup = production.getUnorderedChildren(ele);
		if (unorderedgroup != null)
			return factory.createForUnordertedChildren(many, optional, clone(production, unorderedgroup, factory));
		return factory.createForToken(many, optional, null);
	}

	public <E, T> E find(Production<E, T> production, E element, Predicate<E> matches) {
		if (matches.apply(element))
			return element;
		Iterable<E> children = getChildren(production, element);
		if (children != null)
			for (E child : children) {
				E found = find(production, child, matches);
				if (found != null)
					return found;
			}
		return null;
	}

	public <E, T> List<E> findAll(Production<E, T> production, E element, Predicate<E> matches) {
		List<E> result = Lists.newArrayList();
		findAll(production, element, matches, result);
		return result;
	}

	protected <E, T> void findAll(Production<E, T> production, E element, Predicate<E> matches, List<E> result) {
		if (matches.apply(element))
			result.add(element);
		Iterable<E> children = getChildren(production, element);
		if (children != null)
			for (E child : children)
				findAll(production, child, matches, result);
	}

	public <E, T> E find(Production<E, T> production, Predicate<E> matches) {
		return find(production, production.getRoot(), matches);
	}

	public <E, T> E findByToken(final Production<E, T> production, E element, final Predicate<T> matches) {
		return find(production, element, new Predicate<E>() {
			@Override
			public boolean apply(E input) {
				T token = production.getToken(input);
				return token != null && matches.apply(token);
			}
		});
	}

	public <E, T> E findByToken(final Production<E, T> production, final Predicate<T> matches) {
		return findByToken(production, production.getRoot(), matches);
	}

	public <E, T> E findByToken(final Production<E, T> production, final T matches) {
		return findByToken(production, Predicates.equalTo(matches));
	}

	protected <E, T> void getAllChildren(Production<E, T> production, E element, List<E> result) {
		result.add(element);
		Iterable<E> children = getChildren(production, element);
		if (children != null)
			for (E child : children)
				getAllChildren(production, child, result);
	}

	public <E, T> List<E> getAllChildren(Production<E, T> production, E element) {
		List<E> result = Lists.newArrayList();
		getAllChildren(production, element, result);
		return result;
	}

	public <E, T> E getRoot(Production<E, T> prod, E element) {
		E current = element;
		E parent = prod.getParent(current);
		while (parent != null) {
			current = parent;
			parent = prod.getParent(current);
		}
		return current;
	}

	public <E, T> Iterable<E> getChildren(Production<E, T> production, E element) {
		Iterable<E> result;
		if ((result = production.getSequentialChildren(element)) != null)
			return result;
		if ((result = production.getAlternativeChildren(element)) != null)
			return result;
		if ((result = production.getUnorderedChildren(element)) != null)
			return result;
		return null;
	}

}
