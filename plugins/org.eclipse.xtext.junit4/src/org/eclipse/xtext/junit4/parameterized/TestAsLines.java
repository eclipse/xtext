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

import org.eclipse.xtext.junit4.parameterized.AbstractIterableExpectationValidator.ToString;
import org.eclipse.xtext.junit4.parameterized.TestAsLines.LinesResultValidator;
import org.eclipse.xtext.junit4.parameterized.TestExpectationValidator.TestResult;
import org.junit.ComparisonFailure;

import com.google.common.base.Function;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@TestExpectationValidator(validator = LinesResultValidator.class)
public @interface TestAsLines {

	public class LinesResultValidator extends AbstractIterableExpectationValidator {

		protected TestAsLines cfg;

		public LinesResultValidator(TestAsLines cfg) {
			super(cfg.caseSensitive(), cfg.whitespaceSensitive());
			this.cfg = cfg;
		}

		protected String format(List<Item> items) {
			StringBuilder result = new StringBuilder();
			for (Item item : items) {
				if (result.length() > 0)
					result.append("\n");
				result.append(item.escaped);
			}
			return result.toString();
		}

		public void validate(String expectation, @TestResult Iterable<Object> actual) {
			List<String> expectedList = toStringList(expectation, '\n');
			List<String> actualList = toStringList(actual, cfg.itemFormatter());
			Collection<String> expectedNormalized = normalize(expectedList);
			Collection<String> actualNormalized = normalize(actualList);
			if (!expectedNormalized.equals(actualNormalized)) {
				List<Item> actualItems = escape(actualList);
				List<Item> expectedItems = escape(expectedList);
				if (!cfg.ordered())
					expectedItems = sort(actualItems, expectedItems);
				String expectedFormatted = format(expectedItems);
				String actualFormatted = format(actualItems);
				throw new ComparisonFailure("", expectedFormatted, actualFormatted);
			}
		}

	}

	boolean caseSensitive() default true;

	boolean whitespaceSensitive() default false;

	Class<? extends Function<Object, String>> itemFormatter() default ToString.class;

	boolean ordered() default false;

}
