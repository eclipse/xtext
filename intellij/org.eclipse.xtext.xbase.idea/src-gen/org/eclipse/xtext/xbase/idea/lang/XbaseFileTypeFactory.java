package org.eclipse.xtext.xbase.idea.lang;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

public class XbaseFileTypeFactory extends FileTypeFactory {

	public void createFileTypes(@NotNull FileTypeConsumer consumer) {
		consumer.consume(org.eclipse.xtext.xbase.idea.lang.XbaseFileType.INSTANCE, org.eclipse.xtext.xbase.idea.lang.XbaseFileType.DEFAULT_EXTENSION);
	}

}
