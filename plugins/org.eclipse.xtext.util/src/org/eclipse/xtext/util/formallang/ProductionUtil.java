/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.util.formallang;

import java.util.List;

import com.google.inject.internal.Lists;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class ProductionUtil {

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

	protected <S, D, T> List<D> clone(Production<S, T> grammarAdapter, Iterable<S> eles, ProductionFactory<D, T> factory) {
		List<D> result = Lists.newArrayList();
		for (S ele : eles)
			result.add(clone(grammarAdapter, ele, factory));
		return result;
	}

}
