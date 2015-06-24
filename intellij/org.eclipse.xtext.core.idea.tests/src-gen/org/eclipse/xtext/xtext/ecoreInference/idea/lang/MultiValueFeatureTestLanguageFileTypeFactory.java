package org.eclipse.xtext.xtext.ecoreInference.idea.lang;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

public class MultiValueFeatureTestLanguageFileTypeFactory extends FileTypeFactory {

	@Override
	public void createFileTypes(@NotNull FileTypeConsumer consumer) {
		consumer.consume(org.eclipse.xtext.xtext.ecoreInference.idea.lang.MultiValueFeatureTestLanguageFileType.INSTANCE, org.eclipse.xtext.xtext.ecoreInference.idea.lang.AbstractMultiValueFeatureTestLanguageFileType.DEFAULT_EXTENSION);
	}

}
