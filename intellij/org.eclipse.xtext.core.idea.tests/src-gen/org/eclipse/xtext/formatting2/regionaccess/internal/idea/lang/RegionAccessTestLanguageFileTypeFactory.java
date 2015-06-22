package org.eclipse.xtext.formatting2.regionaccess.internal.idea.lang;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

public class RegionAccessTestLanguageFileTypeFactory extends FileTypeFactory {

	@Override
	public void createFileTypes(@NotNull FileTypeConsumer consumer) {
		consumer.consume(org.eclipse.xtext.formatting2.regionaccess.internal.idea.lang.RegionAccessTestLanguageFileType.INSTANCE, org.eclipse.xtext.formatting2.regionaccess.internal.idea.lang.AbstractRegionAccessTestLanguageFileType.DEFAULT_EXTENSION);
	}

}
