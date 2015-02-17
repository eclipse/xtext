package org.eclipse.xtext.parser.antlr.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class Bug289524TestLanguageFileType extends LanguageFileType {

	public static final Bug289524TestLanguageFileType INSTANCE = new Bug289524TestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "";

	private Bug289524TestLanguageFileType() {
		super(Bug289524TestLanguageLanguage.INSTANCE);
	}

	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	public String getDescription() {
		return "Bug289524TestLanguage files";
	}

	public Icon getIcon() {
		return null;
	}

	public String getName() {
		return "Bug289524TestLanguage";
	}

}
