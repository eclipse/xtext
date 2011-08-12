/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.junit4.parameterized;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Collection;
import java.util.List;
import java.util.regex.Pattern;

import org.eclipse.xtext.junit4.parameterized.AbstractIterableExpectationValidator.ToString;
import org.eclipse.xtext.junit4.parameterized.TestAsCommaSeparatedValues.CSVResultValidator;
import org.eclipse.xtext.junit4.parameterized.TestExpectationValidator.TestResult;
import org.junit.ComparisonFailure;

import com.google.common.base.Function;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@TestExpectationValidator(validator = CSVResultValidator.class)
public @interface TestAsCommaSeparatedValues {

	public class CSVResultValidator extends AbstractIterableExpectationValidator {
		protected class ItemWithPred extends Item {
			public ItemWithPred(String normalized, String escaped) {
				super(normalized, escaped);
			}

			protected Item predecessor;
			protected boolean suppressWrapBefore = false;
			protected boolean wrapBefore = false;

			public int charsInLine() {
				if (wrapBefore || predecessor == null)
					return escaped.length();
				return charsInLine() + 2 + escaped.length();
			}

			@Override
			public boolean equals(Object obj) {
				return normalized.equals(obj);
			}

			@Override
			public int hashCode() {
				return normalized.hashCode();
			}

			public int itemsInLine() {
				if (wrapBefore || predecessor == null)
					return 1;
				return itemsInLine() + 1;
			}
		}

		protected static final Pattern WS = Pattern.compile("\\s+", Pattern.MULTILINE);

		protected TestAsCommaSeparatedValues cfg;

		public CSVResultValidator(TestAsCommaSeparatedValues cfg) {
			super(cfg.caseSensitive(), cfg.whitespaceSensitive());
			this.cfg = cfg;
		}

		@Override
		protected Item createItem(String normalized, String escaped) {
			return new ItemWithPred(normalized, escaped);
		}

		@Override
		protected String escapeUnquoted(String str) {
			return super.escapeUnquoted(str).replaceAll(",", "\\,");
		}

		protected String format(List<Item> items) {
			StringBuilder result = new StringBuilder();
			for (Item i : items) {
				if (result.length() > 0) {
					if (((ItemWithPred) i).wrapBefore)
						result.append(",\n");
					else
						result.append(", ");
				}
				result.append(i.escaped);
			}
			return result.toString();
		}

		protected void suppressWrap(List<Item> wrapped, List<Item> items) {
			int next = 0;
			for (Item w : wrapped) {
				int found = -1;
				for (int i = next; i < items.size(); i++)
					if (items.get(i).equals(w)) {
						found = i;
						break;
					}
				if (!((ItemWithPred) w).wrapBefore)
					for (int i = next; i <= found; i++)
						((ItemWithPred) items.get(i)).suppressWrapBefore = true;
				next = found + 1;
			}
		}

		public void validate(String expectation, @TestResult Iterable<Object> actual) {
			List<String> expectedList = toStringList(expectation, ',');
			List<String> actualList = toStringList(actual, cfg.itemFormatter());
			Collection<String> expectedNormalized = normalize(expectedList);
			Collection<String> actualNormalized = normalize(actualList);
			if (!expectedNormalized.equals(actualNormalized)) {
				List<Item> actualItems = escape(actualList);
				List<Item> expectedItems = escape(expectedList);
				if (!cfg.ordered())
					expectedItems = sort(actualItems, expectedItems);
				wrap(actualItems);
				suppressWrap(actualItems, expectedItems);
				wrap(expectedItems);
				String expectedFormatted = format(expectedItems);
				String actualFormatted = format(actualItems);
				throw new ComparisonFailure("", expectedFormatted, actualFormatted);
			}
		}

		protected void wrap(List<Item> items) {
			boolean restrictWidth = cfg.maxLineWidth() >= 0;
			boolean restrictItems = cfg.maxItemsPerLine() >= 0;
			ItemWithPred last = null;
			for (Item item : items) {
				ItemWithPred i = (ItemWithPred) item;
				i.predecessor = last;
				last = i;
			}
			for (Item item : items) {
				ItemWithPred i = (ItemWithPred) item;
				if (!i.suppressWrapBefore) {
					boolean itemsEx = restrictItems && i.itemsInLine() > cfg.maxItemsPerLine();
					boolean widthEx = restrictWidth && i.charsInLine() > cfg.maxLineWidth();
					i.wrapBefore = itemsEx || widthEx;
				}
			}
		}

	}

	boolean caseSensitive() default true;

	Class<? extends Function<Object, String>> itemFormatter() default ToString.class;

	int maxItemsPerLine() default -1;

	int maxLineWidth() default 80;

	boolean ordered() default false;

	boolean whitespaceSensitive() default false;

}
