package org.eclipse.xpect.registry;

import static org.eclipse.emf.common.EMFPlugin.IS_ECLIPSE_RUNNING;

import java.util.Collection;
import java.util.Set;

import com.google.inject.Injector;
import com.google.inject.Module;

public interface ILanguageInfo {
	public interface Registry {
		public static final Registry INSTANCE = IS_ECLIPSE_RUNNING ? new DelegatingLanguageRegistry() : new StandaloneLanguageRegistry();

		public abstract ILanguageInfo getLanguageByFileExtension(String fileExtension);

		public abstract ILanguageInfo getLanguageByName(String languageName);

		public abstract Collection<ILanguageInfo> getLanguages();
	}

	public Set<String> getFileExtensions();

	public Injector getInjector(Module... modules);

	public String getLanguageName();

}