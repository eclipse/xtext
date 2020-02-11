/*******************************************************************************
 * Copyright (c) 2011, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.serializer.acceptor;

import java.io.IOException;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.parsetree.reconstr.ITokenStream;
import org.eclipse.xtext.parsetree.reconstr.ITokenStreamExtension;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.ExceptionDiagnostic;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class TokenStreamSequenceAdapter implements ISequenceAcceptor {

	protected ISerializationDiagnostic.Acceptor errorAcceptor;

	protected ITokenStream out;

	protected Grammar grammar;

	public TokenStreamSequenceAdapter(ITokenStream out, Grammar grammar, ISerializationDiagnostic.Acceptor errorAcceptor) {
		this.out = out;
		this.grammar = grammar;
		this.errorAcceptor = errorAcceptor;
	}

	@Override
	public void acceptAssignedCrossRefDatatype(RuleCall rc, String token, EObject value, int index, ICompositeNode node) {
		writeSemantic(GrammarUtil.containingCrossReference(rc), token);
	}

	@Override
	public void acceptAssignedCrossRefEnum(RuleCall enumRC, String token, EObject value, int index, ICompositeNode node) {
		writeSemantic(GrammarUtil.containingCrossReference(enumRC), token);
	}

	@Override
	public void acceptAssignedCrossRefKeyword(Keyword kw, String token, EObject value, int index, ILeafNode node) {
		writeSemantic(GrammarUtil.containingCrossReference(kw), token);
	}

	@Override
	public void acceptAssignedCrossRefTerminal(RuleCall rc, String token, EObject value, int index, ILeafNode node) {
		writeSemantic(GrammarUtil.containingCrossReference(rc), token);
	}

	@Override
	public void acceptAssignedDatatype(RuleCall datatypeRC, String token, Object value, int index, ICompositeNode node) {
		writeSemantic(datatypeRC, token);
	}

	@Override
	public void acceptAssignedEnum(RuleCall enumRC, String token, Object value, int index, ICompositeNode node) {
		writeSemantic(enumRC, token);
	}

	@Override
	public void acceptAssignedKeyword(Keyword keyword, String token, Object value, int index, ILeafNode node) {
		writeSemantic(keyword, token);
	}

	@Override
	public void acceptAssignedTerminal(RuleCall terminalRC, String token, Object value, int index, ILeafNode node) {
		writeSemantic(terminalRC, token);
	}

	@Override
	public void acceptComment(AbstractRule rule, String token, ILeafNode node) {
		writeHidden(rule, token);
	}

	@Override
	public void acceptUnassignedAction(Action action) {
	}

	@Override
	public void acceptUnassignedDatatype(RuleCall datatypeRC, String token, ICompositeNode node) {
		writeSemantic(datatypeRC, token);
	}

	@Override
	public void acceptUnassignedEnum(RuleCall enumRC, String token, ICompositeNode node) {
		writeSemantic(enumRC, token);
	}

	@Override
	public void acceptUnassignedKeyword(Keyword keyword, String token, ILeafNode node) {
		writeSemantic(keyword, token);
	}

	@Override
	public void acceptUnassignedTerminal(RuleCall terminalRC, String token, ILeafNode node) {
		writeSemantic(terminalRC, token);
	}

	@Override
	public void acceptWhitespace(AbstractRule rule, String token, ILeafNode node) {
		writeHidden(rule, token);
	}

	@Override
	public boolean enterAssignedAction(Action action, EObject semanticChild, ICompositeNode node) {
		return true;
	}

	@Override
	public boolean enterAssignedParserRuleCall(RuleCall rc, EObject newCurrent, ICompositeNode node) {
		return true;
	}

	@Override
	@Deprecated
	public void enterUnassignedParserRuleCall(RuleCall rc) {
	}

	@Override
	public void finish() {
	}

	protected void flush() {
		try {
			out.flush();
		} catch (IOException e) {
			if (errorAcceptor != null)
				errorAcceptor.accept(new ExceptionDiagnostic(grammar, e));
		}
	}

	/**
	 * @deprecated use {@link #init(ISerializationContext)}
	 */
	@Deprecated
	public void init(EObject context) {
		if (context instanceof ParserRule && out instanceof ITokenStreamExtension) {
			((ITokenStreamExtension) out).init((ParserRule) context);
		}
	}
	
	public void init(ISerializationContext context) {
		if (context instanceof ParserRule && out instanceof ITokenStreamExtension) {
			((ITokenStreamExtension) out).init(context.getParserRule());
		}
	}

	@Override
	public void leaveAssignedAction(Action action, EObject semanticChild) {
	}

	public void leaveAssignedParserRuleCall(RuleCall rc) {
	}

	@Override
	public void leaveAssignedParserRuleCall(RuleCall rc, EObject semanticChild) {
	}

	@Override
	@Deprecated
	public void leaveUnssignedParserRuleCall(RuleCall rc) {
	}

	protected void writeHidden(EObject grammarElement, String value) {
		try {
			out.writeHidden(grammarElement, value);
			//			System.out.println("H:" + value);
		} catch (IOException e) {
			if (errorAcceptor != null)
				errorAcceptor.accept(new ExceptionDiagnostic(grammar, e));
		}
	}

	protected void writeSemantic(EObject grammarElement, String value) {
		try {
			//			System.out.println("S:" + value);
			out.writeSemantic(grammarElement, value);
		} catch (IOException e) {
			if (errorAcceptor != null)
				errorAcceptor.accept(new ExceptionDiagnostic(grammar, e));
		}

	}

}
