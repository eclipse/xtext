package org.eclipse.xtext.lexer.idea.lang;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

public class IgnoreCaseLexerTestLanguageFileTypeFactory extends FileTypeFactory {

	@Override
	public void createFileTypes(@NotNull FileTypeConsumer consumer) {
		consumer.consume(org.eclipse.xtext.lexer.idea.lang.IgnoreCaseLexerTestLanguageFileType.INSTANCE, org.eclipse.xtext.lexer.idea.lang.AbstractIgnoreCaseLexerTestLanguageFileType.DEFAULT_EXTENSION);
	}

}
