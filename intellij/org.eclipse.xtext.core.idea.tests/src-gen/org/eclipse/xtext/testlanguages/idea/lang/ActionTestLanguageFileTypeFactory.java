package org.eclipse.xtext.testlanguages.idea.lang;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

public class ActionTestLanguageFileTypeFactory extends FileTypeFactory {

	@Override
	public void createFileTypes(@NotNull FileTypeConsumer consumer) {
		consumer.consume(org.eclipse.xtext.testlanguages.idea.lang.ActionTestLanguageFileType.INSTANCE, org.eclipse.xtext.testlanguages.idea.lang.AbstractActionTestLanguageFileType.DEFAULT_EXTENSION);
	}

}
