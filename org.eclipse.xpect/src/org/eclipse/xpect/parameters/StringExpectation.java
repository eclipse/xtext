package org.eclipse.xpect.parameters;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;

import org.eclipse.xpect.parameters.StringExpectation.StringExpectationParser;
import org.eclipse.xpect.runner.XpectSingleParameterProvider;
import org.eclipse.xpect.runner.XpectTestRunner;
import org.eclipse.xpect.runner.IXpectParameterProvider.IXpectSingleParameterProvider;
import org.eclipse.xpect.util.IRegion;
import org.eclipse.xpect.util.ITypedProvider;
import org.eclipse.xtext.util.internal.FormattingMigrator;
import org.junit.ComparisonFailure;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@SuppressWarnings("restriction")
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
@XpectSingleParameterProvider(StringExpectationParser.class)
public @interface StringExpectation {

	public class IStringExpectationImpl extends AbstractExpectation implements IStringExpectation, ITypedProvider {

		private final StringExpectation annotation;

		public IStringExpectationImpl(StringExpectation annotation, String document, int offset, int lenght) {
			super(document, offset, lenght);
			this.annotation = annotation;
		}

		@Override
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

		@Override
		public boolean canProvide(Class<?> expectedType) {
			return expectedType.isInstance(this);
		}

		@Override
		@SuppressWarnings("unchecked")
		public <T> T get(Class<T> expectedType) {
			if (expectedType.isInstance(this))
				return (T) this;
			return null;
		}

		public StringExpectation getAnnotation() {
			return annotation;
		}

	}

	public class StringExpectationParser extends AbstractExpectationParser implements IXpectSingleParameterProvider {

		private final StringExpectation annotation;

		public StringExpectationParser(StringExpectation cfg) {
			super();
			this.annotation = cfg;
		}

		public StringExpectation getAnnotation() {
			return annotation;
		}

		@Override
		public ITypedProvider parseRegion(XpectTestRunner invocation, int paramIndex, List<IClaimedRegion> claims) {
			IRegion region = claimRegion(invocation, paramIndex);
			if (region != null)
				return new IStringExpectationImpl(annotation, invocation.getDocument(), region.getOffset(), region.getLength());
			return null;
		}

	}

	boolean caseSensitive() default true;

	boolean whitespaceSensitive() default false;
}
