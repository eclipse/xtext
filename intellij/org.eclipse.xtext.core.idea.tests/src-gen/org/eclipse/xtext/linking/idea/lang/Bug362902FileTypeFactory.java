package org.eclipse.xtext.linking.idea.lang;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

public class Bug362902FileTypeFactory extends FileTypeFactory {

	@Override
	public void createFileTypes(@NotNull FileTypeConsumer consumer) {
		consumer.consume(org.eclipse.xtext.linking.idea.lang.Bug362902FileType.INSTANCE, org.eclipse.xtext.linking.idea.lang.AbstractBug362902FileType.DEFAULT_EXTENSION);
	}

}
