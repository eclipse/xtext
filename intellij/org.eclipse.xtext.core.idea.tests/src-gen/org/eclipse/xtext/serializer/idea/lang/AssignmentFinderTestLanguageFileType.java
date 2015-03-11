package org.eclipse.xtext.serializer.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class AssignmentFinderTestLanguageFileType extends LanguageFileType {

	public static final AssignmentFinderTestLanguageFileType INSTANCE = new AssignmentFinderTestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "assignmentfindertestlanguage";

	private AssignmentFinderTestLanguageFileType() {
		super(AssignmentFinderTestLanguageLanguage.INSTANCE);
	}

	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	public String getDescription() {
		return "AssignmentFinderTestLanguage files";
	}

	public Icon getIcon() {
		return null;
	}

	public String getName() {
		return "AssignmentFinderTestLanguage";
	}

}
