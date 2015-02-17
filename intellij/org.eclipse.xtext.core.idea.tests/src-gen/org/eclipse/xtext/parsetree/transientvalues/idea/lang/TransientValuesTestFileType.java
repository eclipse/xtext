package org.eclipse.xtext.parsetree.transientvalues.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class TransientValuesTestFileType extends LanguageFileType {

	public static final TransientValuesTestFileType INSTANCE = new TransientValuesTestFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "";

	private TransientValuesTestFileType() {
		super(TransientValuesTestLanguage.INSTANCE);
	}

	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	public String getDescription() {
		return "TransientValuesTest files";
	}

	public Icon getIcon() {
		return null;
	}

	public String getName() {
		return "TransientValuesTest";
	}

}
