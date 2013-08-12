/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xpect.expectation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Collection;
import java.util.List;

import org.eclipse.xtext.util.Pair;
import org.junit.Assert;
import org.junit.ComparisonFailure;
import org.xpect.XpectInvocation;
import org.xpect.expectation.ActualCollection.ActualItem;
import org.xpect.expectation.ActualCollection.ToString;
import org.xpect.expectation.ExpectationCollection.ExpectationItem;
import org.xpect.expectation.LinesExpectation.LinesExpectationParser;
import org.xpect.parameter.IParameterParser.ISingleParameterParser;
import org.xpect.parameter.IParameterParser.SingleParameterParser;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@SingleParameterParser(LinesExpectationParser.class)
public @interface LinesExpectation {

	public class LinesExpectationImpl extends AbstractExpectation implements ILinesExpectation {

		private final LinesExpectation annotation;

		public LinesExpectationImpl(LinesExpectation annotation, ITargetSyntaxSupport targetSyntax, IExpectationRegion region) {
			super(targetSyntax, region);
			this.annotation = annotation;
		}

		public void assertEquals(Iterable<?> actual) {
			assertEquals("", actual, false);
		}

		public void assertEquals(String message, Iterable<?> actual) {
			assertEquals(message, actual, false);
		}

		protected void assertEquals(String message, Iterable<?> actual, boolean forceFail) {
			Assert.assertNotNull(actual);

			ExpectationCollection exp = new ExpectationCollection();
			exp.setCaseSensitive(annotation.caseSensitive());
			exp.setOrdered(annotation.ordered());
			exp.setQuoted(annotation.quoted());
			exp.setSeparator('\n');
			exp.setWhitespaceSensitive(annotation.whitespaceSensitive());
			exp.init(getExpectation());

			ActualCollection act = new ActualCollection();
			act.setCaseSensitive(annotation.caseSensitive());
			act.setOrdered(annotation.ordered());
			act.setQuoted(annotation.quoted());
			act.setSeparator('\n');
			act.setWhitespaceSensitive(annotation.whitespaceSensitive());
			act.init(actual, annotation.itemFormatter());

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
				String expDoc = replaceInDocument(Joiner.on('\n').join(expString));
				String actDoc = replaceInDocument(Joiner.on('\n').join(actString));
				throw new ComparisonFailure(message, expDoc, actDoc);
			}
		}

		public void fail(String message, Iterable<?> actual) {
			assertEquals(message, actual, true);
		}

		public LinesExpectation getAnnotation() {
			return annotation;
		}
	}

	public class LinesExpectationParser extends AbstractExpectationParser implements ISingleParameterParser {
		private final LinesExpectation annotation;

		public LinesExpectationParser(LinesExpectation cfg) {
			super();
			this.annotation = cfg;
		}

		public LinesExpectation getAnnotation() {
			return annotation;
		}

		public IParsedParameterProvider parseRegion(XpectInvocation invocation, int paramIndex, List<IClaimedRegion> claims) {
			IExpectationRegion region = claimRegion(invocation, paramIndex);
			if (region != null)
				return new LinesExpectationProvider(annotation, region);
			return null;
		}
	}

	public class LinesExpectationProvider extends AbstractExpectationProvider<ILinesExpectation> {

		private final LinesExpectation annotation;

		public LinesExpectationProvider(LinesExpectation cfg, IExpectationRegion region) {
			super(region);
			this.annotation = cfg;
		}

		@Override
		protected ILinesExpectation createExpectation(ITargetSyntaxSupport targetSyntax) {
			return new LinesExpectationImpl(annotation, targetSyntax, getClaimedRegion());
		}

		public LinesExpectation getAnnotation() {
			return annotation;
		}

	}

	boolean caseSensitive() default true;

	Class<? extends Function<Object, String>> itemFormatter() default ToString.class;

	boolean ordered() default false;

	boolean quoted() default false;

	boolean whitespaceSensitive() default false;

}
