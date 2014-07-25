/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2.internal;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.formatting2.ITextSegment;
import org.eclipse.xtext.formatting2.regionaccess.IComment;
import org.eclipse.xtext.formatting2.regionaccess.IHiddenRegion;
import org.eclipse.xtext.formatting2.regionaccess.IHiddenRegionPart;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;
import org.eclipse.xtext.formatting2.regionaccess.IWhitespace;
import org.eclipse.xtext.grammaranalysis.impl.GrammarElementTitleSwitch;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class RegionToString {

	private Function<AbstractElement, String> grammarToString = new GrammarElementTitleSwitch().showRule()
			.showAssignments().showQualified();

	private boolean hightlightOrigin = false;

	private ITextSegment origin;

	public RegionToString hightlightOrigin() {
		this.hightlightOrigin = true;
		return this;
	}

	protected String quote(String string) {
		if (string == null)
			return "null";
		if (string.length() > 10)
			string = string.substring(0, 10) + "...";
		string = string.replace("\n", "\\n").replace("\r", "\\r");
		return "\"" + string + "\"";
	}

	@Override
	public String toString() {
		List<ITextSegment> list = toTokenAndGapList();
		int offsetDigits = String.valueOf(list.get(list.size() - 1).getOffset()).length();
		int lenghtDigits = 0;
		for (ITextSegment region : list) {
			int lenghtD = String.valueOf(region.getLength()).length();
			if (lenghtDigits < lenghtD)
				lenghtDigits = lenghtD;
		}
		List<String> result = Lists.newArrayListWithExpectedSize(list.size() + 1);
		result.add("Columns: 1:offset; 2:length; 3:token/gap; 4: text; 5..n:grammar elements or more whispace/comments");
		String format = "%0" + offsetDigits + "d %0" + lenghtDigits + "d %s";
		for (ITextSegment region : list)
			result.add(String.format(format, region.getOffset(), region.getLength(), toString(region)));
		return Joiner.on('\n').join(result);
	}

	protected String toString(EObject ele) {
		if (ele instanceof AbstractElement)
			return grammarToString.apply((AbstractElement) ele);
		if (ele instanceof AbstractRule)
			return ele.eClass().getName() + "'" + ((AbstractRule) ele).getName() + "'";
		return ele.toString();
	}

	protected String toString(AbstractRule rule) {
		return rule == null ? "null" : rule.getName();
	}

	protected String toString(IComment comment) {
		String text = quote(comment.getText());
		String gammar = toString(comment.getGrammarElement());
		return String.format("%s Comment:%s", text, gammar);
	}

	protected String toString(IHiddenRegion gap) {
		List<IHiddenRegionPart> whitespaceAndComments = gap.getParts();
		List<String> children = Lists.newArrayListWithExpectedSize(whitespaceAndComments.size());
		for (IHiddenRegionPart hidden : gap.getParts())
			children.add(toString(hidden));
		if (children.isEmpty())
			return "Gap";
		return "Gap   " + Joiner.on(", ").join(children);
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

	protected String toString(ISemanticRegion token) {
		return String.format("Token %s %s", quote(token.getText()), toString(token.getGrammarElement()));
	}

	protected String toString(IWhitespace whitespace) {
		String text = quote(whitespace.getText());
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
				if (current instanceof ISemanticRegion)
					current = ((ISemanticRegion) current).getPreviousHiddenRegion();
				else if (current instanceof IHiddenRegion)
					current = ((IHiddenRegion) current).getPreviousSemanticRegion();
				else if (current instanceof IHiddenRegionPart)
					current = ((IHiddenRegionPart) current).getHiddenRegion();
				else
					throw new IllegalStateException();
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
					throw new IllegalStateException();
			}
		}
		return result;
	}

	public RegionToString withOrigin(ITextSegment origin) {
		this.origin = origin;
		return this;
	}

}
