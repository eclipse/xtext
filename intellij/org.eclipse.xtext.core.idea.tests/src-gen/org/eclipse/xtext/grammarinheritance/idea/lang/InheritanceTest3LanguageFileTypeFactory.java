package org.eclipse.xtext.grammarinheritance.idea.lang;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

public class InheritanceTest3LanguageFileTypeFactory extends FileTypeFactory {

	@Override
	public void createFileTypes(@NotNull FileTypeConsumer consumer) {
		consumer.consume(org.eclipse.xtext.grammarinheritance.idea.lang.InheritanceTest3LanguageFileType.INSTANCE, org.eclipse.xtext.grammarinheritance.idea.lang.AbstractInheritanceTest3LanguageFileType.DEFAULT_EXTENSION);
	}

}
