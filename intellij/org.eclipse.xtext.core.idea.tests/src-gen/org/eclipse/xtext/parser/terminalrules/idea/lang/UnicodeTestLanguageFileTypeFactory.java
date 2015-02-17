package org.eclipse.xtext.parser.terminalrules.idea.lang;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

public class UnicodeTestLanguageFileTypeFactory extends FileTypeFactory {

	public void createFileTypes(@NotNull FileTypeConsumer consumer) {
		consumer.consume(org.eclipse.xtext.parser.terminalrules.idea.lang.UnicodeTestLanguageFileType.INSTANCE, org.eclipse.xtext.parser.terminalrules.idea.lang.UnicodeTestLanguageFileType.DEFAULT_EXTENSION);
	}

}
