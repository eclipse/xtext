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

import org.eclipse.xtext.junit4.parameterized.IParameterProvider.IExpectation;
import org.eclipse.xtext.junit4.parameterized.TestExpectationValidator.ITestExpectationValidator;
import org.eclipse.xtext.junit4.parameterized.TestExpectationValidator.TestResult;
import org.eclipse.xtext.junit4.parameterized.XpectString.StringResultValidator;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.internal.FormattingMigrator;
import org.junit.ComparisonFailure;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@TestExpectationValidator(validator = StringResultValidator.class)
public @interface XpectString {

	public class StringResultValidator implements ITestExpectationValidator<String> {

		protected XpectString config;

		public StringResultValidator(XpectString config) {
			this.config = config;
		}

		public void validate(XtextResource resource, IExpectation expectation, @TestResult String actual) {
			String exp;
			if (!config.whitespaceSensitive()) {
				FormattingMigrator migrator = new FormattingMigrator();
				exp = migrator.migrate(actual, expectation.getExpectation());
			} else
				exp = expectation.getExpectation();

			if ((config.caseSensitive() && !exp.equals(actual))
					|| (!config.caseSensitive() && !exp.equalsIgnoreCase(actual))) {
				String expDoc = IExpectation.Util.replace(resource, expectation, exp);
				String actDoc = IExpectation.Util.replace(resource, expectation, actual);
				throw new ComparisonFailure("", expDoc, actDoc);
			}
		}
	}

	boolean caseSensitive() default true;

	boolean whitespaceSensitive() default false;
}
