/*******************************************************************************
 * Copyright (c) 2014, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.junit4;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.junit.Assert;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import com.google.common.annotations.Beta;

/**
 * Annotate a method with {@code Flaky} to mark it as occasionally failing.
 * 
 * If the test class defines a {@code @Rule Flaky.Rule} (a public, non-static, initialized field),
 * it will try to execute a flaky tests more than once if it failed. By default,
 * three executions are tried.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @noreference This annotation is not intended to be referenced by clients.
 * @deprecated Use org.eclipse.xtext.testing.Flaky instead
 * 
 * @since 2.7
 */
@Beta
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Deprecated(forRemoval = true)
public @interface Flaky {

	/**
	 * The number of trials if the test method failed. Defaults to {@code 3}.
	 */
	int trials() default 3;
	
	/**
	 * A test rule that will enable flaky tests to be executed more than once.
	 */
	class Rule implements TestRule {

		@Override
		public Statement apply(Statement base, Description description) {
			Flaky flaky = description.getAnnotation(Flaky.class);
			if (flaky == null) {
				return base;
			}
			int trials = flaky.trials();
			return new RepeatedStatement(base, trials);
		}
		
		private static class RepeatedStatement extends Statement {

			private final Statement base;
			private final int trials;

			public RepeatedStatement(Statement base, int trials) {
				this.base = base;
				this.trials = trials;
			}

			@Override
			public void evaluate() throws Throwable {
				if (trials <= 1 || trials > 100) {
					throw new IllegalArgumentException("Illegal number of trials: " + trials + ", must be between 2 and 100 (inclusive)");
				}
				
				int remaining = trials;
				Throwable firstError = null;
				while(remaining > 0) {
					try {
						base.evaluate();
						return;
					} catch(Throwable t) {
						if (firstError == null) {
							firstError = t;
						}
						remaining--;
					}
				}
				Assert.assertNotNull(firstError);
				throw firstError;
			}
			
		}
	}
	
	
}
