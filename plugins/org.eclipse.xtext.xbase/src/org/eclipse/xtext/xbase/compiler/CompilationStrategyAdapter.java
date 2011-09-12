/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.compiler;

import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.xtext.xbase.lib.Functions;


/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class CompilationStrategyAdapter extends AdapterImpl {

	@Override
	public boolean isAdapterForType(Object type) {
		return type == CompilationStrategyAdapter.class;
	}
	
	private Functions.Function1<ImportManager, CharSequence> compilationStrategy;
	
	public Functions.Function1<ImportManager, CharSequence> getCompilationStrategy() {
		return compilationStrategy;
	}
	
	public void setCompilationStrategy(
			Functions.Function1<ImportManager, CharSequence> compilationStrategy) {
		this.compilationStrategy = compilationStrategy;
	}
}
