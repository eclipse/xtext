/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer.impl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.serializer.IGrammarConstraintProvider.IConstraintElement;
import org.eclipse.xtext.serializer.ISequencer;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public abstract class AbstractSequencer implements ISequencer {
	protected static class EObjectActionPair extends GrammarValuePair implements IEObjectActionPair {
		protected Action action;
		protected EObject value;

		public EObjectActionPair(Action action, EObject value) {
			super();
			this.action = action;
			this.value = value;
		}

		public Action getGrammarElement() {
			return this.action;
		}

		public EObject getValue() {
			return this.value;
		}

	}

	protected static class EObjectRuleCallPair extends GrammarValuePair implements IEObjectRuleCallPair {
		protected RuleCall ruleCall;
		protected EObject value;

		public EObjectRuleCallPair(RuleCall ruleCall, EObject value) {
			super();
			this.ruleCall = ruleCall;
			this.value = value;
		}

		public RuleCall getGrammarElement() {
			return this.ruleCall;
		}

		public EObject getValue() {
			return this.value;
		}

	}

	protected abstract static class GrammarValuePair implements IGrammarValuePair {
		@Override
		public String toString() {
			return PairFormatter.toStr(this);
		}
	}

	protected static class KeywordValuePair extends GrammarValuePair implements IKeywordValuePair {
		protected Keyword keyword;
		protected String value;

		public KeywordValuePair(Keyword keyword, String value) {
			super();
			this.keyword = keyword;
			this.value = value;
		}

		public Keyword getGrammarElement() {
			return this.keyword;
		}

		public String getValue() {
			return this.value;
		}

	}

	protected static class ValueRuleCallPair extends GrammarValuePair implements IValueRuleCallPair {
		protected RuleCall ruleCall;
		protected Object value;

		public ValueRuleCallPair(RuleCall ruleCall, Object value) {
			super();
			this.ruleCall = ruleCall;
			this.value = value;
		}

		public RuleCall getGrammarElement() {
			return this.ruleCall;
		}

		public Object getValue() {
			return this.value;
		}

	}

	protected IEObjectActionPair newPair(Action action, EObject value) {
		return new EObjectActionPair(action, value);
	}

	protected IGrammarValuePair newPair(IConstraintElement constraint, Object value) {
		switch (constraint.getType()) {
			case ASSIGNED_ACTION_CALL:
				return newPair(constraint.getAction(), (EObject) value);
			case ASSIGNED_PARSER_RULE_CALL:
			case ASSIGNED_CROSSREF_DATATYPE_RULE_CALL:
			case ASSIGNED_CROSSREF_ENUM_RULE_CALL:
			case ASSIGNED_CROSSREF_TERMINAL_RULE_CALL:
				return newPair(constraint.getRuleCall(), (EObject) value);
			case ASSIGNED_DATATYPE_RULE_CALL:
			case ASSIGNED_ENUM_RULE_CALL:
			case ASSIGNED_TERMINAL_RULE_CALL:
			case UNASSIGNED_DATATYPE_RULE_CALL:
			case UNASSIGNED_TERMINAL_RULE_CALL:
				return newPair(constraint.getRuleCall(), value);
			case ASSIGNED_KEYWORD:
			case ASSIGNED_CROSSREF_KEYWORD:
				return newPair(constraint.getKeyword(), (String) value);
			case ALTERNATIVE:
			case GROUP:
				return null;
		}
		return null;
	}

	protected IKeywordValuePair newPair(Keyword keyword, String value) {
		return new KeywordValuePair(keyword, value);
	}

	protected IEObjectRuleCallPair newPair(RuleCall ruleCall, EObject value) {
		return new EObjectRuleCallPair(ruleCall, value);
	}

	protected IValueRuleCallPair newPair(RuleCall ruleCall, Object value) {
		return new ValueRuleCallPair(ruleCall, value);
	}
}
