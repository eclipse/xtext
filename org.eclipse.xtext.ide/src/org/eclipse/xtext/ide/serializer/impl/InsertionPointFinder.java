/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.serializer.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.formatting2.regionaccess.IAstRegion;
import org.eclipse.xtext.formatting2.regionaccess.IEObjectRegion;
import org.eclipse.xtext.formatting2.regionaccess.IHiddenRegion;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.analysis.IContextTypePDAProvider;
import org.eclipse.xtext.serializer.analysis.ISerState;
import org.eclipse.xtext.serializer.analysis.ISerState.SerStateType;
import org.eclipse.xtext.serializer.analysis.SerializationContextMap;
import org.eclipse.xtext.util.formallang.NfaUtil;
import org.eclipse.xtext.util.formallang.Pda;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 *
 * @since 2.13
 */
public class InsertionPointFinder {

	private SerializationContextMap<Pda<ISerState, RuleCall>> pdas;

	protected Set<AbstractElement> collectAdjacent(ISerState start,
			Function<ISerState, List<? extends ISerState>> followers) {
		LinkedList<ISerState> todo = new LinkedList<>();
		Set<ISerState> seen = Sets.newHashSet();
		todo.addAll(followers.apply(start));
		Set<AbstractElement> result = Sets.newLinkedHashSet();
		while (!todo.isEmpty()) {
			ISerState next = todo.pop();
			if (!seen.add(next)) {
				continue;
			}
			if (next.getType() == SerStateType.ELEMENT && !GrammarUtil.isUnassignedAction(next.getGrammarElement())) {
				result.add(next.getGrammarElement());
			} else {
				todo.addAll(followers.apply(next));
			}
		}
		return result;
	}

	public IHiddenRegion findInsertionPoint(ISerializationContext ctx, IEObjectRegion obj, AbstractElement ins) {
		ISerState insertionState = findState(ctx, ins);
		Set<AbstractElement> followers = collectAdjacent(insertionState, s -> s.getFollowers());
		Set<AbstractElement> precendents = collectAdjacent(insertionState, s -> s.getPrecedents());
		List<IAstRegion> regions = Lists.newArrayList(obj.getAstRegions());
		if (regions.isEmpty()) {
			return obj.getPreviousHiddenRegion();
		}
		if (followers.contains(regions.get(0).getGrammarElement())) {
			return obj.getPreviousHiddenRegion();
		}
		if (precendents.contains(regions.get(regions.size() - 1).getGrammarElement())) {
			return obj.getNextHiddenRegion();
		}
		for (int i = 0; i < regions.size() - 1; i++) {
			IAstRegion leading = regions.get(i);
			IAstRegion trailing = regions.get(i + 1);
			if (precendents.contains(leading.getGrammarElement()) && followers.contains(trailing.getGrammarElement())) {
				return leading.getNextHiddenRegion();
			}
		}
		return null;
	}

	protected ISerState findState(ISerializationContext ctx, AbstractElement ele) {
		Pda<ISerState, RuleCall> pda = pdas.get(ctx);
		return new NfaUtil().find(pda, s -> s.getGrammarElement() == ele);
	}

	@Inject
	protected void init(IContextTypePDAProvider pdaProvider, IGrammarAccess grammar) {
		pdas = pdaProvider.getContextTypePDAs(grammar.getGrammar());
	}

}
