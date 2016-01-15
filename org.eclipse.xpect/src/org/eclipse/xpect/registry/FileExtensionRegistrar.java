package org.eclipse.xpect.registry;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Factory;
import org.eclipse.xpect.registry.IEmfFileExtensionInfo.IXtextFileExtensionInfo;
import org.eclipse.xtext.resource.IResourceServiceProvider;

import com.google.inject.Provider;

public class FileExtensionRegistrar {

	protected abstract static class AbstractDesrc<T extends IEmfFileExtensionInfo> {

		protected final T info;

		public AbstractDesrc(T info) {
			this.info = info;
		}

		public T getInfo() {
			return info;
		}

		protected <X> X newInstance(LazyClass<X> clazz) {
			Class<X> loaded = clazz.load();
			if (info instanceof IXtextFileExtensionInfo) {
				IXtextFileExtensionInfo xtextInfo = (IXtextFileExtensionInfo) info;
				ILanguageInfo languageInfo = ILanguageInfo.Registry.INSTANCE.getLanguageByName(xtextInfo.getLanguageID());
				return languageInfo.getInjector().getInstance(loaded);
			} else {
				try {
					return loaded.newInstance();
				} catch (InstantiationException e) {
					throw new RuntimeException(e);
				} catch (IllegalAccessException e) {
					throw new RuntimeException(e);
				}
			}
		}
	}

	protected static class ResourceFactoryDescr extends AbstractDesrc<IEmfFileExtensionInfo> implements Resource.Factory.Descriptor {
		private Factory factory;

		public ResourceFactoryDescr(IEmfFileExtensionInfo info) {
			super(info);
		}

		public Factory createFactory() {
			if (factory == null)
				factory = newInstance(info.getResourceFactory());
			return factory;
		}
	}

	protected static class ServiceProvider extends AbstractDesrc<IXtextFileExtensionInfo> implements Provider<IResourceServiceProvider> {

		private IResourceServiceProvider provider;

		public ServiceProvider(IXtextFileExtensionInfo info) {
			super(info);
		}

		public IResourceServiceProvider get() {
			if (provider == null)
				provider = newInstance(info.getResourceServiceProvider());
			return provider;
		}
	}

	public static void register(IEmfFileExtensionInfo info) {
		ResourceFactoryDescr rf = new ResourceFactoryDescr(info);
		ServiceProvider spp = info instanceof IXtextFileExtensionInfo ? new ServiceProvider((IXtextFileExtensionInfo) info) : null;
		for (String ext : info.getFileExtensions()) {
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(ext, rf);
			if (spp != null)
				IResourceServiceProvider.Registry.INSTANCE.getExtensionToFactoryMap().put(ext, spp);
		}
	}
}
