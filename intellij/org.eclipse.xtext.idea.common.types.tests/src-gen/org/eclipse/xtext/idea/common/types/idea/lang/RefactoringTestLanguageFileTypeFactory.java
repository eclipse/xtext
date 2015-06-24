package org.eclipse.xtext.idea.common.types.idea.lang;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

public class RefactoringTestLanguageFileTypeFactory extends FileTypeFactory {

	@Override
	public void createFileTypes(@NotNull FileTypeConsumer consumer) {
		consumer.consume(org.eclipse.xtext.idea.common.types.idea.lang.RefactoringTestLanguageFileType.INSTANCE, org.eclipse.xtext.idea.common.types.idea.lang.AbstractRefactoringTestLanguageFileType.DEFAULT_EXTENSION);
	}

}
