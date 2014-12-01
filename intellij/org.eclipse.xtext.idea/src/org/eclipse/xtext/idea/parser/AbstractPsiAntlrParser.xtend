package org.eclipse.xtext.idea.parser

import com.intellij.lang.PsiBuilder
import com.intellij.openapi.progress.ProcessCanceledException
import com.intellij.psi.tree.IElementType
import java.lang.reflect.InvocationTargetException
import java.util.List
import java.util.Map
import org.antlr.runtime.BitSet
import org.antlr.runtime.IntStream
import org.antlr.runtime.MismatchedTokenException
import org.antlr.runtime.MissingTokenException
import org.antlr.runtime.Parser
import org.antlr.runtime.RecognitionException
import org.antlr.runtime.RecognizerSharedState
import org.antlr.runtime.Token
import org.antlr.runtime.TokenStream
import org.antlr.runtime.UnwantedTokenException
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.parser.antlr.ISyntaxErrorMessageProvider

abstract class AbstractPsiAntlrParser extends Parser {
	
	List<String> readableTokenNames
	
	@Accessors
	extension ISyntaxErrorMessageProvider

	val PsiBuilder psiBuilder
	
	val TokenTypeProvider tokenTypeProvider

	val leafMarkers = <PsiBuilder.Marker>newLinkedList
	
	val compositeMarkers = <CompositeMarker>newLinkedList
	
	String currentError

	new(PsiBuilder builder, TokenStream input, TokenTypeProvider tokenTypeProvider) {
		this(builder, input, tokenTypeProvider, new RecognizerSharedState)
	}

	new(PsiBuilder builder, TokenStream input, TokenTypeProvider tokenTypeProvider, RecognizerSharedState state) {
		super(input, state)
		this.psiBuilder = builder
		this.tokenTypeProvider = tokenTypeProvider
	}

	new(TokenStream input, RecognizerSharedState state) {
		super(input, state)
		psiBuilder = null
		tokenTypeProvider = null
		throw new UnsupportedOperationException
	}
	
	protected def String getFirstRuleName()
	
	def parse() throws RecognitionException {
		parse(firstRuleName)
	}
	
	def void parse(String entryRuleName) throws RecognitionException {
		val antlrEntryRuleName = entryRuleName.normalizeEntryRuleName
		try {
			antlrEntryRuleName.invokeEntryRule
			appendAllTokens
		} catch (InvocationTargetException ite) {
			switch targetException : ite.targetException {
				RecognitionException: {
					appendAllTokens 
					throw targetException
				}
				ProcessCanceledException:
					throw targetException
				default:
					throw ite
			}
		}
	}
	
	protected def invokeEntryRule(String antlrEntryRuleName) {
		val method = class.getMethod(antlrEntryRuleName)
		method.accessible = true
		method.invoke(this)
	}
	
	protected def appendAllTokens() {
		while(!psiBuilder.eof) {
			input.consume
		}
		if (currentError != null) {
			psiBuilder.error(currentError)
			currentError = null
		}
	}
	
	protected def String normalizeEntryRuleName(String entryRuleName) {
		if (entryRuleName.startsWith("entryRule")) {
			return entryRuleName
		} 
		if (entryRuleName.startsWith("rule")) {
			return '''entry«entryRuleName.toFirstUpper»'''
		}
		'''entryRule«entryRuleName»'''
	}
	

	override getSourceName() {
		input.sourceName
	}

	protected def void markComposite(IElementType elementType) {
		compositeMarkers.push(new CompositeMarker(psiBuilder.mark, currentLookAhead, elementType))
	}

	protected def void markLeaf() {
		val marker = psiBuilder.mark
		leafMarkers.push(marker)
	}
	
	protected def void precedeComposite(IElementType elementType) {
		val compositeMarker = compositeMarkers.pop
		compositeMarkers.push(compositeMarker.precede(elementType))
		compositeMarkers.push(compositeMarker)
	}
	
	protected def drop() {
		leafMarkers.pop.drop
	}

	protected def void doneComposite() {
		compositeMarkers.pop.done()
	}

	protected def void doneLeaf(Token matchedToken, IElementType elementType) {
		if (matchedToken == null) {
			drop
			return
		}
		val marker = leafMarkers.pop
		val endTokenIndex = psiBuilder.rawTokenIndex
		marker.rollbackTo
		val startTokenIndex = psiBuilder.rawTokenIndex
		val n = endTokenIndex - startTokenIndex - 1
		for (var i = 0; i < n; i++) {
			psiBuilder.advanceLexer
		}
		psiBuilder.remapCurrentToken(elementType)
		if (currentError != null) {
			val errorMarker = psiBuilder.mark
			psiBuilder.advanceLexer
			errorMarker.error(currentError)
			currentError = null
		} else {
			psiBuilder.advanceLexer
		}
	}
	
	protected def getCurrentLookAhead() {
		if (input instanceof PsiXtextTokenStream) {
			return input.currentLookAhead
		} 
		throw new IllegalStateException('the input should be an instance of '+ PsiXtextTokenStream.simpleName)
	}
	
	override protected Object recoverFromMismatchedToken(IntStream input, int ttype, BitSet follow) {
		if (mismatchIsUnwantedToken(input, ttype)) {
			val marked = !leafMarkers.empty 
			if (marked) {
				drop
			}
		
			val unwantedTokenException = new UnwantedTokenException(ttype, input)
			
			val startTokenIndex = psiBuilder.rawTokenIndex
			val marker = psiBuilder.mark
			
			beginResync()
			input.consume()
			endResync()
			reportError(unwantedTokenException)
			
			if (currentError != null) {
				val endTokenIndex = psiBuilder.rawTokenIndex
				marker.rollbackTo
				val n = endTokenIndex - startTokenIndex - 1
				for (var i = 0; i < n; i++) {
					psiBuilder.advanceLexer
				}
				val errorMarker = psiBuilder.mark
				psiBuilder.advanceLexer
				errorMarker.error(getErrorMessage(unwantedTokenException, readableTokenNames))
				currentError = null
			}
		
			if (marked) {
				markLeaf
			}
			var Object matchedSymbol = getCurrentInputSymbol(input)
			input.consume()
			return matchedSymbol
		}
		if (mismatchIsMissingToken(input, follow)) {
			var Object inserted = getMissingSymbol(input, null, ttype, follow)
			reportError(new MissingTokenException(ttype, input, inserted))
			return null
		}
		throw new MismatchedTokenException(ttype, input)
	}
	
	override recover(IntStream input, RecognitionException re) {
		if (currentError == null) {
			currentError = getErrorMessage(re, readableTokenNames)
		}
		for (leafMarker : leafMarkers) {
			leafMarker.drop
		}
		leafMarkers.clear
		super.recover(input, re)
	}
	
	override reportError(RecognitionException e) {
		if ( state.errorRecovery ) {
			return;
		}
		state.syntaxErrors++; // don't count spurious
		state.errorRecovery = true;
		if (currentError == null)
			currentError = getErrorMessage(e, readableTokenNames)
	}

	override emitErrorMessage(String msg) {
		throw new UnsupportedOperationException
	}
	
	def void setTokenTypeMap(Map<Integer, String> tokenTypeMap) {
		var tokenNames = tokenNames
		readableTokenNames = newArrayOfSize(tokenNames.length)
		for (var i = 0; i < tokenNames.length; i++) {
			if (tokenTypeMap.containsKey(i)) {
				readableTokenNames.set(i, tokenTypeMap.get(i))
			} else {
				readableTokenNames.set(i, tokenNames.get(i))
			}
		}
	}
	
}