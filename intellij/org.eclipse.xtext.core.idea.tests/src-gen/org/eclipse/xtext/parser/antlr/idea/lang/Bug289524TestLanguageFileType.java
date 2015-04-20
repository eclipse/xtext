package org.eclipse.xtext.parser.antlr.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class Bug289524TestLanguageFileType extends LanguageFileType {

	public static final Bug289524TestLanguageFileType INSTANCE = new Bug289524TestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "bug289524testlanguage";

	private Bug289524TestLanguageFileType() {
		super(Bug289524TestLanguageLanguage.INSTANCE);
	}

	@Override
	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	@Override
	public String getDescription() {
		return "Bug289524TestLanguage files";
	}

	@Override
	public Icon getIcon() {
		return null;
	}

	@Override
	public String getName() {
		return "Bug289524TestLanguage";
	}

}
