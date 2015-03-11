/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.linking;

import java.util.List;

import org.eclipse.xtend.core.tests.RuntimeInjectorProvider;
import org.eclipse.xtend.core.tests.RuntimeTestSetup;
import org.eclipse.xtend.core.typesystem.XtendTypeComputer;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.typesystem.computation.ILinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeComputer;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class RuntimeInjectorProviderWithReversedCandidates extends RuntimeInjectorProvider {
	@Override
	protected Injector internalCreateInjector() {
	    return new RuntimeTestSetup() {
	    	@Override
	    	public Injector createInjector() {
	    		return Guice.createInjector(new XtendRuntimeTestModule() {
	    			@Override
					public Class<? extends ITypeComputer> bindITypeComputer() {
	    				return XtendTypeComputerWithReversedCandidates.class;
	    			}
	    		});
	    	}
	    	
	    }.createInjectorAndDoEMFRegistration();
	}
	
	public static class XtendTypeComputerWithReversedCandidates extends XtendTypeComputer {
		@Override
		protected ILinkingCandidate getBestCandidate(List<? extends ILinkingCandidate> candidates) {
			return super.getBestCandidate(ListExtensions.reverseView(candidates));
		}
	}
}