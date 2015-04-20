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

	@Override
	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	@Override
	public String getDescription() {
		return "AbstractIgnoreCaseLinkingTestLanguage files";
	}

	@Override
	public Icon getIcon() {
		return null;
	}

	@Override
	public String getName() {
		return "AbstractIgnoreCaseLinkingTestLanguage";
	}

}
