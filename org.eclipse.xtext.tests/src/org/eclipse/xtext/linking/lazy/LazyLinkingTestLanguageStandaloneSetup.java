package org.eclipse.xtext.linking.lazy;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.linking.lazy.lazyLinking.LazyLinkingPackage;

import com.google.inject.Injector;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class LazyLinkingTestLanguageStandaloneSetup extends LazyLinkingTestLanguageStandaloneSetupGenerated {

	public static void doSetup() {
		new LazyLinkingTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
	
	@Override
	public void register(Injector injector) {
		super.register(injector);
		if (!EPackage.Registry.INSTANCE.containsKey("http://eclipse.org/xtext/lazyLinkingTestLanguage")) {
			EPackage.Registry.INSTANCE.put("http://eclipse.org/xtext/lazyLinkingTestLanguage", LazyLinkingPackage.eINSTANCE);
		}
	}
	
}
