package org.eclipse.xtext.linking.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class AbstractIgnoreCaseLinkingTestLanguageFileType extends LanguageFileType {

	public static final AbstractIgnoreCaseLinkingTestLanguageFileType INSTANCE = new AbstractIgnoreCaseLinkingTestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "abstractignorecaselinkingtestlanguage";

	private AbstractIgnoreCaseLinkingTestLanguageFileType() {
		super(AbstractIgnoreCaseLinkingTestLanguageLanguage.INSTANCE);
	}

	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	public String getDescription() {
		return "AbstractIgnoreCaseLinkingTestLanguage files";
	}

	public Icon getIcon() {
		return null;
	}

	public String getName() {
		return "AbstractIgnoreCaseLinkingTestLanguage";
	}

}
