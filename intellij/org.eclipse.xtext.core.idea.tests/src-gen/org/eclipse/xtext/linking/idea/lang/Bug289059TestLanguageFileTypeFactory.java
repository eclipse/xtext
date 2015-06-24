package org.eclipse.xtext.linking.idea.lang;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

public class Bug289059TestLanguageFileTypeFactory extends FileTypeFactory {

	@Override
	public void createFileTypes(@NotNull FileTypeConsumer consumer) {
		consumer.consume(org.eclipse.xtext.linking.idea.lang.Bug289059TestLanguageFileType.INSTANCE, org.eclipse.xtext.linking.idea.lang.AbstractBug289059TestLanguageFileType.DEFAULT_EXTENSION);
	}

}
