package org.eclipse.xtext.formatting2.internal.idea.lang;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

public class FormatterTestLanguageFileTypeFactory extends FileTypeFactory {

	public void createFileTypes(@NotNull FileTypeConsumer consumer) {
		consumer.consume(org.eclipse.xtext.formatting2.internal.idea.lang.FormatterTestLanguageFileType.INSTANCE, org.eclipse.xtext.formatting2.internal.idea.lang.FormatterTestLanguageFileType.DEFAULT_EXTENSION);
	}

}
