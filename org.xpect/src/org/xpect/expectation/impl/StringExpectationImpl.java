package org.xpect.expectation.impl;

import org.eclipse.xtext.util.internal.FormattingMigrator;
import org.junit.ComparisonFailure;
import org.xpect.XpectArgument;
import org.xpect.XpectImport;
import org.xpect.expectation.IStringExpectation;
import org.xpect.expectation.StringExpectation;
import org.xpect.setup.XpectSetupFactory;
import org.xpect.state.Creates;

@XpectSetupFactory
@SuppressWarnings("restriction")
@XpectImport(ExpectationRegionProvider.class)
public class StringExpectationImpl extends AbstractExpectation implements IStringExpectation {

	private final StringExpectation annotation;

	public StringExpectationImpl(XpectArgument argument, TargetSyntaxSupport targetSyntax) {
		super(argument, targetSyntax);
		this.annotation = argument.getAnnotationOrDefault(StringExpectation.class);
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
		if ((annotation.caseSensitive() && !migratedExpectation.equals(escapedActual)) || (!annotation.caseSensitive() && !migratedExpectation.equalsIgnoreCase(escapedActual))) {
			String expDoc = replaceInDocument(migratedExpectation);
			String actDoc = replaceInDocument(escapedActual);
			throw new ComparisonFailure("", expDoc, actDoc);
		}
	}

	public StringExpectation getAnnotation() {
		return annotation;
	}

	@Creates
	public IStringExpectation create() {
		return this;
	}

}