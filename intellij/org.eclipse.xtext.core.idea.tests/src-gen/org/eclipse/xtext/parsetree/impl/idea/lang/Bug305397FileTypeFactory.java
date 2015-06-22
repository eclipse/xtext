package org.eclipse.xtext.parsetree.impl.idea.lang;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

public class Bug305397FileTypeFactory extends FileTypeFactory {

	@Override
	public void createFileTypes(@NotNull FileTypeConsumer consumer) {
		consumer.consume(org.eclipse.xtext.parsetree.impl.idea.lang.Bug305397FileType.INSTANCE, org.eclipse.xtext.parsetree.impl.idea.lang.AbstractBug305397FileType.DEFAULT_EXTENSION);
	}

}
