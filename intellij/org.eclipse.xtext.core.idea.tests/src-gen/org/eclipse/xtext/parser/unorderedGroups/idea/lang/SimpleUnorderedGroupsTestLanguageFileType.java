package org.eclipse.xtext.parser.unorderedGroups.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class SimpleUnorderedGroupsTestLanguageFileType extends LanguageFileType {

	public static final SimpleUnorderedGroupsTestLanguageFileType INSTANCE = new SimpleUnorderedGroupsTestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "simpleunorderedgroupstestlanguage";

	private SimpleUnorderedGroupsTestLanguageFileType() {
		super(SimpleUnorderedGroupsTestLanguageLanguage.INSTANCE);
	}

	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	public String getDescription() {
		return "SimpleUnorderedGroupsTestLanguage files";
	}

	public Icon getIcon() {
		return null;
	}

	public String getName() {
		return "SimpleUnorderedGroupsTestLanguage";
	}

}
