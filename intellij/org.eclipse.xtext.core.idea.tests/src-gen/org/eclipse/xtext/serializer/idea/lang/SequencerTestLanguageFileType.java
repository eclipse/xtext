package org.eclipse.xtext.serializer.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class SequencerTestLanguageFileType extends LanguageFileType {

	public static final SequencerTestLanguageFileType INSTANCE = new SequencerTestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "";

	private SequencerTestLanguageFileType() {
		super(SequencerTestLanguageLanguage.INSTANCE);
	}

	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	public String getDescription() {
		return "SequencerTestLanguage files";
	}

	public Icon getIcon() {
		return null;
	}

	public String getName() {
		return "SequencerTestLanguage";
	}

}
