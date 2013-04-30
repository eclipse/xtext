/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.parser.antlr.internal;

import org.antlr.runtime.BitSet;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.parser.IAstFactory;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class InternalXtendParserBase extends AbstractInternalAntlrParser {

	private IAstFactory.Extension semanticModelBuilderExtensions;
	
	protected InternalXtendParserBase(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	protected final boolean shouldPerformAction() {
		state._fsp--;
		return !state.failed && state.backtracking == 0;
	}

	protected final EObject consumeTokenAndSetBooleanValue(int tokenID, BitSet followSet, EObject current,
			AbstractElement grammarElement, ParserRule rule, int featureID) throws RecognitionException {
		Token token = (Token) match(input, tokenID, followSet);
		if (!state.failed && state.backtracking == 0) {
			newLeafNode(token, grammarElement);
			if (current == null) {
				current = createModelElement(rule);
			}
			setWithLastConsumed(current, featureID, Boolean.TRUE, null);
		}
		return current;
	}

	protected final EObject consumeTokenAndSet(int tokenID, BitSet followSet, EObject current,
			AbstractElement grammarElement, ParserRule rule, int featureID) throws RecognitionException {
		Token token = (Token) match(input, tokenID, followSet);
		if (!state.failed && state.backtracking == 0) {
			newLeafNode(token, grammarElement);
			if (current == null) {
				current = createModelElement(rule);
			}
			setWithLastConsumed(current, featureID, token, null);
		}
		return current;
	}

	protected final EObject consumeTokenAndAdd(int tokenID, BitSet followSet, EObject current,
			AbstractElement grammarElement, ParserRule rule, int featureID) throws RecognitionException {
		Token token = (Token) match(input, tokenID, followSet);
		if (!state.failed && state.backtracking == 0) {
			newLeafNode(token, grammarElement);
			if (current == null) {
				current = createModelElement(rule);
			}
			addWithLastConsumed(current, featureID, token, null);
		}
		return current;
	}

	protected final boolean consumeUnassignedToken(int tokenID, BitSet followSet, AbstractElement grammarElement)
			throws RecognitionException {
		Token other = (Token) match(input, tokenID, followSet);
		if (state.failed) {
			return false;
		}
		if (state.backtracking == 0) {
			newLeafNode(other, grammarElement);
		}
		return true;
	}

	protected void pushFollow(BitSet followSet, AbstractElement grammarElement) {
		if (state.backtracking == 0) {
			newCompositeNode(grammarElement);
		}
		pushFollow(followSet);
	}

	protected EObject addValue(EObject current, Object value, ParserRule rule, int featureID, String ruleName) {
		if (shouldPerformAction()) {
			if (current == null) {
				current = createModelElementForParent(rule);
			}
			add(current, featureID, value, ruleName);
			afterParserOrEnumRuleCall();
		}
		return current;
	}

	protected EObject setValue(EObject current, Object value, ParserRule rule, int featureID, String ruleName) {
		if (shouldPerformAction()) {
			if (current == null) {
				current = createModelElementForParent(rule);
			}
			set(current, featureID, value, ruleName);
			afterParserOrEnumRuleCall();
		}
		return current;
	}

	protected EObject getCurrentOrNull(EObject newCurrent) {
		if (shouldPerformAction()) {
			afterParserOrEnumRuleCall();
			return newCurrent;
		}
		return null;
	}

	protected void merge(AntlrDatatypeRuleToken current, AntlrDatatypeRuleToken token) {
		if (shouldPerformAction()) {
			current.merge(token);
			afterParserOrEnumRuleCall();
		}
	}
	
	protected boolean consumeTokenAndMerge(int tokenID, BitSet followSet, AntlrDatatypeRuleToken current,
			AbstractElement grammarElement) throws RecognitionException {
		Token other = (Token) match(input, tokenID, followSet);
		if (state.failed) {
			return false;
		}
		if (state.backtracking == 0) {
			current.merge(other);
			newLeafNode(other, grammarElement); 
		}
		return true;
	}
	
	protected EObject createModelElementAndPushFollow(EObject current, ParserRule rule, BitSet followSet, AbstractElement grammarElement) {
		if (state.backtracking == 0 && current == null) {
			current = createModelElement(rule);
		}
		pushFollow(followSet, grammarElement);
		return current;
	}
	
	protected void postCrossReference() {
		if (shouldPerformAction()) {
			afterParserOrEnumRuleCall();
		}
	}
	
	protected EObject forceCreateModelElementAndAdd(Action action, int featureID, EObject value) {
		InternalEObject result = (InternalEObject) getSemanticModelBuilder().create(action.getType().getClassifier());
		@SuppressWarnings("unchecked")
		InternalEList<EObject> values = (InternalEList<EObject>) result.eGet(featureID, false, false);
		values.addUnique(value);
		insertCompositeNode(action);
		associateNodeWithAstElement(getCurrentNode(), result);
		return result;
	}
	
	protected EObject forceCreateModelElementAndSet(Action action, int featureID, EObject value) {
		InternalEObject result = (InternalEObject) getSemanticModelBuilder().create(action.getType().getClassifier());
		result.eSet(featureID, value);
		insertCompositeNode(action);
		associateNodeWithAstElement(getCurrentNode(), result);
		return result;
	}
	
	protected void set(EObject _this, int featureID, Object value, String lexerRule, INode node) {
		try {
			semanticModelBuilderExtensions.set(_this, featureID, value, lexerRule, node);
		} catch (ValueConverterException vce) {
			handleValueConverterException(vce);
		}
	}

	protected void set(EObject _this, int featureID, Object value, String lexerRule) {
		set(_this, featureID, value, lexerRule, getCurrentNode());
	}

	protected void setWithLastConsumed(EObject _this, int featureID, Object value, String lexerRule) {
		set(_this, featureID, value, lexerRule, getLastConsumedNode());
	}

	protected void add(EObject _this, int featureID, Object value, String lexerRule, INode node) {
		try {
			semanticModelBuilderExtensions.add(_this, featureID, value, lexerRule, node);
		} catch (ValueConverterException vce) {
			handleValueConverterException(vce);
		}
	}

	protected void add(EObject _this, int featureID, Object value, String lexerRule) {
		add(_this, featureID, value, lexerRule, getCurrentNode());
	}

	protected void addWithLastConsumed(EObject _this, int featureID, Object value, String lexerRule) {
		add(_this, featureID, value, lexerRule, getLastConsumedNode());
	}
	
	@Override
	public void setSemanticModelBuilder(IAstFactory semanticModelBuilder) {
		if (!(semanticModelBuilder instanceof IAstFactory.Extension)) {
			throw new IllegalArgumentException();
		}
		this.semanticModelBuilderExtensions = (IAstFactory.Extension)semanticModelBuilder;
		super.setSemanticModelBuilder(semanticModelBuilder);
	}
	
}
