package org.eclipse.xtext.parser.antlr.idea.lang;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

public class Bug296889ExTestLanguageFileTypeFactory extends FileTypeFactory {

	@Override
	public void createFileTypes(@NotNull FileTypeConsumer consumer) {
		consumer.consume(org.eclipse.xtext.parser.antlr.idea.lang.Bug296889ExTestLanguageFileType.INSTANCE, org.eclipse.xtext.parser.antlr.idea.lang.AbstractBug296889ExTestLanguageFileType.DEFAULT_EXTENSION);
	}

}
