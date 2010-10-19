/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.interpreter.impl;

import org.eclipse.xtext.xbase.interpreter.IEvaluationContext;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class NullEvaluationContext implements IEvaluationContext {

	public Throwable getCurrentException() {
		return null;
	}

	public void setCurrentException(Throwable throwable) {
		throw new IllegalStateException("Current exception may not be propagated to null context.");
	}

	public Object getValue(String name) {
		return null;
	}

	public void newValue(String name, Object value) {
		throw new IllegalStateException("Cannot create new value in null context.");
	}

	public void assignValue(String name, Object value) {
		throw new IllegalStateException("Cannot assign a value in null context.");
	}

	public IEvaluationContext fork() {
		throw new IllegalStateException("Cannot fork a null context.");
	}

}
