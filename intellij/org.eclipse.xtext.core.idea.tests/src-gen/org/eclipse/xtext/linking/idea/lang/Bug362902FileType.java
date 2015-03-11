package org.eclipse.xtext.linking.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class Bug362902FileType extends LanguageFileType {

	public static final Bug362902FileType INSTANCE = new Bug362902FileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "bug362902";

	private Bug362902FileType() {
		super(Bug362902Language.INSTANCE);
	}

	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	public String getDescription() {
		return "Bug362902 files";
	}

	public Icon getIcon() {
		return null;
	}

	public String getName() {
		return "Bug362902";
	}

}
