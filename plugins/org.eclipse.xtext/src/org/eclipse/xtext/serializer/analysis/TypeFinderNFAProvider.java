/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer.analysis;

import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.grammaranalysis.impl.AbstractCachingNFABuilder;
import org.eclipse.xtext.grammaranalysis.impl.AbstractNFAProvider;
import org.eclipse.xtext.grammaranalysis.impl.AbstractNFAState;
import org.eclipse.xtext.grammaranalysis.impl.AbstractNFATransition;
import org.eclipse.xtext.serializer.analysis.TypeFinderNFAProvider.TypeFinderState;
import org.eclipse.xtext.serializer.analysis.TypeFinderNFAProvider.TypeFinderTransition;

import com.google.inject.Singleton;

@Singleton
public class TypeFinderNFAProvider extends AbstractNFAProvider<TypeFinderState, TypeFinderTransition> {
	public static class TypeFinderState extends AbstractNFAState<TypeFinderState, TypeFinderTransition> {

		public TypeFinderState(AbstractElement element, NFABuilder<TypeFinderState, TypeFinderTransition> builder) {
			super(element, builder);
		}

	}

	public static class TypeFinderTransition extends AbstractNFATransition<TypeFinderState, TypeFinderTransition> {

		public TypeFinderTransition(TypeFinderState source, TypeFinderState target, boolean ruleCall,
				AbstractElement loopCenter) {
			super(source, target, ruleCall, loopCenter);
		}
	}

	public static class TypeFinderNFABuilder extends AbstractCachingNFABuilder<TypeFinderState, TypeFinderTransition> {

		@Override
		public TypeFinderState createState(AbstractElement ele) {
			return new TypeFinderState(ele, this);
		}

		@Override
		protected TypeFinderTransition createTransition(TypeFinderState source, TypeFinderState target,
				boolean isRuleCall, AbstractElement loopCenter) {
			return new TypeFinderTransition(source, target, isRuleCall, loopCenter);
		}

		@Override
		public boolean filter(AbstractElement ele) {

			// never filter root elements
			if (!(ele.eContainer() instanceof AbstractElement))
				return false;

			if (ele instanceof Assignment || ele instanceof Action)
				return false;

			if (GrammarUtil.isUnassignedEObjectRuleCall(ele))
				return false;

			return true;
		}

		public NFADirection getDirection() {
			return NFADirection.BACKWARD;
		}
	}

	@Override
	protected NFABuilder<TypeFinderState, TypeFinderTransition> createBuilder() {
		return new TypeFinderNFABuilder();
	}

}