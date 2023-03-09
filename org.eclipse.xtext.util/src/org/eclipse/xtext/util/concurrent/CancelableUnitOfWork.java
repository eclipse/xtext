/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.util.concurrent;

import org.eclipse.xtext.util.CancelIndicator;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.7
 */
public abstract class CancelableUnitOfWork<R,P> implements IUnitOfWork<R, P> {
	
	private CancelIndicator cancelIndicator;

	public void setCancelIndicator(CancelIndicator cancelIndicator) {
		this.cancelIndicator = cancelIndicator;
	}
	
	@Override
	public R exec(P state) throws Exception {
		return exec(state, cancelIndicator);
	}

	public abstract R exec(P state, CancelIndicator cancelIndicator) throws Exception;
}
