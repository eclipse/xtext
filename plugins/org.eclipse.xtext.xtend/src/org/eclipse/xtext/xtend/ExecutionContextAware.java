/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.xtend;

import org.eclipse.xtend.expression.ExecutionContext;

import com.google.common.base.Function;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Sven Efftinge - Initial contribution and API
 *
 */
public class ExecutionContextAware {
	private Provider<ExecutionContext> execProv;
	
	@Inject
	public ExecutionContextAware(Provider<ExecutionContext> execProv) {
		super();
		this.execProv = execProv;
	}
	
	private ThreadLocal<ExecutionContext> current = new ThreadLocal<ExecutionContext>();
	private ThreadLocal<Integer> numberOfUsers = new ThreadLocal<Integer>();
	
	public <T> T exec(Function<ExecutionContext,T> func) {
		try {
			final ExecutionContext ctx = getContext();
			return func.apply(ctx);
		} finally {
			dispose();
		}
	}
	
	private ExecutionContext getContext() {
		if (current.get()==null) {
			current.set(execProv.get());
			numberOfUsers.set(0);
		}
		numberOfUsers.set(numberOfUsers.get()+1);
		return current.get();
	}
	
	private void dispose() {
		Integer integer = numberOfUsers.get()-1;
		if (integer.intValue() == 0) {
			current.set(null);
		} else {
			numberOfUsers.set(integer);
		}
	}
	
}
