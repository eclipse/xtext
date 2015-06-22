package org.eclipse.xtext.testlanguages.idea.lang;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

public class LookaheadTestLanguageFileTypeFactory extends FileTypeFactory {

	@Override
	public void createFileTypes(@NotNull FileTypeConsumer consumer) {
		consumer.consume(org.eclipse.xtext.testlanguages.idea.lang.LookaheadTestLanguageFileType.INSTANCE, org.eclipse.xtext.testlanguages.idea.lang.AbstractLookaheadTestLanguageFileType.DEFAULT_EXTENSION);
	}

}
