package org.xpect.text;

import java.util.Collections;
import java.util.List;

public interface ITextBlock {

	final static ITextBlock EMPTY = new ITextBlock() {
		public List<String> getLines() {
			return Collections.singletonList("");
		}
	};

	List<String> getLines();
}
