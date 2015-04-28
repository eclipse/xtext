package org.eclipse.xtext.parsetree.reconstr.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class SimpleReconstrTestLanguageFileType extends LanguageFileType {

	public static final SimpleReconstrTestLanguageFileType INSTANCE = new SimpleReconstrTestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "simplereconstrtestlanguage";

	private SimpleReconstrTestLanguageFileType() {
		super(SimpleReconstrTestLanguageLanguage.INSTANCE);
	}

	@Override
	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	@Override
	public String getDescription() {
		return "SimpleReconstrTestLanguage files";
	}

	@Override
	public Icon getIcon() {
		return null;
	}

	@Override
	public String getName() {
		return "SimpleReconstrTestLanguage";
	}

}
