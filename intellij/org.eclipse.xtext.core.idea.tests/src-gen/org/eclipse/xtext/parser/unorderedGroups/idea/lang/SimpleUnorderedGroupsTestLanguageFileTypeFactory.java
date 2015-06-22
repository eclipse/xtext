package org.eclipse.xtext.parser.unorderedGroups.idea.lang;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

public class SimpleUnorderedGroupsTestLanguageFileTypeFactory extends FileTypeFactory {

	@Override
	public void createFileTypes(@NotNull FileTypeConsumer consumer) {
		consumer.consume(org.eclipse.xtext.parser.unorderedGroups.idea.lang.SimpleUnorderedGroupsTestLanguageFileType.INSTANCE, org.eclipse.xtext.parser.unorderedGroups.idea.lang.AbstractSimpleUnorderedGroupsTestLanguageFileType.DEFAULT_EXTENSION);
	}

}
