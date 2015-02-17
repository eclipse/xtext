package org.eclipse.xtext.validation.idea.lang;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

public class ConcreteSyntaxValidationTestLanguageFileTypeFactory extends FileTypeFactory {

	public void createFileTypes(@NotNull FileTypeConsumer consumer) {
		consumer.consume(org.eclipse.xtext.validation.idea.lang.ConcreteSyntaxValidationTestLanguageFileType.INSTANCE, org.eclipse.xtext.validation.idea.lang.ConcreteSyntaxValidationTestLanguageFileType.DEFAULT_EXTENSION);
	}

}
