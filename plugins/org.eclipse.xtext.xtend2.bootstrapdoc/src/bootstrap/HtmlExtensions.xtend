package bootstrap

import org.eclipse.xtext.xdoc.xdoc.Anchor
import org.eclipse.xtext.xdoc.xdoc.Emphasize
import org.eclipse.xtext.xdoc.xdoc.Identifiable
import org.eclipse.xtext.xdoc.xdoc.Ref
import org.eclipse.xtext.xdoc.xdoc.TextOrMarkup
import org.eclipse.xtext.xdoc.xdoc.TextPart
import java.util.List
import org.eclipse.xtext.xdoc.xdoc.OrderedList
import org.eclipse.xtext.xdoc.xdoc.Item
import java.util.Map

class HtmlExtensions {
	
	def dispatch CharSequence toHtml(TextOrMarkup it) {
		contents.toHtml
	} 
	
	def dispatch toHtml(List<TextOrMarkup> it) {
		map[toHtml].join
	}
	
	def dispatch toHtml(TextPart it) {
		text
	}
	
	def dispatch toHtml(Emphasize it) '''
		<strong>«contents.toHtml»</strong>
	'''

	def dispatch toHtml(Anchor it) '''
		<a name="«name»"/>	
	'''
	
	def dispatch toHtml(Ref it) '''
		<a href="«ref.href»">«contents.toHtml»</a>
	'''
	
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
	
	
	/*Emphasize |
	Anchor |
	Ref |
	OrderedList |
	UnorderedList |
	CodeBlock |
	CodeRef |
	Link |
	ImageRef |
	Table | 
	Todo;*/
	
	Map<Identifiable, String> artificialHrefs = newHashMap()

	def href(Identifiable it) {
		if(name != null) { 
			name 
		} else if(artificialHrefs.containsKey(it)) {
			artificialHrefs.get(it)
		} else {
			val newHref = it.eClass.name + artificialHrefs.size()
			artificialHrefs.put(it, newHref)
			newHref
		}  
	}
}