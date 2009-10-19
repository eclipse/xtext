/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.google.common.collect.Lists;
import com.google.inject.Binder;
import com.google.inject.Module;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class CompoundModule implements Module {

	private static Logger LOGGER = Logger.getLogger(CompoundModule.class);
	
	private List<Module> modules;

	public CompoundModule() {
		modules = Lists.newArrayList();
	}
	
	public void configure(Binder binder) {
		for (Module module : modules) {
			try {
				module.configure(binder);
			} catch(Exception e) {
				LOGGER.warn(e.getMessage(), e);
			}
		}
	}

	public void add(Module module) {
		modules.add(module);
	}
	
	public void remove(Module module) {
		modules.remove(module);
	}
	
	public boolean isConfigured(Class<?> from, Object to, boolean singleton, boolean eagerSingleton, boolean provider) {
		for(Module module: modules) {
			if (module instanceof MethodBasedModule) {
				if (((MethodBasedModule) module).isConfigured(from, to, singleton, eagerSingleton, provider))
					return true;
			}
		}
		return false;
	}
	
	public int size() {
		return modules.size();
	}
}
