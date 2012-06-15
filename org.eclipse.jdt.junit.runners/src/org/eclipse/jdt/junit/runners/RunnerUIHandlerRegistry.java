package org.eclipse.jdt.junit.runners;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.junit.model.ITestElement;


public class RunnerUIHandlerRegistry {

	public final static String UI_RUNNER_EXTENSION_POINT_ID = "org.eclipse.jdt.junit.runners.junitRunnerUI";
	public final static String RUNNER_CLASS = "runnerClass";
	public final static String HANDLER_CLASS = "handlerClass";

	private static Map<String, IRunnerUIHandler> handlers = new HashMap<String, IRunnerUIHandler>();

	public static IRunnerUIHandler getHandler(ITestElement element) {
		IType type = TypeUtil.findType(element);
		if (type != null) {
			String runner = TypeUtil.findRunner(type);
			if (runner != null)
				return RunnerUIHandlerRegistry.getHandler(runner);
		}
		return null;
	}

	public static IRunnerUIHandler getHandler(String runner) {
		IRunnerUIHandler cachedHandler = handlers.get(runner);
		if (cachedHandler != null)
			return cachedHandler;
		IConfigurationElement[] cfgs = Platform.getExtensionRegistry().getConfigurationElementsFor(UI_RUNNER_EXTENSION_POINT_ID);
		for (IConfigurationElement cfg : cfgs) {
			String runnerClass = cfg.getAttribute(RUNNER_CLASS);
			if (runner.equals(runnerClass)) {
				try {
					IRunnerUIHandler handler = (IRunnerUIHandler) cfg.createExecutableExtension(HANDLER_CLASS);
					handlers.put(runnerClass, handler);
					return handler;
				} catch (CoreException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return null;
	}

}
