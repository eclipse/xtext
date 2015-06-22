package org.eclipse.xtext.resource.idea.lang;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

public class LiveContainerBuilderIntegerationTestLanguageFileTypeFactory extends FileTypeFactory {

	@Override
	public void createFileTypes(@NotNull FileTypeConsumer consumer) {
		consumer.consume(org.eclipse.xtext.resource.idea.lang.LiveContainerBuilderIntegerationTestLanguageFileType.INSTANCE, org.eclipse.xtext.resource.idea.lang.AbstractLiveContainerBuilderIntegerationTestLanguageFileType.DEFAULT_EXTENSION);
	}

}
