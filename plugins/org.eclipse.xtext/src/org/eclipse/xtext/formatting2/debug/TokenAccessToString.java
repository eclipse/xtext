/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2.debug;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.formatting2.ITextSegment;
import org.eclipse.xtext.formatting2.regionaccess.IComment;
import org.eclipse.xtext.formatting2.regionaccess.IHiddenRegion;
import org.eclipse.xtext.formatting2.regionaccess.IHiddenRegionPart;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;
import org.eclipse.xtext.formatting2.regionaccess.ISequentialRegion;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;
import org.eclipse.xtext.formatting2.regionaccess.IWhitespace;
import org.eclipse.xtext.grammaranalysis.impl.GrammarElementTitleSwitch;
import org.eclipse.xtext.util.EmfFormatter;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Strings;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class TokenAccessToString {

	private static final int TITLE_WIDTH = 9;
	private static final String SEMANTIC_PADDED = Strings.padEnd("Semantic", TITLE_WIDTH, ' ');
	private static final String HIDDEN = "Hidden";
	private static final String HIDDEN_PADDED = Strings.padEnd(HIDDEN, TITLE_WIDTH, ' ');
	private static final String EOBJECT_START_PADDED = Strings.padEnd("Start", TITLE_WIDTH, ' ');
	private static final String EOBJECT_END_PADDED = Strings.padEnd("End", TITLE_WIDTH, ' ');

	private Function<AbstractElement, String> grammarToString = new GrammarElementTitleSwitch().showRule()
			.showAssignments().showQualified();

	private boolean hideColumnExplanation = false;

	private boolean hightlightOrigin = false;

	private ITextSegment origin;

	public TokenAccessToString hideColumnExplanation() {
		this.hideColumnExplanation = true;
		return this;
	}

	public TokenAccessToString hightlightOrigin() {
		this.hightlightOrigin = true;
		return this;
	}

	public boolean isHideColumnExplanation() {
		return hideColumnExplanation;
	}

	public boolean isHightlightOrigin() {
		return hightlightOrigin;
	}

	protected String quote(String string, int maxLength) {
		if (string == null)
			return "null";
		if (string.length() > maxLength)
			string = string.substring(0, maxLength - 3) + "...";
		string = string.replace("\n", "\\n").replace("\r", "\\r");
		return "\"" + string + "\"";
	}

	protected void collectHiddenRegionsBySemanticObject(List<ITextSegment> regions,
			Multimap<IHiddenRegion, EObject> leadingHiddens, Multimap<IHiddenRegion, EObject> trailingHiddens,
			List<String> errors) {
		Set<EObject> sem = Sets.newHashSet();
		for (ITextSegment s : regions)
			if (s instanceof ISemanticRegion)
				sem.add(((ISemanticRegion) s).getSemanticElement());
		ISemanticRegion previous = ((ISequentialRegion) regions.get(0)).getPreviousSemanticRegion();
		if (previous != null)
			sem.add(previous.getSemanticElement());
		ISemanticRegion next = ((ISequentialRegion) regions.get(regions.size() - 1)).getNextSemanticRegion();
		if (next != null)
			sem.add(next.getSemanticElement());
		sem.remove(null);
		Set<EObject> containers = Sets.newHashSet();
		for (EObject s : sem) {
			EObject container = s.eContainer();
			while (container != null && containers.add(container))
				container = container.eContainer();
		}
		sem.addAll(containers);
		ITextRegionAccess access = regions.get(0).getTextRegionAccess();
		for (EObject s : sem) {
			IHiddenRegion leading = access.leadingHiddenRegion(s);
			if (leading == null)
				errors.add("ERROR: " + EmfFormatter.objPath(s) + " has no leading HiddenRegion.");
			else
				leadingHiddens.put(leading, s);
			IHiddenRegion trailing = access.trailingHiddenRegion(s);
			if (trailing == null)
				errors.add("ERROR: " + EmfFormatter.objPath(s) + " has no trailing HiddenRegion.");
			else
				trailingHiddens.put(trailing, s);
		}
	}

	protected String toString(Collection<EObject> objs) {
		List<String> result = Lists.newArrayList();
		for (EObject obj : objs) {
			StringBuilder builder = new StringBuilder();
			EStructuralFeature containingFeature = obj.eContainingFeature();
			if (containingFeature != null) {
				builder.append(containingFeature.getName());
				if (containingFeature.isMany()) {
					int index = ((List<?>) obj.eContainer().eGet(containingFeature)).indexOf(obj);
					builder.append("[" + index + "]");
				}
				builder.append("=");
			}
			builder.append(obj.eClass().getName());
			EStructuralFeature nameFeature = obj.eClass().getEStructuralFeature("name");
			if (nameFeature != null) {
				Object name = obj.eGet(nameFeature);
				if (name != null)
					builder.append("'" + name + "'");
			}
			result.add(builder.toString());
		}
		Collections.sort(result);
		return Joiner.on(", ").join(result);
	}

	@Override
	public String toString() {
		List<ITextSegment> list = toTokenAndGapList();
		Multimap<IHiddenRegion, EObject> leadingHiddens = LinkedHashMultimap.create();
		Multimap<IHiddenRegion, EObject> trailingHiddens = LinkedHashMultimap.create();
		List<String> errors = Lists.newArrayList();
		collectHiddenRegionsBySemanticObject(list, leadingHiddens, trailingHiddens, errors);
		TextRegionListToString result = new TextRegionListToString();
		if (!hideColumnExplanation) {
			String explanation = "Columns: 1:offset; 2:length; 3:hidden/semantic; 4: text; 5..n:grammar elements or whispace/comments";
			result.add(explanation, false);
		}
		for (String error : errors)
			result.add(error, false);
		for (ITextSegment region : list) {
			if (region instanceof IHiddenRegion) {
				Collection<EObject> collection = trailingHiddens.get((IHiddenRegion) region);
				if (!collection.isEmpty())
					result.add(EOBJECT_END_PADDED + toString(collection));
			}
			result.add(region, toString(region));
			if (region instanceof IHiddenRegion) {
				Collection<EObject> collection = leadingHiddens.get((IHiddenRegion) region);
				if (!collection.isEmpty())
					result.add(EOBJECT_START_PADDED + toString(collection));
			}
		}
		return result.toString();
	}

	protected String toString(AbstractRule rule) {
		return rule == null ? "null" : rule.getName();
	}

	protected String toString(EObject ele) {
		if (ele instanceof AbstractElement)
			return grammarToString.apply((AbstractElement) ele);
		if (ele instanceof AbstractRule)
			return ele.eClass().getName() + "'" + ((AbstractRule) ele).getName() + "'";
		return ele.toString();
	}

	protected String toString(IComment comment) {
		String text = quote(comment.getText(), 10);
		String gammar = toString(comment.getGrammarElement());
		return String.format("%s Comment:%s", text, gammar);
	}

	protected String toString(IHiddenRegion gap) {
		List<IHiddenRegionPart> whitespaceAndComments = gap.getParts();
		List<String> children = Lists.newArrayListWithExpectedSize(whitespaceAndComments.size());
		for (IHiddenRegionPart hidden : gap.getParts())
			children.add(toString(hidden));
		if (children.isEmpty())
			return HIDDEN;
		return HIDDEN_PADDED + Joiner.on(", ").join(children);
	}

	protected String toString(ISemanticRegion token) {
		String text = quote(token.getText(), 10);
		return String.format("%s%s %s", SEMANTIC_PADDED, text, toString(token.getGrammarElement()));
	}

	protected String toString(ITextSegment region) {
		String result;
		if (region instanceof ISemanticRegion)
			result = toString((ISemanticRegion) region);
		else if (region instanceof IHiddenRegion)
			result = toString((IHiddenRegion) region);
		else if (region instanceof IWhitespace)
			result = toString((IWhitespace) region);
		else if (region instanceof IComment)
			result = toString((IComment) region);
		else if (region != null)
			result = region.getClass().getName() + "@" + Integer.toHexString(System.identityHashCode(region));
		else
			result = "null";
		if (hightlightOrigin && region == origin)
			return ">>>" + result + "<<<";
		return result;
	}

	protected String toString(IWhitespace whitespace) {
		String text = quote(whitespace.getText(), 10);
		String grammar = toString(whitespace.getGrammarElement());
		return String.format("%s Whitespace:%s", text, grammar);
	}

	protected List<ITextSegment> toTokenAndGapList() {
		final int range = this.hightlightOrigin ? 4 : (Integer.MAX_VALUE / 2);
		ITextSegment first = null;
		{
			ITextSegment current = origin;
			for (int i = 0; i < range && current != null; i++) {
				first = current;
				if (current instanceof ITextRegionAccess)
					current = ((ITextRegionAccess) current).getFirstRegionInFile();
				else if (current instanceof ISemanticRegion)
					current = ((ISemanticRegion) current).getPreviousHiddenRegion();
				else if (current instanceof IHiddenRegion)
					current = ((IHiddenRegion) current).getPreviousSemanticRegion();
				else if (current instanceof IHiddenRegionPart)
					current = ((IHiddenRegionPart) current).getHiddenRegion();
				else
					throw new IllegalStateException("Unexpected Type: " + current.getClass());
			}
		}
		if (first == null)
			return Collections.emptyList();
		List<ITextSegment> result = Lists.newArrayList();
		{
			ITextSegment current = first;
			for (int i = 0; i <= (range * 2) && current != null; i++) {
				result.add(current);
				if (current instanceof ISemanticRegion)
					current = ((ISemanticRegion) current).getNextHiddenRegion();
				else if (current instanceof IHiddenRegion)
					current = ((IHiddenRegion) current).getNextSemanticRegion();
				else
					throw new IllegalStateException("Unexpected Type: " + current.getClass());
			}
		}
		return result;
	}

	public TokenAccessToString withOrigin(ITextSegment origin) {
		this.origin = origin;
		return this;
	}

}
