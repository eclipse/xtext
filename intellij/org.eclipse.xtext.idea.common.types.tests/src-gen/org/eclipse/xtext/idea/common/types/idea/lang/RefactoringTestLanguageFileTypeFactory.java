package org.eclipse.xtext.idea.common.types.idea.lang;

import org.jetbrains.annotations.NotNull;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;

public class RefactoringTestLanguageFileTypeFactory extends FileTypeFactory {

	public void createFileTypes(@NotNull FileTypeConsumer consumer) {
		consumer.consume(org.eclipse.xtext.idea.common.types.idea.lang.RefactoringTestLanguageFileType.INSTANCE, org.eclipse.xtext.idea.common.types.idea.lang.RefactoringTestLanguageFileType.DEFAULT_EXTENSION);
	}

}
