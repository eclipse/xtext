package org.eclipse.jdt.junit.runners;

import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.core.runtime.ListenerList;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.internal.junit.model.ITestSessionListener;
import org.eclipse.jdt.internal.junit.model.TestCaseElement;
import org.eclipse.jdt.internal.junit.model.TestElement;
import org.eclipse.jdt.internal.junit.model.TestElement.Status;
import org.eclipse.jdt.internal.junit.model.TestRunSession;
import org.eclipse.jdt.junit.model.ITestElement;

@SuppressWarnings("restriction")
public class RunnerFinder {

	private static class Cache implements ITestSessionListener {

		private Map<String, String> suiteToRunner = new LinkedHashMap<String, String>();
		private Map<String, String> idToRunner = new LinkedHashMap<String, String>();

		public String getRunner(ITestElement element) {
			String id = ((TestElement) element).getId();
			if (idToRunner.containsKey(id))
				return idToRunner.get(id);
			ITestElement current = element;
			while (current != null) {
				String name = TypeUtil.getTypeName(current);
				if (name != null) {
					if (suiteToRunner.containsKey(name)) {
						String result = suiteToRunner.get(name);
						idToRunner.put(id, result);
						return result;
					}
					String result = findRunner(element.getTestRunSession().getLaunchedProject(), name);
					idToRunner.put(id, result);
					suiteToRunner.put(name, result);
					return result;
				}
				current = current.getParentContainer();
			}
			return null;
		}

		private String findRunner(IJavaProject project, String className) {
			IType type = TypeUtil.findType(project, className);
			if (type != null)
				return RunnerUtil.findRunner(type);
			return null;
		}

		@Override
		public void sessionStarted() {
		}

		@Override
		public void sessionEnded(long elapsedTime) {
		}

		@Override
		public void sessionStopped(long elapsedTime) {
		}

		@Override
		public void sessionTerminated() {
		}

		@Override
		public void testAdded(TestElement testElement) {
		}

		@Override
		public void runningBegins() {
		}

		@Override
		public void testStarted(TestCaseElement testCaseElement) {
		}

		@Override
		public void testEnded(TestCaseElement testCaseElement) {
		}

		@Override
		public void testFailed(TestElement testElement, Status status, String trace, String expected, String actual) {
		}

		@Override
		public void testReran(TestCaseElement testCaseElement, Status status, String trace, String expectedResult, String actualResult) {
		}

		@Override
		public boolean acceptsSwapToDisk() {
			idToRunner.clear();
			suiteToRunner.clear();
			return true;
		}
	}

	public static String getRunner(ITestElement element) {
		TestRunSession session = (TestRunSession) element.getTestRunSession();
		ListenerList listeners = ReflectionUtil.readField(TestRunSession.class, session, "fSessionListeners", ListenerList.class);
		for (Object obj : listeners.getListeners())
			if (obj instanceof Cache) {
				return ((Cache) obj).getRunner(element);
			}
		Cache cache = new Cache();
		session.addTestSessionListener(cache);
		return cache.getRunner(element);
	}
}
