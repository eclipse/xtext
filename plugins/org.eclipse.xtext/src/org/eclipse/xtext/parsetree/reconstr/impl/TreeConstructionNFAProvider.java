/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parsetree.reconstr.impl;

import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.grammaranalysis.impl.AbstractCachingNFABuilder;
import org.eclipse.xtext.grammaranalysis.impl.AbstractNFAProvider;

public class TreeConstructionNFAProvider extends
		AbstractNFAProvider<TreeConstState, TreeConstTransition> {

	protected static class TreeConstNFABuilder extends
			AbstractCachingNFABuilder<TreeConstState, TreeConstTransition> {

		@Override
		protected TreeConstState createState(AbstractElement ele) {
			return new TreeConstState(ele, this);
		}

		@Override
		protected TreeConstTransition createTransition(TreeConstState source,
				TreeConstState target, boolean isRuleCall) {
			return new TreeConstTransition(source, target, isRuleCall);
		}

		@Override
		public boolean filter(AbstractElement ele) {
			if (ele.eContainer() instanceof AbstractRule)
				return false;
			if (EcoreUtil2.getContainerOfType(ele.eContainer(), Assignment.class) != null)
				return true;

			return false;
		}

		public NFADirection getDirection() {
			return NFADirection.BACKWARD;
		}
	}

	@Override
	protected NFABuilder<TreeConstState, TreeConstTransition> createBuilder() {
		return new TreeConstNFABuilder();
	}

}
