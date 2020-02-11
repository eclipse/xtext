/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.parsetree.reconstr.impl;

import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.grammaranalysis.impl.AbstractCachingNFABuilder;
import org.eclipse.xtext.grammaranalysis.impl.AbstractNFAProvider;

import com.google.inject.Singleton;

@Singleton
public class TreeConstructionNFAProvider extends AbstractNFAProvider<TreeConstState, TreeConstTransition> {

	protected static class TreeConstNFABuilder extends AbstractCachingNFABuilder<TreeConstState, TreeConstTransition> {

		@Override
		protected TreeConstState createState(AbstractElement grammarElement) {
			return new TreeConstState(grammarElement, this);
		}

		@Override
		protected TreeConstTransition createTransition(TreeConstState source, TreeConstState target,
				boolean isRuleCall, AbstractElement loopCenter) {
			return new TreeConstTransition(source, target, isRuleCall, loopCenter);
		}

		@Override
		public boolean filter(AbstractElement grammarElement) {
			if (grammarElement.eContainer() instanceof AbstractRule)
				return false;
			if (EcoreUtil2.getContainerOfType(grammarElement.eContainer(), Assignment.class) != null)
				return true;

			return false;
		}

		@Override
		public NFADirection getDirection() {
			return NFADirection.BACKWARD;
		}
	}

	@Override
	protected NFABuilder<TreeConstState, TreeConstTransition> createBuilder() {
		return new TreeConstNFABuilder();
	}

}
