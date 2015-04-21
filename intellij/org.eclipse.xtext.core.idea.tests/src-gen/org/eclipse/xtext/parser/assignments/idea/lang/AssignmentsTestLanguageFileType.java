package org.eclipse.xtext.parser.assignments.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class AssignmentsTestLanguageFileType extends LanguageFileType {

	public static final AssignmentsTestLanguageFileType INSTANCE = new AssignmentsTestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "assignmentstestlanguage";

	private AssignmentsTestLanguageFileType() {
		super(AssignmentsTestLanguageLanguage.INSTANCE);
	}

	@Override
	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	@Override
	public String getDescription() {
		return "AssignmentsTestLanguage files";
	}

	@Override
	public Icon getIcon() {
		return null;
	}

	@Override
	public String getName() {
		return "AssignmentsTestLanguage";
	}

}
