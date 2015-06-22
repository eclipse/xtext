package org.eclipse.xtext.idea.example.entities.idea.lang;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

public class EntitiesFileTypeFactory extends FileTypeFactory {

	@Override
	public void createFileTypes(@NotNull FileTypeConsumer consumer) {
		consumer.consume(org.eclipse.xtext.idea.example.entities.idea.lang.EntitiesFileType.INSTANCE, org.eclipse.xtext.idea.example.entities.idea.lang.AbstractEntitiesFileType.DEFAULT_EXTENSION);
	}

}
