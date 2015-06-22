package org.eclipse.xtext.resource.idea.lang;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

public class Bug385636FileTypeFactory extends FileTypeFactory {

	@Override
	public void createFileTypes(@NotNull FileTypeConsumer consumer) {
		consumer.consume(org.eclipse.xtext.resource.idea.lang.Bug385636FileType.INSTANCE, org.eclipse.xtext.resource.idea.lang.AbstractBug385636FileType.DEFAULT_EXTENSION);
	}

}
