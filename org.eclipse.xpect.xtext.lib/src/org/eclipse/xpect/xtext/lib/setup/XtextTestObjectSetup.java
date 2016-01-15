package org.eclipse.xpect.xtext.lib.setup;

import org.eclipse.xpect.XpectImport;
import org.eclipse.xpect.XpectReplace;
import org.eclipse.xpect.setup.ThisTestClass;
import org.eclipse.xpect.setup.ThisTestObject;
import org.eclipse.xpect.setup.ThisTestObject.TestObjectSetup;
import org.eclipse.xpect.setup.XpectSetupFactory;
import org.eclipse.xpect.state.Creates;

import com.google.inject.Injector;

@XpectSetupFactory
@XpectImport(InjectorSetup.class)
@XpectReplace(TestObjectSetup.class)
public class XtextTestObjectSetup extends TestObjectSetup {

	private final Injector injector;

	public XtextTestObjectSetup(@ThisTestClass Class<?> testClass, Injector injector) {
		super(testClass);
		this.injector = injector;
	}

	@Creates(ThisTestObject.class)
	public Object createTestInstance() throws InstantiationException, IllegalAccessException {
		return injector.getInstance(getTestClass());
	}

}
