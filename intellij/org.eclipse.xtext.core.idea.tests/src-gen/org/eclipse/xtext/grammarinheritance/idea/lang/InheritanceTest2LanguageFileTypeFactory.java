package org.eclipse.xtext.grammarinheritance.idea.lang;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

public class InheritanceTest2LanguageFileTypeFactory extends FileTypeFactory {

	@Override
	public void createFileTypes(@NotNull FileTypeConsumer consumer) {
		consumer.consume(org.eclipse.xtext.grammarinheritance.idea.lang.InheritanceTest2LanguageFileType.INSTANCE, org.eclipse.xtext.grammarinheritance.idea.lang.AbstractInheritanceTest2LanguageFileType.DEFAULT_EXTENSION);
	}

}
