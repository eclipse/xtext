package org.eclipse.xtext.resource.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class LiveContainerBuilderIntegerationTestLanguageFileType extends LanguageFileType {

	public static final LiveContainerBuilderIntegerationTestLanguageFileType INSTANCE = new LiveContainerBuilderIntegerationTestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "livecontainerbuilderintegerationtestlanguage";

	private LiveContainerBuilderIntegerationTestLanguageFileType() {
		super(LiveContainerBuilderIntegerationTestLanguageLanguage.INSTANCE);
	}

	@Override
	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	@Override
	public String getDescription() {
		return "LiveContainerBuilderIntegerationTestLanguage files";
	}

	@Override
	public Icon getIcon() {
		return null;
	}

	@Override
	public String getName() {
		return "LiveContainerBuilderIntegerationTestLanguage";
	}

}
