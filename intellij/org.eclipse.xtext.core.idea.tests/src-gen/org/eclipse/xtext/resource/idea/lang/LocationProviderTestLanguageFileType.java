package org.eclipse.xtext.resource.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class LocationProviderTestLanguageFileType extends LanguageFileType {

	public static final LocationProviderTestLanguageFileType INSTANCE = new LocationProviderTestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "locationprovidertestlanguage";

	private LocationProviderTestLanguageFileType() {
		super(LocationProviderTestLanguageLanguage.INSTANCE);
	}

	@Override
	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	@Override
	public String getDescription() {
		return "LocationProviderTestLanguage files";
	}

	@Override
	public Icon getIcon() {
		return null;
	}

	@Override
	public String getName() {
		return "LocationProviderTestLanguage";
	}

}
