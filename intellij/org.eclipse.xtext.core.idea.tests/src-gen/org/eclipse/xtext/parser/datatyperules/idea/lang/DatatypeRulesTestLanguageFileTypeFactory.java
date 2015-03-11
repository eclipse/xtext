package org.eclipse.xtext.parser.datatyperules.idea.lang;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

public class DatatypeRulesTestLanguageFileTypeFactory extends FileTypeFactory {

	public void createFileTypes(@NotNull FileTypeConsumer consumer) {
		consumer.consume(org.eclipse.xtext.parser.datatyperules.idea.lang.DatatypeRulesTestLanguageFileType.INSTANCE, org.eclipse.xtext.parser.datatyperules.idea.lang.DatatypeRulesTestLanguageFileType.DEFAULT_EXTENSION);
	}

}
