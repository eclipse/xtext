package org.xpect.lib;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.ComparisonFailure;
import org.junit.runner.RunWith;
import org.junit.runner.Runner;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;
import org.junit.runner.notification.RunNotifier;
import org.xpect.XpectFile;
import org.xpect.XpectImport;
import org.xpect.XpectInvocation;
import org.xpect.expectation.IStringDiffExpectation;
import org.xpect.expectation.IStringExpectation;
import org.xpect.expectation.StringDiffExpectation;
import org.xpect.expectation.StringExpectation;
import org.xpect.lib.XpectTestResultTest.ReflectiveXpectFileRunner;
import org.xpect.parameter.IParameterParser.IParsedParameterProvider;
import org.xpect.parameter.IParameterProvider;
import org.xpect.runner.Xpect;
import org.xpect.runner.XpectFileRunner;
import org.xpect.runner.XpectRunner;
import org.xpect.runner.XpectTestRunner;
import org.xpect.setup.XpectSetupFactory;
import org.xpect.state.StateContainer;
import org.xpect.text.IRegion;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

@RunWith(XpectRunner.class)
@XpectImport(ReflectiveXpectFileRunner.class)
public class XpectTestResultTest {
	public static class FailureListener extends RunListener {
		private Failure failure;

		public Failure getFailure() {
			return failure;
		}

		@Override
		public void testAssumptionFailure(Failure failure) {
			this.failure = failure;
		}

		@Override
		public void testFailure(Failure failure) throws Exception {
			this.failure = failure;
		}
	}

	@XpectSetupFactory
	public final static class ReflectiveXpectFileRunner extends XpectFileRunner {

		private final Map<XpectTestRunner, XpectTestRunner> reflectiveToInspected = Maps.newHashMap();

		public ReflectiveXpectFileRunner(StateContainer state, XpectRunner runner, XpectFile file) {
			super(state, runner, file);
		}

		@Override
		protected List<Runner> createChildren() {
			List<Runner> filtered = Lists.newArrayList();
			List<XpectTestRunner> lastReflectives = Lists.newArrayList();
			List<Runner> allChildren = super.createChildren();
			for (Runner runner : allChildren) {
				if (runner instanceof XpectTestRunner) {
					XpectTestRunner testRunner = (XpectTestRunner) runner;
					if (isReflectiveTest(testRunner.getInvocation())) {
						lastReflectives.add(testRunner);
						filtered.add(runner);
					} else if (!lastReflectives.isEmpty()) {
						for (XpectTestRunner reflective : lastReflectives)
							reflectiveToInspected.put(reflective, testRunner);
						lastReflectives.clear();
					} else {
						filtered.add(runner);
					}
				} else {
					filtered.add(runner);
				}
			}
			return filtered;
		}

		public Map<XpectTestRunner, XpectTestRunner> getReflectiveToInspected() {
			return reflectiveToInspected;
		}

		protected boolean isReflectiveTest(XpectInvocation invocation) {
			return XpectTestResultTest.class.isAssignableFrom(invocation.getMethod().getTest().getJavaClass());
		}
	}

	protected IRegion getExpectationRegion(XpectTestRunner runner) {
		for (IParameterProvider provider : runner.getInvocation().getParameters())
			if (provider instanceof IParsedParameterProvider)
				return ((IParsedParameterProvider) provider).getClaimedRegion();
		return null;
	}

	protected Failure run(XpectTestRunner inspected) {
		if (inspected == null)
			Assert.fail("This test needs to be followed by another XPECT statement.");
		FailureListener failureListener = new FailureListener();
		RunNotifier notifier = new RunNotifier();
		notifier.addListener(failureListener);
		inspected.run(notifier);
		Failure failure = failureListener.getFailure();
		if (failure == null)
			Assert.fail("The test didn't fail: " + inspected.getDescription().getDisplayName());
		return failure;
	}

	@Xpect
	public void testFailureDiff(@StringDiffExpectation IStringDiffExpectation expectation, XpectTestRunner runner) {
		ReflectiveXpectFileRunner fileRunner = (ReflectiveXpectFileRunner) runner.getFileRunner();
		XpectTestRunner inspected = fileRunner.getReflectiveToInspected().get(runner);
		Failure failure = run(inspected);
		Throwable exception = failure.getException();
		if (exception instanceof ComparisonFailure) {
			IRegion region = getExpectationRegion(inspected);
			ComparisonFailure comparisonFailure = (ComparisonFailure) exception;
			String expected = comparisonFailure.getExpected();
			String actual = comparisonFailure.getActual();
			String trimmedExpected = trim(expected, expected, region);
			String trimmedActual = trim(actual, expected, region);
			expectation.assertDiffEquals(trimmedExpected, trimmedActual);
		} else {
			throw new AssertionError("The exception is not a " + ComparisonFailure.class.getName(), exception);
		}
	}

	@Xpect
	public void testFailureMessage(@StringExpectation IStringExpectation expectation, XpectTestRunner runner) {
		ReflectiveXpectFileRunner fileRunner = (ReflectiveXpectFileRunner) runner.getFileRunner();
		XpectTestRunner inspected = fileRunner.getReflectiveToInspected().get(runner);
		Failure failure = run(inspected);
		expectation.assertEquals(failure.getMessage());
	}

	protected String trim(String string, String ref, IRegion region) {
		if (region == null)
			return string;
		int offsetFromEnd = ref.length() - (region.getOffset() + region.getLength());
		return string.substring(region.getOffset(), string.length() - offsetFromEnd);
	}

}
