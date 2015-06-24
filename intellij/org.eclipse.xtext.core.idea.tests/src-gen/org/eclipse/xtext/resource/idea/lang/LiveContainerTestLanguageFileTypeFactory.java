package org.eclipse.xtext.resource.idea.lang;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

public class LiveContainerTestLanguageFileTypeFactory extends FileTypeFactory {

	@Override
	public void createFileTypes(@NotNull FileTypeConsumer consumer) {
		consumer.consume(org.eclipse.xtext.resource.idea.lang.LiveContainerTestLanguageFileType.INSTANCE, org.eclipse.xtext.resource.idea.lang.AbstractLiveContainerTestLanguageFileType.DEFAULT_EXTENSION);
	}

}
