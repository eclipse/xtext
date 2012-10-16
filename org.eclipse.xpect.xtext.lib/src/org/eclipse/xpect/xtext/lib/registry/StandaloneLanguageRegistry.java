package org.eclipse.xpect.xtext.lib.registry;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Factory;
import org.eclipse.xpect.xtext.lib.registry.StandalonePluginXMLParser.EMFExtensionParserInfo;
import org.eclipse.xpect.xtext.lib.registry.StandalonePluginXMLParser.EMFGeneratedPackageInfo;
import org.eclipse.xpect.xtext.lib.registry.StandalonePluginXMLParser.ExtensionInfo;
import org.eclipse.xtext.resource.IResourceServiceProvider;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.Provider;

public class StandaloneLanguageRegistry implements ILanguageInfo.Registry {

	protected static class EPackageDescriptorImpl implements EPackage.Descriptor {
		private final EMFGeneratedPackageInfo info;
		private EPackage pkg = null;

		public EPackageDescriptorImpl(EMFGeneratedPackageInfo info) {
			super();
			this.info = info;
		}

		@Override
		public EFactory getEFactory() {
			if (pkg != null)
				return pkg.getEFactoryInstance();
			return null;
		}

		@Override
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

		@Override
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

		@Override
		public Factory createFactory() {
			if (factory == null)
				try {
					Class<?> loaded = ClassLoader.getSystemClassLoader().loadClass(clazz);
					factory = (Factory) info.getDefaultInjector().getInstance(loaded);
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

		@Override
		public IResourceServiceProvider get() {
			if (provider == null)
				provider = info.getDefaultInjector().getInstance(IResourceServiceProvider.class);
			return provider;
		}

		public ILanguageInfo getInfo() {
			return info;
		}
	}

	protected static class StandaloneLanguageInfoImpl implements ILanguageInfo {

		private final List<String> fileExtensions;

		protected Injector injector;

		private final String language;

		protected Module runtimeModule = null;

		public StandaloneLanguageInfoImpl(String language, List<String> fileExtensions) {
			super();
			this.language = language;
			this.fileExtensions = fileExtensions;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj == null || obj.getClass() != getClass())
				return false;
			return language.equals(((StandaloneLanguageInfoImpl) obj).language);
		}

		@Override
		public Injector getDefaultInjector() {
			if (injector == null)
				injector = Guice.createInjector(getRuntimeModule());
			return injector;
		}

		@Override
		public List<String> getFileExtensions() {
			return fileExtensions;
		}

		@Override
		public String getLanguageName() {
			return language;
		}

		@Override
		public Module getRuntimeModule() {
			if (runtimeModule == null) {
				String className = getLanguageName() + "RuntimeModule";
				try {
					Class<?> clazz = ClassLoader.getSystemClassLoader().loadClass(className);
					runtimeModule = (Module) clazz.newInstance();
				} catch (ClassNotFoundException e) {
					throw new RuntimeException(e);
				} catch (InstantiationException e) {
					throw new RuntimeException(e);
				} catch (IllegalAccessException e) {
					throw new RuntimeException(e);
				}
			}
			return runtimeModule;
		}

		@Override
		public Module getUIModule() {
			throw new IllegalStateException("The UI-Module is not availabe in a standalone environment.");
		}

		@Override
		public int hashCode() {
			return language.hashCode();
		}
	}

	private static boolean running = false;

	private Map<String, ILanguageInfo> languageInfos;

	public StandaloneLanguageRegistry() {
		if (EcorePlugin.IS_ECLIPSE_RUNNING)
			throw new IllegalStateException("This class can only run in standalone mode (no OSGi, no Eclipse)");
		if (running)
			throw new IllegalStateException("I want to be a singleton!");
		running = true;
		languageInfos = Maps.newHashMap();
		List<ExtensionInfo> extensionInfos = new StandalonePluginXMLParser().parse();
		Multimap<String, EMFExtensionParserInfo> languages = HashMultimap.create();
		for (ExtensionInfo info : extensionInfos)
			if (info instanceof EMFExtensionParserInfo) {
				EMFExtensionParserInfo parserInfo = (EMFExtensionParserInfo) info;
				if (parserInfo.getLanguage() != null)
					languages.put(parserInfo.getLanguage(), parserInfo);
				else
					registerEFactoryWithoutInjector(parserInfo);
			} else if (info instanceof EMFGeneratedPackageInfo)
				registerEPackage((EMFGeneratedPackageInfo) info);
		for (Map.Entry<String, Collection<EMFExtensionParserInfo>> entry : languages.asMap().entrySet()) {
			ILanguageInfo info = registerEFactoryWithInjector(entry.getKey(), entry.getValue());
			for (String ext : info.getFileExtensions())
				languageInfos.put(ext, info);
		}
	}

	@Override
	public ILanguageInfo getLanguageInfo(String fileExtension) {
		return languageInfos.get(fileExtension);
	}

	@Override
	public Collection<ILanguageInfo> getLanguageInfos() {
		return Sets.newLinkedHashSet(languageInfos.values());
	}

	protected ILanguageInfo registerEFactoryWithInjector(String key, Collection<EMFExtensionParserInfo> infos) {
		Map<String, String> extension2factory = Maps.newLinkedHashMap();
		for (EMFExtensionParserInfo info : infos)
			extension2factory.put(info.getType(), info.getClazz());
		StandaloneLanguageInfoImpl impl = new StandaloneLanguageInfoImpl(key, Lists.newArrayList(extension2factory.keySet()));
		for (Map.Entry<String, String> entry : extension2factory.entrySet()) {
			ResourceFactoryDescriptorForXtext descriptor = new ResourceFactoryDescriptorForXtext(impl, entry.getValue());
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(entry.getKey(), descriptor);
			ResourceServiceProviderProviderImpl provider = new ResourceServiceProviderProviderImpl(impl);
			IResourceServiceProvider.Registry.INSTANCE.getExtensionToFactoryMap().put(entry.getKey(), provider);
		}
		return impl;
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
