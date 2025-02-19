package fr.elias.morecreeps.client.render;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import fr.elias.morecreeps.common.entity.CREEPSEntitySnowDevil;

public class CREEPSRenderSnowDevil extends RenderLiving {

    protected ModelBiped modelBipedMain;

    public CREEPSRenderSnowDevil(ModelBase modelbase, ModelBase modelbase1, float f) {
        super(modelbase, f);
    }

    protected void fattenup(CREEPSEntitySnowDevil creepsentitysnowdevil, float f) {
        GL11.glScalef(
            creepsentitysnowdevil.modelsize,
            creepsentitysnowdevil.modelsize,
            creepsentitysnowdevil.modelsize);
    }

    /**
     * Allows the render to do any OpenGL state modifications necessary before the model is rendered. Args:
     * entityLiving, partialTickTime
     */
    protected void preRenderCallback(EntityLivingBase entityliving, float f) {
        fattenup((CREEPSEntitySnowDevil) entityliving, f);
    }

    public void doRenderLiving(EntityLiving entityliving, double d, double d1, double d2, float f, float f1) {
        super.doRender(entityliving, d, d1, d2, f, f1);
        float f2 = 1.6F;
        float f3 = 0.01666667F * f2;
        float f4 = entityliving.getDistanceToEntity(renderManager.livingPlayer);
        String s = ((CREEPSEntitySnowDevil) entityliving).name;

        if (((CREEPSEntitySnowDevil) entityliving).getHealth()
            < ((CREEPSEntitySnowDevil) entityliving).getMaxHealth() / 2 && s.length() > 0) {
            s = (new StringBuilder()).append(s)
                .append(" \2474 * WOUNDED *")
                .toString();
        }

        if (f4 < 32F && s.length() > 0) {
            FontRenderer fontrenderer = getFontRendererFromRenderManager();
            GL11.glPushMatrix();
            GL11.glTranslatef((float) d + 0.0F, (float) d1 + 2.1F, (float) d2);
            GL11.glNormal3f(0.0F, 1.0F, 0.0F);
            GL11.glRotatef(-renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(renderManager.playerViewX, 1.0F, 0.0F, 0.0F);
            GL11.glScalef(-f3, -f3, f3);
            GL11.glDisable(GL11.GL_LIGHTING);
            GL11.glDepthMask(false);
            GL11.glDisable(GL11.GL_DEPTH_TEST);
            GL11.glEnable(GL11.GL_BLEND);
            GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
            Tessellator tessellator = Tessellator.instance;
            float f5 = (1.0F - ((CREEPSEntitySnowDevil) entityliving).modelsize) * 55F;
            int i = 0 + (int) f5;
            GL11.glDisable(GL11.GL_TEXTURE_2D);
            tessellator.startDrawingQuads();
            int j = fontrenderer.getStringWidth(s) / 2;
            tessellator.setColorRGBA_F(0.0F, 0.0F, 0.0F, 0.25F);
            tessellator.addVertex(-j - 1, -1 + i, 0.0D);
            tessellator.addVertex(-j - 1, 8 + i, 0.0D);
            tessellator.addVertex(j + 1, 8 + i, 0.0D);
            tessellator.addVertex(j + 1, -1 + i, 0.0D);
            tessellator.draw();
            GL11.glEnable(GL11.GL_TEXTURE_2D);
            fontrenderer.drawString(
                (new StringBuilder()).append("\2476")
                    .append(s)
                    .toString(),
                -fontrenderer.getStringWidth(s) / 2,
                i,
                0x20ffffff);
            GL11.glEnable(GL11.GL_DEPTH_TEST);
            GL11.glDepthMask(true);
            fontrenderer.drawString(
                (new StringBuilder()).append("\2476")
                    .append(s)
                    .toString(),
                -fontrenderer.getStringWidth(s) / 2,
                i,
                -1);
            GL11.glEnable(GL11.GL_LIGHTING);
            GL11.glDisable(GL11.GL_BLEND);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glPopMatrix();
        }
    }

    public void doRender(Entity entity, double d, double d1, double d2, float f, float f1) {
        doRenderLiving((EntityLiving) entity, d, d1, d2, f, f1);
    }

    protected ResourceLocation getEntityTexture(CREEPSEntitySnowDevil entity) {
        return new ResourceLocation(entity.texture);
    }

    protected ResourceLocation getEntityTexture(Entity entity) {

        return getEntityTexture((CREEPSEntitySnowDevil) entity);
    }
}
