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

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE)
public @interface TestExpectationValidator {

	public interface ITestExpectationValidator<RESULT> {

		void validate(String expectation, RESULT actual);
	}

	public class NullTestResultValidator implements ITestExpectationValidator<Void> {
		public NullTestResultValidator(Test config) {
		}

		public void validate(String expectation, @TestResult Void actual) {
			if (expectation != null && expectation.length() > 0)
				Assert.fail("This test should not have an expectation. Expectation: '" + expectation + "'.");
		}
	}

	@Retention(RetentionPolicy.RUNTIME)
	@Target(ElementType.PARAMETER)
	public @interface TestResult {
	}

	Class<? extends ITestExpectationValidator<?>> validator();
}