/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer.impl;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.ParserRule;

import com.google.common.collect.Lists;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class ContextUtil {
	public List<EObject> getAllContexts(Grammar grammar) {
		List<EObject> result = Lists.newArrayList();
		for (ParserRule pr : GrammarUtil.allParserRules(grammar))
			if (GrammarUtil.isParserParserRule(pr)) {
				result.add(pr);
				for (Action action : GrammarUtil.containedActions(pr))
					if (GrammarUtil.isAssignedAction(action))
						result.add(action);
			}
		return result;
	}

}
