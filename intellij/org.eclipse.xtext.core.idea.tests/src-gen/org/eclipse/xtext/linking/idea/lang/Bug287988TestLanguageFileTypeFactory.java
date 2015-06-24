package org.eclipse.xtext.linking.idea.lang;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

public class Bug287988TestLanguageFileTypeFactory extends FileTypeFactory {

	@Override
	public void createFileTypes(@NotNull FileTypeConsumer consumer) {
		consumer.consume(org.eclipse.xtext.linking.idea.lang.Bug287988TestLanguageFileType.INSTANCE, org.eclipse.xtext.linking.idea.lang.AbstractBug287988TestLanguageFileType.DEFAULT_EXTENSION);
	}

}
