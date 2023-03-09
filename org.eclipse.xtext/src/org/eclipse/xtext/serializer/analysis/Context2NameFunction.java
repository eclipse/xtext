/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.serializer.analysis;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.util.EmfFormatter;
import org.eclipse.xtext.xtext.RuleNames;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class Context2NameFunction {

	public Function<EObject, String> toFunction(final Grammar grammar) {
		return new Function<EObject, String>() {
			@Override
			public String apply(EObject from) {
				return getContextName(grammar, from);
			}
		};
	}
	
	public String getContextName(Grammar grammar, Action ctx) {
		ParserRule rule = EcoreUtil2.getContainerOfType(ctx, ParserRule.class);
		return getContextName(grammar, rule) + "_" + getUniqueActionName(ctx);
	}

	public String getContextName(Grammar grammar, EObject ctx) {
		if (GrammarUtil.isEObjectRule(ctx))
			return getContextName(grammar, (ParserRule) ctx);
		if (GrammarUtil.isAssignedAction(ctx))
			return getContextName(grammar, (Action) ctx);
		throw new RuntimeException("Invalid Context: " + EmfFormatter.objPath(ctx));
	}

	public String getContextName(Grammar grammar, ParserRule ctx) {
		if (grammar == null) {
			return ctx.getName();	
		}
		return RuleNames.getRuleNames(grammar, false).getUniqueRuleName(ctx);
	}

	public String getUniqueActionName(Action action) {
		List<Integer> indices = Lists.newArrayList();
		EObject current = action;
		while (current.eContainer() instanceof AbstractElement) {
			indices.add(current.eContainer().eContents().indexOf(current));
			current = current.eContainer();
		}
		Collections.reverse(indices);
		return action.getType().getClassifier().getName() + "_" + Joiner.on('_').join(indices);
	}
}
