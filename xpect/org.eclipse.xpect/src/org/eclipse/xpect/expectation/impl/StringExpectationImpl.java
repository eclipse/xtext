package org.eclipse.xpect.expectation.impl;

import org.eclipse.xpect.XpectArgument;
import org.eclipse.xpect.XpectImport;
import org.eclipse.xpect.expectation.IStringExpectation;
import org.eclipse.xpect.expectation.StringExpectation;
import org.eclipse.xpect.setup.XpectSetupFactory;
import org.eclipse.xpect.state.Creates;
import org.eclipse.xpect.text.Text;
import org.eclipse.xtext.util.internal.FormattingMigrator;
import org.junit.ComparisonFailure;

import com.google.common.base.Joiner;

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
		String originalExpectation = getExpectation();
		String nl = new Text(originalExpectation).getNL();
		String actual = string.toString();
		String actualWithNL = Joiner.on(nl).join(new Text(actual).splitIntoLines());
		String escapedActual = getTargetSyntaxLiteral().escape(actualWithNL);
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