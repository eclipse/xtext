/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
