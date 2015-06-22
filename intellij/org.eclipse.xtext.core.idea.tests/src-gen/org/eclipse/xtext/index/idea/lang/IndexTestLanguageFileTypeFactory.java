package org.eclipse.xtext.index.idea.lang;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

public class IndexTestLanguageFileTypeFactory extends FileTypeFactory {

	@Override
	public void createFileTypes(@NotNull FileTypeConsumer consumer) {
		consumer.consume(org.eclipse.xtext.index.idea.lang.IndexTestLanguageFileType.INSTANCE, org.eclipse.xtext.index.idea.lang.AbstractIndexTestLanguageFileType.DEFAULT_EXTENSION);
	}

}
