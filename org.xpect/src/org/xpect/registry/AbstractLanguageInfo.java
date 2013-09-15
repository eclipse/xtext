/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xpect.registry;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import com.google.inject.Injector;
import com.google.inject.Module;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public abstract class AbstractLanguageInfo implements ILanguageInfo {

	private final Set<String> fileExtensions;

	protected Injector injector;

	protected Map<List<Class<? extends Module>>, Injector> injectors = Maps.newHashMap();

	private final String rtLangName;

	protected Module runtimeModule = null;

	private final String uiLangName;

	protected Module uiModule = null;

	public AbstractLanguageInfo(String rtLangName, String uiLangName, Set<String> fileExtensions) {
		this.rtLangName = rtLangName;
		this.uiLangName = uiLangName;
		this.fileExtensions = fileExtensions;
	}

	protected abstract Injector createInjector(Module... modules);

	@Override
	public boolean equals(Object obj) {
		if (obj == null || obj.getClass() != getClass())
			return false;
		return rtLangName.equals(((AbstractLanguageInfo) obj).rtLangName);
	}

	public Set<String> getFileExtensions() {
		return fileExtensions;
	}

	public Injector getInjector() {
		if (injector == null)
			injector = createInjector();
		return injector;
	}

	public Injector getInjector(List<Class<? extends Module>> moduleClasses) {
		if (moduleClasses.isEmpty()) {
			return getInjector();
		} else {
			List<Class<? extends Module>> key = ImmutableList.copyOf(moduleClasses);
			Injector result = injectors.get(key);
			if (result != null)
				return result;
			Injector defaultInjector = getInjector();
			Module[] modules = new Module[moduleClasses.size()];
			for (int i = 0; i < moduleClasses.size(); i++)
				modules[i] = defaultInjector.getInstance(moduleClasses.get(i));
			result = createInjector(modules);
			injectors.put(key, result);
			return result;
		}
	}

	public String getLanguageName() {
		return rtLangName;
	}

	@SuppressWarnings("unchecked")
	public Class<? extends Module> getRuntimeModuleClass() {
		String className = rtLangName + "RuntimeModule";
		return (Class<? extends Module>) loadClass(className);
	}

	protected Module getRuntimeModule() {
		if (runtimeModule == null) {

			try {
				Class<? extends Module> clazz = getRuntimeModuleClass();
				runtimeModule = clazz.newInstance();
			} catch (InstantiationException e) {
				throw new RuntimeException(e);
			} catch (IllegalAccessException e) {
				throw new RuntimeException(e);
			}
		}
		return runtimeModule;
	}

	public String getUiLangName() {
		return uiLangName;
	}

	@SuppressWarnings("unchecked")
	public Class<? extends Module> getUIModuleClass() {
		String className = uiLangName + "UiModule";
		return (Class<? extends Module>) loadClass(className);
	}

	@Override
	public int hashCode() {
		return rtLangName.hashCode();
	}

	protected abstract Class<?> loadClass(String name);

}
