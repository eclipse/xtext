package org.xpect.ui.util;

import java.util.List;

import org.xpect.XtRuntimeModule;
import org.xpect.ui.XtUIModule;
import org.xpect.util.EnvironmentUtil;
import org.xpect.util.IXtInjectorProvider.RuntimeXtInjectorProvider;

import com.google.inject.Module;

public class UIXtInjectorProvider extends RuntimeXtInjectorProvider {

	@Override
	protected void collectBuiltinModules(List<Class<? extends Module>> moduleClasses) {
		switch (EnvironmentUtil.ENVIRONMENT) {
		case STANDALONE_TEST:
			moduleClasses.add(XtRuntimeModule.class);
			break;
		case PLUGIN_TEST:
			moduleClasses.add(XtRuntimeModule.class);
			moduleClasses.add(XtUIModule.class);
			break;
		case WORKBENCH:
			moduleClasses.add(XtRuntimeModule.class);
			moduleClasses.add(XtUIModule.class);
			break;
		}
	}
}
