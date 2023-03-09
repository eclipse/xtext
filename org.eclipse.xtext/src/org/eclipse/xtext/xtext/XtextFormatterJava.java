/*******************************************************************************
 * Copyright (c) 2020 itemis AG (http://www.itemis.com) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractMetamodelDeclaration;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Annotation;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CharacterRange;
import org.eclipse.xtext.CompoundElement;
import org.eclipse.xtext.Conjunction;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.Disjunction;
import org.eclipse.xtext.EnumLiteralDeclaration;
import org.eclipse.xtext.EnumRule;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.NamedArgument;
import org.eclipse.xtext.NegatedToken;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.TypeRef;
import org.eclipse.xtext.UnorderedGroup;
import org.eclipse.xtext.UntilToken;
import org.eclipse.xtext.Wildcard;
import org.eclipse.xtext.formatting2.AbstractJavaFormatter;
import org.eclipse.xtext.formatting2.IFormattableDocument;

/**
 * @author Arne Deutsch - Initial contribution and API
 */
public class XtextFormatterJava extends AbstractJavaFormatter {

	protected void format(Grammar grammar, IFormattableDocument doc) {
		doc.prepend(regionFor(grammar).keyword("("), this::noSpace);
		formatParens(grammar, doc);
		regionFor(grammar).keywords(",").forEach(s -> doc.prepend(s, this::noSpace));
		regionFor(grammar).keywords(",").forEach(s -> doc.append(s, this::oneSpace));
		boolean first = true;
		for (AbstractMetamodelDeclaration decl : grammar.getMetamodelDeclarations()) {
			doc.set(previousHiddenRegion(decl), first ? it -> it.setNewLines(2) : it -> it.setNewLines(1));
			first = false;
			doc.format(decl);
		}
		for (AbstractRule rule : grammar.getRules()) {
			doc.set(previousHiddenRegion(rule), it -> it.setNewLines(2));
			doc.format(rule);
		}
		doc.set(nextHiddenRegion(grammar), it -> it.setNewLines(0, 0, 1));
	}

	protected void format(ParserRule rule, IFormattableDocument doc) {
		doc.prepend(regionFor(rule).keyword("<"), this::oneSpace);
		doc.append(regionFor(rule).keyword("<"), this::noSpace);
		doc.prepend(regionFor(rule).keyword(">"), this::noSpace);
		rule.getParameters().forEach(p -> doc.format(p));
		formatRule(rule, doc);
		formatParens(rule, doc);
	}

	protected void format(TerminalRule rule, IFormattableDocument doc) {
		formatRule(rule, doc);
	}

	protected void format(EnumRule rule, IFormattableDocument doc) {
		formatRule(rule, doc);
	}

	protected void format(EnumLiteralDeclaration decl, IFormattableDocument doc) {
		doc.surround(regionFor(decl).keyword("="), this::noSpace);
	}

	protected void format(Alternatives alternatives, IFormattableDocument doc) {
		regionFor(alternatives).keywords("|").forEach(r -> {
			doc.surround(r, this::autowrap);
			doc.surround(r, it -> it.setNewLines(0, 0, 1));
			doc.surround(r, this::oneSpace);
		});
		formatParens(alternatives, doc);
		formatCardinality(alternatives, doc);
		formatGroupElements(alternatives, doc);
	}

	protected void format(Assignment assignment, IFormattableDocument doc) {
		regionFor(assignment).keywords("=", "+=", "?=").forEach(r -> doc.surround(r, this::noSpace));
		regionFor(assignment).keywords("->", "=>").forEach(k -> doc.append(k, this::noSpace));
		formatParens(assignment, doc);
		formatCardinality(assignment, doc);
		doc.format(assignment.getTerminal());
	}

	protected void format(Group group, IFormattableDocument doc) {
		doc.append(regionFor(group).keyword("<"), this::noSpace);
		doc.format(group.getGuardCondition());
		doc.prepend(regionFor(group).keyword(">"), this::noSpace);
		formatParens(group, doc);
		formatCardinality(group, doc);
		formatGroupElements(group, doc);
	}

	protected void format(UnorderedGroup group, IFormattableDocument doc) {
		regionFor(group).keywords("&").forEach(r -> doc.surround(r, this::oneSpace));
		formatParens(group, doc);
		formatGroupElements(group, doc);
	}

	protected void format(Conjunction conjunction, IFormattableDocument doc) {
		regionFor(conjunction).keywords("&").forEach(r -> doc.surround(r, this::oneSpace));
		formatParens(conjunction, doc);
		doc.format(conjunction.getRight());
	}

	protected void format(Disjunction disjunction, IFormattableDocument doc) {
		regionFor(disjunction).keywords("|").forEach(r -> doc.surround(r, this::oneSpace));
		formatParens(disjunction, doc);
		doc.format(disjunction.getRight());
	}

	protected void format(Wildcard wildcard, IFormattableDocument doc) {
		doc.surround(regionFor(wildcard).keyword(":"), this::oneSpace);
	}

	protected void format(CharacterRange range, IFormattableDocument doc) {
		doc.surround(regionFor(range).keyword(".."), this::noSpace);
		formatParens(range, doc);
		formatCardinality(range, doc);
		doc.format(range.getLeft());
		doc.format(range.getRight());
	}

	protected void format(RuleCall call, IFormattableDocument doc) {
		doc.append(call, this::autowrap);
		doc.surround(regionFor(call).keyword("<"), this::noSpace);
		doc.prepend(regionFor(call).keyword(">"), this::noSpace);
		regionFor(call).keywords(",").forEach(r -> doc.prepend(r, this::noSpace));
		regionFor(call).keywords(",").forEach(r -> doc.append(r, this::oneSpace));
		formatParens(call, doc);
		formatCardinality(call, doc);
		call.getArguments().forEach(a -> doc.format(a));
	}

	protected void format(Keyword keyword, IFormattableDocument doc) {
		doc.surround(keyword, this::autowrap);
		regionFor(keyword).keywords("->", "=>").forEach(k -> doc.append(k, this::noSpace));
		formatParens(keyword, doc);
		formatCardinality(keyword, doc);
	}

	protected void format(NegatedToken token, IFormattableDocument doc) {
		doc.append(regionFor(token).keyword("!"), this::noSpace);
		formatParens(token, doc);
		formatCardinality(token, doc);
		doc.format(token.getTerminal());
	}

	protected void format(UntilToken token, IFormattableDocument doc) {
		doc.surround(regionFor(token).keyword("->"), this::noSpace);
		doc.format(token.getTerminal());
	}

	protected void format(Action action, IFormattableDocument doc) {
		doc.prepend(regionFor(action).keyword("{"), this::autowrap);
		doc.append(regionFor(action).keyword("{"), this::noSpace);
		doc.prepend(regionFor(action).keyword("}"), this::noSpace);
		doc.append(regionFor(action).keyword("}"), this::autowrap);
		doc.surround(regionFor(action).keyword("."), this::noSpace);
		regionFor(action).keywords("=", "+=").forEach(k -> doc.surround(k, this::noSpace));
		doc.format(action.getType());
	}

	protected void format(CrossReference ref, IFormattableDocument doc) {
		doc.append(regionFor(ref).keyword("["), this::noSpace);
		doc.prepend(regionFor(ref).keyword("]"), this::noSpace);
		doc.surround(regionFor(ref).keyword("|"), this::noSpace);
		doc.format(ref.getType());
	}

	protected void format(Parameter param, IFormattableDocument doc) {
	}

	protected void format(NamedArgument param, IFormattableDocument doc) {
		regionFor(param).keywords("=").forEach(k -> doc.surround(k, this::noSpace));
	}

	protected void format(TypeRef ref, IFormattableDocument doc) {
		doc.surround(regionFor(ref).keyword("::"), this::noSpace);
	}

	protected void format(Annotation annotation, IFormattableDocument doc) {
		doc.surround(regionFor(annotation).keyword("@"), this::noSpace);
		doc.append(annotation, this::newLine);
	}

	private void formatGroupElements(CompoundElement group, IFormattableDocument doc) {
		boolean first = true;
		EList<AbstractElement> elements = group.getElements();
		int size = elements.size();
		for (int index = 0; index < elements.size(); index++) {
			boolean last = index + 1 == size;
			AbstractElement element = elements.get(index);
			AbstractElement next = null;
			if (!last)
				next = elements.get(index + 1);
			if (first && !last) {
				if (elementsAreSeperatedBySpace(element, next))
					doc.append(element, this::oneSpace);
			} else if (!first && !last) {
				doc.prepend(element, it -> it.setNewLines(0, 0, 1));
				if (elementsAreSeperatedBySpace(element, next))
					doc.surround(element, this::oneSpace);
			} else if (!first && last) {
				doc.prepend(element, it -> it.setNewLines(0, 0, 1));
			}
			first = false;
			doc.format(element);
		}
	}

	private boolean elementsAreSeperatedBySpace(AbstractElement element, AbstractElement next) {
		return !(element instanceof UntilToken || element instanceof Group || next instanceof UntilToken);
	}

	private void formatRule(AbstractRule rule, IFormattableDocument doc) {
		doc.surround(regionFor(rule).keyword("returns"), this::oneSpace);
		doc.prepend(regionFor(rule).keyword("hidden"), this::oneSpace);
		doc.append(regionFor(rule).keyword("hidden"), this::noSpace);
		regionFor(rule).keywords(",").forEach(r -> doc.prepend(r, this::noSpace));
		regionFor(rule).keywords(",").forEach(r -> doc.append(r, this::oneSpace));
		doc.prepend(regionFor(rule).keyword(":"), this::noSpace);
		doc.append(regionFor(rule).keyword(":"), this::newLine);
		doc.prepend(regionFor(rule).keyword(";"), this::noSpace);
		doc.append(regionFor(rule).keyword(";"), this::noSpace);
		doc.interior(regionFor(rule).keyword(":"), regionFor(rule).keyword(";"), this::indent);
		rule.getAnnotations().forEach(a -> doc.format(a));
		doc.format(rule.getType());
		doc.format(rule.getAlternatives());
	}

	private void formatParens(EObject element, IFormattableDocument doc) {
		doc.prepend(regionFor(element).keyword("("), this::autowrap);
		doc.append(regionFor(element).keyword("("), this::noSpace);
		doc.prepend(regionFor(element).keyword(")"), this::noSpace);
		doc.append(regionFor(element).keyword(")"), this::autowrap);
	}

	private void formatCardinality(EObject element, IFormattableDocument doc) {
		regionFor(element).keywords("?", "*", "+").forEach(r -> doc.prepend(r, this::noSpace));
		regionFor(element).keywords("?", "*", "+").forEach(r -> doc.append(r, this::autowrap));
	}

}
