package org.eclipse.xtext.resource.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class Bug385636FileType extends LanguageFileType {

	public static final Bug385636FileType INSTANCE = new Bug385636FileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "bug385636";

	private Bug385636FileType() {
		super(Bug385636Language.INSTANCE);
	}

	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	public String getDescription() {
		return "Bug385636 files";
	}

	public Icon getIcon() {
		return null;
	}

	public String getName() {
		return "Bug385636";
	}

}
