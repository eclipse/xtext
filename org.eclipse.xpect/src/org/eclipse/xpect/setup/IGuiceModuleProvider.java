package org.eclipse.xpect.setup;

import com.google.inject.Module;

public interface IGuiceModuleProvider {
	Module getRuntimeModule();

	Module getUIModule();
}
