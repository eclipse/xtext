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

import com.google.common.base.Function;
import com.google.inject.internal.Join;
import com.google.inject.internal.Lists;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class GrammarStringFactory<TOKEN> implements IGrammarFactory<String, TOKEN> {

	protected Function<TOKEN, String> token2String;

	protected String card(boolean many, boolean optional) {
		return many ? (optional ? "*" : "+") : (optional ? "?" : "");
	}

	public String createForAlternativeChildren(boolean many, boolean optional, Iterable<String> children) {
		List<String> childrenSorted = Lists.newArrayList(children);
		Collections.sort(childrenSorted);
		return "(" + Join.join(" | ", childrenSorted) + ")" + card(many, optional);
	}

	public String createForSequentialChildren(boolean many, boolean optional, Iterable<String> children) {
		if (many || optional)
			return "(" + Join.join(" ", children) + ")" + card(many, optional);
		return Join.join(" ", children) + card(many, optional);
	}

	public String createForToken(boolean many, boolean optional, TOKEN token) {
		if (token2String != null)
			return token2String.apply(token) + card(many, optional);
		if (token == null)
			return "null" + card(many, optional);
		return token.toString() + card(many, optional);
	}

	public String createForUnordertedChildren(boolean many, boolean optional, Iterable<String> children) {
		List<String> childrenSorted = Lists.newArrayList(children);
		Collections.sort(childrenSorted);
		return "(" + Join.join(" & ", childrenSorted) + ")" + card(many, optional);
	}

}
