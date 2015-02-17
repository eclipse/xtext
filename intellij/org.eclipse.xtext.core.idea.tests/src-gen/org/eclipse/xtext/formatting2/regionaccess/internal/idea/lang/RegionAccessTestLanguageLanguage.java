package org.eclipse.xtext.formatting2.regionaccess.internal.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class RegionAccessTestLanguageLanguage extends AbstractXtextLanguage {

	public static final RegionAccessTestLanguageLanguage INSTANCE = new RegionAccessTestLanguageLanguage();

	private Injector injector;

	private RegionAccessTestLanguageLanguage() {
		super("org.eclipse.xtext.formatting2.regionaccess.internal.RegionAccessTestLanguage");
		this.injector = new org.eclipse.xtext.formatting2.regionaccess.internal.idea.RegionAccessTestLanguageStandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
