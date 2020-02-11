/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.validation

import org.eclipse.xtend.core.xtend.AnonymousClass
import org.eclipse.xtend.core.xtend.RichString
import org.eclipse.xtext.xbase.validation.XbaseImplicitReturnFinder

/**
 * @author Stefan Oehme - Initial contribution and API
 */
class XtendImplicitReturnFinder extends XbaseImplicitReturnFinder {

	def dispatch findImplicitReturns(AnonymousClass expression, Acceptor acceptor) {
		acceptor.accept(expression)
	}

	def dispatch findImplicitReturns(RichString expression, Acceptor acceptor) {
		acceptor.accept(expression)
	}

}
