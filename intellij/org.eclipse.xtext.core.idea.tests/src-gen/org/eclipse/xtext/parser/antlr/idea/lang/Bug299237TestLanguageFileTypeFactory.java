package org.eclipse.xtext.parser.antlr.idea.lang;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

public class Bug299237TestLanguageFileTypeFactory extends FileTypeFactory {

	@Override
	public void createFileTypes(@NotNull FileTypeConsumer consumer) {
		consumer.consume(org.eclipse.xtext.parser.antlr.idea.lang.Bug299237TestLanguageFileType.INSTANCE, org.eclipse.xtext.parser.antlr.idea.lang.AbstractBug299237TestLanguageFileType.DEFAULT_EXTENSION);
	}

}
