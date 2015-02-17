package org.eclipse.xtext.parser.antlr.idea.lang;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

public class Bug289524ExTestLanguageFileTypeFactory extends FileTypeFactory {

	public void createFileTypes(@NotNull FileTypeConsumer consumer) {
		consumer.consume(org.eclipse.xtext.parser.antlr.idea.lang.Bug289524ExTestLanguageFileType.INSTANCE, org.eclipse.xtext.parser.antlr.idea.lang.Bug289524ExTestLanguageFileType.DEFAULT_EXTENSION);
	}

}
