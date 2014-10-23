package org.xtext.idea.sdomain.idea.lang;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

public class SDomainFileTypeFactory extends FileTypeFactory {

	public void createFileTypes(@NotNull FileTypeConsumer consumer) {
		consumer.consume(org.xtext.idea.sdomain.idea.lang.SDomainFileType.INSTANCE, org.xtext.idea.sdomain.idea.lang.SDomainFileType.DEFAULT_EXTENSION);
	}

}
