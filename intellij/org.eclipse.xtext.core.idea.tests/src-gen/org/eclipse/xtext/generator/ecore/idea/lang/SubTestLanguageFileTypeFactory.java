package org.eclipse.xtext.generator.ecore.idea.lang;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

public class SubTestLanguageFileTypeFactory extends FileTypeFactory {

	@Override
	public void createFileTypes(@NotNull FileTypeConsumer consumer) {
		consumer.consume(org.eclipse.xtext.generator.ecore.idea.lang.SubTestLanguageFileType.INSTANCE, org.eclipse.xtext.generator.ecore.idea.lang.AbstractSubTestLanguageFileType.DEFAULT_EXTENSION);
	}

}
