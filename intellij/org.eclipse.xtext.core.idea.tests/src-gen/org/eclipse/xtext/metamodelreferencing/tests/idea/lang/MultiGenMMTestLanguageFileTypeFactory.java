package org.eclipse.xtext.metamodelreferencing.tests.idea.lang;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

public class MultiGenMMTestLanguageFileTypeFactory extends FileTypeFactory {

	@Override
	public void createFileTypes(@NotNull FileTypeConsumer consumer) {
		consumer.consume(org.eclipse.xtext.metamodelreferencing.tests.idea.lang.MultiGenMMTestLanguageFileType.INSTANCE, org.eclipse.xtext.metamodelreferencing.tests.idea.lang.AbstractMultiGenMMTestLanguageFileType.DEFAULT_EXTENSION);
	}

}
