package org.eclipse.xtext.enumrules.idea.lang;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

public class EnumRulesTestLanguageFileTypeFactory extends FileTypeFactory {

	@Override
	public void createFileTypes(@NotNull FileTypeConsumer consumer) {
		consumer.consume(org.eclipse.xtext.enumrules.idea.lang.EnumRulesTestLanguageFileType.INSTANCE, org.eclipse.xtext.enumrules.idea.lang.AbstractEnumRulesTestLanguageFileType.DEFAULT_EXTENSION);
	}

}
