package org.eclipse.xtext.generator.ecore.idea.lang;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

public class EcoreFragmentTestLanguageFileTypeFactory extends FileTypeFactory {

	@Override
	public void createFileTypes(@NotNull FileTypeConsumer consumer) {
		consumer.consume(org.eclipse.xtext.generator.ecore.idea.lang.EcoreFragmentTestLanguageFileType.INSTANCE, org.eclipse.xtext.generator.ecore.idea.lang.AbstractEcoreFragmentTestLanguageFileType.DEFAULT_EXTENSION);
	}

}
