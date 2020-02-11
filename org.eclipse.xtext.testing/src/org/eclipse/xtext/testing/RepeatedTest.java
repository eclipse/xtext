/*******************************************************************************
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.testing;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 * Annotation to mark a test that should be executed in a loop for
 * {@link #times() n times}.
 * 
 * @since 2.17
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD, ElementType.TYPE })
@Inherited
public @interface RepeatedTest {
	/**
	 * @return number of repetitions.
	 */
	int times() default 10;

	/**
	 * Test rule used along with {@link RepeatedTest} to let a test loop for a couple
	 * of rounds.
	 */
	public static class Rule implements TestRule {

		private final boolean quiet;

		/**
		 * @param quiet set to true if log output is not desired. Otherwise the current
		 *              iteration is logged to <code>System.out</code>
		 */
		public Rule(boolean quiet) {
			this.quiet = quiet;
		}

		/**
		 * Creates a quiet test rule.
		 */
		public Rule() {
			this(true);
		}

		@Override
		public Statement apply(Statement statement, Description description) {
			RepeatedTest repeat = description.getAnnotation(RepeatedTest.class);
			if (repeat == null) {
				repeat = description.getTestClass().getAnnotation(RepeatedTest.class);
			}
			if (repeat != null) {
				return new RepeatedTestStatement(repeat.times(), statement, description, quiet);
			}
			return statement;
		}

		/**
		 * Encapsulates the logic for tests that should be executed in a tight loop.
		 */
		public static class RepeatedTestStatement extends Statement {
			private final int times;
			private final Statement statement;
			private final boolean quiet;
			private final Description description;

			public RepeatedTestStatement(int times, Statement statement, Description description, boolean quiet) {
				this.times = times;
				this.statement = statement;
				this.description = description;
				this.quiet = quiet;
			}

			@Override
			public void evaluate() throws Throwable {
				for (int i = 1; i <= times; i++) {
					if (!quiet) {
						System.out.printf("[%s] %d of %d\n", description.getMethodName(), i, times);
					}
					statement.evaluate();
				}
			}
		}
	}
}