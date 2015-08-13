package org.eclipse.xtext.parser.parameters.idea.lang;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

public class ParametersTestLanguageExFileTypeFactory extends FileTypeFactory {

	@Override
	public void createFileTypes(@NotNull FileTypeConsumer consumer) {
		consumer.consume(org.eclipse.xtext.parser.parameters.idea.lang.ParametersTestLanguageExFileType.INSTANCE, org.eclipse.xtext.parser.parameters.idea.lang.AbstractParametersTestLanguageExFileType.DEFAULT_EXTENSION);
	}

}
