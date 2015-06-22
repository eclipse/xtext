package org.eclipse.xtext.parser.terminalrules.idea.lang;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

public class Bug292245TestLanguageFileTypeFactory extends FileTypeFactory {

	@Override
	public void createFileTypes(@NotNull FileTypeConsumer consumer) {
		consumer.consume(org.eclipse.xtext.parser.terminalrules.idea.lang.Bug292245TestLanguageFileType.INSTANCE, org.eclipse.xtext.parser.terminalrules.idea.lang.AbstractBug292245TestLanguageFileType.DEFAULT_EXTENSION);
	}

}
