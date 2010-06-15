<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                version="1.0"
                xmlns="http://www.w3.org/TR/xhtml1/transitional"
                xmlns:fo="http://www.w3.org/1999/XSL/Format"
                exclude-result-prefixes="#default">

<!--###################################################
                   Custom Title Page
    ################################################### --> 
<!-- Define the margins, background image for the cover page -->
    <xsl:template name="user.pagemasters">
        <fo:page-sequence-master master-name="coversequence"> 
            <fo:repeatable-page-master-alternatives>
                <fo:conditional-page-master-reference master-reference="my.titlepage" page-position="first"/>
                <fo:conditional-page-master-reference master-reference="my.titlepage" odd-or-even="odd"/> 
                <fo:conditional-page-master-reference master-reference="my.titlepage" odd-or-even="even"/>
                <fo:conditional-page-master-reference master-reference="blank" blank-or-not-blank="blank"/> 
            </fo:repeatable-page-master-alternatives>
        </fo:page-sequence-master>
        <fo:simple-page-master master-name="my.titlepage" 
		                       page-width="{$page.width}"  
		                       page-height="{$page.height}"
		                       margin-top="20mm"
		                       margin-bottom="20mm"
		                       margin-left="{$page.margin.inner}"
		                       margin-right="{$page.margin.outer}">
			<fo:region-body margin-bottom="20"  
		                    margin-top="20"
		                    column-count="{$column.count.titlepage}">
			</fo:region-body>
			<fo:region-before region-name="xsl-region-before-even"  
		                      extent="0"
		                      display-align="before"/>
			<fo:region-after region-name="xsl-region-after-even"  
		                     extent="0"
		                     display-align="after"/>
		</fo:simple-page-master>
    </xsl:template>
    
    <xsl:template name="select.user.pagemaster">
        <xsl:param name="element"/>
        <xsl:param name="pageclass"/> 
        <xsl:param name="default-pagemaster"/>
        <xsl:choose>
            <xsl:when test="$element = 'book' and $pageclass = 'titlepage'"> 
                <xsl:value-of select="'coversequence'"/>
            </xsl:when>
            <xsl:otherwise>
                <xsl:value-of select="$default-pagemaster"/> 
            </xsl:otherwise>
        </xsl:choose>
    </xsl:template>

    <xsl:template name="book.titlepage.recto">
        <fo:block>
            <fo:table table-layout="fixed" width="175mm">
                <fo:table-column column-width="175mm"/>
                <fo:table-body>
                    <fo:table-row height="20pc">
                        <fo:table-cell text-align="center">
                            <fo:block> </fo:block>
                        </fo:table-cell>
                    </fo:table-row>
                    <fo:table-row>
                        <fo:table-cell text-align="center">
                            <fo:block>
                                <fo:external-graphic src="file:images/logo/Xtext-logo-dark-1600.png" content-width="10cm"/>
                                <!-- <fo:external-graphic src="file:images/logo/Xtext-logo-dark.pdf" content-width="5cm"/>-->
                            </fo:block>
                        </fo:table-cell>
                    </fo:table-row>
                    <fo:table-row>
                        <fo:table-cell text-align="center">
                            <fo:block font-family="Helvetica" font-size="24pt" padding-before="25mm">
                                <xsl:value-of select="title"/> 
                            </fo:block>
                            <fo:block font-family="Helvetica" font-size="12pt">
                                <!-- <xsl:value-of select="bookinfo/releaseinfo"/> -->
                                <xsl:text>Heiko Behrens, Michael Clay, Sven Efftinge, Moritz Eysholdt, Peter Friese, Jan Köhnlein, Knut Wannheden, Sebastian Zarnekow and contributors</xsl:text>
                            </fo:block>
                            <fo:block font-family="Helvetica" font-size="12pt" padding="10mm">
                                <xsl:text>Copyright 2008 - 2010</xsl:text>
                            </fo:block>
                        </fo:table-cell>
                    </fo:table-row>
                </fo:table-body>
            </fo:table>
        </fo:block>
    </xsl:template>

    <!-- Prevent blank pages in output -->    
    <xsl:template name="book.titlepage.before.verso">
    </xsl:template>
    
    <xsl:template name="book.titlepage.verso">
    </xsl:template>
    <xsl:template name="book.titlepage.separator">
    </xsl:template>
    
</xsl:stylesheet>