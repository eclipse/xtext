require(["assert", "xtext/xtext-test"], function(assert, xtext) {
	
	describe('Xtext', function() {
		describe('#createEditor()', function() {
			it('should return an editor context', function() {
				var editorContext = xtext.createEditor();
				assert.equal(0, editorContext.getCaretOffset());
			})
		})
	})

});