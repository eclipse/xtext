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

import org.eclipse.xtext.AbstractElement;

import com.google.inject.Singleton;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@Singleton
public class DefaultBackwardNFAProvider extends AbstractNFAProvider<DefaultNFAState, DefaultNFATransition> {

	public static class DefaultBackwardsNFABuilder extends
			AbstractCachingNFABuilder<DefaultNFAState, DefaultNFATransition> {

		@Override
		public DefaultNFAState createState(AbstractElement ele) {
			return new DefaultNFAState(ele, this);
		}

		@Override
		protected DefaultNFATransition createTransition(DefaultNFAState source, DefaultNFAState target,
				boolean isRuleCall, AbstractElement loopCenter) {
			return new DefaultNFATransition(source, target, isRuleCall, loopCenter);
		}

		@Override
		public boolean filter(AbstractElement ele) {
			return false;
		}

		@Override
		public NFADirection getDirection() {
			return NFADirection.BACKWARD;
		}
	}

	@Override
	protected NFABuilder<DefaultNFAState, DefaultNFATransition> createBuilder() {
		return new DefaultBackwardsNFABuilder();
	}
}
