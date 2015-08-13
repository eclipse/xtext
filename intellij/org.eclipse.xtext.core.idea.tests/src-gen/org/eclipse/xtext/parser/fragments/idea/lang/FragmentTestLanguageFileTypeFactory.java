package org.eclipse.xtext.parser.fragments.idea.lang;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

public class FragmentTestLanguageFileTypeFactory extends FileTypeFactory {

	@Override
	public void createFileTypes(@NotNull FileTypeConsumer consumer) {
		consumer.consume(org.eclipse.xtext.parser.fragments.idea.lang.FragmentTestLanguageFileType.INSTANCE, org.eclipse.xtext.parser.fragments.idea.lang.AbstractFragmentTestLanguageFileType.DEFAULT_EXTENSION);
	}

}
