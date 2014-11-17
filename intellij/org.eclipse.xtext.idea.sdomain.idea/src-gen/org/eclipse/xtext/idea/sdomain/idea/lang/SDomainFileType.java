package org.eclipse.xtext.idea.sdomain.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class SDomainFileType extends LanguageFileType {

	public static final SDomainFileType INSTANCE = new SDomainFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "sdomain";

	private SDomainFileType() {
		super(SDomainLanguage.INSTANCE);
	}

	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	public String getDescription() {
		return "SDomain files";
	}

	public Icon getIcon() {
		return null;
	}

	public String getName() {
		return "SDomain";
	}

}
