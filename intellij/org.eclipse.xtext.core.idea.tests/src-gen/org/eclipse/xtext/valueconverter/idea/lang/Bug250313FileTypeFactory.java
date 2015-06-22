package org.eclipse.xtext.valueconverter.idea.lang;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

public class Bug250313FileTypeFactory extends FileTypeFactory {

	@Override
	public void createFileTypes(@NotNull FileTypeConsumer consumer) {
		consumer.consume(org.eclipse.xtext.valueconverter.idea.lang.Bug250313FileType.INSTANCE, org.eclipse.xtext.valueconverter.idea.lang.AbstractBug250313FileType.DEFAULT_EXTENSION);
	}

}
