package org.eclipse.xtend.ide.tests

import org.eclipse.xtend.ide.internal.XtendActivator
import org.eclipse.xtext.testing.GlobalRegistries
import org.eclipse.xtext.testing.GlobalRegistries.GlobalStateMemento
import org.eclipse.xtext.testing.IInjectorProvider
import org.eclipse.xtext.testing.IRegistryConfigurator

class XtendIDEInjectorProvider implements IInjectorProvider, IRegistryConfigurator {

	protected GlobalStateMemento stateAfterInjectorCreation

	override getInjector() {
		val result = XtendActivator::instance.getInjector(XtendActivator::ORG_ECLIPSE_XTEND_CORE_XTEND)
		if (stateAfterInjectorCreation === null) {
			stateAfterInjectorCreation = GlobalRegistries.makeCopyOfGlobalState();
		}
		return result
	}

	override void restoreRegistry() {
		stateAfterInjectorCreation.restoreGlobalState();
	}

	override void setupRegistry() {
		if (stateAfterInjectorCreation === null) {
			getInjector()
		} else {
			stateAfterInjectorCreation.restoreGlobalState()
		}
	}

}
