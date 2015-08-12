package org.eclipse.xtext.parser.fragments.idea.lang;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

public class FragmentTestLanguageExFileTypeFactory extends FileTypeFactory {

	@Override
	public void createFileTypes(@NotNull FileTypeConsumer consumer) {
		consumer.consume(org.eclipse.xtext.parser.fragments.idea.lang.FragmentTestLanguageExFileType.INSTANCE, org.eclipse.xtext.parser.fragments.idea.lang.AbstractFragmentTestLanguageExFileType.DEFAULT_EXTENSION);
	}

}
