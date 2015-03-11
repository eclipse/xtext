package org.eclipse.xtext.parser.bug419429.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class Bug419429FileType extends LanguageFileType {

	public static final Bug419429FileType INSTANCE = new Bug419429FileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "bug419429";

	private Bug419429FileType() {
		super(Bug419429Language.INSTANCE);
	}

	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	public String getDescription() {
		return "Bug419429 files";
	}

	public Icon getIcon() {
		return null;
	}

	public String getName() {
		return "Bug419429";
	}

}
