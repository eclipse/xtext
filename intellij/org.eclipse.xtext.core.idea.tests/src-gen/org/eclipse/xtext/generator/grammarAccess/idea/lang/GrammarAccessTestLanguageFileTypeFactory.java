package org.eclipse.xtext.generator.grammarAccess.idea.lang;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

public class GrammarAccessTestLanguageFileTypeFactory extends FileTypeFactory {

	@Override
	public void createFileTypes(@NotNull FileTypeConsumer consumer) {
		consumer.consume(org.eclipse.xtext.generator.grammarAccess.idea.lang.GrammarAccessTestLanguageFileType.INSTANCE, org.eclipse.xtext.generator.grammarAccess.idea.lang.AbstractGrammarAccessTestLanguageFileType.DEFAULT_EXTENSION);
	}

}
