package org.eclipse.xpect.lib;

import java.util.List;

import org.junit.runner.Description;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.ParentRunner;
import org.junit.runners.model.InitializationError;

public class XpectRunner extends ParentRunner<Object> {

	protected XpectRunner(Class<?> testClass) throws InitializationError {
		super(testClass);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected List<Object> getChildren() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Description describeChild(Object child) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void runChild(Object child, RunNotifier notifier) {
		// TODO Auto-generated method stub
		
	}

}
