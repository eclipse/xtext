package org.eclipse.xtext.testlanguages.idea.lang;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

public class OptionalEmptyTestLanguageFileTypeFactory extends FileTypeFactory {

	@Override
	public void createFileTypes(@NotNull FileTypeConsumer consumer) {
		consumer.consume(org.eclipse.xtext.testlanguages.idea.lang.OptionalEmptyTestLanguageFileType.INSTANCE, org.eclipse.xtext.testlanguages.idea.lang.AbstractOptionalEmptyTestLanguageFileType.DEFAULT_EXTENSION);
	}

}
