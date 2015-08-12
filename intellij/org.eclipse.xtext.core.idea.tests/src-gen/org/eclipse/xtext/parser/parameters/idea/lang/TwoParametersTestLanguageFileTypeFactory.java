package org.eclipse.xtext.parser.parameters.idea.lang;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

public class TwoParametersTestLanguageFileTypeFactory extends FileTypeFactory {

	@Override
	public void createFileTypes(@NotNull FileTypeConsumer consumer) {
		consumer.consume(org.eclipse.xtext.parser.parameters.idea.lang.TwoParametersTestLanguageFileType.INSTANCE, org.eclipse.xtext.parser.parameters.idea.lang.AbstractTwoParametersTestLanguageFileType.DEFAULT_EXTENSION);
	}

}
