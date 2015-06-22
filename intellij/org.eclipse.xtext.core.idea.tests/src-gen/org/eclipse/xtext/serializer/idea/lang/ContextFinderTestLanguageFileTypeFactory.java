package org.eclipse.xtext.serializer.idea.lang;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

public class ContextFinderTestLanguageFileTypeFactory extends FileTypeFactory {

	@Override
	public void createFileTypes(@NotNull FileTypeConsumer consumer) {
		consumer.consume(org.eclipse.xtext.serializer.idea.lang.ContextFinderTestLanguageFileType.INSTANCE, org.eclipse.xtext.serializer.idea.lang.AbstractContextFinderTestLanguageFileType.DEFAULT_EXTENSION);
	}

}
