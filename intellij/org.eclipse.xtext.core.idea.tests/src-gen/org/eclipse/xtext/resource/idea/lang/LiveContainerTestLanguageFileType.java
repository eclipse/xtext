package org.eclipse.xtext.resource.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class LiveContainerTestLanguageFileType extends LanguageFileType {

	public static final LiveContainerTestLanguageFileType INSTANCE = new LiveContainerTestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "";

	private LiveContainerTestLanguageFileType() {
		super(LiveContainerTestLanguageLanguage.INSTANCE);
	}

	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	public String getDescription() {
		return "LiveContainerTestLanguage files";
	}

	public Icon getIcon() {
		return null;
	}

	public String getName() {
		return "LiveContainerTestLanguage";
	}

}
