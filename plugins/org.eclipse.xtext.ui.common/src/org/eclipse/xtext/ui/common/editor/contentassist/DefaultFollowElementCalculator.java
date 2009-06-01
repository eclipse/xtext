/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.contentassist;

import java.util.Set;

import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.EnumLiteralDeclaration;
import org.eclipse.xtext.EnumRule;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.ParseTreeUtil;
import org.eclipse.xtext.ui.core.editor.contentassist.IFollowElementCalculator;
import org.eclipse.xtext.util.XtextSwitch;

/**
 * Provides a default implementation of interface {@link IFollowElementCalculator} to compute
 * the valid element set at a given offset.
 *
 * @author Michael Clay - Initial contribution and API
 * @author Sebastian Zarnekow
 */
public class DefaultFollowElementCalculator implements IFollowElementCalculator {

	public void calculateValidElements(CompositeNode rootNode, AbstractNode lastCompleteNode, int offset, IFollowElementAcceptor acceptor) {
		Set<AbstractElement> nextValidElementSet = getValidElementSet(rootNode, lastCompleteNode, offset);
		if (nextValidElementSet != null && !nextValidElementSet.isEmpty()) {
			IFollowElementAcceptor nullSafeAcceptor = new NullSafeElementAcceptor(acceptor);
			FirstSetCalculator elementSwitch = new FirstSetCalculator(nullSafeAcceptor);
			for (AbstractElement element: nextValidElementSet) {
				elementSwitch.doSwitch(element);
			}
		}
	}
	
	public Set<AbstractElement> getValidElementSet(CompositeNode rootNode, AbstractNode lastCompleteNode, int offset) {
		return ParseTreeUtil.getElementSetValidFromOffset(rootNode, lastCompleteNode, offset);
	}
	
	public static class NullSafeElementAcceptor implements IFollowElementAcceptor {

		private final IFollowElementAcceptor decorated;
		
		public NullSafeElementAcceptor(IFollowElementAcceptor decorated) {
			this.decorated = decorated;
		}
		
		public void accept(AbstractElement element) {
			if (element != null)
				decorated.accept(element);
		}
		
	}
	
	public static class FirstSetCalculator extends XtextSwitch<FirstSetCalculator> {
		
		private final IFollowElementAcceptor acceptor;

		public FirstSetCalculator(IFollowElementAcceptor acceptor) {
			this.acceptor = acceptor;
		}
		
		@Override
		public FirstSetCalculator caseAlternatives(Alternatives alternatives) {
			for (AbstractElement alternativeElement : alternatives.getGroups()) {
				doSwitch(alternativeElement);
			}
			return this;
		}
		
		@Override
		public FirstSetCalculator caseEnumLiteralDeclaration(EnumLiteralDeclaration object) {
			doSwitch(object.getLiteral());
			acceptor.accept(object);
			return this;
		}

		@Override
		public FirstSetCalculator caseGroup(Group group) {
			for(AbstractElement token: group.getTokens()) {
				doSwitch(token);
				if (!isOptional(token))
					return this;
			}
			return this;
		}
		
		@Override
		public FirstSetCalculator caseAssignment(Assignment assignment) {
			acceptor.accept(assignment);
			doSwitch(assignment.getTerminal());
			return this;
		}

		@Override
		public FirstSetCalculator caseRuleCall(RuleCall ruleCall) {
			doSwitch(ruleCall.getRule());
			return this;
		}
		
		@Override
		public FirstSetCalculator caseAbstractRule(AbstractRule object) {
			return this;
		}
		
		@Override
		public FirstSetCalculator caseParserRule(ParserRule object) {
			doSwitch(object.getAlternatives());
			return this;
		}
		
		@Override
		public FirstSetCalculator caseEnumRule(EnumRule object) {
			doSwitch(object.getAlternatives());
			return this;
		}
		
		@Override
		public FirstSetCalculator caseAbstractElement(AbstractElement object) {
			return this;
		}
		
		@Override
		public FirstSetCalculator caseKeyword(Keyword object) {
			acceptor.accept(object);
			return this;
		}

		public boolean isOptional(AbstractElement element) {
			return (element instanceof Action) || GrammarUtil.isOptionalCardinality(element);
		}

	}

}
