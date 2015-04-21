package org.eclipse.xtext.dummy.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class DummyTestLanguageFileType extends LanguageFileType {

	public static final DummyTestLanguageFileType INSTANCE = new DummyTestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "dummytestlanguage";

	private DummyTestLanguageFileType() {
		super(DummyTestLanguageLanguage.INSTANCE);
	}

	@Override
	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	@Override
	public String getDescription() {
		return "DummyTestLanguage files";
	}

	@Override
	public Icon getIcon() {
		return null;
	}

	@Override
	public String getName() {
		return "DummyTestLanguage";
	}

}
