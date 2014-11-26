package org.eclipse.xtext.formatting2;

/**
 * Xtext formatting infrastructure 2.0.
 * 
 * A formatter is responsible for arranging line-wraps, indentation, whitespace, etc. in a text document to improve is
 * readability and emphasize its structure. A formatter is not supposed to alter a document in a way that impacts the
 * semantic model.
 * 
 * This infrastructure is capable of formatting documents based on the node model and based on the serializer's output.
 * The actual formatting is done by constructing a list of text replacements. Applying the text replacement turns the
 * unformatted document into a formatted document. Purpose of this infrastructure is to make it convenient for
 * implementers to construct these text replacements.
 * 
 * To run the formatter, you'll need to construct a {@link FormatterRequest}, get an instance of {@link IFormatter2}
 * from your language's Guice Injector and call {@link IFormatter2#format(FormatterRequest)}. The result will be a list
 * of text replacements. Use {@link TextReplacements#apply(CharSequence, Iterable)} to apply the replacements to a
 * String/CharSequence, if desired.
 * 
 * To implement a formatter or to understand how to implement a formatter, see {@link AbstractFormatter2}.
 * 
 * @see IFormatter2 - use this interface to invoke the formatter
 * @see AbstractFormatter2 - subclass this class to implement a formatter
 * @see ITextReplacement - a text-substitution at a defined offset inside a larger text
 * @see FormatterRequest - per-execution scoped configuration for the formatter.  
 *                         Per-language configuration is handled by the Guice-Injector 
 *                         or {@link org.eclipse.xtext.formatting2.AbstractFormatter2}. 
 * 
 * @author Moritz Eysholdt - Initial contribution and API
 * @since 2.8
 */
