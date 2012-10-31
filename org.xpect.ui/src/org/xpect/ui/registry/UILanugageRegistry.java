package org.xpect.ui.registry;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.ui.shared.SharedStateModule;
import org.eclipse.xtext.util.Modules2;
import org.osgi.framework.Bundle;
import org.xpect.registry.AbstractLanguageInfo;
import org.xpect.registry.ILanguageInfo;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class UILanugageRegistry implements ILanguageInfo.Registry {

	public static class UILanguageInfo extends AbstractLanguageInfo {

		private final String bundleID;

		public UILanguageInfo(String bundleID, String rtLangName, String uiLangName, Set<String> fileExtensions) {
			super(rtLangName, uiLangName, fileExtensions);
			this.bundleID = bundleID;
		}

		@Override
		protected Injector createInjector(Module... modules) {
			if (modules.length == 0) {
				URI uri = URI.createURI("*." + getFileExtensions().iterator().next());
				IResourceServiceProvider provider = IResourceServiceProvider.Registry.INSTANCE.getResourceServiceProvider(uri);
				return provider.get(Injector.class);
			} else {
				Module runtimeModule = getRuntimeModule();
				Module sharedStateModule = new SharedStateModule();
				Module uiModule = getUIModule();
				Module override = Modules2.mixin(modules);
				return Guice.createInjector(Modules2.mixin(runtimeModule, sharedStateModule, uiModule, override));
			}
		}

		public String getBundleID() {
			return bundleID;
		}

		protected Module getUIModule() {
			if (uiModule == null) {
				try {
					@SuppressWarnings("deprecation")
					Plugin plugin = Platform.getPlugin(bundleID);
					Constructor<?> constructor = getUIModuleClass().getConstructor(AbstractUIPlugin.class);
					uiModule = (Module) constructor.newInstance(plugin);
				} catch (InstantiationException e) {
					throw new RuntimeException(e);
				} catch (IllegalAccessException e) {
					throw new RuntimeException(e);
				} catch (IllegalArgumentException e) {
					throw new RuntimeException(e);
				} catch (InvocationTargetException e) {
					throw new RuntimeException(e);
				} catch (SecurityException e) {
					throw new RuntimeException(e);
				} catch (NoSuchMethodException e) {
					throw new RuntimeException(e);
				}
			}
			return uiModule;
		}

		@Override
		protected Class<?> loadClass(String name) {
			try {
				Bundle bundle = Platform.getBundle(bundleID);
				return bundle.loadClass(name);
			} catch (ClassNotFoundException e) {
				throw new RuntimeException(e);
			}
		}
	}

	protected Map<String, ILanguageInfo> fileExtension2language = Maps.newLinkedHashMap();

	protected Map<String, ILanguageInfo> name2language = Maps.newLinkedHashMap();

	public void addLanguage(String bundleID, String rtLangName, String uiLangName, String[] fileExtensions) {
		UILanguageInfo info = (UILanguageInfo) name2language.get(rtLangName);
		if (info == null) {
			info = new UILanguageInfo(bundleID, rtLangName, uiLangName, Sets.newHashSet(fileExtensions));
			name2language.put(rtLangName, info);
		} else {
			info.getFileExtensions().addAll(Sets.newHashSet(fileExtensions));
		}
		for (String ext : fileExtensions)
			fileExtension2language.put(ext, info);
	}

	@Override
	public ILanguageInfo getLanguageByFileExtension(String fileExtension) {
		return fileExtension2language.get(fileExtension);
	}

	@Override
	public ILanguageInfo getLanguageByName(String name) {
		return name2language.get(name);
	}

	@Override
	public Collection<ILanguageInfo> getLanguages() {
		return name2language.values();
	}

	public void removeLanguage(String language, String[] fileExtensions) {
		UILanguageInfo info = (UILanguageInfo) name2language.get(language);
		if (info != null) {
			info.getFileExtensions().removeAll(Sets.newHashSet(fileExtensions));
			if (info.getFileExtensions().isEmpty())
				name2language.remove(language);
		}
		for (String ext : fileExtensions)
			fileExtension2language.remove(ext);
	}
}
