package org.eclipse.xtext.parser.unorderedGroups.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class ExUnorderedGroupsTestLanguageFileType extends LanguageFileType {

	public static final ExUnorderedGroupsTestLanguageFileType INSTANCE = new ExUnorderedGroupsTestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "exunorderedgroupstestlanguage";

	private ExUnorderedGroupsTestLanguageFileType() {
		super(ExUnorderedGroupsTestLanguageLanguage.INSTANCE);
	}

	@Override
	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	@Override
	public String getDescription() {
		return "ExUnorderedGroupsTestLanguage files";
	}

	@Override
	public Icon getIcon() {
		return null;
	}

	@Override
	public String getName() {
		return "ExUnorderedGroupsTestLanguage";
	}

}
