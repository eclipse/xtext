/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.interpreter.impl;

import org.eclipse.xtext.xbase.interpreter.IEvaluationResult;


/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class DefaultEvaluationResult implements IEvaluationResult {

	private final Object result;
	private final Throwable throwable;

	public DefaultEvaluationResult(Object result, Throwable throwable) {
		this.result = result;
		this.throwable = throwable;
	}
	
	@Override
	public Throwable getException() {
		return throwable;
	}

	@Override
	public Object getResult() {
		return result;
	}

}
