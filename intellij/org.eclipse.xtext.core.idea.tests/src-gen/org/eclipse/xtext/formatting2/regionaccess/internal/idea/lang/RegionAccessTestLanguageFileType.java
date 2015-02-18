package org.eclipse.xtext.formatting2.regionaccess.internal.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class RegionAccessTestLanguageFileType extends LanguageFileType {

	public static final RegionAccessTestLanguageFileType INSTANCE = new RegionAccessTestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "regionaccesstestlanguage";

	private RegionAccessTestLanguageFileType() {
		super(RegionAccessTestLanguageLanguage.INSTANCE);
	}

	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	public String getDescription() {
		return "RegionAccessTestLanguage files";
	}

	public Icon getIcon() {
		return null;
	}

	public String getName() {
		return "RegionAccessTestLanguage";
	}

}
