package org.eclipse.xtext.parsetree.reconstr.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class HiddenTokensMergerTestLanguageFileType extends LanguageFileType {

	public static final HiddenTokensMergerTestLanguageFileType INSTANCE = new HiddenTokensMergerTestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "hiddentokensmergertestlanguage";

	private HiddenTokensMergerTestLanguageFileType() {
		super(HiddenTokensMergerTestLanguageLanguage.INSTANCE);
	}

	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	public String getDescription() {
		return "HiddenTokensMergerTestLanguage files";
	}

	public Icon getIcon() {
		return null;
	}

	public String getName() {
		return "HiddenTokensMergerTestLanguage";
	}

}
