package org.eclipse.xtext.parsetree.unassignedtext.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class UnassignedTextTestLanguageFileType extends LanguageFileType {

	public static final UnassignedTextTestLanguageFileType INSTANCE = new UnassignedTextTestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "unassignedtexttestlanguage";

	private UnassignedTextTestLanguageFileType() {
		super(UnassignedTextTestLanguageLanguage.INSTANCE);
	}

	@Override
	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	@Override
	public String getDescription() {
		return "UnassignedTextTestLanguage files";
	}

	@Override
	public Icon getIcon() {
		return null;
	}

	@Override
	public String getName() {
		return "UnassignedTextTestLanguage";
	}

}
