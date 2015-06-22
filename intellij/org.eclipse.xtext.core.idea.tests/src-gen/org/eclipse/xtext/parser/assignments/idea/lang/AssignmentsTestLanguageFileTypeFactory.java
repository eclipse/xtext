package org.eclipse.xtext.parser.assignments.idea.lang;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

public class AssignmentsTestLanguageFileTypeFactory extends FileTypeFactory {

	@Override
	public void createFileTypes(@NotNull FileTypeConsumer consumer) {
		consumer.consume(org.eclipse.xtext.parser.assignments.idea.lang.AssignmentsTestLanguageFileType.INSTANCE, org.eclipse.xtext.parser.assignments.idea.lang.AbstractAssignmentsTestLanguageFileType.DEFAULT_EXTENSION);
	}

}
