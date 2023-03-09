/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.interpreter.impl;

import java.util.Map;

import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.xbase.interpreter.IEvaluationContext;

import com.google.common.collect.Maps;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class DefaultEvaluationContext implements IEvaluationContext {

	private IEvaluationContext parent;
	private Map<QualifiedName, Object> values;
	
	public DefaultEvaluationContext() {
		this(new NullEvaluationContext());
	}
	
	public DefaultEvaluationContext(IEvaluationContext parent) {
		this.parent = parent;
	}

	@Override
	public Object getValue(QualifiedName qualifiedName) {
		if (values != null && values.containsKey(qualifiedName))
			return values.get(qualifiedName);
		return parent.getValue(qualifiedName);
	}

	@Override
	public void newValue(QualifiedName qualifiedName, Object value) {
		if (values == null)
			values = Maps.newHashMap();
		if (values.containsKey(qualifiedName))
			throw new IllegalStateException("Cannot create a duplicate value '" + qualifiedName + "'.");
		values.put(qualifiedName, value);
	}
	
	@Override
	public void assignValue(QualifiedName qualifiedName, Object value) {
		if (values == null || !values.containsKey(qualifiedName))
			parent.assignValue(qualifiedName, value);
		else
			values.put(qualifiedName, value);
	}

	@Override
	public IEvaluationContext fork() {
		return new DefaultEvaluationContext(this);
	}
	
}
