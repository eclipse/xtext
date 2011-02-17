/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer.acceptor;

import java.io.IOException;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.parsetree.reconstr.ITokenStream;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.ExceptionDiagnostic;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class TokenStreamSequenceAdapter implements IRecursiveSequenceAcceptor {

	protected ISerializationDiagnostic.Acceptor errorAcceptor;

	protected ITokenStream out;

	public TokenStreamSequenceAdapter(ITokenStream out, ISerializationDiagnostic.Acceptor errorAcceptor) {
		this.out = out;
		this.errorAcceptor = errorAcceptor;
	}

	public void acceptAssignedCrossRefDatatype(RuleCall rc, String token, EObject value, int index, ICompositeNode node) {
		writeSemantic(rc, token);
	}

	public void acceptAssignedCrossRefEnum(RuleCall enumRC, String token, EObject value, int index, ICompositeNode node) {
		writeSemantic(enumRC, token);
	}

	public void acceptAssignedCrossRefTerminal(RuleCall rc, String token, EObject value, int index, ILeafNode node) {
		writeSemantic(rc, token);
	}

	public void acceptAssignedDatatype(RuleCall datatypeRC, String token, Object value, int index, ICompositeNode node) {
		writeSemantic(datatypeRC, token);
	}

	public void acceptAssignedEnum(RuleCall enumRC, String token, Object value, int index, ICompositeNode node) {
		writeSemantic(enumRC, token);
	}

	public void acceptAssignedKeyword(Keyword keyword, String token, Boolean value, int index, ILeafNode node) {
		writeSemantic(keyword, token);
	}

	public void acceptAssignedKeyword(Keyword keyword, String token, String value, int index, ILeafNode node) {
		writeSemantic(keyword, token);
	}

	public void acceptAssignedTerminal(RuleCall terminalRC, String token, Object value, int index, ILeafNode node) {
		writeSemantic(terminalRC, token);
	}

	public void acceptComment(AbstractRule rule, String token, ILeafNode node) {
		writeHidden(rule, token);
	}

	public void acceptUnassignedAction(Action action) {
	}

	public void acceptUnassignedDatatype(RuleCall datatypeRC, String token, ICompositeNode node) {
		writeSemantic(datatypeRC, token);
	}

	public void acceptUnassignedEnum(RuleCall enumRC, String token, ICompositeNode node) {
		writeSemantic(enumRC, token);
	}

	public void acceptUnassignedKeyword(Keyword keyword, ILeafNode node) {
		writeSemantic(keyword, keyword.getValue());
	}

	public void acceptUnassignedTerminal(RuleCall terminalRC, String token, ILeafNode node) {
		writeSemantic(terminalRC, token);
	}

	public void acceptWhitespace(AbstractRule rule, String token, ILeafNode node) {
		writeHidden(rule, token);
	}

	public void enterAssignedAction(Action action, EObject semanticChild, ICompositeNode node) {
	}

	public void enterAssignedParserRuleCall(RuleCall rc, EObject newCurrent, ICompositeNode node) {
	}

	public void enterUnassignedParserRuleCall(RuleCall rc) {
	}

	protected void flush() {
		try {
			out.flush();
		} catch (IOException e) {
			if (errorAcceptor != null)
				errorAcceptor.accept(new ExceptionDiagnostic(e));
		}
	}

	public void leaveAssignedAction(Action action, EObject semanticChild) {
	}

	public void leaveAssignedParserRuleCall(RuleCall rc) {
	}

	public void leaveUnssignedParserRuleCall(RuleCall rc) {
	}

	protected void writeHidden(EObject grammarElement, String value) {
		try {
			out.writeHidden(grammarElement, value);
			//			System.out.println("H:" + value);
		} catch (IOException e) {
			if (errorAcceptor != null)
				errorAcceptor.accept(new ExceptionDiagnostic(e));
		}
	}

	protected void writeSemantic(EObject grammarElement, String value) {
		try {
			//			System.out.println("S:" + value);
			out.writeSemantic(grammarElement, value);
		} catch (IOException e) {
			if (errorAcceptor != null)
				errorAcceptor.accept(new ExceptionDiagnostic(e));
		}

	}

}
