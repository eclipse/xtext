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

	@Override
	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	@Override
	public String getDescription() {
		return "AssignmentFinderTestLanguage files";
	}

	@Override
	public Icon getIcon() {
		return null;
	}

	@Override
	public String getName() {
		return "AssignmentFinderTestLanguage";
	}

}
