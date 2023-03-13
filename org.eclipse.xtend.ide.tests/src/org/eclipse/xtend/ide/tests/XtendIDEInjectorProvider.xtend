/*******************************************************************************
 * Copyright (c) 2013, 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.tests

import org.eclipse.xtend.ide.internal.XtendActivator
import org.eclipse.xtext.testing.IInjectorProvider

class XtendIDEInjectorProvider implements IInjectorProvider {

	override getInjector() {
		XtendActivator::instance.getInjector(XtendActivator::ORG_ECLIPSE_XTEND_CORE_XTEND)
	}
	
}