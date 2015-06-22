package org.eclipse.xtext.linking.idea.lang;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

public class AbstractIgnoreCaseLinkingTestLanguageFileTypeFactory extends FileTypeFactory {

	@Override
	public void createFileTypes(@NotNull FileTypeConsumer consumer) {
		consumer.consume(org.eclipse.xtext.linking.idea.lang.AbstractIgnoreCaseLinkingTestLanguageFileType.INSTANCE, org.eclipse.xtext.linking.idea.lang.AbstractAbstractIgnoreCaseLinkingTestLanguageFileType.DEFAULT_EXTENSION);
	}

}
