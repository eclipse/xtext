package org.eclipse.xtext.parsetree.reconstr.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class Bug299395TestLanguageFileType extends LanguageFileType {

	public static final Bug299395TestLanguageFileType INSTANCE = new Bug299395TestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "bug299395testlanguage";

	private Bug299395TestLanguageFileType() {
		super(Bug299395TestLanguageLanguage.INSTANCE);
	}

	@Override
	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	@Override
	public String getDescription() {
		return "Bug299395TestLanguage files";
	}

	@Override
	public Icon getIcon() {
		return null;
	}

	@Override
	public String getName() {
		return "Bug299395TestLanguage";
	}

}
