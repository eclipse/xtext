/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.interpreter;

import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.xbase.interpreter.impl.DefaultEvaluationContext;

import com.google.inject.ImplementedBy;

@ImplementedBy(DefaultEvaluationContext.class)
public interface IEvaluationContext {
	Object getValue(QualifiedName qualifiedName);
	void newValue(QualifiedName qualifiedName, Object value);
	void assignValue(QualifiedName qualifiedName, Object value);
	IEvaluationContext fork();
}