/*
 * package fr.elias.morecreeps.client.render.layers;
 * @SideOnly(Side.CLIENT)
 * public class LayerHeldItemArmyGuy implements LayerRenderer
 * {
 * private final RenderLiving field_177206_a;
 * public LayerHeldItemArmyGuy(RenderLiving p_i46115_1_)
 * {
 * this.field_177206_a = p_i46115_1_;
 * }
 * public void doRenderLayer(EntityLivingBase p_177141_1_, float p_177141_2_, float p_177141_3_, float p_177141_4_,
 * float p_177141_5_, float p_177141_6_, float p_177141_7_, float p_177141_8_)
 * {
 * ItemStack itemstack = p_177141_1_.getHeldItem();
 * if (itemstack != null)
 * {
 * GlStateManager.pushMatrix();
 * if (this.field_177206_a.getMainModel().isChild)
 * {
 * float f7 = 0.5F;
 * GlStateManager.translate(0.0F, 0.625F, 0.0F);
 * GlStateManager.rotate(-20.0F, -1.0F, 0.0F, 0.0F);
 * GlStateManager.scale(f7, f7, f7);
 * }
 * ((CREEPSModelArmyGuy)this.field_177206_a.getMainModel()).postRenderArm(0.0625F);
 * GlStateManager.translate(-0.0625F, 0.4375F, 0.0625F);
 * if (p_177141_1_ instanceof EntityPlayer && ((EntityPlayer)p_177141_1_).fishEntity != null)
 * {
 * itemstack = new ItemStack(Items.fishing_rod, 0);
 * }
 * Item item = itemstack.getItem();
 * Minecraft minecraft = Minecraft.getMinecraft();
 * if (item instanceof ItemBlock && Block.getBlockFromItem(item).getRenderType() == 2)
 * {
 * GlStateManager.translate(0.0F, 0.1875F, -0.3125F);
 * GlStateManager.rotate(20.0F, 1.0F, 0.0F, 0.0F);
 * GlStateManager.rotate(45.0F, 0.0F, 1.0F, 0.0F);
 * float f8 = 0.375F;
 * GlStateManager.scale(-f8, -f8, f8);
 * }
 * minecraft.getItemRenderer().renderItem(p_177141_1_, itemstack, ItemCameraTransforms.TransformType.THIRD_PERSON);
 * GlStateManager.popMatrix();
 * }
 * }
 * public boolean shouldCombineTextures()
 * {
 * return false;
 * }
 * }
 */
