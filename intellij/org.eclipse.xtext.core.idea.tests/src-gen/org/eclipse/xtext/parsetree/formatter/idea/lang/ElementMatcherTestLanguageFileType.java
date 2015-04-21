package org.eclipse.xtext.parsetree.formatter.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class ElementMatcherTestLanguageFileType extends LanguageFileType {

	public static final ElementMatcherTestLanguageFileType INSTANCE = new ElementMatcherTestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "elementmatchertestlanguage";

	private ElementMatcherTestLanguageFileType() {
		super(ElementMatcherTestLanguageLanguage.INSTANCE);
	}

	@Override
	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	@Override
	public String getDescription() {
		return "ElementMatcherTestLanguage files";
	}

	@Override
	public Icon getIcon() {
		return null;
	}

	@Override
	public String getName() {
		return "ElementMatcherTestLanguage";
	}

}
