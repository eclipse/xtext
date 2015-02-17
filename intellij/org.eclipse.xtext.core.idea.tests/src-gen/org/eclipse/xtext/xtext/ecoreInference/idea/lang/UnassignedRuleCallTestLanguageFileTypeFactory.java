package org.eclipse.xtext.xtext.ecoreInference.idea.lang;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

public class UnassignedRuleCallTestLanguageFileTypeFactory extends FileTypeFactory {

	public void createFileTypes(@NotNull FileTypeConsumer consumer) {
		consumer.consume(org.eclipse.xtext.xtext.ecoreInference.idea.lang.UnassignedRuleCallTestLanguageFileType.INSTANCE, org.eclipse.xtext.xtext.ecoreInference.idea.lang.UnassignedRuleCallTestLanguageFileType.DEFAULT_EXTENSION);
	}

}
