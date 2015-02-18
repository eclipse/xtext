package org.eclipse.xtext.testlanguages.backtracking.idea.lang;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

public class BeeLangTestLanguageFileTypeFactory extends FileTypeFactory {

	public void createFileTypes(@NotNull FileTypeConsumer consumer) {
		consumer.consume(org.eclipse.xtext.testlanguages.backtracking.idea.lang.BeeLangTestLanguageFileType.INSTANCE, org.eclipse.xtext.testlanguages.backtracking.idea.lang.BeeLangTestLanguageFileType.DEFAULT_EXTENSION);
	}

}
