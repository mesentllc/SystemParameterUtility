<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output encoding="UTF-8" indent="yes" method="xml" />
    <xsl:template match="@*|node()">
        <xsl:element name="SystemParameters">
			<xsl:for-each select="SystemParameter">
                <xsl:element name="SystemParameter">
					<xsl:element name="Category">
						<xsl:value-of select="Category"/>
                    </xsl:element>
					<xsl:element name="SubCategory">
						<xsl:value-of select="SubCategory"/>
                    </xsl:element>
					<xsl:element name="Name">
						<xsl:value-of select="Name"/>
                    </xsl:element>
					<xsl:element name="Value">
						<xsl:value-of select="Value"/>
                    </xsl:element>
					<xsl:element name="Type">
						<xsl:value-of select="Type"/>
                    </xsl:element>
					<xsl:element name="Cache">
						<xsl:value-of select="Cache"/>
                    </xsl:element>
					<xsl:element name="Comment">
						<xsl:value-of select="Comment"/>
                    </xsl:element>
					<xsl:element name="LongValue">
						<xsl:value-of select="LongValue"/>
                    </xsl:element>
                </xsl:element>
            </xsl:for-each>
		</xsl:element>
	</xsl:template>
</xsl:stylesheet>