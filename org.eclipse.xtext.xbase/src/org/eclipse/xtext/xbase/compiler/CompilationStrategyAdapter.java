/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.compiler;

import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable;
import org.eclipse.xtext.xbase.lib.Procedures;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class CompilationStrategyAdapter extends AdapterImpl {

	@Override
	public boolean isAdapterForType(Object type) {
		return type == CompilationStrategyAdapter.class;
	}
	
	private Procedures.Procedure1<ITreeAppendable> compilationStrategy;
	
	public Procedures.Procedure1<ITreeAppendable> getCompilationStrategy() {
		return compilationStrategy;
	}
	
	public void setCompilationStrategy(Procedures.Procedure1<ITreeAppendable> compilationStrategy) {
		this.compilationStrategy = compilationStrategy;
	}
}
