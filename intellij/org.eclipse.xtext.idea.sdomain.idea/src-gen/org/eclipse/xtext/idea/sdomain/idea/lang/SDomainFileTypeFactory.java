package org.eclipse.xtext.idea.sdomain.idea.lang;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

public class SDomainFileTypeFactory extends FileTypeFactory {

	@Override
	public void createFileTypes(@NotNull FileTypeConsumer consumer) {
		consumer.consume(org.eclipse.xtext.idea.sdomain.idea.lang.SDomainFileType.INSTANCE, org.eclipse.xtext.idea.sdomain.idea.lang.AbstractSDomainFileType.DEFAULT_EXTENSION);
	}

}
