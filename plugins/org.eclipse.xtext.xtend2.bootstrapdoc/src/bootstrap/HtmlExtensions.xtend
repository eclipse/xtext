package bootstrap

import java.util.List
import java.util.Map
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.xdoc.xdoc.Anchor
import org.eclipse.xtext.xdoc.xdoc.Code
import org.eclipse.xtext.xdoc.xdoc.CodeBlock
import org.eclipse.xtext.xdoc.xdoc.CodeRef
import org.eclipse.xtext.xdoc.xdoc.Emphasize
import org.eclipse.xtext.xdoc.xdoc.Identifiable
import org.eclipse.xtext.xdoc.xdoc.Item
import org.eclipse.xtext.xdoc.xdoc.Link
import org.eclipse.xtext.xdoc.xdoc.OrderedList
import org.eclipse.xtext.xdoc.xdoc.Ref
import org.eclipse.xtext.xdoc.xdoc.Table
import org.eclipse.xtext.xdoc.xdoc.TableRow
import org.eclipse.xtext.xdoc.xdoc.TextOrMarkup
import org.eclipse.xtext.xdoc.xdoc.TextPart
import org.eclipse.xtext.xdoc.xdoc.Todo
import org.eclipse.xtext.xdoc.xdoc.UnorderedList
import org.eclipse.xtext.xdoc.xdoc.TableData

class HtmlExtensions {
	
	Map<Identifiable, String> artificialHrefs = newHashMap()

	def href(Identifiable it) {
		if(name != null) { 
			name 
		} else if(artificialHrefs.containsKey(it)) {
			artificialHrefs.get(it)
		} else {
			val newHref = it.eClass.name + '_' + artificialHrefs.size()
			artificialHrefs.put(it, newHref)
			newHref
		}  
	}
	
	
	def dispatch CharSequence toHtml(TextOrMarkup it) {
		contents.toHtml
	} 
	
	def dispatch toHtml(List<EObject> it) {
		map[toHtml].join
	}
	
	def dispatch toHtml(TextPart it) {
		text.quote
	}
	
	def dispatch toHtml(Emphasize it) '''<strong>«contents.toHtml»</strong>'''

	def dispatch toHtml(Anchor it) '''
		<a name="«name.quote»"/>	
	'''
	
	def dispatch toHtml(Ref it) '''<a href="#«ref.href»">«contents.toHtml»</a>'''
	
	def dispatch toHtml(OrderedList it) '''
		<ol>
			«FOR item:items»
				«item.toHtml»
			«ENDFOR»
		</ol>
	'''
	
	def dispatch toHtml(Item it) '''
		<li>«contents.toHtml»</li>
	'''
	
	def dispatch toHtml(UnorderedList it) '''
		<ul>
			«FOR item:items»
				«item.toHtml»
			«ENDFOR»
		</ul>
	'''
	
	def dispatch toHtml(Todo it) {
		println("TODO: " + text)
		""
	}
	
	def dispatch toHtml(CodeRef it) {
		println("TODO CodeRef to: " + element.identifier)
		if(altText!=null) 
			altText.toHtml
		else 
			'<code class="prettyprint lang-java">' + element.identifier + '</code>'
	}
	
	def dispatch toHtml(Code it) {
		contents.quote
	}
	
	def dispatch toHtml(CodeBlock it) {
		internalToHtml(false)
	}
	
	def dispatch toHtml(Link it) '''<a href="«url»">«text»</a>'''

	def dispatch toHtml(Table it) '''
		<table class="bordered-table zebra-striped">
		«FOR row:rows»
			«row.toHtml»
		«ENDFOR»
		</table>
	'''
	
	def dispatch toHtml(TableRow it) '''
		<tr>«data.toHtml»</tr>
	'''
	
	def dispatch toHtml(TableData it) '''
		<td>«contents.toHtml»</td>
	'''
	
	def dispatch toHtml(EObject it) {
		println("Missing toHtml for " + eClass.name)
		""
	}
	
	def markCodeBegin() {
		'###xdoc code begin###'
	}	
	def markCodeEnd() {
		'###xdoc code end###'
	}	
	
	def protected internalToHtml(CodeBlock it, boolean isParagraph) {
		val code = contents.toHtml.toString
		val languageName = if (language?.name==null) "xtend" else language.name
		if(code.contains('\n') || code.contains('\r')) '''
			«IF isParagraph»</p>«ENDIF»<pre class="prettyprint lang-«languageName.toLowerCase»">«markCodeBegin»
			«code.trimCode»«markCodeEnd»</pre>«IF isParagraph»<p>«ENDIF»
		''' else '''<code class="prettyprint lang-«languageName.toLowerCase»">«code.trimCode»</code>'''
	}
	
	def protected trimCode(String it) {
		var start = 0
		while(start < length()-1 && (substring(start, 1) == ' ' || substring(start,1)=='\t'))
			start = start + 1;
		if(substring(start,1) =='\n')
			start = start + 1;
		var end = length()-1
		while(end >0 && Character::isWhitespace(charAt(end)))
			end = end - 1
		substring(start, end+1)
	}
	
	def protected quote(CharSequence it) {
		toString.replace('<', '&lt;').replace('>', '&gt;')
			.replace('«', '&laquo;').replace('»', '&raquo;')
			.replace('\\[', '[').replace('\\]',']')
			.replace("'", '&apos;').replace('´','&apos;').replace('`','&apos;')
	}

	def toHtmlParagraph(List<? extends EObject> it) '''
		<p>
		«internalToHtmlParagraph»
		</p>
	'''
	
	def protected internalToHtmlParagraph(Object it) {
		switch(it) {
			TextOrMarkup:	it.contents.internalToHtmlParagraph
			List<EObject>:	it.map[internalToHtmlParagraph].join
			TextPart: {
							val paragraphs = it.text.quote.split('^\\s*$')
							paragraphs.filter([!isEmpty]).join('''
								</p>
								<p>
							''')
			}
			CodeBlock:		internalToHtml(true)
			default: 		toHtml
		} 
	}
	
}