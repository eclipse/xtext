package org.eclipse.xtext.testlanguages.idea.lang;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

public class PartialParserTestLanguageFileTypeFactory extends FileTypeFactory {

	@Override
	public void createFileTypes(@NotNull FileTypeConsumer consumer) {
		consumer.consume(org.eclipse.xtext.testlanguages.idea.lang.PartialParserTestLanguageFileType.INSTANCE, org.eclipse.xtext.testlanguages.idea.lang.AbstractPartialParserTestLanguageFileType.DEFAULT_EXTENSION);
	}

}
