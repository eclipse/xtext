package org.eclipse.xtext.parsetree.impl.idea.lang;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

public class CommentAssociationTestLanguageFileTypeFactory extends FileTypeFactory {

	@Override
	public void createFileTypes(@NotNull FileTypeConsumer consumer) {
		consumer.consume(org.eclipse.xtext.parsetree.impl.idea.lang.CommentAssociationTestLanguageFileType.INSTANCE, org.eclipse.xtext.parsetree.impl.idea.lang.AbstractCommentAssociationTestLanguageFileType.DEFAULT_EXTENSION);
	}

}
