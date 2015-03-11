package org.eclipse.xtext.generator;

import org.eclipse.xpand2.output.FileHandle;
import org.eclipse.xpand2.output.PostProcessor;

/**
 * A post processor for Xpand that replaces all line separators in generated code by the configured line delimiter.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * 
 * @since 2.7
 */
public class NewlineNormalizer extends LineSeparatorHarmonizer implements PostProcessor {

	private final String lineDelimiterToUse;

	public NewlineNormalizer(String lineDelimiterToUse) {
		this.lineDelimiterToUse = lineDelimiterToUse;
	}
	
	@Override
	public void beforeWriteAndClose(FileHandle impl) {
		CharSequence content = impl.getBuffer();
		String replaced = normalizeLineDelimiters(content);
		impl.setBuffer(replaced);
	}

	@Override
	public void afterClose(FileHandle impl) {
		// nothing to do
	}

	/**
	 * Converts the given content into a {@link CharSequence} that uses only the configured {@link #lineDelimiterToUse}
	 */
	public String normalizeLineDelimiters(CharSequence content) {
		return replaceLineSeparators(content, lineDelimiterToUse);
	}

}