package org.eclipse.xtext.serializer.idea.lang;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

public class HiddenTokenSequencerTestLanguageFileTypeFactory extends FileTypeFactory {

	@Override
	public void createFileTypes(@NotNull FileTypeConsumer consumer) {
		consumer.consume(org.eclipse.xtext.serializer.idea.lang.HiddenTokenSequencerTestLanguageFileType.INSTANCE, org.eclipse.xtext.serializer.idea.lang.AbstractHiddenTokenSequencerTestLanguageFileType.DEFAULT_EXTENSION);
	}

}
