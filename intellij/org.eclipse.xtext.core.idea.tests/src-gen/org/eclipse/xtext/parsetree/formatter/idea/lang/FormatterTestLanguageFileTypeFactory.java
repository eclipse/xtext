package org.eclipse.xtext.parsetree.formatter.idea.lang;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

public class FormatterTestLanguageFileTypeFactory extends FileTypeFactory {

	@Override
	public void createFileTypes(@NotNull FileTypeConsumer consumer) {
		consumer.consume(org.eclipse.xtext.parsetree.formatter.idea.lang.FormatterTestLanguageFileType.INSTANCE, org.eclipse.xtext.parsetree.formatter.idea.lang.AbstractFormatterTestLanguageFileType.DEFAULT_EXTENSION);
	}

}
