/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.grammaranalysis.impl;

import org.eclipse.xtext.AbstractElement;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class DefaultForwardNFAProvider extends AbstractNFAProvider<DefaultNFAState, DefaultNFATransition> {

	public static class DefaultForwardsNFABuilder extends
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

		public NFADirection getDirection() {
			return NFADirection.FORWARD;
		}
	}

	@Override
	protected NFABuilder<DefaultNFAState, DefaultNFATransition> createBuilder() {
		return new DefaultForwardsNFABuilder();
	}
}
