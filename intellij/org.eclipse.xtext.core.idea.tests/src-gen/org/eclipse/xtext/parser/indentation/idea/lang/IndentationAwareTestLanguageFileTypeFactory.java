package org.eclipse.xtext.parser.indentation.idea.lang;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

public class IndentationAwareTestLanguageFileTypeFactory extends FileTypeFactory {

	@Override
	public void createFileTypes(@NotNull FileTypeConsumer consumer) {
		consumer.consume(org.eclipse.xtext.parser.indentation.idea.lang.IndentationAwareTestLanguageFileType.INSTANCE, org.eclipse.xtext.parser.indentation.idea.lang.AbstractIndentationAwareTestLanguageFileType.DEFAULT_EXTENSION);
	}

}
