package org.eclipse.xtext.generator.ecore.idea.lang;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

public class SuperTestLanguageFileTypeFactory extends FileTypeFactory {

	public void createFileTypes(@NotNull FileTypeConsumer consumer) {
		consumer.consume(org.eclipse.xtext.generator.ecore.idea.lang.SuperTestLanguageFileType.INSTANCE, org.eclipse.xtext.generator.ecore.idea.lang.SuperTestLanguageFileType.DEFAULT_EXTENSION);
	}

}
