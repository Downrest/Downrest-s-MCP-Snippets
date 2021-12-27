/// EFFECTS DRAW STRING LIBRARY - AUTHOR: DOWNREST ///
// ! PUT THIS ON FONTRENDERER.JAVA (OR ANY OTHER CLASS IF YOU WANT) ! //
    
    /**
     * Draws the specified string with a configurable shaking effect
     * @author Downrest
     * 
     */
    public int drawShakingString(String text, float textSize, int x, int y, int color, boolean dropShadow, int shakeIntensity)
    {
        return this.drawShakingString(text, textSize, (float)x, (float)y, color, dropShadow, (float)shakeIntensity);
    }
    
    /**
     * Draws the specified string with a configurable shaking effect
     * @author Downrest
     * 
     */
    public int drawShakingString(String text, float textSize, float x, float y, int color, boolean dropShadow, float shakeIntensity)
    {
        GlStateManager.enableAlpha();
        this.resetStyles();
        int i;

        if (dropShadow)
        {
        	GlStateManager.pushMatrix();
            float e = textSize - MathHelper.abs(MathHelper.sin((float)(Minecraft.getSystemTime() % shakeIntensity)/ 1000.0F * (float)Math.PI * 2.0F) * 0.1F);
            GlStateManager.scale(e, e, e);
            i = this.renderString(text, x + 1.0F, y + 1.0F, color, true);
            i = Math.max(i, this.renderString(text, x, y, color, false));
            GlStateManager.popMatrix();           
        }
        else
        {
        	GlStateManager.pushMatrix();
            float e = textSize - MathHelper.abs(MathHelper.sin((float)(Minecraft.getSystemTime() % shakeIntensity)/ 1000.0F * (float)Math.PI * 2.0F) * 0.1F);
            GlStateManager.scale(e, e, e);
            i = this.renderString(text, x, y, color, false);
            GlStateManager.popMatrix();            
        }

        return i;
    }

    /**
     * Draws the specified string with a configurable rainbow effect
     * @author Downrest
     * 
     */
    public int drawRainbowString(String text, float textSize, int x, int y, boolean dropShadow, int rainbowSpeed)
    {
        return this.drawRainbowString(text, textSize, (float)x, (float)y, dropShadow, (float)rainbowSpeed);
    }
    
    /**
     * Draws the specified string with a configurable rainbow effect
     * @author Downrest
     * 
     */
    public int drawRainbowString(String text, float textSize, float x, float y, boolean dropShadow, float rainbowSpeed)
    {
        GlStateManager.enableAlpha();
        this.resetStyles();
        int i;

        if (dropShadow)
        {
            i = this.renderString(text, x + 1.0F, y + 1.0F, Color.HSBtoRGB((float)(System.currentTimeMillis() % 1000L) / 1000.0F, rainbowSpeed, rainbowSpeed), true);
            i = Math.max(i, this.renderString(text, x, y, Color.HSBtoRGB((float)(System.currentTimeMillis() % 1000L) / 1000.0F, rainbowSpeed, rainbowSpeed), false));       
        }
        else
        {
            i = this.renderString(text, x, y, Color.HSBtoRGB((float)(System.currentTimeMillis() % 1000L) / 1000.0F, rainbowSpeed, rainbowSpeed), false);          
        }

        return i;
    }

/// EFFECTS DRAW STRING LIBRARY - AUTHOR: DOWNREST ///
