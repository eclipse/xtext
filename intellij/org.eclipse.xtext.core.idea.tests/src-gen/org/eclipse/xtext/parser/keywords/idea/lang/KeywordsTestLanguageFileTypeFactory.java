package org.eclipse.xtext.parser.keywords.idea.lang;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

public class KeywordsTestLanguageFileTypeFactory extends FileTypeFactory {

	@Override
	public void createFileTypes(@NotNull FileTypeConsumer consumer) {
		consumer.consume(org.eclipse.xtext.parser.keywords.idea.lang.KeywordsTestLanguageFileType.INSTANCE, org.eclipse.xtext.parser.keywords.idea.lang.AbstractKeywordsTestLanguageFileType.DEFAULT_EXTENSION);
	}

}
