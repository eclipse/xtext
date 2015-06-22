package org.eclipse.xtext.grammarinheritance.idea.lang;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

public class InheritanceTestLanguageFileTypeFactory extends FileTypeFactory {

	@Override
	public void createFileTypes(@NotNull FileTypeConsumer consumer) {
		consumer.consume(org.eclipse.xtext.grammarinheritance.idea.lang.InheritanceTestLanguageFileType.INSTANCE, org.eclipse.xtext.grammarinheritance.idea.lang.AbstractInheritanceTestLanguageFileType.DEFAULT_EXTENSION);
	}

}
