package org.eclipse.xtext.parser.assignments.idea.lang;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

public class Bug288432TestLanguageFileTypeFactory extends FileTypeFactory {

	@Override
	public void createFileTypes(@NotNull FileTypeConsumer consumer) {
		consumer.consume(org.eclipse.xtext.parser.assignments.idea.lang.Bug288432TestLanguageFileType.INSTANCE, org.eclipse.xtext.parser.assignments.idea.lang.AbstractBug288432TestLanguageFileType.DEFAULT_EXTENSION);
	}

}
