/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xpect.ui.registry;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.osgi.framework.internal.core.BundleContextImpl;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.util.Modules2;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.xpect.registry.AbstractLanguageInfo;
import org.xpect.registry.IEmfFileExtensionInfo;
import org.xpect.registry.IEmfFileExtensionInfo.IXtextFileExtensionInfo;
import org.xpect.registry.ILanguageInfo;
import org.xpect.util.ReflectionUtil;

import com.google.common.collect.Maps;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@SuppressWarnings("restriction")
public class UILanugageRegistry implements ILanguageInfo.Registry {

	public static class UILanguageInfo extends AbstractLanguageInfo {

		public UILanguageInfo(IXtextFileExtensionInfo info) {
			super(info);
		}

		@Override
		protected Injector createInjector(Module... modules) {
			if (modules.length == 0) {
				URI uri = URI.createURI("*." + getFileExtensions().iterator().next());
				IResourceServiceProvider provider = IResourceServiceProvider.Registry.INSTANCE.getResourceServiceProvider(uri);
				return provider.get(Injector.class);
			} else {
				Module runtimeModule = getRuntimeModule();
				Module sharedStateModule = getSharedStateModule();
				Module uiModule = getUIModule();
				Module override = Modules2.mixin(modules);
				return Guice.createInjector(Modules2.mixin(runtimeModule, sharedStateModule, uiModule, override));
			}
		}

		protected Module getUIModule() {
			if (uiModule == null) {
				try {
					Class<? extends Module> uiModuleClass = getUIModuleClass();
					Bundle bundle = FrameworkUtil.getBundle(uiModuleClass);
					Plugin plugin = ReflectionUtil.readField(BundleContextImpl.class, bundle.getBundleContext(), "activator", Plugin.class);
					if (plugin == null)
						throw new IllegalStateException("Could not access Activator of bundle '" + bundle.getBundleId() + "'. ");
					Constructor<?> constructor = uiModuleClass.getConstructor(AbstractUIPlugin.class);
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

	}

	private static final Logger LOG = Logger.getLogger(UILanugageRegistry.class);

	public UILanugageRegistry() {
		try {
			init();
		} catch (Throwable e) {
			LOG.error("Error initalizing language registry", e);
		}
	}

	private void init() {
		for (IEmfFileExtensionInfo info : IEmfFileExtensionInfo.Registry.INSTANCE.getFileExtensionInfos()) {
			if (info instanceof IXtextFileExtensionInfo) {
				UILanguageInfo infoImpl = new UILanguageInfo((IXtextFileExtensionInfo) info);
				name2language.put(infoImpl.getLanguageName(), infoImpl);
				for (String ext : info.getFileExtensions())
					fileExtension2language.put(ext, infoImpl);
			}
		}
	}

	protected Map<String, ILanguageInfo> fileExtension2language = Maps.newLinkedHashMap();

	protected Map<String, ILanguageInfo> name2language = Maps.newLinkedHashMap();

	public ILanguageInfo getLanguageByFileExtension(String fileExtension) {
		return fileExtension2language.get(fileExtension);
	}

	public ILanguageInfo getLanguageByName(String name) {
		return name2language.get(name);
	}

	public Collection<ILanguageInfo> getLanguages() {
		return name2language.values();
	}

}
