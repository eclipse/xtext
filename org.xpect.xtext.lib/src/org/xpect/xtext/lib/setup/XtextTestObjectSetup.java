package org.xpect.xtext.lib.setup;

import org.xpect.XpectImport;
import org.xpect.XpectReplace;
import org.xpect.setup.ThisTestClass;
import org.xpect.setup.ThisTestObject;
import org.xpect.setup.ThisTestObject.TestObjectSetup;
import org.xpect.setup.XpectSetupFactory;
import org.xpect.state.Creates;

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
