package org.eclipse.xtext.serializer.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class HiddenTokenSequencerTestLanguageFileType extends LanguageFileType {

	public static final HiddenTokenSequencerTestLanguageFileType INSTANCE = new HiddenTokenSequencerTestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "";

	private HiddenTokenSequencerTestLanguageFileType() {
		super(HiddenTokenSequencerTestLanguageLanguage.INSTANCE);
	}

	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	public String getDescription() {
		return "HiddenTokenSequencerTestLanguage files";
	}

	public Icon getIcon() {
		return null;
	}

	public String getName() {
		return "HiddenTokenSequencerTestLanguage";
	}

}
