package org.eclipse.xtext.parsetree.reconstr.idea.lang;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

public class SerializationBug269362TestLanguageFileTypeFactory extends FileTypeFactory {

	@Override
	public void createFileTypes(@NotNull FileTypeConsumer consumer) {
		consumer.consume(org.eclipse.xtext.parsetree.reconstr.idea.lang.SerializationBug269362TestLanguageFileType.INSTANCE, org.eclipse.xtext.parsetree.reconstr.idea.lang.AbstractSerializationBug269362TestLanguageFileType.DEFAULT_EXTENSION);
	}

}
