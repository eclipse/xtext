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

	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	public String getDescription() {
		return "ElementMatcherTestLanguage files";
	}

	public Icon getIcon() {
		return null;
	}

	public String getName() {
		return "ElementMatcherTestLanguage";
	}

}
