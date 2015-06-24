package org.eclipse.xtext.linking.lazy.idea.lang;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

public class Bug311337TestLanguageFileTypeFactory extends FileTypeFactory {

	@Override
	public void createFileTypes(@NotNull FileTypeConsumer consumer) {
		consumer.consume(org.eclipse.xtext.linking.lazy.idea.lang.Bug311337TestLanguageFileType.INSTANCE, org.eclipse.xtext.linking.lazy.idea.lang.AbstractBug311337TestLanguageFileType.DEFAULT_EXTENSION);
	}

}
