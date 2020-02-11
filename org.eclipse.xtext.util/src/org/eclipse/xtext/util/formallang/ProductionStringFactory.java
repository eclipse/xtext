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

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class ProductionStringFactory<TOKEN> implements ProductionFactory<String, TOKEN> {

	protected Function<TOKEN, String> token2String;

	public ProductionStringFactory() {
	}

	public ProductionStringFactory(Function<TOKEN, String> token2String) {
		super();
		this.token2String = token2String;
	}

	protected String card(boolean many, boolean optional) {
		return many ? (optional ? "*" : "+") : (optional ? "?" : "");
	}

	@Override
	public String createForAlternativeChildren(boolean many, boolean optional, Iterable<String> children) {
		List<String> childrenSorted = Lists.newArrayList(Iterables.filter(children, Predicates.notNull()));
		Collections.sort(childrenSorted);
		return "(" + Joiner.on(" | ").join(childrenSorted) + ")" + card(many, optional);
	}

	@Override
	public String createForSequentialChildren(boolean many, boolean optional, Iterable<String> children) {
		children = Iterables.filter(children, Predicates.notNull());
		if (many || optional)
			return "(" + Joiner.on(" ").join(children) + ")" + card(many, optional);
		return Joiner.on(" ").join(children) + card(many, optional);
	}

	@Override
	public String createForToken(boolean many, boolean optional, TOKEN token) {
		if (token2String != null)
			return token2String.apply(token) + card(many, optional);
		if (token == null)
			return "null" + card(many, optional);
		return token.toString() + card(many, optional);
	}

	@Override
	public String createForUnordertedChildren(boolean many, boolean optional, Iterable<String> children) {
		List<String> childrenSorted = Lists.newArrayList(Iterables.filter(children, Predicates.notNull()));
		Collections.sort(childrenSorted);
		return "(" + Joiner.on(" & ").join(childrenSorted) + ")" + card(many, optional);
	}

}
