package org.eclipse.xtext.idea.lang;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

public class XtextFileTypeFactory extends FileTypeFactory {

	@Override
	public void createFileTypes(@NotNull FileTypeConsumer consumer) {
		consumer.consume(org.eclipse.xtext.idea.lang.XtextFileType.INSTANCE, org.eclipse.xtext.idea.lang.AbstractXtextFileType.DEFAULT_EXTENSION);
	}

}
