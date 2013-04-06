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
import java.util.List;

import org.eclipse.xtext.util.internal.FormattingMigrator;
import org.junit.ComparisonFailure;
import org.xpect.XpectInvocation;
import org.xpect.expectation.StringExpectation.StringExpectationParser;
import org.xpect.parameter.IParameterParser.ISingleParameterParser;
import org.xpect.parameter.IParameterParser.SingleParameterParser;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@SuppressWarnings("restriction")
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
@SingleParameterParser(StringExpectationParser.class)
public @interface StringExpectation {

	public class StringExpectationImpl extends AbstractExpectation implements IStringExpectation {

		private final StringExpectation annotation;

		public StringExpectationImpl(StringExpectation annotation, String document, IExpectationRegion region) {
			super(document, region);
			this.annotation = annotation;
		}

		public void assertEquals(Object string) {
			if (string == null)
				throw new NullPointerException("Object is null");
			String actual = string.toString();
			String originalExpectation = getExpectation();
			String migratedExpectation;
			if (!annotation.whitespaceSensitive()) {
				FormattingMigrator migrator = new FormattingMigrator();
				migratedExpectation = migrator.migrate(actual, originalExpectation);
			} else
				migratedExpectation = originalExpectation;
			if ((annotation.caseSensitive() && !migratedExpectation.equals(actual))
					|| (!annotation.caseSensitive() && !migratedExpectation.equalsIgnoreCase(actual))) {
				String expDoc = replaceInDocument(migratedExpectation);
				String actDoc = replaceInDocument(actual);
				throw new ComparisonFailure("", expDoc, actDoc);
			}

		}

		public StringExpectation getAnnotation() {
			return annotation;
		}

	}

	public class StringExpectationParser extends AbstractExpectationParser implements ISingleParameterParser {

		private final StringExpectation annotation;

		public StringExpectationParser(StringExpectation cfg) {
			super();
			this.annotation = cfg;
		}

		public StringExpectation getAnnotation() {
			return annotation;
		}

		public IParsedParameterProvider parseRegion(XpectInvocation invocation, int paramIndex, List<IClaimedRegion> claims) {
			IExpectationRegion region = claimRegion(invocation, paramIndex);
			if (region != null) {
				String document = invocation.getFile().getDocument();
				return new StringExpectationImpl(annotation, document, region);
			}
			return null;
		}

	}

	boolean caseSensitive() default true;

	boolean whitespaceSensitive() default false;
}
