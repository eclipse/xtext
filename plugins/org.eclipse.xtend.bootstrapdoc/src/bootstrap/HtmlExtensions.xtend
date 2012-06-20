package bootstrap

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
import org.eclipse.xtext.xdoc.xdoc.XdocPackage$Literals

import static bootstrap.HtmlExtensions.*
import com.google.inject.Inject

class ArtificialIds extends AdapterImpl {
	public Map<Identifiable, String> artificialHrefs = newHashMap() 	
}

class HtmlExtensions {
	
	@Inject extension CodeRefs
	
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
	
	def private artificialHrefs(Identifiable id) {
		val adapters = id.eResource.resourceSet.eAdapters
		val adapter = adapters.filter(typeof(ArtificialIds)).head 
						?: (new ArtificialIds => [
							adapters.add(it)
						])
		return adapter.artificialHrefs
	}
	
	
	def dispatch CharSequence toHtml(TextOrMarkup it) 
		'''«IF isParagraph»
			<p>
				«contents.toHtml»
			</p>
		«ELSE»«contents.toHtml.toString.trim»«ENDIF»'''
	
	def private isParagraph(TextOrMarkup it) {
		switch eContainingFeature {
			case contents.size==1 
			&& (contents.head instanceof CodeBlock 
				|| contents.head instanceof OrderedList
				|| contents.head instanceof UnorderedList): false
			case XdocPackage$Literals::ABSTRACT_SECTION__CONTENTS : true
			default : false
		}
	}

	def dispatch CharSequence toHtml(List<EObject> it) {
		map[toHtml].join
	}

	def dispatch toHtml(TextPart it) '''«text.quote»'''
	
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
	
	def dispatch toHtml(ImageRef it) '''
		<div class="thumbnail">
			<img src="«path»" alt="«caption»">
		</div>
	'''
	
	def dispatch toHtml(Todo it) {
		println("TODO: " + text)
		return ""
	}
	
	def dispatch CharSequence toHtml(CodeRef it) {
		try {
		val sourceCodeURI = element?.sourceCodeURI
		val javaDocURI = element?.javaDocURI
		'''
		«IF javaDocURI != null
			»<a href="«javaDocURI»">»«
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
		ENDIF»
	'''
	} catch (Exception e) {
		e.printStackTrace
	}
	}
	
	def dispatch toHtml(Code it) {
		contents.quote
	}
	
	def dispatch toHtml(CodeBlock it) {
		val code = contents.toHtml.toString
		if (code.contains('\n') && !code.contains('\r')) {
			'''<pre class="prettyprint lang-«language?.name?.toLowerCase?:'xtend'» linenums">«markCodeBegin»
			«code.trimCode»«markCodeEnd»</pre>'''
		} else {
			'''<code class="prettyprint lang-«language?.name?.toLowerCase?:'xtend'»">«code.trimCode»</code>'''
		}
	}
	
	def dispatch toHtml(Link it) '''<a href="«url»">«text»</a>'''

	def dispatch toHtml(Table it) '''
		<table class="table table-bordered table-condensed">
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