package org.xpect.registry;

import java.util.Map;
import java.util.Set;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.inject.Injector;
import com.google.inject.Module;

public abstract class AbstractLanguageInfo implements ILanguageInfo {

	private final Set<String> fileExtensions;

	protected Injector injector;

	protected Map<Set<Class<? extends Module>>, Injector> injectors = Maps.newHashMap();

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

	@Override
	public Set<String> getFileExtensions() {
		return fileExtensions;
	}

	@Override
	public Injector getInjector(Module... modules) {
		if (modules.length == 0) {
			if (injector == null)
				injector = createInjector();
			return injector;
		} else {
			Set<Class<? extends Module>> key = Sets.newHashSetWithExpectedSize(modules.length);
			for (Module m : modules) {
				key.add(m.getClass());
			}
			Injector result = injectors.get(key);
			if (result == null) {
				result = createInjector(modules);
				injectors.put(key, result);
			}
			return result;
		}
	}

	@Override
	public String getLanguageName() {
		return rtLangName;
	}

	protected Module getRuntimeModule() {
		if (runtimeModule == null) {
			String className = rtLangName + "RuntimeModule";
			try {
				Class<?> clazz = loadClass(className);
				runtimeModule = (Module) clazz.newInstance();
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

	protected Class<?> getUIModuleClass() {
		String className = uiLangName + "UiModule";
		return loadClass(className);
	}

	@Override
	public int hashCode() {
		return rtLangName.hashCode();
	}

	protected abstract Class<?> loadClass(String name);

}
