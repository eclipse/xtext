package org.eclipse.xtext.parser.unorderedGroups.idea.lang;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

public class SimpleBacktrackingBug325745TestLanguageFileTypeFactory extends FileTypeFactory {

	@Override
	public void createFileTypes(@NotNull FileTypeConsumer consumer) {
		consumer.consume(org.eclipse.xtext.parser.unorderedGroups.idea.lang.SimpleBacktrackingBug325745TestLanguageFileType.INSTANCE, org.eclipse.xtext.parser.unorderedGroups.idea.lang.AbstractSimpleBacktrackingBug325745TestLanguageFileType.DEFAULT_EXTENSION);
	}

}
