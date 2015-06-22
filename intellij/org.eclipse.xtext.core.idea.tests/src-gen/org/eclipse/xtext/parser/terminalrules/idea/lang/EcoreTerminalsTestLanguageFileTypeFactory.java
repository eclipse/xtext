package org.eclipse.xtext.parser.terminalrules.idea.lang;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

public class EcoreTerminalsTestLanguageFileTypeFactory extends FileTypeFactory {

	@Override
	public void createFileTypes(@NotNull FileTypeConsumer consumer) {
		consumer.consume(org.eclipse.xtext.parser.terminalrules.idea.lang.EcoreTerminalsTestLanguageFileType.INSTANCE, org.eclipse.xtext.parser.terminalrules.idea.lang.AbstractEcoreTerminalsTestLanguageFileType.DEFAULT_EXTENSION);
	}

}
