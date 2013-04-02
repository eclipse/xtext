/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xpect.parameters;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Collection;
import java.util.List;

import org.eclipse.xtext.util.Pair;
import org.junit.ComparisonFailure;
import org.xpect.parameters.ActualCollection.ActualItem;
import org.xpect.parameters.ActualCollection.ToString;
import org.xpect.parameters.CommaSeparatedValuesExpectation.CommaSeparatedValuesExpectationParser;
import org.xpect.parameters.ExpectationCollection.ExpectationItem;
import org.xpect.runner.IParameterParser.ISingleParameterParser;
import org.xpect.runner.XpectSingleParameterProvider;
import org.xpect.runner.XpectTestRunner;
import org.xpect.util.IRegion;
import org.xpect.util.ITypedProvider;

import com.google.common.base.Function;
import com.google.common.base.Predicate;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
@XpectSingleParameterProvider(CommaSeparatedValuesExpectationParser.class)
public @interface CommaSeparatedValuesExpectation {

	public class CommaSeparatedValuesExpectationImpl extends AbstractExpectation implements ICommaSeparatedValuesExpectation {
		private final CommaSeparatedValuesExpectation annotation;

		public CommaSeparatedValuesExpectationImpl(CommaSeparatedValuesExpectation annotation, String document, int offset, int lenght) {
			super(document, offset, lenght);
			this.annotation = annotation;
		}

		public void assertEquals(Iterable<?> actual) {
			assertEquals(actual, null);
		}

		public void assertEquals(Iterable<?> actual, Predicate<String> predicate) {
			String indentation = getIndentation();

			ExpectationCollection exp = new ExpectationCollection();
			exp.setCaseSensitive(annotation.caseSensitive());
			exp.setOrdered(annotation.ordered());
			exp.setQuoted(annotation.quoted());
			exp.setSeparator(',');
			exp.setWhitespaceSensitive(annotation.whitespaceSensitive());
			exp.init(getExpectation(indentation));

			ActualCollection act = new ActualCollection();
			act.setCaseSensitive(annotation.caseSensitive());
			act.setOrdered(annotation.ordered());
			act.setQuoted(annotation.quoted());
			act.setSeparator(',');
			act.setWhitespaceSensitive(annotation.whitespaceSensitive());
			if (actual != null && predicate != null) {
				if (exp.isWildcard())
					act.init(exp.applyPredicate(predicate), annotation.itemFormatter());
				else
					act.init(actual, annotation.itemFormatter());
			} else if (predicate != null)
				act.init(exp.applyPredicate(predicate), annotation.itemFormatter());
			else if (actual != null)
				act.init(actual, annotation.itemFormatter());
			else
				throw new NullPointerException();

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
						boolean count = annotation.maxItemsPerLine() > 0 && lineCount > annotation.maxItemsPerLine();
						boolean width = annotation.maxLineWidth() > 0 && lineLength > annotation.maxLineWidth();
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
				String expDoc = replaceInDocument(indentation, expString.toString());
				String actDoc = replaceInDocument(indentation, actString.toString());
				throw new ComparisonFailure("", expDoc, actDoc);
			}
		}

		public void assertEquals(Predicate<String> predicate) {
			assertEquals(null, predicate);
		}

		public CommaSeparatedValuesExpectation getAnnotation() {
			return annotation;
		}

		protected String str(int length) {
			StringBuilder b = new StringBuilder();
			for (int i = 0; i < length; i++)
				b.append(" ");
			return b.toString();
		}

	}

	public class CommaSeparatedValuesExpectationParser extends AbstractExpectationParser implements ISingleParameterParser {

		private final CommaSeparatedValuesExpectation annotation;

		public CommaSeparatedValuesExpectationParser(CommaSeparatedValuesExpectation cfg) {
			super();
			this.annotation = cfg;
		}

		public CommaSeparatedValuesExpectation getAnnotation() {
			return annotation;
		}

		public ITypedProvider parseRegion(XpectTestRunner invocation, int paramIndex, List<IClaimedRegion> claims) {
			IRegion region = claimRegion(invocation, paramIndex);
			if (region != null)
				return new CommaSeparatedValuesExpectationImpl(annotation, invocation.getDocument(), region.getOffset(), region.getLength());
			return null;
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
