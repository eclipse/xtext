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

		public StringExpectationImpl(StringExpectation annotation, ITargetSyntaxSupport targetSyntax, IExpectationRegion region) {
			super(targetSyntax, region);
			this.annotation = annotation;
		}

		public void assertEquals(Object string) {
			if (string == null)
				throw new NullPointerException("Object is null");
			String actual = string.toString();
			String escapedActual = getTargetSyntaxLiteral().escape(actual);
			String originalExpectation = getExpectation();
			String migratedExpectation;
			if (!annotation.whitespaceSensitive()) {
				FormattingMigrator migrator = new FormattingMigrator();
				migratedExpectation = migrator.migrate(escapedActual, originalExpectation);
			} else
				migratedExpectation = originalExpectation;
			if ((annotation.caseSensitive() && !migratedExpectation.equals(escapedActual))
					|| (!annotation.caseSensitive() && !migratedExpectation.equalsIgnoreCase(escapedActual))) {
				String expDoc = replaceInDocument(migratedExpectation);
				String actDoc = replaceInDocument(escapedActual);
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
			if (region != null)
				return new StringExpectationProvider(annotation, region);
			return null;
		}
	}

	public class StringExpectationProvider extends AbstractExpectationProvider<IStringExpectation> {

		private final StringExpectation annotation;

		public StringExpectationProvider(StringExpectation cfg, IExpectationRegion region) {
			super(region);
			this.annotation = cfg;
		}

		@Override
		protected IStringExpectation createExpectation(ITargetSyntaxSupport targetSyntax) {
			return new StringExpectationImpl(annotation, targetSyntax, getClaimedRegion());
		}

		public StringExpectation getAnnotation() {
			return annotation;
		}
	}

	boolean caseSensitive() default true;

	boolean whitespaceSensitive() default false;
}
