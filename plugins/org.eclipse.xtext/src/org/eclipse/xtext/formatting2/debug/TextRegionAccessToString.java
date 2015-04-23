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
import java.util.Comparator;
import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.formatting2.regionaccess.IAstRegion;
import org.eclipse.xtext.formatting2.regionaccess.IComment;
import org.eclipse.xtext.formatting2.regionaccess.IEObjectRegion;
import org.eclipse.xtext.formatting2.regionaccess.IHiddenRegion;
import org.eclipse.xtext.formatting2.regionaccess.IHiddenRegionPart;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;
import org.eclipse.xtext.formatting2.regionaccess.ISequentialRegion;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;
import org.eclipse.xtext.formatting2.regionaccess.ITextSegment;
import org.eclipse.xtext.formatting2.regionaccess.IWhitespace;
import org.eclipse.xtext.grammaranalysis.impl.GrammarElementTitleSwitch;
import org.eclipse.xtext.util.EmfFormatter;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Strings;
import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class TextRegionAccessToString {

	protected static enum AstRegionComparator implements Comparator<IAstRegion> {
		CHILDREN_FIRST {
			@Override
			public int compare(IAstRegion o1, IAstRegion o2) {
				EObject e1 = o1.getSemanticElement();
				EObject e2 = o2.getSemanticElement();
				if (e1 == e2)
					return 0;
				if (EcoreUtil.isAncestor(e1, e2))
					return 1;
				return -1;
			}
		},
		CONTAINER_FIRST {
			@Override
			public int compare(IAstRegion o1, IAstRegion o2) {
				EObject e1 = o1.getSemanticElement();
				EObject e2 = o2.getSemanticElement();
				if (e1 == e2)
					return 0;
				if (EcoreUtil.isAncestor(e1, e2))
					return -1;
				return 1;
			}
		};
	}

	private static final int TITLE_WIDTH = 9;
	private static final String EOBJECT_END_PADDED = Strings.padEnd("End", TITLE_WIDTH, ' ');
	private static final String EOBJECT_START_PADDED = Strings.padEnd("Start", TITLE_WIDTH, ' ');
	private static final String HIDDEN = "Hidden";
	private static final String HIDDEN_PADDED = Strings.padEnd(HIDDEN, TITLE_WIDTH, ' ');
	private static final String SEMANTIC_PADDED = Strings.padEnd("Semantic", TITLE_WIDTH, ' ');

	private Function<AbstractElement, String> grammarToString = new GrammarElementTitleSwitch().showRule()
			.showAssignments().showQualified();

	private boolean hideColumnExplanation = false;

	private boolean hightlightOrigin = false;

	private ITextSegment origin;

	public TextRegionAccessToString hideColumnExplanation() {
		this.hideColumnExplanation = true;
		return this;
	}

	public TextRegionAccessToString hightlightOrigin() {
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

	@Override
	public String toString() {
		List<ITextSegment> list = toTokenAndGapList();
		if (list.isEmpty())
			return "(empty)";
		Multimap<IHiddenRegion, IEObjectRegion> hiddens = LinkedListMultimap.create();
		List<String> errors = Lists.newArrayList();
		ITextRegionAccess access = list.get(0).getTextRegionAccess();
		TreeIterator<EObject> all = EcoreUtil2.eAll(access.regionForRootEObject().getSemanticElement());
		while (all.hasNext()) {
			EObject element = all.next();
			IEObjectRegion obj = access.regionForEObject(element);
			if (obj == null)
				continue;
			IHiddenRegion previous = obj.getPreviousHiddenRegion();
			IHiddenRegion next = obj.getNextHiddenRegion();
			if (previous == null)
				errors.add("ERROR: " + EmfFormatter.objPath(element) + " has no leading HiddenRegion.");
			else
				hiddens.put(previous, obj);
			if (previous != next) {
				if (next == null)
					errors.add("ERROR: " + EmfFormatter.objPath(element) + " has no trailing HiddenRegion.");
				else
					hiddens.put(next, obj);
			}
		}
		TextRegionListToString result = new TextRegionListToString();
		if (!hideColumnExplanation) {
			String explanation = "Columns: 1:offset; 2:length; 3:hidden/semantic; 4: text; 5..n:grammar elements or whispace/comments";
			result.add(explanation, false);
		}
		for (String error : errors)
			result.add(error, false);
		for (ITextSegment region : list) {
			List<IEObjectRegion> previous = Lists.newArrayList();
			List<IEObjectRegion> next = Lists.newArrayList();
			List<String> middle = Lists.newArrayList(toString(region));
			if (region instanceof IHiddenRegion) {
				Collection<IEObjectRegion> found = hiddens.get((IHiddenRegion) region);
				for (IEObjectRegion obj : found) {
					boolean p = obj.getNextHiddenRegion().equals(region);
					boolean n = obj.getPreviousHiddenRegion().equals(region);
					if (p && n)
						middle.add("Semantic " + toString(obj));
					else if (p)
						previous.add(obj);
					else if (n)
						next.add(obj);
				}
				Collections.sort(previous, AstRegionComparator.CHILDREN_FIRST);
				Collections.sort(next, AstRegionComparator.CONTAINER_FIRST);
			}
			for (IEObjectRegion obj : previous)
				result.add(EOBJECT_END_PADDED + toString(obj));

			result.add(region, Joiner.on(", ").join(middle));
			for (IEObjectRegion obj : next)
				result.add(EOBJECT_START_PADDED + toString(obj));
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

	protected String toString(IEObjectRegion region) {
		EObject obj = region.getSemanticElement();
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
		EObject element = region.getGrammarElement();
		if (element instanceof AbstractElement)
			builder.append(" via " + grammarToString.apply((AbstractElement) element));
		else if (element instanceof AbstractRule)
			builder.append(" via " + ((AbstractRule) element).getName());
		else
			builder.append(": ERROR: EObject has no grammar element.");
		return builder.toString();
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
		if (region instanceof IEObjectRegion)
			result = toString((IEObjectRegion) region);
		else if (region instanceof ISemanticRegion)
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
					current = ((ITextRegionAccess) current).regionForRootEObject().getPreviousHiddenRegion();
				else if (current instanceof ISequentialRegion)
					current = ((ISequentialRegion) current).getPreviousHiddenRegion();
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

	public TextRegionAccessToString withOrigin(ITextSegment origin) {
		this.origin = origin;
		return this;
	}

	public TextRegionAccessToString withRegionAccess(ITextRegionAccess access) {
		this.origin = access.regionForRootEObject();
		this.hightlightOrigin = false;
		return this;
	}

}
