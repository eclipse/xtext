/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.parser.packrat;

import org.eclipse.xtext.parser.packrat.tokens.AbstractParsedToken;
import org.eclipse.xtext.parser.packrat.tokens.AlternativesToken;
import org.eclipse.xtext.parser.packrat.tokens.AssignmentToken;
import org.eclipse.xtext.parser.packrat.tokens.CompoundParsedToken;
import org.eclipse.xtext.parser.packrat.tokens.ErrorToken;
import org.eclipse.xtext.parser.packrat.tokens.FakedToken;
import org.eclipse.xtext.parser.packrat.tokens.GroupToken;
import org.eclipse.xtext.parser.packrat.tokens.ParsedAction;
import org.eclipse.xtext.parser.packrat.tokens.ParsedEnumLiteral;
import org.eclipse.xtext.parser.packrat.tokens.ParsedNonTerminal;
import org.eclipse.xtext.parser.packrat.tokens.ParsedNonTerminalEnd;
import org.eclipse.xtext.parser.packrat.tokens.ParsedTerminal;
import org.eclipse.xtext.parser.packrat.tokens.ParsedTerminalWithFeature;
import org.eclipse.xtext.parser.packrat.tokens.ParsedTerminalWithFeatureInfo;
import org.eclipse.xtext.parser.packrat.tokens.ParsedToken;
import org.eclipse.xtext.parser.packrat.tokens.PlaceholderToken;
import org.eclipse.xtext.parser.packrat.tokens.UnorderedGroupToken;

import com.google.common.base.Function;

/**
 * Interface for ParsedTokenVisitor.
 * It is not intended to be implemented by clients. Use AbstractParsedTokenVisitor instead.
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface IParsedTokenVisitor extends Function<AbstractParsedToken, Void> {

	void visitAbstractParsedToken(AbstractParsedToken token);

	void visitAbstractParsedTokenEnd(AbstractParsedToken.End token);

	void visitCompoundParsedToken(CompoundParsedToken token);

	void visitCompoundParsedTokenEnd(CompoundParsedToken.End token);

	void visitAlternativesToken(AlternativesToken token);

	void visitAlternativesTokenEnd(AlternativesToken.End token);

	void visitGroupToken(GroupToken token);

	void visitGroupTokenEnd(GroupToken.End token);

	void visitUnorderedGroupToken(UnorderedGroupToken token);
	
	void visitUnorderedGroupTokenEnd(UnorderedGroupToken.End token);
	
	void visitAssignmentToken(AssignmentToken token);

	void visitAssignmentTokenEnd(AssignmentToken.End token);

	void visitErrorToken(ErrorToken token);

	void visitParsedToken(ParsedToken token);

	void visitParsedTerminal(ParsedTerminal token);

	void visitParsedNonTerminal(ParsedNonTerminal token);

	void visitParsedNonTerminalEnd(ParsedNonTerminalEnd token);

	void visitFakedToken(FakedToken token);

	void visitParsedAction(ParsedAction action);

	void visitPlaceholder(PlaceholderToken action);

	void visitParsedTerminalWithFeature(ParsedTerminalWithFeature token);

	void visitParsedTerminalWithFeatureInfo(ParsedTerminalWithFeatureInfo token);

	void visitParsedEnumLiteral(ParsedEnumLiteral token);

}
