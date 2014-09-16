package org.xpect.expectation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Collections;
import java.util.List;

import org.eclipse.xtext.util.internal.FormattingMigrator;
import org.junit.ComparisonFailure;
import org.xpect.XpectInvocation;
import org.xpect.expectation.IStringDiffExpectation.IToken;
import org.xpect.expectation.IStringDiffExpectation.ITokenAdapter;
import org.xpect.expectation.StringDiffExpectation.StringDiffExpectationParser;
import org.xpect.parameter.IParameterParser.ISingleParameterParser;
import org.xpect.parameter.IParameterParser.SingleParameterParser;
import org.xpect.text.GenericTokenizer;
import org.xpect.text.ITextDifferencer;
import org.xpect.text.ITextDifferencer.ISegment;
import org.xpect.text.ITextDifferencer.ITextDiff;
import org.xpect.text.ITextDifferencer.ITextDiffConfig;
import org.xpect.text.StringEndsSimilarityFunction;
import org.xpect.text.TextDiffToString;
import org.xpect.text.TextDifferencer;
import org.xpect.util.IDifferencer.ISimilarityFunction;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

@SuppressWarnings("restriction")
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
@SingleParameterParser(StringDiffExpectationParser.class)
public @interface StringDiffExpectation {

	public static class GenericTextDiffConfig<T> implements ITextDiffConfig<T> {

		private final ITokenAdapter<T> delegate;
		private final List<T> left;
		private final List<T> right;

		public GenericTextDiffConfig(List<T> left, List<T> right, ITokenAdapter<T> delegate) {
			super();
			this.delegate = delegate;
			this.left = left;
			this.right = right;
		}

		public boolean isHidden(T token, String segment) {
			return delegate.isHidden(token, segment);
		}

		public float similarity(ISegment object1, ISegment object2) {
			T token1 = left.get(object1.getTokenIndex());
			T token2 = right.get(object2.getTokenIndex());
			return delegate.similarity(token1, object1.toString(), token2, object2.toString());
		}

		public Iterable<String> toSegments(T token) {
			return delegate.splitIntoSegments(token);
		}
	}

	public class StringDiffExpectationImpl extends AbstractExpectation implements IStringDiffExpectation {

		private final StringDiffExpectation annotation;

		public StringDiffExpectationImpl(StringDiffExpectation annotation, TargetSyntaxSupport targetSyntax, IExpectationRegion region) {
			super(targetSyntax, region);
			this.annotation = annotation;
		}

		public <T extends IToken<? super T>> void assertDiffEquals(Iterable<T> leftTokens, Iterable<T> rightTokens) {
			List<T> left = ImmutableList.copyOf(leftTokens);
			List<T> right = ImmutableList.copyOf(rightTokens);
			ITextDiffConfig<T> config = createDiffConfig(left, right);
			assertDiffEquals(left, right, config);
		}

		public <T> void assertDiffEquals(Iterable<T> leftTokens, Iterable<T> rightTokens, ITokenAdapter<T> adapter) {
			Preconditions.checkNotNull(adapter);
			List<T> left = ImmutableList.copyOf(leftTokens);
			List<T> right = ImmutableList.copyOf(rightTokens);
			ITextDiffConfig<T> config = createDiffConfig(left, right, adapter);
			assertDiffEquals(left, right, config);
		}

		protected <T> void assertDiffEquals(List<T> left, List<T> right, ITextDiffConfig<T> config) throws ComparisonFailure {
			ITextDifferencer differencer = createDifferencer();
			ITextDiff diff = differencer.diff(left, right, config);
			String actual = createDiffToString().apply(diff);
			String escapedActual = getTargetSyntaxLiteral().escape(actual);
			String originalExpectation = getExpectation();
			String migratedExpectation;
			if (!annotation.whitespaceSensitive()) {
				FormattingMigrator migrator = new FormattingMigrator();
				migratedExpectation = migrator.migrate(escapedActual, originalExpectation);
			} else {
				migratedExpectation = originalExpectation;
			}
			if (!migratedExpectation.equals(escapedActual)) {
				String expDoc = replaceInDocument(migratedExpectation);
				String actDoc = replaceInDocument(escapedActual);
				throw new ComparisonFailure("", expDoc, actDoc);
			}
		}

		public void assertDiffEquals(String left, String right) {
			Preconditions.checkNotNull(left);
			Preconditions.checkNotNull(right);
			Function<String, ? extends Iterable<String>> tokenizer = createTokenizer();
			List<String> leftTokens = ImmutableList.copyOf(tokenizer.apply(left));
			List<String> rightTokens = ImmutableList.copyOf(tokenizer.apply(right));
			ITextDiffConfig<String> config = createDiffConfig();
			assertDiffEquals(leftTokens, rightTokens, config);
		}

		protected ITextDifferencer.ITextDiffConfig<String> createDiffConfig() {
			return new StringTextDiffConfig(new StringEndsSimilarityFunction(), annotation.whitespaceSensitive());
		}

		protected <T extends IToken<? super T>> ITextDifferencer.ITextDiffConfig<T> createDiffConfig(List<T> left, List<T> right) {
			return new TokenTextDiffConfig<T>(left, right);
		}

		protected <T> ITextDifferencer.ITextDiffConfig<T> createDiffConfig(List<T> left, List<T> right, ITokenAdapter<T> adapter) {
			return new GenericTextDiffConfig<T>(left, right, adapter);
		}

		protected ITextDifferencer createDifferencer() {
			return new TextDifferencer();
		}

		protected Function<? super ITextDiff, String> createDiffToString() {
			TextDiffToString toString = new TextDiffToString();
			toString.setAllowSingleLineDiff(annotation.allowSingleLineDiff());
			toString.setAllowSingleSegmentDiff(annotation.allowSingleSegmentDiff() && getRegion() instanceof ISingleLineExpectationRegion);
			toString.setLinesBeforeDiff(annotation.linesBeforeDiff());
			toString.setLinesAfterDiff(annotation.linesAfterDiff());
			return toString;
		}

		protected Function<String, ? extends Iterable<String>> createTokenizer() {
			try {
				return annotation.tokenizer().newInstance();
			} catch (Throwable e) {
				throw new RuntimeException("Error instantiating " + annotation.tokenizer(), e);
			}
		}

		public StringDiffExpectation getAnnotation() {
			return annotation;
		}

	}

	public class StringDiffExpectationParser extends AbstractExpectationParser implements ISingleParameterParser {
		private final StringDiffExpectation annotation;

		public StringDiffExpectationParser(StringDiffExpectation cfg) {
			super();
			this.annotation = cfg;
		}

		public StringDiffExpectation getAnnotation() {
			return annotation;
		}

		public IParsedParameterProvider parseRegion(XpectInvocation invocation, int paramIndex, List<IClaimedRegion> claims) {
			IExpectationRegion region = claimRegion(invocation, paramIndex);
			if (region != null)
				return new StringDiffExpectationProvider(annotation, region);
			return null;
		}
	}

	public class StringDiffExpectationProvider extends AbstractExpectationProvider<IStringDiffExpectation> {

		private final StringDiffExpectation annotation;

		public StringDiffExpectationProvider(StringDiffExpectation cfg, IExpectationRegion region) {
			super(region);
			this.annotation = cfg;
		}

		@Override
		protected IStringDiffExpectation createExpectation(TargetSyntaxSupport targetSyntax) {
			return new StringDiffExpectationImpl(annotation, targetSyntax, getClaimedRegion());
		}

		public StringDiffExpectation getAnnotation() {
			return annotation;
		}
	}

	public static class StringTextDiffConfig implements ITextDiffConfig<String> {
		private final ISimilarityFunction<String> similarityFunction;
		private final boolean whitespaceSensitive;

		public StringTextDiffConfig(ISimilarityFunction<String> similarityFunction, boolean whitespaceSensitive) {
			super();
			this.similarityFunction = similarityFunction;
			this.whitespaceSensitive = whitespaceSensitive;
		}

		public boolean isHidden(String token, String segment) {
			if (whitespaceSensitive)
				return false;
			for (int i = 0; i < segment.length(); i++)
				if (!Character.isWhitespace(segment.charAt(i)))
					return false;
			return true;
		}

		public float similarity(ISegment object1, ISegment object2) {
			return similarityFunction.similarity(object1.toString(), object2.toString());
		}

		public Iterable<String> toSegments(String token) {
			return Collections.singleton(token);
		}
	}

	public static class TokenTextDiffConfig<T extends IToken<? super T>> implements ITextDiffConfig<T> {

		private final List<T> left;
		private final List<T> right;

		public TokenTextDiffConfig(List<T> left, List<T> right) {
			super();
			this.left = left;
			this.right = right;
		}

		public boolean isHidden(T token, String segment) {
			return token.isHidden(segment);
		}

		public float similarity(ISegment object1, ISegment object2) {
			T l = left.get(object1.getTokenIndex());
			T r = right.get(object2.getTokenIndex());
			return l.similarity(object1.toString(), r, object2.toString());
		}

		public Iterable<String> toSegments(T token) {
			return token.splitIntoSegments();
		}

	}

	boolean allowSingleLineDiff() default true;

	boolean allowSingleSegmentDiff() default true;

	int linesAfterDiff() default 4;

	int linesBeforeDiff() default 4;

	Class<? extends Function<String, ? extends Iterable<String>>> tokenizer() default GenericTokenizer.class;

	boolean whitespaceSensitive() default false;
}
