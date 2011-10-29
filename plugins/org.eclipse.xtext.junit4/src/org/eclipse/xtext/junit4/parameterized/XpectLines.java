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

import org.eclipse.xtext.junit4.parameterized.ActualCollection.ActualItem;
import org.eclipse.xtext.junit4.parameterized.ActualCollection.ToString;
import org.eclipse.xtext.junit4.parameterized.ExpectationCollection.ExpectationItem;
import org.eclipse.xtext.junit4.parameterized.IParameterProvider.IExpectation;
import org.eclipse.xtext.junit4.parameterized.TestExpectationValidator.ITestExpectationValidator;
import org.eclipse.xtext.junit4.parameterized.TestExpectationValidator.TestResult;
import org.eclipse.xtext.junit4.parameterized.XpectLines.LinesResultValidator;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.Pair;
import org.junit.Assert;
import org.junit.ComparisonFailure;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@TestExpectationValidator(validator = LinesResultValidator.class)
public @interface XpectLines {

	public class LinesResultValidator implements ITestExpectationValidator<Iterable<Object>> {

		protected XpectLines cfg;

		public LinesResultValidator(XpectLines cfg) {
			this.cfg = cfg;
		}

		public void validate(XtextResource res, IExpectation expectation, @TestResult Iterable<Object> actual) {
			Assert.assertNotNull(res);
			Assert.assertNotNull(expectation);
			Assert.assertNotNull(expectation.getExpectation());
			Assert.assertNotNull(actual);

			ExpectationCollection exp = new ExpectationCollection();
			exp.setCaseSensitive(cfg.caseSensitive());
			exp.setOrdered(cfg.ordered());
			exp.setQuoted(cfg.quoted());
			exp.setSeparator('\n');
			exp.setWhitespaceSensitive(cfg.whitespaceSensitive());
			exp.init(expectation.getExpectation());

			ActualCollection act = new ActualCollection();
			act.setCaseSensitive(cfg.caseSensitive());
			act.setOrdered(cfg.ordered());
			act.setQuoted(cfg.quoted());
			act.setSeparator('\n');
			act.setWhitespaceSensitive(cfg.whitespaceSensitive());
			act.init(actual, cfg.itemFormatter());

			if (!exp.matches(act)) {
				List<String> expString = Lists.newArrayList();
				List<String> actString = Lists.newArrayList();
				for (Pair<Collection<ExpectationItem>, ActualItem> pair : exp.map(act)) {
					if (pair.getFirst() != null && !pair.getFirst().isEmpty()) {
						if (pair.getSecond() != null)
							expString.add(pair.getSecond().getEscaped());
						else
							expString.add(pair.getFirst().iterator().next().getEscaped());
					}
					if (pair.getSecond() != null)
						actString.add(pair.getSecond().getEscaped());
				}
				String expDoc = IExpectation.Util.replace(res, expectation, Joiner.on('\n').join(expString));
				String actDoc = IExpectation.Util.replace(res, expectation, Joiner.on('\n').join(actString));
				throw new ComparisonFailure("", expDoc, actDoc);
			}

		}
	}

	boolean caseSensitive() default true;

	boolean whitespaceSensitive() default false;

	boolean quoted() default false;

	Class<? extends Function<Object, String>> itemFormatter() default ToString.class;

	boolean ordered() default false;

}
