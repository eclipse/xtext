package org.eclipse.xtext.testlanguages.backtracking.idea.lang;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

public class SimpleBeeLangTestLanguageFileTypeFactory extends FileTypeFactory {

	public void createFileTypes(@NotNull FileTypeConsumer consumer) {
		consumer.consume(org.eclipse.xtext.testlanguages.backtracking.idea.lang.SimpleBeeLangTestLanguageFileType.INSTANCE, org.eclipse.xtext.testlanguages.backtracking.idea.lang.SimpleBeeLangTestLanguageFileType.DEFAULT_EXTENSION);
	}

}
