package org.eclipse.xtend.core.idea.lang;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

public class XtendFileTypeFactory extends FileTypeFactory {

	public void createFileTypes(@NotNull FileTypeConsumer consumer) {
		consumer.consume(org.eclipse.xtend.core.idea.lang.XtendFileType.INSTANCE, org.eclipse.xtend.core.idea.lang.XtendFileType.DEFAULT_EXTENSION);
	}

}
