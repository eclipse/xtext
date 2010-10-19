/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.interpreter.impl;

import java.util.Map;

import org.eclipse.xtext.xbase.interpreter.IEvaluationContext;

import com.google.common.collect.Maps;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class DefaultEvaluationContext implements IEvaluationContext {

	private IEvaluationContext parent;
	private Throwable currentException;
	private Map<String, Object> values;
	
	public DefaultEvaluationContext() {
		this(new NullEvaluationContext());
	}
	
	public DefaultEvaluationContext(IEvaluationContext parent) {
		this.parent = parent;
	}

	public Throwable getCurrentException() {
		return currentException;
	}

	public void setCurrentException(Throwable throwable) {
		this.currentException = throwable;
	}

	public Object getValue(String name) {
		if (values != null && values.containsKey(name))
			return values.get(name);
		return parent.getValue(name);
	}

	public void newValue(String name, Object value) {
		if (values == null)
			values = Maps.newHashMap();
		if (values.containsKey(name))
			throw new IllegalStateException("Cannot create a duplicate value '" + name + "'.");
		values.put(name, value);
	}
	
	public void assignValue(String name, Object value) {
		if (values == null || !values.containsKey(name))
			parent.assignValue(name, value);
		else
			values.put(name, value);
	}

	public IEvaluationContext fork() {
		return new DefaultEvaluationContext(this);
	}
	
}
