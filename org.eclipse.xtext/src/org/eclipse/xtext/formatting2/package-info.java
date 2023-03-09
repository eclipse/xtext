/**
 * <p>Xtext formatting infrastructure since Xtext 2.8.</p>
 * 
 * <p>A formatter is responsible for arranging line-wraps, indentation, whitespace, etc. in a text document to improve its
 * readability and emphasize its structure. A formatter is not supposed to alter a document in a way that impacts the
 * semantic model.</p>
 * 
 * <p>This infrastructure is capable of formatting documents based on the node model and based on the serializer's output.
 * The actual formatting is done by constructing a list of text replacements. Applying the text replacements turns the
 * unformatted document into a formatted document. Purpose of this infrastructure is to make it convenient for
 * implementers to construct these text replacements.</p>
 * 
 * <p>To run the formatter, you'll need to construct a {@link org.eclipse.xtext.formatting2.FormatterRequest},
 * get an instance of {@link org.eclipse.xtext.formatting2.IFormatter2} from your language's Guice Injector,
 * and call {@link org.eclipse.xtext.formatting2.IFormatter2#format(FormatterRequest)}. The result will be a list
 * of text replacements. Use {@link org.eclipse.xtext.formatting2.regionaccess.ITextRegionRewriter}
 * to apply the replacements to a String/CharSequence, if desired.</p>
 * 
 * <p>To implement a formatter or to understand how to implement a formatter, see
 * {@link org.eclipse.xtext.formatting2.AbstractFormatter2}.</p>
 * 
 * <ul>
 * <li>{@link org.eclipse.xtext.formatting2.IFormatter2} Use the IFormatter2 to invoke the formatter</li>
 * <li>{@link org.eclipse.xtext.formatting2.AbstractFormatter2} Extend the AbstractFormatter2 to implement a formatter</li>
 * <li>{@link org.eclipse.xtext.formatting2.FormatterRequest} The FormatterRequest is a per-execution scoped configuration for the formatter.  
 *                         Per-language configuration is handled by the injector
 *                         or {@link org.eclipse.xtext.formatting2.AbstractFormatter2}.</li>
 * </ul>
 * 
 * @author Moritz Eysholdt - Initial contribution and API
 * @since 2.8
 */
package org.eclipse.xtext.formatting2;

