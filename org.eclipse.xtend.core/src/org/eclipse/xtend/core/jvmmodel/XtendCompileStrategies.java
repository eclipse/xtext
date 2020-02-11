/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.jvmmodel;

import org.eclipse.xtend.core.xtend.CreateExtensionInfo;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable;
import org.eclipse.xtext.xbase.lib.Procedures;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class XtendCompileStrategies {

	@Inject
	private Provider<DispatchMethodCompileStrategy> dispatchMethodProvider;

	public Procedures.Procedure1<ITreeAppendable> forDispatcher(JvmOperation dispatchOperation) {
		DispatchMethodCompileStrategy strategy = dispatchMethodProvider.get();
		strategy.initialize(dispatchOperation);
		return strategy;
	}

	@Inject
	private Provider<CacheMethodCompileStrategy> cacheMethodProvider;

	public Procedures.Procedure1<ITreeAppendable> forCacheMethod(CreateExtensionInfo createExtensionInfo,
			JvmField cacheField, JvmOperation initializerMethod) {
		CacheMethodCompileStrategy strategy = cacheMethodProvider.get();
		strategy.init(createExtensionInfo, cacheField, initializerMethod);
		return strategy;
	}

	@Inject
	private Provider<CacheVariableCompileStrategy> cacheVarProvider;

	public Procedures.Procedure1<ITreeAppendable> forCacheVariable(XtendFunction function) {
		CacheVariableCompileStrategy strategy = cacheVarProvider.get();
		return strategy;
	}
}
