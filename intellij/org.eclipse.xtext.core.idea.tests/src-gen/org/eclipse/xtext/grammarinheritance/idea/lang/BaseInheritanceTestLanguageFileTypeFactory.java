package org.eclipse.xtext.grammarinheritance.idea.lang;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

public class BaseInheritanceTestLanguageFileTypeFactory extends FileTypeFactory {

	@Override
	public void createFileTypes(@NotNull FileTypeConsumer consumer) {
		consumer.consume(org.eclipse.xtext.grammarinheritance.idea.lang.BaseInheritanceTestLanguageFileType.INSTANCE, org.eclipse.xtext.grammarinheritance.idea.lang.AbstractBaseInheritanceTestLanguageFileType.DEFAULT_EXTENSION);
	}

}
