package org.eclipse.xtext.parsetree.reconstr.idea.lang;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

public class PartialSerializationTestLanguageFileTypeFactory extends FileTypeFactory {

	@Override
	public void createFileTypes(@NotNull FileTypeConsumer consumer) {
		consumer.consume(org.eclipse.xtext.parsetree.reconstr.idea.lang.PartialSerializationTestLanguageFileType.INSTANCE, org.eclipse.xtext.parsetree.reconstr.idea.lang.AbstractPartialSerializationTestLanguageFileType.DEFAULT_EXTENSION);
	}

}
