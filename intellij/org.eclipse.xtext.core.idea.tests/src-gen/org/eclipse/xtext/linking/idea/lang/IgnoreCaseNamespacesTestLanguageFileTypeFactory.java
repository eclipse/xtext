package org.eclipse.xtext.linking.idea.lang;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

public class IgnoreCaseNamespacesTestLanguageFileTypeFactory extends FileTypeFactory {

	@Override
	public void createFileTypes(@NotNull FileTypeConsumer consumer) {
		consumer.consume(org.eclipse.xtext.linking.idea.lang.IgnoreCaseNamespacesTestLanguageFileType.INSTANCE, org.eclipse.xtext.linking.idea.lang.AbstractIgnoreCaseNamespacesTestLanguageFileType.DEFAULT_EXTENSION);
	}

}
