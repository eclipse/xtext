package org.eclipse.xtext.linking.lazy.idea.lang;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

public class LazyLinkingTestLanguageFileTypeFactory extends FileTypeFactory {

	@Override
	public void createFileTypes(@NotNull FileTypeConsumer consumer) {
		consumer.consume(org.eclipse.xtext.linking.lazy.idea.lang.LazyLinkingTestLanguageFileType.INSTANCE, org.eclipse.xtext.linking.lazy.idea.lang.AbstractLazyLinkingTestLanguageFileType.DEFAULT_EXTENSION);
	}

}
