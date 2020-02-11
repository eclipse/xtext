/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.validation;

import org.eclipse.xtext.xbase.XExpression;

import com.google.inject.ImplementedBy;

/**
 * @author Stefan Oehme - Initial contribution and API
 */
@ImplementedBy(XbaseImplicitReturnFinder.class)
public interface ImplicitReturnFinder {

	void findImplicitReturns(XExpression expression, Acceptor acceptor);

	/**
	 * @author Stefan Oehme - Initial contribution and API
	 */
	public interface Acceptor {
		void accept(XExpression implicitReturn);
	}
}
