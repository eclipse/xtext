package org.xpect.setup;

import com.google.inject.Module;

public interface IXpectGuiceModuleSetup extends IXpectSetup {
	Class<? extends Module> getModule();
}
