package org.eclipse.xtext.parsetree.transientvalues.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class TransientValuesTestFileType extends LanguageFileType {

	public static final TransientValuesTestFileType INSTANCE = new TransientValuesTestFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "transientvaluestest";

	private TransientValuesTestFileType() {
		super(TransientValuesTestLanguage.INSTANCE);
	}

	@Override
	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	@Override
	public String getDescription() {
		return "TransientValuesTest files";
	}

	@Override
	public Icon getIcon() {
		return null;
	}

	@Override
	public String getName() {
		return "TransientValuesTest";
	}

}
