package org.eclipse.xtext.serializer.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class SyntacticSequencerTestLanguageFileType extends LanguageFileType {

	public static final SyntacticSequencerTestLanguageFileType INSTANCE = new SyntacticSequencerTestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "syntacticsequencertestlanguage";

	private SyntacticSequencerTestLanguageFileType() {
		super(SyntacticSequencerTestLanguageLanguage.INSTANCE);
	}

	@Override
	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	@Override
	public String getDescription() {
		return "SyntacticSequencerTestLanguage files";
	}

	@Override
	public Icon getIcon() {
		return null;
	}

	@Override
	public String getName() {
		return "SyntacticSequencerTestLanguage";
	}

}
