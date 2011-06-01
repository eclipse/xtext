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
public class GrammarUtil2<ELEMENT, TOKEN> {
	public static <ELEMENT, TOKEN> GrammarUtil2<ELEMENT, TOKEN> newUtil(IGrammarAdapter<ELEMENT, TOKEN> grammarAdapter) {
		return new GrammarUtil2<ELEMENT, TOKEN>(grammarAdapter);
	}

	protected IGrammarAdapter<ELEMENT, TOKEN> grammarAdapter;

	public GrammarUtil2(IGrammarAdapter<ELEMENT, TOKEN> grammarAdapter) {
		super();
		this.grammarAdapter = grammarAdapter;
	}

	public <ELEMENT2> ELEMENT2 clone(ELEMENT ele, IGrammarFactory<ELEMENT2, TOKEN> factory) {
		boolean many = grammarAdapter.isMany(ele);
		boolean optional = grammarAdapter.isOptional(ele);
		TOKEN token = grammarAdapter.getToken(ele);
		if (token != null)
			return factory.createForToken(many, optional, token);
		Iterable<ELEMENT> alternative = grammarAdapter.getAlternativeChildren(ele);
		if (alternative != null)
			return factory.createForAlternativeChildren(many, optional, clone(alternative, factory));
		Iterable<ELEMENT> group = grammarAdapter.getSequentialChildren(ele);
		if (group != null)
			return factory.createForSequentialChildren(many, optional, clone(group, factory));
		Iterable<ELEMENT> unorderedgroup = grammarAdapter.getUnorderedChildren(ele);
		if (unorderedgroup != null)
			return factory.createForUnordertedChildren(many, optional, clone(unorderedgroup, factory));
		return factory.createForToken(many, optional, null);
	}

	public <ELEMENT2> List<ELEMENT2> clone(Iterable<ELEMENT> eles, IGrammarFactory<ELEMENT2, TOKEN> factory) {
		List<ELEMENT2> result = Lists.newArrayList();
		for (ELEMENT ele : eles)
			result.add(clone(ele, factory));
		return result;
	}

}
