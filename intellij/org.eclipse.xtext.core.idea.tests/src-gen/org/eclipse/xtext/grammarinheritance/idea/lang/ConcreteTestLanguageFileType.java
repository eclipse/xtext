package org.eclipse.xtext.grammarinheritance.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class ConcreteTestLanguageFileType extends LanguageFileType {

	public static final ConcreteTestLanguageFileType INSTANCE = new ConcreteTestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "concretetestlanguage";

	private ConcreteTestLanguageFileType() {
		super(ConcreteTestLanguageLanguage.INSTANCE);
	}

	@Override
	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	@Override
	public String getDescription() {
		return "ConcreteTestLanguage files";
	}

	@Override
	public Icon getIcon() {
		return null;
	}

	@Override
	public String getName() {
		return "ConcreteTestLanguage";
	}

}
