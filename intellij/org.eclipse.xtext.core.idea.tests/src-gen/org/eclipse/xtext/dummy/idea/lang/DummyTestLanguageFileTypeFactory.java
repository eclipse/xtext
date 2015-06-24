package org.eclipse.xtext.dummy.idea.lang;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

public class DummyTestLanguageFileTypeFactory extends FileTypeFactory {

	@Override
	public void createFileTypes(@NotNull FileTypeConsumer consumer) {
		consumer.consume(org.eclipse.xtext.dummy.idea.lang.DummyTestLanguageFileType.INSTANCE, org.eclipse.xtext.dummy.idea.lang.AbstractDummyTestLanguageFileType.DEFAULT_EXTENSION);
	}

}
