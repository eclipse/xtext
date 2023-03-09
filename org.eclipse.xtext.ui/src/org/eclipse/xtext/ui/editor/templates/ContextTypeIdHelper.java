/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.templates;

import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ContextTypeIdHelper {

	public String getId(AbstractElement element) {
		if (!(element instanceof Keyword))
			throw new IllegalArgumentException("Unsupported context element: " + element);
		return GrammarUtil.getGrammar(element).getName()+".kw_"+((Keyword) element).getValue();
	}

	public String getId(AbstractRule rule) {
		if (!(rule instanceof ParserRule))
			throw new IllegalArgumentException("Unsupported context rule: " + rule);
		return GrammarUtil.getGrammar(rule).getName()+"."+rule.getName();
	}

}
