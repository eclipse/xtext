package org.eclipse.xtext.parsetree.unassignedtext.idea.lang;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

public class UnassignedTextTestLanguageFileTypeFactory extends FileTypeFactory {

	@Override
	public void createFileTypes(@NotNull FileTypeConsumer consumer) {
		consumer.consume(org.eclipse.xtext.parsetree.unassignedtext.idea.lang.UnassignedTextTestLanguageFileType.INSTANCE, org.eclipse.xtext.parsetree.unassignedtext.idea.lang.AbstractUnassignedTextTestLanguageFileType.DEFAULT_EXTENSION);
	}

}
