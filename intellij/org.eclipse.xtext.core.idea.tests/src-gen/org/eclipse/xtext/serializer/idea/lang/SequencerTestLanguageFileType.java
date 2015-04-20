package org.eclipse.xtext.serializer.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class SequencerTestLanguageFileType extends LanguageFileType {

	public static final SequencerTestLanguageFileType INSTANCE = new SequencerTestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "sequencertestlanguage";

	private SequencerTestLanguageFileType() {
		super(SequencerTestLanguageLanguage.INSTANCE);
	}

	@Override
	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	@Override
	public String getDescription() {
		return "SequencerTestLanguage files";
	}

	@Override
	public Icon getIcon() {
		return null;
	}

	@Override
	public String getName() {
		return "SequencerTestLanguage";
	}

}
