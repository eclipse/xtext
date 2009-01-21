/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.common.xtend;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.mwe.core.resources.ResourceLoader;
import org.eclipse.emf.mwe.core.resources.ResourceLoaderFactory;
import org.eclipse.emf.mwe.core.resources.ResourceLoaderImpl;
import org.eclipse.internal.xtend.type.impl.java.JavaBeansMetaModel;
import org.eclipse.xtend.XtendFacade;
import org.eclipse.xtend.expression.ExecutionContext;
import org.eclipse.xtend.expression.ExecutionContextImpl;
import org.eclipse.xtend.expression.TypeSystemImpl;
import org.eclipse.xtend.expression.Variable;
import org.eclipse.xtend.typesystem.emf.EmfRegistryMetaModel;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.IMetamodelAccess;
import org.eclipse.xtext.crossref.IScopeProvider;
import org.eclipse.xtext.service.Inject;

/**
 * Super class for Xtend based services. Registers Xtext services as global
 * variables in the execution context, making them accessible from within Xtend.
 * 
 * @author Jan Köhnlein - Initial contribution and API
 */
public abstract class AbstractXtendService {

	@Inject
	protected IGrammarAccess grammarAccess;

	@Inject
	protected IMetamodelAccess metamodelAccess;

	@Inject
	protected IScopeProvider scopeProvider;

	private static final String GRAMMAR_ACCESS_VAR_NAME = "grammarAccess";
	private static final String METAMODEL_ACCESS_VAR_NAME = "metamodelAccess";
	private static final String SCOPE_PROVIDER_VAR_NAME = "scopeProvider";

	protected ExecutionContext createExecutionContext() {
		TypeSystemImpl typeSystem = new TypeSystemImpl();
		typeSystem.registerMetaModel(new EmfRegistryMetaModel());
		typeSystem.registerMetaModel(new JavaBeansMetaModel());
		ExecutionContext executionContext = new ExecutionContextImpl(typeSystem, createGlobalVars());
		return executionContext;
	}

	protected Map<String, Variable> createGlobalVars() {
		Map<String, Variable> globalVars = new HashMap<String, Variable>();
		addServiceGlobalVar(globalVars, GRAMMAR_ACCESS_VAR_NAME, grammarAccess);
		addServiceGlobalVar(globalVars, METAMODEL_ACCESS_VAR_NAME, metamodelAccess);
		addServiceGlobalVar(globalVars, SCOPE_PROVIDER_VAR_NAME, scopeProvider);
		return globalVars;
	}

	protected void addServiceGlobalVar(Map<String, Variable> globalVars, String variableName, Object service) {
		Variable variable = new Variable(variableName, service);
		globalVars.put(variableName, variable);
	}

	/**
	 * Subclasses should override this to return the right classloader that is
	 * able to locate the Xtend files.
	 * 
	 * @return the classloader of the grammarAccess.
	 */
	protected ClassLoader getClassLoader() {
		return grammarAccess.getClass().getClassLoader();
	}

	/**
	 * Returns the fully qualified name of the xtend file containing the
	 * extensions to be called.
	 * 
	 * @return
	 */
	protected abstract String getMasterXtendFileName();

	protected Object invokeExtension(String extensionName, List<?> parameterValues) throws NoSuchExtensionException {
		ResourceLoader oldResourceLoader = ResourceLoaderFactory.createResourceLoader();
		try {
			ResourceLoaderFactory.setCurrentThreadResourceLoader(new ResourceLoaderImpl(getClassLoader()));
			ExecutionContext executionContext = createExecutionContext();
			XtendFacade facade = XtendFacade.create(executionContext, getMasterXtendFileName());
			if (!facade.hasExtension(extensionName, parameterValues)) {
				throw new NoSuchExtensionException(extensionName, parameterValues);
			}
			Object result = facade.call(extensionName, parameterValues);
			return result;
		}
		finally {
			ResourceLoaderFactory.setCurrentThreadResourceLoader(oldResourceLoader);
		}
	}

	public String toXtendFQName(String fqName) {
		return fqName.replaceAll("\\.", "::");
	}
}
