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
import java.util.List;

import org.eclipse.xtext.util.internal.FormattingMigrator;
import org.junit.ComparisonFailure;
import org.xpect.XpectInvocation;
import org.xpect.parameters.IParameterParser.ISingleParameterParser;
import org.xpect.parameters.IParameterParser.SingleParameterParser;
import org.xpect.parameters.StringExpectation.StringExpectationParser;
import org.xpect.util.IParameterProvider;
import org.xpect.util.IRegion;

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

		public StringExpectationImpl(StringExpectation annotation, String document, int offset, int lenght) {
			super(document, offset, lenght);
			this.annotation = annotation;
		}

		public void assertEquals(Object string) {
			if (string == null)
				throw new NullPointerException("Object is null");
			String actual = string.toString();
			String indentation = getIndentation();
			String originalExpectation = getExpectation(indentation);
			String migratedExpectation;
			if (!annotation.whitespaceSensitive()) {
				FormattingMigrator migrator = new FormattingMigrator();
				migratedExpectation = migrator.migrate(actual, originalExpectation);
			} else
				migratedExpectation = originalExpectation;
			if ((annotation.caseSensitive() && !migratedExpectation.equals(actual))
					|| (!annotation.caseSensitive() && !migratedExpectation.equalsIgnoreCase(actual))) {
				String expDoc = replaceInDocument(indentation, migratedExpectation);
				String actDoc = replaceInDocument(indentation, actual);
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

		public IParameterProvider parseRegion(XpectInvocation invocation, int paramIndex, List<IClaimedRegion> claims) {
			IRegion region = claimRegion(invocation, paramIndex);
			if (region != null) {
				String document = invocation.getFile().getDocument();
				return new StringExpectationImpl(annotation, document, region.getOffset(), region.getLength());
			}
			return null;
		}

	}

	boolean caseSensitive() default true;

	boolean whitespaceSensitive() default false;
}
