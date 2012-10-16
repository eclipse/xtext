package org.eclipse.xpect.xtext.lib.registry;

import static org.eclipse.emf.common.EMFPlugin.IS_ECLIPSE_RUNNING;

import java.util.Collection;
import java.util.List;

import com.google.inject.Injector;
import com.google.inject.Module;

public interface ILanguageInfo {
	public interface Registry {
		public static final Registry INSTANCE = IS_ECLIPSE_RUNNING ? new EclipseLanugageRegistry() : new StandaloneLanguageRegistry();

		public abstract ILanguageInfo getLanguageInfo(String fileExtension);

		public abstract Collection<ILanguageInfo> getLanguageInfos();
	}

	public Injector getDefaultInjector();

	public List<String> getFileExtensions();

	public String getLanguageName();

	public Module getRuntimeModule();

	public Module getUIModule();
}