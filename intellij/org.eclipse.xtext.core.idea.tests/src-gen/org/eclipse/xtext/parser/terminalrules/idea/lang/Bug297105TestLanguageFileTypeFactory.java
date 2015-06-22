package org.eclipse.xtext.parser.terminalrules.idea.lang;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

public class Bug297105TestLanguageFileTypeFactory extends FileTypeFactory {

	@Override
	public void createFileTypes(@NotNull FileTypeConsumer consumer) {
		consumer.consume(org.eclipse.xtext.parser.terminalrules.idea.lang.Bug297105TestLanguageFileType.INSTANCE, org.eclipse.xtext.parser.terminalrules.idea.lang.AbstractBug297105TestLanguageFileType.DEFAULT_EXTENSION);
	}

}
