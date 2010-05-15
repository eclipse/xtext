/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting.impl;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.formatting.IElementMatcherProvider.IAfterElement;
import org.eclipse.xtext.formatting.IElementMatcherProvider.IBeforeElement;
import org.eclipse.xtext.formatting.IElementMatcherProvider.IBetweenElements;
import org.eclipse.xtext.parsetree.reconstr.IHiddenTokenHelper;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;

import com.google.common.collect.Lists;
import com.google.inject.internal.Maps;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public abstract class AbstractFormattingConfig {

	public class ElementLocator implements IAfterElement, IBeforeElement, IBetweenElements {
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

		public AbstractElement getAbstractElement(EObject obj) {
			if (obj instanceof AbstractElement)
				return (AbstractElement) obj;
			if (obj instanceof AbstractRule)
				return ((AbstractRule) obj).getAlternatives();
			return null;
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

		public AbstractElement matchAfter() {
			if (type == LocatorType.BETWEEN)
				return null;
			return getAbstractElement(after);
		}

		public AbstractElement matchBefore() {
			if (type == LocatorType.BETWEEN)
				return null;
			return getAbstractElement(before);
		}

		public Pair<AbstractElement, AbstractElement> matchBetween() {
			if (type == LocatorType.BETWEEN)
				return Tuples.create(getAbstractElement(after), getAbstractElement(before));
			return null;
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

	public interface IAfterLocator {
		void after(EObject after);
	}

	public interface IAroundLocator {
		void around(EObject ele);
	}

	public interface IBeforeLocator {
		void before(EObject right);
	}

	public interface IBetweenLocator {
		void between(EObject left, EObject right);
	}

	public interface IBoundsLocator {
		void bounds(EObject left, EObject right);
	}

	public interface IRangeLocator {
		void range(EObject left, EObject right);
	}

	public enum LocatorType {
		AFTER, //
		AROUND, // before + after
		BEFORE, //
		BETWEEN, // matches, if two elements follow each other
		BOUNDS, // after(left) + before(right)
		RANGE, // matches always between left and right
	}

	protected IHiddenTokenHelper hiddenTokenHelper;

	protected Map<EObject, List<ElementLocator>> locatorsCommentAfter = Maps.newHashMap();

	protected Map<EObject, List<ElementLocator>> locatorsCommentBefore = Maps.newHashMap();

	protected List<ElementLocator> locatorsSemantic = Lists.newArrayList();

	public AbstractFormattingConfig(IHiddenTokenHelper hiddenTokenHelper) {
		super();
		this.hiddenTokenHelper = hiddenTokenHelper;
	}

	protected void addLocator(ElementLocator locator) {
		if ((locator.before instanceof AbstractRule && hiddenTokenHelper.isComment((AbstractRule) locator.before))
				|| (locator.after instanceof AbstractRule && hiddenTokenHelper.isComment((AbstractRule) locator.after))) {
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
		} else
			locatorsSemantic.add(locator);

	}

	public List<ElementLocator> getLocatorsForCommentTokensAfter(EObject ctx) {
		List<ElementLocator> result = locatorsCommentAfter.get(ctx);
		return result != null ? result : Collections.<ElementLocator> emptyList();
	}

	public List<ElementLocator> getLocatorsForCommentTokensBefore(EObject ctx) {
		List<ElementLocator> result = locatorsCommentBefore.get(ctx);
		return result != null ? result : Collections.<ElementLocator> emptyList();
	}

	public List<ElementLocator> getLocatorsForSemanticTokens() {
		return locatorsSemantic;
	}
}
