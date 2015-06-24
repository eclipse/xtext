package org.eclipse.xtext.parser.encoding.idea.lang;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

public class EncodingTestLanguageFileTypeFactory extends FileTypeFactory {

	@Override
	public void createFileTypes(@NotNull FileTypeConsumer consumer) {
		consumer.consume(org.eclipse.xtext.parser.encoding.idea.lang.EncodingTestLanguageFileType.INSTANCE, org.eclipse.xtext.parser.encoding.idea.lang.AbstractEncodingTestLanguageFileType.DEFAULT_EXTENSION);
	}

}
