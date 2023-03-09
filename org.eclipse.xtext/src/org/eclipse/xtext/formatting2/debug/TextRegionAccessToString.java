/*******************************************************************************
 * Copyright (c) 2014, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.formatting2.debug;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

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
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccessDiff;
import org.eclipse.xtext.formatting2.regionaccess.ITextSegment;
import org.eclipse.xtext.formatting2.regionaccess.ITextSegmentDiff;
import org.eclipse.xtext.formatting2.regionaccess.IWhitespace;
import org.eclipse.xtext.grammaranalysis.impl.GrammarElementTitleSwitch;
import org.eclipse.xtext.util.EmfFormatter;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Strings;
import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
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

	protected static class DiffColumn {
		private ITextRegionAccessDiff access;
		private Map<ITextSegment, String> diffs;
		private String empty;

		protected ISequentialRegion toSequential(ITextSegment seg) {
			if (seg instanceof ISequentialRegion) {
				return (ISequentialRegion) seg;
			}
			if (seg instanceof IHiddenRegionPart) {
				return ((IHiddenRegionPart) seg).getHiddenRegion();
			}
			throw new IllegalStateException();
		}

		public DiffColumn(ITextRegionAccess access) {
			if (access instanceof ITextRegionAccessDiff) {
				this.diffs = Maps.newHashMap();
				this.access = (ITextRegionAccessDiff) access;
				int width = 0;
				int i = 1;
				for (ITextSegmentDiff diff : this.access.getRegionDifferences()) {
					ISequentialRegion current = toSequential(diff.getModifiedFirstRegion());
					ISequentialRegion last = toSequential(diff.getModifiedLastRegion());
					String text = i + " ";
					if (width < text.length()) {
						width = text.length();
					}
					while (current != null) {
						diffs.put(current, text);
						if (current.getOffset() >= last.getOffset()) {
							break;
						}
						current = current.getNextSequentialRegion();
					}
					i++;
				}
				this.empty = Strings.repeat(" ", width);
			} else {
				this.access = null;
				this.empty = "";
			}
		}

		public void appendDiffs(TextRegionListToString result, TextRegionAccessToString toStr) {
			if (this.access == null) {
				return;
			}
			int i = 1;
			for (ITextSegmentDiff diff : this.access.getRegionDifferences()) {
				ISequentialRegion current = toSequential(diff.getOriginalFirstRegion());
				ISequentialRegion last = toSequential(diff.getOriginalLastRegion());
				List<ITextSegment> regions = new ArrayList<>();
				while (current != null) {
					regions.add(current);
					if (current.getOffset() >= last.getOffset()) {
						break;
					}
					current = current.getNextSequentialRegion();
				}
				result.add("------------ diff " + i + " ------------", false);
				toStr.appendRegions(result, regions, new DiffColumn(null), true);
				i++;
			}

		}

		public String get(ITextSegment seg) {
			if (this.access == null) {
				return "";
			}
			String result = this.diffs.get(seg);
			if (result != null)
				return result;
			return empty;
		}

		public boolean isDiff() {
			return this.access != null;
		}

	}

	private static final int TITLE_WIDTH = 2;
	private static final String EMPTY_TITLE = Strings.repeat(" ", TITLE_WIDTH);
	private static final String EOBJECT_BEGIN_PADDED = Strings.padEnd("B", TITLE_WIDTH, ' ');
	private static final String EOBJECT_END_PADDED = Strings.padEnd("E", TITLE_WIDTH, ' ');
	private static final String HIDDEN = "H";
	private static final String HIDDEN_PADDED = Strings.padEnd(HIDDEN, TITLE_WIDTH, ' ');
	private static final String SEMANTIC_PADDED = Strings.padEnd("S", TITLE_WIDTH, ' ');

	private Function<AbstractElement, String> grammarToString = new GrammarElementTitleSwitch().showRule()
			.showAssignments().showQualified();

	private boolean hideColumnExplanation = false;

	private boolean hideIndentation = false;

	private boolean highlightOrigin = false;

	private ITextSegment origin;

	private int textWidth = 20;

	protected void appendRegions(TextRegionListToString result, List<ITextSegment> list, DiffColumn diff,
			boolean isDiffAppendix) {
		Multimap<IHiddenRegion, IEObjectRegion> hiddens = LinkedListMultimap.create();
		List<String> errors = new ArrayList<>();
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
		for (String error : errors)
			result.add(error, false);
		int indentation = 0, min = 0;
		for (ITextSegment region : list) {
			if (region instanceof IHiddenRegion) {
				Collection<IEObjectRegion> found = hiddens.get((IHiddenRegion) region);
				for (IEObjectRegion obj : found) {
					boolean p = region.equals(obj.getNextHiddenRegion());
					boolean n = region.equals(obj.getPreviousHiddenRegion());
					if (p)
						indentation--;
					else if (n)
						indentation++;
					if (indentation < min)
						min = indentation;
				}
			}
		}
		indentation = min < 0 ? min * -1 : 0;
		for (ITextSegment region : list) {
			List<IEObjectRegion> previous = new ArrayList<>();
			List<IEObjectRegion> next = new ArrayList<>();
			List<String> middle = Lists.newArrayList(toString(region));
			if (region instanceof IHiddenRegion) {
				Collection<IEObjectRegion> found = hiddens.get((IHiddenRegion) region);
				for (IEObjectRegion obj : found) {
					boolean p = region.equals(obj.getNextHiddenRegion());
					boolean n = region.equals(obj.getPreviousHiddenRegion());
					if (p && n)
						middle.add(EMPTY_TITLE + "Semantic " + toString(obj));
					else if (p)
						previous.add(obj);
					else if (n)
						next.add(obj);
				}
				Collections.sort(previous, AstRegionComparator.CHILDREN_FIRST);
				Collections.sort(next, AstRegionComparator.CONTAINER_FIRST);
			}
			if (!isDiffAppendix) {
				for (IEObjectRegion obj : previous) {
					indentation--;
					result.add(diff.empty + indent(indentation) + EOBJECT_END_PADDED + toString(obj));
				}
			}
			String indent = indent(indentation);
			result.add(region, diff.get(region) + indent + Joiner.on("\n").join(middle).replace("\n", "\n" + indent));
			if (!isDiffAppendix) {
				for (IEObjectRegion obj : next) {
					result.add(diff.empty + indent(indentation) + EOBJECT_BEGIN_PADDED + toString(obj));
					indentation++;
				}
			}
		}
	}

	public int getTextWidth() {
		return textWidth;
	}

	public TextRegionAccessToString hideColumnExplanation() {
		this.hideColumnExplanation = true;
		return this;
	}

	public TextRegionAccessToString hideIndentation() {
		this.hideIndentation = true;
		return this;
	}

	/**
	 * @since 2.26
	 */
	public TextRegionAccessToString highlightOrigin() {
		this.highlightOrigin = true;
		return this;
	}

	protected String indent(int indentation) {
		if (hideIndentation)
			return "";
		return Strings.repeat(" ", indentation);
	}

	public boolean isHideColumnExplanation() {
		return hideColumnExplanation;
	}

	public boolean isHideIndentation() {
		return hideIndentation;
	}

	/**
	 * @since 2.26
	 */
	public boolean isHighlightOrigin() {
		return highlightOrigin;
	}

	protected String quote(String string) {
		if (string == null)
			return "null";
		string = string.replace("\n", "\\n").replace("\r", "\\r").replace("\t", "\\t");
		int textLen = textWidth - 2;
		if (string.length() > textLen)
			return "\"" + string.substring(0, textLen - 3) + "...\"";
		else
			return Strings.padEnd("\"" + string + "\"", textWidth, ' ');
	}

	protected String toClassWithName(EObject obj) {
		String className = obj.eClass().getName();
		EStructuralFeature nameFeature = obj.eClass().getEStructuralFeature("name");
		if (nameFeature != null) {
			Object name = obj.eGet(nameFeature);
			if (name != null)
				return className + "'" + name + "'";
		}
		return className;
	}

	@Override
	public String toString() {
		List<ITextSegment> list = toTokenAndGapList();
		if (list.isEmpty())
			return "(empty)";
		ITextRegionAccess access = list.get(0).getTextRegionAccess();
		DiffColumn diff = new DiffColumn(access);
		TextRegionListToString result = new TextRegionListToString();
		if (!hideColumnExplanation) {
			if (diff.isDiff()) {
				result.add("Columns: 1:offset 2:length 3:diff 4:kind 5: text 6:grammarElement", false);
			} else {
				result.add("Columns: 1:offset 2:length 3:kind 4: text 5:grammarElement", false);
			}
			result.add("Kind: H=IHiddenRegion S=ISemanticRegion B/E=IEObjectRegion", false);
			result.add("", false);
		}
		appendRegions(result, list, diff, false);
		diff.appendDiffs(result, this);
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
		if (ele == null) {
			return "(null)";
		}
		return ele.toString();
	}

	protected String toString(IComment comment) {
		String text = quote(comment.getText());
		String grammar = toString(comment.getGrammarElement());
		String association = comment.getAssociation() + "";
		return String.format("%s Comment:%s Association:%s", text, grammar, association);
	}

	protected String toString(IEObjectRegion region) {
		EObject obj = region.getSemanticElement();
		StringBuilder builder = new StringBuilder(Strings.padEnd(toClassWithName(obj), textWidth, ' ') + " ");
		EObject element = region.getGrammarElement();
		if (element instanceof AbstractElement)
			builder.append(grammarToString.apply((AbstractElement) element));
		else if (element instanceof AbstractRule)
			builder.append(((AbstractRule) element).getName());
		else
			builder.append(": ERROR: No grammar element.");
		List<String> segments = new ArrayList<>();
		EObject current = obj;
		while (current.eContainer() != null) {
			EObject container = current.eContainer();
			EStructuralFeature containingFeature = current.eContainingFeature();
			StringBuilder segment = new StringBuilder();
			segment.append(toClassWithName(container));
			segment.append("/");
			segment.append(containingFeature.getName());
			if (containingFeature.isMany()) {
				int index = ((List<?>) container.eGet(containingFeature)).indexOf(current);
				segment.append("[" + index + "]");
			}
			current = container;
			segments.add(segment.toString());
		}
		if (!segments.isEmpty()) {
			builder.append(" path:");
			builder.append(Joiner.on("=").join(segments));
		}
		return builder.toString();
	}

	protected String toString(IHiddenRegion hiddens) {
		List<IHiddenRegionPart> parts = hiddens.getParts();
		if (parts.isEmpty())
			return HIDDEN;
		List<String> children = Lists.newArrayListWithExpectedSize(parts.size());
		children.add(HIDDEN_PADDED + toString(parts.get(0)));
		for (int i = 1; i < parts.size(); i++)
			children.add(EMPTY_TITLE + toString(parts.get(i)));
		return Joiner.on("\n").join(children);
	}

	protected String toString(ISemanticRegion token) {
		String text = quote(token.getText());
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
		if (highlightOrigin && region == origin)
			return ">>>" + result + "<<<";
		return result;
	}

	protected String toString(IWhitespace whitespace) {
		String text = quote(whitespace.getText());
		String grammar = toString(whitespace.getGrammarElement());
		return String.format("%s Whitespace:%s", text, grammar);
	}

	protected List<ITextSegment> toTokenAndGapList() {
		int range = this.highlightOrigin ? 4 : (Integer.MAX_VALUE / 2);
		ITextSegment first = null;
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
		
		if (first == null)
			return Collections.emptyList();
		
		List<ITextSegment> result = new ArrayList<>();
		ITextSegment currentRegion = first;
		for (int i = 0; i <= (range * 2) && currentRegion != null; i++) {
			result.add(currentRegion);
			if (currentRegion instanceof ISemanticRegion)
				currentRegion = ((ISemanticRegion) currentRegion).getNextHiddenRegion();
			else if (currentRegion instanceof IHiddenRegion)
				currentRegion = ((IHiddenRegion) currentRegion).getNextSemanticRegion();
			else
				throw new IllegalStateException("Unexpected Type: " + currentRegion.getClass());
		}
		return result;
	}

	public TextRegionAccessToString withOrigin(ITextSegment origin) {
		this.origin = origin;
		return this;
	}

	public TextRegionAccessToString withRegionAccess(ITextRegionAccess access) {
		this.origin = access.regionForRootEObject();
		this.highlightOrigin = false;
		return this;
	}

	public TextRegionAccessToString withTextWidth(int width) {
		this.textWidth = width;
		return this;
	}

}
