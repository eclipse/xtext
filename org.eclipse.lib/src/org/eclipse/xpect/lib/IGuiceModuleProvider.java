package org.eclipse.xpect.lib;

import com.google.inject.Module;

public interface IGuiceModuleProvider {
	Module getRuntimeModule();

	Module getUIModule();
}
