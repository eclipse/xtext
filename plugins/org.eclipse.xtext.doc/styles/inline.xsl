<?xml version='1.0'?> 
<xsl:stylesheet 
    xmlns:fo="http://www.w3.org/1999/XSL/Format"
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
    version="1.0">

  <xsl:template match="comment|remark">
    <xsl:if test="$show.comments != 0">
      <fo:block font-style="italic">
        <fo:inline background-color="#FFEE30">
          <xsl:call-template name="inline.charseq"/>
        </fo:inline>
      </fo:block>
    </xsl:if>
  </xsl:template>

</xsl:stylesheet>