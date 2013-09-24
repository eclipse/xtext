/**
 * 
 */
package org.eclipse.xtext.builder.standalone;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.resource.FileExtensionProvider;
import org.eclipse.xtext.resource.IResourceServiceProvider;

import com.google.inject.Injector;

/**
 * @author Dennis Huebner - Initial contribution and API
 * 
 */
public class LanguageAccessFactory {

	public Map<String,LanguageAccess> createLanguageAccess(List<? extends ILanguageConfiguration> languageConfigs, ClassLoader compilerClassLoder) {
		Map<String,LanguageAccess> result = new HashMap<String, LanguageAccess>();
		for (ILanguageConfiguration languageGenConf : languageConfigs) {
			ISetup setup;
			try {
				Class<?> loadClass = compilerClassLoder.loadClass(languageGenConf.getSetup());
				if (!ISetup.class.isAssignableFrom(loadClass)) {
					throw new IllegalArgumentException("Language setup class " + languageGenConf.getSetup()
							+ " must implement " + ISetup.class.getName());
				}
				setup = (ISetup) loadClass.newInstance();
			} catch (Exception e) {
				// TODO better exception handling
				throw new RuntimeException("Failed to load language setup class.", e);
			}

			Injector injector = setup.createInjectorAndDoEMFRegistration();
			IResourceServiceProvider serviceProvider = injector.getInstance(IResourceServiceProvider.class);
			FileExtensionProvider fileExtensionProvider = injector.getInstance(FileExtensionProvider.class);
			LanguageAccess languageAccess = new LanguageAccess(languageGenConf.getOutputConfigurations(), serviceProvider);
			for (String extesion : fileExtensionProvider.getFileExtensions()) {
				result.put(extesion, languageAccess);
			}
		}
		return result;
	}
	
}
