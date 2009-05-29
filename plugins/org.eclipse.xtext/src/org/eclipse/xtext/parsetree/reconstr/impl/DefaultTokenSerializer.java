/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parsetree.reconstr.impl;

import java.io.IOException;
import java.io.OutputStream;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.EnumLiteralDeclaration;
import org.eclipse.xtext.EnumRule;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.parsetree.reconstr.ICrossReferenceSerializer;
import org.eclipse.xtext.parsetree.reconstr.IInstanceDescription;
import org.eclipse.xtext.parsetree.reconstr.IUnassignedTextSerializer;
import org.eclipse.xtext.parsetree.reconstr.IParseTreeConstructor.IAbstractToken;
import org.eclipse.xtext.parsetree.reconstr.IParseTreeConstructor.IAssignmentToken;
import org.eclipse.xtext.parsetree.reconstr.IParseTreeConstructor.IKeywordToken;
import org.eclipse.xtext.parsetree.reconstr.IParseTreeConstructor.IUnassignedTextToken;

import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class DefaultTokenSerializer extends AbstractTokenSerializer {

	@Inject
	protected IValueConverterService converterService;

	@Inject
	protected ICrossReferenceSerializer crossRefSerializer;

	@Inject
	protected IUnassignedTextSerializer unassTextSerializer;

	protected boolean outputHasStarted;

	protected OutputStream out;

	/**
	 * @throws IOException
	 */
	protected void afterElement(IInstanceDescription curr, AbstractElement ele)
			throws IOException {
	}

	/**
	 * @throws IOException
	 */
	protected void afterToken(IAbstractToken token) throws IOException {
	}

	protected void append(String str) throws IOException {
		if (str == null)
			out.write("null".getBytes());
		else
			out.write(str.getBytes());
		outputHasStarted = true;
	}

	protected void beforeElement(IInstanceDescription curr, AbstractElement ele)
			throws IOException {
		if (outputHasStarted)
			append(" ");
	}

	/**
	 * @throws IOException
	 */
	protected void beforeToken(IAbstractToken token) throws IOException {
	}

	protected void elementCrossRef(IInstanceDescription current,
			CrossReference call, EObject value) throws IOException {
		beforeElement(current, call);
		append(crossRefSerializer.serializeCrossRef(current, call, value));
		afterElement(current, call);
	}

	protected void elementKeyword(IInstanceDescription current, Keyword call)
			throws IOException {
		beforeElement(current, call);
		append(call.getValue());
		afterElement(current, call);
	}

	protected void elementLexerRuleCall(IInstanceDescription current,
			RuleCall call, Object value) throws IOException {
		beforeElement(current, call);
		append(converterService.toString(value, call.getRule().getName()));
		afterElement(current, call);
	}

	protected void elementEnumRuleCall(IInstanceDescription current,
			RuleCall call, Object value) throws IOException {
		beforeElement(current, call);
		EnumRule rule = (EnumRule) call.getRule();
		if (rule.getAlternatives() instanceof EnumLiteralDeclaration) {
			EnumLiteralDeclaration decl = (EnumLiteralDeclaration) rule
					.getAlternatives();
			append(decl.getLiteral().getValue());
		} else {
			for (AbstractElement element : ((Alternatives) rule
					.getAlternatives()).getGroups()) {
				EnumLiteralDeclaration decl = (EnumLiteralDeclaration) element;
				if (decl.getEnumLiteral().getInstance().equals(value)) {
					append(decl.getLiteral().getValue());
					break;
				}
			}
		}
		afterElement(current, call);
	}

	@Override
	public void serialize(IAbstractToken firstToken, OutputStream out)
			throws IOException {
		outputHasStarted = false;
		this.out = out;
		for (IAbstractToken t = firstToken; t != null; t = t.getNext()) {
			beforeToken(t);
			token(t);
			afterToken(t);
		}
	}

	protected void token(IAbstractToken t) throws IOException {
		if (t instanceof IKeywordToken)
			tokenKeyword((IKeywordToken) t);
		else if (t instanceof IAssignmentToken)
			tokenAssignment((IAssignmentToken) t);
		else if (t instanceof IUnassignedTextToken)
			tokenUnassText((IUnassignedTextToken) t);
	}

	protected void tokenUnassText(IUnassignedTextToken token)
			throws IOException {
		String val = unassTextSerializer.serializeUnassignedRuleCall(token
				.getGrammarElement(), token.getCurrent().getDelegate());
		beforeElement(token.getCurrent(), token.getGrammarElement());
		append(val);
		afterElement(token.getCurrent(), token.getGrammarElement());
	}

	protected void tokenAssignment(IAssignmentToken ass) throws IOException {
		if (ass == null || ass.getType() == null)
			return;
		switch (ass.getType()) {
		case CR:
			elementCrossRef(ass.getCurrent(), (CrossReference) ass
					.getAssignmentElement(), (EObject) ass.getValue());
			break;
		case KW:
			elementKeyword(ass.getCurrent(), (Keyword) ass
					.getAssignmentElement());
			break;
		case LRC:
			elementLexerRuleCall(ass.getCurrent(), (RuleCall) ass
					.getAssignmentElement(), ass.getValue());
			break;
		case ERC:
			elementEnumRuleCall(ass.getCurrent(), (RuleCall) ass
					.getAssignmentElement(), ass.getValue());
			break;
		case PRC:
			final RuleCall ruleCall = (RuleCall) ass.getAssignmentElement();
			if (ruleCall != null) {
				final ParserRule parserRule = (ParserRule) ruleCall.getRule();
				if (GrammarUtil.isDatatypeRule(parserRule)) {
					elementLexerRuleCall(ass.getCurrent(), ruleCall, ass
							.getValue());
				}
			}
			break;
		default:
			break;
		}

	}

	protected void tokenKeyword(IKeywordToken kw) throws IOException {
		elementKeyword(kw.getCurrent(), kw.getGrammarElement());
	}
}
