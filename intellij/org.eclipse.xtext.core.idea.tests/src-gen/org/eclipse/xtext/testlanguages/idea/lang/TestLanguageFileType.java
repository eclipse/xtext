package org.eclipse.xtext.testlanguages.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class TestLanguageFileType extends LanguageFileType {

	public static final TestLanguageFileType INSTANCE = new TestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "testlanguage";

	private TestLanguageFileType() {
		super(TestLanguageLanguage.INSTANCE);
	}

	@Override
	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	@Override
	public String getDescription() {
		return "TestLanguage files";
	}

	@Override
	public Icon getIcon() {
		return null;
	}

	@Override
	public String getName() {
		return "TestLanguage";
	}

}
