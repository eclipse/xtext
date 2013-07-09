/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xpect.registry;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Factory;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.util.Modules2;
import org.xpect.registry.StandalonePluginXMLParser.EMFExtensionParserInfo;
import org.xpect.registry.StandalonePluginXMLParser.EMFGeneratedPackageInfo;
import org.xpect.registry.StandalonePluginXMLParser.EditorInfo;
import org.xpect.registry.StandalonePluginXMLParser.ExtensionInfo;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.Provider;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class StandaloneLanguageRegistry implements ILanguageInfo.Registry {

	protected static class EPackageDescriptorImpl implements EPackage.Descriptor {
		private final EMFGeneratedPackageInfo info;
		private EPackage pkg = null;

		public EPackageDescriptorImpl(EMFGeneratedPackageInfo info) {
			super();
			this.info = info;
		}

		public EFactory getEFactory() {
			if (pkg != null)
				return pkg.getEFactoryInstance();
			return null;
		}

		public EPackage getEPackage() {
			if (pkg == null)
				try {
					Class<?> clazz = ClassLoader.getSystemClassLoader().loadClass(info.getClazz());
					Field field = clazz.getField("eINSTANCE");
					pkg = (EPackage) field.get(null);
				} catch (ClassNotFoundException e) {
					throw new RuntimeException(e);
				} catch (IllegalAccessException e) {
					throw new RuntimeException(e);
				} catch (SecurityException e) {
					throw new RuntimeException(e);
				} catch (NoSuchFieldException e) {
					throw new RuntimeException(e);
				}
			return pkg;
		}

		public EMFGeneratedPackageInfo getInfo() {
			return info;
		}

	}

	protected static class ResourceFactoryDescriptorForEMF implements Resource.Factory.Descriptor {

		private final String clazz;
		private Factory factory;

		public ResourceFactoryDescriptorForEMF(String clazz) {
			super();
			this.clazz = clazz;
		}

		public Factory createFactory() {
			if (factory == null)
				try {
					factory = (Factory) ClassLoader.getSystemClassLoader().loadClass(clazz).newInstance();
				} catch (InstantiationException e) {
					throw new RuntimeException(e);
				} catch (IllegalAccessException e) {
					throw new RuntimeException(e);
				} catch (ClassNotFoundException e) {
					throw new RuntimeException(e);
				}
			return factory;
		}

		public String getClazz() {
			return clazz;
		}

	}

	protected static class ResourceFactoryDescriptorForXtext implements Resource.Factory.Descriptor {
		private final String clazz;
		private Factory factory;

		private final ILanguageInfo info;

		public ResourceFactoryDescriptorForXtext(ILanguageInfo info, String clazz) {
			this.clazz = clazz;
			this.info = info;
		}

		public Factory createFactory() {
			if (factory == null)
				try {
					Class<?> loaded = ClassLoader.getSystemClassLoader().loadClass(clazz);
					factory = (Factory) info.getInjector().getInstance(loaded);
				} catch (ClassNotFoundException e) {
					throw new RuntimeException(e);
				}
			return factory;
		}

		public String getClazz() {
			return clazz;
		}

		public ILanguageInfo getInfo() {
			return info;
		}

	}

	protected static class ResourceServiceProviderProviderImpl implements Provider<IResourceServiceProvider> {

		private final ILanguageInfo info;
		private IResourceServiceProvider provider;

		public ResourceServiceProviderProviderImpl(ILanguageInfo info) {
			super();
			this.info = info;
		}

		public IResourceServiceProvider get() {
			if (provider == null)
				provider = info.getInjector().getInstance(IResourceServiceProvider.class);
			return provider;
		}

		public ILanguageInfo getInfo() {
			return info;
		}
	}

	protected static class StandaloneLanguageInfoImpl extends AbstractLanguageInfo {
		public StandaloneLanguageInfoImpl(String rtLangName, String uiLangName, Set<String> fileExtensions) {
			super(rtLangName, uiLangName, fileExtensions);
		}

		protected Injector createInjector(Module... modules) {
			if (modules.length > 0)
				return Guice.createInjector(Modules2.mixin(getRuntimeModule(), Modules2.mixin(modules)));
			else
				return Guice.createInjector(getRuntimeModule());
		}

		protected Module getUIModule() {
			if (uiModule == null) {
				try {
					uiModule = (Module) getUIModuleClass().newInstance();
				} catch (InstantiationException e) {
					throw new RuntimeException(e);
				} catch (IllegalAccessException e) {
					throw new RuntimeException(e);
				}
			}
			return uiModule;
		}

		@Override
		protected Class<?> loadClass(String name) {
			try {
				return ClassLoader.getSystemClassLoader().loadClass(name);
			} catch (ClassNotFoundException e) {
				throw new RuntimeException(e);
			}
		}
	}

	private static final Logger LOG = Logger.getLogger(StandaloneLanguageRegistry.class);

	private static boolean running = false;

	private Map<String, ILanguageInfo> ext2language;

	private Map<String, ILanguageInfo> name2language;

	public StandaloneLanguageRegistry() {
		try {
			init();
		} catch (Throwable e) {
			LOG.error(e);
		}
	}

	public ILanguageInfo getLanguageByFileExtension(String fileExtension) {
		return ext2language.get(fileExtension);
	}

	public ILanguageInfo getLanguageByName(String name) {
		return name2language.get(name);
	}

	public Collection<ILanguageInfo> getLanguages() {
		return name2language.values();
	}

	protected void init() {
		ext2language = Maps.newHashMap();
		name2language = Maps.newHashMap();
		if (EcorePlugin.IS_ECLIPSE_RUNNING)
			throw new IllegalStateException("This class can only run in standalone mode (no OSGi, no Eclipse)");
		if (running)
			throw new IllegalStateException("I want to be a singleton!");
		running = true;
		List<ExtensionInfo> extensionInfos = new StandalonePluginXMLParser().parse();
		Multimap<String, EMFExtensionParserInfo> uiName2ExtParser = HashMultimap.create();
		Multimap<String, EditorInfo> uiName2Editor = HashMultimap.create();
		for (ExtensionInfo info : extensionInfos)
			if (info instanceof EditorInfo) {
				EditorInfo ei = (EditorInfo) info;
				uiName2Editor.put(ei.getUiLang(), ei);
			} else if (info instanceof EMFExtensionParserInfo) {
				EMFExtensionParserInfo parserInfo = (EMFExtensionParserInfo) info;
				if (parserInfo.getUiLangName() != null)
					uiName2ExtParser.put(parserInfo.getUiLangName(), parserInfo);
				else
					registerEFactoryWithoutInjector(parserInfo);
			} else if (info instanceof EMFGeneratedPackageInfo)
				registerEPackage((EMFGeneratedPackageInfo) info);
		for (String uiName : Sets.union(uiName2Editor.keySet(), uiName2ExtParser.keySet())) {
			Collection<EditorInfo> editors = uiName2Editor.get(uiName);
			Collection<EMFExtensionParserInfo> extParsers = uiName2ExtParser.get(uiName);
			ILanguageInfo info = registerEFactoryWithInjector(uiName, editors, extParsers);
			if (info != null) {
				name2language.put(info.getLanguageName(), info);
				for (String ext : info.getFileExtensions())
					ext2language.put(ext, info);
			}
		}
	}

	protected ILanguageInfo registerEFactoryWithInjector(String uiName, Collection<EditorInfo> editors,
			Collection<EMFExtensionParserInfo> parsers) {
		if (editors.size() > 0) {
			EditorInfo editor = editors.iterator().next();
			Map<String, String> extension2factory = Maps.newLinkedHashMap();
			for (EMFExtensionParserInfo info : parsers)
				extension2factory.put(info.getType(), info.getClazz());
			StandaloneLanguageInfoImpl impl = new StandaloneLanguageInfoImpl(editor.getRtLang(), uiName, extension2factory.keySet());
			for (Map.Entry<String, String> entry : extension2factory.entrySet()) {
				ResourceFactoryDescriptorForXtext descriptor = new ResourceFactoryDescriptorForXtext(impl, entry.getValue());
				Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(entry.getKey(), descriptor);
				ResourceServiceProviderProviderImpl provider = new ResourceServiceProviderProviderImpl(impl);
				IResourceServiceProvider.Registry.INSTANCE.getExtensionToFactoryMap().put(entry.getKey(), provider);
			}
			return impl;
		}
		return null;
	}

	protected void registerEFactoryWithoutInjector(EMFExtensionParserInfo info) {
		ResourceFactoryDescriptorForEMF descriptor = new ResourceFactoryDescriptorForEMF(info.getClazz());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(info.getType(), descriptor);
	}

	protected void registerEPackage(EMFGeneratedPackageInfo info) {
		EPackage.Registry.INSTANCE.put(info.getUri(), new EPackageDescriptorImpl(info));
		EcorePlugin.getEPackageNsURIToGenModelLocationMap().put(info.getUri(), URI.createURI(info.getGenModel()));
	}
}
