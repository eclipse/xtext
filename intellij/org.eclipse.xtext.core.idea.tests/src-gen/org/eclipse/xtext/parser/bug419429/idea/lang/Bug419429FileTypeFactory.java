package org.eclipse.xtext.parser.bug419429.idea.lang;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

public class Bug419429FileTypeFactory extends FileTypeFactory {

	@Override
	public void createFileTypes(@NotNull FileTypeConsumer consumer) {
		consumer.consume(org.eclipse.xtext.parser.bug419429.idea.lang.Bug419429FileType.INSTANCE, org.eclipse.xtext.parser.bug419429.idea.lang.AbstractBug419429FileType.DEFAULT_EXTENSION);
	}

}
