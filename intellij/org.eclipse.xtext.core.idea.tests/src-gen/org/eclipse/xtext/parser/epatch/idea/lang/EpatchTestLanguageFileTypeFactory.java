package org.eclipse.xtext.parser.epatch.idea.lang;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

public class EpatchTestLanguageFileTypeFactory extends FileTypeFactory {

	@Override
	public void createFileTypes(@NotNull FileTypeConsumer consumer) {
		consumer.consume(org.eclipse.xtext.parser.epatch.idea.lang.EpatchTestLanguageFileType.INSTANCE, org.eclipse.xtext.parser.epatch.idea.lang.AbstractEpatchTestLanguageFileType.DEFAULT_EXTENSION);
	}

}
