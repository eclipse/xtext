/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.xtend;

import static org.eclipse.xtext.util.Tuples.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.internal.xtend.type.impl.java.JavaBeansMetaModel;
import org.eclipse.xtend.expression.ExecutionContextImpl;
import org.eclipse.xtend.expression.ResourceManager;
import org.eclipse.xtend.expression.TypeSystemImpl;
import org.eclipse.xtend.expression.Variable;
import org.eclipse.xtend.typesystem.emf.EmfRegistryMetaModel;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.scoping.IScopeProvider;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Sven Efftinge - Initial contribution and API
 *
 */
@Singleton
public class InjectableExecutionContext extends ExecutionContextImpl {
	
	private static final String GRAMMAR_ACCESS_VAR_NAME = "grammarAccess";
	private static final String SCOPE_PROVIDER_VAR_NAME = "scopeProvider";
	
	@SuppressWarnings("unchecked")
	@Inject
	public InjectableExecutionContext(ResourceManager resourceManager, IScopeProvider scopeProvider, IGrammarAccess grammarAccess) {
		super(resourceManager, new TypeSystemImpl(), toGlobalVarMap(toMap(pair(SCOPE_PROVIDER_VAR_NAME,(Object)scopeProvider),pair(GRAMMAR_ACCESS_VAR_NAME,(Object)grammarAccess))));
		registerMetaModel(new EmfRegistryMetaModel());
		registerMetaModel(new JavaBeansMetaModel());
	}

	/**
	 * @param globalVars
	 * @return
	 */
	private static Map<String, Variable> toGlobalVarMap(Map<String, ? extends Object> globalVars) {
		Map<String , Variable> result = new HashMap<String, Variable>();
		for (Entry<String, ? extends Object> globalVar: globalVars.entrySet()) {
			result.put(globalVar.getKey(), new Variable(globalVar.getKey(),globalVar.getValue()));
		}
		return result;
	}
	
}
