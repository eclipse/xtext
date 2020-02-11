/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.formatting.impl;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.formatting.IElementMatcherProvider.IAfterElement;
import org.eclipse.xtext.formatting.IElementMatcherProvider.IBeforeElement;
import org.eclipse.xtext.formatting.IElementMatcherProvider.IBetweenElements;
import org.eclipse.xtext.formatting.IElementMatcherProvider.IElementPattern;
import org.eclipse.xtext.parsetree.reconstr.IHiddenTokenHelper;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public abstract class AbstractFormattingConfig {

	public static class ElementBeforeAfterPattern extends ElementPattern implements IAfterElement, IBeforeElement {
		public ElementBeforeAfterPattern(ElementLocator locator, AbstractElement before, AbstractElement after) {
			super(locator, before, after);
		}

		@Override
		public AbstractElement matchAfter() {
			return after;
		}

		@Override
		public AbstractElement matchBefore() {
			return before;
		}
	}

	public static class ElementBetweenPattern extends ElementPattern implements IBetweenElements {
		public ElementBetweenPattern(ElementLocator locator, AbstractElement before, AbstractElement after) {
			super(locator, before, after);
		}

		@Override
		public Pair<AbstractElement, AbstractElement> matchBetween() {
			return Tuples.create(after, before);
		}
	}

	public class ElementLocator {
		protected EObject after;
		protected EObject before;
		protected LocatorType type;

		public void after(EObject after) {
			this.type = LocatorType.AFTER;
			this.after = after;
			this.before = null;
			addLocator(this);
		}

		public void around(EObject ele) {
			this.type = LocatorType.AROUND;
			this.after = ele;
			this.before = ele;
			addLocator(this);
		}

		public void before(EObject right) {
			this.type = LocatorType.BEFORE;
			this.before = right;
			this.after = null;
			addLocator(this);
		}

		public void between(EObject left, EObject right) {
			this.type = LocatorType.BETWEEN;
			this.after = left;
			this.before = right;
			addLocator(this);
		}

		public void bounds(EObject left, EObject right) {
			this.type = LocatorType.BOUNDS;
			this.after = left;
			this.before = right;
			addLocator(this);
		}

		public EObject getLeft() {
			return after;
		}

		public EObject getRight() {
			return before;
		}

		public LocatorType getType() {
			return type;
		}

		public void range(EObject left, EObject right) {
			type = LocatorType.RANGE;
			this.after = left;
			this.before = right;
			addLocator(this);
		}

		@Override
		public String toString() {
			return getClass().getSimpleName() + "-" + type.name();
		}
	}

	public static class ElementPattern implements IElementPattern {
		protected AbstractElement after;
		protected AbstractElement before;
		protected ElementLocator locator;

		public ElementPattern(ElementLocator locator, AbstractElement before, AbstractElement after) {
			super();
			this.locator = locator;
			this.before = before;
			this.after = after;
		}

		public ElementLocator getLocator() {
			return locator;
		}

		@Override
		public String toString() {
			return locator.toString();
		}
	}

	public enum LocatorType {
		AFTER, //
		AROUND, // before + after
		BEFORE, //
		BETWEEN, // matches, if two elements follow each other
		BOUNDS, // after(left) + before(right)
		RANGE, // matches always between left and right
	}

	protected IGrammarAccess grammarAccess;

	protected IHiddenTokenHelper hiddenTokenHelper;

	protected Map<EObject, List<ElementLocator>> locatorsCommentAfter = Maps.newHashMap();

	protected Map<EObject, List<ElementLocator>> locatorsCommentBefore = Maps.newHashMap();

	protected List<ElementPattern> locatorsSemantic = Lists.newArrayList();

	public AbstractFormattingConfig(IGrammarAccess grammarAccess, IHiddenTokenHelper hiddenTokenHelper) {
		super();
		this.grammarAccess = grammarAccess;
		this.hiddenTokenHelper = hiddenTokenHelper;
	}

	protected void addLocator(ElementLocator locator) {
		if ((locator.before instanceof AbstractRule && hiddenTokenHelper.isComment((AbstractRule) locator.before))
				|| (locator.after instanceof AbstractRule && hiddenTokenHelper.isComment((AbstractRule) locator.after)))
			addLocatorComment(locator);
		else
			addLocatorSemantic(locator);

	}

	protected void addLocatorComment(ElementLocator locator) {
		if (locator.before != null) {
			List<ElementLocator> loc = locatorsCommentBefore.get(locator.before);
			if (loc == null)
				locatorsCommentBefore.put(locator.before, loc = Lists.newArrayList());
			loc.add(locator);
		}
		if (locator.after != null) {
			List<ElementLocator> loc = locatorsCommentAfter.get(locator.after);
			if (loc == null)
				locatorsCommentAfter.put(locator.after, loc = Lists.newArrayList());
			loc.add(locator);
		}
	}

	protected void addLocatorSemantic(ElementLocator locator) {
		List<AbstractElement> before = getAbstractElements(locator.before);
		List<AbstractElement> after = getAbstractElements(locator.after);
		if (before != null && after != null)
			for (AbstractElement b : before)
				for (AbstractElement a : after)
					addLocatorSemantic(locator, b, a);
		else if (before != null)
			for (AbstractElement b : before)
				addLocatorSemantic(locator, b, null);
		else if (after != null)
			for (AbstractElement a : after)
				addLocatorSemantic(locator, null, a);
	}

	protected void addLocatorSemantic(ElementLocator locator, AbstractElement before, AbstractElement after) {
		if (locator.type == LocatorType.BETWEEN)
			locatorsSemantic.add(new ElementBetweenPattern(locator, before, after));
		else
			locatorsSemantic.add(new ElementBeforeAfterPattern(locator, before, after));
	}

	protected List<AbstractElement> getAbstractElements(EObject obj) {
		if (obj instanceof AbstractElement)
			return Collections.singletonList((AbstractElement) obj);
		if (obj instanceof AbstractRule) {
			AbstractRule rule = (AbstractRule) obj;
			if (rule.getType().getClassifier() instanceof EClass)
				return Collections.singletonList(rule.getAlternatives());
			List<AbstractElement> result = Lists.newArrayList();
			for (RuleCall rc : grammarAccess.findRuleCalls(rule)) {
				CrossReference cr = GrammarUtil.containingCrossReference(rc);
				result.add(cr == null ? rc : cr);
			}
			return result;
		}
		return null;
	}

	public List<ElementLocator> getLocatorsForCommentTokensAfter(EObject ctx) {
		List<ElementLocator> result = locatorsCommentAfter.get(ctx);
		return result != null ? result : Collections.<ElementLocator> emptyList();
	}

	public List<ElementLocator> getLocatorsForCommentTokensBefore(EObject ctx) {
		List<ElementLocator> result = locatorsCommentBefore.get(ctx);
		return result != null ? result : Collections.<ElementLocator> emptyList();
	}

	public List<ElementPattern> getLocatorsForSemanticTokens() {
		return locatorsSemantic;
	}
}
