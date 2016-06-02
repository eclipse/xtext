package org.eclipse.xpect.text;

public interface IRenderContext {
	IRenderContext at(int line, int column);

	void fill(Object value);

	ICanvas newSubCanvas();

	void print(Object value);

	IRenderContext withBounds(int maxLines, int maxColumns);

	// IRenderContext withVAlign(IVAlign align);

	// IRenderContext withHAlign(IHAlign align);
}