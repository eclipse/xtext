package org.eclipse.xtext.parser.parameters.idea.lang;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

public class ParametersTestLanguageFileTypeFactory extends FileTypeFactory {

	@Override
	public void createFileTypes(@NotNull FileTypeConsumer consumer) {
		consumer.consume(org.eclipse.xtext.parser.parameters.idea.lang.ParametersTestLanguageFileType.INSTANCE, org.eclipse.xtext.parser.parameters.idea.lang.AbstractParametersTestLanguageFileType.DEFAULT_EXTENSION);
	}

}
