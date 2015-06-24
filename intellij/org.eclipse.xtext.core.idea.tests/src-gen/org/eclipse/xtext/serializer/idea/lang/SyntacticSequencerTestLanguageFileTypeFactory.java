package org.eclipse.xtext.serializer.idea.lang;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

public class SyntacticSequencerTestLanguageFileTypeFactory extends FileTypeFactory {

	@Override
	public void createFileTypes(@NotNull FileTypeConsumer consumer) {
		consumer.consume(org.eclipse.xtext.serializer.idea.lang.SyntacticSequencerTestLanguageFileType.INSTANCE, org.eclipse.xtext.serializer.idea.lang.AbstractSyntacticSequencerTestLanguageFileType.DEFAULT_EXTENSION);
	}

}
