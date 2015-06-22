package org.eclipse.xtext.testlanguages.idea.lang;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

public class ReferenceGrammarTestLanguageFileTypeFactory extends FileTypeFactory {

	@Override
	public void createFileTypes(@NotNull FileTypeConsumer consumer) {
		consumer.consume(org.eclipse.xtext.testlanguages.idea.lang.ReferenceGrammarTestLanguageFileType.INSTANCE, org.eclipse.xtext.testlanguages.idea.lang.AbstractReferenceGrammarTestLanguageFileType.DEFAULT_EXTENSION);
	}

}
