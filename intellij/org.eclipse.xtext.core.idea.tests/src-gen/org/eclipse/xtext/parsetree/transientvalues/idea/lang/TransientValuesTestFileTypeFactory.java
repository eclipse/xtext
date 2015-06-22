package org.eclipse.xtext.parsetree.transientvalues.idea.lang;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

public class TransientValuesTestFileTypeFactory extends FileTypeFactory {

	@Override
	public void createFileTypes(@NotNull FileTypeConsumer consumer) {
		consumer.consume(org.eclipse.xtext.parsetree.transientvalues.idea.lang.TransientValuesTestFileType.INSTANCE, org.eclipse.xtext.parsetree.transientvalues.idea.lang.AbstractTransientValuesTestFileType.DEFAULT_EXTENSION);
	}

}
