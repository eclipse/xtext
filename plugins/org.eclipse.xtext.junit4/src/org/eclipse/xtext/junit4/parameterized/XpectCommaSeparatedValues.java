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

import org.eclipse.xtext.junit4.parameterized.ActualCollection.ActualItem;
import org.eclipse.xtext.junit4.parameterized.ActualCollection.ToString;
import org.eclipse.xtext.junit4.parameterized.ExpectationCollection.ExpectationItem;
import org.eclipse.xtext.junit4.parameterized.IParameterProvider.IExpectation;
import org.eclipse.xtext.junit4.parameterized.TestExpectationValidator.ITestExpectationValidator;
import org.eclipse.xtext.junit4.parameterized.TestExpectationValidator.TestResult;
import org.eclipse.xtext.junit4.parameterized.XpectCommaSeparatedValues.CSVResultValidator;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.Pair;
import org.junit.ComparisonFailure;

import com.google.common.base.Function;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@TestExpectationValidator(validator = CSVResultValidator.class)
public @interface XpectCommaSeparatedValues {

	public class CSVResultValidator implements ITestExpectationValidator<Iterable<Object>> {
		protected XpectCommaSeparatedValues cfg;

		public CSVResultValidator(XpectCommaSeparatedValues cfg) {
			this.cfg = cfg;
		}

		protected String str(int length) {
			StringBuilder b = new StringBuilder();
			for (int i = 0; i < length; i++)
				b.append(" ");
			return b.toString();
		}

		public void validate(XtextResource res, IExpectation expectation, @TestResult Iterable<Object> actual) {
			ExpectationCollection exp = new ExpectationCollection();
			exp.setCaseSensitive(cfg.caseSensitive());
			exp.setOrdered(cfg.ordered());
			exp.setQuoted(cfg.quoted());
			exp.setSeparator(',');
			exp.setWhitespaceSensitive(cfg.whitespaceSensitive());
			exp.init(expectation.getExpectation());

			ActualCollection act = new ActualCollection();
			act.setCaseSensitive(cfg.caseSensitive());
			act.setOrdered(cfg.ordered());
			act.setQuoted(cfg.quoted());
			act.setSeparator(',');
			act.setWhitespaceSensitive(cfg.whitespaceSensitive());
			act.init(actual, cfg.itemFormatter());

			if (!exp.matches(act)) {
				StringBuilder expString = new StringBuilder();
				StringBuilder actString = new StringBuilder();
				boolean expWrap = false;
				boolean expEmpty = false;
				boolean actWrap = false;
				int lineLength = 0, lineCount = 0;
				for (Pair<Collection<ExpectationItem>, ActualItem> pair : exp.map(act)) {
					String expItem = null;
					String actItem = null;
					if (pair.getFirst() != null && !pair.getFirst().isEmpty()) {
						if (pair.getSecond() != null)
							expItem = pair.getSecond().getEscaped();
						else
							expItem = pair.getFirst().iterator().next().getEscaped();
					} else {
						if (pair.getSecond() != null)
							expItem = str(pair.getSecond().getEscaped().length());
					}
					if (pair.getSecond() != null) {
						actItem = pair.getSecond().getEscaped();
						lineCount++;
						lineLength += actItem.length() + 2;
						boolean count = cfg.maxItemsPerLine() > 0 && lineCount > cfg.maxItemsPerLine();
						boolean width = cfg.maxLineWidth() > 0 && lineLength > cfg.maxLineWidth();
						if (count || width)
							expWrap = actWrap = true;
					}
					if (expItem != null && expString.length() > 0) {
						if (expWrap) {
							expString.append(expEmpty ? "\n" : ",\n");
							expWrap = false;
						} else
							expString.append(expEmpty ? "  " : ", ");
					}
					if (actItem != null && actString.length() > 0) {
						if (actWrap) {
							actString.append(",\n");
							actWrap = false;
							lineCount = 0;
							lineLength = 0;
						} else
							actString.append(", ");
					}
					if (expItem != null) {
						expString.append(expItem);
						expEmpty = expItem.trim().length() == 0;
					}
					if (actItem != null)
						actString.append(actItem);
				}
				String expDoc = IExpectation.Util.replace(res, expectation, expString.toString());
				String actDoc = IExpectation.Util.replace(res, expectation, actString.toString());
				throw new ComparisonFailure("", expDoc, actDoc);
			}
		}
	}

	boolean caseSensitive() default true;

	Class<? extends Function<Object, String>> itemFormatter() default ToString.class;

	int maxItemsPerLine() default -1;

	int maxLineWidth() default 80;

	boolean ordered() default false;

	boolean quoted() default false;

	boolean whitespaceSensitive() default false;

}
