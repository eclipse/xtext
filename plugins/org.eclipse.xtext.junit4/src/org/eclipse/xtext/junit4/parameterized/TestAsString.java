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
import java.util.regex.Pattern;

import org.eclipse.xtext.junit4.parameterized.TestExpectationValidator.ITestExpectationValidator;
import org.eclipse.xtext.junit4.parameterized.TestExpectationValidator.TestResult;
import org.eclipse.xtext.junit4.parameterized.TestAsString.StringResultValidator;
import org.eclipse.xtext.util.internal.FormattingMigrator;
import org.junit.ComparisonFailure;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@TestExpectationValidator(validator = StringResultValidator.class)
public @interface TestAsString {

	public class StringResultValidator implements ITestExpectationValidator<String> {
		protected static final Pattern WS = Pattern.compile("\\s+", Pattern.MULTILINE);

		protected TestAsString config;

		public StringResultValidator(TestAsString config) {
			this.config = config;
		}

		public void validate(String expectation, @TestResult String actual) {
			String exp;
			if (!config.whitespaceSensitive()) {
				FormattingMigrator migrator = new FormattingMigrator();
				exp = migrator.migrate(actual, expectation, WS);
			} else
				exp = expectation;
			if (config.caseSensitive()) {
				if (!exp.equals(actual))
					throw new ComparisonFailure("", exp, actual);
			} else {
				if (!exp.equalsIgnoreCase(actual))
					throw new ComparisonFailure("", exp, actual);
			}
		}
	}

	boolean caseSensitive() default true;

	boolean whitespaceSensitive() default false;
}
