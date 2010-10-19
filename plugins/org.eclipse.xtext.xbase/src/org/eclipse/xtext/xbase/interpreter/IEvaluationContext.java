/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.interpreter;

public interface IEvaluationContext {
	Throwable getCurrentException();
	void setCurrentException(Throwable throwable);
	Object getValue(String name);
	void newValue(String name, Object value);
	void assignValue(String name, Object value);
	IEvaluationContext fork();
}