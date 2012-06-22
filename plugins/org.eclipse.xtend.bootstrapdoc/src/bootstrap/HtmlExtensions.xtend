package bootstrap

import com.google.inject.Inject
import java.util.List
import java.util.Map
import org.eclipse.emf.common.notify.impl.AdapterImpl
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.xdoc.xdoc.Anchor
import org.eclipse.xtext.xdoc.xdoc.ChapterRef
import org.eclipse.xtext.xdoc.xdoc.Code
import org.eclipse.xtext.xdoc.xdoc.CodeBlock
import org.eclipse.xtext.xdoc.xdoc.CodeRef
import org.eclipse.xtext.xdoc.xdoc.Emphasize
import org.eclipse.xtext.xdoc.xdoc.Identifiable
import org.eclipse.xtext.xdoc.xdoc.ImageRef
import org.eclipse.xtext.xdoc.xdoc.Item
import org.eclipse.xtext.xdoc.xdoc.Link
import org.eclipse.xtext.xdoc.xdoc.OrderedList
import org.eclipse.xtext.xdoc.xdoc.Ref
import org.eclipse.xtext.xdoc.xdoc.Section2Ref
import org.eclipse.xtext.xdoc.xdoc.SectionRef
import org.eclipse.xtext.xdoc.xdoc.Table
import org.eclipse.xtext.xdoc.xdoc.TableData
import org.eclipse.xtext.xdoc.xdoc.TableRow
import org.eclipse.xtext.xdoc.xdoc.TextOrMarkup
import org.eclipse.xtext.xdoc.xdoc.TextPart
import org.eclipse.xtext.xdoc.xdoc.Todo
import org.eclipse.xtext.xdoc.xdoc.UnorderedList
import com.google.inject.Singleton

class ArtificialIds extends AdapterImpl {
	public Map<Identifiable, String> artificialHrefs = newHashMap() 	
}

@Singleton
class HtmlExtensions {
	
	@Inject extension CodeRefs
	@Inject extension ImageExtensions

	boolean inParagraph = false
	
	def href(Identifiable id) {
		val it = switch id {
			ChapterRef : id.chapter
			SectionRef : id.section
			Section2Ref : id.section2
			default : id
		}
		if(name != null) { 
			name 
		} else if(artificialHrefs.containsKey(it)) {
			artificialHrefs.get(it)
		} else {
			val newHref = '_'+artificialHrefs.size()
			artificialHrefs.put(it, newHref)
			newHref
		}  
	}
	
	def protected artificialHrefs(Identifiable id) {
		val adapters = id.eResource.resourceSet.eAdapters
		val adapter = adapters.filter(typeof(ArtificialIds)).head 
						?: (new ArtificialIds => [
							adapters.add(it)
						])
		return adapter.artificialHrefs
	}
	
	
	def protected dispatch CharSequence toHtml(TextOrMarkup it) {
		if(!inParagraph) {
			inParagraph = true
			val result = '''
				<p>
					«contents.toHtml.toString.trim»
				</p>
			'''
			inParagraph = false
			result
		} else contents.toHtml.toString.trim
		
	}
	
//	def protected isParagraph(TextOrMarkup it) {
//		switch eContainingFeature {
//			case contents.size==1 
//			&& (contents.head instanceof CodeBlock 
//				|| contents.head instanceof OrderedList
//				|| contents.head instanceof UnorderedList): false
//			case XdocPackage$Literals::ABSTRACT_SECTION__CONTENTS : true
//			default : false
//		}
//	}

	def toHtmlText(Object element) {
		this.inParagraph = true 
		toHtml(element)
	}

	def toHtmlParagraph(Object element) {
		this.inParagraph = false 
		toHtml(element)
	}

	def protected dispatch CharSequence toHtml(List<EObject> it) {
		map[toHtml].join
	}

	def protected dispatch CharSequence toHtml(TextPart it) '''«text.quote»'''
	
	def protected dispatch CharSequence toHtml(Emphasize it) '''<strong>«contents.toHtml»</strong>'''

	def protected dispatch CharSequence toHtml(Anchor it) '''
		<a name="«name.quote»"></a>
	'''
	
	def protected dispatch CharSequence toHtml(Ref it) '''<a href="#«ref.href»">«contents.toHtml»</a>'''
	
	def protected dispatch CharSequence toHtml(OrderedList it) { '''
			<ol>
				«FOR item:items»
					«item.toHtml»
				«ENDFOR»
			</ol>
		'''.insert
	}
	
	def protected dispatch CharSequence toHtml(Item it) '''
		<li>«contents.toHtml»</li>
	'''
	
	def protected dispatch CharSequence toHtml(UnorderedList it) { '''
			<ul>
				«FOR item:items»
					«item.toHtml»
				«ENDFOR»
			</ul>
		'''.insert
	}
	
	def protected dispatch CharSequence toHtml(ImageRef it) {
		val dimension = it.dimension
		val caption = it.caption?.trim
		'''
			<div class="thumbnail">
				<img src="«path»" alt="«caption»" «IF dimension!=null»width="«dimension.width»" height="«dimension.height»"«ENDIF»>
			</div>
		'''
	}
	
	def protected dispatch CharSequence toHtml(Todo it) {
		println("TODO: " + text)
		return ""
	}
	
	def protected dispatch CharSequence toHtml(CodeRef it) {
		val sourceCodeURI = element?.sourceCodeURI
		val javaDocURI = element?.javaDocURI
		'''
		«IF javaDocURI != null
			»<a href="«javaDocURI»">«
		ENDIF»«
		IF altText != null
			»«altText.toHtml»«
		ELSE
			»<abbr title="«element?.identifier»">«element?.simpleName?.trim»</abbr>«
		ENDIF»«
		IF javaDocURI != null 
			»</a>«
		ENDIF»«
		IF sourceCodeURI!=null
			» <a href="«sourceCodeURI»">(src)</a>«
		ENDIF»'''
	}
	
	def protected dispatch CharSequence toHtml(Code it) {
		contents.quote
	}
	
	def protected dispatch CharSequence toHtml(CodeBlock it) {
		val code = contents.toHtml.toString
		if (code.contains('\n') && !code.contains('\r')) {
			'''<pre class="prettyprint lang-«language?.name?.toLowerCase?:'xtend'» linenums">«markCodeBegin»
			«code.trimCode»«markCodeEnd»</pre>'''.insert
		} else {
			'''<code class="prettyprint lang-«language?.name?.toLowerCase?:'xtend'»">«code.trimCode»</code>'''
		}
	}
	
	def protected dispatch CharSequence toHtml(Link it) '''<a href="«url»">«text»</a>'''

	def protected dispatch CharSequence toHtml(Table it) { '''
			<table class="table table-bordered table-condensed">
			«FOR row:rows»
				«row.toHtml»
			«ENDFOR»
			</table>
		'''.insert
	}
	
	def protected dispatch CharSequence toHtml(TableRow it) '''
		<tr>«data.toHtml»</tr>
	'''
	
	def protected dispatch CharSequence toHtml(TableData it) '''
		<td>«contents.toHtml»</td>
	'''
	
	def protected dispatch CharSequence toHtml(EObject it) {
		println("Missing toHtml for " + eClass.name)
		""
	}
	
	def markCodeBegin() {
		'###xdoc code begin###'
	}	
	def markCodeEnd() {
		'###xdoc code end###'
	}	
	
	def protected insert(CharSequence content) {
		if(inParagraph) '''
			</p>
			«content»
			<p>
		''' else content
	}
	
	def protected trimCode(String it) {
		if(nullOrEmpty) 
			return ''
		var start = 0
		while(start < length()-1 && (substring(start, start+1) == ' ' || substring(start,start+1) == '\t'))
			start = start + 1;
		if(substring(start,start+1) =='\n')
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
			.replace('´',"'").replace('`',"'")
	}

}