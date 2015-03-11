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

	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	public String getDescription() {
		return "TestLanguage files";
	}

	public Icon getIcon() {
		return null;
	}

	public String getName() {
		return "TestLanguage";
	}

}
