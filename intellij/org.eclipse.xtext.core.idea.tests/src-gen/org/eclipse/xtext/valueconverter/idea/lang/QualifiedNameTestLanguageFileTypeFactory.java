package org.eclipse.xtext.valueconverter.idea.lang;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

public class QualifiedNameTestLanguageFileTypeFactory extends FileTypeFactory {

	@Override
	public void createFileTypes(@NotNull FileTypeConsumer consumer) {
		consumer.consume(org.eclipse.xtext.valueconverter.idea.lang.QualifiedNameTestLanguageFileType.INSTANCE, org.eclipse.xtext.valueconverter.idea.lang.AbstractQualifiedNameTestLanguageFileType.DEFAULT_EXTENSION);
	}

}
