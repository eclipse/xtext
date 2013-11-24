package org.xpect.registry;

import java.util.Collection;
import java.util.Set;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.IResourceServiceProvider;

import com.google.inject.Module;

public interface IEmfFileExtensionInfo {

	public interface IXtextFileExtensionInfo extends IEmfFileExtensionInfo {

		String getLanguageID();

		LazyClass<IResourceServiceProvider> getResourceServiceProvider();

		LazyClass<IResourceServiceProvider> getResourceUIServiceProvider();

		LazyClass<Module> getRuntimeModule();

		LazyClass<Module> getUIModule();

	}

	public interface Registry {
		Registry INSTANCE = new FileExtensionInfoRegistry();

		IEmfFileExtensionInfo getEmfFileExtensionInfo(String fileExtension);

		Collection<IEmfFileExtensionInfo> getFileExtensionInfos();
	}

	Set<String> getFileExtensions();

	LazyClass<Resource.Factory> getResourceFactory();
}
