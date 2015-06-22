package org.eclipse.xtext.grammarinheritance.idea.lang;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

public class AbstractTestLanguageFileTypeFactory extends FileTypeFactory {

	@Override
	public void createFileTypes(@NotNull FileTypeConsumer consumer) {
		consumer.consume(org.eclipse.xtext.grammarinheritance.idea.lang.AbstractTestLanguageFileType.INSTANCE, org.eclipse.xtext.grammarinheritance.idea.lang.AbstractAbstractTestLanguageFileType.DEFAULT_EXTENSION);
	}

}
