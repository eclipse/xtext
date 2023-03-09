/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.xtext.grammaranalysis.impl;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.grammaranalysis.IGrammarNFAProvider.NFABuilder;
import org.eclipse.xtext.grammaranalysis.INFAState;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public abstract class AbstractCachingNFABuilder<S, T> implements NFABuilder<S, T> {

	protected abstract S createState(AbstractElement ele);

	protected abstract T createTransition(S source, S target, boolean isRuleCall, AbstractElement loopCenter);

	@Override
	public boolean filter(AbstractElement ele) {
		return false;
	}

	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public final S getState(AbstractElement ele) {
		if (ele == null)
			return null;
		for (Adapter a : ele.eAdapters())
			if (a instanceof INFAState) {
				INFAState s = (INFAState) a;
				if (s.getBuilder() == this)
					return (S) s;
			}
		S t = createState(ele);
		ele.eAdapters().add((Adapter) t);
		return t;
	}

	@Override
	public final T getTransition(S source, S target, boolean isRuleCall, AbstractElement loopCenter) {
		return createTransition(source, target, isRuleCall, loopCenter);
	}
}
