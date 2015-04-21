package org.eclipse.xtext.parsetree.impl.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class Bug305397FileType extends LanguageFileType {

	public static final Bug305397FileType INSTANCE = new Bug305397FileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "bug305397";

	private Bug305397FileType() {
		super(Bug305397Language.INSTANCE);
	}

	@Override
	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	@Override
	public String getDescription() {
		return "Bug305397 files";
	}

	@Override
	public Icon getIcon() {
		return null;
	}

	@Override
	public String getName() {
		return "Bug305397";
	}

}
