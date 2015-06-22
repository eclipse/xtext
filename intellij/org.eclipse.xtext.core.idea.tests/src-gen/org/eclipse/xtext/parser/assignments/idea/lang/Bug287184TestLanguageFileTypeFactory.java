package org.eclipse.xtext.parser.assignments.idea.lang;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

public class Bug287184TestLanguageFileTypeFactory extends FileTypeFactory {

	@Override
	public void createFileTypes(@NotNull FileTypeConsumer consumer) {
		consumer.consume(org.eclipse.xtext.parser.assignments.idea.lang.Bug287184TestLanguageFileType.INSTANCE, org.eclipse.xtext.parser.assignments.idea.lang.AbstractBug287184TestLanguageFileType.DEFAULT_EXTENSION);
	}

}
