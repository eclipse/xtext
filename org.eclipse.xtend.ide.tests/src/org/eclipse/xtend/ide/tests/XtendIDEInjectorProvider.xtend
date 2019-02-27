package org.eclipse.xtend.ide.tests

import org.eclipse.xtend.ide.internal.XtendActivator
import org.eclipse.xtext.testing.IInjectorProvider

class XtendIDEInjectorProvider implements IInjectorProvider {

	override getInjector() {
		XtendActivator::instance.getInjector(XtendActivator::ORG_ECLIPSE_XTEND_CORE_XTEND)
	}
	
}