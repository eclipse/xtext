package org.eclipse.xtend.ide.tests

import org.eclipse.xtext.junit4.IInjectorProvider
import org.eclipse.xtend.ide.internal.XtendActivator

class XtendIDEInjectorProvider implements IInjectorProvider {

	override getInjector() {
		XtendActivator::instance.getInjector(XtendActivator::ORG_ECLIPSE_XTEND_CORE_XTEND)
	}
	
}