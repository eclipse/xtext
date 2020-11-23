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
		doc.prepend(regionFor(grammar).keyword("("), it -> it.noSpace());
		formatParens(grammar, doc);
		regionFor(grammar).keywords(",").forEach(s -> doc.prepend(s, it -> it.noSpace()));
		regionFor(grammar).keywords(",").forEach(s -> doc.append(s, it -> it.oneSpace()));
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
		doc.prepend(regionFor(rule).keyword("<"), it -> it.oneSpace());
		doc.append(regionFor(rule).keyword("<"), it -> it.noSpace());
		doc.prepend(regionFor(rule).keyword(">"), it -> it.noSpace());
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
		doc.surround(regionFor(decl).keyword("="), it -> it.noSpace());
	}

	protected void format(Alternatives alternatives, IFormattableDocument doc) {
		regionFor(alternatives).keywords("|").forEach(r -> {
			doc.surround(r, it -> it.autowrap());
			doc.surround(r, it -> it.setNewLines(0, 0, 1));
			doc.surround(r, it -> it.oneSpace());
		});
		formatParens(alternatives, doc);
		formatCardinality(alternatives, doc);
		for (AbstractElement element : alternatives.getElements())
			doc.format(element);
	}

	protected void format(Assignment assignment, IFormattableDocument doc) {
		regionFor(assignment).keywords("=", "+=", "?=").forEach(r -> doc.surround(r, it -> it.noSpace()));
		formatCardinality(assignment, doc);
		formatParens(assignment, doc);
		doc.format(assignment.getTerminal());
	}

	protected void format(Group group, IFormattableDocument doc) {
		doc.append(regionFor(group).keyword("<"), it -> it.noSpace());
		doc.format(group.getGuardCondition());
		doc.prepend(regionFor(group).keyword(">"), it -> it.noSpace());
		formatCardinality(group, doc);
		formatParens(group, doc);
		formatGroupElements(group, doc);
	}

	protected void format(UnorderedGroup group, IFormattableDocument doc) {
		doc.append(regionFor(group).keyword("&"), it -> it.oneSpace());
		formatGroupElements(group, doc);
	}

	protected void format(Conjunction conjunction, IFormattableDocument doc) {
		regionFor(conjunction).keywords("&").forEach(r -> doc.surround(r, it -> it.oneSpace()));
		doc.format(conjunction.getRight());
	}

	protected void format(Disjunction disjunction, IFormattableDocument doc) {
		regionFor(disjunction).keywords("|").forEach(r -> doc.surround(r, it -> it.oneSpace()));
		doc.format(disjunction.getRight());
	}

	protected void format(Wildcard wildcard, IFormattableDocument doc) {
		doc.surround(regionFor(wildcard).keyword(":"), it -> it.oneSpace());
	}

	protected void format(CharacterRange range, IFormattableDocument doc) {
		doc.surround(regionFor(range).keyword(".."), it -> it.noSpace());
		formatCardinality(range, doc);
		doc.format(range.getLeft());
		doc.format(range.getRight());
	}

	protected void format(RuleCall call, IFormattableDocument doc) {
		doc.append(call, it -> it.autowrap());
		doc.surround(regionFor(call).keyword("<"), it -> it.noSpace());
		doc.prepend(regionFor(call).keyword(">"), it -> it.noSpace());
		regionFor(call).keywords(",").forEach(r -> doc.prepend(r, it -> it.noSpace()));
		regionFor(call).keywords(",").forEach(r -> doc.append(r, it -> it.oneSpace()));
		formatCardinality(call, doc);
		call.getArguments().forEach(a -> doc.format(a));
	}

	protected void format(Keyword keyword, IFormattableDocument doc) {
		doc.surround(keyword, it -> it.autowrap());
		formatCardinality(keyword, doc);
	}

	protected void format(NegatedToken token, IFormattableDocument doc) {
		doc.append(regionFor(token).keyword("!"), it -> it.noSpace());
		formatParens(token, doc);
		formatCardinality(token, doc);
		doc.format(token.getTerminal());
	}

	protected void format(UntilToken token, IFormattableDocument doc) {
		doc.surround(regionFor(token).keyword("->"), it -> it.noSpace());
		doc.format(token.getTerminal());
	}

	protected void format(Action action, IFormattableDocument doc) {
		doc.append(regionFor(action).keyword("{"), it -> it.noSpace());
		doc.prepend(regionFor(action).keyword("}"), it -> it.noSpace());
		doc.surround(regionFor(action).keyword("."), it -> it.noSpace());
		doc.surround(regionFor(action).keyword("="), it -> it.noSpace());
	}

	protected void format(CrossReference ref, IFormattableDocument doc) {
		doc.prepend(regionFor(ref).keyword("["), it -> it.autowrap());
		doc.append(regionFor(ref).keyword("["), it -> it.noSpace());
		doc.prepend(regionFor(ref).keyword("]"), it -> it.noSpace());
		doc.append(regionFor(ref).keyword("]"), it -> it.autowrap());
		doc.surround(regionFor(ref).keyword("|"), it -> it.noSpace());
		doc.format(ref.getType());
	}

	protected void format(Parameter param, IFormattableDocument doc) {
	}

	protected void format(NamedArgument param, IFormattableDocument doc) {
		regionFor(param).keywords("=").forEach(k -> doc.surround(k, it -> it.noSpace()));
	}

	protected void format(TypeRef ref, IFormattableDocument doc) {
		doc.surround(regionFor(ref).keyword("::"), it -> it.noSpace());
	}

	protected void format(Annotation annotation, IFormattableDocument doc) {
		doc.surround(regionFor(annotation).keyword("@"), it -> it.noSpace());
		doc.append(annotation, it -> it.newLine());
	}

	private void formatGroupElements(CompoundElement group, IFormattableDocument doc) {
		boolean first = true;
		EList<AbstractElement> elements = group.getElements();
		int size = elements.size();
		int index = 0;
		for (AbstractElement element : elements) {
			index++;
			boolean last = index == size;
			if (!first && !last) {
				doc.prepend(element, it -> it.setNewLines(0, 0, 1));
				if (!(element instanceof UntilToken) && !(element instanceof Group))
					doc.surround(element, it -> it.oneSpace());
			} else if (!first && last) {
				doc.prepend(element, it -> it.setNewLines(0, 0, 1));
			}
			first = false;
			doc.format(element);
		}
	}

	private void formatRule(AbstractRule rule, IFormattableDocument doc) {
		doc.surround(regionFor(rule).keyword("returns"), it -> it.oneSpace());
		doc.prepend(regionFor(rule).keyword("hidden"), it -> it.oneSpace());
		doc.append(regionFor(rule).keyword("hidden"), it -> it.noSpace());
		regionFor(rule).keywords(",").forEach(r -> doc.prepend(r, it -> it.noSpace()));
		regionFor(rule).keywords(",").forEach(r -> doc.append(r, it -> it.oneSpace()));
		doc.prepend(regionFor(rule).keyword(":"), it -> it.noSpace());
		doc.append(regionFor(rule).keyword(":"), it -> it.newLine());
		doc.prepend(regionFor(rule).keyword(";"), it -> it.noSpace());
		doc.append(regionFor(rule).keyword(";"), it -> it.noSpace());
		doc.interior(regionFor(rule).keyword(":"), regionFor(rule).keyword(";"), it -> it.indent());
		rule.getAnnotations().forEach(a -> doc.format(a));
		doc.format(rule.getType());
		doc.format(rule.getAlternatives());
	}

	private void formatParens(EObject element, IFormattableDocument doc) {
		doc.prepend(regionFor(element).keyword("("), it -> it.autowrap());
		doc.append(regionFor(element).keyword("("), it -> it.noSpace());
		doc.prepend(regionFor(element).keyword(")"), it -> it.noSpace());
		doc.append(regionFor(element).keyword(")"), it -> it.autowrap());
	}

	private void formatCardinality(EObject element, IFormattableDocument doc) {
		regionFor(element).keywords("?", "*", "+").forEach(r -> doc.prepend(r, it -> it.noSpace()));
	}

}
