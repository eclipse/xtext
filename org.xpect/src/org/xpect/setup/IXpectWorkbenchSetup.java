package org.xpect.setup;

import com.google.inject.Module;

public interface IXpectWorkbenchSetup extends IXpectSetup {
	Module getModule();
}
