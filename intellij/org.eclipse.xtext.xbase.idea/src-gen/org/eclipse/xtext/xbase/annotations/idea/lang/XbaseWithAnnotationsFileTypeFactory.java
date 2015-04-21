package org.eclipse.xtext.xbase.annotations.idea.lang;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

public class XbaseWithAnnotationsFileTypeFactory extends FileTypeFactory {

	@Override
	public void createFileTypes(@NotNull FileTypeConsumer consumer) {
		consumer.consume(org.eclipse.xtext.xbase.annotations.idea.lang.XbaseWithAnnotationsFileType.INSTANCE, org.eclipse.xtext.xbase.annotations.idea.lang.XbaseWithAnnotationsFileType.DEFAULT_EXTENSION);
	}

}
