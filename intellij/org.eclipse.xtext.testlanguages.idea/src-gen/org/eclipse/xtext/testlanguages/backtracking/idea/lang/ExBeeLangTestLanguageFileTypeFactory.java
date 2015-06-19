package org.eclipse.xtext.testlanguages.backtracking.idea.lang;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

public class ExBeeLangTestLanguageFileTypeFactory extends FileTypeFactory {

	@Override
	public void createFileTypes(@NotNull FileTypeConsumer consumer) {
		consumer.consume(org.eclipse.xtext.testlanguages.backtracking.idea.lang.ExBeeLangTestLanguageFileType.INSTANCE, org.eclipse.xtext.testlanguages.backtracking.idea.lang.AbstractExBeeLangTestLanguageFileType.DEFAULT_EXTENSION);
	}

}
