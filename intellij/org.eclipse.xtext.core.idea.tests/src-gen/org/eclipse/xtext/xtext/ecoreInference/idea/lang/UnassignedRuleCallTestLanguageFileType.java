package org.eclipse.xtext.xtext.ecoreInference.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class UnassignedRuleCallTestLanguageFileType extends LanguageFileType {

	public static final UnassignedRuleCallTestLanguageFileType INSTANCE = new UnassignedRuleCallTestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "";

	private UnassignedRuleCallTestLanguageFileType() {
		super(UnassignedRuleCallTestLanguageLanguage.INSTANCE);
	}

	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	public String getDescription() {
		return "UnassignedRuleCallTestLanguage files";
	}

	public Icon getIcon() {
		return null;
	}

	public String getName() {
		return "UnassignedRuleCallTestLanguage";
	}

}
