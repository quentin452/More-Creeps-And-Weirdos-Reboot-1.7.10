package fr.elias.morecreeps.client.particles;

import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class CREEPSFxAtoms extends EntityFX {

    public CREEPSFxAtoms(World world, double d, double d1, double d2, Item item, float f) {
        super(world, d, d1, d2, 0.0D, 0.0D, 0.0D);
        // Below was added in 1.8, may be unneeded
        // this.particleIcon = Minecraft.getMinecraft().getRenderItem().getItemModelMesher().getParticleIcon(item);
        setSize(0.4F, 0.4F);
        particleRed = 1.0F;
        particleBlue = 1.0F;
        particleGreen = 1.0F;
        particleGravity = 0.33F;
        particleScale *= f;
    }

    public int getFXLayer() {
        return 2;
    }

    /**
     * Returns true if other Entities should be prevented from moving through this Entity.
     */
    public boolean canBeCollidedWith() {
        return false;
    }

    public void func_180434_a(Tessellator p_180434_1_, Entity p_180434_2_, float p_180434_3_, float p_180434_4_,
        float p_180434_5_, float p_180434_6_, float p_180434_7_, float p_180434_8_) {
        float f6 = (float) this.particleTextureIndexX / 16.0F;
        float f7 = f6 + 0.01560938F;
        float f8 = (float) this.particleTextureIndexY / 16.0F;
        float f9 = f8 + 0.01560938F;
        float f10 = 0.1F * this.particleScale;
        // TODO Don't know what the below is supposed to do, need to be fixed
        // super.func_180434_a(p_180434_9_, p_180434_2_, p_180434_3_, p_180434_4_, p_180434_5_, p_180434_6_,
        // p_180434_7_, p_180434_8_);

        if (this.particleIcon != null) {
            f6 = this.particleIcon.getMinU();
            f7 = this.particleIcon.getMaxU();
            f8 = this.particleIcon.getMinV();
            f9 = this.particleIcon.getMaxV();
        }

        float f11 = (float) (this.prevPosX + (this.posX - this.prevPosX) * (double) p_180434_3_ - interpPosX);
        float f12 = (float) (this.prevPosY + (this.posY - this.prevPosY) * (double) p_180434_3_ - interpPosY);
        float f13 = (float) (this.prevPosZ + (this.posZ - this.prevPosZ) * (double) p_180434_3_ - interpPosZ);
        p_180434_1_.setColorRGBA_F(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha);
        p_180434_1_.addVertexWithUV(
            (double) (f11 - p_180434_4_ * f10 - p_180434_7_ * f10),
            (double) (f12 - p_180434_5_ * f10),
            (double) (f13 - p_180434_6_ * f10 - p_180434_8_ * f10),
            (double) f7,
            (double) f9);
        p_180434_1_.addVertexWithUV(
            (double) (f11 - p_180434_4_ * f10 + p_180434_7_ * f10),
            (double) (f12 + p_180434_5_ * f10),
            (double) (f13 - p_180434_6_ * f10 + p_180434_8_ * f10),
            (double) f7,
            (double) f8);
        p_180434_1_.addVertexWithUV(
            (double) (f11 + p_180434_4_ * f10 + p_180434_7_ * f10),
            (double) (f12 + p_180434_5_ * f10),
            (double) (f13 + p_180434_6_ * f10 + p_180434_8_ * f10),
            (double) f6,
            (double) f8);
        p_180434_1_.addVertexWithUV(
            (double) (f11 + p_180434_4_ * f10 - p_180434_7_ * f10),
            (double) (f12 - p_180434_5_ * f10),
            (double) (f13 + p_180434_6_ * f10 - p_180434_8_ * f10),
            (double) f6,
            (double) f9);
    }
}
