/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer.analysis;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.util.EmfFormatter;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class Context2NameFunction implements Function<EObject, String> {

	public String apply(EObject from) {
		return getContextName(from);
	}

	public String getContextName(Action ctx) {
		ParserRule rule = EcoreUtil2.getContainerOfType(ctx, ParserRule.class);
		return rule.getName() + "_" + getUniqueActionName(ctx);
	}

	public String getContextName(EObject ctx) {
		if (GrammarUtil.isEObjectRule(ctx))
			return getContextName((ParserRule) ctx);
		if (GrammarUtil.isAssignedAction(ctx))
			return getContextName((Action) ctx);
		throw new RuntimeException("Invalid Context: " + EmfFormatter.objPath(ctx));
	}

	public String getContextName(ParserRule ctx) {
		return ctx.getName();
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
