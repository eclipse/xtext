package org.eclipse.xtext.lexer.idea.lang;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

public class BacktrackingLexerTestLanguageFileTypeFactory extends FileTypeFactory {

	@Override
	public void createFileTypes(@NotNull FileTypeConsumer consumer) {
		consumer.consume(org.eclipse.xtext.lexer.idea.lang.BacktrackingLexerTestLanguageFileType.INSTANCE, org.eclipse.xtext.lexer.idea.lang.AbstractBacktrackingLexerTestLanguageFileType.DEFAULT_EXTENSION);
	}

}
