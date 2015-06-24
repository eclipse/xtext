package org.eclipse.xtext.parser.terminalrules.idea.lang;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

public class XtextTerminalsTestLanguageFileTypeFactory extends FileTypeFactory {

	@Override
	public void createFileTypes(@NotNull FileTypeConsumer consumer) {
		consumer.consume(org.eclipse.xtext.parser.terminalrules.idea.lang.XtextTerminalsTestLanguageFileType.INSTANCE, org.eclipse.xtext.parser.terminalrules.idea.lang.AbstractXtextTerminalsTestLanguageFileType.DEFAULT_EXTENSION);
	}

}
